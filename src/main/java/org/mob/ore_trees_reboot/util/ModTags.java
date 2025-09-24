package org.mob.ore_trees_reboot.util;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static org.mob.ore_trees_reboot.Ore_trees_reboot.resourceLocation;

public class ModTags {
    public static class Blocks{

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
