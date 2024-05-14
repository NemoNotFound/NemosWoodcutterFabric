package com.nemonotfound.nemoswoodcutter.recipe;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.PacketByteBuf;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.world.World;

public class WoodcuttingRecipe implements Recipe<Inventory> {

    private final ItemStack result;
    private final Pair<Ingredient, Integer> ingredientPair;

    public WoodcuttingRecipe(ItemStack result, Pair<Ingredient, Integer> ingredientPair) {
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
    public ItemStack getResult(DynamicRegistryManager registryManager) {
        return result;
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
        public static final Codec<WoodcuttingRecipe> CODEC = RecordCodecBuilder.create(instance -> instance.group(
                ItemStack.CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                Codec.pair(Ingredient.DISALLOW_EMPTY_CODEC, Codec.INT.optionalFieldOf("count", 1)
                        .codec()).fieldOf("ingredient").forGetter(WoodcuttingRecipe::getIngredientPair)
        ).apply(instance, WoodcuttingRecipe::new));
        public static final String ID = "woodcutting";

        @Override
        public Codec<WoodcuttingRecipe> codec() {
            return CODEC;
        }

        @Override
        public WoodcuttingRecipe read(PacketByteBuf buf) {
            Ingredient ingredient = Ingredient.fromPacket(buf);
            int ingredientCount = buf.readInt();
            ItemStack result = buf.readItemStack();

            return new WoodcuttingRecipe(result, Pair.of(ingredient, ingredientCount));
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
