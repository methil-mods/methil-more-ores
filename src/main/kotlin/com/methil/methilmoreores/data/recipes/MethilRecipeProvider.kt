package com.methil.methilmoreores.data.recipes

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.data.recipes.provider.FurnaceRecipeProvider
import com.methil.methilmoreores.data.recipes.provider.NormalCraftingTableRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.resources.ResourceLocation
import java.util.concurrent.CompletableFuture


open class MethilRecipeProvider(
    protected val generator: DataGenerator,
    private val registries: CompletableFuture<HolderLookup.Provider>
) :
    RecipeProvider(generator.packOutput, registries) {
    override fun buildRecipes(pRecipeOutput: RecipeOutput) {
        NormalCraftingTableRecipeProvider(generator, registries, pRecipeOutput).build()
        FurnaceRecipeProvider(generator, registries, pRecipeOutput).build()
    }

    fun getModId(path: String?): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(MODID, path)
    }
}