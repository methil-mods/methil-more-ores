package com.methil.methilmoreores.block

import com.google.common.base.Supplier
import com.methil.methilmoreores.MethilMoreOres
import com.methil.methilmoreores.MethilMoreOres.Companion
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.MethilItem.ITEMS
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister

object MethilBlock {

    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(
        MODID
    )
    public val METHIL_ORE_BLOCK: DeferredBlock<Block> =
        BLOCKS.registerSimpleBlock("methil_ore", BlockBehaviour.Properties.of().mapColor(MapColor.STONE)
            .strength(4f).requiresCorrectToolForDrops()
            .destroyTime(3.0F)
            .explosionResistance(10.0F)
            .sound(SoundType.METAL))

    fun register(modEventBus: IEventBus){
        BLOCKS.register(modEventBus)
    }
}