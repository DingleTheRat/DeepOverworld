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
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class GrasinBugAEntity extends GrasinBugEntity {
	public GrasinBugAEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	protected int getExperienceToDrop(ServerWorld world) {
		return 5;
	}
	
	@Override
	public boolean tryAttack(ServerWorld world, Entity target) {
		boolean didAttack = super.tryAttack(world, target);
		if (didAttack && target instanceof LivingEntity living) {
			living.addStatusEffect(new StatusEffectInstance(ModEffects.GRASIN_POISONING_UNO, 1200, 0));
		}
		return didAttack;
	}
	
	@Override
	protected void dropLoot(ServerWorld world, DamageSource source, boolean causedByPlayer) {
		super.dropLoot(world, source, causedByPlayer);
		if (!this.getWorld().isClient()) {
			if (this.random.nextFloat() < 0.5f) {
				this.dropItem(world, ModItems.GRASIN_A);
			} else if (this.random.nextFloat() < 0.5f) {
				this.dropStack(world, ModItems.GRASIN_A.getDefaultStack().copyWithCount(2));
			} else if (this.random.nextFloat() < 0.5f) {
				this.dropStack(world, ModItems.GRASIN_A.getDefaultStack().copyWithCount(3));
			} else if (this.random.nextFloat() < 0.5f) {
				this.dropStack(world, ModItems.GRASIN_A.getDefaultStack().copyWithCount(4));
			}
			this.dropStack(world, ModItems.GRASIN_GOO.getDefaultStack().copyWithCount(1));
		}
	}
	
	public static DefaultAttributeContainer.Builder createAttributes() {
		return HostileEntity.createHostileAttributes()
				.add(EntityAttributes.MAX_HEALTH, 1.0)
				.add(EntityAttributes.MOVEMENT_SPEED, 0.25)
				.add(EntityAttributes.ATTACK_DAMAGE, 1.0)
				.add(EntityAttributes.FOLLOW_RANGE, 16f);
	}
}
