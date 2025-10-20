package net.dinglezz.deepoverworld.screen;

import net.fabricmc.fabric.api.screenhandler.v1.ExtendedScreenHandlerType;
import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.screen.custom.GrasinWorkbenchScreenHandler;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

public class ModScreenHandlers {
	public static final ScreenHandlerType<GrasinWorkbenchScreenHandler> GRASIN_WORKBENCH_SCREEN_HANDLER =
			Registry.register(Registries.SCREEN_HANDLER, Identifier.of(DeepOverworld.MOD_ID, "grasin_workbench_screen_handler"),
					new ExtendedScreenHandlerType<>(GrasinWorkbenchScreenHandler::new, BlockPos.PACKET_CODEC));
	
	
	public static void registerScreenHandlers() {
		DeepOverworld.LOGGER.info("Registering Screen Handlers for " + DeepOverworld.MOD_ID);
	}
}