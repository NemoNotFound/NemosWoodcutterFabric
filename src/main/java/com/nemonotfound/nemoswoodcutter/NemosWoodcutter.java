package com.nemonotfound.nemoswoodcutter;

import com.nemonotfound.nemoswoodcutter.block.ModBlocks;
import com.nemonotfound.nemoswoodcutter.recipe.WoodcutterSerializer;
import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipe;
import com.nemonotfound.nemoswoodcutter.screen.WoodcutterScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.Blocks;
import net.minecraft.item.ItemGroups;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NemosWoodcutter implements ModInitializer {

	public static final String MOD_ID = "nemos-woodcutter";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);
	public static final ScreenHandlerType<WoodcutterScreenHandler> WOODCUTTER_SCREEN_HANDLER =
			ScreenHandlerType.register(MOD_ID, WoodcutterScreenHandler::new);
	public static RecipeType<WoodcuttingRecipe> WOODCUTTING;
	public static WoodcutterSerializer WOODCUTTING_RECIPE_RECIPE_SERIALIZER;

	@Override
	public void onInitialize() {
		log.info("Thank you for using Nemo's Woodcutter!");
		ModBlocks.registerBlocks();
		WOODCUTTING = RecipeType.register("woodcutting");
		WOODCUTTING_RECIPE_RECIPE_SERIALIZER = RecipeSerializer.register("woodcutting", new WoodcutterSerializer(WoodcuttingRecipe::new));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.addAfter(Blocks.STONECUTTER,
				ModBlocks.WOODCUTTER_BLOCK));
	}
}