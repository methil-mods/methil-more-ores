package com.methil.methilmoreores.block

import com.google.common.base.Supplier
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.MethilItem.ITEMS
import net.minecraft.world.item.BlockItem
import net.minecraft.world.item.Item
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
    val METHIL_ORE_BLOCK: DeferredBlock<Block> =
        registerBlock("methil_ore", Supplier {
            Block(BlockBehaviour.Properties.of()
                .destroyTime(3.0F)
                .explosionResistance(10.0F)
                .sound(SoundType.METAL)
                .requiresCorrectToolForDrops()
            )
        } )

    fun register(modEventBus: IEventBus){
        BLOCKS.register(modEventBus)
    }

    fun registerBlock(name: String, block: Supplier<Block>): DeferredBlock<Block> {
        val blockReg = BLOCKS.register(name, block)
        ITEMS.registerSimpleBlockItem(blockReg)
        return blockReg
    }
}