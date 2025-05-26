package com.Infinity.Nexus.Miner.compat.rei.category;

import com.Infinity.Nexus.Core.utils.GetResourceLocation;
import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.compat.rei.display.MinerDisplay;
import com.Infinity.Nexus.Miner.config.ConfigUtils;
import com.Infinity.Nexus.Miner.utils.ModUtilsMiner;
import me.shedaniel.math.Point;
import me.shedaniel.math.Rectangle;
import me.shedaniel.rei.api.client.gui.Renderer;
import me.shedaniel.rei.api.client.gui.widgets.Widget;
import me.shedaniel.rei.api.client.gui.widgets.Widgets;
import me.shedaniel.rei.api.client.registry.display.DisplayCategory;
import me.shedaniel.rei.api.common.category.CategoryIdentifier;
import me.shedaniel.rei.api.common.util.EntryStacks;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;

import java.util.ArrayList;
import java.util.List;

public class MinerCategory implements DisplayCategory<MinerDisplay> {
    private static final int PADDING = 4;
    private static final int SLOT_SIZE = 18;

    @Override
    public CategoryIdentifier<? extends MinerDisplay> getCategoryIdentifier() {
        return MinerDisplay.CATEGORY;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.infinity_nexus_miner.miner");
    }

    @Override
    public Renderer getIcon() {
        return EntryStacks.of(ModBlocksMiner.MINER.get());
    }

    @Override
    public List<Widget> setupDisplay(MinerDisplay display, Rectangle bounds) {
        List<Widget> widgets = new ArrayList<>();
        widgets.add(Widgets.createRecipeBase(bounds));

        int x = bounds.x + PADDING;
        int y = bounds.y + PADDING;
        ResourceLocation texture = GetResourceLocation.withNamespaceAndPath(InfinityNexusMiner.MOD_ID, "textures/gui/jei/miner_gui_jei.png");
        widgets.add(Widgets.createTexturedWidget(texture, x, y, 0, 0, 176, 88));

        // Posições baseadas no layout JEI
        Point startPoint = new Point(bounds.x + PADDING, bounds.y + PADDING);

        // Mineradora (centro esquerdo)
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 44, startPoint.y + 29))
                .entry(EntryStacks.of(ModBlocksMiner.MINER.get())) // Use entry() instead of entries()
                .disableBackground());

        // Estrutura (esquerda)
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 26, startPoint.y + 29))
                .entry(EntryStacks.of(ConfigUtils.getStructureByLevel(ModUtilsMiner.getTierByItem(display.recipe().value().getTier().getValues().get(0)))))
                .disableBackground());

        // Componente (canto superior esquerdo)
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 8, startPoint.y + 29))
                .entries(display.getTierEntries().get(0))
                .markInput()
                .disableBackground());

        // Input (minério - centro)
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 44, startPoint.y + 47))
                .entries(display.getInputEntries().get(0))
                .markInput()
                .disableBackground());

        // Output (canto superior direito)
        widgets.add(Widgets.createSlot(new Point(startPoint.x + 80, startPoint.y + 11))
                .entries(display.getOutputEntries().get(0))
                .markOutput()
                .disableBackground());

        // Cristais (padrão de grade à direita)
        int[] crystalSlotX = {98, 116, 80, 98, 116, 80, 98, 116};
        int[] crystalSlotY = {11, 11, 29, 29, 29, 48, 48, 48};


        int tier = display.recipe().value().getTier().getValues().size() > 0 ?
                ModUtilsMiner.getTierByItem(display.recipe().value().getTier().getValues().get(0)) : 1;

        for(int i = 0; i < tier; i++) {
            widgets.add(Widgets.createSlot(new Point(startPoint.x + crystalSlotX[i], startPoint.y + crystalSlotY[i]))
                    .entry(EntryStacks.of(ModUtilsMiner.getCrystalType(i+1)))
                    .markOutput()
                    .disableBackground());
        }

        // Informações de energia e fortune (parte inferior)
        widgets.add(Widgets.createLabel(
                        new Point(startPoint.x + 6, startPoint.y + 76),
                        Component.literal(display.recipe().value().getEnergy() + " FE / Fortune: " +
                                (display.recipe().value().getFortune() ? "Yes" : "No")))
                .leftAligned());

        return widgets;
    }

    @Override
    public int getDisplayWidth(MinerDisplay display) {
        return 184; // Mesma largura do JEI
    }

    @Override
    public int getDisplayHeight() {
        return 96; // Mesma altura do JEI
    }

}