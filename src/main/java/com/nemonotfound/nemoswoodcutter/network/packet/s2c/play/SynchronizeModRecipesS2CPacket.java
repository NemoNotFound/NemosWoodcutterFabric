package com.nemonotfound.nemoswoodcutter.network.packet.s2c.play;

import com.nemonotfound.nemoswoodcutter.network.listener.ModClientPlayPacketListener;
import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipe;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.PacketType;
import net.minecraft.recipe.display.CuttingRecipeDisplay;

public record SynchronizeModRecipesS2CPacket(CuttingRecipeDisplay.Grouping<WoodcuttingRecipe> woodcuttingRecipes) implements Packet<ModClientPlayPacketListener> {

    public static final PacketCodec<RegistryByteBuf, SynchronizeModRecipesS2CPacket> CODEC = PacketCodec.tuple(
            CuttingRecipeDisplay.Grouping.codec(),
            SynchronizeModRecipesS2CPacket::woodcuttingRecipes,
            SynchronizeModRecipesS2CPacket::new
    );

    @Override
    public PacketType<? extends Packet<ModClientPlayPacketListener>> getPacketId() {
        return null;
    }

    @Override
    public void apply(ModClientPlayPacketListener clientPlayPacketListener) {
        clientPlayPacketListener.onSynchronizeModRecipes(this);
    }
}
