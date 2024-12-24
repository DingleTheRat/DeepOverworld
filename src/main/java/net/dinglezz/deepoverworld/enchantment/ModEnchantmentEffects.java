package net.dinglezz.deepoverworld.enchantment;

import com.mojang.serialization.MapCodec;
import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.enchantment.custom.GrasinProtectionEnchantmentEffect;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModEnchantmentEffects {
    public static final MapCodec<? extends EnchantmentEntityEffect> GRASIN_PROTECTION =
            registerEntityEffect("grasin_protection", GrasinProtectionEnchantmentEffect.CODEC);

    private static MapCodec<? extends EnchantmentEntityEffect> registerEntityEffect(String name, MapCodec<? extends EnchantmentEntityEffect> codec) {
        return Registry.register(Registries.ENCHANTMENT_ENTITY_EFFECT_TYPE, Identifier.of(DeepOverworld.MOD_ID, name), codec);
    }

    public static void registerEnchantmentEffects() {
        DeepOverworld.LOGGER.info("Registering Enchantment Effect for " + DeepOverworld.MOD_ID);
    }
}
