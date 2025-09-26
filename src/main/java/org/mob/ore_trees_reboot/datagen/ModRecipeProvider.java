package org.mob.ore_trees_reboot.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.nbt.Tag;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import org.mob.ore_trees_reboot.block.ModBlocks;
import org.mob.ore_trees_reboot.item.ModItems;
import org.mob.ore_trees_reboot.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.IRON_SAPLING.get(), Blocks.IRON_BLOCK);
        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.GOLD_SAPLING.get(), Blocks.GOLD_BLOCK);
        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.COPPER_SAPLING.get(), Blocks.COPPER_BLOCK);
        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.LAPIS_SAPLING.get(), Blocks.LAPIS_BLOCK);
        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.DIAMOND_SAPLING.get(), Blocks.DIAMOND_BLOCK);
        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.REDSTONE_SAPLING.get(), Blocks.REDSTONE_BLOCK);
        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.ANCIENT_SAPLING.get(), Blocks.NETHERITE_BLOCK);
        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.QUARTZ_SAPLING.get(), Blocks.QUARTZ_BLOCK);
        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.COAL_SAPLING.get(), Blocks.COAL_BLOCK);
        tempSaplingCraftingRecipe(recipeOutput, ModBlocks.EMERALD_SAPLING.get(), Blocks.EMERALD_BLOCK);

        tempDirtCraftingRecipe(recipeOutput, ModBlocks.IRON_DIRT.get(), Blocks.IRON_BLOCK);
        tempDirtCraftingRecipe(recipeOutput, ModBlocks.GOLD_DIRT.get(), Blocks.GOLD_BLOCK);
        tempDirtCraftingRecipe(recipeOutput, ModBlocks.COPPER_DIRT.get(), Blocks.COPPER_BLOCK);
        tempDirtCraftingRecipe(recipeOutput, ModBlocks.LAPIS_DIRT.get(), Blocks.LAPIS_BLOCK);
        tempDirtCraftingRecipe(recipeOutput, ModBlocks.DIAMOND_DIRT.get(), Blocks.DIAMOND_BLOCK);
        tempDirtCraftingRecipe(recipeOutput, ModBlocks.REDSTONE_DIRT.get(), Blocks.REDSTONE_BLOCK);
        tempDirtCraftingRecipe(recipeOutput, ModBlocks.ANCIENT_DIRT.get(), Blocks.NETHERITE_BLOCK);
        tempDirtCraftingRecipe(recipeOutput, ModBlocks.COAL_DIRT.get(), Blocks.COAL_BLOCK);
        tempDirtCraftingRecipe(recipeOutput, ModBlocks.QUARTZ_DIRT.get(), Blocks.QUARTZ_BLOCK);
        tempDirtCraftingRecipe(recipeOutput, ModBlocks.EMERALD_DIRT.get(), Blocks.EMERALD_BLOCK);


        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORE_TREE_RECONSTRUCTOR.get())
                .pattern("ICL")
                .pattern("GDR")
                .pattern("EQW")
                .define('I',Blocks.IRON_BLOCK)
                .define('C',Blocks.COPPER_BLOCK)
                .define('L',Blocks.LAPIS_BLOCK)
                .define('G',Blocks.GOLD_BLOCK)
                .define('D',Blocks.DIAMOND_BLOCK)
                .define('R',Blocks.REDSTONE_BLOCK)
                .define('E',Blocks.EMERALD_BLOCK)
                .define('Q',Blocks.QUARTZ_BLOCK)
                .define('W',Blocks.COAL_BLOCK)
                .unlockedBy("has_sapling", has(Items.OAK_SAPLING))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.RESOURCE_PROCESSOR.get())
                .pattern("SSS")
                .pattern("SBO")
                .pattern("OOO")
                .define('S', ModItems.ORE_TREE_SHARD)
                .define('B', ModItems.Crafting_Base)
                .define('O', Blocks.OAK_LOG)
                .unlockedBy("has_base", has(ModItems.Crafting_Base.get()))
                .save(recipeOutput);

    }

    private static void tempSaplingCraftingRecipe(RecipeOutput recipeOutput, Block sapling, Block material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, sapling)
                .pattern("SSS")
                .pattern("SCB")
                .pattern("BBB")
                .define('B', material)
                .define('S', ModItems.ORE_TREE_SHARD)
                .define('C', ModItems.Crafting_Base)
                .unlockedBy("has_crafting_base", has(ModItems.Crafting_Base))
                .save(recipeOutput);
    }

    private static void tempDirtCraftingRecipe(RecipeOutput recipeOutput, Block dirt, Block material) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, dirt)
                .pattern("SSS")
                .pattern("SBS")
                .pattern("SSS")
                .define('B', material)
                .define('S', ModItems.ORE_TREE_SHARD)
                .unlockedBy("has_ore_shards", has(ModItems.ORE_TREE_SHARD))
                .save(recipeOutput);
    }


}
