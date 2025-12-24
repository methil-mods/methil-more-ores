package com.methil.methilmoreores.data.worldgen

import com.methil.methilmoreores.MethilMoreOres
import com.methil.methilmoreores.data.worldgen.ore.ModConfiguredFeatures
import com.methil.methilmoreores.data.worldgen.ore.ModPlacedFeatures
import net.minecraft.core.HolderLookup
import net.minecraft.core.RegistrySetBuilder
import net.minecraft.core.registries.Registries
import net.minecraft.data.PackOutput
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.neoforged.neoforge.common.data.DatapackBuiltinEntriesProvider
import net.neoforged.neoforge.common.world.BiomeModifier
import net.neoforged.neoforge.registries.NeoForgeRegistries
import java.util.Set
import java.util.concurrent.CompletableFuture

class ModWorldGenProvider(output: PackOutput, registries: CompletableFuture<HolderLookup.Provider?>) :
    DatapackBuiltinEntriesProvider(
        output, registries, RegistrySetBuilder()
            .add<ConfiguredFeature<*, *>>(Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
            .add<PlacedFeature>(Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
            .add(NeoForgeRegistries.Keys.BIOME_MODIFIERS, ModBiomesModifiers::bootstrap),
        Set.of<String>(MethilMoreOres.MODID)
    )