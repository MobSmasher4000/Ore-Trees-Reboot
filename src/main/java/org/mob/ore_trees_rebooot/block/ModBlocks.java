package org.mob.ore_trees_rebooot.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.mob.ore_trees_rebooot.Ore_trees_reboot;
import org.mob.ore_trees_rebooot.block.base.ModOreTreeLog;
import org.mob.ore_trees_rebooot.block.base.ModSaplingBlock;
import org.mob.ore_trees_rebooot.item.ModItems;
import org.mob.ore_trees_rebooot.worldgen.tree.ModTreeGrowers;

import java.util.function.Supplier;

public class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(Ore_trees_reboot.MOD_ID);

    // ORE LOGS
    public static final DeferredBlock<Block> IRON_LOG = registerBlock("iron_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> GOLD_LOG = registerBlock("gold_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> COPPER_LOG = registerBlock("copper_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> LAPIS_LOG = registerBlock("lapis_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> DIAMOND_LOG = registerBlock("diamond_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> REDSTONE_LOG = registerBlock("redstone_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> QUARTZ_LOG = registerBlock("quartz_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> ANCIENT_LOG = registerBlock("ancient_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> COAL_LOG = registerBlock("coal_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

    public static final DeferredBlock<Block> EMERALD_LOG = registerBlock("emerald_log",
            ()-> new ModOreTreeLog(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LOG)));

//    ORE SAPLINGS
    public static final DeferredBlock<Block> IRON_SAPLING = registerBlock("iron_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.IRON_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.IRON_BLOCK));

    public static final DeferredBlock<Block> GOLD_SAPLING = registerBlock("gold_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.GOLD_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.GOLD_BLOCK));

    public static final DeferredBlock<Block> COPPER_SAPLING = registerBlock("copper_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.COPPER_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.COPPER_BLOCK));

    public static final DeferredBlock<Block> LAPIS_SAPLING = registerBlock("lapis_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.LAPIS_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.LAPIS_BLOCK));

    public static final DeferredBlock<Block> DIAMOND_SAPLING = registerBlock("diamond_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.DIAMOND_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.DIAMOND_BLOCK));

    public static final DeferredBlock<Block> REDSTONE_SAPLING = registerBlock("redstone_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.REDSTONE_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.REDSTONE_BLOCK));

    public static final DeferredBlock<Block> QUARTZ_SAPLING = registerBlock("quartz_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.QUARTZ_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.QUARTZ_BLOCK));

    public static final DeferredBlock<Block> ANCIENT_SAPLING = registerBlock("ancient_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.ANCIENT_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.NETHERITE_BLOCK));

    public static final DeferredBlock<Block> COAL_SAPLING = registerBlock("coal_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.COAL_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.COAL_BLOCK));

    public static final DeferredBlock<Block> EMERALD_SAPLING = registerBlock("emerald_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.EMERALD_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.JUNGLE_SAPLING), ()-> Blocks.EMERALD_BLOCK));

//    ORE LEAVES
    public static final DeferredBlock<Block> IRON_LEAVES = registerBlock("iron_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> GOLD_LEAVES = registerBlock("gold_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> COPPER_LEAVES = registerBlock("copper_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> LAPIS_LEAVES = registerBlock("lapis_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> DIAMOND_LEAVES = registerBlock("diamond_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> REDSTONE_LEAVES = registerBlock("redstone_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> QUARTZ_LEAVES = registerBlock("quartz_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> ANCIENT_LEAVES = registerBlock("ancient_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> COAL_LEAVES = registerBlock("coal_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });

    public static final DeferredBlock<Block> EMERALD_LEAVES = registerBlock("emerald_leaves",
            ()-> new LeavesBlock(BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_LEAVES)){
                @Override
                public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return true;
                }

                @Override
                public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 60;
                }

                @Override
                public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
                    return 30;
                }
            });



    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
        DeferredBlock<T> toReturn = BLOCKS.register(name,block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
        ModItems.ITEMS.register(name, ()-> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
