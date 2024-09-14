package com.methil.methilmoreores.effect

import com.methil.methilmoreores.item.methil.MethilArmorItem
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.player.Player
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.event.tick.PlayerTickEvent

/**
 * The idea between this class is after every player tick, check if the player have
 * a full set of Methil, if yes, it just applies the Absorption effect that gives 4 new hearts !
 */
object MethilArmorEffect {
    private fun isWearingFullMethilArmor(player: Player): Boolean {
        val helmet = player.getItemBySlot(EquipmentSlot.HEAD).item
        val chestplate = player.getItemBySlot(EquipmentSlot.CHEST).item
        val leggings = player.getItemBySlot(EquipmentSlot.LEGS).item
        val boots = player.getItemBySlot(EquipmentSlot.FEET).item

        return helmet is MethilArmorItem &&
                chestplate is MethilArmorItem &&
                leggings is MethilArmorItem &&
                boots is MethilArmorItem
    }

    @SubscribeEvent
    public fun onPlayerTick(event: PlayerTickEvent.Post) {
        val player = event.entity ?: return

        if (isWearingFullMethilArmor(player)) {
            if (!player.hasEffect(MobEffects.ABSORPTION)) {
                player.addEffect(
                    MobEffectInstance(MobEffects.ABSORPTION, 300, 1, false, false, true)
                )
            }
        }
    }
}