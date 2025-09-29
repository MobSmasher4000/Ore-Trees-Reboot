package org.mob.ore_trees_reboot.recipe.input;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeInput;

import java.util.List;

public record OreTreeCrafterRecipeInput(List<ItemStack> inputItems) implements RecipeInput {
    @Override
    public ItemStack getItem(int i) {
        return inputItems.get(i);
    }

    @Override
    public int size() {
        return 9;
    }
}