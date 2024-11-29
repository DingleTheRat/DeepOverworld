package net.dinglezz.deepoverworld.world;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.TreeFeatureConfig;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEP_TREE_KEY = registryKey("deepwood");

    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, DEEP_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DEEP_LOG),
                new StraightTrunkPlacer(5, 4, 3),

                BlockStateProvider.of(ModBlocks.DECAYED_GRASIN),
                new SpruceFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), ConstantIntProvider.create(2)),

                new TwoLayersFeatureSize(3, 1, 3)).build());
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registryKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(DeepOverworld.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>>
    void register(Registerable<ConfiguredFeature<?,?>> context, RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
