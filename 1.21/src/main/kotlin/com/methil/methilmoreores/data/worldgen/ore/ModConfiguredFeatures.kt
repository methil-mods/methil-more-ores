package com.methil.methilmoreores.data.worldgen.ore

import com.methil.methilmoreores.MethilMoreOres
import com.methil.methilmoreores.block.MethilBlock.DEEPSLATE_METHIL_ORE_BLOCK
import com.methil.methilmoreores.block.MethilBlock.METHIL_ORE_BLOCK
import com.methil.methilmoreores.block.MethilBlock.NETHER_METHIL_ORE_BLOCK
import net.minecraft.core.registries.Registries
import net.minecraft.data.worldgen.BootstrapContext
import net.minecraft.resources.ResourceKey
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature
import net.minecraft.world.level.levelgen.feature.Feature
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration.TargetBlockState
import net.minecraft.world.level.levelgen.structure.templatesystem.AlwaysTrueTest
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest
import java.util.List

object ModConfiguredFeatures {
    internal var OVERWORLD_METHIL_ORE: ResourceKey<ConfiguredFeature<*, *>> = createKey("overworld_methil_ore")
    internal var OVERWORLD_DEEPSLATE_METHIL_ORE: ResourceKey<ConfiguredFeature<*, *>> = createKey("overworld_deepslate_methil_ore")
    internal var NETHER_METHIL_ORE: ResourceKey<ConfiguredFeature<*, *>> = createKey("nether_methil_ore")


    fun bootstrap(context: BootstrapContext<ConfiguredFeature<*, *>>) {
        val stoneReplacable: RuleTest = TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES)
        val deepslateReplacable: RuleTest = TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES)
        val netherReplacable: RuleTest = TagMatchTest(BlockTags.NETHER_CARVER_REPLACEABLES)

        val methilOre = List.of(OreConfiguration.target(stoneReplacable, METHIL_ORE_BLOCK.get().defaultBlockState()))
        val deepslateMethilOre = List.of(OreConfiguration.target(deepslateReplacable, DEEPSLATE_METHIL_ORE_BLOCK.get().defaultBlockState()))
        val netherMethilOre = List.of(OreConfiguration.target(netherReplacable, NETHER_METHIL_ORE_BLOCK.get().defaultBlockState()))

        register(context, OVERWORLD_METHIL_ORE, Feature.ORE, OreConfiguration(methilOre, 4))
        register(context, OVERWORLD_DEEPSLATE_METHIL_ORE, Feature.ORE, OreConfiguration(deepslateMethilOre, 4))
        register(context, NETHER_METHIL_ORE, Feature.ORE, OreConfiguration(netherMethilOre, 4))
    }

    private fun createKey(name: String): ResourceKey<ConfiguredFeature<*, *>> {
        return ResourceKey.create(
            Registries.CONFIGURED_FEATURE,
            ResourceLocation.fromNamespaceAndPath(MethilMoreOres.MODID, name)
        )
    }

    private fun <FC : FeatureConfiguration?, F : Feature<FC>?> register(
        context: BootstrapContext<ConfiguredFeature<*, *>>,
        key: ResourceKey<ConfiguredFeature<*, *>>,
        feature: F,
        config: FC
    ) {
        context.register(key, ConfiguredFeature(feature, config))
    }
}