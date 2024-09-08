package io.github.realyusufismail.data

import io.github.realyusufismail.data.recipe.MainModRecipeProvider
import net.neoforged.neoforge.data.event.GatherDataEvent

object DataGenerators {
    fun gatherData(event: GatherDataEvent) {
        val generator = event.generator
        val output = generator.packOutput
        val existingFileHelper = event.existingFileHelper
        generator.addProvider(true, MainModRecipeProvider(generator, event.lookupProvider))
    }
}