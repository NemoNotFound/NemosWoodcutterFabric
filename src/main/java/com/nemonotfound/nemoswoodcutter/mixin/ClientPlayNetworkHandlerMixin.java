package com.nemonotfound.nemoswoodcutter.mixin;

import com.nemonotfound.nemoswoodcutter.client.recipebook.ClientModRecipeManager;
import com.nemonotfound.nemoswoodcutter.network.listener.ModClientPlayPacketListener;
import com.nemonotfound.nemoswoodcutter.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.DisconnectionInfo;
import net.minecraft.network.NetworkSide;
import net.minecraft.network.packet.s2c.query.PingResultS2CPacket;
import net.minecraft.recipe.display.CuttingRecipeDisplay;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ClientPlayNetworkHandler.class)
public class ClientPlayNetworkHandlerMixin implements ModClientPlayPacketListener {

    //TODO: need to set the recipes in the ServerRecipeManager
    //TODO: need to send the packet trough PlayerManager

    @Unique
    private ClientModRecipeManager modRecipeManager = new ClientModRecipeManager(CuttingRecipeDisplay.Grouping.empty());

    //TODO: need to add this method to the ClientPlayNetworkHandler
    @Unique
    public ClientModRecipeManager getModRecipeManager() {
        return this.modRecipeManager;
    }

    @Override
    public void onSynchronizeModRecipes(SynchronizeModRecipesS2CPacket packet) {
        //TODO: need to retrieve client
        //NetworkThreadUtils.forceMainThread(packet, this, this.client);
        this.modRecipeManager = new ClientModRecipeManager(packet.woodcuttingRecipes());
    }

    @Override
    public void onPingResult(PingResultS2CPacket packet) {

    }

    @Override
    public NetworkSide getSide() {
        return null;
    }

    @Override
    public void onDisconnected(DisconnectionInfo info) {

    }

    @Override
    public boolean isConnectionOpen() {
        return false;
    }
}
