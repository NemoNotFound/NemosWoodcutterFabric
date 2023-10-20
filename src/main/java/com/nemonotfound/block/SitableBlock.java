package com.nemonotfound.block;

import com.nemonotfound.WoodcutterMod;
import com.nemonotfound.entity.ChairEntity;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.entity.Entity;
import net.minecraft.entity.ai.pathing.NavigationType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.property.BooleanProperty;
import net.minecraft.state.property.Properties;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Direction;
import net.minecraft.world.BlockView;
import net.minecraft.world.World;
import net.minecraft.world.WorldAccess;

import java.util.ArrayList;
import java.util.List;

public abstract class SitableBlock extends HorizontalFacingBlock {

    public static final BooleanProperty WATERLOGGED = Properties.WATERLOGGED;
    private ChairEntity chairEntity;

    public SitableBlock(Settings settings) {
        super(settings);
        setDefaultState(this.getStateManager().getDefaultState().with(Properties.HORIZONTAL_FACING, Direction.NORTH));

        this.height = 0.5f;
    }

    public float height;

    @Override
    public ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, Hand hand, BlockHitResult hit) {
        if (world.isClient) {
            return ActionResult.CONSUME;
        }

        if (player.isSpectator() || player.isSneaking()) {
            return ActionResult.FAIL;
        }

        List<ChairEntity> active = world.getEntitiesByClass(ChairEntity.class, new Box(pos), Entity::hasPassengers);
        List<Entity> hasPassenger = new ArrayList<>();
        active.forEach(chairEntity -> hasPassenger.add(chairEntity.getFirstPassenger()));
        if (!active.isEmpty() && hasPassenger.stream().anyMatch(Entity::isPlayer)) {
            return ActionResult.FAIL;
        } else if (!active.isEmpty()) {
            hasPassenger.forEach(Entity::stopRiding);
            return ActionResult.SUCCESS;
        } else if (sitEntity(world, pos, state, player) == ActionResult.SUCCESS) {
            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }


    public ActionResult sitEntity(World world, BlockPos pos, BlockState state, Entity entityToSit) {
        double posX;
        double posZ;
        if (state.getBlock() instanceof ChairBlock) {
            Direction direction = state.get(FACING);
            switch (direction) {
                case EAST -> {
                    posX = pos.getX() + 0.4;
                    posZ = pos.getZ() + 0.5;
                }
                case WEST -> {
                    posX = pos.getX() + 0.6;
                    posZ = pos.getZ() + 0.5;
                }
                case SOUTH -> {
                    posX = pos.getX() + 0.5;
                    posZ = pos.getZ() + 0.4;
                }
                default -> {
                    posX = pos.getX() + 0.5;
                    posZ = pos.getZ() + 0.6;
                }
            }

        } else {
            posX = pos.getX() + 0.5;
            posZ = pos.getZ() + 0.5;
        }
        double posY = pos.getY() + this.height;
        float yaw = state.get(FACING).asRotation();
        this.chairEntity = WoodcutterMod.CHAIR_ENTITY.create(world);
        chairEntity.refreshPositionAndAngles(posX, posY, posZ, yaw, 0);
        chairEntity.setNoGravity(true);
        chairEntity.setSilent(true);
        chairEntity.setInvisible(false);
        chairEntity.setInvulnerable(true);
        if (world.spawnEntity(chairEntity)) {
            entityToSit.setYaw(yaw);
            entityToSit.setBodyYaw(yaw);
            entityToSit.setHeadYaw(yaw);
            entityToSit.startRiding(chairEntity, true);

            return ActionResult.SUCCESS;
        }
        return ActionResult.CONSUME;
    }

    @Override
    public boolean canPathfindThrough(BlockState state, BlockView world, BlockPos pos, NavigationType type) {
        return false;
    }

    @Override
    public void onBroken(WorldAccess world, BlockPos pos, BlockState state) {
        if (chairEntity != null) {
            chairEntity.discard();
        }
    }
}

