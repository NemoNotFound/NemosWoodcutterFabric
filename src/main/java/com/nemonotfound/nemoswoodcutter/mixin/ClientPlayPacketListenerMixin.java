package com.nemonotfound.nemoswoodcutter.mixin;

import com.nemonotfound.nemoswoodcutter.network.listener.ModClientPlayPacketListener;
import net.minecraft.network.listener.ClientPlayPacketListener;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(ClientPlayPacketListener.class)
public interface ClientPlayPacketListenerMixin extends ModClientPlayPacketListener {
}
