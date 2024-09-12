package com.methil.methilmoreores.data.loottable

import com.methil.methilmoreores.MethilMoreOres.Companion.LOGGER
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.block.MethilBlock
import com.methil.methilmoreores.item.MethilItem
import net.minecraft.core.HolderLookup
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.data.loot.BlockLootSubProvider
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.flag.FeatureFlags
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block
import java.util.*
import java.util.stream.Collectors

class ModBlockLootTables(p_344943_: HolderLookup.Provider) : BlockLootSubProvider(setOf(), FeatureFlags.REGISTRY.allFlags(), p_344943_) {
    override fun generate() {
        LOGGER.info("Generate MODBLOCKLOOTTABLES")
        add(MethilBlock.METHIL_ORE_BLOCK.get(), createOreDrop(MethilBlock.METHIL_ORE_BLOCK.get(), MethilItem.METHIL_ITEM.get()))
    }

    override fun getKnownBlocks(): Iterable<Block> {
        return BuiltInRegistries.BLOCK.stream()
            .filter { block: Block ->
                Optional.of<ResourceLocation>(BuiltInRegistries.BLOCK.getKey(block))
                    .filter { key: ResourceLocation -> key.namespace == MODID }
                    .isPresent
            }
            .collect(Collectors.toSet<Block>())
    }
}