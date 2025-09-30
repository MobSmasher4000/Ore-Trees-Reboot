//package org.mob.ore_trees_reboot.datagen.builder;
//
//import net.minecraft.advancements.Advancement;
//import net.minecraft.advancements.AdvancementRequirements;
//import net.minecraft.advancements.AdvancementRewards;
//import net.minecraft.advancements.Criterion;
//import net.minecraft.advancements.critereon.RecipeUnlockedTrigger;
//import net.minecraft.data.recipes.RecipeBuilder;
//import net.minecraft.data.recipes.RecipeOutput;
//import net.minecraft.resources.ResourceLocation;
//import net.minecraft.world.item.Item;
//import net.minecraft.world.item.ItemStack;
//import net.minecraft.world.item.Items;
//import net.minecraft.world.item.crafting.Ingredient;
//import net.neoforged.neoforge.common.crafting.SizedIngredient;
//import org.jetbrains.annotations.Nullable;
//import org.mob.ore_trees_reboot.recipe.OreTreeCrafterRecipe;
//import org.mob.ore_trees_reboot.recipe.ResourceProcessorRecipe;
//
//import java.util.ArrayList;
//import java.util.LinkedHashMap;
//import java.util.List;
//import java.util.Map;
//
//public class ResourceProcessorRecipeBuilder implements RecipeBuilder {
//    private Ingredient ingredients;
//    private final List<ItemStack> outputs = new ArrayList<>();
//    private final Map<String, Criterion<?>> criteria = new LinkedHashMap<>();
//    @Nullable
//    private String group;
//
//    public static ResourceProcessorRecipeBuilder resourceProcessorRecipe() {
//        return new ResourceProcessorRecipeBuilder();
//    }
//
//    private ResourceProcessorRecipeBuilder(Ingredient ingredients) {
//        // Private constructor to enforce the use of the static factory method
//        this.ingredients = ingredients;
//    }
//
//    public ResourceProcessorRecipeBuilder addIngredient(Ingredient ingredient) {
//        this.ingredients=(ingredient);
//        return this;
//    }
//
//    public ResourceProcessorRecipeBuilder addOutput(ItemStack output) {
//        this.outputs.add(output);
//        return this;
//    }
//
//    @Override
//    public RecipeBuilder unlockedBy(String s, Criterion<?> criterion) {
//        this.criteria.put(s, criterion);
//        return this;
//    }
//
//    @Override
//    public RecipeBuilder group(@Nullable String s) {
//        this.group = s;
//        return this;
//    }
//
//    @Override
//    public Item getResult() {
//        return this.outputs.isEmpty() ? Items.AIR : this.outputs.get(0).getItem();
//    }
//
//    @Override
//    public void save(RecipeOutput recipeOutput, ResourceLocation resourceLocation) {
//        Advancement.Builder advancement = recipeOutput.advancement()
//                .addCriterion("has_the_recipe", RecipeUnlockedTrigger.unlocked(resourceLocation))
//                .rewards(AdvancementRewards.Builder.recipe(resourceLocation))
//                .requirements(AdvancementRequirements.Strategy.OR);
//        this.criteria.forEach(advancement::addCriterion);
//
//        // Create the recipe instance
//        ResourceProcessorRecipe recipe = new ResourceProcessorRecipe(
//                this.ingredients,
//                this.outputs
//        );
//
//        // Pass the recipe and advancement to the output
//        recipeOutput.accept(resourceLocation, recipe, advancement.build(resourceLocation.withPrefix("recipes/")));
//    }
//}