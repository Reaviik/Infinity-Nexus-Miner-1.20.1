package com.Infinity.Nexus.Miner.block;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.custom.LightCrystal;
import com.Infinity.Nexus.Miner.block.custom.Miner;
import com.Infinity.Nexus.Miner.item.ModItemsMiner;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.GlassBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModBlocksMiner {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, InfinityNexusMiner.MOD_ID);
    public static final RegistryObject<Block> MINER = registerBlock("miner", () -> new Miner(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(3.0f, 6.0f).lightLevel((state) -> state.getValue(Miner.LIT) >= 8 ? 2 : 0).noOcclusion().mapColor(MapColor.METAL)));
    public static final RegistryObject<Block> STRUCTURAL_BLOCK = registerBlock("structural_block", () -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).replaceable().noLootTable().noOcclusion().noCollission().noParticlesOnBreak().mapColor(MapColor.COLOR_RED).instabreak()));

    public static final RegistryObject<Block> PURPLE_CLEAR_GLASS = registerBlock("purple_clear_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f, 0.1f).sound(SoundType.GLASS).lightLevel((state) -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> YELLOW_CLEAR_GLASS = registerBlock("yellow_clear_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f, 0.1f).sound(SoundType.GLASS).lightLevel((state) -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> WHITE_CLEAR_GLASS = registerBlock("white_clear_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f, 0.1f).sound(SoundType.GLASS).lightLevel((state) -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> RED_CLEAR_GLASS = registerBlock("red_clear_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f, 0.1f).sound(SoundType.GLASS).lightLevel((state) -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ORANGE_CLEAR_GLASS = registerBlock("orange_clear_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f, 0.1f).sound(SoundType.GLASS).lightLevel((state) -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> BLUE_CLEAR_GLASS = registerBlock("blue_clear_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f, 0.1f).sound(SoundType.GLASS).lightLevel((state) -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> PINK_CLEAR_GLASS = registerBlock("pink_clear_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f, 0.1f).sound(SoundType.GLASS).lightLevel((state) -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> GREEN_CLEAR_GLASS = registerBlock("green_clear_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f, 0.1f).sound(SoundType.GLASS).lightLevel((state) -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)));
    public static final RegistryObject<Block> ANCIENT_CLEAR_GLASS = registerBlock("ancient_clear_glass", () -> new GlassBlock(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(0.3f, 0.1f).sound(SoundType.GLASS).lightLevel((state) -> 5).noOcclusion().mapColor(MapColor.COLOR_RED)));

    public static final RegistryObject<Block> WOOD_STRUCTURE = registerBlock("wood_structure",() -> new Block(BlockBehaviour.Properties.copy(Blocks.OAK_WOOD).requiresCorrectToolForDrops().strength(2.0f, 1.0f).sound(SoundType.WOOD).mapColor(MapColor.WOOD)));
    public static final RegistryObject<Block> STONE_STRUCTURE = registerBlock("stone_structure",() -> new Block(BlockBehaviour.Properties.copy(Blocks.STONE).requiresCorrectToolForDrops().strength(2.0f, 3.0f).sound(SoundType.COPPER).mapColor(MapColor.COLOR_ORANGE)));
    public static final RegistryObject<Block> COPPER_STRUCTURE = registerBlock("copper_structure",() -> new Block(BlockBehaviour.Properties.copy(Blocks.COPPER_BLOCK).requiresCorrectToolForDrops().strength(2.0f, 6.0f).sound(SoundType.METAL).mapColor(MapColor.GOLD)));
    public static final RegistryObject<Block> IRON_STRUCTURE = registerBlock("iron_structure",() -> new Block(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK).requiresCorrectToolForDrops().strength(2.0f, 4.0f).sound(SoundType.COPPER).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistryObject<Block> GOLD_STRUCTURE = registerBlock("gold_structure",() -> new Block(BlockBehaviour.Properties.copy(Blocks.GOLD_BLOCK).requiresCorrectToolForDrops().strength(2.0f, 4.0f).sound(SoundType.COPPER).mapColor(MapColor.TERRACOTTA_WHITE)));
    public static final RegistryObject<Block> QUARTZ_STRUCTURE = registerBlock("quartz_structure",() -> new Block(BlockBehaviour.Properties.copy(Blocks.QUARTZ_BLOCK).requiresCorrectToolForDrops().strength(2.0f, 4.0f).sound(SoundType.COPPER).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> DIAMOND_STRUCTURE = registerBlock("diamond_structure",() -> new Block(BlockBehaviour.Properties.copy(Blocks.DIAMOND_BLOCK).requiresCorrectToolForDrops().strength(2.0f, 5.0f).sound(SoundType.METAL).mapColor(MapColor.COLOR_BLACK)));
    public static final RegistryObject<Block> EMERALD_STRUCTURE = registerBlock("emerald_structure",() -> new Block(BlockBehaviour.Properties.copy(Blocks.EMERALD_BLOCK).requiresCorrectToolForDrops().strength(2.0f, 5.0f).sound(SoundType.METAL).mapColor(MapColor.COLOR_YELLOW)));
    public static final RegistryObject<Block> NETHERITE_STRUCTURE = registerBlock("netherite_structure",() -> new Block(BlockBehaviour.Properties.copy(Blocks.NETHERITE_BLOCK).requiresCorrectToolForDrops().strength(2.0f, 5.0f).sound(SoundType.METAL).mapColor(MapColor.COLOR_BLACK)));

    public static final RegistryObject<Block> PURPLE_LIGHT_CRYSTAL = registerBlock("purple_light_crystal", () -> new LightCrystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f, 6.0f).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion().mapColor(MapColor.COLOR_PURPLE), BlockSetType.POLISHED_BLACKSTONE, 1, true));
    public static final RegistryObject<Block> YELLOW_LIGHT_CRYSTAL = registerBlock("yellow_light_crystal", () -> new LightCrystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f, 6.0f).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion().mapColor(MapColor.COLOR_YELLOW), BlockSetType.POLISHED_BLACKSTONE, 1, true));
    public static final RegistryObject<Block> WHITE_LIGHT_CRYSTAL = registerBlock("white_light_crystal", () -> new LightCrystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f, 6.0f).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion().mapColor(MapColor.TERRACOTTA_WHITE), BlockSetType.POLISHED_BLACKSTONE, 1, true));
    public static final RegistryObject<Block> RED_LIGHT_CRYSTAL = registerBlock("red_light_crystal", () -> new LightCrystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f, 6.0f).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion().mapColor(MapColor.COLOR_RED), BlockSetType.POLISHED_BLACKSTONE, 1, true));
    public static final RegistryObject<Block> ORANGE_LIGHT_CRYSTAL = registerBlock("orange_light_crystal", () -> new LightCrystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f, 6.0f).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion().mapColor(MapColor.COLOR_ORANGE), BlockSetType.POLISHED_BLACKSTONE, 1, true));
    public static final RegistryObject<Block> PINK_LIGHT_CRYSTAL = registerBlock("pink_light_crystal", () -> new LightCrystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f, 6.0f).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion().mapColor(MapColor.COLOR_PINK), BlockSetType.POLISHED_BLACKSTONE, 1, true));
    public static final RegistryObject<Block> GREEN_LIGHT_CRYSTAL = registerBlock("green_light_crystal", () -> new LightCrystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f, 6.0f).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion().mapColor(MapColor.COLOR_GREEN), BlockSetType.POLISHED_BLACKSTONE, 1, true));
    public static final RegistryObject<Block> BLUE_LIGHT_CRYSTAL = registerBlock("blue_light_crystal", () -> new LightCrystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f, 6.0f).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion().mapColor(MapColor.COLOR_BLUE), BlockSetType.POLISHED_BLACKSTONE, 1, true));
    public static final RegistryObject<Block> ANCIENT_LIGHT_CRYSTAL = registerBlock("ancient_light_crystal", () -> new LightCrystal(BlockBehaviour.Properties.copy(Blocks.GLASS).strength(2.0f, 6.0f).sound(SoundType.GLASS).lightLevel((state) -> 15).noOcclusion().mapColor(MapColor.COLOR_BLUE), BlockSetType.POLISHED_BLACKSTONE, 1, true));

    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block) {
        return ModItemsMiner.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
