package com.nemonotfound.nemoswoodcutter.item;

import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.Items;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.log;

public class ModItemGroups {

    public static void registerItemGroups() {
        log.info("Registering item groups");

        modifyFunctionalItemGroup();
    }

    private static void modifyFunctionalItemGroup() {
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.FUNCTIONAL).register(entries -> entries.addAfter(Items.STONECUTTER, ModItems.WOODCUTTER));
    }
}
