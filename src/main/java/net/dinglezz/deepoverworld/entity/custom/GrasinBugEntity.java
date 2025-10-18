package net.dinglezz.deepoverworld.entity.custom;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.world.World;

public abstract class GrasinBugEntity extends HostileEntity {
	public final AnimationState walkingAnimationState = new AnimationState();
	private int walkingAnimationTimeout = 0;
	
	public GrasinBugEntity(EntityType<? extends HostileEntity> entityType, World world) {
		super(entityType, world);
	}
	
	@Override
	protected void initGoals() {
		// Swim if in water
		this.goalSelector.add(0, new SwimGoal(this));
		this.goalSelector.add(1, new MeleeAttackGoal(this, 1.2, true));
		this.goalSelector.add(2, new WanderAroundGoal(this, 1.0));
		this.goalSelector.add(3, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.targetSelector.add(1, new ActiveTargetGoal<>(this, PlayerEntity.class, true));
	}
	
	private void setupAnimationStates() {
		DeepOverworld.LOGGER.info(String.valueOf(this.getNavigation().isIdle()));
		if (!this.getNavigation().isIdle()) {
			if (this.walkingAnimationTimeout++ > 40) {
				this.walkingAnimationState.start(this.age);
				this.walkingAnimationTimeout = 0;
			}
		} else {
			this.walkingAnimationState.stop();
		}
	}
	
	@Override
	public void tick() {
		super.tick();
		
		if (this.getWorld().isClient()) {
			this.setupAnimationStates();
		}
	}
}
