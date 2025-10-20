package net.dinglezz.deepoverworld.block;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.block.custom.DeepSprout;
import net.dinglezz.deepoverworld.world.tree.ModSaplingGenerators;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

public class ModBlocks {
    // Vegetation
    public static final Block DEEPSLATE_GRASS = registerBlock("deepslate_grass",
            new GrassBlock(AbstractBlock.Settings.create().strength(3.0F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block DEEP_SPROUT = registerBlock("deep_sprout",
        new DeepSprout(ModSaplingGenerators.DEEP, AbstractBlock.Settings.create().noCollision().ticksRandomly().breakInstantly()
                .pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.NYLIUM).nonOpaque()));

    // Grasin
    public static final Block DECAYED_GRASIN = registerBlock("decayed_grasin",
            new Block(AbstractBlock.Settings.create().breakInstantly().sounds(BlockSoundGroup.WART_BLOCK).nonOpaque()));
    public static final Block GRASIN_BOCK_A = registerBlock("grasin_block_a",
            new Block(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.WART_BLOCK).requiresTool()));
    public static final Block GRASIN_BOCK_B = registerBlock("grasin_block_b",
            new Block(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.WART_BLOCK).requiresTool()));
    public static final Block GRASIN_BOCK_C = registerBlock("grasin_block_c",
            new Block(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.WART_BLOCK).requiresTool()));
    public static final Block GRASIN_WORKBENCH = registerBlock("grasin_workbench",
            new Block(AbstractBlock.Settings.create().strength(1f).sounds(BlockSoundGroup.WOOD)));
    
    // Wood
    public static final Block DEEP_LOG = registerBlock("deep_log",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_LOG).strength(4f)));
    public static final Block DEEP_WOOD = registerBlock("deep_wood",
            new PillarBlock(AbstractBlock.Settings.copy(Blocks.SPRUCE_WOOD).strength(4f)));

    // Functions
    private static Block registerBlockWithoutBlockItem(String name, Block block) {
        return Registry.register(Registries.BLOCK, Identifier.of(DeepOverworld.MOD_ID, name), block);
    }

    private static Block registerBlock(String name, Block block) {
        registerBlockItem(name, block);
        return Registry.register(Registries.BLOCK, Identifier.of(DeepOverworld.MOD_ID, name), block);
    }

    private static void registerBlockItem(String name, Block block) {
        Registry.register(Registries.ITEM, Identifier.of(DeepOverworld.MOD_ID, name),
                new BlockItem(block, new Item.Settings()));
    }

    public static void registerModBlocks() {
        DeepOverworld.LOGGER.info("Registering Mod Blocks for " + DeepOverworld.MOD_ID);
    }
}
