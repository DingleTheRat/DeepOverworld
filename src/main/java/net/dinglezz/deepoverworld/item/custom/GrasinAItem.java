package net.dinglezz.deepoverworld.item.custom;

import net.dinglezz.deepoverworld.effect.ModEffects;
import net.dinglezz.deepoverworld.enchantment.ModEnchantments;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.server.world.ServerWorld;
import org.jetbrains.annotations.Nullable;

public class GrasinAItem extends Item {
    public GrasinAItem(Settings settings) {
        super(settings);
    }
    
    @Override
    public void inventoryTick(ItemStack stack, ServerWorld world, Entity entity, @Nullable EquipmentSlot slot) {
        if (entity instanceof ServerPlayerEntity player) {
            
            ItemStack helmetStack = player.getInventory().getStack(EquipmentSlot.HEAD.getEntitySlotId());
            Registry<Enchantment> enchantmentRegistry = world.getRegistryManager().getOrThrow(RegistryKeys.ENCHANTMENT);
            RegistryEntry.Reference<Enchantment> enchantmentReference = enchantmentRegistry.getEntry(ModEnchantments.GRASIN_PROTECTION.getValue()).orElseThrow();
            boolean hasEnchantment = EnchantmentHelper.getLevel(enchantmentReference, helmetStack) > 0;
            
            if (!hasEnchantment) player.addStatusEffect(new StatusEffectInstance(ModEffects.GRASIN_POISONING_UNO, 1800, 0));
        }
        
        super.inventoryTick(stack, world, entity, slot);
    }
}
