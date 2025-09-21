package org.mob.ore_trees_reboot.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record OreTreeReconstructorRecipe(Ingredient inputItem, ItemStack output) implements Recipe<OreTreeReconstructorRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // OreTreeReconstructorRecipeInput --> INVENTORY of the Block Entity

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(OreTreeReconstructorRecipeInput OreTreeReconstructorRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(OreTreeReconstructorRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(OreTreeReconstructorRecipeInput OreTreeReconstructorRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ORE_TREE_RECONSTRUCTOR_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ORE_TREE_RECONSTRUCTOR_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<OreTreeReconstructorRecipe> {
        public static final MapCodec<OreTreeReconstructorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(OreTreeReconstructorRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(OreTreeReconstructorRecipe::output)
        ).apply(inst, OreTreeReconstructorRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, OreTreeReconstructorRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, OreTreeReconstructorRecipe::inputItem,
                        ItemStack.STREAM_CODEC, OreTreeReconstructorRecipe::output,
                        OreTreeReconstructorRecipe::new);

        @Override
        public MapCodec<OreTreeReconstructorRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, OreTreeReconstructorRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}