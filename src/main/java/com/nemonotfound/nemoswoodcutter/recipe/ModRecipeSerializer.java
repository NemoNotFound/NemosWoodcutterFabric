package com.nemonotfound.nemoswoodcutter.recipe;

import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;
import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModRecipeSerializer {

    public static void registerRecipeSerializer() {
        log.info("Register recipe serializer");

        Registry.register(Registry.RECIPE_SERIALIZER, new Identifier(MOD_ID, WoodcuttingRecipe.Serializer.ID),
                WoodcuttingRecipe.Serializer.INSTANCE);
    }
}
