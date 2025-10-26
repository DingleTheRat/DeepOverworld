package net.dinglezz.deepoverworld;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.entity.ModEntities;
import net.dinglezz.deepoverworld.entity.client.*;
import net.dinglezz.deepoverworld.screen.ModScreenHandlers;
import net.dinglezz.deepoverworld.screen.custom.GrasinWorkbenchScreen;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.client.render.BlockRenderLayer;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.gui.screen.ingame.HandledScreens;
import net.minecraft.entity.EntityType;

public class DeepOverworldClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        BlockRenderLayerMap.putBlock(ModBlocks.DECAYED_GRASIN, BlockRenderLayer.CUTOUT);
        BlockRenderLayerMap.putBlock(ModBlocks.DEEP_SPROUT, BlockRenderLayer.CUTOUT);
        
        EntityModelLayerRegistry.registerModelLayer(GrasinBugModel.GRASIN_BUG, GrasinBugModel::getTexturedModelData);
        EntityRendererRegistry.register((EntityType) ModEntities.GRASIN_BUG_A, GrasinBugARenderer::new);
        EntityRendererRegistry.register((EntityType) ModEntities.GRASIN_BUG_B, GrasinBugBRenderer::new);
        EntityRendererRegistry.register((EntityType) ModEntities.GRASIN_BUG_C, GrasinBugCRenderer::new);
        
        HandledScreens.register(ModScreenHandlers.GRASIN_WORKBENCH_SCREEN_HANDLER, GrasinWorkbenchScreen::new);
    }
}
