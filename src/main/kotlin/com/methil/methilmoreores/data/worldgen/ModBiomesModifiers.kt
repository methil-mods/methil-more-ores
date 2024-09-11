package com.methil.methilmoreores.data.worldgen

import com.methil.methilmoreores.MethilMoreOres
import com.methil.methilmoreores.block.MethilBlock.METHIL_ORE_BLOCK
import com.methil.methilmoreores.data.worldgen.ore.ModPlacedFeatures
import net.minecraft.core.HolderSet
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BiomeTags
import net.minecraft.world.level.levelgen.GenerationStep
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.common.world.BiomeModifiers.AddFeaturesBiomeModifier
import net.neoforged.neoforge.registries.NeoForgeRegistries
import com.methil.methilmoreores.MethilMoreOres.Companion.LOGGER

object ModBiomesModifiers {
    fun bootstrap(context: BootstrapContext<BiomeModifier>) {
        LOGGER.info("Generate bioome modifier")
        val placedFeatures = context.lookup(Registries.PLACED_FEATURE)
        val biomes = context.lookup(Registries.BIOME)

        context.register(
            createKey("methil_add_ore_underground_ores"),
            AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.METHIL_ORE)),
                GenerationStep.Decoration.UNDERGROUND_ORES)
        )

        context.register(
            createKey("methil_add_ore_lake"),
            AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.METHIL_ORE)),
                GenerationStep.Decoration.LAKES)
        )

        context.register(
            createKey("methil_add_ore_stronghold"),
            AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.METHIL_ORE)),
                GenerationStep.Decoration.STRONGHOLDS)
        )

        context.register(
            createKey("methil_add_ore_underground_struct"),
            AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OVERWORLD),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.METHIL_ORE)),
                GenerationStep.Decoration.UNDERGROUND_STRUCTURES)
        )

    }

    private fun createKey(name: String): ResourceKey<BiomeModifier> {
        return ResourceKey.create(
            NeoForgeRegistries.Keys.BIOME_MODIFIERS, ResourceLocation.fromNamespaceAndPath(
                MethilMoreOres.MODID, name
            )
        )
    }
}