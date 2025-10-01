package org.mob.ore_trees_reboot.compat;

import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.Nullable;
import org.mob.ore_trees_reboot.block.ModBlocks;
import org.mob.ore_trees_reboot.recipe.OreTreeCrafterRecipe;

import static org.mob.ore_trees_reboot.Ore_trees_reboot.resourceLocation;

public class OreTreeCrafterRecipeCategory implements IRecipeCategory<OreTreeCrafterRecipe> {
    public static final ResourceLocation UID = resourceLocation("ore_tree_crafter");
    public static final ResourceLocation TEXTURE = resourceLocation("textures/gui/jei/ore_tree_crafter_gui.png");
    public static final RecipeType<OreTreeCrafterRecipe> ORE_TREE_CRAFTER_RECIPE_TYPE = new RecipeType<>(UID, OreTreeCrafterRecipe.class);
    private int tickCount = 0;

    private final IDrawable background;
    private final IDrawable icon;

    public OreTreeCrafterRecipeCategory(IGuiHelper helper){
        this.background = helper.createDrawable(TEXTURE, 5, 5, 200, 95);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocks.ORE_TREE_CRAFTER.get()));
    }

    @Override
    public RecipeType<OreTreeCrafterRecipe> getRecipeType() {
        return ORE_TREE_CRAFTER_RECIPE_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.ore_trees_reboot.ore_tree_crafter");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public @Nullable IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, OreTreeCrafterRecipe recipe, IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 85 - 5, 48 - 5).addItemStack(new ItemStack(recipe.getInputItems().get(0).getItems()[0].getItem(), recipe.getInputItems().get(0).count()));

        builder.addSlot(RecipeIngredientRole.INPUT, 59 - 5, 23 - 5).addItemStack(new ItemStack(recipe.getInputItems().get(1).getItems()[0].getItem(), recipe.getInputItems().get(1).count()));
        builder.addSlot(RecipeIngredientRole.INPUT, 84 - 5, 20 - 5).addItemStack(new ItemStack(recipe.getInputItems().get(2).getItems()[0].getItem(), recipe.getInputItems().get(2).count()));
        builder.addSlot(RecipeIngredientRole.INPUT, 109 - 5, 23 - 5).addItemStack(new ItemStack(recipe.getInputItems().get(3).getItems()[0].getItem(), recipe.getInputItems().get(3).count()));
        builder.addSlot(RecipeIngredientRole.INPUT, 56 - 5, 48 - 5).addItemStack(new ItemStack(recipe.getInputItems().get(4).getItems()[0].getItem(), recipe.getInputItems().get(4).count()));
        builder.addSlot(RecipeIngredientRole.INPUT, 111 - 5, 48 - 5).addItemStack(new ItemStack(recipe.getInputItems().get(5).getItems()[0].getItem(), recipe.getInputItems().get(5).count()));
        builder.addSlot(RecipeIngredientRole.INPUT, 59 - 5, 73 - 5).addItemStack(new ItemStack(recipe.getInputItems().get(6).getItems()[0].getItem(), recipe.getInputItems().get(6).count()));
        builder.addSlot(RecipeIngredientRole.INPUT, 84 - 5, 76 - 5).addItemStack(new ItemStack(recipe.getInputItems().get(7).getItems()[0].getItem(), recipe.getInputItems().get(7).count()));
        builder.addSlot(RecipeIngredientRole.INPUT, 109 - 5, 73 - 5).addItemStack(new ItemStack(recipe.getInputItems().get(8).getItems()[0].getItem(), recipe.getInputItems().get(8).count()));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 167 - 5, 49 - 5).addItemStack(recipe.getOutput().getFirst());
    }
}