package org.mob.ore_trees_reboot.inventory;

import net.neoforged.neoforge.items.IItemHandler;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class SlotFilteredItemHandler implements IItemHandler {
    private final ItemStackHandler parent;
    private final List<Integer> inputSlots;
    private final List<Integer> outputSlots;

    public SlotFilteredItemHandler(ItemStackHandler parent, List<Integer> inputSlots, List<Integer> outputSlots) {
        this.parent = parent;
        this.inputSlots = inputSlots;
        this.outputSlots = outputSlots;
    }

    @Override
    public int getSlots() {
        return parent.getSlots();
    }

    @Override
    public ItemStack getStackInSlot(int slot) {
        return parent.getStackInSlot(slot);
    }

    @Override
    public ItemStack insertItem(int slot, ItemStack stack, boolean simulate) {
        if (!inputSlots.contains(slot)) return stack; // reject insert outside inputs
        return parent.insertItem(slot, stack, simulate);
    }

    @Override
    public ItemStack extractItem(int slot, int amount, boolean simulate) {
        if (!outputSlots.contains(slot)) return ItemStack.EMPTY; // reject extract outside outputs
        return parent.extractItem(slot, amount, simulate);
    }

    @Override
    public int getSlotLimit(int slot) {
        return parent.getSlotLimit(slot);
    }

    @Override
    public boolean isItemValid(int slot, ItemStack stack) {
        return inputSlots.contains(slot) && parent.isItemValid(slot, stack);
    }
}
