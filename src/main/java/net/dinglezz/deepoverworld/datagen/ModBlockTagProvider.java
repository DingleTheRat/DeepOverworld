package net.dinglezz.deepoverworld.datagen;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.util.ModTags;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends FabricTagProvider.BlockTagProvider {
    public ModBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        // Tools
        valueLookupBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_GRASS);

        valueLookupBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.DEEP_LOG)
                .add(ModBlocks.DEEP_WOOD)
                .add(ModBlocks.GRASIN_WORKBENCH)
                .add(ModBlocks.DEEP_WOOD);

        valueLookupBuilder(BlockTags.SHOVEL_MINEABLE)
                .add(ModBlocks.GRASIN_BOCK_A)
                .add(ModBlocks.GRASIN_BOCK_B)
                .add(ModBlocks.GRASIN_BOCK_C);

        valueLookupBuilder(BlockTags.HOE_MINEABLE)
                .add(ModBlocks.DECAYED_GRASIN);

        // Needs?
        valueLookupBuilder(BlockTags.NEEDS_STONE_TOOL)
                .add(ModBlocks.GRASIN_BOCK_A)
                .add(ModBlocks.GRASIN_BOCK_B)
                .add(ModBlocks.GRASIN_BOCK_C);
        
        valueLookupBuilder(BlockTags.NEEDS_IRON_TOOL)
                .add(ModBlocks.DEEPSLATE_GRASS)
                .add(ModBlocks.DEEP_LOG)
                .add(ModBlocks.DEEP_WOOD);

        // Custom
        valueLookupBuilder(ModTags.Blocks.DEEP_VEGETATION)
                .add(ModBlocks.DEEPSLATE_GRASS)
                .add(ModBlocks.GRASIN_BOCK_A)
                .add(ModBlocks.GRASIN_BOCK_C)
                .add(ModBlocks.GRASIN_BOCK_B);
    }
}
