package org.mob.ore_trees_reboot.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import org.mob.ore_trees_reboot.recipe.ModRecipes;
import org.mob.ore_trees_reboot.recipe.input.OreTreeCrafterRecipeInput;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.mob.ore_trees_reboot.Ore_trees_reboot.resourceLocation;

public class OreTreeCrafterRecipe implements Recipe<OreTreeCrafterRecipeInput> {
    private final List<SizedIngredient> inputItems;
    private final List<ItemStack> output;

    public OreTreeCrafterRecipe(List<SizedIngredient> inputItems, List<ItemStack> output) {
        this.inputItems = inputItems;
        this.output = output;
    }

    @Override
    public boolean matches(OreTreeCrafterRecipeInput oreTreeCrafterRecipeInput, Level level) {
        List<ItemStack> inputItems = oreTreeCrafterRecipeInput.inputItems();
        List<SizedIngredient> remainingIngredients  = new ArrayList<>(this.inputItems);

        for (ItemStack itemStack : inputItems) {
            if (itemStack.isEmpty()) {
                continue;
            }

            boolean ingredientFound = false;
            Iterator<SizedIngredient> iterator = remainingIngredients.iterator();

            while (iterator.hasNext()) {
                SizedIngredient ingredient = iterator.next();
                if (ingredient.ingredient().test(itemStack)) {
                    iterator.remove();
                    ingredientFound = true;
                    break;
                }
            }

            if (!ingredientFound) {
                return false;
            }
        }

        return remainingIngredients.isEmpty();
    }

    @Override
    public ItemStack assemble(OreTreeCrafterRecipeInput oreTreeCrafterRecipeInput, HolderLookup.Provider provider) {
        return output.isEmpty() ? ItemStack.EMPTY : output.get(0).copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output.isEmpty() ? ItemStack.EMPTY : output.get(0).copy();
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.ORE_TREE_CRAFTER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.ORE_TREE_CRAFTER_TYPE.get();
    }

    public List<SizedIngredient> getInputItems() {
        return inputItems;
    }

    public List<ItemStack> getOutput() {
        return output;
    }

    public static class Serializer implements RecipeSerializer<OreTreeCrafterRecipe>{
        public static final OreTreeCrafterRecipe.Serializer INSTANCE = new OreTreeCrafterRecipe.Serializer();
        public static final ResourceLocation ID = resourceLocation("ore_tree_crafter");

        private final MapCodec<OreTreeCrafterRecipe> CODEC = RecordCodecBuilder.mapCodec(oreTreeCrafterRecipeInstance -> oreTreeCrafterRecipeInstance.group(
                SizedIngredient.FLAT_CODEC.listOf().fieldOf("ingredients").forGetter(OreTreeCrafterRecipe::getInputItems),
                ItemStack.CODEC.listOf().fieldOf("output").forGetter(OreTreeCrafterRecipe::getOutput)
        ).apply(oreTreeCrafterRecipeInstance, OreTreeCrafterRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, OreTreeCrafterRecipe> STREAM_CODEC = StreamCodec.of(
                OreTreeCrafterRecipe.Serializer::toNetwork, OreTreeCrafterRecipe.Serializer::fromNetwork
        );

        @Override
        public MapCodec<OreTreeCrafterRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, OreTreeCrafterRecipe> streamCodec() {
            return STREAM_CODEC;
        }

        private static OreTreeCrafterRecipe fromNetwork(RegistryFriendlyByteBuf buffer) {
            int ingredientCount = buffer.readVarInt();
            List<SizedIngredient> inputItems = new ArrayList<>(ingredientCount);
            for (int i = 0; i < ingredientCount; i++) {
                inputItems.add(SizedIngredient.STREAM_CODEC.decode(buffer));
            }

            int outputCount = buffer.readVarInt();
            List<ItemStack> result = new ArrayList<>(outputCount);
            for (int i = 0; i < outputCount; i++) {
                result.add(ItemStack.STREAM_CODEC.decode(buffer));
            }

            return new OreTreeCrafterRecipe(inputItems, result);
        }

        private static void toNetwork(RegistryFriendlyByteBuf buffer, OreTreeCrafterRecipe recipe) {
            buffer.writeVarInt(recipe.inputItems.size());
            for (SizedIngredient ingredient : recipe.inputItems) {
                SizedIngredient.STREAM_CODEC.encode(buffer, ingredient);
            }

            buffer.writeVarInt(recipe.output.size());
            for (ItemStack itemStack : recipe.output) {
                ItemStack.STREAM_CODEC.encode(buffer, itemStack);
            }

        }
    }
}