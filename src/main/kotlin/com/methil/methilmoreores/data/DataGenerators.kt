package com.methil.methilmoreores.data

import com.methil.methilmoreores.MethilMoreOres.Companion.LOGGER
import com.methil.methilmoreores.data.loottable.ModLootTables
import com.methil.methilmoreores.data.recipes.MethilRecipeProvider
import com.methil.methilmoreores.data.recipes.provider.EmeraldNormalCraftingTableRecipeProvider
import com.methil.methilmoreores.data.tag.ModBlockTagsProvider
import com.methil.methilmoreores.data.worldgen.ModWorldGenProvider
import net.neoforged.neoforge.data.event.GatherDataEvent


object DataGenerators {
    fun gatherData(event: GatherDataEvent) {
        try {
            LOGGER.info("Launch gathering data")
            val generator = event.generator
            val output = generator.packOutput
            val existingFileHelper = event.existingFileHelper

            val modBlockTagsProvider = ModBlockTagsProvider(output, event.lookupProvider, existingFileHelper)
            generator.addProvider(true, modBlockTagsProvider);
            generator.addProvider(true, MethilRecipeProvider(generator, event.lookupProvider))
            generator.addProvider(true, ModLootTables(output, event.lookupProvider))
            generator.addProvider(true, ModWorldGenProvider(output, event.lookupProvider))
        } catch (e: RuntimeException) {
            LOGGER.error("Failed to gather data", e)
        }
    }
}