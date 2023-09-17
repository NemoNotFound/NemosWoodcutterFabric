package com.nemonotfound.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;

public class ModBlocks {

    public static final Block WOODCUTTER_BLOCK = new WoodcutterBlock(AbstractBlock.Settings.create().mapColor(MapColor.OAK_TAN).instrument(Instrument.BASEDRUM).strength(2.0f));
}
