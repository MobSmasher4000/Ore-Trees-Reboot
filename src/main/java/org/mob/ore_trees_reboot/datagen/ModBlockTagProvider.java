package org.mob.ore_trees_reboot.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.block.ModBlocks;
import org.mob.ore_trees_reboot.util.ModTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, Ore_trees_reboot.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.SAPLINGS)
                .add(ModBlocks.IRON_SAPLING.get())
                .add(ModBlocks.GOLD_SAPLING.get())
                .add(ModBlocks.COPPER_SAPLING.get())
                .add(ModBlocks.LAPIS_SAPLING.get())
                .add(ModBlocks.DIAMOND_SAPLING.get())
                .add(ModBlocks.REDSTONE_SAPLING.get())
                .add(ModBlocks.ANCIENT_SAPLING.get())
                .add(ModBlocks.QUARTZ_SAPLING.get())
                .add(ModBlocks.COAL_SAPLING.get())
                .add(ModBlocks.EMERALD_SAPLING.get())
        ;

        tag(BlockTags.LOGS)
                .add(ModBlocks.IRON_LOG.get())
                .add(ModBlocks.GOLD_LOG.get())
                .add(ModBlocks.COPPER_LOG.get())
                .add(ModBlocks.LAPIS_LOG.get())
                .add(ModBlocks.DIAMOND_LOG.get())
                .add(ModBlocks.REDSTONE_LOG.get())
                .add(ModBlocks.ANCIENT_LOG.get())
                .add(ModBlocks.QUARTZ_LOG.get())
                .add(ModBlocks.COAL_LOG.get())
                .add(ModBlocks.EMERALD_LOG.get())
        ;

        tag(BlockTags.LEAVES)
                .add(ModBlocks.IRON_LEAVES.get())
                .add(ModBlocks.GOLD_LEAVES.get())
                .add(ModBlocks.COPPER_LEAVES.get())
                .add(ModBlocks.LAPIS_LEAVES.get())
                .add(ModBlocks.DIAMOND_LEAVES.get())
                .add(ModBlocks.REDSTONE_LEAVES.get())
                .add(ModBlocks.ANCIENT_LEAVES.get())
                .add(ModBlocks.QUARTZ_LEAVES.get())
                .add(ModBlocks.COAL_LEAVES.get())
                .add(ModBlocks.EMERALD_LEAVES.get())
        ;

        tag(ModTags.Blocks.ORE_SAPLINGS)
                .add(ModBlocks.IRON_SAPLING.get())
                .add(ModBlocks.GOLD_SAPLING.get())
                .add(ModBlocks.COPPER_SAPLING.get())
                .add(ModBlocks.LAPIS_SAPLING.get())
                .add(ModBlocks.DIAMOND_SAPLING.get())
                .add(ModBlocks.REDSTONE_SAPLING.get())
                .add(ModBlocks.ANCIENT_SAPLING.get())
                .add(ModBlocks.QUARTZ_SAPLING.get())
                .add(ModBlocks.COAL_SAPLING.get())
                .add(ModBlocks.EMERALD_SAPLING.get())
        ;

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.IRON_DIRT.get())
                .add(ModBlocks.GOLD_DIRT.get())
                .add(ModBlocks.COPPER_DIRT.get())
                .add(ModBlocks.LAPIS_DIRT.get())
                .add(ModBlocks.DIAMOND_DIRT.get())
                .add(ModBlocks.ANCIENT_DIRT.get())
                .add(ModBlocks.REDSTONE_DIRT.get())
                .add(ModBlocks.QUARTZ_DIRT.get())
                .add(ModBlocks.COAL_DIRT.get())
                .add(ModBlocks.EMERALD_DIRT.get())

        ;

        tag(ModTags.Blocks.ORE_LOG)
                .add(ModBlocks.IRON_LOG.get())
                .add(ModBlocks.GOLD_LOG.get())
                .add(ModBlocks.COPPER_LOG.get())
                .add(ModBlocks.LAPIS_LOG.get())
                .add(ModBlocks.DIAMOND_LOG.get())
                .add(ModBlocks.REDSTONE_LOG.get())
                .add(ModBlocks.ANCIENT_LOG.get())
                .add(ModBlocks.QUARTZ_LOG.get())
                .add(ModBlocks.COAL_LOG.get())
                .add(ModBlocks.EMERALD_LOG.get())
        ;

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(ModBlocks.ORE_TREE_CRAFTER.get())
                .add(ModBlocks.ORE_TREE_RECONSTRUCTOR.get())
                .add(ModBlocks.RESOURCE_PROCESSOR.get());
    }
}
