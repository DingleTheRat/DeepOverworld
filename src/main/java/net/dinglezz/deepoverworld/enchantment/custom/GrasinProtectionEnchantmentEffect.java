package net.dinglezz.deepoverworld.enchantment.custom;

import com.mojang.serialization.MapCodec;
import net.dinglezz.deepoverworld.DeepOverworld;
import net.minecraft.enchantment.EnchantmentEffectContext;
import net.minecraft.enchantment.effect.EnchantmentEntityEffect;
import net.minecraft.entity.Entity;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.math.Vec3d;

public record GrasinProtectionEnchantmentEffect() implements EnchantmentEntityEffect {
    public static MapCodec<GrasinProtectionEnchantmentEffect> CODEC = MapCodec.unit(GrasinProtectionEnchantmentEffect::new);

    @Override
    public void apply(ServerWorld world, int level, EnchantmentEffectContext context, Entity user, Vec3d pos) {
        if (level == 1) {

        } else if (level == 2) {

        } else if (level == 3) {

        }
    }

    @Override
    public MapCodec<? extends EnchantmentEntityEffect> getCodec() {
        return CODEC;
    }
}
