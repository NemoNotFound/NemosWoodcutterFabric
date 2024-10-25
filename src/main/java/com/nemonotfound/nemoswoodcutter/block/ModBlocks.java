package com.nemonotfound.nemoswoodcutter.block;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;
import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModBlocks {

    public static final Block WOODCUTTER = register("woodcutter", WoodcutterBlock::new,
            AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.OAK_TAN)
                    .instrument(NoteBlockInstrument.BASS)
                    .strength(2.0f));

    public static void registerBlocks() {
        log.info("Register blocks");
    }

    private static Block register(String path, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(keyOf(path), factory, settings);
    }

    private static RegistryKey<Block> keyOf(String path) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MOD_ID, path));
    }

    public static Block register(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings.registryKey(key));

        return Registry.register(Registries.BLOCK, key, block);
    }
}
