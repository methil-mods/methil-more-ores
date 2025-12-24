package com.methil.methilmoreores.data.recipes.provider


import com.methil.methilmoreores.data.recipes.MethilRecipeProvider
import com.methil.methilmoreores.item.emerald.EmeraldItem.EMERALD_AXE
import com.methil.methilmoreores.item.emerald.EmeraldItem.EMERALD_BOOTS
import com.methil.methilmoreores.item.emerald.EmeraldItem.EMERALD_CHESTPLATE
import com.methil.methilmoreores.item.emerald.EmeraldItem.EMERALD_HELMET
import com.methil.methilmoreores.item.emerald.EmeraldItem.EMERALD_HOE
import com.methil.methilmoreores.item.emerald.EmeraldItem.EMERALD_LEGGINGS
import com.methil.methilmoreores.item.emerald.EmeraldItem.EMERALD_PICKAXE
import com.methil.methilmoreores.item.emerald.EmeraldItem.EMERALD_SHOVEL
import com.methil.methilmoreores.item.emerald.EmeraldItem.EMERALD_SWORD
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.world.item.Items.EMERALD
import net.minecraft.world.item.Items.STICK
import java.util.concurrent.CompletableFuture

class EmeraldNormalCraftingTableRecipeProvider(
    generator: DataGenerator,
    pRegistries: CompletableFuture<HolderLookup.Provider>,
    private val recipeOutput: RecipeOutput
) : MethilRecipeProvider(generator, pRegistries) {
    fun build() {
        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EMERALD_SHOVEL.get(), 1)
            .pattern(" # ")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', EMERALD)
            .define('S', STICK)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_shovel_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EMERALD_HOE.get(), 1)
            .pattern(" ##")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', EMERALD)
            .define('S', STICK)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_hoe_right_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EMERALD_HOE.get(), 1)
            .pattern("## ")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', EMERALD)
            .define('S', STICK)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_hoe_left_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EMERALD_PICKAXE.get(), 1)
            .pattern("###")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', EMERALD)
            .define('S', STICK)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_pickaxe_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EMERALD_AXE.get(), 1)
            .pattern(" ##")
            .pattern(" S#")
            .pattern(" S ")
            .define('#', EMERALD)
            .define('S', STICK)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_axe_right_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EMERALD_AXE.get(), 1)
            .pattern("## ")
            .pattern("#S ")
            .pattern(" S ")
            .define('#', EMERALD)
            .define('S', STICK)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_axe_left_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, EMERALD_SWORD.get(), 1)
            .pattern(" # ")
            .pattern(" # ")
            .pattern(" S ")
            .define('#', EMERALD)
            .define('S', STICK)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_sword_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EMERALD_HELMET.get(), 1)
            .pattern("###")
            .pattern("# #")
            .define('#', EMERALD)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_helmet_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EMERALD_CHESTPLATE.get(), 1)
            .pattern("# #")
            .pattern("###")
            .pattern("###")
            .define('#', EMERALD)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_chestplate_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EMERALD_LEGGINGS.get(), 1)
            .pattern("###")
            .pattern("# #")
            .pattern("# #")
            .define('#', EMERALD)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_leggings_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, EMERALD_BOOTS.get(), 1)
            .pattern("# #")
            .pattern("# #")
            .define('#', EMERALD)
            .unlockedBy("has_item", has(EMERALD))
            .save(this.recipeOutput, getModId("emerald_boots_recipe"))
    }
}