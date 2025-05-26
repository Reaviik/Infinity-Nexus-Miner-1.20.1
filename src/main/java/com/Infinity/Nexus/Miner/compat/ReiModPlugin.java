package com.Infinity.Nexus.Miner.compat;

import com.Infinity.Nexus.Miner.compat.rei.display.MinerDisplay;
import com.Infinity.Nexus.Miner.recipes.MinerRecipe;
import com.Infinity.Nexus.Miner.recipes.ModRecipes;
import me.shedaniel.rei.api.common.display.DisplaySerializerRegistry;
import me.shedaniel.rei.api.common.plugins.REICommonPlugin;
import me.shedaniel.rei.api.common.registry.display.ServerDisplayRegistry;
import me.shedaniel.rei.forge.REIPluginCommon;

@REIPluginCommon
public class ReiModPlugin implements REICommonPlugin {
    @Override
    public String getPluginProviderName() {
        return "Infinity Nexus Miner";
    }

    @Override
    public void registerDisplays(ServerDisplayRegistry registry) {
        registry.beginRecipeFiller(MinerRecipe.class).filterType(ModRecipes.MINER_RECIPE_TYPE.get()).fill(MinerDisplay::new);
    }

    @Override
    public void registerDisplaySerializer(DisplaySerializerRegistry registry) {
        registry.register(MinerDisplay.CATEGORY.getIdentifier(), MinerDisplay.SERIALIZER);
    }
}