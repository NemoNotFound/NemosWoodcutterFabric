package com.nemonotfound.nemoswoodcutter.mixin;

import com.nemonotfound.nemoswoodcutter.interfaces.WoodcutterRecipeGetter;
import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipe;
import com.nemonotfound.nemoswoodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.recipe.PreparedRecipes;
import net.minecraft.recipe.Recipe;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.resource.featuretoggle.FeatureSet;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Mixin(ServerRecipeManager.class)
public abstract class ServerRecipeManagerMixin implements WoodcutterRecipeGetter {

    @Shadow public abstract Collection<RecipeEntry<?>> values();

    @Shadow private PreparedRecipes preparedRecipes;
    @Unique
    private WoodcuttingRecipeDisplay.Grouping woodcutterRecipes;

    @Override
    public WoodcuttingRecipeDisplay.Grouping nemo_sWoodcutter$getWoodcutterRecipeForSync() {
        return this.woodcutterRecipes;
    }

    @Override
    public WoodcuttingRecipeDisplay.Grouping nemo_sWoodcutter$getWoodcutterRecipes() {
        return this.woodcutterRecipes;
    }

    @Inject(method = "<init>", at = @At("TAIL"))
    private void init(RegistryWrapper.WrapperLookup registries, CallbackInfo ci) {
        woodcutterRecipes = WoodcuttingRecipeDisplay.Grouping.empty();
    }

    @Inject(method = "initialize", at = @At("TAIL"))
    private void initialize(FeatureSet features, CallbackInfo ci) {
        List<WoodcuttingRecipeDisplay.GroupEntry> woodcuttingRecipeEntries = new ArrayList<>();
        this.preparedRecipes.recipes().forEach(
                recipeEntry -> {
                    Recipe<?> recipe = recipeEntry.value();
                    if (recipe instanceof WoodcuttingRecipe woodcuttingRecipe) {
                        woodcuttingRecipeEntries.add(new WoodcuttingRecipeDisplay.GroupEntry(woodcuttingRecipe.ingredient(),
                                woodcuttingRecipe.inputCount(), new WoodcuttingRecipeDisplay(woodcuttingRecipe.createResultDisplay(), Optional.of((RecipeEntry<WoodcuttingRecipe>) recipeEntry))));
                    }
                }
        );
        this.woodcutterRecipes = new WoodcuttingRecipeDisplay.Grouping(woodcuttingRecipeEntries);
    }
}
