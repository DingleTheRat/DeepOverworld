package net.dinglezz.deepoverworld.potion;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.effect.ModEffects;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.potion.Potion;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModPotions {
    public static final RegistryEntry<Potion> GRASIN_POISONING_POTION_UNO = registerPotion("grasin_poisoning_potion_uno",
            new Potion("grasin_poisoning_potion_uno", new StatusEffectInstance(ModEffects.GRASIN_POISONING_UNO, 1800, 0)));
    public static final RegistryEntry<Potion> GRASIN_POISONING_POTION_DOS = registerPotion("grasin_poisoning_potion_dos",
            new Potion("grasin_poisoning_potion_dos", new StatusEffectInstance(ModEffects.GRASIN_POISONING_DOS, 1800, 1)));
    public static final RegistryEntry<Potion> GRASIN_POISONING_POTION_TRES = registerPotion("grasin_poisoning_potion_tres",
            new Potion("grasin_poisoning_potion_tres", new StatusEffectInstance(ModEffects.GRASIN_POISONING_TRES, 1800, 2)));

    private static RegistryEntry<Potion> registerPotion(String name, Potion potion) {
        return Registry.registerReference(Registries.POTION, Identifier.of(DeepOverworld.MOD_ID, name), potion);
    }

    public static void registerPotions() {
        DeepOverworld.LOGGER.info("Registering Potions for " + DeepOverworld.MOD_ID);
    }
}
