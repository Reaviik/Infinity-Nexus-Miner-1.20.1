import com.google.gson.*;

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Map;

public class CraftingRecipeConverter {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public static void main(String[] args) {
        // Caminho para a pasta de receitas (ajuste conforme necessário)
        Path recipesFolder = Paths.get("D:/desktop/NeoForge-Infinity-Nexus-Mod-1.21.5/src/main/resources/data/infinity_nexus_mod/recipe/preassawd");

        try {
            Files.walkFileTree(recipesFolder, new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (file.toString().endsWith(".json")) {
                        convertRecipe(file);
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
            System.out.println("Conversão concluída com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao processar receitas: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void convertRecipe(Path recipeFile) throws IOException {
        try (Reader reader = Files.newBufferedReader(recipeFile)) {
            JsonObject recipe = JsonParser.parseReader(reader).getAsJsonObject();

            // Verifica se é uma receita de crafting shaped
            if (recipe.has("type") && recipe.get("type").getAsString().equals("minecraft:crafting_shaped")) {
                JsonObject convertedRecipe = new JsonObject();

                // Copia todos os campos existentes
                for (Map.Entry<String, JsonElement> entry : recipe.entrySet()) {
                    String key = entry.getKey();

                    // Converte o campo 'key' se existir
                    if (key.equals("key") && entry.getValue().isJsonObject()) {
                        JsonObject convertedKey = convertKeyObject(entry.getValue().getAsJsonObject());
                        convertedRecipe.add("key", convertedKey);
                    } else {
                        convertedRecipe.add(key, entry.getValue());
                    }
                }

                // Escreve o arquivo convertido
                try (Writer writer = Files.newBufferedWriter(recipeFile)) {
                    gson.toJson(convertedRecipe, writer);
                }

                System.out.println("Convertido: " + recipeFile);
            }
        } catch (Exception e) {
            System.err.println("Erro ao converter " + recipeFile + ": " + e.getMessage());
        }
    }

    private static JsonObject convertKeyObject(JsonObject keyObject) {
        JsonObject convertedKey = new JsonObject();

        for (Map.Entry<String, JsonElement> entry : keyObject.entrySet()) {
            String keyChar = entry.getKey();
            JsonElement value = entry.getValue();

            if (value.isJsonObject()) {
                JsonObject valueObj = value.getAsJsonObject();

                if (valueObj.has("tag")) {
                    // Converte tag para formato simplificado
                    convertedKey.addProperty(keyChar, "#" + valueObj.get("tag").getAsString());
                } else if (valueObj.has("item")) {
                    // Converte item para formato simplificado
                    convertedKey.addProperty(keyChar, valueObj.get("item").getAsString());
                } else {
                    // Mantém outros formatos como estão
                    convertedKey.add(keyChar, value);
                }
            } else {
                // Mantém valores não-objeto como estão
                convertedKey.add(keyChar, value);
            }
        }

        return convertedKey;
    }
}