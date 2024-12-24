package net.dinglezz.deepoverworld.effect;

import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectCategory;

public class GrasinPoisoningEffect extends StatusEffect {
    protected GrasinPoisoningEffect(StatusEffectCategory category, int color) {
        super(category, color);
    }

    public boolean applyUpdateEffect(LivingEntity entity, int amplifier) {
        if (amplifier == 0 && entity.getHealth() > 15.0F) {
            entity.damage(entity.getDamageSources().magic(), 1.0F);
        }
        else if (amplifier == 1 && entity.getHealth() > 11.0F) {
            entity.damage(entity.getDamageSources().magic(), 1.0F);
        }
        else if (amplifier == 2 && entity.getHealth() > 5.0F) {
            entity.damage(entity.getDamageSources().magic(), 1.0F);
        }

        return true;
    }

    public boolean canApplyUpdateEffect(int duration, int amplifier) {
        int i = 40 >> 2;
        return duration % i == 0;
    }
}
