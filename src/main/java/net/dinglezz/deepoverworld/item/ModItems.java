package net.dinglezz.deepoverworld.item;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.block.ModBlocks;
import net.minecraft.item.AliasedBlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModItems {
    public static final Item DEEP_BERRIES = registerItem("deep_berries",
            new AliasedBlockItem(ModBlocks.DEEP_BERRY_BUSH, new Item.Settings()));// NOTE!!!! 1.21.3 alias block item is a setting!!!!!

    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(DeepOverworld.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DeepOverworld.LOGGER.info("Registering Mod Items for " + DeepOverworld.MOD_ID);
    }
}
