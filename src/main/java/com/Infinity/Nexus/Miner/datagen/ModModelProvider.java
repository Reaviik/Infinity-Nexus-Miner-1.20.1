package com.Infinity.Nexus.Miner.datagen;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.item.ModItemsMiner;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.ModelProvider;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Holder;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.stream.Stream;

public class ModModelProvider extends ModelProvider {
    public ModModelProvider(PackOutput output) {
        super(output, InfinityNexusMiner.MOD_ID);
    }

    @Override
    protected void registerModels(BlockModelGenerators blockModels, ItemModelGenerators itemModels) {
        itemModels.generateFlatItem(ModItemsMiner.AGATE_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsMiner.TERMURIUM_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsMiner.DEMETRIUM_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsMiner.RUBIUM_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsMiner.CITRIUM_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsMiner.MARINE_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsMiner.AMBER_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);
        itemModels.generateFlatItem(ModItemsMiner.DARIUM_CRYSTAL.get(), ModelTemplates.FLAT_ITEM);

        blockModels.createTrivialCube(ModBlocksMiner.WHITE_CLEAR_GLASS.get());
        blockModels.createTrivialCube(ModBlocksMiner.YELLOW_CLEAR_GLASS.get());
        blockModels.createTrivialCube(ModBlocksMiner.BLUE_CLEAR_GLASS.get());
        blockModels.createTrivialCube(ModBlocksMiner.GREEN_CLEAR_GLASS.get());
        blockModels.createTrivialCube(ModBlocksMiner.ORANGE_CLEAR_GLASS.get());
        blockModels.createTrivialCube(ModBlocksMiner.PINK_CLEAR_GLASS.get());
        blockModels.createTrivialCube(ModBlocksMiner.PURPLE_CLEAR_GLASS.get());
        blockModels.createTrivialCube(ModBlocksMiner.RED_CLEAR_GLASS.get());
        blockModels.createTrivialCube(ModBlocksMiner.ANCIENT_CLEAR_GLASS.get());
        blockModels.createTrivialCube(ModBlocksMiner.CHRISTMAS_CLEAR_GLASS.get());

        blockModels.createTrivialCube(ModBlocksMiner.WHITE_CRYSTAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocksMiner.YELLOW_CRYSTAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocksMiner.BLUE_CRYSTAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocksMiner.GREEN_CRYSTAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocksMiner.ORANGE_CRYSTAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocksMiner.PINK_CRYSTAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocksMiner.PURPLE_CRYSTAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocksMiner.RED_CRYSTAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocksMiner.ANCIENT_CRYSTAL_BLOCK.get());
        blockModels.createTrivialCube(ModBlocksMiner.CHRISTMAS_CRYSTAL_BLOCK.get());

    }

    @Override
    protected Stream<? extends Holder<Block>> getKnownBlocks() {
        return ModBlocksMiner.BLOCKS.getEntries().stream().filter(x ->
                !x.is(ModBlocksMiner.MINER) &&
                !x.is(ModBlocksMiner.STRUCTURAL_BLOCK) &&
                !x.is(ModBlocksMiner.WOOD_STRUCTURE) &&
                !x.is(ModBlocksMiner.STONE_STRUCTURE) &&
                !x.is(ModBlocksMiner.COPPER_STRUCTURE) &&
                !x.is(ModBlocksMiner.IRON_STRUCTURE) &&
                !x.is(ModBlocksMiner.GOLD_STRUCTURE) &&
                !x.is(ModBlocksMiner.QUARTZ_STRUCTURE) &&
                !x.is(ModBlocksMiner.DIAMOND_STRUCTURE) &&
                !x.is(ModBlocksMiner.EMERALD_STRUCTURE) &&
                !x.is(ModBlocksMiner.NETHERITE_STRUCTURE) &&
                !x.is(ModBlocksMiner.RED_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.BLUE_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.GREEN_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.YELLOW_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.PURPLE_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.ORANGE_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.WHITE_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.PINK_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.ANCIENT_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.CHRISTMAS_LIGHT_CRYSTAL) &&
                !x.is(ModBlocksMiner.STRUCTURAL_BLOCK)
        );
    }

    @Override
    protected Stream<? extends Holder<Item>> getKnownItems() {
        return ModItemsMiner.ITEMS.getEntries().stream().filter(x ->
                x.get() != ModBlocksMiner.MINER.asItem() &&
                x.get() != ModBlocksMiner.STRUCTURAL_BLOCK.asItem() &&
                x.get() != ModBlocksMiner.WOOD_STRUCTURE.asItem() &&
                x.get() != ModBlocksMiner.STONE_STRUCTURE.asItem() &&
                x.get() != ModBlocksMiner.COPPER_STRUCTURE.asItem() &&
                x.get() != ModBlocksMiner.IRON_STRUCTURE.asItem() &&
                x.get() != ModBlocksMiner.GOLD_STRUCTURE.asItem() &&
                x.get() != ModBlocksMiner.QUARTZ_STRUCTURE.asItem() &&
                x.get() != ModBlocksMiner.DIAMOND_STRUCTURE.asItem() &&
                x.get() != ModBlocksMiner.EMERALD_STRUCTURE.asItem() &&
                x.get() != ModBlocksMiner.NETHERITE_STRUCTURE.asItem() &&
                x.get() != ModBlocksMiner.RED_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.BLUE_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.GREEN_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.YELLOW_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.PURPLE_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.ORANGE_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.WHITE_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.PINK_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.ANCIENT_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.CHRISTMAS_LIGHT_CRYSTAL.asItem() &&
                x.get() != ModBlocksMiner.STRUCTURAL_BLOCK.asItem()
        );
    }
}
