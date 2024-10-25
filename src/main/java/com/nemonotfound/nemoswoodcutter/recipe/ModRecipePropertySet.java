package com.nemonotfound.nemoswoodcutter.recipe;

import net.minecraft.recipe.RecipePropertySet;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;

public class ModRecipePropertySet {

    public static final RegistryKey<? extends Registry<RecipePropertySet>> REGISTRY = RegistryKey.ofRegistry(Identifier.ofVanilla("recipe_property_set"));
    public static final RegistryKey<RecipePropertySet> WOODCUTTER_INPUT = register("woodcutter_input");

    private static RegistryKey<RecipePropertySet> register(String id) {
        return RegistryKey.of(REGISTRY, Identifier.of(MOD_ID, id));
    }
}
