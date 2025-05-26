package com.Infinity.Nexus.Miner.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;

import java.util.List;

public class Crystals extends Item {
    int tier;
    public Crystals(Properties pProperties, int tier) {
        super(pProperties);
        this.tier = tier;
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext tooltip, List<Component> components, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            components.add(Component.translatable("item.infinity_nexus_miner.crystal_description").append(" §5"+tier));
        } else {
            components.add(Component.translatable("tooltip.infinity_nexus.pressShift"));
        }

        super.appendHoverText(stack, tooltip, components, flag);
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return tier == 8;
    }
}
