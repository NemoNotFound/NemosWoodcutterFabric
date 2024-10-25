package com.nemonotfound.nemoswoodcutter.item;

import com.nemonotfound.nemoswoodcutter.block.ModBlocks;
import net.minecraft.item.Item;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;
import static net.minecraft.item.Items.register;

public class ModItems {

    public static final Item WOODCUTTER = register(ModBlocks.WOODCUTTER);

    public static void registerItems() {
        log.info("Registering items");
    }
}
