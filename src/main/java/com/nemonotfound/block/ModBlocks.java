package com.nemonotfound.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.LadderBlock;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.sound.BlockSoundGroup;

import static net.minecraft.block.Blocks.*;

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
    public static final Block OAK_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(OAK_PLANKS).nonOpaque());
    public static final Block CHERRY_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(CHERRY_PLANKS).nonOpaque());
    public static final Block DARK_OAK_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(DARK_OAK_PLANKS).nonOpaque());
    public static final Block BAMBOO_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(BAMBOO_PLANKS).nonOpaque());
    public static final Block WARPED_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(WARPED_PLANKS).nonOpaque());
    public static final Block CRIMSON_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(CRIMSON_PLANKS).nonOpaque());
    public static final Block MANGROVE_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(MANGROVE_PLANKS).nonOpaque());
    public static final Block SPRUCE_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(SPRUCE_PLANKS).nonOpaque());
    public static final Block BIRCH_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(BIRCH_PLANKS).nonOpaque());
    public static final Block ACACIA_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(ACACIA_PLANKS).nonOpaque());
    public static final Block JUNGLE_TABLE_THE_CLASSIC = new TableBlock(AbstractBlock.Settings.copy(JUNGLE_PLANKS).nonOpaque());
    public static final Block OAK_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(OAK_PLANKS).nonOpaque());
    public static final Block CHERRY_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(CHERRY_PLANKS).nonOpaque());
    public static final Block DARK_OAK_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(DARK_OAK_PLANKS).nonOpaque());
    public static final Block BAMBOO_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(BAMBOO_PLANKS).nonOpaque());
    public static final Block WARPED_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(WARPED_PLANKS).nonOpaque());
    public static final Block CRIMSON_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(CRIMSON_PLANKS).nonOpaque());
    public static final Block MANGROVE_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(MANGROVE_PLANKS).nonOpaque());
    public static final Block SPRUCE_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(SPRUCE_PLANKS).nonOpaque());
    public static final Block BIRCH_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(BIRCH_PLANKS).nonOpaque());
    public static final Block ACACIA_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(ACACIA_PLANKS).nonOpaque());
    public static final Block JUNGLE_CHAIR = new ChairBlock(AbstractBlock.Settings.copy(JUNGLE_PLANKS).nonOpaque());

}
