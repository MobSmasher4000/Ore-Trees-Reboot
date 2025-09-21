package org.mob.ore_trees_reboot.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

import java.util.List;

public record OreTreeCrafterRecipe(List<Ingredient> inputItems, ItemStack output) implements Recipe<OreTreeCrafterRecipeInput> {

    @Override
    public NonNullList<Ingredient> getIngredients() {
//        NonNullList<Ingredient> list = NonNullList.create();
//        list.add(inputItems.iterator().next());
//        list.addAll(Arrays.asList(inputItems).subList(0, 9));
//        return list;
        return NonNullList.of(Ingredient.EMPTY, inputItems.toArray(new Ingredient[0]));
    }

    @Override
    public boolean matches(OreTreeCrafterRecipeInput oreTreeCrafterRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }
        if (inputItems.size() != oreTreeCrafterRecipeInput.size()) return false;

        for (int i = 0; i < inputItems.size(); i++) {
            if (!inputItems.get(i).test(oreTreeCrafterRecipeInput.getItem(i))) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack assemble(OreTreeCrafterRecipeInput oreTreeCrafterRecipeInput, HolderLookup.Provider provider) {
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
        return ModRecipes.ORE_TREE_CRAFTER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ORE_TREE_CRAFTER_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<OreTreeCrafterRecipe> {
        public static final MapCodec<OreTreeCrafterRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC.listOf(9,9).fieldOf("ingredient").forGetter(OreTreeCrafterRecipe::inputItems),
                ItemStack.CODEC.fieldOf("result").forGetter(OreTreeCrafterRecipe::output)
        ).apply(inst, OreTreeCrafterRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, OreTreeCrafterRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC.apply(ByteBufCodecs.list(9)), OreTreeCrafterRecipe::inputItems,
                        ItemStack.STREAM_CODEC, OreTreeCrafterRecipe::output,
                        OreTreeCrafterRecipe::new);

        @Override
        public MapCodec<OreTreeCrafterRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, OreTreeCrafterRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
