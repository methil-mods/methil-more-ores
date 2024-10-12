package com.methil.methilmoreores.data.recipes.provider


import com.methil.methilmoreores.block.MethilBlock.METHIL_BLOCK
import com.methil.methilmoreores.data.recipes.MethilRecipeProvider
import com.methil.methilmoreores.item.methil.MethilItem
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_AXE
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_BOOTS
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_CHESTPLATE
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_DOUBLE_PICKAXE
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_HELMET
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_HOE
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_ITEM
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_LEGGINGS
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_PICKAXE
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_SHOVEL
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_SWORD
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_AXE
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_BOOTS
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_CHESTPLATE
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_HELMET
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_HOE
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_ITEM
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_LEGGINGS
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_PICKAXE
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_SHOVEL
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem.STARLIGHT_METHIL_SWORD
import net.minecraft.core.HolderLookup
import net.minecraft.data.DataGenerator
import net.minecraft.data.recipes.RecipeCategory
import net.minecraft.data.recipes.RecipeOutput
import net.minecraft.data.recipes.ShapedRecipeBuilder
import net.minecraft.data.recipes.ShapelessRecipeBuilder
import net.minecraft.world.item.Items.NETHER_STAR
import net.minecraft.world.item.Items.STICK
import net.minecraft.world.item.crafting.ShapelessRecipe
import java.util.concurrent.CompletableFuture

class MethilNormalCraftingTableRecipeProvider(
    generator: DataGenerator,
    pRegistries: CompletableFuture<HolderLookup.Provider>,
    private val recipeOutput: RecipeOutput
) : MethilRecipeProvider(generator, pRegistries) {
    fun build() {

        ShapelessRecipeBuilder.shapeless(RecipeCategory.BUILDING_BLOCKS, METHIL_ITEM.get(), 9)
            .requires(METHIL_BLOCK.get())
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_item_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, METHIL_BLOCK.get(), 1)
            .pattern("###")
            .pattern("###")
            .pattern("###")
            .define('#', MethilItem.METHIL_ITEM)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_block_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, METHIL_SHOVEL.get(), 1)
            .pattern(" # ")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', MethilItem.METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_shovel_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, METHIL_HOE.get(), 1)
            .pattern(" ##")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', MethilItem.METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_hoe_right_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, METHIL_HOE.get(), 1)
            .pattern("## ")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', MethilItem.METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_hoe_left_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, METHIL_DOUBLE_PICKAXE.get(), 1)
            .pattern("###")
            .pattern("###")
            .pattern(" S ")
            .define('#', MethilItem.METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_double_pickaxe_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, METHIL_PICKAXE.get(), 1)
            .pattern("###")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', MethilItem.METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_pickaxe_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, METHIL_AXE.get(), 1)
            .pattern(" ##")
            .pattern(" S#")
            .pattern(" S ")
            .define('#', MethilItem.METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_axe_right_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, METHIL_AXE.get(), 1)
            .pattern("## ")
            .pattern("#S ")
            .pattern(" S ")
            .define('#', MethilItem.METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_axe_left_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, METHIL_SWORD.get(), 1)
            .pattern(" # ")
            .pattern(" # ")
            .pattern(" S ")
            .define('#', MethilItem.METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_sword_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, METHIL_HELMET.get(), 1)
            .pattern("###")
            .pattern("# #")
            .define('#', MethilItem.METHIL_ITEM)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_helmet_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, METHIL_CHESTPLATE.get(), 1)
            .pattern("# #")
            .pattern("###")
            .pattern("###")
            .define('#', MethilItem.METHIL_ITEM)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_chestplate_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, METHIL_LEGGINGS.get(), 1)
            .pattern("###")
            .pattern("# #")
            .pattern("# #")
            .define('#', MethilItem.METHIL_ITEM)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_leggings_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, METHIL_BOOTS.get(), 1)
            .pattern("# #")
            .pattern("# #")
            .define('#', MethilItem.METHIL_ITEM)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("methil_boots_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, STARLIGHT_METHIL_ITEM.get(), 8)
            .pattern("###")
            .pattern("#S#")
            .pattern("###")
            .define('#', MethilItem.METHIL_ITEM)
            .define('S', NETHER_STAR)
            .unlockedBy("has_item", has(MethilItem.METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, STARLIGHT_METHIL_SHOVEL.get(), 1)
            .pattern(" # ")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', STARLIGHT_METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_shovel_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, STARLIGHT_METHIL_HOE.get(), 1)
            .pattern(" ##")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', STARLIGHT_METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_hoe_right_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, STARLIGHT_METHIL_HOE.get(), 1)
            .pattern("## ")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', STARLIGHT_METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_hoe_left_recipe"))


        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, STARLIGHT_METHIL_PICKAXE.get(), 1)
            .pattern("###")
            .pattern(" S ")
            .pattern(" S ")
            .define('#', STARLIGHT_METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_pickaxe_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, STARLIGHT_METHIL_AXE.get(), 1)
            .pattern(" ##")
            .pattern(" S#")
            .pattern(" S ")
            .define('#', STARLIGHT_METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_axe_right_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, STARLIGHT_METHIL_AXE.get(), 1)
            .pattern("## ")
            .pattern("#S ")
            .pattern(" S ")
            .define('#', STARLIGHT_METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_axe_left_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.TOOLS, STARLIGHT_METHIL_SWORD.get(), 1)
            .pattern(" # ")
            .pattern(" # ")
            .pattern(" S ")
            .define('#', STARLIGHT_METHIL_ITEM)
            .define('S', STICK)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_sword_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, STARLIGHT_METHIL_HELMET.get(), 1)
            .pattern("###")
            .pattern("# #")
            .define('#', STARLIGHT_METHIL_ITEM)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_helmet_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, STARLIGHT_METHIL_CHESTPLATE.get(), 1)
            .pattern("# #")
            .pattern("###")
            .pattern("###")
            .define('#', STARLIGHT_METHIL_ITEM)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_chestplate_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, STARLIGHT_METHIL_LEGGINGS.get(), 1)
            .pattern("###")
            .pattern("# #")
            .pattern("# #")
            .define('#', STARLIGHT_METHIL_ITEM)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_leggings_recipe"))

        ShapedRecipeBuilder.shaped(RecipeCategory.COMBAT, STARLIGHT_METHIL_BOOTS.get(), 1)
            .pattern("# #")
            .pattern("# #")
            .define('#', STARLIGHT_METHIL_ITEM)
            .unlockedBy("has_item", has(STARLIGHT_METHIL_ITEM))
            .save(this.recipeOutput, getModId("starlight_methil_boots_recipe"))
    }
}