package org.mob.ore_trees_rebooot;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.mob.ore_trees_rebooot.block.ModBlocks;
import org.mob.ore_trees_rebooot.item.ModItems;

import static org.mob.ore_trees_rebooot.Ore_trees_reboot.MOD_ID;

public class ModCreativeModeTab {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> CREATIVE_MOD_TAB = CREATIVE_MODE_TABS.register("creative_tab", () -> CreativeModeTab.builder().title(Component.translatable("itemGroup.ore_trees_reboot")).withTabsBefore(CreativeModeTabs.COMBAT).icon(() -> ModItems.Crafting_Base.get().getDefaultInstance()).displayItems((parameters, output) -> {
        output.accept(ModItems.Crafting_Base.get());
        output.accept(ModItems.ORE_TREE_SHARD.get());

        output.accept(ModBlocks.IRON_LEAVES.get());
        output.accept(ModBlocks.GOLD_LEAVES.get());
        output.accept(ModBlocks.COPPER_LEAVES.get());
        output.accept(ModBlocks.LAPIS_LEAVES.get());
        output.accept(ModBlocks.DIAMOND_LEAVES.get());
        output.accept(ModBlocks.REDSTONE_LEAVES.get());
        output.accept(ModBlocks.ANCIENT_LEAVES.get());
        output.accept(ModBlocks.QUARTZ_LEAVES.get());
        output.accept(ModBlocks.COAL_LEAVES.get());
        output.accept(ModBlocks.EMERALD_LEAVES.get());

        output.accept(ModBlocks.IRON_SAPLING.get());
        output.accept(ModBlocks.GOLD_SAPLING.get());
        output.accept(ModBlocks.COPPER_SAPLING.get());
        output.accept(ModBlocks.LAPIS_SAPLING.get());
        output.accept(ModBlocks.DIAMOND_SAPLING.get());
        output.accept(ModBlocks.REDSTONE_SAPLING.get());
        output.accept(ModBlocks.QUARTZ_SAPLING.get());
        output.accept(ModBlocks.ANCIENT_SAPLING.get());
        output.accept(ModBlocks.COAL_SAPLING.get());
        output.accept(ModBlocks.EMERALD_SAPLING.get());

        output.accept(ModBlocks.IRON_LOG.get());
        output.accept(ModBlocks.GOLD_LOG.get());
        output.accept(ModBlocks.COPPER_LOG.get());
        output.accept(ModBlocks.LAPIS_LOG.get());
        output.accept(ModBlocks.DIAMOND_LOG.get());
        output.accept(ModBlocks.REDSTONE_LOG.get());
        output.accept(ModBlocks.QUARTZ_LOG.get());
        output.accept(ModBlocks.ANCIENT_LOG.get());
        output.accept(ModBlocks.COAL_LOG.get());
        output.accept(ModBlocks.EMERALD_LOG.get());
    }).build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
