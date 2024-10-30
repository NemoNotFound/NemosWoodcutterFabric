package com.nemonotfound.nemoswoodcutter.network.packet.s2c.play;

import com.nemonotfound.nemoswoodcutter.network.packet.ModPlayPackets;
import com.nemonotfound.nemoswoodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.network.RegistryByteBuf;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.listener.ClientPlayPacketListener;
import net.minecraft.network.packet.Packet;
import net.minecraft.network.packet.PacketType;

public record SynchronizeModRecipesS2CPacket(WoodcuttingRecipeDisplay.Grouping woodcuttingRecipes) implements Packet<ClientPlayPacketListener> {

    public static final PacketCodec<RegistryByteBuf, SynchronizeModRecipesS2CPacket> CODEC = PacketCodec.tuple(
            WoodcuttingRecipeDisplay.Grouping.codec(),
            SynchronizeModRecipesS2CPacket::woodcuttingRecipes,
            SynchronizeModRecipesS2CPacket::new
    );

//    @Override
//    public PacketType<? extends Packet<ClientPlayPacketListener>> getPacketId() {
//        return ModPlayPackets.UPDATE_RECIPES;
//    }
//
//    @Override
//    public void apply(ClientPlayPacketListener clientPlayPacketListener) {
//        clientPlayPacketListener.nemo_sWoodcutter$onSynchronizeModRecipes(this);
//    }

    @Override
    public PacketType<? extends Packet<ClientPlayPacketListener>> method_65080() {
        return ModPlayPackets.UPDATE_RECIPES;
    }

    @Override
    public void method_65081(ClientPlayPacketListener clientPlayPacketListener) {
        clientPlayPacketListener.nemo_sWoodcutter$onSynchronizeModRecipes(this);
    }
}
