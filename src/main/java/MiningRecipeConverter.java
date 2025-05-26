

import com.google.gson.*;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

public class MiningRecipeConverter {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        Path recipesFolder = Paths.get("D:/desktop/NeoForge-Infinity-Nexus-Miner-1.21.5/src/main/resources/data/infinity_nexus_miner/recipe/minader");

        try {
            Files.walkFileTree(recipesFolder, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".json")) {
                        convertMiningRecipe(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println("Conversão de receitas miner concluída com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao processar receitas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void convertMiningRecipe(Path recipeFile) throws IOException {
        try (Reader reader = Files.newBufferedReader(recipeFile)) {
            JsonObject recipe = JsonParser.parseReader(reader).getAsJsonObject();

            if (recipe.has("type") && recipe.get("type").getAsString().equals("infinity_nexus_miner:mining")) {

                // 1. Converter level
                if (recipe.has("level")) {
                    JsonObject levelObj = recipe.getAsJsonObject("level");
                    if (levelObj.has("tag")) {
                        String tag = levelObj.get("tag").getAsString();
                        recipe.addProperty("level", "#" + tag);
                    }
                }

                // 2. Converter ingredient
                if (recipe.has("ingredient")) {
                    JsonElement ingredient = recipe.get("ingredient");
                    if (ingredient.isJsonArray()) {
                        JsonArray array = ingredient.getAsJsonArray();
                        if (array.size() == 1 && array.get(0).isJsonObject()) {
                            JsonObject obj = array.get(0).getAsJsonObject();
                            if (obj.has("tag")) {
                                recipe.addProperty("ingredient", "#" + obj.get("tag").getAsString());
                            } else if (obj.has("item")) {
                                recipe.addProperty("ingredient", obj.get("item").getAsString());
                            }
                        }
                    }
                }

                // 3. Escrever de volta no arquivo
                try (JsonWriter writer = new JsonWriter(Files.newBufferedWriter(recipeFile))) {
                    writer.setIndent("  ");
                    gson.toJson(recipe, writer);
                }

                System.out.println("Convertido: " + recipeFile);
            }

        } catch (Exception e) {
            System.err.println("Erro ao converter " + recipeFile + ": " + e.getMessage());
            e.printStackTrace();
        }
    }
}
