package com.Infinity.Nexus.Miner.slots;

import com.Infinity.Nexus.Core.itemStackHandler.RestrictedItemStackHandler;
import com.Infinity.Nexus.Core.slots.RestrictiveSlot;
import com.Infinity.Nexus.Miner.config.ConfigUtils;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class StructureSlot extends RestrictiveSlot {
    public StructureSlot(RestrictedItemStackHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition, 64);
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return ConfigUtils.isStructure(stack);
    }
}