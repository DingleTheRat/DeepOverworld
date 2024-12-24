package net.dinglezz.deepoverworld.enchantment;

import net.minecraft.entity.attribute.ClampedEntityAttribute;
import net.minecraft.entity.attribute.EntityAttribute;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.util.Identifier;

public class ModEntityAttributes {
    public static final RegistryEntry<EntityAttribute> GENERIC_GRASIN_PROTECTION;

    private static RegistryEntry<EntityAttribute> register(String id, EntityAttribute attribute) {
        return Registry.registerReference(Registries.ATTRIBUTE, Identifier.ofVanilla(id), attribute);
    }

    static {
        GENERIC_GRASIN_PROTECTION = register("player.grasin_protection", (new ClampedEntityAttribute("attribute.name.player.grasin_protection", (double)0.0F, (double)0.0F, (double)3.0F)).setTracked(true));
    }
}
