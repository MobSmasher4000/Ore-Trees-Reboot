package org.mob.ore_trees_reboot.compat;

import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.RecipeHolder;
import net.minecraft.world.item.crafting.RecipeManager;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.block.ModBlocks;
import org.mob.ore_trees_reboot.recipe.ModRecipes;
import org.mob.ore_trees_reboot.recipe.OreTreeReconstructorRecipe;
import org.mob.ore_trees_reboot.screen.custom.OreTreeReconstructorScreen;

import java.util.List;

@JeiPlugin
public class JEIOreTreesRebootPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new OreTreeReconstructorRecipeCategory(
                registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<OreTreeReconstructorRecipe> oreTreeReconstructorRecipes = recipeManager
                .getAllRecipesFor(ModRecipes.ORE_TREE_RECONSTRUCTOR_TYPE.get()).stream().map(RecipeHolder::value).toList();
        registration.addRecipes(OreTreeReconstructorRecipeCategory.ORE_TREE_RECONSTRUCTOR_RECIPE_TYPE, oreTreeReconstructorRecipes);

    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(OreTreeReconstructorScreen.class, 74, 30, 22, 20,
                OreTreeReconstructorRecipeCategory.ORE_TREE_RECONSTRUCTOR_RECIPE_TYPE);

    }

    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModBlocks.ORE_TREE_RECONSTRUCTOR.get().asItem()),
                OreTreeReconstructorRecipeCategory.ORE_TREE_RECONSTRUCTOR_RECIPE_TYPE);
    }
}
