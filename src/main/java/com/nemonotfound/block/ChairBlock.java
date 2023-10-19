package com.nemonotfound.block;


import net.minecraft.block.*;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.DirectionProperty;
import net.minecraft.util.BlockMirror;
import net.minecraft.util.BlockRotation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.util.shape.VoxelShapes;
import net.minecraft.world.BlockView;

public class ChairBlock extends Block {

    private static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.union(Block.createCuboidShape(1, 6, 1, 15, 8, 15),
            Block.createCuboidShape(1, 8, 1, 15, 16, 3),
            Block.createCuboidShape(12, 0, 12, 14, 6, 14),
            Block.createCuboidShape(2, 0, 12, 4, 6, 14),
            Block.createCuboidShape(2, 0, 2, 4, 6, 4),
            Block.createCuboidShape(12, 0, 2, 14, 6, 4));
    private static final VoxelShape EAST_SHAPE = VoxelShapes.union(Block.createCuboidShape(1, 6, 1, 15, 8, 15),
            Block.createCuboidShape(13, 8, 1, 15, 16, 15),
            Block.createCuboidShape(2, 0, 12, 4, 6, 14),
            Block.createCuboidShape(2, 0, 2, 4, 6, 4),
            Block.createCuboidShape(12, 0, 2, 14, 6, 4),
            Block.createCuboidShape(12, 0, 12, 14, 6, 14));
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(Block.createCuboidShape(1, 6, 1, 15, 8, 15),
            Block.createCuboidShape(1, 8, 13, 15, 16, 15),
            Block.createCuboidShape(2, 0, 2, 4, 6, 4),
            Block.createCuboidShape(12, 0, 2, 14, 6, 4),
            Block.createCuboidShape(12, 0, 12, 14, 6, 14),
            Block.createCuboidShape(2, 0, 12, 4, 6, 14));
    private static final VoxelShape WEST_SHAPE = VoxelShapes.union(Block.createCuboidShape(1, 6, 1, 15, 8, 15),
            Block.createCuboidShape(1, 8, 1, 3, 16, 15),
            Block.createCuboidShape(12, 0, 2, 14, 6, 4),
            Block.createCuboidShape(12, 0, 12, 14, 6, 14),
            Block.createCuboidShape(2, 0, 12, 4, 6, 14),
            Block.createCuboidShape(2, 0, 2, 4, 6, 4));

    protected ChairBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH));
    }

    @Override
    public VoxelShape getOutlineShape(BlockState state, BlockView view, BlockPos pos, ShapeContext context) {
        switch (state.get(FACING)) {
            case NORTH -> {
                return NORTH_SHAPE;
            }
            case SOUTH -> {
                return SOUTH_SHAPE;
            }
            case EAST -> {
                return EAST_SHAPE;
            }
            case WEST -> {
                return WEST_SHAPE;
            }
        }
        return NORTH_SHAPE;
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing());
    }

    @Override
    public BlockState rotate(BlockState state, BlockRotation rotation) {
        return state.with(FACING, rotation.rotate(state.get(FACING)));
    }

    @Override
    public BlockState mirror(BlockState state, BlockMirror mirror) {
        return state.rotate(mirror.getRotation(state.get(FACING)));
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        builder.add(FACING);
    }
}
