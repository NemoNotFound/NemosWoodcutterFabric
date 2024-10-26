package com.nemonotfound.nemoswoodcutter.client.recipebook;

import com.nemonotfound.nemoswoodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class ClientModRecipeManager {

    private final WoodcuttingRecipeDisplay.Grouping woodcuttingRecipes;

    public ClientModRecipeManager(WoodcuttingRecipeDisplay.Grouping woodcuttingRecipes) {
        this.woodcuttingRecipes = woodcuttingRecipes;
    }

    public WoodcuttingRecipeDisplay.Grouping getWoodcutterRecipes() {
        return this.woodcuttingRecipes;
    }
}
