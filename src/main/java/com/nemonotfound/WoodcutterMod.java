package com.nemonotfound;

import com.nemonotfound.block.ModBlocks;
import com.nemonotfound.entity.ChairEntity;
import com.nemonotfound.recipe.WoodcutterSerializer;
import com.nemonotfound.recipe.WoodcuttingRecipe;
import com.nemonotfound.screen.WoodcutterScreenHandler;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeSerializer;
import net.minecraft.recipe.RecipeType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WoodcutterMod implements ModInitializer {

	public static final String MOD_ID = "woodcutter";
    public static final Logger log = LoggerFactory.getLogger(MOD_ID);
	public static final ScreenHandlerType<WoodcutterScreenHandler> WOODCUTTER_SCREEN_HANDLER =
			ScreenHandlerType.register(MOD_ID, WoodcutterScreenHandler::new);
	public static RecipeType<WoodcuttingRecipe> WOODCUTTING;
	public static WoodcutterSerializer WOODCUTTING_RECIPE_RECIPE_SERIALIZER;
	public static final EntityType<ChairEntity> CHAIR_ENTITY = Registry.register(Registries.ENTITY_TYPE,
			new Identifier(MOD_ID, "chair_entity"),
			FabricEntityTypeBuilder.create(SpawnGroup.MISC, ChairEntity::new)
					.dimensions(new EntityDimensions(0, 0, true))
					.fireImmune()
					.disableSummon()
					.build());

	@Override
	public void onInitialize() {
		log.info("Thank you for using Nemo's Woodcutter!");
		registerBlocks();
		registerItems();
		addItemsToItemGroup();
		addItemsToCustomItemGroup();
		WOODCUTTING = RecipeType.register("woodcutting");
		WOODCUTTING_RECIPE_RECIPE_SERIALIZER = RecipeSerializer.register("woodcutting", new WoodcutterSerializer(WoodcuttingRecipe::new));
	}

	private void registerBlocks() {
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "woodcutter"), ModBlocks.WOODCUTTER_BLOCK);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "dark_oak_ladder"), ModBlocks.DARK_OAK_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "acacia_ladder"), ModBlocks.ACACIA_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "birch_ladder"), ModBlocks.BIRCH_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "spruce_ladder"), ModBlocks.SPRUCE_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "warped_ladder"), ModBlocks.WARPED_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "bamboo_ladder"), ModBlocks.BAMBOO_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "crimson_ladder"), ModBlocks.CRIMSON_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "mangrove_ladder"), ModBlocks.MANGROVE_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "jungle_ladder"), ModBlocks.JUNGLE_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "bound_bamboo_ladder"), ModBlocks.BOUND_BAMBOO_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cherry_ladder"), ModBlocks.CHERRY_LADDER);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "oak_table_the_classic"), ModBlocks.OAK_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cherry_table_the_classic"), ModBlocks.CHERRY_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "dark_oak_table_the_classic"), ModBlocks.DARK_OAK_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "bamboo_table_the_classic"), ModBlocks.BAMBOO_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "warped_table_the_classic"), ModBlocks.WARPED_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "crimson_table_the_classic"), ModBlocks.CRIMSON_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "mangrove_table_the_classic"), ModBlocks.MANGROVE_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "spruce_table_the_classic"), ModBlocks.SPRUCE_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "birch_table_the_classic"), ModBlocks.BIRCH_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "acacia_table_the_classic"), ModBlocks.ACACIA_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "jungle_table_the_classic"), ModBlocks.JUNGLE_TABLE_THE_CLASSIC);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "oak_chair"), ModBlocks.OAK_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "cherry_chair"), ModBlocks.CHERRY_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "dark_oak_chair"), ModBlocks.DARK_OAK_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "bamboo_chair"), ModBlocks.BAMBOO_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "warped_chair"), ModBlocks.WARPED_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "crimson_chair"), ModBlocks.CRIMSON_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "mangrove_chair"), ModBlocks.MANGROVE_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "spruce_chair"), ModBlocks.SPRUCE_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "birch_chair"), ModBlocks.BIRCH_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "acacia_chair"), ModBlocks.ACACIA_CHAIR);
		Registry.register(Registries.BLOCK, new Identifier(MOD_ID, "jungle_chair"), ModBlocks.JUNGLE_CHAIR);
	}

	private void registerItems() {
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "woodcutter"), new BlockItem(ModBlocks.WOODCUTTER_BLOCK, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dark_oak_ladder"), new BlockItem(ModBlocks.DARK_OAK_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "acacia_ladder"), new BlockItem(ModBlocks.ACACIA_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "birch_ladder"), new BlockItem(ModBlocks.BIRCH_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spruce_ladder"), new BlockItem(ModBlocks.SPRUCE_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "warped_ladder"), new BlockItem(ModBlocks.WARPED_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bamboo_ladder"), new BlockItem(ModBlocks.BAMBOO_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "crimson_ladder"), new BlockItem(ModBlocks.CRIMSON_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "mangrove_ladder"), new BlockItem(ModBlocks.MANGROVE_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "jungle_ladder"), new BlockItem(ModBlocks.JUNGLE_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bound_bamboo_ladder"), new BlockItem(ModBlocks.BOUND_BAMBOO_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cherry_ladder"), new BlockItem(ModBlocks.CHERRY_LADDER, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "oak_table_the_classic"), new BlockItem(ModBlocks.OAK_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cherry_table_the_classic"), new BlockItem(ModBlocks.CHERRY_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dark_oak_table_the_classic"), new BlockItem(ModBlocks.DARK_OAK_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bamboo_table_the_classic"), new BlockItem(ModBlocks.BAMBOO_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "warped_table_the_classic"), new BlockItem(ModBlocks.WARPED_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "crimson_table_the_classic"), new BlockItem(ModBlocks.CRIMSON_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "mangrove_table_the_classic"), new BlockItem(ModBlocks.MANGROVE_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spruce_table_the_classic"), new BlockItem(ModBlocks.SPRUCE_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "birch_table_the_classic"), new BlockItem(ModBlocks.BIRCH_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "acacia_table_the_classic"), new BlockItem(ModBlocks.ACACIA_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "jungle_table_the_classic"), new BlockItem(ModBlocks.JUNGLE_TABLE_THE_CLASSIC, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "oak_chair"), new BlockItem(ModBlocks.OAK_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "cherry_chair"), new BlockItem(ModBlocks.CHERRY_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "dark_oak_chair"), new BlockItem(ModBlocks.DARK_OAK_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "bamboo_chair"), new BlockItem(ModBlocks.BAMBOO_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "warped_chair"), new BlockItem(ModBlocks.WARPED_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "crimson_chair"), new BlockItem(ModBlocks.CRIMSON_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "mangrove_chair"), new BlockItem(ModBlocks.MANGROVE_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "spruce_chair"), new BlockItem(ModBlocks.SPRUCE_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "birch_chair"), new BlockItem(ModBlocks.BIRCH_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "acacia_chair"), new BlockItem(ModBlocks.ACACIA_CHAIR, new FabricItemSettings()));
		Registry.register(Registries.ITEM, new Identifier(MOD_ID, "jungle_chair"), new BlockItem(ModBlocks.JUNGLE_CHAIR, new FabricItemSettings()));
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
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.CHERRY_LADDER));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.OAK_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.CHERRY_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.DARK_OAK_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.BAMBOO_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.WARPED_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.CRIMSON_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.MANGROVE_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.SPRUCE_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.BIRCH_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.ACACIA_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.JUNGLE_TABLE_THE_CLASSIC));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.OAK_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.CHERRY_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.DARK_OAK_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.BAMBOO_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.WARPED_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.CRIMSON_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.MANGROVE_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.SPRUCE_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.BIRCH_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.ACACIA_CHAIR));
		ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(content -> content.add(ModBlocks.JUNGLE_CHAIR));
	}

	private void addItemsToCustomItemGroup() {
		ItemGroup ITEM_GROUP = FabricItemGroup.builder()
				.icon(() -> new ItemStack(ModBlocks.WOODCUTTER_BLOCK))
				.displayName(Text.translatable("Nemo's Woodcutter"))
				.entries((context, entries) -> {
					entries.add(ModBlocks.WOODCUTTER_BLOCK);
					entries.add(ModBlocks.DARK_OAK_LADDER);
					entries.add(ModBlocks.ACACIA_LADDER);
					entries.add(ModBlocks.BIRCH_LADDER);
					entries.add(ModBlocks.SPRUCE_LADDER);
					entries.add(ModBlocks.WARPED_LADDER);
					entries.add(ModBlocks.BAMBOO_LADDER);
					entries.add(ModBlocks.CRIMSON_LADDER);
					entries.add(ModBlocks.MANGROVE_LADDER);
					entries.add(ModBlocks.JUNGLE_LADDER);
					entries.add(ModBlocks.BOUND_BAMBOO_LADDER);
					entries.add(ModBlocks.CHERRY_LADDER);
					entries.add(ModBlocks.OAK_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.CHERRY_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.DARK_OAK_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.BAMBOO_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.WARPED_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.CRIMSON_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.MANGROVE_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.SPRUCE_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.BIRCH_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.ACACIA_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.JUNGLE_TABLE_THE_CLASSIC);
					entries.add(ModBlocks.OAK_CHAIR);
					entries.add(ModBlocks.CHERRY_CHAIR);
					entries.add(ModBlocks.DARK_OAK_CHAIR);
					entries.add(ModBlocks.BAMBOO_CHAIR);
					entries.add(ModBlocks.WARPED_CHAIR);
					entries.add(ModBlocks.CRIMSON_CHAIR);
					entries.add(ModBlocks.MANGROVE_CHAIR);
					entries.add(ModBlocks.SPRUCE_CHAIR);
					entries.add(ModBlocks.BIRCH_CHAIR);
					entries.add(ModBlocks.ACACIA_CHAIR);
					entries.add(ModBlocks.JUNGLE_CHAIR);
				})
				.build();

		Registry.register(Registries.ITEM_GROUP, new Identifier(MOD_ID, "woodcutter_group"), ITEM_GROUP);
	}
}