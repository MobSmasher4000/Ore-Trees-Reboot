package org.mob.ore_trees_reboot.recipe;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public record OreTreeCrafterRecipeInput(ItemStack[] itemStacks) implements RecipeInput {

    public OreTreeCrafterRecipeInput {
        if (itemStacks.length != 9) {
            throw new IllegalArgumentException("sideIngredients must contain exactly 8 ItemStacks."+itemStacks.length);
        }
        itemStacks = Arrays.copyOf(itemStacks, itemStacks.length);
    }

    @Override
    public @NotNull ItemStack getItem(int i) {
        ItemStack itemStack;
        switch (i) {
            case 0 -> itemStack = this.itemStacks[0];
            case 1 -> itemStack = this.itemStacks[1];
            case 2 -> itemStack = this.itemStacks[2];
            case 3 -> itemStack = this.itemStacks[3];
            case 4 -> itemStack = this.itemStacks[4];
            case 5 -> itemStack = this.itemStacks[5];
            case 6 -> itemStack = this.itemStacks[6];
            case 7 -> itemStack = this.itemStacks[7];
            case 8 -> itemStack = this.itemStacks[8];
            default -> throw new IllegalArgumentException("Recipe does not contain slot " + i);
        }

        return itemStack;

    }

    @Override
    public int size() {
        return 9;
    }
}
