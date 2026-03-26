package org.mob.ore_trees_reboot.item.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import org.mob.ore_trees_reboot.component.ModDataComponents;

import java.util.List;

public class UpgradeItem extends Item {
    public UpgradeItem(Properties properties,int speed, int amount) {
        super(properties.stacksTo(16)
                .component(ModDataComponents.SPEED, speed)
                .component(ModDataComponents.AMOUNT, amount));
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
}
