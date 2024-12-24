package net.dinglezz.deepoverworld.datagen;

import com.mojang.datafixers.types.templates.Tag;
import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.Ingredient;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
          offer2x2CompactingRecipe(recipeExporter, RecipeCategory.MISC, ModBlocks.DEEP_WOOD, ModBlocks.DEEP_LOG);
          offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.GRASIN_A, RecipeCategory.MISC, ModBlocks.GRASIN_BOCK_A);
          offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.GRASIN_B, RecipeCategory.MISC, ModBlocks.GRASIN_BOCK_B);
          offerReversibleCompactingRecipes(recipeExporter, RecipeCategory.MISC, ModItems.GRASIN_C, RecipeCategory.MISC, ModBlocks.GRASIN_BOCK_C);

        ShapedRecipeJsonBuilder.create(RecipeCategory.TOOLS, ModBlocks.DEEP_SPROUT)
                .pattern("   ")
                .pattern(" G ")
                .pattern(" S ")
                .input('S', Ingredient.fromTag(ItemTags.SAPLINGS))
                .input('G', ModItems.GRASIN_B)
                .criterion(hasItem(ModItems.GRASIN_B), conditionsFromItem(ModItems.GRASIN_B))// Unlock recipe when pink garnet obtained
                .offerTo(recipeExporter);

    }
}
