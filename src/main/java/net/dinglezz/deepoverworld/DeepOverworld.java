package net.dinglezz.deepoverworld;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.item.ModItemGroups;
import net.dinglezz.deepoverworld.item.ModItems;
import net.dinglezz.deepoverworld.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DeepOverworld implements ModInitializer {
    public static final String MOD_ID = "deepoverworld";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        ModItemGroups.registerItemGroups();

        ModItems.registerModItems();
        ModBlocks.registerModBlocks();

        ModWorldGeneration.generateModWorldGen();
    }
}
