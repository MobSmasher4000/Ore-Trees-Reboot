package org.mob.ore_trees_reboot.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.block.ModBlocks;
import org.mob.ore_trees_reboot.datagen.builder.OreTreeCrafterRecipeBuilder;
import org.mob.ore_trees_reboot.datagen.builder.OreTreeReconstructorRecipeBuilder;
import org.mob.ore_trees_reboot.datagen.builder.ResourceProcessorRecipeBuilder;
import org.mob.ore_trees_reboot.item.ModItems;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {

//        Saplings
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.IRON_BLOCK, 1), ModBlocks.IRON_SAPLING, 1);
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.GOLD_BLOCK, 1), ModBlocks.GOLD_SAPLING, 1);
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.COPPER_BLOCK, 1), ModBlocks.COPPER_SAPLING, 1);
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.LAPIS_BLOCK, 1), ModBlocks.LAPIS_SAPLING, 1);
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.DIAMOND_BLOCK, 1), ModBlocks.DIAMOND_SAPLING, 1);
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.REDSTONE_BLOCK, 1), ModBlocks.REDSTONE_SAPLING, 1);
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.COAL_BLOCK, 1), ModBlocks.COAL_SAPLING, 1);
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.QUARTZ_BLOCK, 1), ModBlocks.QUARTZ_SAPLING, 1);
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.EMERALD_BLOCK, 1), ModBlocks.EMERALD_SAPLING, 1);
        oreTreeCrafterSaplingRecipe(recipeOutput, SizedIngredient.of(Blocks.NETHERITE_BLOCK, 1), ModBlocks.ANCIENT_SAPLING, 1);
        
//      Upgrades Speed
        oreTreeCrafterSpeedUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_BASE, 1), SizedIngredient.of(Items.SUGAR, 1), SizedIngredient.of(Items.CLOCK, 1), ModItems.UPGRADE_SPEED_TIER_1, 1);
        oreTreeCrafterSpeedUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_SPEED_TIER_1, 1), SizedIngredient.of(Items.SUGAR, 1), SizedIngredient.of(Items.CLOCK, 1), ModItems.UPGRADE_SPEED_TIER_2, 1);
        oreTreeCrafterSpeedUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_SPEED_TIER_2, 1), SizedIngredient.of(Items.SUGAR, 1), SizedIngredient.of(Items.CLOCK, 1), ModItems.UPGRADE_SPEED_TIER_3, 1);
        oreTreeCrafterSpeedUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_SPEED_TIER_3, 1), SizedIngredient.of(Items.SUGAR, 1), SizedIngredient.of(Items.CLOCK, 1), ModItems.UPGRADE_SPEED_TIER_4, 1);

//      Upgrade Amount
        oreTreeCrafterAmountUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_BASE, 1), SizedIngredient.of(Items.IRON_BLOCK, 1), ModItems.UPGRADE_AMOUNT_TIER_1, 1);
        oreTreeCrafterAmountUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_1, 1), SizedIngredient.of(Items.LAPIS_BLOCK, 1), ModItems.UPGRADE_AMOUNT_TIER_2, 1);
        oreTreeCrafterAmountUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_2, 1), SizedIngredient.of(Items.GOLD_BLOCK, 1), ModItems.UPGRADE_AMOUNT_TIER_3, 1);
        oreTreeCrafterAmountUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_3, 1), SizedIngredient.of(Items.EMERALD_BLOCK, 1), ModItems.UPGRADE_AMOUNT_TIER_4, 1);
        oreTreeCrafterAmountUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_4, 1), SizedIngredient.of(Items.DIAMOND_BLOCK, 1), ModItems.UPGRADE_AMOUNT_TIER_5, 1);
        oreTreeCrafterAmountUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_5, 1), SizedIngredient.of(Items.NETHERITE_BLOCK, 1), ModItems.UPGRADE_AMOUNT_TIER_6, 1);

//      Speed_amount upgrades
        oreTreeCrafterUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_1, 1), ModItems.UPGRADE_TIER_1, 1);
        oreTreeCrafterUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_2, 1), ModItems.UPGRADE_TIER_2, 1);
        oreTreeCrafterUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_3, 1), ModItems.UPGRADE_TIER_3, 1);
        oreTreeCrafterUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_4, 1), ModItems.UPGRADE_TIER_4, 1);
        oreTreeCrafterUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_5, 1), ModItems.UPGRADE_TIER_5, 1);
        oreTreeCrafterUpgradeRecipe(recipeOutput, SizedIngredient.of(ModItems.UPGRADE_AMOUNT_TIER_6, 1), ModItems.UPGRADE_TIER_6, 1);

//        Dirt
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.IRON_BLOCK, 1), ModBlocks.IRON_DIRT, 1);
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.GOLD_BLOCK, 1), ModBlocks.GOLD_DIRT, 1);
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.COPPER_BLOCK, 1), ModBlocks.COPPER_DIRT, 1);
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.LAPIS_BLOCK, 1), ModBlocks.LAPIS_DIRT, 1);
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.DIAMOND_BLOCK, 1), ModBlocks.DIAMOND_DIRT, 1);
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.REDSTONE_BLOCK, 1), ModBlocks.REDSTONE_DIRT, 1);
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.COAL_BLOCK, 1), ModBlocks.COAL_DIRT, 1);
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.QUARTZ_BLOCK, 1), ModBlocks.QUARTZ_DIRT, 1);
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.EMERALD_BLOCK, 1), ModBlocks.EMERALD_DIRT, 1);
        oreTreeCrafterDirtRecipe(recipeOutput, SizedIngredient.of(Blocks.NETHERITE_BLOCK, 1), ModBlocks.ANCIENT_DIRT, 1);

//        ore logs processing in resource processor
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.IRON_LOG), Items.IRON_INGOT, 4);
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.GOLD_LOG), Items.GOLD_INGOT, 4);
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.COPPER_LOG), Items.COPPER_INGOT, 4);
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.LAPIS_LOG), Items.LAPIS_LAZULI, 8);
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.DIAMOND_LOG), Items.DIAMOND, 2);
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.REDSTONE_LOG), Items.REDSTONE, 8);
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.ANCIENT_LOG), Items.ANCIENT_DEBRIS, 1);
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.COAL_LOG), Items.COAL, 8);
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.QUARTZ_LOG), Items.QUARTZ, 4);
        ResourceProcessorRecipe(recipeOutput, Ingredient.of(ModBlocks.EMERALD_LOG), Items.EMERALD, 2);

//      Reconstructor Recipes
        OreTreeReconstructorRecipe(recipeOutput, Ingredient.of(ItemTags.SAPLINGS), ModItems.Crafting_Base, 1);

        
        
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
                .define('O', Tags.Items.STRIPPED_LOGS)
                .unlockedBy("has_base", has(ModItems.Crafting_Base.get()))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModBlocks.ORE_TREE_CRAFTER.get())
                .pattern("SSS")
                .pattern("SBS")
                .pattern("SSS")
                .define('S', ModItems.ORE_TREE_SHARD)
                .define('B', ModItems.Crafting_Base)
                .unlockedBy("has_base", has(ModItems.Crafting_Base))
                .save(recipeOutput);
        
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ModItems.UPGRADE_BASE.get())
                .pattern(" S ")
                .pattern("SIS")
                .pattern(" S ")
                .define('S', ModItems.ORE_TREE_SHARD)
                .define('I', Items.IRON_INGOT)
                .unlockedBy("has_ore_shard", has(ModItems.ORE_TREE_SHARD))
                .save(recipeOutput);
    }

    protected static void oreTreeCrafterSaplingRecipe(RecipeOutput recipeOutput, SizedIngredient material, ItemLike result, int outputCount){
        OreTreeCrafterRecipeBuilder.oreTreeCrafterRecipe()
                .addIngredient(SizedIngredient.of(ModItems.Crafting_Base, 1)) // 0
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 1
                .addIngredient(material) // 2
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 3
                .addIngredient(material) // 4
                .addIngredient(material) // 5
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 6
                .addIngredient(material) // 7
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 8
                .addOutput(new ItemStack(result, outputCount))
                .unlockedBy(getHasName(material.ingredient().getItems()[0].getItem()), has(material.ingredient().getItems()[0].getItem()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, "ore_tree_crafter/" + getItemName(result) + "_from_ore_tree_crafter"));
    }

    protected static void oreTreeCrafterDirtRecipe(RecipeOutput recipeOutput, SizedIngredient material, ItemLike result, int outputCount){
        OreTreeCrafterRecipeBuilder.oreTreeCrafterRecipe()
                .addIngredient(material) // 0
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 1
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 2
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 3
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 4
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 5
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 6
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 7
                .addIngredient(SizedIngredient.of(ModItems.ORE_TREE_SHARD, 1)) // 8
                .addOutput(new ItemStack(result, outputCount))
                .unlockedBy(getHasName(material.ingredient().getItems()[0].getItem()), has(material.ingredient().getItems()[0].getItem()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, "ore_tree_crafter/" + getItemName(result) + "_from_ore_tree_crafter"));
    }

    protected static void ResourceProcessorRecipe(RecipeOutput recipeOutput, Ingredient input, ItemLike result, int outputCount){
        ResourceProcessorRecipeBuilder.resourceProcessorRecipe()
                .addIngredient(input) // 0
                .addOutput(new ItemStack(result, outputCount))
                .unlockedBy(getHasName(input.getItems()[0].getItem()), has(input.getItems()[0].getItem()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, "resource_processor/" + getItemName(result) + "_from_resource_processor"));
    }

    protected static void OreTreeReconstructorRecipe(RecipeOutput recipeOutput, Ingredient input, ItemLike result, int outputCount){
        OreTreeReconstructorRecipeBuilder.oreTreeReconstructorRecipe()
                .addIngredient(input) // 0
                .addOutput(new ItemStack(result, outputCount))
                .unlockedBy(getHasName(input.getItems()[0].getItem()), has(input.getItems()[0].getItem()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, "ore_tree_reconstructor/" + getItemName(result) + "_from_ore_tree_reconstructor"));
    }

    protected static void oreTreeCrafterSpeedUpgradeRecipe(RecipeOutput recipeOutput, SizedIngredient input, SizedIngredient material, SizedIngredient material2, ItemLike result, int outputCount){
        OreTreeCrafterRecipeBuilder.oreTreeCrafterRecipe()
                .addIngredient(input) // 0
                .addIngredient(material2) // 1
                .addIngredient(material) // 2
                .addIngredient(material2) // 3
                .addIngredient(material) // 4
                .addIngredient(material) // 5
                .addIngredient(material2) // 6
                .addIngredient(material) // 7
                .addIngredient(material2) // 8
                .addOutput(new ItemStack(result, outputCount))
                .unlockedBy(getHasName(material.ingredient().getItems()[0].getItem()), has(material.ingredient().getItems()[0].getItem()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, "ore_tree_crafter/" + getItemName(result) + "_from_ore_tree_crafter"));
    }

    protected static void oreTreeCrafterAmountUpgradeRecipe(RecipeOutput recipeOutput, SizedIngredient input, SizedIngredient material, ItemLike result, int outputCount){
        OreTreeCrafterRecipeBuilder.oreTreeCrafterRecipe()
                .addIngredient(input) // 0
                .addIngredient(material) // 1
                .addIngredient(material) // 2
                .addIngredient(material) // 3
                .addIngredient(material) // 4
                .addIngredient(material) // 5
                .addIngredient(material) // 6
                .addIngredient(material) // 7
                .addIngredient(material) // 8
                .addOutput(new ItemStack(result, outputCount))
                .unlockedBy(getHasName(material.ingredient().getItems()[0].getItem()), has(material.ingredient().getItems()[0].getItem()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, "ore_tree_crafter/" + getItemName(result) + "_from_ore_tree_crafter"));
    }

    protected static void oreTreeCrafterUpgradeRecipe(RecipeOutput recipeOutput, SizedIngredient material, ItemLike result, int outputCount){
        OreTreeCrafterRecipeBuilder.oreTreeCrafterRecipe()
                .addIngredient(SizedIngredient.of(ModItems.UPGRADE_BASE, 1)) // 0
                .addIngredient(SizedIngredient.of(Items.IRON_BLOCK, 1)) // 1
                .addIngredient(material) // 2
                .addIngredient(SizedIngredient.of(Items.IRON_BLOCK, 1)) // 3
                .addIngredient(SizedIngredient.of(Items.GOLD_BLOCK,1)) // 4
                .addIngredient(SizedIngredient.of(Items.GOLD_BLOCK,1)) // 5
                .addIngredient(SizedIngredient.of(Items.IRON_BLOCK, 1)) // 6
                .addIngredient(SizedIngredient.of(ModItems.UPGRADE_SPEED_TIER_4,1)) // 7
                .addIngredient(SizedIngredient.of(Items.IRON_BLOCK, 1)) // 8
                .addOutput(new ItemStack(result, outputCount))
                .unlockedBy(getHasName(material.ingredient().getItems()[0].getItem()), has(material.ingredient().getItems()[0].getItem()))
                .save(recipeOutput, ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, "ore_tree_crafter/" + getItemName(result) + "_from_ore_tree_crafter"));
    }

}
