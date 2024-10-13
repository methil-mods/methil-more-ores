package com.methil.methilmoreores.effect

import com.methil.methilmoreores.item.methil.MethilArmorItem
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilArmorItem
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.player.Player
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.event.tick.PlayerTickEvent

object StarlightMethilArmorEffect {
    private fun isWearingFullStarlightMethilArmor(player: Player): Boolean {
        val helmet = player.getItemBySlot(EquipmentSlot.HEAD).item
        val chestplate = player.getItemBySlot(EquipmentSlot.CHEST).item
        val leggings = player.getItemBySlot(EquipmentSlot.LEGS).item
        val boots = player.getItemBySlot(EquipmentSlot.FEET).item

        return helmet is StarlightMethilArmorItem &&
                chestplate is StarlightMethilArmorItem &&
                leggings is StarlightMethilArmorItem &&
                boots is StarlightMethilArmorItem
    }

    @SubscribeEvent
    public fun onPlayerTick(event: PlayerTickEvent.Post) {
        val player = event.entity ?: return

        if (isWearingFullStarlightMethilArmor(player)) {
            if (!player.hasEffect(MethilEffect.STARLIGHT_METHILFY)) {
                player.addEffect(
                    MobEffectInstance(MethilEffect.STARLIGHT_METHILFY, -1, 1, false, false, false)
                )
            }
        } else {
            if (player.hasEffect(MethilEffect.STARLIGHT_METHILFY)) {
                player.removeEffect(MethilEffect.STARLIGHT_METHILFY)
            }

        }
    }
}