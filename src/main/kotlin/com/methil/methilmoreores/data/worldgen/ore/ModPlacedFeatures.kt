package com.methil.methilmoreores.data.worldgen.ore

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import net.minecraft.core.Holder
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.level.levelgen.VerticalAnchor
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.placement.HeightRangePlacement
import net.minecraft.world.level.levelgen.placement.PlacedFeature
import net.minecraft.world.level.levelgen.placement.PlacementModifier

object ModPlacedFeatures {
    var METHIL_ORE: ResourceKey<PlacedFeature> = createKey("methil_ore")
    var DEEPSLATE_METHIL_ORE: ResourceKey<PlacedFeature> = createKey("deepslate_methil_ore")
    var NETHER_METHIL_ORE: ResourceKey<PlacedFeature> = createKey("nether_methil_ore")

    fun bootstrap(context: BootstrapContext<PlacedFeature>) {
        val configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE)

        val holderOverworldMethilOre: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_METHIL_ORE)
        val holderOverworldDeepslateMethilOre: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.OVERWORLD_DEEPSLATE_METHIL_ORE)
        val holderNetherMethilOre: Holder<ConfiguredFeature<*, *>> =
            configuredFeatures.getOrThrow(ModConfiguredFeatures.NETHER_METHIL_ORE)


        register(context, METHIL_ORE, holderOverworldMethilOre,
            ModOrePlacement.frequentOrePlacements(
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(30))
            )
        )
        register(context, DEEPSLATE_METHIL_ORE, holderOverworldDeepslateMethilOre,
            ModOrePlacement.frequentOrePlacements(
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(200))
            )
        )
        register(context, NETHER_METHIL_ORE, holderNetherMethilOre,
            ModOrePlacement.frequentOrePlacements(
                HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(200))
            )
        )
    }


    private fun createKey(name: String): ResourceKey<PlacedFeature> {
        return ResourceKey.create<PlacedFeature>(
            Registries.PLACED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MODID, name)
        )
    }

    private fun register(
        context: BootstrapContext<PlacedFeature>,
        key: ResourceKey<PlacedFeature>,
        feature: Holder<ConfiguredFeature<*, *>>,
        placementModifiers: List<PlacementModifier>
    ) {
        context.register(key, PlacedFeature(feature, placementModifiers))
    }
}