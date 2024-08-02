package com.Infinity.Nexus.Miner.utils;

import com.Infinity.Nexus.Core.fakePlayer.IFFakePlayer;
import com.Infinity.Nexus.Miner.config.Config;
import com.Infinity.Nexus.Miner.item.ModItemsMiner;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.atomic.AtomicReference;

public class ModUtilsMiner {
    public static ItemStack getCrystalType(int value) {
        return switch (value) {
            case 2 -> new ItemStack(ModItemsMiner.MARINE_CRYSTAL.get());
            case 3 -> new ItemStack(ModItemsMiner.CITRIUM_CRYSTAL.get());
            case 4 -> new ItemStack(ModItemsMiner.RUBIUM_CRYSTAL.get());
            case 5 -> new ItemStack(ModItemsMiner.DEMETRIUM_CRYSTAL.get());
            case 6 -> new ItemStack(ModItemsMiner.AGATE_CRYSTAL.get());
            case 7 -> new ItemStack(ModItemsMiner.DARIUM_CRYSTAL.get());
            case 8 -> new ItemStack(ModItemsMiner.TERMURIUM_CRYSTAL.get());
            default -> new ItemStack(ModItemsMiner.AMBER_CRYSTAL.get());
        };
    }
    public static Direction getLinkedSide(String side) {
        return switch (side) {
            case "up" -> Direction.UP;
            case "down" -> Direction.DOWN;
            case "north" -> Direction.NORTH;
            case "south" -> Direction.SOUTH;
            case "west" -> Direction.WEST;
            case "east" -> Direction.EAST;
            default -> Direction.UP;
        };
    }
    public static int getFortuneLevel(ItemStack fortuneItem) {
        int enchantmentLevel = 0;
        CompoundTag bookTag = fortuneItem.getTag();
        if (bookTag != null && bookTag.contains("StoredEnchantments")) {
            ListTag enchantmentsTag = bookTag.getList("StoredEnchantments", 10);
            for (int i = 0; i < enchantmentsTag.size(); i++) {
                CompoundTag enchantmentTag = enchantmentsTag.getCompound(i);
                String enchantmentId = enchantmentTag.getString("id");
                if (enchantmentId.equals("minecraft:fortune")) {
                    enchantmentLevel = enchantmentTag.getShort("lvl");
                    break;
                }
            }
        }
        return Math.min(enchantmentLevel, Config.max_fortune_level);

    }
    public static ItemStack getDrop(ItemStack stack, Level level, BlockPos pos, ItemStack pickaxe) {
        if (!(stack.getItem() instanceof BlockItem)) {
            return null;
        }
        IFFakePlayer player = new IFFakePlayer((ServerLevel) level);
        Block block = ((BlockItem) stack.getItem()).getBlock();
        AtomicReference<ItemStack> dropItem = new AtomicReference<ItemStack>(ItemStack.EMPTY);

        List<ItemStack> drops = new ArrayList<>(Block.getDrops(block.defaultBlockState(), (ServerLevel) level, pos, null, player, pickaxe));

        drops.forEach(stack1 -> {
            int drop = new Random().nextInt(drops.size());
            dropItem.set(drops.get(drop).copy());

        });
        return dropItem.get();
    }
}
