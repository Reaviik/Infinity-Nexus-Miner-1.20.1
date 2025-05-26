package com.Infinity.Nexus.Miner.networking;

import com.Infinity.Nexus.Miner.networking.packet.AssembleMinerC2SPacket;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;

public class ModMessages {
    @SubscribeEvent
    public static void register(final RegisterPayloadHandlersEvent event) {
        final PayloadRegistrar registrar = event.registrar("1")
                .versioned("1.0")
                .optional();

        registrar.playToServer(
                AssembleMinerC2SPacket.TYPE,
                AssembleMinerC2SPacket.STREAM_CODEC,
                AssembleMinerC2SPacket::handle
        );
    }

    public static void sendToServer(AssembleMinerC2SPacket packet) {
        PacketDistributor.sendToServer(packet);
    }
}