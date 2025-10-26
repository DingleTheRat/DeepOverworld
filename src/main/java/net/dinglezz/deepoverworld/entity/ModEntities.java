package net.dinglezz.deepoverworld.entity;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.entity.custom.*;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

public class ModEntities {
	private static final RegistryKey<EntityType<?>> GRASIN_BUG_A_KEY =
			RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(DeepOverworld.MOD_ID, "grasin_bug_a"));
	private static final RegistryKey<EntityType<?>> GRASIN_BUG_B_KEY =
			RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(DeepOverworld.MOD_ID, "grasin_bug_b"));
	private static final RegistryKey<EntityType<?>> GRASIN_BUG_C_KEY =
			RegistryKey.of(RegistryKeys.ENTITY_TYPE, Identifier.of(DeepOverworld.MOD_ID, "grasin_bug_c"));
	
	public static final EntityType<? extends MobEntity> GRASIN_BUG_A = Registry.register(Registries.ENTITY_TYPE,
			Identifier.of(DeepOverworld.MOD_ID, "grasin_bug_a"),
			EntityType.Builder.create(GrasinBugAEntity::new, SpawnGroup.MONSTER)
					.dimensions(0.3f, 0.14f).build(GRASIN_BUG_A_KEY));
	public static final EntityType<? extends MobEntity> GRASIN_BUG_B = Registry.register(Registries.ENTITY_TYPE,
			Identifier.of(DeepOverworld.MOD_ID, "grasin_bug_b"),
			EntityType.Builder.create(GrasinBugBEntity::new, SpawnGroup.MONSTER)
					.dimensions(0.3f, 0.14f).build(GRASIN_BUG_B_KEY));
	public static final EntityType<? extends MobEntity> GRASIN_BUG_C = Registry.register(Registries.ENTITY_TYPE,
			Identifier.of(DeepOverworld.MOD_ID, "grasin_bug_c"),
			EntityType.Builder.create(GrasinBugCEntity::new, SpawnGroup.MONSTER)
					.dimensions(0.3f, 0.14f).build(GRASIN_BUG_C_KEY));
	
	public static void registerModEntities() {
		DeepOverworld.LOGGER.info("Registering Mod Entities for " + DeepOverworld.MOD_ID);
	}
}
