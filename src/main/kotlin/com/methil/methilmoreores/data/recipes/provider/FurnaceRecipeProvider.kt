package com.methil.methilmoreores.data.recipes.provider


import com.methil.methilmoreores.block.MethilBlock
import com.methil.methilmoreores.data.init.TagsInit
import com.methil.methilmoreores.data.recipes.MethilRecipeProvider
import com.methil.methilmoreores.item.MethilItem
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder
import net.minecraft.world.item.crafting.Ingredient
import java.util.concurrent.CompletableFuture

class FurnaceRecipeProvider(
    generator: DataGenerator,
    pRegistries: CompletableFuture<HolderLookup.Provider>,
    private val recipeOutput: RecipeOutput
) :
    MethilRecipeProvider(generator, pRegistries) {
    fun build() {
        SimpleCookingRecipeBuilder.smelting(
            Ingredient.of(MethilBlock.METHIL_ORE_BLOCK.asItem()),
            RecipeCategory.MISC,
            MethilItem.METHIL_ITEM,
            0.6f,
            300
        )
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_item_smelting"))
    }
}