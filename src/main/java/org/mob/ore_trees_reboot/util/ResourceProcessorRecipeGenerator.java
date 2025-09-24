package org.mob.ore_trees_reboot.util;

import com.google.gson.JsonObject;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import org.mob.ore_trees_reboot.block.ModBlocks;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResourceProcessorRecipeGenerator {

    /**
     * Generates a simple resource processor JSON file.
     *
     * @param inputItem  The input item ID (e.g., "ore_trees_reboot:iron_log")
     * @param outputItem The output item ID (e.g., "minecraft:iron_ingot")
     * @param count      How many items to produce
     * @param recipeId   Name of the JSON file to generate (without .json)
     * @param folder     Folder to save the JSON file
     */
    public static void generateRecipe(String inputItem, String outputItem, int count, String recipeId, File folder) {
        JsonObject json = new JsonObject();

        // Recipe type
        json.addProperty("type", "ore_trees_reboot:resource_processor");

        // Input
        JsonObject ingredient = new JsonObject();
        ingredient.addProperty("item", inputItem);
        json.add("ingredient", ingredient);

        // Output
        JsonObject result = new JsonObject();
        result.addProperty("id", outputItem);
        result.addProperty("count", count);
        json.add("result", result);

        // Ensure folder exists
        folder.mkdirs();

        // Write file
        File file = new File(folder, recipeId + ".json");
        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json.toString());
            System.out.println("Recipe generated: " + file.getAbsolutePath());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        File folder = new File("src/generated/resources/data/ore_trees_reboot/recipe");

        generateRecipe("ore_trees_reboot:iron_log", "minecraft:iron_ingot", 4,
                "iron_ingot_from_iron_log", folder);

        generateRecipe("ore_trees_reboot:gold_log", "minecraft:gold_ingot", 4,
                "gold_ingot_from_gold_log", folder);

        generateRecipe("ore_trees_reboot:copper_log", "minecraft:copper_ingot", 4,
                "copper_ingot_from_copper_log", folder);

        generateRecipe("ore_trees_reboot:diamond_log", "minecraft:diamond", 2,
                "diamond_from_diamond_log", folder);

        generateRecipe("ore_trees_reboot:redstone_log", "minecraft:redstone", 8,
                "redstone_dust_from_redstone_log", folder);

        generateRecipe("ore_trees_reboot:ancient_log", "minecraft:ancient_debris", 1,
                "ancient_debris_from_ancient_log", folder);

        generateRecipe("ore_trees_reboot:coal_log", "minecraft:coal", 8,
                "coal_from_coal_log", folder);

        generateRecipe("ore_trees_reboot:quartz_log", "minecraft:quartz", 4,
                "nether_quartz_from_quartz_log", folder);

        generateRecipe("ore_trees_reboot:emerald_log", "minecraft:emerald", 2,
                "emerald_from_emerald_log", folder);

        generateRecipe("ore_trees_reboot:lapis_log", "minecraft:lapis_lazuli", 8,
                "lapis_lazuli_from_lapis_log", folder);

    }
}
