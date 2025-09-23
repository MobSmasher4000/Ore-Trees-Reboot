package org.mob.ore_trees_reboot.worldgen;

import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.TreeConfiguration;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.featuresize.TwoLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.BlobFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.foliageplacers.MegaJungleFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.ForkingTrunkPlacer;
import net.minecraft.world.level.levelgen.feature.trunkplacers.MegaJungleTrunkPlacer;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.block.ModBlocks;
import org.mob.ore_trees_reboot.util.ModTags;

import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final ResourceKey<ConfiguredFeature<?, ?>> IRON_TREE_KEY = registerKey("iron_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GOLD_TREE_KEY = registerKey("gold_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COPPER_TREE_KEY = registerKey("copper_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAPIS_TREE_KEY = registerKey("lapis_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DIAMOND_TREE_KEY = registerKey("diamond_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> REDSTONE_TREE_KEY = registerKey("redstone_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> QUARTZ_TREE_KEY = registerKey("quartz_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANCIENT_TREE_KEY = registerKey("ancient_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COAL_TREE_KEY = registerKey("coal_tree");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EMERALD_TREE_KEY = registerKey("emerald_tree");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

//        registerTree(context, ORE_TREE_KEY, ModBlocks.ORE_LOG.get(), ModBlocks.ORE_LEAVES.get(), DIRT_BLOCK);
        registerTree(context, IRON_TREE_KEY, ModBlocks.IRON_LOG.get(), ModBlocks.IRON_LEAVES.get(), ModBlocks.IRON_DIRT.get());
        registerTree(context, GOLD_TREE_KEY, ModBlocks.GOLD_LOG.get(), ModBlocks.GOLD_LEAVES.get(), ModBlocks.GOLD_DIRT.get());
        registerTree(context, COPPER_TREE_KEY, ModBlocks.COPPER_LOG.get(), ModBlocks.COPPER_LEAVES.get(), ModBlocks.COPPER_DIRT.get());
        registerTree(context, LAPIS_TREE_KEY, ModBlocks.LAPIS_LOG.get(), ModBlocks.LAPIS_LEAVES.get(), ModBlocks.LAPIS_DIRT.get());
        registerTree(context, DIAMOND_TREE_KEY, ModBlocks.DIAMOND_LOG.get(), ModBlocks.DIAMOND_LEAVES.get(), ModBlocks.DIAMOND_DIRT.get());
        registerTree(context, REDSTONE_TREE_KEY, ModBlocks.REDSTONE_LOG.get(), ModBlocks.REDSTONE_LEAVES.get(), ModBlocks.REDSTONE_DIRT.get());
        registerTree(context, QUARTZ_TREE_KEY, ModBlocks.QUARTZ_LOG.get(), ModBlocks.QUARTZ_LEAVES.get(), ModBlocks.QUARTZ_DIRT.get());
        registerTree(context, ANCIENT_TREE_KEY, ModBlocks.ANCIENT_LOG.get(), ModBlocks.ANCIENT_LEAVES.get(), ModBlocks.ANCIENT_DIRT.get());
        registerTree(context, COAL_TREE_KEY, ModBlocks.COAL_LOG.get(), ModBlocks.COAL_LEAVES.get(), ModBlocks.COAL_DIRT.get());
        registerTree(context, EMERALD_TREE_KEY, ModBlocks.EMERALD_LOG.get(), ModBlocks.EMERALD_LEAVES.get(), ModBlocks.EMERALD_DIRT.get());

    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

    private static void registerTree(BootstrapContext<ConfiguredFeature<?, ?>> context, ResourceKey<ConfiguredFeature<?, ?>> key, Block log, Block leaves, Block dirt){
        register(context, key, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(log),
                new ForkingTrunkPlacer(8, 6, 5),
                BlockStateProvider.simple(leaves),
                new BlobFoliagePlacer(ConstantInt.of(3), ConstantInt.of(3), 4),

                new TwoLayersFeatureSize(1, 0, 2))
                .dirt(BlockStateProvider.simple(dirt))
                .forceDirt()
                .build());
    }
}
