package com.Infinity.Nexus.Miner.config;

import com.Infinity.Nexus.Core.items.ModItems;
import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.utils.ModTags;
import net.minecraft.world.item.ItemStack;

public class ConfigUtils {


    public static ItemStack getStructureByLevel(int componentLevel) {
        return switch (componentLevel) {
            case 1 -> new ItemStack(ModBlocksMiner.WOOD_STRUCTURE.get().defaultBlockState().getBlock());
            case 2 -> new ItemStack(ModBlocksMiner.STONE_STRUCTURE.get().defaultBlockState().getBlock());
            case 3 -> new ItemStack(ModBlocksMiner.COPPER_STRUCTURE.get().defaultBlockState().getBlock());
            case 4 -> new ItemStack(ModBlocksMiner.IRON_STRUCTURE.get().defaultBlockState().getBlock());
            case 5 -> new ItemStack(ModBlocksMiner.GOLD_STRUCTURE.get().defaultBlockState().getBlock());
            case 6 -> new ItemStack(ModBlocksMiner.QUARTZ_STRUCTURE.get().defaultBlockState().getBlock());
            case 7 -> new ItemStack(ModBlocksMiner.DIAMOND_STRUCTURE.get().defaultBlockState().getBlock());
            case 8 -> new ItemStack(ModBlocksMiner.EMERALD_STRUCTURE.get().defaultBlockState().getBlock());
            case 9 -> new ItemStack(ModBlocksMiner.NETHERITE_STRUCTURE.get().defaultBlockState().getBlock());
            default -> ItemStack.EMPTY;
        };
    }

    public static boolean isStructure(ItemStack item) {
        return item.is(ModTags.Items.MINER_STRUCTURE);
    }

    public static ItemStack getComponentByLevel(int level) {
        return switch (level) {
            case 1 -> ModItems.REDSTONE_COMPONENT.get().getDefaultInstance();
            case 2 -> ModItems.BASIC_COMPONENT.get().getDefaultInstance();
            case 3 -> ModItems.REINFORCED_COMPONENT.get().getDefaultInstance();
            case 4 -> ModItems.LOGIC_COMPONENT.get().getDefaultInstance();
            case 5 -> ModItems.ADVANCED_COMPONENT.get().getDefaultInstance();
            case 6 -> ModItems.REFINED_COMPONENT.get().getDefaultInstance();
            case 7 -> ModItems.INTEGRAL_COMPONENT.get().getDefaultInstance();
            case 8 -> ModItems.INFINITY_COMPONENT.get().getDefaultInstance();
            case 9 -> ModItems.ANCESTRAL_COMPONENT.get().getDefaultInstance();
            default -> ItemStack.EMPTY;
        };
    }
}
