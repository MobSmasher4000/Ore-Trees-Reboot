package org.mob.ore_trees_reboot.item;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.component.ModDataComponents;
import org.mob.ore_trees_reboot.item.custom.UpgradeItem;

import java.util.List;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ore_trees_reboot.MOD_ID);

    public static final DeferredItem<Item> Crafting_Base = ITEMS.register("crafting_base",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ORE_TREE_SHARD = ITEMS.register("ore_tree_shard",
            ()-> new Item(new Item.Properties()){
                @Override
                public void appendHoverText(ItemStack stack, TooltipContext context, List<Component> tooltipComponents, TooltipFlag tooltipFlag) {
                    tooltipComponents.add(Component.translatable("tooltip.ore_trees_reboot.ore_tree_shard"));
                    super.appendHoverText(stack, context, tooltipComponents, tooltipFlag);
                }
            });

    // Upgrades
    public static final DeferredItem<Item> UPGRADE_BASE = ITEMS.register("upgrade_base",
            ()-> new Item(new Item.Properties().stacksTo(16)));

//    Speed upgrades
    public static final DeferredItem<Item> UPGRADE_SPEED_TIER_1 = ITEMS.register("upgrade_speed_tier_1",
            ()-> new UpgradeItem(new Item.Properties(), 80,1));

    public static final DeferredItem<Item> UPGRADE_SPEED_TIER_2 = ITEMS.register("upgrade_speed_tier_2",
            ()-> new UpgradeItem(new Item.Properties(), 60,1));

    public static final DeferredItem<Item> UPGRADE_SPEED_TIER_3 = ITEMS.register("upgrade_speed_tier_3",
            ()-> new UpgradeItem(new Item.Properties(), 40,1));

    public static final DeferredItem<Item> UPGRADE_SPEED_TIER_4 = ITEMS.register("upgrade_speed_tier_4",
            ()-> new UpgradeItem(new Item.Properties(), 20,1));


//    Amount upgrades
    public static final DeferredItem<Item> UPGRADE_AMOUNT_TIER_1 = ITEMS.register("upgrade_amount_tier_1",
            ()-> new UpgradeItem(new Item.Properties(),100, 2));

    public static final DeferredItem<Item> UPGRADE_AMOUNT_TIER_2 = ITEMS.register("upgrade_amount_tier_2",
            ()-> new UpgradeItem(new Item.Properties(), 100, 4));

    public static final DeferredItem<Item> UPGRADE_AMOUNT_TIER_3 = ITEMS.register("upgrade_amount_tier_3",
            ()-> new UpgradeItem(new Item.Properties(), 100, 8));

    public static final DeferredItem<Item> UPGRADE_AMOUNT_TIER_4 = ITEMS.register("upgrade_amount_tier_4",
            ()-> new UpgradeItem(new Item.Properties(), 100, 16));

    public static final DeferredItem<Item> UPGRADE_AMOUNT_TIER_5 = ITEMS.register("upgrade_amount_tier_5",
            ()-> new UpgradeItem(new Item.Properties(), 100, 32));

    public static final DeferredItem<Item> UPGRADE_AMOUNT_TIER_6 = ITEMS.register("upgrade_amount_tier_6",
            ()-> new UpgradeItem(new Item.Properties(), 100, 64));

//    speed-amount upgrades
    public static final DeferredItem<Item> UPGRADE_TIER_1 = ITEMS.register("upgrade_tier_1",
        ()->new UpgradeItem(new Item.Properties(), 20, 2));

    public static final DeferredItem<Item> UPGRADE_TIER_2 = ITEMS.register("upgrade_tier_2",
        ()->new UpgradeItem(new Item.Properties(), 20, 4));

    public static final DeferredItem<Item> UPGRADE_TIER_3 = ITEMS.register("upgrade_tier_3",
        ()->new UpgradeItem(new Item.Properties(), 20, 8));

    public static final DeferredItem<Item> UPGRADE_TIER_4 = ITEMS.register("upgrade_tier_4",
        ()->new UpgradeItem(new Item.Properties(), 20, 16));

    public static final DeferredItem<Item> UPGRADE_TIER_5 = ITEMS.register("upgrade_tier_5",
        ()->new UpgradeItem(new Item.Properties(), 20, 32));

    public static final DeferredItem<Item> UPGRADE_TIER_6 = ITEMS.register("upgrade_tier_6",
        ()->new UpgradeItem(new Item.Properties(), 20, 64));


    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
