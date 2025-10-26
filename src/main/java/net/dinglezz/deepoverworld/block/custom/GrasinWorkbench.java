package net.dinglezz.deepoverworld.block.custom;

import com.mojang.serialization.MapCodec;
import net.dinglezz.deepoverworld.block.entity.ModBlockEntities;
import net.dinglezz.deepoverworld.block.entity.custom.GrasinWorkbenchBlockEntity;
import net.minecraft.block.BlockEntityProvider;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.BlockWithEntity;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityTicker;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class GrasinWorkbench extends BlockWithEntity implements BlockEntityProvider {
	public static final MapCodec<GrasinWorkbench> CODEC = GrasinWorkbench.createCodec(GrasinWorkbench::new);
	
	public GrasinWorkbench(Settings settings) {
		super(settings);
	}
	
	@Override
	protected MapCodec<? extends BlockWithEntity> getCodec() {
		return CODEC;
	}
	
	@Override
	public @Nullable BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
		return new GrasinWorkbenchBlockEntity(pos, state);
	}
	
	@Override
	protected BlockRenderType getRenderType(BlockState state) {
		return BlockRenderType.MODEL;
	}
	
	@Override
	protected void onStateReplaced(BlockState state, ServerWorld world, BlockPos pos, boolean moved) {
		super.onStateReplaced(state, world, pos, moved);
	}
	
	@Override
	protected ActionResult onUse(BlockState state, World world, BlockPos pos, PlayerEntity player, BlockHitResult hit) {
		if (!world.isClient()) {
			NamedScreenHandlerFactory screenHandlerFactory = ((GrasinWorkbenchBlockEntity) world.getBlockEntity(pos));
			if (screenHandlerFactory != null) {
				player.openHandledScreen(screenHandlerFactory);
			}
		}
		return ActionResult.SUCCESS;
	}
	
	@Nullable
	@Override
	public <T extends BlockEntity> BlockEntityTicker<T> getTicker(World world, BlockState state, BlockEntityType<T> type) {
		if(world.isClient()) {
			return null;
		}
		
		return validateTicker(type, ModBlockEntities.GRASIN_WORKBENCH_BE,
				(world1, pos, state1, blockEntity) -> blockEntity.tick(world1, pos, state1));
	}
}
