package com.Infinity.Nexus.Miner.compat;


import com.Infinity.Nexus.Miner.block.custom.Miner;
import com.Infinity.Nexus.Miner.compat.jade.MinerOwner;
import snownee.jade.api.IWailaClientRegistration;
import snownee.jade.api.IWailaCommonRegistration;
import snownee.jade.api.IWailaPlugin;
import snownee.jade.api.WailaPlugin;

@WailaPlugin
public class JadeModPlugin implements IWailaPlugin {
    @Override
    public void registerClient(IWailaClientRegistration registration) {
        registration.registerBlockComponent(MinerOwner.INSTANCE, Miner.class);

        //registration.registerItemStorageClient(TombstoneProvider.INSTANCE);
    }

    @Override
    public void register(IWailaCommonRegistration registration) {
        //registration.registerItemStorage(MinerOwner.INSTANCE, MinerBlockEntity.class);
    }
}