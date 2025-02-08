package com.Infinity.Nexus.Miner.events;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.command.MinerTP;
import com.Infinity.Nexus.Miner.command.Reload;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;

@Mod.EventBusSubscriber(modid = InfinityNexusMiner.MOD_ID)
public class ModEvents {
    @SubscribeEvent
    public static void onCommandRegister(RegisterCommandsEvent event) {
        new Reload(event.getDispatcher());
        new MinerTP(event.getDispatcher());
        ConfigCommand.register(event.getDispatcher());
    }
}
