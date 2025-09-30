package org.mob.ore_trees_reboot.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.mob.ore_trees_reboot.component.ModDataComponents;

import java.util.List;

public class UpgradeItem extends Item {
    private boolean glint = false;

    public UpgradeItem(Properties properties){
        super(properties);
        this.glint = false;
    }

    public UpgradeItem(Properties properties, boolean glint) {
        super(properties);
        this.glint = glint;
    }

    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {

        if ((stack.get(ModDataComponents.AMOUNT)) != null){
            tooltipComponents.add(Component.literal("Per Cycle Processed : " + stack.get(ModDataComponents.AMOUNT) + " items"));
        }

        if ((stack.get(ModDataComponents.SPEED)) != null){
            tooltipComponents.add(Component.literal("Speed : " + stack.get(ModDataComponents.SPEED) + " ticks"));
            tooltipComponents.add(Component.literal("Speed : " + stack.get(ModDataComponents.SPEED)/20 + " sec"));
        }

        super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
    }

    @Override
    public boolean isFoil(ItemStack stack) {
        return glint;
    }
}
