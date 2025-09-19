package org.mob.ore_trees_rebooot.worldgen.tree;

import net.minecraft.world.level.block.grower.TreeGrower;
import org.mob.ore_trees_rebooot.Ore_trees_reboot;
import org.mob.ore_trees_rebooot.worldgen.ModConfiguredFeatures;

import java.util.Optional;

public class ModTreeGrowers {
    public static final TreeGrower IRON_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.IRON_TREE_KEY),Optional.empty());

    public static final TreeGrower GOLD_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.GOLD_TREE_KEY),Optional.empty());

    public static final TreeGrower COPPER_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.COPPER_TREE_KEY),Optional.empty());

    public static final TreeGrower LAPIS_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.LAPIS_TREE_KEY),Optional.empty());

    public static final TreeGrower DIAMOND_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.DIAMOND_TREE_KEY),Optional.empty());

    public static final TreeGrower REDSTONE_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.REDSTONE_TREE_KEY),Optional.empty());

    public static final TreeGrower ANCIENT_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.ANCIENT_TREE_KEY),Optional.empty());

    public static final TreeGrower COAL_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.COAL_TREE_KEY),Optional.empty());

    public static final TreeGrower EMERALD_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.EMERALD_TREE_KEY),Optional.empty());

    public static final TreeGrower QUARTZ_TREE = new TreeGrower(Ore_trees_reboot.MOD_ID+"iron_tree",
            Optional.empty(),Optional.of(ModConfiguredFeatures.QUARTZ_TREE_KEY),Optional.empty());


}
