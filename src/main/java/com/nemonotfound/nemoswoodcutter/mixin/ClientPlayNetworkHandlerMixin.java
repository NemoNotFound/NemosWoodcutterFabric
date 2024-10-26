package com.nemonotfound.nemoswoodcutter.mixin;

import com.nemonotfound.nemoswoodcutter.client.recipebook.ClientModRecipeManager;
import com.nemonotfound.nemoswoodcutter.interfaces.ModRecipeManagerGetter;
import com.nemonotfound.nemoswoodcutter.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import com.nemonotfound.nemoswoodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.network.ClientCommonNetworkHandler;
import net.minecraft.client.network.ClientConnectionState;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.network.ClientConnection;
import net.minecraft.network.NetworkThreadUtils;
import net.minecraft.network.listener.ClientPlayPacketListener;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;

@Mixin(ClientPlayNetworkHandler.class)
public abstract class ClientPlayNetworkHandlerMixin extends ClientCommonNetworkHandler implements ClientPlayPacketListener, ModRecipeManagerGetter {

    @Unique
    private ClientModRecipeManager modRecipeManager = new ClientModRecipeManager(WoodcuttingRecipeDisplay.Grouping.empty());

    protected ClientPlayNetworkHandlerMixin(MinecraftClient client, ClientConnection connection, ClientConnectionState connectionState) {
        super(client, connection, connectionState);
    }

    @Override
    public ClientModRecipeManager nemo_sWoodcutter$getModRecipeManager() {
        return this.modRecipeManager;
    }

    @Override
    public void nemo_sWoodcutter$onSynchronizeModRecipes(SynchronizeModRecipesS2CPacket packet) {
        MinecraftClient client = this.nemo_sWoodcutter$getMinecraftClient();
        NetworkThreadUtils.forceMainThread(packet, this, client);
        this.modRecipeManager = new ClientModRecipeManager(packet.woodcuttingRecipes());
    }
}
