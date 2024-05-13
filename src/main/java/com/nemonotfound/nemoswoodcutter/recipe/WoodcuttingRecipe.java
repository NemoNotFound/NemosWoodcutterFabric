package com.nemonotfound.nemoswoodcutter.recipe;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.RegistryWrapper;
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
    public ItemStack craft(Inventory inventory, RegistryWrapper.WrapperLookup lookup) {
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
    public ItemStack getResult(RegistryWrapper.WrapperLookup registriesLookup) {
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
        public static final MapCodec<WoodcuttingRecipe> CODEC = RecordCodecBuilder.mapCodec(instance -> instance.group(
                ItemStack.VALIDATED_CODEC.fieldOf("result").forGetter(recipe -> recipe.result),
                Codec.pair(Ingredient.DISALLOW_EMPTY_CODEC, Codec.INT.optionalFieldOf("count", 1)
                        .codec()).fieldOf("ingredient").forGetter(WoodcuttingRecipe::getIngredientPair)
        ).apply(instance, WoodcuttingRecipe::new));
        private final PacketCodec<RegistryByteBuf, WoodcuttingRecipe> packetCodec;
        public static final String ID = "woodcutting";

        public Serializer() {
            this.packetCodec = PacketCodec.ofStatic(this::write, this::read);
        }

        @Override
        public MapCodec<WoodcuttingRecipe> codec() {
            return CODEC;
        }

        @Override
        public PacketCodec<RegistryByteBuf, WoodcuttingRecipe> packetCodec() {
            return packetCodec;
        }

        public WoodcuttingRecipe read(RegistryByteBuf buf) {
            Ingredient ingredient = Ingredient.PACKET_CODEC.decode(buf);
            int ingredientCount = buf.readInt();
            ItemStack result = ItemStack.PACKET_CODEC.decode(buf);

            return new WoodcuttingRecipe(result, Pair.of(ingredient, ingredientCount));
        }

        public void write(RegistryByteBuf buf, WoodcuttingRecipe recipe) {
            Pair<Ingredient, Integer> ingredientPair = recipe.getIngredientPair();
            Ingredient.PACKET_CODEC.encode(buf, ingredientPair.getFirst());
            buf.writeInt(ingredientPair.getSecond());

            ItemStack.PACKET_CODEC.encode(buf, recipe.result);
        }
    }
}
