package com.Infinity.Nexus.Miner.slots;

import com.Infinity.Nexus.Core.itemStackHandler.RestrictedItemStackHandler;
import com.Infinity.Nexus.Core.slots.RestrictiveSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

public class EnchantSlot extends RestrictiveSlot {
    public EnchantSlot(RestrictedItemStackHandler itemHandler, int index, int xPosition, int yPosition) {
        super(itemHandler, index, xPosition, yPosition, 1);
    }

    @Override
    public boolean mayPlace(@NotNull ItemStack stack) {
        return stack.getItem() == Items.ENCHANTED_BOOK || stack.isEnchanted();
    }
}