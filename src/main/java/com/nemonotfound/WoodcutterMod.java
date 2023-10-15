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
		log.info("Thank you for using Nemo's Woodcutter!");
		registerBlocks();
		registerItems();
		addItemsToItemGroup();
		WOODCUTTING = RecipeType.register("woodcutting");
		WOODCUTTING_RECIPE_RECIPE_SERIALIZER = RecipeSerializer.register("woodcutting", new WoodcutterSerializer(WoodcuttingRecipe::new));
	}

	private void registerBlocks() {
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "woodcutter"), ModBlocks.WOODCUTTER_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "dark_oak_ladder"), ModBlocks.DARK_OAK_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "acacia_ladder"), ModBlocks.ACACIA_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "birch_ladder"), ModBlocks.BIRCH_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "spruce_ladder"), ModBlocks.SPRUCE_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "warped_ladder"), ModBlocks.WARPED_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "bamboo_ladder"), ModBlocks.BAMBOO_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "crimson_ladder"), ModBlocks.CRIMSON_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "mangrove_ladder"), ModBlocks.MANGROVE_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "jungle_ladder"), ModBlocks.JUNGLE_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(mod_id, "bound_bamboo_ladder"), ModBlocks.BOUND_BAMBOO_LADDER);
	}

	private void registerItems() {
		Registry.register(Registries.ITEM, new Identifier(mod_id, "woodcutter"), new BlockItem(ModBlocks.WOODCUTTER_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "dark_oak_ladder"), new BlockItem(ModBlocks.DARK_OAK_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "acacia_ladder"), new BlockItem(ModBlocks.ACACIA_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "birch_ladder"), new BlockItem(ModBlocks.BIRCH_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "spruce_ladder"), new BlockItem(ModBlocks.SPRUCE_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "warped_ladder"), new BlockItem(ModBlocks.WARPED_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "bamboo_ladder"), new BlockItem(ModBlocks.BAMBOO_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "crimson_ladder"), new BlockItem(ModBlocks.CRIMSON_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "mangrove_ladder"), new BlockItem(ModBlocks.MANGROVE_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "jungle_ladder"), new BlockItem(ModBlocks.JUNGLE_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(mod_id, "bound_bamboo_ladder"), new BlockItem(ModBlocks.BOUND_BAMBOO_LADDER, new FabricItemSettings()));
	}

	private void addItemsToItemGroup() {
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.WOODCUTTER_BLOCK));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.DARK_OAK_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.ACACIA_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.BIRCH_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.SPRUCE_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.WARPED_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.BAMBOO_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.CRIMSON_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.MANGROVE_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.JUNGLE_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.BOUND_BAMBOO_LADDER));
	}
}