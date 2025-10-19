package net.dinglezz.deepoverworld.block;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.block.custom.DeepSprout;
import net.dinglezz.deepoverworld.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.enums.NoteBlockInstrument;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    // Vegetation
    public static final Block DEEPSLATE_GRASS = registerBlock("deepslate_grass",
            properties -> new GrassBlock(properties.strength(3.0F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block DEEP_SPROUT = registerBlock("deep_sprout",
            properties -> new DeepSprout(ModSaplingGenerators.DEEP, properties.noCollision().ticksRandomly().breakInstantly()
                .pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.NYLIUM).nonOpaque()));

    // Grasin
    public static final Block DECAYED_GRASIN = registerBlock("decayed_grasin",
            properties -> new Block(properties.breakInstantly().sounds(BlockSoundGroup.WART_BLOCK).nonOpaque()));
    public static final Block GRASIN_BOCK_A = registerBlock("grasin_block_a",
            properties -> new Block(properties.strength(1f).sounds(BlockSoundGroup.WART_BLOCK).requiresTool()));
    public static final Block GRASIN_BOCK_B = registerBlock("grasin_block_b",
            properties -> new Block(properties.strength(1f).sounds(BlockSoundGroup.WART_BLOCK).requiresTool()));
    public static final Block GRASIN_BOCK_C = registerBlock("grasin_block_c",
            properties -> new Block(properties.strength(1f).sounds(BlockSoundGroup.WART_BLOCK).requiresTool()));

    // Wood
    public static final Block DEEP_LOG = registerBlock("deep_log",
            properties -> new PillarBlock(properties.instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.WOOD).strength(4f)));
    public static final Block DEEP_WOOD = registerBlock("deep_wood",
            properties -> new PillarBlock(properties.instrument(NoteBlockInstrument.BASS).sounds(BlockSoundGroup.WOOD).strength(4f)));

    // Functions
    private static Block registerBlock(String name, Function<AbstractBlock.Settings, Block> function) {
        Block toRegister = function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(DeepOverworld.MOD_ID, name))));
        registerBlockItem(name, toRegister);
        return Registry.register(Registries.BLOCK, Identifier.of(DeepOverworld.MOD_ID, name), toRegister);
    }

    private static Block registerBlockWithoutBlockItem(String name, Function<AbstractBlock.Settings, Block> function) {
        return Registry.register(Registries.BLOCK, Identifier.of(DeepOverworld.MOD_ID, name),
                function.apply(AbstractBlock.Settings.create().registryKey(RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(DeepOverworld.MOD_ID, name)))));
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DeepOverworld.MOD_ID, name),
                new BlockItem(block, new Item.Settings().useBlockPrefixedTranslationKey()
                        .registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DeepOverworld.MOD_ID, name)))));
    }

    public static void registerModBlocks() {
        DeepOverworld.LOGGER.info("Registering Mod Blocks for " + DeepOverworld.MOD_ID);
    }
}
