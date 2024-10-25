package com.nemonotfound.nemoswoodcutter.recipe;

import com.nemonotfound.nemoswoodcutter.item.ModItems;
import com.nemonotfound.nemoswoodcutter.recipe.book.ModRecipeBookCategory;
import com.nemonotfound.nemoswoodcutter.recipe.display.WoodcutterRecipeDisplay;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.recipe.display.RecipeDisplay;
import net.minecraft.recipe.display.SlotDisplay;

import java.util.List;

public class WoodcuttingRecipe extends SingleStackWithCountRecipe {

    public WoodcuttingRecipe(String group, Ingredient ingredient, int inputCount, ItemStack result) {
        super(group, ingredient, inputCount, result);
    }

    @Override
    public RecipeSerializer<WoodcuttingRecipe> getSerializer() {
        return ModRecipeSerializer.WOODCUTTING;
    }

    @Override
    public RecipeType<WoodcuttingRecipe> getType() {
        return ModRecipeTypes.WOODCUTTING;
    }

    @Override
    public List<RecipeDisplay> getDisplays() {
        return List.of(new WoodcutterRecipeDisplay(this.ingredient().toDisplay(), this.createResultDisplay(),
                new SlotDisplay.ItemSlotDisplay(ModItems.WOODCUTTER)));
    }

    public SlotDisplay createResultDisplay() {
        return new SlotDisplay.StackSlotDisplay(this.result());
    }

    @Override
    public RecipeBookCategory getRecipeBookCategory() {
        return ModRecipeBookCategory.WOODCUTTER;
    }
}
