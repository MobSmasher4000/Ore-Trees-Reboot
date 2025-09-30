package org.mob.ore_trees_reboot.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.TreeGrower;
import net.minecraft.world.level.block.state.BlockState;

import java.util.List;
import java.util.function.Supplier;

public class ModSaplingBlock extends SaplingBlock {
    private final Supplier<Block> blockToSurviveOn;

    public ModSaplingBlock(TreeGrower treeGrower, Properties properties, Supplier<Block> block) {
        super(treeGrower, properties);
        this.blockToSurviveOn = block;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return blockToSurviveOn.get() == state.getBlock();
    }

    @Override
    public void appendHoverText(ItemStack stack, Item.TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
        tooltipComponents.add(Component.literal("Only placeable on their respective dirt (use jei to see dirts)."));
        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }
}
