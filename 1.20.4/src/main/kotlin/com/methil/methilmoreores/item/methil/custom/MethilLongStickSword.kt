package com.methil.methilmoreores.item.methil.custom

import com.methil.methilmoreores.item.methil.MethilItem.METHIL_TIER
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.SwordItem
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.common.NeoForgeMod
import net.neoforged.neoforge.event.TickEvent

class MethilLongStickSword  // Constructor for the custom sword
    (properties: Properties) :
    SwordItem(METHIL_TIER, 4, -1f, properties) {

    companion object{
        @SubscribeEvent
        fun onPlayerTick(event: TickEvent.PlayerTickEvent) {
            if (event.phase != TickEvent.Phase.END) return
            val player = event.player
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
            player.attributes.getInstance(NeoForgeMod.ENTITY_REACH.value())?.baseValue = reachDistance
        }
        private fun removeReachExtension(player: Player) {
            val reachDistance = 3.0
            player.attributes.getInstance(NeoForgeMod.ENTITY_REACH.value())?.baseValue = reachDistance
        }
    }


}