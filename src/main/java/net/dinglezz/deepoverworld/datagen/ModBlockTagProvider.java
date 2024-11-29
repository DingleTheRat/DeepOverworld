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
        getOrCreateTagBuilder(BlockTags.PICKAXE_MINEABLE)
                .add(ModBlocks.DEEPSLATE_GRASS);

        getOrCreateTagBuilder(BlockTags.AXE_MINEABLE)
                .add(ModBlocks.DEEP_LOG)
                .add(ModBlocks.DEEP_WOOD);

        getOrCreateTagBuilder(ModTags.Blocks.DEEP_VEGETATION)
                .add(ModBlocks.DEEPSLATE_GRASS);
    }
}
