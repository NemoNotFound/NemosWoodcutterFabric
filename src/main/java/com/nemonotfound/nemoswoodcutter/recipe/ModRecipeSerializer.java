package com.nemonotfound.nemoswoodcutter.recipe;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;
import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModRecipeSerializer {

    public static void registerRecipeSerializer() {
        log.info("Register recipe serializer");

        Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MOD_ID, WoodcuttingRecipe.Serializer.ID),
                WoodcuttingRecipe.Serializer.INSTANCE);
    }
}
