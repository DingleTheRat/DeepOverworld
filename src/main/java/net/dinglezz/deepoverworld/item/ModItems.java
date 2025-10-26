package net.dinglezz.deepoverworld.item;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.dinglezz.deepoverworld.entity.ModEntities;
import net.dinglezz.deepoverworld.item.custom.GrasinAItem;
import net.dinglezz.deepoverworld.item.custom.GrasinBItem;
import net.dinglezz.deepoverworld.item.custom.GrasinCItem;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.component.type.TooltipDisplayComponent;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroups;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SpawnEggItem;
import net.minecraft.item.tooltip.TooltipType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Consumer;
import java.util.function.Function;

public class ModItems {
    // Grasin
    public static final Item GRASIN_A = registerItem("grasin_a", settings -> new GrasinAItem(settings){
	    @Override
	    public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
		    textConsumer.accept(Text.translatable("tooltip_deepoverworld_grasin_a.tooltip"));
		    super.appendTooltip(stack, context, displayComponent, textConsumer, type);
	    }
    });
    public static final Item GRASIN_B = registerItem("grasin_b",settings -> new GrasinBItem(settings) {
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip_deepoverworld_grasin_b.tooltip"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });
    public static final Item GRASIN_C = registerItem("grasin_c", settings -> new GrasinCItem(settings){
        @Override
        public void appendTooltip(ItemStack stack, Item.TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
            textConsumer.accept(Text.translatable("tooltip_deepoverworld_grasin_c.tooltip"));
            super.appendTooltip(stack, context, displayComponent, textConsumer, type);
        }
    });
	public static final Item GRASIN_GOO = registerItem("grasin_goo", settings -> new Item(settings) {
		@Override
		public void appendTooltip(ItemStack stack, TooltipContext context, TooltipDisplayComponent displayComponent, Consumer<Text> textConsumer, TooltipType type) {
			textConsumer.accept(Text.translatable("tooltip_deepoverworld_grasin_goo.tooltip"));
			super.appendTooltip(stack, context, displayComponent, textConsumer, type);
		}
	});
    
    public static final Item GRASIN_BUG_A_SPAWN_EGG = registerItem("grasin_bug_a_spawn_egg", settings ->
            new SpawnEggItem(settings.spawnEgg(ModEntities.GRASIN_BUG_A)));
    public static final Item GRASIN_BUG_B_SPAWN_EGG = registerItem("grasin_bug_b_spawn_egg", settings ->
            new SpawnEggItem(settings.spawnEgg(ModEntities.GRASIN_BUG_B)));
    public static final Item GRASIN_BUG_C_SPAWN_EGG = registerItem("grasin_bug_c_spawn_egg", settings ->
            new SpawnEggItem(settings.spawnEgg(ModEntities.GRASIN_BUG_C)));

    // Functions
    private static Item registerItem(String name, Function<Item.Settings, Item> function) {
        return Registry.register(Registries.ITEM, Identifier.of(DeepOverworld.MOD_ID, name),
                function.apply(new Item.Settings().registryKey(RegistryKey.of(RegistryKeys.ITEM, Identifier.of(DeepOverworld.MOD_ID, name)))));
    }

    public static void registerModItems() {
        DeepOverworld.LOGGER.info("Registering Mod Items for " + DeepOverworld.MOD_ID);
        
        ItemGroupEvents.modifyEntriesEvent(ItemGroups.SPAWN_EGGS).register((itemGroup) -> {
            itemGroup.add(ModItems.GRASIN_BUG_A_SPAWN_EGG);
            itemGroup.add(ModItems.GRASIN_BUG_B_SPAWN_EGG);
            itemGroup.add(ModItems.GRASIN_BUG_C_SPAWN_EGG);
        });
    }
}
