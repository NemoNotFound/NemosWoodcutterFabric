package com.nemonotfound.nemoswoodcutter.datagen;

import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipeJsonBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
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
import net.minecraft.resource.featuretoggle.FeatureFlags;
import net.minecraft.resource.featuretoggle.FeatureSet;

import java.util.concurrent.CompletableFuture;

public class WinterDropRecipeProvider extends FabricRecipeProvider {

    public WinterDropRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {

            @Override
            public void generate() {
                this.generateFamilies(FeatureSet.of(FeatureFlags.WINTER_DROP));

                createWoodcuttingRecipe(Blocks.PALE_OAK_LOG, Items.STRIPPED_PALE_OAK_LOG);
                createWoodcuttingRecipe(Blocks.PALE_OAK_WOOD, Items.STRIPPED_PALE_OAK_WOOD);

                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, 2, Items.PALE_OAK_BOAT);
                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, 2, Items.PALE_OAK_DOOR, 2);
                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_FENCE);
                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_SIGN, 3);
                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_SLAB, 2);
                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_STAIRS);
                createWoodcuttingRecipe(Blocks.PALE_OAK_PLANKS, Items.PALE_OAK_TRAPDOOR, 2);

                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_BOAT);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.PALE_OAK_LOGS, "pale_oak_logs", Items.PALE_OAK_TRAPDOOR, 8);
            }

            private void createWoodcuttingRecipe(TagKey<Item> inputTag, String criteria, Item output) {
                String tagPath = inputTag.id().getPath();
                Ingredient ingredient = ingredientFromTag(inputTag);

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, output)
                        .criterion(criteria, this.conditionsFromTag(inputTag))
                        .offerTo(exporter, convertBetween(output, tagPath) + "_woodcutting");
            }

            private void createWoodcuttingRecipe(Block input, int inputCount, Item output, int outputCount) {
                Ingredient ingredient = Ingredient.ofItem(input);
                String blockName = Registries.BLOCK.getId(input).getPath();

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, inputCount, output, outputCount)
                        .criterion(hasItem(input), this.conditionsFromItem(input))
                        .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
            }

            private void createWoodcuttingRecipe(Block input, int inputCount, Item output) {
                Ingredient ingredient = Ingredient.ofItem(input);
                String blockName = Registries.BLOCK.getId(input).getPath();

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, inputCount, output)
                        .criterion(hasItem(input), this.conditionsFromItem(input))
                        .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
            }

            private void createWoodcuttingRecipe(Block input, Item output) {
                Ingredient ingredient = Ingredient.ofItem(input);
                String blockName = Registries.BLOCK.getId(input).getPath();

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, output)
                        .criterion(hasItem(input), this.conditionsFromItem(input))
                        .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
            }

            private void createWoodcuttingRecipe(Block input, Item output, int outputCount) {
                Ingredient ingredient = Ingredient.ofItem(input);
                String blockName = Registries.BLOCK.getId(input).getPath();

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, output, outputCount)
                        .criterion(hasItem(input), this.conditionsFromItem(input))
                        .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
            }

            private void createWoodcuttingRecipe(TagKey<Item> inputTag, String criteria, Item output, int outputCount) {
                String tagPath = inputTag.id().getPath();
                Ingredient ingredient = ingredientFromTag(inputTag);

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, output, outputCount)
                        .criterion(criteria, this.conditionsFromTag(inputTag))
                        .offerTo(exporter, convertBetween(output, tagPath) + "_woodcutting");
            }

            private String convertBetween(ItemConvertible to, String from) {
                return getItemPath(to) + "_from_" + from;
            }
        };
    }

    @Override
    public String getName() {
        return "Nemo's Woodcutter Winter Drop Recipes";
    }
}
