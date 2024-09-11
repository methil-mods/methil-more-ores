package com.methil.methilmoreores.data.worldgen.ore

import net.minecraft.world.level.levelgen.placement.*

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

    fun rareOrePlacements(count: Int, placementModifier: PlacementModifier): List<PlacementModifier> {
        return orePlacements(RarityFilter.onAverageOnceEvery(count), placementModifier)
    }
}