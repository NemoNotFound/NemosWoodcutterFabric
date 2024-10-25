package com.nemonotfound.nemoswoodcutter.client.recipebook;

import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipe;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.recipe.display.CuttingRecipeDisplay;

@Environment(EnvType.CLIENT)
public class ClientModRecipeManager {

    private final CuttingRecipeDisplay.Grouping<WoodcuttingRecipe> woodcuttingRecipes;

    public ClientModRecipeManager(CuttingRecipeDisplay.Grouping<WoodcuttingRecipe> woodcuttingRecipes) {
        this.woodcuttingRecipes = woodcuttingRecipes;
    }

    public CuttingRecipeDisplay.Grouping<WoodcuttingRecipe> getWoodcutterRecipes() {
        return this.woodcuttingRecipes;
    }
}
