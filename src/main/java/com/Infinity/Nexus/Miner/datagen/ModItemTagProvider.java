package com.Infinity.Nexus.Miner.datagen;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;


public class ModItemTagProvider extends ItemTagsProvider {
    public ModItemTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider,
                              CompletableFuture<TagLookup<Block>> blockTags) {
        super(output, lookupProvider, blockTags, InfinityNexusMiner.MOD_ID);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Items.MINER_STRUCTURE)
                .add(Item.byBlock(ModBlocksMiner.WOOD_STRUCTURE.get()))
                .add(Item.byBlock(ModBlocksMiner.STONE_STRUCTURE.get()))
                .add(Item.byBlock(ModBlocksMiner.COPPER_STRUCTURE.get()))
                .add(Item.byBlock(ModBlocksMiner.IRON_STRUCTURE.get()))
                .add(Item.byBlock(ModBlocksMiner.GOLD_STRUCTURE.get()))
                .add(Item.byBlock(ModBlocksMiner.QUARTZ_STRUCTURE.get()))
                .add(Item.byBlock(ModBlocksMiner.DIAMOND_STRUCTURE.get()))
                .add(Item.byBlock(ModBlocksMiner.EMERALD_STRUCTURE.get()))
                .add(Item.byBlock(ModBlocksMiner.NETHERITE_STRUCTURE.get()));
    }

    @Override
    public String getName() {
        return "Item Tags";
    }
}
