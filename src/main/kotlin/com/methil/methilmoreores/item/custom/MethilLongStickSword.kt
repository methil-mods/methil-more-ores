package com.methil.methilmoreores.item.custom

import com.methil.methilmoreores.MethilMoreOres
import com.methil.methilmoreores.MethilMoreOres.Companion.LOGGER
import com.methil.methilmoreores.item.MethilItem.METHIL_TIER
import net.minecraft.world.InteractionHand
import net.minecraft.world.InteractionResultHolder
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes.ENTITY_INTERACTION_RANGE
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.SwordItem
import net.minecraft.world.level.Level
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.neoforge.event.tick.PlayerTickEvent

class MethilLongStickSword  // Constructor for the custom sword
    (properties: Properties) :
    SwordItem(METHIL_TIER, properties) {

    companion object{
        @SubscribeEvent
        fun onPlayerTick(event: PlayerTickEvent.Post) {
            val player = event.entity ?: return
            val mainHandItem = player.mainHandItem
            val offHandItem = player.offhandItem

            if (mainHandItem.item is MethilLongStickSword) {
                extendReach(player)
            } else if (offHandItem.item is MethilLongStickSword) {
                removeReachExtension(player)
            } else {
                removeReachExtension(player)
            }
        }
        private fun extendReach(player: Player) {
            val reachDistance = 4.0
            player.attributes.getInstance(ENTITY_INTERACTION_RANGE)?.baseValue = reachDistance
        }
        private fun removeReachExtension(player: Player) {
            val reachDistance = 3.0
            player.attributes.getInstance(ENTITY_INTERACTION_RANGE)?.baseValue = reachDistance
        }
    }


}