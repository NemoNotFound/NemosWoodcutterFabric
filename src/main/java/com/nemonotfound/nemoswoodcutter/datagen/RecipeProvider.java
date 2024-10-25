package com.nemonotfound.nemoswoodcutter.datagen;

import com.mojang.datafixers.util.Pair;
import com.nemonotfound.nemoswoodcutter.block.ModBlocks;
import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipeJsonBuilder;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.RecipeGenerator;
import net.minecraft.data.server.recipe.VanillaRecipeGenerator;
import net.minecraft.item.Item;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;

import java.util.concurrent.CompletableFuture;

public class RecipeProvider extends FabricRecipeProvider {


    public RecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                createWoodCutterRecipe();

                createWoodcuttingRecipe(ItemTags.PLANKS, "has_planks", Items.COMPOSTER);
                createWoodcuttingRecipe(ItemTags.LOGS, "has_planks", Items.COMPOSTER, 4);
                createWoodcuttingRecipe(ItemTags.PLANKS, "has_planks", Items.CRAFTING_TABLE);
                createWoodcuttingRecipe(ItemTags.LOGS, "has_planks", Items.CRAFTING_TABLE, 4);
                createWoodcuttingRecipe(ItemTags.PLANKS, "has_planks", 4, Items.BARREL);
                createWoodcuttingRecipe(ItemTags.LOGS, "has_planks", Items.BARREL);
                createWoodcuttingRecipe(ItemTags.PLANKS, "has_planks",4, Items.CHEST);
                createWoodcuttingRecipe(ItemTags.LOGS, "has_planks", Items.CHEST);

                createWoodcuttingRecipe(Blocks.ACACIA_LOG, Items.STRIPPED_ACACIA_LOG);
                createWoodcuttingRecipe(Blocks.ACACIA_WOOD, Items.STRIPPED_ACACIA_WOOD);

                createWoodcuttingRecipe(Blocks.BAMBOO_BLOCK, Items.STRIPPED_BAMBOO_BLOCK);

                createWoodcuttingRecipe(Blocks.BIRCH_LOG, Items.STRIPPED_BIRCH_LOG);
                createWoodcuttingRecipe(Blocks.BIRCH_WOOD, Items.STRIPPED_BIRCH_WOOD);

                createWoodcuttingRecipe(Blocks.CHERRY_LOG, Items.STRIPPED_CHERRY_LOG);
                createWoodcuttingRecipe(Blocks.CHERRY_WOOD, Items.STRIPPED_CHERRY_WOOD);

                createWoodcuttingRecipe(Blocks.CRIMSON_STEM, Items.STRIPPED_CRIMSON_STEM);
                createWoodcuttingRecipe(Blocks.CRIMSON_HYPHAE, Items.STRIPPED_CRIMSON_HYPHAE);

                createWoodcuttingRecipe(Blocks.DARK_OAK_LOG, Items.STRIPPED_DARK_OAK_LOG);
                createWoodcuttingRecipe(Blocks.DARK_OAK_WOOD, Items.STRIPPED_DARK_OAK_WOOD);

                createWoodcuttingRecipe(Blocks.JUNGLE_LOG, Items.STRIPPED_JUNGLE_LOG);
                createWoodcuttingRecipe(Blocks.JUNGLE_WOOD, Items.STRIPPED_JUNGLE_WOOD);

                createWoodcuttingRecipe(Blocks.MANGROVE_LOG, Items.STRIPPED_MANGROVE_LOG);
                createWoodcuttingRecipe(Blocks.MANGROVE_WOOD, Items.STRIPPED_MANGROVE_WOOD);

                createWoodcuttingRecipe(Blocks.OAK_LOG, Items.STRIPPED_OAK_LOG);
                createWoodcuttingRecipe(Blocks.OAK_WOOD, Items.STRIPPED_OAK_WOOD);

                createWoodcuttingRecipe(Blocks.SPRUCE_LOG, Items.STRIPPED_SPRUCE_LOG);
                createWoodcuttingRecipe(Blocks.SPRUCE_WOOD, Items.STRIPPED_SPRUCE_WOOD);

                createWoodcuttingRecipe(Blocks.WARPED_STEM, Items.STRIPPED_WARPED_STEM);
                createWoodcuttingRecipe(Blocks.WARPED_HYPHAE, Items.STRIPPED_WARPED_HYPHAE);

                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, 2, Items.ACACIA_BOAT);
                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, Items.ACACIA_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, 2, Items.ACACIA_DOOR, 2);
                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, Items.ACACIA_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, Items.ACACIA_FENCE);
                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, Items.ACACIA_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, Items.ACACIA_SIGN, 3);
                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, Items.ACACIA_SLAB, 2);
                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, Items.ACACIA_STAIRS);
                createWoodcuttingRecipe(Blocks.ACACIA_PLANKS, Items.ACACIA_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, 2, Items.BAMBOO_RAFT);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, 2, Items.BAMBOO_DOOR, 2);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_FENCE);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_MOSAIC_SLAB, 2);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_MOSAIC_STAIRS);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_MOSAIC);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_SIGN, 3);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_SLAB, 2);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_STAIRS);
                createWoodcuttingRecipe(Blocks.BAMBOO_PLANKS, Items.BAMBOO_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.BAMBOO_MOSAIC, Items.BAMBOO_MOSAIC_SLAB, 2);
                createWoodcuttingRecipe(Blocks.BAMBOO_MOSAIC, Items.BAMBOO_MOSAIC_STAIRS);

                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, 2, Items.BIRCH_BOAT);
                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, Items.BIRCH_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, 2, Items.BIRCH_DOOR, 2);
                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, Items.BIRCH_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, Items.BIRCH_FENCE);
                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, Items.BIRCH_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, Items.BIRCH_SIGN, 3);
                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, Items.BIRCH_SLAB, 2);
                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, Items.BIRCH_STAIRS);
                createWoodcuttingRecipe(Blocks.BIRCH_PLANKS, Items.BIRCH_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, 2, Items.CHERRY_BOAT);
                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, Items.CHERRY_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, 2, Items.CHERRY_DOOR, 2);
                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, Items.CHERRY_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, Items.CHERRY_FENCE);
                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, Items.CHERRY_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, Items.CHERRY_SIGN, 3);
                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, Items.CHERRY_SLAB, 2);
                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, Items.CHERRY_STAIRS);
                createWoodcuttingRecipe(Blocks.CHERRY_PLANKS, Items.CHERRY_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.CRIMSON_PLANKS, Items.CRIMSON_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.CRIMSON_PLANKS, 2, Items.CRIMSON_DOOR, 2);
                createWoodcuttingRecipe(Blocks.CRIMSON_PLANKS, Items.CRIMSON_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.CRIMSON_PLANKS, Items.CRIMSON_FENCE);
                createWoodcuttingRecipe(Blocks.CRIMSON_PLANKS, Items.CRIMSON_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.CRIMSON_PLANKS, Items.CRIMSON_SIGN, 3);
                createWoodcuttingRecipe(Blocks.CRIMSON_PLANKS, Items.CRIMSON_SLAB, 2);
                createWoodcuttingRecipe(Blocks.CRIMSON_PLANKS, Items.CRIMSON_STAIRS);
                createWoodcuttingRecipe(Blocks.CRIMSON_PLANKS, Items.CRIMSON_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, 2, Items.DARK_OAK_BOAT);
                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, 2, Items.DARK_OAK_DOOR, 2);
                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_FENCE);
                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_SIGN, 3);
                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_SLAB, 2);
                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_STAIRS);
                createWoodcuttingRecipe(Blocks.DARK_OAK_PLANKS, Items.DARK_OAK_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, 2, Items.JUNGLE_BOAT);
                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, Items.JUNGLE_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, 2, Items.JUNGLE_DOOR, 2);
                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, Items.JUNGLE_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, Items.JUNGLE_FENCE);
                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, Items.JUNGLE_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, Items.JUNGLE_SIGN, 3);
                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, Items.JUNGLE_SLAB, 2);
                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, Items.JUNGLE_STAIRS);
                createWoodcuttingRecipe(Blocks.JUNGLE_PLANKS, Items.JUNGLE_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, 2, Items.MANGROVE_BOAT);
                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, Items.MANGROVE_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, 2, Items.MANGROVE_DOOR, 2);
                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, Items.MANGROVE_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, Items.MANGROVE_FENCE);
                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, Items.MANGROVE_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, Items.MANGROVE_SIGN, 3);
                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, Items.MANGROVE_SLAB, 2);
                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, Items.MANGROVE_STAIRS);
                createWoodcuttingRecipe(Blocks.MANGROVE_PLANKS, Items.MANGROVE_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.OAK_PLANKS, 2, Items.OAK_BOAT);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, Items.OAK_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, 2, Items.OAK_DOOR, 2);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, Items.OAK_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, Items.OAK_FENCE);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, Items.LADDER, 2);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, Items.OAK_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, Items.OAK_SIGN, 3);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, Items.OAK_SLAB, 2);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, Items.OAK_STAIRS);
                createWoodcuttingRecipe(Blocks.OAK_PLANKS, Items.OAK_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, 2, Items.SPRUCE_BOAT);
                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, Items.SPRUCE_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, 2, Items.SPRUCE_DOOR, 2);
                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, Items.SPRUCE_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, Items.SPRUCE_FENCE);
                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, Items.SPRUCE_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, Items.SPRUCE_SIGN, 3);
                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, Items.SPRUCE_SLAB, 2);
                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, Items.SPRUCE_STAIRS);
                createWoodcuttingRecipe(Blocks.SPRUCE_PLANKS, Items.SPRUCE_TRAPDOOR, 2);

                createWoodcuttingRecipe(Blocks.WARPED_PLANKS, Items.WARPED_BUTTON, 4);
                createWoodcuttingRecipe(Blocks.WARPED_PLANKS, 2, Items.WARPED_DOOR, 2);
                createWoodcuttingRecipe(Blocks.WARPED_PLANKS, Items.WARPED_FENCE_GATE);
                createWoodcuttingRecipe(Blocks.WARPED_PLANKS, Items.WARPED_FENCE);
                createWoodcuttingRecipe(Blocks.WARPED_PLANKS, Items.WARPED_PRESSURE_PLATE, 4);
                createWoodcuttingRecipe(Blocks.WARPED_PLANKS, Items.WARPED_SIGN, 3);
                createWoodcuttingRecipe(Blocks.WARPED_PLANKS, Items.WARPED_SLAB, 2);
                createWoodcuttingRecipe(Blocks.WARPED_PLANKS, Items.WARPED_STAIRS);
                createWoodcuttingRecipe(Blocks.WARPED_PLANKS, Items.WARPED_TRAPDOOR, 2);

                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_BOAT);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.ACACIA_LOGS, "acacia_logs", Items.ACACIA_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_RAFT);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_MOSAIC_SLAB, 2);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_MOSAIC_STAIRS);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_MOSAIC);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.BAMBOO_BLOCKS, "bamboo_blocks", Items.BAMBOO_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_BOAT);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.BIRCH_LOGS, "birch_logs", Items.BIRCH_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_BOAT);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.CHERRY_LOGS, "cherry_logs", Items.CHERRY_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.CRIMSON_STEMS, "crimson_stems", Items.CRIMSON_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_BOAT);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.DARK_OAK_LOGS, "dark_oak_logs", Items.DARK_OAK_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_BOAT);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.JUNGLE_LOGS, "jungle_logs", Items.JUNGLE_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS,"mangrove_logs", Items.MANGROVE_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_BOAT);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.MANGROVE_LOGS, "mangrove_logs", Items.MANGROVE_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_BOAT);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.OAK_LOGS, "oak_logs", Items.OAK_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_BOAT);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.SPRUCE_LOGS, "spruce_logs", Items.SPRUCE_TRAPDOOR, 8);

                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_PLANKS, 4);
                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_BUTTON, 16);
                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_DOOR, 4);
                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_FENCE_GATE, 4);
                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_FENCE, 4);
                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_PRESSURE_PLATE, 16);
                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_SIGN, 12);
                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_SLAB, 8);
                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_STAIRS, 4);
                createWoodcuttingRecipe(ItemTags.WARPED_STEMS, "warped_stems", Items.WARPED_TRAPDOOR, 8);
            }

            private void createWoodcuttingRecipe(TagKey<Item> inputTag, String criteria, Item output) {
                String tagPath = inputTag.id().getPath();
                Ingredient ingredient = ingredientFromTag(inputTag);

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, output)
                        .criterion(criteria, this.conditionsFromTag(inputTag))
                        .offerTo(exporter, convertBetween(output, tagPath) + "_woodcutting");
            }

            private void createWoodcuttingRecipe(TagKey<Item> inputTag, String criteria, int inputCount, Item output) {
                String tagPath = inputTag.id().getPath();
                Ingredient ingredient = ingredientFromTag(inputTag);

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, inputCount, output)
                        .criterion(criteria, this.conditionsFromTag(inputTag))
                        .offerTo(exporter, convertBetween(output, tagPath) + "_woodcutting");
            }

            private void createWoodcuttingRecipe(TagKey<Item> inputTag, String criteria, Item output, int outputCount) {
                String tagPath = inputTag.id().getPath();
                Ingredient ingredient = ingredientFromTag(inputTag);

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, output, outputCount)
                        .criterion(criteria, this.conditionsFromTag(inputTag))
                        .offerTo(exporter, convertBetween(output, tagPath) + "_woodcutting");
            }

            private void createWoodcuttingRecipe(Block input, Item output) {
                Ingredient ingredient = Ingredient.ofItem(input);
                String blockName = Registries.BLOCK.getId(input).getPath();

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, output)
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

            private void createWoodcuttingRecipe(Block input, Item output, int outputCount) {
                Ingredient ingredient = Ingredient.ofItem(input);
                String blockName = Registries.BLOCK.getId(input).getPath();

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, output, outputCount)
                        .criterion(hasItem(input), this.conditionsFromItem(input))
                        .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
            }

            private void createWoodcuttingRecipe(Block input, int inputCount, Item output, int outputCount) {
                Ingredient ingredient = Ingredient.ofItem(input);
                String blockName = Registries.BLOCK.getId(input).getPath();

                WoodcuttingRecipeJsonBuilder.createWoodcutting(RecipeCategory.DECORATIONS, ingredient, inputCount, output, outputCount)
                        .criterion(hasItem(input), this.conditionsFromItem(input))
                        .offerTo(exporter, convertBetween(output, blockName) + "_woodcutting");
            }

            public static String convertBetween(ItemConvertible to, String from) {
                return getItemPath(to) + "_from_" + from;
            }

            private void createWoodCutterRecipe() {
                this.createShaped(RecipeCategory.DECORATIONS, ModBlocks.WOODCUTTER)
                        .input('I', Items.IRON_INGOT)
                        .input('#', ItemTags.LOGS)
                        .pattern(" I ")
                        .pattern("###")
                        .criterion("has_logs", this.conditionsFromTag(ItemTags.LOGS))
                        .offerTo(exporter);
            }
        };
    }

    @Override
    public String getName() {
        return "Nemo's Woodcutter Recipes";
    }
}
