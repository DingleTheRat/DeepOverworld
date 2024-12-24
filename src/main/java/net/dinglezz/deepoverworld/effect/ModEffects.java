package net.dinglezz.deepoverworld.effect;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEffects {
    public static final RegistryEntry<StatusEffect> GRASIN_POISONING_UNO = registerStatusEffect("grasin_poisoning_uno",
            new GrasinPoisoningEffect(StatusEffectCategory.HARMFUL, 0x523677));
    public static final RegistryEntry<StatusEffect> GRASIN_POISONING_DOS = registerStatusEffect("grasin_poisoning_dos",
            new GrasinPoisoningEffect(StatusEffectCategory.HARMFUL, 0x3767ab));
    public static final RegistryEntry<StatusEffect> GRASIN_POISONING_TRES = registerStatusEffect("grasin_poisoning_tres",
            new GrasinPoisoningEffect(StatusEffectCategory.HARMFUL, 0x5eab37));

    private static RegistryEntry<StatusEffect> registerStatusEffect(String name, StatusEffect statusEffect) {
        return Registry.registerReference(Registries.STATUS_EFFECT, Identifier.of(DeepOverworld.MOD_ID, name), statusEffect);
    }

    public static void registerEffects() {
        DeepOverworld.LOGGER.info("Registering Mod Effects for " + DeepOverworld.MOD_ID);
    }
}
