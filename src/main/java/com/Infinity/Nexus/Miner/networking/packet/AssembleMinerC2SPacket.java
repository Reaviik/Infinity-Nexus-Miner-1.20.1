package com.Infinity.Nexus.Miner.networking.packet;

import com.Infinity.Nexus.Miner.block.entity.MinerBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

/**
 * Network packet sent from client to server to toggle the working area display of a Mob Crusher.
 * Handles the synchronization of area visibility state between client and server.
 */
public class AssembleMinerC2SPacket {
    private final BlockPos pos;

    /**
     * Creates a new toggle area packet
     *
     * @param pos The position of the Mob Crusher block
     */
    public AssembleMinerC2SPacket(BlockPos pos) {
        this.pos = pos;
    }

    /**
     * Deserializes packet data from the network buffer
     *
     * @param buf The network buffer containing serialized packet data
     */
    public AssembleMinerC2SPacket(FriendlyByteBuf buf) {
        this.pos = buf.readBlockPos();
    }

    /**
     * Serializes packet data to the network buffer
     *
     * @param buf The network buffer to write the packet data to
     */
    public void toBytes(FriendlyByteBuf buf) {
        buf.writeBlockPos(pos);
    }

    /**
     * Processes the packet on the server side and broadcasts the state change to nearby players
     *
     * @param supplier The network context supplier
     * @return true if the packet was handled successfully
     */
    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = context.getSender();
            if (player == null) return;

            ServerLevel level = player.serverLevel();
            if (level.getBlockEntity(pos) instanceof MinerBlockEntity blockEntity) {
                blockEntity.makeStructure();
                blockEntity.setChanged();
                blockEntity.makeStructure();
                blockEntity.setChanged();
                level.sendBlockUpdated(pos, blockEntity.getBlockState(), blockEntity.getBlockState(), 3);
            }
        });
        return true;
    }
}