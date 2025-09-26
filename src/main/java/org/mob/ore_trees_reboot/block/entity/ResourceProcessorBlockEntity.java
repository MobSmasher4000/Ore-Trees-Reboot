package org.mob.ore_trees_reboot.block.entity;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.Containers;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import org.mob.ore_trees_reboot.recipe.ModRecipes;
import org.mob.ore_trees_reboot.recipe.ResourceProcessorRecipe;
import org.mob.ore_trees_reboot.recipe.ResourceProcessorRecipeInput;
import org.mob.ore_trees_reboot.screen.custom.ResourceProcessorMenu;

import java.util.Optional;
import java.util.stream.IntStream;

public class ResourceProcessorBlockEntity extends BlockEntity implements MenuProvider {
    // 3 input slots + 9 output slots = 12 total
    // gui handler
    public final ItemStackHandler itemHandler = new ItemStackHandler(12) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if (!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    // --- Automation handler for mods ---
    private final ItemStackHandler automationHandler = new ItemStackHandler(12) {
        @Override
        public boolean isItemValid(int slot, ItemStack stack) {
            return slot >= 0 && slot <= 2; // input slots only
        }

        @Override
        public ItemStack extractItem(int slot, int amount, boolean simulate) {
            if (slot >= 3 && slot <= 11) return super.extractItem(slot, amount, simulate);
            return ItemStack.EMPTY;
        }
    };


    private static final int[] INPUT_SLOTS = {0, 1, 2}; // sequential input slots
    private static final int[] OUTPUT_SLOT = IntStream.rangeClosed(3, 11).toArray(); // output slots 3–11

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;
    private int activeInputSlot = 0; // tracks the currently processing input slot

    public ResourceProcessorBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.RESOURCE_PROCESSOR_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i) {
                    case 0 -> ResourceProcessorBlockEntity.this.progress;
                    case 1 -> ResourceProcessorBlockEntity.this.maxProgress;
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i) {
                    case 0 -> ResourceProcessorBlockEntity.this.progress = value;
                    case 1 -> ResourceProcessorBlockEntity.this.maxProgress = value;
                }
            }

            @Override
            public int getCount() {
                return 2;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.ore_trees_reboot.resource_processor");
    }

    @Nullable
    @Override
    public AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new ResourceProcessorMenu(i, inventory, this, this.data);
    }

    public void drops() {
        SimpleContainer inventory = new SimpleContainer(itemHandler.getSlots());
        for (int i = 0; i < itemHandler.getSlots(); i++) {
            inventory.setItem(i, itemHandler.getStackInSlot(i));
        }
        Containers.dropContents(this.level, this.worldPosition, inventory);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        pTag.put("inventory", itemHandler.serializeNBT(pRegistries));
        pTag.putInt("resource_processor.progress", progress);
        pTag.putInt("resource_processor.max_progress", maxProgress);
        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("resource_processor.progress");
        maxProgress = pTag.getInt("resource_processor.max_progress");
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        ItemStack activeStack = itemHandler.getStackInSlot(activeInputSlot);

        // If current active slot is empty, find next input slot
        if (activeStack.isEmpty()) {
            boolean foundInput = false;
            for (int slot : INPUT_SLOTS) {
                if (!itemHandler.getStackInSlot(slot).isEmpty()) {
                    activeInputSlot = slot;
                    foundInput = true;
                    break;
                }
            }
            if (!foundInput) {
                resetProgress();
                return; // no input, stop processing
            }
            activeStack = itemHandler.getStackInSlot(activeInputSlot);
        }

        // Process the active input slot if it has a valid recipe
        if (hasRecipe(activeInputSlot)) {
            increaseCraftingProgress();
            setChanged(level, blockPos, blockState);

            if (hasCraftingFinished()) {
                craftItem(activeInputSlot);
                resetProgress();
            }
        } else {
            resetProgress();
        }
    }

    private boolean hasRecipe(int inputSlot) {
        Optional<RecipeHolder<ResourceProcessorRecipe>> recipe = getCurrentRecipe(inputSlot);
        if (recipe.isEmpty()) return false;

        ItemStack output = recipe.get().value().output();
        return getNextAvailableOutputSlot(output) != -1;
    }

    private Optional<RecipeHolder<ResourceProcessorRecipe>> getCurrentRecipe(int inputSlot) {
        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.RESOURCE_PROCESSOR_TYPE.get(),
                        new ResourceProcessorRecipeInput(itemHandler.getStackInSlot(inputSlot)), level);
    }

    private void craftItem(int inputSlot) {
        Optional<RecipeHolder<ResourceProcessorRecipe>> recipe = getCurrentRecipe(inputSlot);
        if (recipe.isEmpty()) return;

        ItemStack output = recipe.get().value().output();
        int slot = getNextAvailableOutputSlot(output);
        if (slot == -1) return; // no available output slot

        itemHandler.extractItem(inputSlot, 1, false);

        ItemStack current = itemHandler.getStackInSlot(slot);
        if (current.isEmpty()) {
            itemHandler.setStackInSlot(slot, output.copy());
        } else {
            current.grow(output.getCount());
            itemHandler.setStackInSlot(slot, current);
        }
    }

    private int getNextAvailableOutputSlot(ItemStack output) {
        for (int slot : OUTPUT_SLOT) {
            ItemStack stackInSlot = itemHandler.getStackInSlot(slot);
            if (stackInSlot.isEmpty() || stackInSlot.getItem() == output.getItem()) {
                int maxCount = stackInSlot.isEmpty() ? 64 : stackInSlot.getMaxStackSize();
                if (stackInSlot.getCount() + output.getCount() <= maxCount) {
                    return slot;
                }
            }
        }
        return -1; // no slot can accept the output
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = maxProgress;
    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    @Override
    public CompoundTag getUpdateTag(HolderLookup.Provider pRegistries) {
        return saveWithoutMetadata(pRegistries);
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    public @Nullable IItemHandler getItemHandler(@Nullable Direction side) {
        return itemHandler;
    }

    @SubscribeEvent
    private void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                ModBlockEntities.RESOURCE_PROCESSOR_BE.get(),
                (be,side) -> be.getItemHandler(side));
    }
}