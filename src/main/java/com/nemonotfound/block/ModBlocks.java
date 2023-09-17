package com.nemonotfound.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final Block WOODCUTTER_BLOCK = new WoodcutterBlock(
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.OAK_TAN)
                    .instrument(Instrument.BASEDRUM)
                    .strength(2.0f));
}
