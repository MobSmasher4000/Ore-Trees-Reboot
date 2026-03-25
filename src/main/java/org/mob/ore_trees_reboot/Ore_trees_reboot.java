package org.mob.ore_trees_reboot;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.capabilities.Capabilities;
import net.neoforged.neoforge.capabilities.RegisterCapabilitiesEvent;
import net.neoforged.neoforge.client.event.RegisterMenuScreensEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.neoforge.event.server.ServerStartingEvent;
import org.mob.ore_trees_reboot.block.ModBlocks;
import org.mob.ore_trees_reboot.block.entity.ModBlockEntities;
import org.mob.ore_trees_reboot.component.ModDataComponents;
import org.mob.ore_trees_reboot.item.ModItems;
import org.mob.ore_trees_reboot.loot.ModLootModifiers;
import org.mob.ore_trees_reboot.recipe.ModRecipes;
import org.mob.ore_trees_reboot.screen.ModMenuTypes;
import org.mob.ore_trees_reboot.screen.screen.OreTreeCrafterScreen;
import org.mob.ore_trees_reboot.screen.screen.OreTreeReconstructorScreen;
import org.mob.ore_trees_reboot.screen.screen.ResourceProcessorScreen;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(Ore_trees_reboot.MOD_ID)
public class Ore_trees_reboot {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "ore_trees_reboot";
    // Directly reference a slf4j logger
    public static final Logger LOGGER = LogUtils.getLogger();

    public Ore_trees_reboot(IEventBus modEventBus, ModContainer modContainer) {
        modEventBus.addListener(this::commonSetup);
        modEventBus.addListener(this::onRegisterCapabilities);

        ModItems.register(modEventBus);
        ModBlocks.register(modEventBus);
        ModCreativeModeTab.register(modEventBus);
        ModLootModifiers.register(modEventBus);
        ModBlockEntities.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModMenuTypes.register(modEventBus);
        ModDataComponents.register(modEventBus);

        NeoForge.EVENT_BUS.register(this);

//        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP");
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting");
    }

    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
    @EventBusSubscriber(modid = MOD_ID, bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
    public static class ClientModEvents {
        @SubscribeEvent
        public static void registerScreens(RegisterMenuScreensEvent event) {
            event.register(ModMenuTypes.ORE_TREE_RECONSTRUCTOR_MENU.get(), OreTreeReconstructorScreen::new);
            event.register(ModMenuTypes.RESOURCE_PROCESSOR_MENU.get(), ResourceProcessorScreen::new);
            event.register(ModMenuTypes.ORE_TREE_CRAFTER_MENU.get(), OreTreeCrafterScreen::new);
        }
    }

    public static ResourceLocation resourceLocation(String name){
        return ResourceLocation.fromNamespaceAndPath(MOD_ID,name);
    }

    private void onRegisterCapabilities(RegisterCapabilitiesEvent event) {

        // Resource processor block entity
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                ModBlockEntities.RESOURCE_PROCESSOR_BE.get(),
                (be,side) -> be.getItemHandler(side));

        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK,
                ModBlockEntities.RESOURCE_PROCESSOR_BE.get(),
                (be, side) -> be.getEnergyStorage(side));

//        Ore tree reconstructor
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                ModBlockEntities.ORE_TREE_RECONSTRUCTOR_BE.get(),
                (be, side)-> be.getItemHandler(side));

//        Ore tree crafter
        event.registerBlockEntity(Capabilities.ItemHandler.BLOCK,
                ModBlockEntities.ORE_TREE_CRAFTER_BE.get(),
                (be, side) -> be.getItemHandler(side));

        event.registerBlockEntity(Capabilities.EnergyStorage.BLOCK,
                ModBlockEntities.ORE_TREE_CRAFTER_BE.get(),
                (be, side) -> be.getEnergyStorage(side));
    }

}
