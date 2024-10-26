package com.nemonotfound.nemoswoodcutter.network.listener;

import com.nemonotfound.nemoswoodcutter.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import net.minecraft.network.listener.ClientPingResultPacketListener;

public interface ModClientPlayPacketListener extends ClientPingResultPacketListener {

    void nemo_sWoodcutter$onSynchronizeModRecipes(SynchronizeModRecipesS2CPacket packet);
}
