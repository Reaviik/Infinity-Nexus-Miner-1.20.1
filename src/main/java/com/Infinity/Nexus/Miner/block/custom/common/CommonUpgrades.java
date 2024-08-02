package com.Infinity.Nexus.Miner.block.custom.common;

import com.Infinity.Nexus.Miner.block.entity.MinerBlockEntity;
import com.Infinity.Nexus.Miner.config.ConfigUtils;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.network.NetworkHooks;

public class CommonUpgrades {

    public static void setUpgrades(Level pLevel, BlockPos pPos, Player pPlayer) {
        BlockEntity entity = pLevel.getBlockEntity(pPos);
        ItemStack stack = pPlayer.getMainHandItem().copy();
        boolean component = ConfigUtils.isComponentItem(stack.getItem());
        boolean upgrade = ConfigUtils.isUpgradeItem(stack.getItem());
        if (pPlayer instanceof ServerPlayer) {
            if (component) {
                if (entity instanceof MinerBlockEntity be) {
                    be.setMachineLevel(stack, pPlayer);
                }
            } else if (upgrade) {
                if (entity instanceof MinerBlockEntity be) {
                    be.setUpgradeLevel(stack, pPlayer);
                }
            } else {
                NetworkHooks.openScreen(((ServerPlayer) pPlayer), (MenuProvider) entity, pPos);
            }
        }
    }
}
