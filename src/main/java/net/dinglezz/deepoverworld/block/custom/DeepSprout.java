package net.dinglezz.deepoverworld.block.custom;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.minecraft.block.BlockState;
import net.minecraft.block.SaplingBlock;
import net.minecraft.block.SaplingGenerator;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.BlockView;

public class DeepSprout extends SaplingBlock {
    public DeepSprout(SaplingGenerator generator, Settings settings) {
        super(generator, settings);
    }

    @Override
    protected boolean canPlantOnTop(BlockState floor, BlockView world, BlockPos pos) {
        return floor.isOf(ModBlocks.DEEPSLATE_GRASS);
    }
}
