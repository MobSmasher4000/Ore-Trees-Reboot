package org.mob.ore_trees_reboot.recipe;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.ArrayList;
import java.util.List;

public record OreTreeCrafterRecipe(List<Ingredient> inputItems, ItemStack output) implements Recipe<OreTreeCrafterRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return NonNullList.of(Ingredient.EMPTY, inputItems.toArray(new Ingredient[0]));
    }

    @Override
    public boolean matches(OreTreeCrafterRecipeInput inv, Level level) {
        if (level.isClientSide()) return false;
        for (int i = 0; i < inputItems.size(); i++) {
            if (!inputItems.get(i).test(inv.getItem(i))) return false;
        }
        return true;
    }

    @Override
    public ItemStack assemble(OreTreeCrafterRecipeInput inv, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ORE_TREE_CRAFTER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ORE_TREE_CRAFTER_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<OreTreeCrafterRecipe> {

        public static final MapCodec<OreTreeCrafterRecipe> CODEC = RecordCodecBuilder.mapCodec(instance ->
                instance.group(
                        Ingredient.CODEC.listOf(9, 9).fieldOf("ingredient").forGetter(OreTreeCrafterRecipe::inputItems),
                        ItemStack.CODEC.fieldOf("result").forGetter(OreTreeCrafterRecipe::output)
                ).apply(instance, OreTreeCrafterRecipe::new)
        );

        public static final StreamCodec<RegistryFriendlyByteBuf, OreTreeCrafterRecipe> STREAM_CODEC = StreamCodec.of(
                buf -> {
                    // read 9 ingredients from buffer
                    Ingredient[] ingredients = new Ingredient[9];
                    for (int i = 0; i < 9; i++) {
                        ingredients[i] = Ingredient.fromNetwork(buf);
                    }
                    ItemStack output = buf.readItem();
                    return new OreTreeCrafterRecipe(List.of(ingredients), output);
                },
                (buf, recipe) -> {
                    // write 9 ingredients to buffer
                    for (Ingredient ing : recipe.inputItems()) {
                        ing.toNetwork(buf);
                    }
                    buf.writeItem(recipe.output());
                }
        );

        @Override
        public MapCodec<OreTreeCrafterRecipe> codec() {
            return null;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, OreTreeCrafterRecipe> streamCodec() {
            return null;
        }
    }
}
