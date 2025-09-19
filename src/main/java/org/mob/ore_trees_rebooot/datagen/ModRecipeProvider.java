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

        oreLogSmelting(recipeOutput, IRON_LOG_SMELTABLE, Items.IRON_INGOT, "iron");
        oreLogSmelting(recipeOutput, GOLD_LOG_SMELTABLE, Items.GOLD_INGOT, "gold");
        oreLogSmelting(recipeOutput, COPPER_LOG_SMELTABLE, Items.COPPER_INGOT, "copper");
        oreLogSmelting(recipeOutput, LAPIS_LOG_SMELTABLE, Items.LAPIS_LAZULI, "lapis");
        oreLogSmelting(recipeOutput, DIAMOND_LOG_SMELTABLE, Items.DIAMOND, "diamond");
        oreLogSmelting(recipeOutput, REDSTONE_LOG_SMELTABLE, Items.REDSTONE, "redstone");
        oreLogSmelting(recipeOutput, ANCIENT_LOG_SMELTABLE, Items.ANCIENT_DEBRIS, "netherite");
        oreLogSmelting(recipeOutput, QUARTZ_LOG_SMELTABLE, Items.QUARTZ, "quartz");
        oreLogSmelting(recipeOutput, COAL_LOG_SMELTABLE, Items.COAL, "coal");
        oreLogSmelting(recipeOutput, EMERALD_LOG_SMELTABLE, Items.EMERALD, "emerald");

    }

    private static void oreLogSmelting(RecipeOutput recipeOutput, List<ItemLike> IRON_LOG_SMELTABLE, Item output, String group) {
        oreSmelting(recipeOutput, IRON_LOG_SMELTABLE, RecipeCategory.MISC, output, 0.25f, 200, group);
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
