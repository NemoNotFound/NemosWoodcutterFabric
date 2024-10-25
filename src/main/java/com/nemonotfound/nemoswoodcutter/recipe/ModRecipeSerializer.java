package com.nemonotfound.nemoswoodcutter.recipe;

import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;
import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModRecipeSerializer {

    public static RecipeSerializer<WoodcuttingRecipe> WOODCUTTING = register("woodcutting", new SingleStackWithCountRecipe.Serializer<>(WoodcuttingRecipe::new));

    public static void registerRecipeSerializer() {
        log.info("Register recipe serializer");
    }

    private static <S extends RecipeSerializer<T>, T extends Recipe<?>> S register(String path, S serializer) {
        return Registry.register(Registries.RECIPE_SERIALIZER, Identifier.of(MOD_ID, path), serializer);
    }
}
