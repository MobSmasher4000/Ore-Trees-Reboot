package org.mob.ore_trees_reboot.recipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import org.mob.ore_trees_reboot.Ore_trees_reboot;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, Ore_trees_reboot.MOD_ID);
    
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, Ore_trees_reboot.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<OreTreeReconstructorRecipe>> ORE_TREE_RECONSTRUCTOR_SERIALIZER =
            SERIALIZERS.register("ore_tree_reconstructor", OreTreeReconstructorRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<OreTreeReconstructorRecipe>> ORE_TREE_RECONSTRUCTOR_TYPE =
            TYPES.register("ore_tree_reconstructor", () -> new RecipeType<OreTreeReconstructorRecipe>() {
                @Override
                public String toString() {
                    return "ore_tree_reconstructor";
                }
            });

    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}
