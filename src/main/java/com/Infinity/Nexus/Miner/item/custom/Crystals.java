package com.Infinity.Nexus.Miner.item.custom;

import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.component.TooltipDisplay;

import java.util.function.Consumer;

public class Crystals extends Item {
    int tier;
    public Crystals(Properties pProperties, int tier) {
        super(pProperties);
        this.tier = tier;
    }


    @Override
    public void appendHoverText(ItemStack stack, TooltipContext context, TooltipDisplay tooltipDisplay, Consumer<Component> tooltipAdder, TooltipFlag flag) {
        if (Screen.hasShiftDown()) {
            if (Screen.hasShiftDown()) {
                tooltipAdder.accept(Component.translatable("item.infinity_nexus_miner.crystal_description").append(" §5"+tier));
            } else {
                tooltipAdder.accept(Component.translatable("tooltip.infinity_nexus.pressShift"));
            }

            super.appendHoverText(stack, context, tooltipDisplay, tooltipAdder, flag);
        }
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return tier == 8;
    }
}
