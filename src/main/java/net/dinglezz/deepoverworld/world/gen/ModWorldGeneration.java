package net.dinglezz.deepoverworld.world.gen;

public class ModWorldGeneration {
    public static void generateModWorldGen() {
        // Order in the court is important! !
        ModTreeGeneration.generateTrees();
        ModGrasinGeneration.generateGrasin();
    }
}
