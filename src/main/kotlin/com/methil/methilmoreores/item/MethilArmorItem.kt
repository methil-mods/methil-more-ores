package com.methil.methilmoreores.item

import com.methil.methilmoreores.MethilMoreOres
import net.minecraft.core.Holder
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.entity.EquipmentSlot
import net.minecraft.world.entity.player.Player
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Item
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.neoforge.common.NeoForge
import net.neoforged.neoforge.common.NeoForge.EVENT_BUS
import net.neoforged.neoforge.event.tick.PlayerTickEvent

class MethilArmorItem(
    material: Holder<ArmorMaterial>,
    slot: ArmorItem.Type,
    properties: Item.Properties
) : ArmorItem(material, slot, properties)
