package com.Infinity.Nexus.Miner.compat;

import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.compat.rei.category.MinerCategory;
import com.Infinity.Nexus.Miner.compat.rei.display.MinerDisplay;
import com.Infinity.Nexus.Miner.screen.miner.MinerScreen;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.plugins.REIClientPlugin;
import me.shedaniel.rei.api.client.registry.category.CategoryRegistry;
import me.shedaniel.rei.api.client.registry.display.DisplayRegistry;
import me.shedaniel.rei.api.client.registry.screen.ScreenRegistry;
import me.shedaniel.rei.api.common.util.EntryStacks;
import me.shedaniel.rei.forge.REIPluginClient;

@REIPluginClient
public class ReiClientModPlugin implements REIClientPlugin {
    @Override
    public String getPluginProviderName() {
        return "Infinity Nexus Miner";
    }
    @Override
    public void registerCategories(CategoryRegistry registry) {
        registry.add(new MinerCategory());
        registry.addWorkstations(MinerDisplay.CATEGORY, EntryStacks.of(ModBlocksMiner.MINER.get()));
    }
    @Override
    public void registerDisplays(DisplayRegistry registry) {
        registry.add(MinerDisplay.CATEGORY);
    }
    @Override
    public void registerScreens(ScreenRegistry registry) {
        registry.registerContainerClickArea(new Rectangle(162, -10, 7, 8), MinerScreen.class, MinerDisplay.CATEGORY);
    }
}