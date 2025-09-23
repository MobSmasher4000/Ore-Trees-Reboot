package org.mob.ore_trees_reboot.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.block.custom.ModOreTreeLog;
import org.mob.ore_trees_reboot.block.custom.ModSaplingBlock;
import org.mob.ore_trees_reboot.block.custom.OreTreeReconstructorBlock;
import org.mob.ore_trees_reboot.item.ModItems;
import org.mob.ore_trees_reboot.util.ModTags;
import org.mob.ore_trees_reboot.worldgen.tree.ModTreeGrowers;

import java.util.List;
import java.util.function.Supplier;

import static org.mob.ore_trees_reboot.util.ModTags.Blocks.*;

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
            ()-> new ModSaplingBlock(ModTreeGrowers.IRON_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.IRON_DIRT::get));

    public static final DeferredBlock<Block> GOLD_SAPLING = registerBlock("gold_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.GOLD_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.GOLD_DIRT::get));

    public static final DeferredBlock<Block> COPPER_SAPLING = registerBlock("copper_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.COPPER_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.COPPER_DIRT::get));

    public static final DeferredBlock<Block> LAPIS_SAPLING = registerBlock("lapis_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.LAPIS_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.LAPIS_DIRT::get));

    public static final DeferredBlock<Block> DIAMOND_SAPLING = registerBlock("diamond_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.DIAMOND_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.DIAMOND_DIRT::get));

    public static final DeferredBlock<Block> REDSTONE_SAPLING = registerBlock("redstone_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.REDSTONE_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.REDSTONE_DIRT::get));

    public static final DeferredBlock<Block> QUARTZ_SAPLING = registerBlock("quartz_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.QUARTZ_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.QUARTZ_DIRT::get));

    public static final DeferredBlock<Block> ANCIENT_SAPLING = registerBlock("ancient_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.ANCIENT_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.ANCIENT_DIRT::get));

    public static final DeferredBlock<Block> COAL_SAPLING = registerBlock("coal_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.COAL_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.COAL_DIRT::get));

    public static final DeferredBlock<Block> EMERALD_SAPLING = registerBlock("emerald_sapling",
            ()-> new ModSaplingBlock(ModTreeGrowers.EMERALD_TREE, BlockBehaviour.Properties.ofFullCopy(Blocks.OAK_SAPLING), ModBlocks.EMERALD_DIRT::get));

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


    //    Ore Tree Reconstructor
    public static final DeferredBlock<Block> ORE_TREE_RECONSTRUCTOR = registerBlock("ore_tree_reconstructor",
            ()-> new OreTreeReconstructorBlock(BlockBehaviour.Properties.of()));

//    Ore Tree Dirts
    public static final DeferredBlock<Block> IRON_DIRT = registerBlock("iron_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.iron_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredBlock<Block> COPPER_DIRT = registerBlock("copper_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.copper_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredBlock<Block> GOLD_DIRT = registerBlock("gold_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.gold_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredBlock<Block> LAPIS_DIRT = registerBlock("lapis_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.lapis_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredBlock<Block> DIAMOND_DIRT = registerBlock("diamond_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.diamond_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredBlock<Block> REDSTONE_DIRT = registerBlock("redstone_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.redstone_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredBlock<Block> ANCIENT_DIRT = registerBlock("ancient_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.ancient_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredBlock<Block> QUARTZ_DIRT = registerBlock("quartz_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.quartz_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredBlock<Block> COAL_DIRT = registerBlock("coal_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.coal_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
            }
        });

    public static final DeferredBlock<Block> EMERALD_DIRT = registerBlock("emerald_dirt",
        ()-> new Block(BlockBehaviour.Properties.ofFullCopy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops()){
            @Override
            public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.emerald_dirt"));
                super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
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
