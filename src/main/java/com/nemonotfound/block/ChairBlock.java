package com.nemonotfound.block;


import net.minecraft.block.*;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
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
import net.minecraft.world.WorldAccess;

public class ChairBlock extends SittableBlock implements Waterloggable {

    private static final DirectionProperty FACING = HorizontalFacingBlock.FACING;
    private static final VoxelShape SOUTH_SHAPE = VoxelShapes.union(Block.createCuboidShape(1, 6, 1, 15, 8, 15),
            Block.createCuboidShape(1, 8, 1, 15, 16, 3),
            Block.createCuboidShape(12, 0, 12, 14, 6, 14),
            Block.createCuboidShape(2, 0, 12, 4, 6, 14),
            Block.createCuboidShape(2, 0, 2, 4, 6, 4),
            Block.createCuboidShape(12, 0, 2, 14, 6, 4));
    private static final VoxelShape WEST_SHAPE = VoxelShapes.union(Block.createCuboidShape(1, 6, 1, 15, 8, 15),
            Block.createCuboidShape(13, 8, 1, 15, 16, 15),
            Block.createCuboidShape(2, 0, 12, 4, 6, 14),
            Block.createCuboidShape(2, 0, 2, 4, 6, 4),
            Block.createCuboidShape(12, 0, 2, 14, 6, 4),
            Block.createCuboidShape(12, 0, 12, 14, 6, 14));
    private static final VoxelShape NORTH_SHAPE = VoxelShapes.union(Block.createCuboidShape(1, 6, 1, 15, 8, 15),
            Block.createCuboidShape(1, 8, 13, 15, 16, 15),
            Block.createCuboidShape(2, 0, 2, 4, 6, 4),
            Block.createCuboidShape(12, 0, 2, 14, 6, 4),
            Block.createCuboidShape(12, 0, 12, 14, 6, 14),
            Block.createCuboidShape(2, 0, 12, 4, 6, 14));
    private static final VoxelShape EAST_SHAPE = VoxelShapes.union(Block.createCuboidShape(1, 6, 1, 15, 8, 15),
            Block.createCuboidShape(1, 8, 1, 3, 16, 15),
            Block.createCuboidShape(12, 0, 2, 14, 6, 4),
            Block.createCuboidShape(12, 0, 12, 14, 6, 14),
            Block.createCuboidShape(2, 0, 12, 4, 6, 14),
            Block.createCuboidShape(2, 0, 2, 4, 6, 4));

    protected ChairBlock(Settings settings) {
        super(settings);
        this.setDefaultState(this.stateManager.getDefaultState().with(FACING, Direction.NORTH).with(WATERLOGGED, false));
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
    public FluidState getFluidState(BlockState state) {
        if (state.get(WATERLOGGED).booleanValue()) {
            return Fluids.WATER.getStill(false);
        }
        return super.getFluidState(state);
    }

    @Override
    public BlockState getStateForNeighborUpdate(BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos) {
        if (state.get(WATERLOGGED).booleanValue()) {
            world.scheduleFluidTick(pos, Fluids.WATER, Fluids.WATER.getTickRate(world));
        }
        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public BlockRenderType getRenderType(BlockState state) {
        return BlockRenderType.MODEL;
    }

    @Override
    public BlockState getPlacementState(ItemPlacementContext ctx) {
        FluidState fluidState = ctx.getWorld().getFluidState(ctx.getBlockPos());
        return this.getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite()).with(WATERLOGGED, fluidState.getFluid() == Fluids.WATER);
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
        builder.add(FACING, WATERLOGGED);
    }
}
