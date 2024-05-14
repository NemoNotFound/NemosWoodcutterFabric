package com.nemonotfound.nemoswoodcutter;

import com.nemonotfound.nemoswoodcutter.block.ModBlocks;
import com.nemonotfound.nemoswoodcutter.recipe.ModRecipeSerializer;
import com.nemonotfound.nemoswoodcutter.recipe.ModRecipeTypes;
import com.nemonotfound.nemoswoodcutter.screen.WoodcutterScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.minecraft.screen.ScreenHandlerType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NemosWoodcutter implements ModInitializer {

	public static final String MOD_ID = "nemos-woodcutter";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);
	public static final ScreenHandlerType<WoodcutterScreenHandler> WOODCUTTER_SCREEN_HANDLER =
			ScreenHandlerType.register(MOD_ID, WoodcutterScreenHandler::new);

	@Override
	public void onInitialize() {
		log.info("Thank you for using Nemo's Woodcutter!");

		ModBlocks.registerBlocks();
		ModRecipeTypes.registerRecipeTypes();
		ModRecipeSerializer.registerRecipeSerializer();
	}
}