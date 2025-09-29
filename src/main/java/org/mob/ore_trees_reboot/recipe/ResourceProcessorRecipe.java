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
import org.mob.ore_trees_reboot.recipe.input.ResourceProcessorRecipeInput;

public record ResourceProcessorRecipe(Ingredient inputItem, ItemStack output) implements Recipe<ResourceProcessorRecipeInput> {
    // inputItem & output ==> Read From JSON File!
    // ResourceProcessorRecipeInput --> INVENTORY of the Block Entity

    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(ResourceProcessorRecipeInput resourceProcessorRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(resourceProcessorRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(ResourceProcessorRecipeInput resourceProcessorRecipeInput, HolderLookup.Provider provider) {
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
        return ModRecipes.RESOURCE_PROCESSOR_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.RESOURCE_PROCESSOR_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<ResourceProcessorRecipe> {
        public static final MapCodec<ResourceProcessorRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(ResourceProcessorRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(ResourceProcessorRecipe::output)
        ).apply(inst, ResourceProcessorRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, ResourceProcessorRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, ResourceProcessorRecipe::inputItem,
                        ItemStack.STREAM_CODEC, ResourceProcessorRecipe::output,
                        ResourceProcessorRecipe::new);

        @Override
        public MapCodec<ResourceProcessorRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, ResourceProcessorRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}