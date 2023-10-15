package com.nemonotfound.block;

import net.minecraft.block.*;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

import static net.minecraft.block.Blocks.LADDER;

public class ModBlocks {

    public static final Block WOODCUTTER_BLOCK = new WoodcutterBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.OAK_TAN)
                    .instrument(Instrument.BASS)
                    .strength(2.0f));
    public static final Block DARK_OAK_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block ACACIA_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block BIRCH_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block SPRUCE_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block WARPED_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block BAMBOO_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block CRIMSON_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block MANGROVE_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block JUNGLE_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block BOUND_BAMBOO_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));
    public static final Block CHERRY_LADDER = new LadderBlock(AbstractBlock.Settings.copy(LADDER));

}
