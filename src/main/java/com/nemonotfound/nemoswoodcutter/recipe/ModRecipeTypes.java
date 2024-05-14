package com.nemonotfound.nemoswoodcutter.recipe;

import net.minecraft.recipe.RecipeType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;
import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModRecipeTypes {

    public static RecipeType<WoodcuttingRecipe> WOODCUTTING = Registry.register(Registry.RECIPE_TYPE,
            new Identifier(MOD_ID, WoodcuttingRecipe.Type.ID), WoodcuttingRecipe.Type.INSTANCE);

    public static void registerRecipeTypes() {
        log.info("Register recipe types");
    }
}
