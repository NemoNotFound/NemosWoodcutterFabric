package com.nemonotfound.nemoswoodcutter.recipe;

import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;
import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModRecipeTypes {

    public static RecipeType<WoodcuttingRecipe> WOODCUTTING = Registry.register(Registries.RECIPE_TYPE,
            Identifier.of(MOD_ID, WoodcuttingRecipe.Type.ID), WoodcuttingRecipe.Type.INSTANCE);

    public static void registerRecipeTypes() {
        log.info("Register recipe types");
    }
}
