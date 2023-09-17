package com.nemonotfound;

import com.nemonotfound.screen.WoodcutterScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.ingame.HandledScreens;

@Environment(EnvType.CLIENT)
public class WoodcutterClientMod implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        HandledScreens.register(WoodcutterMod.WOODCUTTER_SCREEN_HANDLER, WoodcutterScreen::new);
    }
}
