package com.nemonotfound.nemoswoodcutter.recipe.display;

import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModRecipeDisplays {

    public static void registerRecipeDisplays() {
        log.info("Registering recipe displays");

        Registry.register(Registries.RECIPE_DISPLAY, "woodcutter", WoodcutterRecipeDisplay.SERIALIZER);
    }
}
