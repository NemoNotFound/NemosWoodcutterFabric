package com.nemonotfound.nemoswoodcutter.interfaces;

import com.nemonotfound.nemoswoodcutter.client.recipebook.ClientModRecipeManager;
import com.nemonotfound.nemoswoodcutter.recipe.display.WoodcuttingRecipeDisplay;

public interface ModRecipeManagerGetter {

    default ClientModRecipeManager nemo_sWoodcutter$getModRecipeManager() {
        return new ClientModRecipeManager(WoodcuttingRecipeDisplay.Grouping.empty());
    }
}
