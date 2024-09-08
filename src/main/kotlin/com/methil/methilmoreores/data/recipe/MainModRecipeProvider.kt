package io.github.realyusufismail.data.recipe

import com.methil.methilmoreores.MethilMoreOres
import io.github.realyusufismail.data.recipe.provider.NormalCraftingTableRecipeProvider
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.RecipeProvider
import net.minecraft.resources.ResourceLocation
import java.util.concurrent.CompletableFuture

open class MainModRecipeProvider(
    protected val generator: DataGenerator,
    private val registries: CompletableFuture<HolderLookup.Provider?>
) : RecipeProvider(generator.packOutput, registries) {

    override fun buildRecipes(pRecipeOutput: RecipeOutput) {
        NormalCraftingTableRecipeProvider(generator, registries, pRecipeOutput).build()
    }

    fun getModId(path: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(MethilMoreOres.MODID, path)
    }
}