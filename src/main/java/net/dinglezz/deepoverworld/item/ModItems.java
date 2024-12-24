package net.dinglezz.deepoverworld.item;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.item.custom.GrasinAItem;
import net.dinglezz.deepoverworld.item.custom.GrasinBItem;
import net.dinglezz.deepoverworld.item.custom.GrasinCItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;

public class ModItems {
    //Grasin
    public static final Item GRASIN_A = registerItem("grasin_a", new GrasinAItem(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip_deepoverworld_grasin_a.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item GRASIN_B = registerItem("grasin_b", new GrasinBItem(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip_deepoverworld_grasin_b.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });
    public static final Item GRASIN_C = registerItem("grasin_c", new GrasinCItem(new Item.Settings()){
        @Override
        public void appendTooltip(ItemStack stack, TooltipContext context, List<Text> tooltip, TooltipType type) {
            tooltip.add(Text.translatable("tooltip_deepoverworld_grasin_c.tooltip"));
            super.appendTooltip(stack, context, tooltip, type);
        }
    });

    // Functions
    private static Item registerItem(String name, Item item) {
        return Registry.register(Registries.ITEM, Identifier.of(DeepOverworld.MOD_ID, name), item);
    }

    public static void registerModItems() {
        DeepOverworld.LOGGER.info("Registering Mod Items for " + DeepOverworld.MOD_ID);
    }
}
