package com.nemonotfound.nemoswoodcutter.interfaces;

import net.minecraft.client.MinecraftClient;

public interface MinecraftClientGetter {

    default MinecraftClient nemo_sWoodcutter$getMinecraftClient() {
        return null;
    }
}
