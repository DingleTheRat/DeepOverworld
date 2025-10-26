package net.dinglezz.deepoverworld.datagen;

import net.dinglezz.deepoverworld.block.ModBlocks;
import net.dinglezz.deepoverworld.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.recipe.Ingredient;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends FabricRecipeProvider {
    public ModRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }
    
    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup wrapperLookup, RecipeExporter recipeExporter) {
        return new RecipeGenerator(wrapperLookup, recipeExporter) {
            @Override
            public void generate() {
                offer2x2CompactingRecipe(RecipeCategory.MISC, ModBlocks.DEEP_WOOD, ModBlocks.DEEP_LOG);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.GRASIN_A, RecipeCategory.MISC, ModBlocks.GRASIN_BOCK_A);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.GRASIN_B, RecipeCategory.MISC, ModBlocks.GRASIN_BOCK_B);
                offerReversibleCompactingRecipes(RecipeCategory.MISC, ModItems.GRASIN_C, RecipeCategory.MISC, ModBlocks.GRASIN_BOCK_C);
                
                createShaped(RecipeCategory.TOOLS, ModBlocks.DEEP_SPROUT)
                        .pattern("   ")
                        .pattern(" G ")
                        .pattern(" S ")
                        .input('S', ItemTags.SAPLINGS)
                        .input('G', ModItems.GRASIN_B)
                        .criterion(hasItem(ModItems.GRASIN_B), conditionsFromItem(ModItems.GRASIN_B))  // Unlock recipe when grasin B obtained
                        .offerTo(recipeExporter);
                
                createShaped(RecipeCategory.TOOLS, ModBlocks.GRASIN_WORKBENCH)
                        .pattern("BAC")
                        .pattern("IGI")
                        .pattern("PGP")
                        .input('P', ModBlocks.DEEP_WOOD)
                        .input('I', Items.IRON_INGOT)
                        .input('G', ModItems.GRASIN_GOO)
                        .input('A', ModItems.GRASIN_A)
                        .input('B', ModItems.GRASIN_B)
                        .input('C', ModItems.GRASIN_C)
                        .criterion(hasItem(ModItems.GRASIN_GOO), conditionsFromItem(ModItems.GRASIN_GOO))  // Unlock recipe when
                        // grasin B obtained
                        .offerTo(recipeExporter);
            }
        };
    }
    
    @Override
    public String getName() {
        return "DeepOverworld Recipes";
    }
}
