package com.nemonotfound.nemoswoodcutter.block;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;
import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModBlocks {

    public static final Block WOODCUTTER_BLOCK = registerBlock("woodcutter",
            new WoodcutterBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
                    .strength(2.0f)));

    public static void registerBlocks() {
        log.info("Register blocks");
    }

    private static Block registerBlock(String path, Block block) {
        Block registeredBlock = Registry.register(Registry.BLOCK, new Identifier(MOD_ID, path), block);
        Registry.register(Registry.ITEM, new Identifier(MOD_ID, path), new BlockItem(block, new FabricItemSettings()
                .group(ItemGroup.DECORATIONS)));

        return registeredBlock;
    }
}
