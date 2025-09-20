package org.mob.ore_trees_rebooot.util;

import com.google.gson.*;
import java.io.*;
import java.nio.file.*;

public class RecipeCountFixer {
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) throws IOException {
        // Path to recipes folder
        Path recipesDir = Paths.get("src/generated/resources/data/ore_trees_reboot/recipe");

        int newCount = 4; //  new count here

        Files.walk(recipesDir)
                .filter(p -> p.toString().endsWith(".json"))
                .filter(p -> {
                    String name = p.getFileName().toString();
                    return name.contains("_from_smelting_") || name.contains("_from_blasting_");
                })
                .forEach(p -> {
                    try {
                        fixRecipe(p, newCount);
                    } catch (IOException e) {
                        System.err.println("Failed to process " + p + ": " + e.getMessage());
                    }
                });
    }

    private static void fixRecipe(Path file, int count) throws IOException {
        JsonObject json = JsonParser.parseReader(new FileReader(file.toFile())).getAsJsonObject();

        if (json.has("result")) {
            JsonElement result = json.get("result");

            // If "result" is already an object -> add/update "count"
            if (result.isJsonObject()) {
                JsonObject obj = result.getAsJsonObject();
                obj.addProperty("count", count);
            }
            // If "result" is just a string -> replace with object {id, count}
            else if (result.isJsonPrimitive()) {
                String id = result.getAsString();
                JsonObject obj = new JsonObject();
                obj.addProperty("id", id);
                obj.addProperty("count", count);
                json.add("result", obj);
            }

            // Save back
            try (FileWriter writer = new FileWriter(file.toFile())) {
                GSON.toJson(json, writer);
            }
            System.out.println("Updated count in: " + file.getFileName());
        }
    }
}
