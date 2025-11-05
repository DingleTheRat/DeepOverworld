package net.dinglezz.deepoverworld.world;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.block.ModBlocks;
import net.minecraft.block.Blocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.intprovider.ConstantIntProvider;
import net.minecraft.world.gen.blockpredicate.BlockPredicate;
import net.minecraft.world.gen.feature.*;
import net.minecraft.world.gen.feature.size.TwoLayersFeatureSize;
import net.minecraft.world.gen.foliage.SpruceFoliagePlacer;
import net.minecraft.world.gen.stateprovider.BlockStateProvider;
import net.minecraft.world.gen.stateprovider.PillarBlockStateProvider;
import net.minecraft.world.gen.trunk.StraightTrunkPlacer;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> DEEP_TREE_KEY = registerKey("deep_tree");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRASIN_B_GEN_KEY = registerKey("grasin_c_gen_key");
    public static final RegistryKey<ConfiguredFeature<?, ?>> GRASIN_C_GEN_KEY = registerKey("grasin_a_gen_key");
    
    public static void bootstrap(Registerable<ConfiguredFeature<?, ?>> context) {
        register(context, DEEP_TREE_KEY, Feature.TREE, new TreeFeatureConfig.Builder(
                BlockStateProvider.of(ModBlocks.DEEP_LOG),
                new StraightTrunkPlacer(5, 4, 3),

                BlockStateProvider.of(ModBlocks.DECAYED_GRASIN),
                new SpruceFoliagePlacer(ConstantIntProvider.create(2), ConstantIntProvider.create(1), ConstantIntProvider.create(2)),

                new TwoLayersFeatureSize(3, 1, 3)).dirtProvider(BlockStateProvider.of(Blocks.DEEPSLATE)).build());

        register(context, GRASIN_B_GEN_KEY, Feature.RANDOM_PATCH,
                new RandomPatchFeatureConfig(
                        64,
                        3,
                        1,
                        PlacedFeatures.createEntry(
                                Feature.SIMPLE_BLOCK,
                                new SimpleBlockFeatureConfig(BlockStateProvider.of(ModBlocks.GRASIN_BOCK_B)),
                                BlockPredicate.allOf(BlockPredicate.replaceable(), BlockPredicate.noFluid(), BlockPredicate.matchingBlocks(Direction.DOWN.getVector(), ModBlocks.DEEPSLATE_GRASS))
                        )
                ));
        register(context, GRASIN_C_GEN_KEY, Feature.BLOCK_PILE, new BlockPileFeatureConfig(new PillarBlockStateProvider(ModBlocks.GRASIN_BOCK_C)));
    }

    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, Identifier.of(DeepOverworld.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>> void register(Registerable<ConfiguredFeature<?, ?>> context,
                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
