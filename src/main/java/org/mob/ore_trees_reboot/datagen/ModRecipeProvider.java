package org.mob.ore_trees_reboot.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.neoforged.neoforge.common.crafting.SizedIngredient;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.block.ModBlocks;
import org.mob.ore_trees_reboot.datagen.builder.OreTreeCrafterRecipeBuilder;
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


}
