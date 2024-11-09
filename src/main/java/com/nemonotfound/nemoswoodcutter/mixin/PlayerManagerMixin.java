package com.nemonotfound.nemoswoodcutter.mixin;

import com.llamalad7.mixinextras.sugar.Local;
import com.nemonotfound.nemoswoodcutter.interfaces.WoodcutterRecipeGetter;
import com.nemonotfound.nemoswoodcutter.network.packet.s2c.play.SynchronizeModRecipesS2CPacket;
import net.minecraft.network.ClientConnection;
import net.minecraft.recipe.ServerRecipeManager;
import net.minecraft.server.PlayerManager;
import net.minecraft.server.network.ConnectedClientData;
import net.minecraft.server.network.ServerPlayNetworkHandler;
import net.minecraft.server.network.ServerPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(PlayerManager.class)
public class PlayerManagerMixin {

    @Inject(method = "onPlayerConnect", at = @At(value = "INVOKE", target = "Lnet/minecraft/server/PlayerManager;sendCommandTree(Lnet/minecraft/server/network/ServerPlayerEntity;)V"))
    private void onPlayerConnect(ClientConnection connection, ServerPlayerEntity player, ConnectedClientData clientData, CallbackInfo ci, @Local ServerPlayNetworkHandler serverPlayNetworkHandler, @Local ServerRecipeManager serverRecipeManager) {
        serverPlayNetworkHandler.sendPacket(new SynchronizeModRecipesS2CPacket(((WoodcutterRecipeGetter)serverRecipeManager).nemo_sWoodcutter$getWoodcutterRecipeForSync()));
    }
}
