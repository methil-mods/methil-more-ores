package com.methil.methilmoreores.effect

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.methil.MethilArmorItem
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes
import net.minecraft.world.entity.player.Player
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.event.tick.PlayerTickEvent

class MethilfyEffect : MobEffect(MobEffectCategory.BENEFICIAL, 0x00FFFF) {
    companion object {

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
        fun onPlayerTick(event: PlayerTickEvent.Post) {
            val player = event.entity ?: return

            if (isWearingFullMethilArmor(player)) {
                if (player.hasEffect(MethilEffect.METHILFY)) {
                    val effectInstance = player.getEffect(MethilEffect.METHILFY)
                    if (effectInstance != null && effectInstance.duration != -1) {
                        effectInstance.update(MobEffectInstance(MethilEffect.METHILFY, -1, 1, false, true, true))
                    }
                } else {
                    player.addEffect(
                        MobEffectInstance(MethilEffect.METHILFY, -1, 1, false, true, true)
                    )
                }
            } else {
                if (player.hasEffect(MethilEffect.METHILFY)) {
                    val effectInstance = player.getEffect(MethilEffect.METHILFY)
                    if (effectInstance != null && effectInstance.duration == -1) {
                        player.removeEffect(MethilEffect.METHILFY)
                    }
                }
            }
        }
    }

    init {
        this.addAttributeModifier(
            Attributes.MAX_HEALTH,
            ResourceLocation.fromNamespaceAndPath(MODID, "methilfy"),
            3.0,
            AttributeModifier.Operation.ADD_VALUE
        )
    }
}