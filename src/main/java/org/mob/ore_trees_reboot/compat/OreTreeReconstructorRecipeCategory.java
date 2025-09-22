package org.mob.ore_trees_reboot.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.Nullable;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.block.ModBlocks;
import org.mob.ore_trees_reboot.recipe.OreTreeReconstructorRecipe;

public class OreTreeReconstructorRecipeCategory implements IRecipeCategory<OreTreeReconstructorRecipe> {
    public static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID, "ore_tree_reconstructor");
    public static final ResourceLocation TEXTURE = ResourceLocation.fromNamespaceAndPath(Ore_trees_reboot.MOD_ID,
            "textures/gui/ore_tree_reconstructor/ore_tree_reconstructor_gui.png");

    public static final RecipeType<OreTreeReconstructorRecipe> ORE_TREE_RECONSTRUCTOR_RECIPE_TYPE =
            new RecipeType<>(UID, OreTreeReconstructorRecipe.class);

    private final IDrawable background;
    private final IDrawable icon;

    public OreTreeReconstructorRecipeCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE,32 ,16, 123, 63);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ORE_TREE_RECONSTRUCTOR));
    }

    @Override
    public RecipeType<OreTreeReconstructorRecipe> getRecipeType() {
        return ORE_TREE_RECONSTRUCTOR_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.ore_trees_reboot.ore_tree_reconstructor");
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return icon;
    }

    @Override
    public @Nullable IDrawable getBackground() {
        return background;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, OreTreeReconstructorRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 22, 18).addIngredients(recipe.getIngredients().get(0));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 72, 18).addItemStack(recipe.getResultItem(null));
    }

}
