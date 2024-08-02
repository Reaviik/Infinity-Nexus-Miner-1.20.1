package com.Infinity.Nexus.Miner.block.entity;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntities {
    public  static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY =
            DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, InfinityNexusMiner.MOD_ID);
    public static final RegistryObject<BlockEntityType<MinerBlockEntity>> MINER_BE =
            BLOCK_ENTITY.register("miner_block_entity", () ->
                    BlockEntityType.Builder.of(MinerBlockEntity::new, ModBlocksMiner.MINER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITY.register(eventBus);
    }
}
