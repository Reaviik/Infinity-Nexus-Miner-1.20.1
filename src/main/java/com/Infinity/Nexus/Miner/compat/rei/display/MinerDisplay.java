package com.Infinity.Nexus.Miner.compat.rei.display;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.recipes.MinerRecipe;
import com.Infinity.Nexus.Miner.recipes.ModRecipes;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.display.Display;
import me.shedaniel.rei.api.common.display.DisplaySerializer;
import me.shedaniel.rei.api.common.entry.EntryIngredient;
import me.shedaniel.rei.api.common.util.EntryIngredients;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeHolder;

import java.util.List;
import java.util.Optional;

public record MinerDisplay(RecipeHolder<MinerRecipe> recipe) implements Display {
    public static final CategoryIdentifier<MinerDisplay> CATEGORY = CategoryIdentifier.of(InfinityNexusMiner.MOD_ID, "mining");
    public static final DisplaySerializer<? extends MinerDisplay> SERIALIZER = DisplaySerializer.of(
            RecordCodecBuilder.mapCodec((instance) -> {
                return instance.group(
                        ResourceLocation.CODEC.fieldOf("recipeId").forGetter(display -> {
                            return display.recipe.id().location();
                        }),
                        ModRecipes.MINER_RECIPE_SERIALIZER.get().codec().fieldOf("ingredient").forGetter(display -> {
                            return display.recipe.value();
                        })
                ).apply(instance, (recipeId, recipe) -> new MinerDisplay(new RecipeHolder<>(
                        ResourceKey.create(Registries.RECIPE, recipeId), recipe
                )));
            }),
            StreamCodec.composite(
                    ResourceLocation.STREAM_CODEC,
                    display -> display.recipe.id().location(),
                    ModRecipes.MINER_RECIPE_SERIALIZER.get().streamCodec(),
                    display -> display.recipe.value(),
                    (recipeId, recipe) -> new MinerDisplay(new RecipeHolder<>(
                            ResourceKey.create(Registries.RECIPE, recipeId), recipe
                    ))
            )
    );

    @Override
    public List<EntryIngredient> getInputEntries() {
        return List.of(
                EntryIngredients.ofIngredient(recipe.value().getIngredient())
        );
    }

    @Override
    public List<EntryIngredient> getOutputEntries() {
        return List.of(
                EntryIngredients.of(recipe.value().getResultItem())
        );
    }

    @Override
    public CategoryIdentifier<MinerDisplay> getCategoryIdentifier() {
        return CATEGORY;
    }

    @Override
    public Optional<ResourceLocation> getDisplayLocation() {
        return Optional.of(recipe.id().location());
    }

    @Override
    public DisplaySerializer<? extends MinerDisplay> getSerializer() {
        return SERIALIZER;
    }

    public List<EntryIngredient> getTierEntries() {
        return List.of(
                EntryIngredients.ofIngredient(recipe.value().getTier())
        );
    }

}