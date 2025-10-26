package net.dinglezz.deepoverworld.item;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.block.ModBlocks;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

public class ModItemGroups {

    public static final ItemGroup DEEP_OVERWORLD = Registry.register(Registries.ITEM_GROUP,
            Identifier.of(DeepOverworld.MOD_ID, "deep_overworld"),
            FabricItemGroup.builder().icon(() -> new ItemStack(ModBlocks.DEEPSLATE_GRASS))
                    .displayName(Text.translatable("itemgroup.deepoverworld.deep_overworld"))
                    .entries((displayContext, entries) -> {
                        entries.add(ModBlocks.DEEPSLATE_GRASS);
                        entries.add(ModBlocks.DEEP_LOG);
                        entries.add(ModBlocks.DEEP_WOOD);

                        entries.add(ModBlocks.DECAYED_GRASIN);
                        entries.add(ModItems.GRASIN_A);
                        entries.add(ModItems.GRASIN_B);
                        entries.add(ModItems.GRASIN_C);
                        entries.add(ModItems.GRASIN_GOO);

                        entries.add(ModBlocks.GRASIN_BOCK_A);
                        entries.add(ModBlocks.GRASIN_BOCK_B);
                        entries.add(ModBlocks.GRASIN_BOCK_C);
                        entries.add(ModBlocks.DEEP_SPROUT);
                        entries.add(ModBlocks.GRASIN_WORKBENCH);
                    }).build());


    public static void registerItemGroups() {
        DeepOverworld.LOGGER.info("Registering item groups for " + DeepOverworld.MOD_ID);
    }
}
