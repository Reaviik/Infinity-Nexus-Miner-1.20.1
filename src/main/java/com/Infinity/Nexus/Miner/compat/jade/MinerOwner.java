package com.Infinity.Nexus.Miner.compat.jade;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.entity.MinerBlockEntity;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import snownee.jade.api.BlockAccessor;
import snownee.jade.api.IBlockComponentProvider;
import snownee.jade.api.ITooltip;
import snownee.jade.api.config.IPluginConfig;

public enum MinerOwner implements IBlockComponentProvider {
    INSTANCE;

    private static final ResourceLocation UID = ResourceLocation.fromNamespaceAndPath(InfinityNexusMiner.MOD_ID, "miner_owner");

    @Override
    public void appendTooltip(ITooltip iTooltip, BlockAccessor blockAccessor, IPluginConfig iPluginConfig) {
        if (blockAccessor.getBlockEntity() instanceof MinerBlockEntity miner) {
            iTooltip.add(Component.translatable("infinity_nexus_miner.miner_owner").append(miner.getOwner()));
            iTooltip.add(Component.translatable("infinity_nexus_miner.miner_level").append(miner.getTier()));
            iTooltip.add(Component.literal(miner.getLinkedPos()));
        }
    }

    @Override
    public ResourceLocation getUid() {
        return UID;
    }
}