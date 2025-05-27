package com.Infinity.Nexus.Miner.recipes;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes {

    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZER =
            DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, InfinityNexusMiner.MOD_ID);
    public static final RegistryObject<RecipeSerializer<MinerRecipes>> MINER_SERIALIZER = SERIALIZER.register("mining", () -> MinerRecipes.Serializer.INSTANCE);

    public static void register(IEventBus eventBus) {
        SERIALIZER.register(eventBus);
    }
}
