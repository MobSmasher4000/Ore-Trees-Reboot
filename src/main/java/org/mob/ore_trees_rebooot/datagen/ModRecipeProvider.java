package org.mob.ore_trees_rebooot.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.mob.ore_trees_rebooot.Ore_trees_reboot;
import org.mob.ore_trees_rebooot.block.ModBlocks;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> IRON_LOG_SMELTABLE = List.of(ModBlocks.IRON_LOG);
        List<ItemLike> GOLD_LOG_SMELTABLE = List.of(ModBlocks.GOLD_LOG);
        List<ItemLike> COPPER_LOG_SMELTABLE = List.of(ModBlocks.COPPER_LOG);
        List<ItemLike> LAPIS_LOG_SMELTABLE = List.of(ModBlocks.LAPIS_LOG);
        List<ItemLike> DIAMOND_LOG_SMELTABLE = List.of(ModBlocks.DIAMOND_LOG);
        List<ItemLike> REDSTONE_LOG_SMELTABLE = List.of(ModBlocks.REDSTONE_LOG);
        List<ItemLike> ANCIENT_LOG_SMELTABLE = List.of(ModBlocks.ANCIENT_LOG);
        List<ItemLike> QUARTZ_LOG_SMELTABLE = List.of(ModBlocks.QUARTZ_LOG);
        List<ItemLike> COAL_LOG_SMELTABLE = List.of(ModBlocks.COAL_LOG);
        List<ItemLike> EMERALD_LOG_SMELTABLE = List.of(ModBlocks.EMERALD_LOG);

        tempCraftingRecipe(recipeOutput, ModBlocks.IRON_SAPLING.get(), Blocks.IRON_BLOCK);
        tempCraftingRecipe(recipeOutput, ModBlocks.GOLD_SAPLING.get(), Blocks.GOLD_BLOCK);
        tempCraftingRecipe(recipeOutput, ModBlocks.COPPER_SAPLING.get(), Blocks.COPPER_BLOCK);
        tempCraftingRecipe(recipeOutput, ModBlocks.LAPIS_SAPLING.get(), Blocks.LAPIS_BLOCK);
        tempCraftingRecipe(recipeOutput, ModBlocks.DIAMOND_SAPLING.get(), Blocks.DIAMOND_BLOCK);
        tempCraftingRecipe(recipeOutput, ModBlocks.REDSTONE_SAPLING.get(), Blocks.REDSTONE_BLOCK);
        tempCraftingRecipe(recipeOutput, ModBlocks.ANCIENT_SAPLING.get(), Blocks.NETHERITE_BLOCK);
        tempCraftingRecipe(recipeOutput, ModBlocks.QUARTZ_SAPLING.get(), Blocks.QUARTZ_BLOCK);
        tempCraftingRecipe(recipeOutput, ModBlocks.COAL_SAPLING.get(), Blocks.COAL_BLOCK);
        tempCraftingRecipe(recipeOutput, ModBlocks.EMERALD_SAPLING.get(), Blocks.EMERALD_BLOCK);

        oreLogSmelting(recipeOutput, IRON_LOG_SMELTABLE, Items.IRON_INGOT);
        oreLogSmelting(recipeOutput, GOLD_LOG_SMELTABLE, Items.GOLD_INGOT);
        oreLogSmelting(recipeOutput, COPPER_LOG_SMELTABLE, Items.COPPER_INGOT);
        oreLogSmelting(recipeOutput, LAPIS_LOG_SMELTABLE, Items.LAPIS_LAZULI);
        oreLogSmelting(recipeOutput, DIAMOND_LOG_SMELTABLE, Items.DIAMOND);
        oreLogSmelting(recipeOutput, REDSTONE_LOG_SMELTABLE, Items.REDSTONE);
        oreLogSmelting(recipeOutput, ANCIENT_LOG_SMELTABLE, Items.ANCIENT_DEBRIS);
        oreLogSmelting(recipeOutput, QUARTZ_LOG_SMELTABLE, Items.QUARTZ);
        oreLogSmelting(recipeOutput, COAL_LOG_SMELTABLE, Items.COAL);
        oreLogSmelting(recipeOutput, EMERALD_LOG_SMELTABLE, Items.EMERALD);

        oreLogBlasting(recipeOutput, IRON_LOG_SMELTABLE, Items.IRON_INGOT);
        oreLogBlasting(recipeOutput, GOLD_LOG_SMELTABLE, Items.GOLD_INGOT);
        oreLogBlasting(recipeOutput, COPPER_LOG_SMELTABLE, Items.COPPER_INGOT);
        oreLogBlasting(recipeOutput, LAPIS_LOG_SMELTABLE, Items.LAPIS_LAZULI);
        oreLogBlasting(recipeOutput, DIAMOND_LOG_SMELTABLE, Items.DIAMOND);
        oreLogBlasting(recipeOutput, REDSTONE_LOG_SMELTABLE, Items.REDSTONE);
        oreLogBlasting(recipeOutput, ANCIENT_LOG_SMELTABLE, Items.ANCIENT_DEBRIS);
        oreLogBlasting(recipeOutput, QUARTZ_LOG_SMELTABLE, Items.QUARTZ);
        oreLogBlasting(recipeOutput, COAL_LOG_SMELTABLE, Items.COAL);
        oreLogBlasting(recipeOutput, EMERALD_LOG_SMELTABLE, Items.EMERALD);

    }

    private static void oreLogSmelting(RecipeOutput recipeOutput, List<ItemLike> ORE_LOG_SMELTABLE, Item output) {
        oreSmelting(recipeOutput, ORE_LOG_SMELTABLE, RecipeCategory.MISC, output, 0.25f, 200, "ore_tree");
    }

    private static void oreLogBlasting(RecipeOutput recipeOutput, List<ItemLike> ORE_LOG_SMELTABLE, Item output) {
        oreBlasting(recipeOutput, ORE_LOG_SMELTABLE, RecipeCategory.MISC, output, 0.25f, 100, "ore_tree");
    }

    private static void tempCraftingRecipe(RecipeOutput recipeOutput, Block sapling, Block material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, sapling)
                .pattern("BBB")
                .pattern("BSB")
                .pattern("BBB")
                .define('B', material)
                .define('S', ItemTags.SAPLINGS)
                .unlockedBy("has_sapling", has(Blocks.OAK_SAPLING))
                .save(recipeOutput);
    }


    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for(ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, Ore_trees_reboot.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }
    }
}
