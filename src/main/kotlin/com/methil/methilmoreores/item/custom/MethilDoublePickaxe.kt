package com.methil.methilmoreores.item.custom

import com.methil.methilmoreores.item.MethilItem.METHIL_TIER
import net.minecraft.core.BlockPos
import net.minecraft.core.Direction
import net.minecraft.core.component.DataComponents
import net.minecraft.server.level.ServerLevel
import net.minecraft.world.entity.LivingEntity
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.PickaxeItem
import net.minecraft.world.item.component.Tool
import net.minecraft.world.level.Level
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.entity.BlockEntity
import net.minecraft.world.level.block.state.BlockState
import net.minecraft.world.level.gameevent.GameEvent
import net.minecraft.world.phys.Vec3


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
        var currentPos = pos

        for (x in -1..1) {
            currentPos = currentPos.relative(direction)
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
