package com.nemonotfound.nemoswoodcutter.mixin;

import com.nemonotfound.nemoswoodcutter.client.recipebook.ClientModRecipeManager;
import com.nemonotfound.nemoswoodcutter.interfaces.ModRecipeManagerGetter;
import net.minecraft.client.network.ClientPlayNetworkHandler;
import net.minecraft.client.world.ClientWorld;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(ClientWorld.class)
public class ClientWorldMixin implements ModRecipeManagerGetter {

    @Shadow @Final
    private ClientPlayNetworkHandler networkHandler;

    @Override
    public ClientModRecipeManager nemo_sWoodcutter$getModRecipeManager() {
        return ((ModRecipeManagerGetter)networkHandler).nemo_sWoodcutter$getModRecipeManager();
    }
}
