package org.mob.ore_trees_rebooot.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static org.mob.ore_trees_rebooot.Ore_trees_reboot.resourceLocation;

public class ModTags {
    public static class Blocks{
        public static final TagKey<Block> IRON_TREE_DIRT = createTag("iron_tree_dirt");
        public static final TagKey<Block> GOLD_TREE_DIRT = createTag("gold_tree_dirt");
        public static final TagKey<Block> COPPER_TREE_DIRT = createTag("copper_tree_dirt");
        public static final TagKey<Block> LAPIS_TREE_DIRT = createTag("lapis_tree_dirt");
        public static final TagKey<Block> DIAMOND_TREE_DIRT = createTag("diamond_tree_dirt");
        public static final TagKey<Block> REDSTONE_TREE_DIRT = createTag("redstone_tree_dirt");
        public static final TagKey<Block> QUARTZ_TREE_DIRT = createTag("quartz_tree_dirt");
        public static final TagKey<Block> ANCIENT_TREE_DIRT = createTag("ancient_tree_dirt");
        public static final TagKey<Block> COAL_TREE_DIRT = createTag("coal_tree_dirt");
        public static final TagKey<Block> EMERALD_TREE_DIRT = createTag("emerald_tree_dirt");

        public static final TagKey<Block> ORE_LOG = createTag("ore_log");
        public static final TagKey<Block> ORE_LEAVES = createTag("ore_leaves");
        public static final TagKey<Block> ORE_SAPLINGS = createTag("ore_saplings");

        public static TagKey<Block> createTag(String name){
            return BlockTags.create(resourceLocation(name));
        }
    }

    public static class Items{

        public static TagKey<Item> createTag(String name){
            return ItemTags.create(resourceLocation(name));
        }

    }

}
