package com.Infinity.Nexus.Miner.networking.packet;

import com.Infinity.Nexus.Core.utils.GetResourceLocation;
import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.entity.MinerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.neoforge.network.handling.IPayloadContext;

public record AssembleMinerC2SPacket(BlockPos pos) implements CustomPacketPayload {
    public static final Type<AssembleMinerC2SPacket> TYPE =
            new Type<>(GetResourceLocation.withNamespaceAndPath(InfinityNexusMiner.MOD_ID, "assemble_miner"));

    public static final StreamCodec<FriendlyByteBuf, AssembleMinerC2SPacket> STREAM_CODEC = StreamCodec.composite(
            BlockPos.STREAM_CODEC,
            AssembleMinerC2SPacket::pos,
            AssembleMinerC2SPacket::new
    );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }

    public static void handle(AssembleMinerC2SPacket packet, IPayloadContext context) {
        context.enqueueWork(() -> {
            ServerPlayer player = (ServerPlayer) context.player();
            if (player == null) return;

            ServerLevel level = player.serverLevel();
            if (level.getBlockEntity(packet.pos()) instanceof MinerBlockEntity blockEntity) {
                blockEntity.makeStructure();
                blockEntity.setChanged();
                level.sendBlockUpdated(packet.pos(),
                        blockEntity.getBlockState(),
                        blockEntity.getBlockState(),
                        3);
            }
        });
    }
}