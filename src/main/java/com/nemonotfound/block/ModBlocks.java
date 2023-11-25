package com.nemonotfound.block;

import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.Material;

public class ModBlocks {

    public static final Block WOODCUTTER_BLOCK = new WoodcutterBlock(FabricBlockSettings.of(Material.WOOD, MapColor.OAK_TAN)
            .strength(2.0f));
}
