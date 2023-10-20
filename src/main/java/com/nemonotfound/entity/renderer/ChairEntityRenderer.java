package com.nemonotfound.entity.renderer;


import com.nemonotfound.entity.ChairEntity;
import net.minecraft.client.render.entity.EntityRenderer;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.util.Identifier;

public class ChairEntityRenderer extends EntityRenderer<ChairEntity> {
    private static final Identifier EMPTY_TEXTURE = new Identifier("minecraft:textures/block/stone.png");
    public ChairEntityRenderer(EntityRendererFactory.Context context) {
        super(context);
    }

    public Identifier getTexture(ChairEntity entity) {
        return EMPTY_TEXTURE;
    }


}
