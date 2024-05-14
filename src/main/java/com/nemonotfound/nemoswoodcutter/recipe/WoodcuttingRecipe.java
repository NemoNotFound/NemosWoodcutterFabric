package com.nemonotfound.nemoswoodcutter.recipe;

import com.google.gson.JsonObject;
import com.mojang.datafixers.util.Pair;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import net.minecraft.util.JsonHelper;
import net.minecraft.world.World;

public class WoodcuttingRecipe implements Recipe<Inventory> {

    private final Identifier ID;
    private final ItemStack result;
    private final Pair<Ingredient, Integer> ingredientPair;

    public WoodcuttingRecipe(Identifier ID, ItemStack result, Pair<Ingredient, Integer> ingredientPair) {
        this.ID = ID;
        this.result = result;
        this.ingredientPair = ingredientPair;
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return ingredientPair.getFirst().test(inventory.getStack(0));
    }

    @Override
    public ItemStack craft(Inventory inventory, DynamicRegistryManager registryManager) {
        return result.copy();
    }

    public Pair<Ingredient, Integer> getIngredientPair() {
        return ingredientPair;
    }


    @Override
    public boolean fits(int width, int height) {
        return true;
    }

    @Override
    public ItemStack getOutput(DynamicRegistryManager registryManager) {
        return result;
    }

    @Override
    public Identifier getId() {
        return ID;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Serializer.INSTANCE;
    }

    @Override
    public RecipeType<?> getType() {
        return Type.INSTANCE;
    }

    public static class Type implements RecipeType<WoodcuttingRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "woodcutting";
    }

    public static class Serializer implements RecipeSerializer<WoodcuttingRecipe> {

        public static final Serializer INSTANCE = new Serializer();
        public static final String ID = "woodcutting";

        @Override
        public WoodcuttingRecipe read(Identifier id, JsonObject json) {
            String countString = "count";
            JsonObject ingredientJson = JsonHelper.getObject(json, "ingredient");
            Ingredient ingredient = Ingredient.fromJson(ingredientJson, false);
            JsonObject resultJson = JsonHelper.getObject(json, "result");
            String result = JsonHelper.getString(resultJson, "id");
            int ingredientCount = 1;
            int resultCount = 1;

            if (JsonHelper.hasElement(ingredientJson, countString)) {
                int count = JsonHelper.getInt(ingredientJson, countString);
                ingredientCount = count > 0 ? count : 1;
            }

            if (JsonHelper.hasElement(resultJson, "Count")) {
                int count = JsonHelper.getInt(resultJson, "Count");
                resultCount = count > 0 ? count : 1;
            }

            ItemStack resultItemStack = new ItemStack(Registries.ITEM.get(new Identifier(result)), resultCount);

            return new WoodcuttingRecipe(id, resultItemStack, Pair.of(ingredient, ingredientCount));
        }

        @Override
        public WoodcuttingRecipe read(Identifier id, PacketByteBuf buf) {
            Ingredient ingredient = Ingredient.fromPacket(buf);
            int ingredientCount = buf.readInt();
            ItemStack result = buf.readItemStack();

            return new WoodcuttingRecipe(id, result, Pair.of(ingredient, ingredientCount));
        }

        @Override
        public void write(PacketByteBuf buf, WoodcuttingRecipe recipe) {
            Pair<Ingredient, Integer> ingredientPair = recipe.getIngredientPair();
            ingredientPair.getFirst().write(buf);
            buf.writeInt(ingredientPair.getSecond());

            buf.writeItemStack(recipe.result);
        }
    }
}
