package com.methil.methilmoreores.block

import com.google.common.base.Supplier
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.methil.MethilItem.ITEMS
import net.minecraft.util.valueproviders.UniformInt
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.DropExperienceBlock
import net.minecraft.world.level.block.SoundType
import net.minecraft.world.level.block.state.BlockBehaviour
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredRegister


object MethilBlock {

    val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(
        MODID
    )
    val METHIL_ORE_BLOCK: DeferredBlock<Block> =
        registerBlock("methil_ore", {
            DropExperienceBlock(UniformInt.of(2,4), BlockBehaviour.Properties.of()
                .destroyTime(3.0f)
                .explosionResistance(10.0F)
                .sound(SoundType.METAL)
                .lightLevel { 5 }
                .requiresCorrectToolForDrops()
                .strength(3.0f, 10.0f)
            )
        } )
    val DEEPSLATE_METHIL_ORE_BLOCK: DeferredBlock<Block> =
        registerBlock("deepslate_methil_ore", {
            DropExperienceBlock(UniformInt.of(5,10), BlockBehaviour.Properties.of()
                .destroyTime(5.0f)
                .explosionResistance(10.0F)
                .sound(SoundType.METAL)
                .lightLevel { 5 }
                .requiresCorrectToolForDrops()
                .strength(5.0f, 10.0f)
            )
        } )
    val NETHER_METHIL_ORE_BLOCK: DeferredBlock<Block> =
        registerBlock("nether_methil_ore", {
            DropExperienceBlock(UniformInt.of(8,14), BlockBehaviour.Properties.of()
                .destroyTime(3.0f)
                .explosionResistance(10.0F)
                .sound(SoundType.METAL)
                .lightLevel { 5 }
                .requiresCorrectToolForDrops()
                .strength(3.0f, 10.0f)
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