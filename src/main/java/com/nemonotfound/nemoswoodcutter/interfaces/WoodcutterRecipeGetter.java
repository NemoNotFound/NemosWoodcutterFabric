package com.nemonotfound.nemoswoodcutter.interfaces;

import com.nemonotfound.nemoswoodcutter.recipe.display.WoodcuttingRecipeDisplay;

public interface WoodcutterRecipeGetter {

    default WoodcuttingRecipeDisplay.Grouping nemo_sWoodcutter$getWoodcutterRecipeForSync() {
        return WoodcuttingRecipeDisplay.Grouping.empty();
    }

    default WoodcuttingRecipeDisplay.Grouping nemo_sWoodcutter$getWoodcutterRecipes() {
        return WoodcuttingRecipeDisplay.Grouping.empty();
    }
}
