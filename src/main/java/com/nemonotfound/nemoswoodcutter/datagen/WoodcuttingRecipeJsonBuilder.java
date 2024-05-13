package com.nemonotfound.nemoswoodcutter.datagen;

import com.mojang.datafixers.util.Pair;
import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipe;
import net.minecraft.advancement.Advancement;
import net.minecraft.advancement.AdvancementCriterion;
import net.minecraft.advancement.AdvancementRequirements;
import net.minecraft.advancement.AdvancementRewards;
import net.minecraft.advancement.criterion.RecipeUnlockedCriterion;
import net.minecraft.data.server.recipe.CraftingRecipeJsonBuilder;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.Nullable;

import java.util.LinkedHashMap;
import java.util.Map;

public class WoodcuttingRecipeJsonBuilder implements CraftingRecipeJsonBuilder {

    private final RecipeCategory category;
    private final Item output;
    private final int count;
    private Pair<Ingredient, Integer> ingredientPair;
    private final Map<String, AdvancementCriterion<?>> advancementBuilder = new LinkedHashMap<>();

    public WoodcuttingRecipeJsonBuilder(RecipeCategory category, ItemConvertible output, int count) {
        this.category = category;
        this.output = output.asItem();
        this.count = count;
    }

    public static WoodcuttingRecipeJsonBuilder create(RecipeCategory category, ItemConvertible output, int count) {
        return new WoodcuttingRecipeJsonBuilder(category, output, count);
    }

    public WoodcuttingRecipeJsonBuilder input(Ingredient ingredient, int ingredientCount) {
        this.ingredientPair = Pair.of(ingredient, ingredientCount);

        return this;
    }

    @Override
    public WoodcuttingRecipeJsonBuilder criterion(String string, AdvancementCriterion<?> advancementCriterion) {
        this.advancementBuilder.put(string, advancementCriterion);
        return this;
    }

    @Override
    public CraftingRecipeJsonBuilder group(@Nullable String group) {
        return null;
    }

    @Override
    public Item getOutputItem() {
        return this.output;
    }

    @Override
    public void offerTo(RecipeExporter exporter, Identifier recipeId) {
        this.validate(recipeId);
        Advancement.Builder builder = exporter.getAdvancementBuilder().criterion("has_the_recipe", RecipeUnlockedCriterion.create(recipeId)).rewards(AdvancementRewards.Builder.recipe(recipeId)).criteriaMerger(AdvancementRequirements.CriterionMerger.OR);
        this.advancementBuilder.forEach(builder::criterion);
        WoodcuttingRecipe carpentryRecipe = new WoodcuttingRecipe(new ItemStack(this.output, this.count),
                this.ingredientPair);
        exporter.accept(recipeId, carpentryRecipe, builder.build(recipeId.withPrefixedPath("recipes/" + this.category.getName() + "/")));
    }

    private void validate(Identifier recipeId) {
        if (this.advancementBuilder.isEmpty()) {
            throw new IllegalStateException("No way of obtaining recipe " + recipeId);
        }
    }
}
