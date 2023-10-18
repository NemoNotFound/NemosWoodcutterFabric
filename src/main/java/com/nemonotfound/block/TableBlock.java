package com.nemonotfound.block;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class TableBlock extends Block {
    public TableBlock(Settings settings) {
        super(settings);
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        VoxelShape tableLegShape = Block.createCuboidShape(6.0f, 0f, 6.0f, 10.0f, 14.0f, 10.0f);
        VoxelShape tablePlateShape = Block.createCuboidShape(0f, 14.0f, 0f, 16.0f, 16.0f, 16.0f);
        return VoxelShapes.union(tableLegShape, tablePlateShape);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }
}
