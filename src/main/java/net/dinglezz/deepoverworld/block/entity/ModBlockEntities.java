package net.dinglezz.deepoverworld.block.entity;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.block.entity.custom.GrasinWorkbenchBlockEntity;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
	public static final BlockEntityType<GrasinWorkbenchBlockEntity> GRASIN_WORKBENCH_BE =
			Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(DeepOverworld.MOD_ID, "grasin_workbench_be"),
					FabricBlockEntityTypeBuilder.create(GrasinWorkbenchBlockEntity::new, ModBlocks.GRASIN_WORKBENCH).build());
	public static void registerBlockEntities() {
		DeepOverworld.LOGGER.info("Registering Block Entities for " + DeepOverworld.MOD_ID);
	}
}
