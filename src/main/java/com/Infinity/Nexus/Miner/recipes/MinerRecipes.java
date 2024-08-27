package com.Infinity.Nexus.Miner.recipes;

import com.Infinity.Nexus.Core.utils.ModUtils;
import com.Infinity.Nexus.Miner.InfinityNexusMiner;
import com.Infinity.Nexus.Miner.block.entity.MinerBlockEntity;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class MinerRecipes implements Recipe<SimpleContainer> {
    private final int energy;
    private final int level;
    private final boolean fortune;
    private final NonNullList<Ingredient> inputItems;
    private final ItemStack output;
    private final ResourceLocation id;

    public MinerRecipes( int energy, int level, boolean fortune, NonNullList<Ingredient> inputItems, ItemStack output, ResourceLocation id) {
        this.energy = energy;
        this.level = level;
        this.fortune = fortune;
        this.inputItems = inputItems;
        this.output = output;
        this.id = id;
    }


    @Override
    public boolean matches(SimpleContainer pContainer, Level pLevel) {
        if(pLevel.isClientSide()) {
            return false;
        }
        int componentSlot = MinerBlockEntity.getComponentSlot();
        ItemStack stack = pContainer.getItem(componentSlot);
        return (ModUtils.getComponentLevel(stack) >= level) && inputItems.get(0).test(pContainer.getItem(MinerBlockEntity.getRecipeSlot()));
    }

    @Override
    public NonNullList<Ingredient> getIngredients() {
        return inputItems;
    }

    @Override
    public ItemStack assemble(SimpleContainer pContainer, RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public  ItemStack getResultItem(RegistryAccess pRegistryAccess) {
        return output.copy();
    }

    public int getComponentLevel() {
        return level;
    }

    public int getEnergy() {
        return energy;
    }

    public boolean getFortune() {
        return fortune;
    }
    @Override
    public ResourceLocation getId() {
        return id;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<MinerRecipes> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "mining";
    }

    public static class Serializer implements RecipeSerializer<MinerRecipes> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(InfinityNexusMiner.MOD_ID, "mining");

        @Override
        public @NotNull MinerRecipes fromJson(@NotNull ResourceLocation pRecipeId, @NotNull JsonObject pSerializedRecipe) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(pSerializedRecipe, "output"));
            JsonArray ingredients = GsonHelper.getAsJsonArray(pSerializedRecipe, "ingredient");

            NonNullList<Ingredient> inputs = NonNullList.withSize(1, Ingredient.EMPTY);
            inputs.set(0, Ingredient.fromJson(ingredients.get(0)));

            int energy = pSerializedRecipe.get("energy").getAsInt();
            int level = pSerializedRecipe.get("level").getAsInt();
            boolean fortune = pSerializedRecipe.get("fortune").getAsBoolean();

            return new MinerRecipes(energy, level, fortune, inputs, output, pRecipeId);
        }

        @Override
        public @Nullable MinerRecipes fromNetwork(@NotNull ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
            int energy = pBuffer.readInt();
            int level = pBuffer.readInt();
            boolean fortune = pBuffer.readBoolean();

            NonNullList<Ingredient> inputs = NonNullList.withSize(pBuffer.readInt(), Ingredient.EMPTY);
            inputs.set(0, Ingredient.fromNetwork(pBuffer));

            ItemStack output = pBuffer.readItem();
            return new MinerRecipes(energy, level, fortune, inputs, output, pRecipeId);
        }

        @Override
        public void toNetwork(FriendlyByteBuf pBuffer, MinerRecipes pRecipe) {

            pBuffer.writeInt(pRecipe.getEnergy());
            pBuffer.writeInt(pRecipe.getComponentLevel());
            pBuffer.writeBoolean(pRecipe.getFortune());
            pBuffer.writeInt(pRecipe.getIngredients().size());

            for (Ingredient ingredient : pRecipe.getIngredients()) {
                ingredient.toNetwork(pBuffer);
            }
            pBuffer.writeItemStack(pRecipe.getResultItem(null), false);
        }
    }
}