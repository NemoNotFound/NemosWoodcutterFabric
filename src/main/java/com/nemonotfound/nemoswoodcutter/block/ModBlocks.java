package com.nemonotfound.nemoswoodcutter.block;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.MapColor;
import net.minecraft.block.enums.Instrument;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.Arrays;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;

public class ModBlocks {

    public static final Block WOODCUTTER_BLOCK = registerBlock("woodcutter", new WoodcutterBlock(AbstractBlock.Settings.create()
                    .sounds(BlockSoundGroup.WOOD)
                    .mapColor(MapColor.OAK_TAN)
                    .instrument(Instrument.BASS)
                    .strength(2.0f)));

    @SafeVarargs
    private static Block registerBlock(String path, Block block, RegistryKey<ItemGroup>... itemGroups) {
        Block registeredBlock = Registry.register(Registries.BLOCK, new Identifier(MOD_ID, path), block);
        Registry.register(Registries.ITEM, new Identifier(MOD_ID, path), new BlockItem(block, new Item.Settings()));

        Arrays.stream(itemGroups).forEach(itemGroup -> ItemGroupEvents.modifyEntriesEvent(itemGroup)
                .register(content -> content.add(block)));

        return registeredBlock;
    }
}
