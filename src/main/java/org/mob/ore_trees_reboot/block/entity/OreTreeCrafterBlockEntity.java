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
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import net.neoforged.neoforge.energy.EnergyStorage;
import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import org.jetbrains.annotations.Nullable;
import org.mob.ore_trees_reboot.inventory.SlotFilteredItemHandler;
import org.mob.ore_trees_reboot.recipe.ModRecipes;
import org.mob.ore_trees_reboot.recipe.OreTreeCrafterRecipe;
import org.mob.ore_trees_reboot.recipe.input.OreTreeCrafterRecipeInput;
import org.mob.ore_trees_reboot.screen.custom.OreTreeCrafterMenu;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.IntStream;

public class OreTreeCrafterBlockEntity extends BlockEntity implements MenuProvider {

    public final ItemStackHandler itemHandler = new ItemStackHandler(10) {
        @Override
        protected void onContentsChanged(int slot) {
            setChanged();
            if(!level.isClientSide()) {
                level.sendBlockUpdated(getBlockPos(), getBlockState(), getBlockState(), 3);
            }
        }
    };

    // Unified automation handler: insert only into 0–2, extract only from 3–11
    private final IItemHandler ioHandler =
            new SlotFilteredItemHandler(itemHandler,
                    java.util.List.of(0, 1, 2, 3, 4, 5, 6, 7, 8),    // input slots
                    java.util.List.of(9)); // output slots
    ;

    // --- Energy handler ---
    private final EnergyStorage energyStorage = new EnergyStorage(100_000, 10_000, 10_000);

    // Helper getters (like normal variables)
    public int getEnergy() {
        return energyStorage.getEnergyStored();
    }

    public int getMaxEnergy() {
        return energyStorage.getMaxEnergyStored();
    }

    private static final int[] INPUT_SLOTS = IntStream.rangeClosed(0, 8).toArray();
    private static final int OUTPUT_SLOT = 9;

    protected final ContainerData data;
    private int progress = 0;
    private int maxProgress = 100;

    public OreTreeCrafterBlockEntity(BlockPos pos, BlockState blockState) {
        super(ModBlockEntities.ORE_TREE_CRAFTER_BE.get(), pos, blockState);
        data = new ContainerData() {
            @Override
            public int get(int i) {
                return switch (i){
                    case 0 -> OreTreeCrafterBlockEntity.this.progress;
                    case 1 -> OreTreeCrafterBlockEntity.this.maxProgress;
                    case 2 -> OreTreeCrafterBlockEntity.this.getEnergy();
                    case 3 -> OreTreeCrafterBlockEntity.this.getMaxEnergy();
                    default -> 0;
                };
            }

            @Override
            public void set(int i, int value) {
                switch (i){
                    case 0: OreTreeCrafterBlockEntity.this.progress = value;
                    case 1: OreTreeCrafterBlockEntity.this.maxProgress = value;
                    case 2: OreTreeCrafterBlockEntity.this.energyStorage.receiveEnergy(value - energyStorage.getEnergyStored(), false);
                }

            }

            @Override
            public int getCount() {
                return 4;
            }
        };
    }

    @Override
    public Component getDisplayName() {
        return Component.translatable("block.ore_trees_reboot.ore_tree_crafter");
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return new OreTreeCrafterMenu(i, inventory, this, this.data);
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
        pTag.putInt("ore_tree_crafter.progress", progress);
        pTag.putInt("ore_tree_crafter.max_progress", maxProgress);
        pTag.put("energy", energyStorage.serializeNBT(pRegistries));

        super.saveAdditional(pTag, pRegistries);
    }

    @Override
    protected void loadAdditional(CompoundTag pTag, HolderLookup.Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);

        itemHandler.deserializeNBT(pRegistries, pTag.getCompound("inventory"));
        progress = pTag.getInt("ore_tree_crafter.progress");
        maxProgress = pTag.getInt("ore_tree_crafter.max_progress");
        energyStorage.deserializeNBT(pRegistries, pTag.get("energy"));
    }

    public void tick(Level level, BlockPos blockPos, BlockState blockState) {
        setChanged(level, blockPos, blockState);

        if(hasRecipe() && energyStorage.getEnergyStored() >= 1){
            increaseCraftingProgress();
            energyStorage.extractEnergy(200, false);
            setChanged(level, blockPos, blockState);

            if(hasCraftingFinished()) {
                craftItem();
                resetProgress();
                setChanged(level, blockPos, blockState);
            }
        } else {
            resetProgress();
            setChanged(level, blockPos, blockState);
        }

    }

    private boolean hasCraftingFinished() {
        return this.progress >= this.maxProgress;
    }

    private void increaseCraftingProgress() {
        progress++;
    }

    private void resetProgress() {
        this.progress = 0;
        this.maxProgress = maxProgress;
    }

    private void craftItem() {
        Optional<RecipeHolder<OreTreeCrafterRecipe>> recipe = getCurrentRecipe();
        if (recipe.isPresent()) {
            List<ItemStack> results = recipe.get().value().getOutput();

            // Track how much to extract from each slot
            int[] extractCounts = new int[itemHandler.getSlots()];

            // Go through all ingredients in the recipe
            for (SizedIngredient ingredient : recipe.get().value().getInputItems()) {
                for (int slot = 0; slot < 9; slot++) { // only first 9 are crafting inputs
                    ItemStack stackInSlot = itemHandler.getStackInSlot(slot);
                    if (!stackInSlot.isEmpty() && ingredient.test(stackInSlot)) {
                        // Add how many we can extract (up to ingredient count)
                        extractCounts[slot] += Math.min(stackInSlot.getCount(), ingredient.count());
                    }
                }
            }

            // Perform extractions
            for (int slot = 0; slot < 9; slot++) {
                if (extractCounts[slot] > 0) {
                    itemHandler.extractItem(slot, extractCounts[slot], false);
                }
            }



            for (ItemStack result : results) {
                this.itemHandler.setStackInSlot(OUTPUT_SLOT, new ItemStack(result.getItem(),
                            this.itemHandler.getStackInSlot(OUTPUT_SLOT).getCount() + result.getCount()));

                }
            }
        }

    private boolean hasRecipe() {
        Optional<RecipeHolder<OreTreeCrafterRecipe>> recipe = getCurrentRecipe();
        if(recipe.isEmpty()) {
            return false;
        }

        List<ItemStack> output = recipe.get().value().getOutput();
        return canInsertAmountIntoOutputSlot(output.size()) && canInsertItemIntoOutputSlot(output);
    }

    private boolean canInsertItemIntoOutputSlot(List<ItemStack> output) {
        return itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ||
                itemHandler.getStackInSlot(OUTPUT_SLOT).getItem() == output.getLast().getItem();
    }

    private boolean canInsertAmountIntoOutputSlot(int count) {
        int maxCount = itemHandler.getStackInSlot(OUTPUT_SLOT).isEmpty() ? 64 : itemHandler.getStackInSlot(OUTPUT_SLOT).getMaxStackSize();
        int currentCount = itemHandler.getStackInSlot(OUTPUT_SLOT).getCount();

        return maxCount >= currentCount + count;
    }

    private Optional<RecipeHolder<OreTreeCrafterRecipe>> getCurrentRecipe() {

        List<ItemStack> inputs = new ArrayList<>();

        for (int i = 0; i < 9; i++) {
            inputs.add(this.itemHandler.getStackInSlot(i));
        }

        return this.level.getRecipeManager()
                .getRecipeFor(ModRecipes.ORE_TREE_CRAFTER_TYPE.get(), new OreTreeCrafterRecipeInput(inputs), level);
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
        return ioHandler;
    }

    public @Nullable EnergyStorage getEnergyStorage(@Nullable Direction side) {
        return energyStorage;
    }
}