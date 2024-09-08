package io.github.realyusufismail.data.recipe.provider

import com.methil.methilmoreores.MethilMoreOres.Companion.METHIL_PICKAXE
import com.methil.methilmoreores.MethilMoreOres.Companion.METHIL_ITEM
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import io.github.realyusufismail.data.recipe.MainModRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.*
import net.minecraft.world.item.crafting.Ingredient
import java.util.concurrent.CompletableFuture

class NormalCraftingTableRecipeProvider(
    generator: DataGenerator,
    pRegistries: CompletableFuture<HolderLookup.Provider?>,
    private val recipeOutput: RecipeOutput
) : MainModRecipeProvider (generator, pRegistries)
{
    fun build() {
        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, METHIL_PICKAXE.get(), 1)
            .pattern("###")
            .pattern("# #")
            .pattern("# #")
            .define('#', METHIL_ITEM)
            .unlockedBy("has_item", has(METHIL_PICKAXE))
            .save(this.recipeOutput,  getModId("methil_pickaxe_recipe"))
    }
}