package net.dinglezz.deepoverworld.enchantment;

import net.dinglezz.deepoverworld.DeepOverworld;
import net.minecraft.component.type.AttributeModifierSlot;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.util.Identifier;

public class ModEnchantments {
    public static final RegistryKey<Enchantment> GRASIN_PROTECTION =
            RegistryKey.of(RegistryKeys.ENCHANTMENT, Identifier.of(DeepOverworld.MOD_ID, "grasin_protection"));

    public static void bootstrap(Registerable<Enchantment> registerable)  {
        var enchantments = registerable.getRegistryLookup(RegistryKeys.ENCHANTMENT);
        var items = registerable.getRegistryLookup(RegistryKeys.ITEM);

        register(registerable, GRASIN_PROTECTION, Enchantment.builder(Enchantment.definition(
            items.getOrThrow(ItemTags.ARMOR_ENCHANTABLE),
            items.getOrThrow(ItemTags.HEAD_ARMOR_ENCHANTABLE),
                5,
                3,
                Enchantment.leveledCost(5, 7),
                Enchantment.leveledCost(25, 9),
                2,
                AttributeModifierSlot.ARMOR))
                .exclusiveSet(enchantments.getOrThrow(EnchantmentTags.ARMOR_EXCLUSIVE_SET)));
    }

    private static void register(Registerable<Enchantment> registry, RegistryKey<Enchantment> key, Enchantment.Builder builder) {
        registry.register(key, builder.build(key.getValue()));
    }
}
