package com.nemonotfound.nemoswoodcutter.datagen;

import com.nemonotfound.nemoswoodcutter.block.ModBlocks;
import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipeJsonBuilder;
import net.minecraft.block.Block;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

public abstract class WoodcutterRecipeGenerator extends RecipeGenerator {

    protected WoodcutterRecipeGenerator(RegistryWrapper.WrapperLookup registries, RecipeExporter exporter) {
        super(registries, exporter);
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, TagKey<Item> inputTag, String criteria, Item output) {
        String tagPath = inputTag.id().getPath();
        Ingredient ingredient = ingredientFromTag(inputTag);

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, output)
                .criterion(criteria, this.conditionsFromTag(inputTag))
                .offerTo(exporter, convertBetween(output, tagPath) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, TagKey<Item> inputTag, String criteria, int inputCount, Item output) {
        String tagPath = inputTag.id().getPath();
        Ingredient ingredient = ingredientFromTag(inputTag);

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, inputCount, output)
                .criterion(criteria, this.conditionsFromTag(inputTag))
                .offerTo(exporter, convertBetween(output, tagPath) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, TagKey<Item> inputTag, String criteria, Item output, int outputCount) {
        String tagPath = inputTag.id().getPath();
        Ingredient ingredient = ingredientFromTag(inputTag);

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, output, outputCount)
                .criterion(criteria, this.conditionsFromTag(inputTag))
                .offerTo(exporter, convertBetween(output, tagPath) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, Block input, Item output) {
        Ingredient ingredient = Ingredient.ofItem(input);
        String blockName = Registries.BLOCK.getId(input).getPath();

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, output)
                .criterion(hasItem(input), this.conditionsFromItem(input))
                .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, Block input, int inputCount, Item output) {
        Ingredient ingredient = Ingredient.ofItem(input);
        String blockName = Registries.BLOCK.getId(input).getPath();

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, inputCount, output)
                .criterion(hasItem(input), this.conditionsFromItem(input))
                .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, Block input, Item output, int outputCount) {
        Ingredient ingredient = Ingredient.ofItem(input);
        String blockName = Registries.BLOCK.getId(input).getPath();

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, output, outputCount)
                .criterion(hasItem(input), this.conditionsFromItem(input))
                .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
    }

    protected void createWoodcuttingRecipe(RecipeCategory recipeCategory, Block input, int inputCount, Item output, int outputCount) {
        Ingredient ingredient = Ingredient.ofItem(input);
        String blockName = Registries.BLOCK.getId(input).getPath();

        WoodcuttingRecipeJsonBuilder.createWoodcutting(recipeCategory, ingredient, inputCount, output, outputCount)
                .criterion(hasItem(input), this.conditionsFromItem(input))
                .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
    }

    protected static String convertBetween(ItemConvertible to, String from) {
        return getItemPath(to) + "_from_" + from;
    }

    protected void createWoodCutterRecipe() {
        this.createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOODCUTTER)
                .input('I', Items.IRON_INGOT)
                .input('#', ItemTags.LOGS)
                .pattern(" I ")
                .pattern("###")
                .criterion("has_logs", this.conditionsFromTag(ItemTags.LOGS))
                .offerTo(exporter);
    }
}
