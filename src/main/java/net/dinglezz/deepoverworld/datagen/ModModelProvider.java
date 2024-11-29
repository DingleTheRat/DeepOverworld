package net.dinglezz.deepoverworld.datagen;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.ItemModelGenerator;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
    blockStateModelGenerator.registerLog(ModBlocks.DEEP_LOG).log(ModBlocks.DEEP_LOG).wood(ModBlocks.DEEP_WOOD);
    blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DECAYED_GRASIN);
    blockStateModelGenerator.registerTintableCross(ModBlocks.DEEP_SPROUT, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
