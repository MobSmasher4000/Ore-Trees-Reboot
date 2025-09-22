package org.mob.ore_trees_reboot.block.entity;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.block.ModBlocks;

import java.util.function.Supplier;

public class ModBlockEntities {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, Ore_trees_reboot.MOD_ID);

    public static final Supplier<BlockEntityType<OreTreeReconstructorBlockEntity>> ORE_TREE_RECONSTRUCTOR_BE =
            BLOCK_ENTITIES.register("ore_tree_reconstructor_be", () -> BlockEntityType.Builder.of(
                    OreTreeReconstructorBlockEntity::new, ModBlocks.ORE_TREE_RECONSTRUCTOR.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}
