package com.Infinity.Nexus.Miner.config;

import com.Infinity.Nexus.Core.items.ModItems;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ConfigUtils {


    public static ItemStack getStructureByLevel(int componentLevel) {
        if (componentLevel > 0 && componentLevel <= Config.list_of_structures.size()) {
            return new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.list_of_structures.get(componentLevel - 1)))));
        } else {
            return new ItemStack(Blocks.AIR);
        }
    }


    public static boolean isStructure(Item item) {
        return Config.list_of_structures.stream()
                .map(structure -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(structure)))
                .anyMatch(structureItem -> structureItem == item);
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
