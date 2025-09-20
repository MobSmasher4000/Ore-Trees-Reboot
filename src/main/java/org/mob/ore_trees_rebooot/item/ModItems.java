package org.mob.ore_trees_rebooot.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.mob.ore_trees_rebooot.Ore_trees_reboot;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(Ore_trees_reboot.MOD_ID);

    public static final DeferredItem<Item> Crafting_Base = ITEMS.register("crafting_base",
            ()-> new Item(new Item.Properties()));

    public static final DeferredItem<Item> ORE_TREE_SHARD = ITEMS.register("ore_tree_shard",
            ()-> new Item(new Item.Properties()));

    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }
}
