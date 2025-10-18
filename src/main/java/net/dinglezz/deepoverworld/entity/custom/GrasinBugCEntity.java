package net.dinglezz.deepoverworld.entity.custom;

import net.dinglezz.deepoverworld.effect.ModEffects;
import net.dinglezz.deepoverworld.item.ModItems;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.world.World;

public class GrasinBugCEntity extends GrasinBugEntity {
	public GrasinBugCEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	protected int getXpToDrop() { return 10; }
	
	@Override
	public boolean tryAttack(Entity target) {
		boolean didAttack = super.tryAttack(target);
		if (didAttack && target instanceof LivingEntity living) {
			living.addStatusEffect(new StatusEffectInstance(ModEffects.GRASIN_POISONING_TRES, 300, 0));
		}
		return didAttack;
	}
	
	@Override
	protected void dropLoot(DamageSource source, boolean causedByPlayer) {
		super.dropLoot(source, causedByPlayer);
		if (!this.getWorld().isClient()) {
			if (this.random.nextFloat() < 0.5f) {
				this.dropItem(ModItems.GRASIN_C);
			} else if (this.random.nextFloat() < 0.5f) {
				this.dropStack(ModItems.GRASIN_C.getDefaultStack().copyWithCount(2));
			} else if (this.random.nextFloat() < 0.5f) {
				this.dropStack(ModItems.GRASIN_C.getDefaultStack().copyWithCount(3));
			} else if (this.random.nextFloat() < 0.5f) {
				this.dropStack(ModItems.GRASIN_C.getDefaultStack().copyWithCount(4));
			}
		}
	}
	
	public static DefaultAttributeContainer.Builder createAttributes() {
		return HostileEntity.createHostileAttributes()
				.add(EntityAttributes.GENERIC_MAX_HEALTH, 5.0)
				.add(EntityAttributes.GENERIC_MOVEMENT_SPEED, 0.25)
				.add(EntityAttributes.GENERIC_ATTACK_DAMAGE, 4.0)
				.add(EntityAttributes.GENERIC_FOLLOW_RANGE, 16f);
	}
}
