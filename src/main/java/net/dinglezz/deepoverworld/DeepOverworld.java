package net.dinglezz.deepoverworld;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.effect.ModEffects;
import net.dinglezz.deepoverworld.enchantment.ModEnchantmentEffects;
import net.dinglezz.deepoverworld.item.ModItemGroups;
import net.dinglezz.deepoverworld.item.ModItems;
import net.dinglezz.deepoverworld.potion.ModPotions;
import net.dinglezz.deepoverworld.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.registry.FabricBrewingRecipeRegistryBuilder;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
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
        ModEffects.registerEffects();
        ModPotions.registerPotions();
        ModEnchantmentEffects.registerEnchantmentEffects();

        ModWorldGeneration.generateModWorldGen();

        FabricBrewingRecipeRegistryBuilder.BUILD.register(builder -> {
            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.GRASIN_A, ModPotions.GRASIN_POISONING_POTION_UNO);
            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.GRASIN_B, ModPotions.GRASIN_POISONING_POTION_DOS);
            builder.registerPotionRecipe(Potions.AWKWARD, ModItems.GRASIN_C, ModPotions.GRASIN_POISONING_POTION_TRES);
        });
    }
}
