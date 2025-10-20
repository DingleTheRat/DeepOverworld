package net.dinglezz.deepoverworld.datagen;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.data.client.*;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class ModModelProvider extends FabricModelProvider {
    public ModModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        blockStateModelGenerator.registerLog(ModBlocks.DEEP_LOG).log(ModBlocks.DEEP_LOG).wood(ModBlocks.DEEP_WOOD);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.DECAYED_GRASIN);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRASIN_BOCK_A);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRASIN_BOCK_B);
        blockStateModelGenerator.registerSimpleCubeAll(ModBlocks.GRASIN_BOCK_C);
        blockStateModelGenerator.registerSingleton(ModBlocks.GRASIN_WORKBENCH, TexturedModel.CUBE_BOTTOM_TOP);
        blockStateModelGenerator.registerTintableCross(ModBlocks.DEEP_SPROUT, BlockStateModelGenerator.TintType.NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {
        itemModelGenerator.register(ModItems.GRASIN_A, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRASIN_B, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRASIN_C, Models.GENERATED);
        itemModelGenerator.register(ModItems.GRASIN_GOO, Models.GENERATED);
        
        itemModelGenerator.register(ModItems.GRASIN_BUG_A_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GRASIN_BUG_B_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
        itemModelGenerator.register(ModItems.GRASIN_BUG_C_SPAWN_EGG,
                new Model(Optional.of(Identifier.of("item/template_spawn_egg")), Optional.empty()));
    }
}
