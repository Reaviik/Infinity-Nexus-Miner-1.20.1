package com.Infinity.Nexus.Miner.block;

import com.Infinity.Nexus.Core.utils.GetResourceLocation;
import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.custom.LightCrystal;
import com.Infinity.Nexus.Miner.block.custom.Miner;
import com.Infinity.Nexus.Miner.block.custom.Structure;
import com.Infinity.Nexus.Miner.item.ModItemsMiner;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.StainedGlassBlock;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModBlocksMiner {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(InfinityNexusMiner.MOD_ID);

    // Blocos principais
    public static final DeferredBlock<Block> MINER = BLOCKS.register("miner", registryName -> new Miner(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(3.0f, 6.0f)
            .requiresCorrectToolForDrops().lightLevel(state -> state.getValue(Miner.LIT) >= 8 ? 2 : 0).noOcclusion().mapColor(MapColor.METAL)
    ));

    public static final DeferredBlock<Block> STRUCTURAL_BLOCK = BLOCKS.register("structural_block", registryName -> new Block(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .replaceable().noLootTable().noOcclusion().noCollission().mapColor(MapColor.COLOR_RED).instabreak()
    ));

    // Vidros transparentes coloridos
    public static final DeferredBlock<Block> PURPLE_CLEAR_GLASS = BLOCKS.register("purple_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.PURPLE,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.COLOR_PURPLE)
    ));

    public static final DeferredBlock<Block> YELLOW_CLEAR_GLASS = BLOCKS.register("yellow_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.YELLOW,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.COLOR_YELLOW)
    ));

    public static final DeferredBlock<Block> WHITE_CLEAR_GLASS = BLOCKS.register("white_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.WHITE,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.TERRACOTTA_WHITE)
    ));

    public static final DeferredBlock<Block> RED_CLEAR_GLASS = BLOCKS.register("red_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.RED,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)
    ));

    public static final DeferredBlock<Block> ORANGE_CLEAR_GLASS = BLOCKS.register("orange_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.ORANGE,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.COLOR_ORANGE)
    ));

    public static final DeferredBlock<Block> BLUE_CLEAR_GLASS = BLOCKS.register("blue_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.BLUE,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.COLOR_BLUE)
    ));

    public static final DeferredBlock<Block> PINK_CLEAR_GLASS = BLOCKS.register("pink_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.PINK,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.COLOR_PINK)
    ));

    public static final DeferredBlock<Block> GREEN_CLEAR_GLASS = BLOCKS.register("green_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.GREEN,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.COLOR_GREEN)
    ));

    public static final DeferredBlock<Block> ANCIENT_CLEAR_GLASS = BLOCKS.register("ancient_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.CYAN,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.COLOR_CYAN)
    ));

    // Blocos de cristal
    public static final DeferredBlock<Block> PURPLE_CRYSTAL_BLOCK = BLOCKS.register("purple_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.PURPLE,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.COLOR_PURPLE)
    ));

    public static final DeferredBlock<Block> YELLOW_CRYSTAL_BLOCK = BLOCKS.register("yellow_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.YELLOW,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.COLOR_YELLOW)
    ));

    public static final DeferredBlock<Block> WHITE_CRYSTAL_BLOCK = BLOCKS.register("white_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.WHITE,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.TERRACOTTA_WHITE)
    ));

    public static final DeferredBlock<Block> RED_CRYSTAL_BLOCK = BLOCKS.register("red_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.RED,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.COLOR_RED)
    ));

    public static final DeferredBlock<Block> ORANGE_CRYSTAL_BLOCK = BLOCKS.register("orange_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.ORANGE,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.COLOR_ORANGE)
    ));

    public static final DeferredBlock<Block> BLUE_CRYSTAL_BLOCK = BLOCKS.register("blue_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.BLUE,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.COLOR_BLUE)
    ));

    public static final DeferredBlock<Block> PINK_CRYSTAL_BLOCK = BLOCKS.register("pink_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.PINK,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.COLOR_PINK)
    ));

    public static final DeferredBlock<Block> GREEN_CRYSTAL_BLOCK = BLOCKS.register("green_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.GREEN,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.COLOR_GREEN)
    ));

    public static final DeferredBlock<Block> ANCIENT_CRYSTAL_BLOCK = BLOCKS.register("ancient_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.CYAN,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.COLOR_CYAN)
    ));

    // Blocos de Natal
    public static final DeferredBlock<Block> CHRISTMAS_CLEAR_GLASS = BLOCKS.register("christmas_clear_glass", registryName -> new StainedGlassBlock(
            DyeColor.CYAN,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.GLASS).lightLevel(state -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)
    ));

    public static final DeferredBlock<Block> CHRISTMAS_CRYSTAL_BLOCK = BLOCKS.register("christmas_crystal_block", registryName -> new StainedGlassBlock(
            DyeColor.CYAN,BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(0.3f, 0.1f)
            .sound(SoundType.AMETHYST).noOcclusion().mapColor(MapColor.COLOR_RED)
    ));

    // Blocos de estrutura
    public static final DeferredBlock<Block> WOOD_STRUCTURE = BLOCKS.register("wood_structure", registryName -> new Structure(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 1.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.WOOD).mapColor(MapColor.WOOD)
    ));

    public static final DeferredBlock<Block> STONE_STRUCTURE = BLOCKS.register("stone_structure", registryName -> new Structure(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 3.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.COPPER).mapColor(MapColor.COLOR_ORANGE)
    ));

    public static final DeferredBlock<Block> COPPER_STRUCTURE = BLOCKS.register("copper_structure", registryName -> new Structure(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.METAL).mapColor(MapColor.GOLD)
    ));

    public static final DeferredBlock<Block> IRON_STRUCTURE = BLOCKS.register("iron_structure", registryName -> new Structure(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 4.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.COPPER).mapColor(MapColor.TERRACOTTA_WHITE)
    ));

    public static final DeferredBlock<Block> GOLD_STRUCTURE = BLOCKS.register("gold_structure", registryName -> new Structure(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 4.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.COPPER).mapColor(MapColor.TERRACOTTA_WHITE)
    ));

    public static final DeferredBlock<Block> QUARTZ_STRUCTURE = BLOCKS.register("quartz_structure", registryName -> new Structure(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 4.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.COPPER).mapColor(MapColor.COLOR_BLACK)
    ));

    public static final DeferredBlock<Block> DIAMOND_STRUCTURE = BLOCKS.register("diamond_structure", registryName -> new Structure(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 5.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.METAL).mapColor(MapColor.COLOR_BLACK)
    ));

    public static final DeferredBlock<Block> EMERALD_STRUCTURE = BLOCKS.register("emerald_structure", registryName -> new Structure(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 5.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.METAL).mapColor(MapColor.COLOR_YELLOW)
    ));

    public static final DeferredBlock<Block> NETHERITE_STRUCTURE = BLOCKS.register("netherite_structure", registryName -> new Structure(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 5.0f)
            .requiresCorrectToolForDrops()
            .sound(SoundType.METAL).mapColor(MapColor.COLOR_BLACK)
    ));

    // Cristais de luz
    public static final DeferredBlock<Block> PURPLE_LIGHT_CRYSTAL = BLOCKS.register("purple_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.COLOR_PURPLE),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    public static final DeferredBlock<Block> YELLOW_LIGHT_CRYSTAL = BLOCKS.register("yellow_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.COLOR_YELLOW),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    public static final DeferredBlock<Block> WHITE_LIGHT_CRYSTAL = BLOCKS.register("white_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.TERRACOTTA_WHITE),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    public static final DeferredBlock<Block> RED_LIGHT_CRYSTAL = BLOCKS.register("red_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.COLOR_RED),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    public static final DeferredBlock<Block> ORANGE_LIGHT_CRYSTAL = BLOCKS.register("orange_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.COLOR_ORANGE),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    public static final DeferredBlock<Block> PINK_LIGHT_CRYSTAL = BLOCKS.register("pink_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.COLOR_PINK),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    public static final DeferredBlock<Block> GREEN_LIGHT_CRYSTAL = BLOCKS.register("green_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.COLOR_GREEN),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    public static final DeferredBlock<Block> BLUE_LIGHT_CRYSTAL = BLOCKS.register("blue_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.COLOR_BLUE),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    public static final DeferredBlock<Block> ANCIENT_LIGHT_CRYSTAL = BLOCKS.register("ancient_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.COLOR_BLUE),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    public static final DeferredBlock<Block> CHRISTMAS_LIGHT_CRYSTAL = BLOCKS.register("christmas_light_crystal", registryName -> new LightCrystal(BlockBehaviour.Properties.of().setId(ResourceKey.create(Registries.BLOCK, registryName))
            .strength(2.0f, 6.0f)
            .sound(SoundType.GLASS).lightLevel(state -> 15).noOcclusion().mapColor(MapColor.COLOR_GRAY),BlockSetType.POLISHED_BLACKSTONE, 1, true
    ));

    // Registro dos itens dos blocos
    static {
        registerBlockItem("miner", MINER);
        registerBlockItem("structural_block", STRUCTURAL_BLOCK);

        registerBlockItem("purple_clear_glass", PURPLE_CLEAR_GLASS);
        registerBlockItem("yellow_clear_glass", YELLOW_CLEAR_GLASS);
        registerBlockItem("white_clear_glass", WHITE_CLEAR_GLASS);
        registerBlockItem("red_clear_glass", RED_CLEAR_GLASS);
        registerBlockItem("orange_clear_glass", ORANGE_CLEAR_GLASS);
        registerBlockItem("blue_clear_glass", BLUE_CLEAR_GLASS);
        registerBlockItem("pink_clear_glass", PINK_CLEAR_GLASS);
        registerBlockItem("green_clear_glass", GREEN_CLEAR_GLASS);
        registerBlockItem("ancient_clear_glass", ANCIENT_CLEAR_GLASS);

        registerBlockItem("purple_crystal_block", PURPLE_CRYSTAL_BLOCK);
        registerBlockItem("yellow_crystal_block", YELLOW_CRYSTAL_BLOCK);
        registerBlockItem("white_crystal_block", WHITE_CRYSTAL_BLOCK);
        registerBlockItem("red_crystal_block", RED_CRYSTAL_BLOCK);
        registerBlockItem("orange_crystal_block", ORANGE_CRYSTAL_BLOCK);
        registerBlockItem("blue_crystal_block", BLUE_CRYSTAL_BLOCK);
        registerBlockItem("pink_crystal_block", PINK_CRYSTAL_BLOCK);
        registerBlockItem("green_crystal_block", GREEN_CRYSTAL_BLOCK);
        registerBlockItem("ancient_crystal_block", ANCIENT_CRYSTAL_BLOCK);

        registerBlockItem("christmas_clear_glass", CHRISTMAS_CLEAR_GLASS);
        registerBlockItem("christmas_crystal_block", CHRISTMAS_CRYSTAL_BLOCK);

        registerBlockItem("wood_structure", WOOD_STRUCTURE);
        registerBlockItem("stone_structure", STONE_STRUCTURE);
        registerBlockItem("copper_structure", COPPER_STRUCTURE);
        registerBlockItem("iron_structure", IRON_STRUCTURE);
        registerBlockItem("gold_structure", GOLD_STRUCTURE);
        registerBlockItem("quartz_structure", QUARTZ_STRUCTURE);
        registerBlockItem("diamond_structure", DIAMOND_STRUCTURE);
        registerBlockItem("emerald_structure", EMERALD_STRUCTURE);
        registerBlockItem("netherite_structure", NETHERITE_STRUCTURE);

        registerBlockItem("purple_light_crystal", PURPLE_LIGHT_CRYSTAL);
        registerBlockItem("yellow_light_crystal", YELLOW_LIGHT_CRYSTAL);
        registerBlockItem("white_light_crystal", WHITE_LIGHT_CRYSTAL);
        registerBlockItem("red_light_crystal", RED_LIGHT_CRYSTAL);
        registerBlockItem("orange_light_crystal", ORANGE_LIGHT_CRYSTAL);
        registerBlockItem("pink_light_crystal", PINK_LIGHT_CRYSTAL);
        registerBlockItem("green_light_crystal", GREEN_LIGHT_CRYSTAL);
        registerBlockItem("blue_light_crystal", BLUE_LIGHT_CRYSTAL);
        registerBlockItem("ancient_light_crystal", ANCIENT_LIGHT_CRYSTAL);
        registerBlockItem("christmas_light_crystal", CHRISTMAS_LIGHT_CRYSTAL);
    }

    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItemsMiner.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().useBlockDescriptionPrefix()
                .setId(ResourceKey.create(Registries.ITEM, GetResourceLocation.withNamespaceAndPath(InfinityNexusMiner.MOD_ID, name)))));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}