package org.mob.ore_trees_reboot.screen;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.extensions.IMenuTypeExtension;
import net.neoforged.neoforge.network.IContainerFactory;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.screen.custom.OreTreeReconstructorMenu;
import org.mob.ore_trees_reboot.screen.custom.ResourceProcessorMenu;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENUS =
            DeferredRegister.create(Registries.MENU, Ore_trees_reboot.MOD_ID);


    public static final DeferredHolder<MenuType<?>, MenuType<OreTreeReconstructorMenu>> ORE_TREE_RECONSTRUCTOR_MENU =
            registerMenuType("ore_tree_reconstructor_menu", OreTreeReconstructorMenu::new);

    public static final DeferredHolder<MenuType<?>, MenuType<ResourceProcessorMenu>> RESOURCE_PROCESSOR_MENU =
            registerMenuType("resource_processor_menu", ResourceProcessorMenu::new);

    private static <T extends AbstractContainerMenu>DeferredHolder<MenuType<?>, MenuType<T>> registerMenuType(String name,
                                                                                                              IContainerFactory<T> factory) {
        return MENUS.register(name, () -> IMenuTypeExtension.create(factory));
    }

    public static void register(IEventBus eventBus) {
        MENUS.register(eventBus);
    }
}
