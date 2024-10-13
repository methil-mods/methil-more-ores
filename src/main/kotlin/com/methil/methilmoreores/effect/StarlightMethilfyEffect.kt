package com.methil.methilmoreores.effect

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilArmorItem
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

class StarlightMethilfyEffect : MobEffect(MobEffectCategory.BENEFICIAL, 0x00FFFF) {
    companion object {

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
        fun onPlayerTick(event: PlayerTickEvent.Post) {
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

    init {
        this.addAttributeModifier(
            Attributes.MAX_HEALTH,
            ResourceLocation.fromNamespaceAndPath(MODID, "starlight_methilfy"),
            6.0,
            AttributeModifier.Operation.ADD_VALUE
        )
    }
}