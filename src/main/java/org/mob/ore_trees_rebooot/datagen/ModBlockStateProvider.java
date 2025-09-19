package org.mob.ore_trees_rebooot.datagen;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;
import org.mob.ore_trees_rebooot.Ore_trees_reboot;
import org.mob.ore_trees_rebooot.block.ModBlocks;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, Ore_trees_reboot.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        logBlock((RotatedPillarBlock) ModBlocks.IRON_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.GOLD_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.COPPER_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.LAPIS_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.DIAMOND_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.REDSTONE_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.ANCIENT_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.QUARTZ_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.COAL_LOG.get());
        logBlock((RotatedPillarBlock) ModBlocks.EMERALD_LOG.get());

        blockItem(ModBlocks.IRON_LOG);
        blockItem(ModBlocks.GOLD_LOG);
        blockItem(ModBlocks.COPPER_LOG);
        blockItem(ModBlocks.LAPIS_LOG);
        blockItem(ModBlocks.REDSTONE_LOG);
        blockItem(ModBlocks.ANCIENT_LOG);
        blockItem(ModBlocks.DIAMOND_LOG);
        blockItem(ModBlocks.COAL_LOG);
        blockItem(ModBlocks.QUARTZ_LOG);
        blockItem(ModBlocks.EMERALD_LOG);

        saplingBlock(ModBlocks.IRON_SAPLING);
        saplingBlock(ModBlocks.GOLD_SAPLING);
        saplingBlock(ModBlocks.COPPER_SAPLING);
        saplingBlock(ModBlocks.LAPIS_SAPLING);
        saplingBlock(ModBlocks.REDSTONE_SAPLING);
        saplingBlock(ModBlocks.DIAMOND_SAPLING);
        saplingBlock(ModBlocks.ANCIENT_SAPLING);
        saplingBlock(ModBlocks.QUARTZ_SAPLING);
        saplingBlock(ModBlocks.COAL_SAPLING);
        saplingBlock(ModBlocks.EMERALD_SAPLING);

        leavesBlock(ModBlocks.IRON_LEAVES);
        leavesBlock(ModBlocks.GOLD_LEAVES);
        leavesBlock(ModBlocks.COPPER_LEAVES);
        leavesBlock(ModBlocks.LAPIS_LEAVES);
        leavesBlock(ModBlocks.REDSTONE_LEAVES);
        leavesBlock(ModBlocks.DIAMOND_LEAVES);
        leavesBlock(ModBlocks.QUARTZ_LEAVES);
        leavesBlock(ModBlocks.ANCIENT_LEAVES);
        leavesBlock(ModBlocks.COAL_LEAVES);
        leavesBlock(ModBlocks.EMERALD_LEAVES);

    }

    private void leavesBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlockWithItem(blockRegistryObject.get(),
                models().singleTexture(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), ResourceLocation.parse("minecraft:block/leaves"),
                        "all", blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void saplingBlock(DeferredBlock<Block> blockRegistryObject) {
        simpleBlock(blockRegistryObject.get(),
                models().cross(BuiltInRegistries.BLOCK.getKey(blockRegistryObject.get()).getPath(), blockTexture(blockRegistryObject.get())).renderType("cutout"));
    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("ore_trees_reboot:block/" + deferredBlock.getId().getPath()));
    }

    private void blockItem(DeferredBlock<?> deferredBlock, String appendix) {
        simpleBlockItem(deferredBlock.get(), new ModelFile.UncheckedModelFile("ore_trees_reboot:block/" + deferredBlock.getId().getPath() + appendix));
    }
}
