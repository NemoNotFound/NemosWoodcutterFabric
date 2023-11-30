package com.nemonotfound;

import com.nemonotfound.block.ModBlocks;
import com.nemonotfound.recipe.WoodcutterSerializer;
import com.nemonotfound.recipe.WoodcuttingRecipe;
import com.nemonotfound.screen.WoodcutterScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
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
		registerBlocks();
		registerItems();
		WOODCUTTING = RecipeType.register("woodcutting");
		WOODCUTTING_RECIPE_RECIPE_SERIALIZER = RecipeSerializer.register("woodcutting", new WoodcutterSerializer(WoodcuttingRecipe::new));
	}

	private void registerBlocks() {
		Registry.register(Registry.BLOCK, new Identifier(MOD_ID, "woodcutter"), ModBlocks.WOODCUTTER_BLOCK);
	}

	private void registerItems() {
		Registry.register(Registry.ITEM, new Identifier(MOD_ID, "woodcutter"), new BlockItem(ModBlocks.WOODCUTTER_BLOCK,
				new FabricItemSettings().group(ItemGroup.DECORATIONS)));
	}
}