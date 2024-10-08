package com.methil.methilmoreores.item.methil.custom

import com.methil.methilmoreores.item.methil.MethilItem.METHIL_TIER
import net.minecraft.core.BlockPos
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.gameevent.GameEvent


class MethilDoublePickaxe(properties: Properties) : PickaxeItem(METHIL_TIER, properties) {
    override fun mineBlock(
        stack: ItemStack,
        level: Level,
        state: BlockState,
        pos: BlockPos,
        miningEntity: LivingEntity
    ): Boolean {
        val result = super.mineBlock(stack, level, state, pos, miningEntity)
        if (level is ServerLevel) {
            breakOtherBlock(stack, level, pos, miningEntity)
        }


        return result
    }

    private fun breakOtherBlock(stack: ItemStack, level: Level, pos: BlockPos, miningEntity: LivingEntity) {
        val direction = miningEntity.nearestViewDirection
        // TODO : Update this code, it's a bit shitty
        // First part, destroy the block behind
        var currentPos : BlockPos = pos
        currentPos = BlockPos(currentPos.x, currentPos.y-1, currentPos.z)
        val state = level.getBlockState(currentPos)
        if (state.block !== Blocks.AIR) {
            val blockEntity: BlockEntity? = level.getBlockEntity(currentPos)
            val block: Block = state.block
            block.playerDestroy(level, miningEntity as Player, pos, state, blockEntity, stack)
            level.removeBlock(currentPos, false)
            level.gameEvent(GameEvent.BLOCK_DESTROY, currentPos, GameEvent.Context.of(state))
        }
        // Second part, destroy the 2 blocks behind
        for (i in 0..1){
            var currentPos : BlockPos = pos
            currentPos = currentPos.relative(direction)
            currentPos = BlockPos(currentPos.x, currentPos.y-i, currentPos.z)
            val state = level.getBlockState(currentPos)
            if (state.block !== Blocks.AIR) {
                val blockEntity: BlockEntity? = level.getBlockEntity(currentPos)
                val block: Block = state.block
                block.playerDestroy(level, miningEntity as Player, pos, state, blockEntity, stack)
                level.removeBlock(currentPos, false)
                level.gameEvent(GameEvent.BLOCK_DESTROY, currentPos, GameEvent.Context.of(state))
            }
        }


    }
}
