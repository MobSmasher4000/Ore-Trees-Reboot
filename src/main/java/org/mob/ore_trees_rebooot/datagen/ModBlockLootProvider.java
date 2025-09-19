package org.mob.ore_trees_rebooot.datagen;

import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;
import org.mob.ore_trees_rebooot.block.ModBlocks;

import java.util.Set;

public class ModBlockLootProvider extends BlockLootSubProvider {
    protected ModBlockLootProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(ModBlocks.IRON_LOG.get());
        dropSelf(ModBlocks.GOLD_LOG.get());
        dropSelf(ModBlocks.COPPER_LOG.get());
        dropSelf(ModBlocks.LAPIS_LOG.get());
        dropSelf(ModBlocks.DIAMOND_LOG.get());
        dropSelf(ModBlocks.REDSTONE_LOG.get());
        dropSelf(ModBlocks.ANCIENT_LOG.get());
        dropSelf(ModBlocks.QUARTZ_LOG.get());
        dropSelf(ModBlocks.COAL_LOG.get());
        dropSelf(ModBlocks.EMERALD_LOG.get());

        dropSelf(ModBlocks.IRON_SAPLING.get());
        dropSelf(ModBlocks.GOLD_SAPLING.get());
        dropSelf(ModBlocks.COPPER_SAPLING.get());
        dropSelf(ModBlocks.LAPIS_SAPLING.get());
        dropSelf(ModBlocks.DIAMOND_SAPLING.get());
        dropSelf(ModBlocks.REDSTONE_SAPLING.get());
        dropSelf(ModBlocks.ANCIENT_SAPLING.get());
        dropSelf(ModBlocks.QUARTZ_SAPLING.get());
        dropSelf(ModBlocks.COAL_SAPLING.get());
        dropSelf(ModBlocks.EMERALD_SAPLING.get());

        this.add(ModBlocks.IRON_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.IRON_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.GOLD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.GOLD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.COPPER_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.COPPER_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.LAPIS_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.LAPIS_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.DIAMOND_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.DIAMOND_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.REDSTONE_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.REDSTONE_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.ANCIENT_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.ANCIENT_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.COAL_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.COAL_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.QUARTZ_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.QUARTZ_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

        this.add(ModBlocks.EMERALD_LEAVES.get(), block ->
                createLeavesDrops(block, ModBlocks.EMERALD_SAPLING.get(), NORMAL_LEAVES_SAPLING_CHANCES));

    }

    @Override
    protected @NotNull Iterable<Block> getKnownBlocks() {
        return ModBlocks.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
    }
}
