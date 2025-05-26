package com.Infinity.Nexus.Miner.datagen;

import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.utils.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, InfinityNexusMiner.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {

        this.tag(ModTags.Blocks.MINER_STRUCTURE)
                .add(ModBlocksMiner.WOOD_STRUCTURE.get())
                .add(ModBlocksMiner.STONE_STRUCTURE.get())
                .add(ModBlocksMiner.COPPER_STRUCTURE.get())
                .add(ModBlocksMiner.IRON_STRUCTURE.get())
                .add(ModBlocksMiner.GOLD_STRUCTURE.get())
                .add(ModBlocksMiner.QUARTZ_STRUCTURE.get())
                .add(ModBlocksMiner.DIAMOND_STRUCTURE.get())
                .add(ModBlocksMiner.EMERALD_STRUCTURE.get())
                .add(ModBlocksMiner.NETHERITE_STRUCTURE.get());

    }

}