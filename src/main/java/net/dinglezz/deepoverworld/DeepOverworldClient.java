package net.dinglezz.deepoverworld;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.entity.ModEntities;
import net.dinglezz.deepoverworld.entity.client.*;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.entity.EntityType;

public class DeepOverworldClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DECAYED_GRASIN, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.DEEP_SPROUT, RenderLayer.getCutout());
        
        EntityModelLayerRegistry.registerModelLayer(GrasinBugModel.GRASIN_BUG, GrasinBugModel::getTexturedModelData);
        EntityRendererRegistry.register((EntityType) ModEntities.GRASIN_BUG_A, GrasinBugARenderer::new);
        EntityRendererRegistry.register((EntityType) ModEntities.GRASIN_BUG_B, GrasinBugBRenderer::new);
        EntityRendererRegistry.register((EntityType) ModEntities.GRASIN_BUG_C, GrasinBugCRenderer::new);
    }
}
