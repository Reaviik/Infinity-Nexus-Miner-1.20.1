package com.Infinity.Nexus.Miner.config;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.Objects;

public class ConfigUtils {


    public static boolean isComponentItem(Item item) {
        return
                Config.list_of_components.stream()
                .map(component -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(component)))
                .anyMatch(componentItem -> componentItem == item);
    }

    public static boolean isUpgradeItem(Item item) {
        return Config.list_of_upgrades.stream()
                .map(upgrade -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(upgrade)))
                .anyMatch(upgradeItem -> upgradeItem == item);
    }

    public static int getComponentLevel(Item item) {
        int index = Config.list_of_components.stream()
                .map(component -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(component)))
                .toList().indexOf(item);
        return index + 1;
    }
    public static int getSpeed(ItemStackHandler itemHandler, int[] upgradeSlots) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.list_of_upgrades.get(0)));
        int speed = 0;
        for (int i : upgradeSlots) {
            if (itemHandler.getStackInSlot(i).getItem() == item) {
                speed++;
            }
        }
        return speed;
    }
    public static int getStrength(ItemStackHandler itemHandler, int[] upgradeSlots) {
        Item item = ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.list_of_upgrades.get(1)));
        int strength = 0;
        for (int i : upgradeSlots) {
            if (itemHandler.getStackInSlot(i).getItem() == item) {
                strength++;
            }
        }
        return strength;
    }

    public static ItemStack getComponentByLevel(int componentLevel) {
        if (componentLevel > 0 && componentLevel <= Config.list_of_components.size()) {
            return new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.list_of_components.get(componentLevel - 1)))));
        } else {
            return new ItemStack(Blocks.AIR);
        }
    }

    public static ItemStack getStructureByLevel(int componentLevel) {
        if (componentLevel > 0 && componentLevel <= Config.list_of_structures.size()) {
            return new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.list_of_structures.get(componentLevel - 1)))));
        } else {
            return new ItemStack(Blocks.AIR);
        }
    }

    public static ItemStack getSpeedUpgrade() {
        return new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.list_of_upgrades.get(0)))));
    }
    public static ItemStack getStrengthUpgrade() {
        return new ItemStack(Objects.requireNonNull(ForgeRegistries.ITEMS.getValue(new ResourceLocation(Config.list_of_upgrades.get(1)))));
    }

    public static boolean isStructure(Item item) {
        return Config.list_of_structures.stream()
                .map(structure -> ForgeRegistries.ITEMS.getValue(new ResourceLocation(structure)))
                .anyMatch(structureItem -> structureItem == item);
    }
}
