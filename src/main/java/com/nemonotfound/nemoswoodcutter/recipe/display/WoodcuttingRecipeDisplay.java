package com.nemonotfound.nemoswoodcutter.recipe.display;

import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipe;
import net.minecraft.item.ItemStack;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.display.SlotDisplay;

import java.util.List;
import java.util.Optional;

public record WoodcuttingRecipeDisplay(SlotDisplay optionDisplay, Optional<RecipeEntry<WoodcuttingRecipe>> recipe) {

    public static PacketCodec<RegistryByteBuf, WoodcuttingRecipeDisplay> codec() {
        return PacketCodec.tuple(SlotDisplay.PACKET_CODEC,
                WoodcuttingRecipeDisplay::optionDisplay, display -> new WoodcuttingRecipeDisplay(display, Optional.empty()));
    }

    public record GroupEntry(Ingredient input, int inputCount, WoodcuttingRecipeDisplay recipe) {

        public static PacketCodec<RegistryByteBuf, WoodcuttingRecipeDisplay.GroupEntry> codec() {
            return PacketCodec.tuple(
                    Ingredient.PACKET_CODEC,
                    WoodcuttingRecipeDisplay.GroupEntry::input,
                    PacketCodecs.INTEGER,
                    WoodcuttingRecipeDisplay.GroupEntry::inputCount,
                    WoodcuttingRecipeDisplay.codec(),
                    WoodcuttingRecipeDisplay.GroupEntry::recipe,
                    WoodcuttingRecipeDisplay.GroupEntry::new
            );
        }
    }

    public record Grouping(List<WoodcuttingRecipeDisplay.GroupEntry> entries) {

        public static WoodcuttingRecipeDisplay.Grouping empty() {
            return new WoodcuttingRecipeDisplay.Grouping(List.of());
        }

        public static PacketCodec<RegistryByteBuf, WoodcuttingRecipeDisplay.Grouping> codec() {
            return PacketCodec.tuple(
                    WoodcuttingRecipeDisplay.GroupEntry.codec().collect(PacketCodecs.toList()),
                    WoodcuttingRecipeDisplay.Grouping::entries, WoodcuttingRecipeDisplay.Grouping::new
            );
        }

        public boolean contains(ItemStack stack) {
            return this.entries.stream().anyMatch(entry -> entry.input.test(stack));
        }

        public WoodcuttingRecipeDisplay.Grouping filter(ItemStack stack) {
            return new WoodcuttingRecipeDisplay.Grouping(this.entries.stream().filter(entry -> entry.input.test(stack)).toList());
        }

        public boolean isEmpty() {
            return this.entries.isEmpty();
        }

        public int size() {
            return this.entries.size();
        }
    }
}
