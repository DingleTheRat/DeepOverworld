package net.dinglezz.deepoverworld.datagen;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Block;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Item;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.entry.LeafEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class ModLootTableProvider extends FabricBlockLootTableProvider {
    public ModLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        addDrop(ModBlocks.DEEPSLATE_GRASS);
        addDrop(ModBlocks.DEEP_LOG);
        addDrop(ModBlocks.DEEP_WOOD);
        addDrop(ModBlocks.DECAYED_GRASIN, multipleOreDrops(ModBlocks.DECAYED_GRASIN, ModItems.GRASIN_A, 1, 3));
        addDrop(ModBlocks.GRASIN_BOCK_A, multipleOreDrops(ModBlocks.GRASIN_BOCK_A, ModItems.GRASIN_A, 6, 9));
        addDrop(ModBlocks.GRASIN_BOCK_B, multipleOreDrops(ModBlocks.GRASIN_BOCK_B, ModItems.GRASIN_B, 6, 9));
        addDrop(ModBlocks.GRASIN_BOCK_B, multipleOreDrops(ModBlocks.GRASIN_BOCK_B, ModItems.GRASIN_B, 6, 9));
        addDrop(ModBlocks.DEEP_SPROUT);
    }

    public LootTable.Builder multipleOreDrops(Block drop, Item item, float minDrops, float maxDrops) {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);
        return this.dropsWithSilkTouch(drop, this.applyExplosionDecay(drop, ((LeafEntry.Builder<?>)
                ItemEntry.builder(item).apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(minDrops, maxDrops))))
                .apply(ApplyBonusLootFunction.oreDrops(impl.getOrThrow(Enchantments.FORTUNE)))));
    }
}
