package com.methil.methilmoreores.data.worldgen.ore

import net.minecraft.world.level.levelgen.placement.*
import com.methil.methilmoreores.MethilMoreOres.Companion.LOGGER

object ModOrePlacement {
    private fun orePlacements(
        placementModifier: PlacementModifier,
        placementModifier1: PlacementModifier
    ): List<PlacementModifier> {
        return java.util.List.of(placementModifier, InSquarePlacement.spread(), placementModifier1, BiomeFilter.biome())
    }

    fun commonOrePlacements(count: Int, placementModifier: PlacementModifier): List<PlacementModifier> {
        return orePlacements(CountPlacement.of(count), placementModifier)
    }

    fun frequentOrePlacements(placementModifier: PlacementModifier): List<PlacementModifier> {
        // Instead of using CountPlacement.of(count), use RarityFilter.onAverageOnceEvery(1) to force constant placement
        return orePlacements(RarityFilter.onAverageOnceEvery(5), placementModifier)
    }

}