package com.nemonotfound.nemoswoodcutter.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

public class ModBlocks {

    public static final Block WOODCUTTER_BLOCK = new WoodcutterBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.OAK_TAN)
                    .instrument(Instrument.BASS)
                    .strength(2.0f));
}
