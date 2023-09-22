package com.nemonotfound;

import com.nemonotfound.block.ModBlocks;
import com.nemonotfound.recipe.WoodcutterSerializer;
import com.nemonotfound.recipe.WoodcuttingRecipe;
import com.nemonotfound.screen.WoodcutterScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroups;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WoodcutterMod implements ModInitializer {

	public static final String mod_id = "woodcutter";
    public static final Logger log = LoggerFactory.getLogger(mod_id);
	public static final ScreenHandlerType<WoodcutterScreenHandler> WOODCUTTER_SCREEN_HANDLER =
			ScreenHandlerType.register(mod_id, WoodcutterScreenHandler::new);
	public static RecipeType<WoodcuttingRecipe> WOODCUTTING;
	public static WoodcutterSerializer WOODCUTTING_RECIPE_RECIPE_SERIALIZER;

	@Override
	public void onInitialize() {
		log.info("Thank you for using Woodcutter!");
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "woodcutter"), ModBlocks.WOODCUTTER_BLOCK);
		Registry.register(Registries.ITEM, new Identifier(mod_id, "woodcutter"), new BlockItem(ModBlocks.WOODCUTTER_BLOCK, new FabricItemSettings()));
		WOODCUTTING = RecipeType.register("woodcutting");
		WOODCUTTING_RECIPE_RECIPE_SERIALIZER = RecipeSerializer.register("woodcutting", new WoodcutterSerializer(WoodcuttingRecipe::new));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.WOODCUTTER_BLOCK));
	}
}