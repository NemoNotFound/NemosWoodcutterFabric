package com.nemonotfound.nemoswoodcutter.recipe.book;

import net.minecraft.recipe.book.RecipeBookCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;
import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModRecipeBookCategory {

    public static final RecipeBookCategory WOODCUTTER = register("woodcutter");

    public static void registerRecipeBookCategories() {
        log.info("Registering recipe book categories");
    }

    private static RecipeBookCategory register(String path) {
        return Registry.register(Registries.RECIPE_BOOK_CATEGORY, Identifier.of(MOD_ID, path), new RecipeBookCategory());
    }
}
