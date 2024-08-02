package com.Infinity.Nexus.Miner.compat;


import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.ModBlocksMiner;
import com.Infinity.Nexus.Miner.config.ConfigUtils;
import com.Infinity.Nexus.Miner.recipes.MinerRecipes;
import com.Infinity.Nexus.Miner.utils.ModUtilsMiner;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;

public class MinerCategory implements IRecipeCategory<MinerRecipes> {

    public static final ResourceLocation UID = new ResourceLocation(InfinityNexusMiner.MOD_ID, "mining");
    public static final ResourceLocation TEXTURE = new ResourceLocation(InfinityNexusMiner.MOD_ID, "textures/gui/jei/miner_gui_jei.png");

    public static final RecipeType<MinerRecipes> MINER_TYPE = new RecipeType<>(UID, MinerRecipes.class);

    private final IDrawable background;
    private final IDrawable icon;

    public MinerCategory(IGuiHelper helper) {
        this.background = helper.createDrawable(TEXTURE, 0, 0, 176, 88);
        this.icon = helper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModBlocksMiner.MINER.get()));
    }

    @Override
    public RecipeType<MinerRecipes> getRecipeType() {
        return MINER_TYPE;
    }

    @Override
    public Component getTitle() {
        return Component.translatable("block.infinity_nexus_miner.miner");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public void draw(MinerRecipes recipe, IRecipeSlotsView recipeSlotsView, GuiGraphics guiGraphics, double mouseX, double mouseY) {
        Minecraft minecraft = Minecraft.getInstance();
        guiGraphics.drawString(minecraft.font, recipe.getEnergy() + " FE", 6, 76, 0xFFFFFF, false);
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, MinerRecipes rcp, IFocusGroup focuses) {
        MinerRecipes recipe = rcp;
        Ingredient ingredient = recipe.getIngredients().get(0);

        ItemStack miner = ModBlocksMiner.MINER.get().asItem().getDefaultInstance();
        ItemStack structure = ConfigUtils.getStructureByLevel(recipe.getComponentLevel());
        ItemStack component = ConfigUtils.getComponentByLevel(recipe.getComponentLevel());
        int tier = recipe.getComponentLevel();
        int [] crystalSlotX = {98, 116, 80, 98, 116, 80, 98, 116};
        int [] crystalSlotY = {11, 11, 29, 29, 29, 48, 48, 48};

        ItemStack output = recipe.getResultItem(null);

        //Mineradora
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 44, 29).addItemStack(miner);
        //Lado Esquerdo
        builder.addSlot(RecipeIngredientRole.RENDER_ONLY, 26, 29).addItemStack(structure.setHoverName(Component.literal("§6Structure: §e"+ structure.getHoverName().getString())));
        //Ore
        builder.addSlot(RecipeIngredientRole.INPUT, 44, 47).addIngredients(ingredient);
        //Componente
        builder.addSlot(RecipeIngredientRole.CATALYST, 8, 29).addItemStack(component.setHoverName(Component.literal("§6Component: §e"+ component.getHoverName().getString())));
        //Saida
        builder.addSlot(RecipeIngredientRole.OUTPUT, 80, 11).addItemStack(output.setHoverName(Component.literal("§6Output: §e"+ output.getHoverName().getString())));
        //Cystals

        for(int i = 0; i <= tier -1; i++) {
            ItemStack secondaryOutput = ModUtilsMiner.getCrystalType(i+1);
            builder.addSlot(RecipeIngredientRole.OUTPUT, crystalSlotX[i], crystalSlotY[i]).addItemStack(secondaryOutput.setHoverName(Component.literal("§6Secondary Output: §e\n"+ secondaryOutput.getHoverName().getString()).append("§6Chance: §9" + ((1 * tier) - i) + "%")));
        }
    }
}
