package net.dinglezz.deepoverworld.block;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.block.custom.DeepBerryBush;
import net.dinglezz.deepoverworld.block.custom.DeepSapling;
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

    public static final Block DEEPSLATE_GRASS = registerBlock("deepslate_grass",
            new GrassBlock(AbstractBlock.Settings.create().strength(3.0F, 6.0F)
                    .requiresTool().sounds(BlockSoundGroup.DEEPSLATE)));
    public static final Block GRASIN = registerBlock("grasin",
            new Block(AbstractBlock.Settings.create().strength(2.0F, 5.0F).sounds(BlockSoundGroup.WART_BLOCK).requiresTool().nonOpaque()));

    public static final Block DEEP_SAPLING = registerBlock("deep_sapling",
        new DeepSapling(ModSaplingGenerators.DEEP, AbstractBlock.Settings.create().noCollision().ticksRandomly().breakInstantly()
                .pistonBehavior(PistonBehavior.DESTROY).sounds(BlockSoundGroup.NYLIUM).nonOpaque()));
    public static final Block DEEP_BERRY_BUSH = registerBlockWithoutBlockItem("deep_berry_bush",
            new DeepBerryBush(AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH)));

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
