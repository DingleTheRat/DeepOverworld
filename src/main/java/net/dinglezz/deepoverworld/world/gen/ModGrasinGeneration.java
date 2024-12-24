package net.dinglezz.deepoverworld.world.gen;

import net.dinglezz.deepoverworld.world.ModPlacedFeatures;
import net.dinglezz.deepoverworld.world.biome.ModBiomes;
import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.world.gen.GenerationStep;

public class ModGrasinGeneration {
    public static void generateGrasin() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DEEP_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GRASIN_B_GEN_PLACED_KEY);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(ModBiomes.DEEP_FOREST),
                GenerationStep.Feature.VEGETAL_DECORATION, ModPlacedFeatures.GRASIN_C_GEN_PLACED_KEY);
    }
}
