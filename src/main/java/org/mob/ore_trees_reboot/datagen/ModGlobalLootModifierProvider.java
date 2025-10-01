package org.mob.ore_trees_reboot.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemRandomChanceCondition;
import net.neoforged.neoforge.common.data.GlobalLootModifierProvider;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.item.ModItems;
import org.mob.ore_trees_reboot.loot.AddItemModifier;

import java.util.concurrent.CompletableFuture;

public class ModGlobalLootModifierProvider extends GlobalLootModifierProvider {
    public ModGlobalLootModifierProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries, Ore_trees_reboot.MOD_ID);
    }

    @Override
    protected void start() {
        this.add("ore_tree_shard_to_oak_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.OAK_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));

        this.add("ore_tree_shard_to_acacia_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.ACACIA_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));

        this.add("ore_tree_shard_to_azalea_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.AZALEA_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));

        this.add("ore_tree_shard_to_birch_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.BIRCH_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));

        this.add("ore_tree_shard_to_cherry_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.CHERRY_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));

        this.add("ore_tree_shard_to_dark_oak_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.DARK_OAK_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));

        this.add("ore_tree_shard_to_flowering_azalea_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.FLOWERING_AZALEA_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));

        this.add("ore_tree_shard_to_jungle_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.JUNGLE_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));

        this.add("ore_tree_shard_to_mangrove_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.MANGROVE_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));

        this.add("ore_tree_shard_to_spruce_leaves",
                new AddItemModifier(new LootItemCondition[]{
                        LootItemBlockStatePropertyCondition.hasBlockStateProperties(Blocks.SPRUCE_LEAVES).build(),
                        LootItemRandomChanceCondition.randomChance(0.50f).build() }, ModItems.ORE_TREE_SHARD.get()));


    }
}
