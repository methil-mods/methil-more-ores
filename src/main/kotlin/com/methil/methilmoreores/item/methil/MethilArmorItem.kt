package com.methil.methilmoreores.item.methil

import net.minecraft.core.Holder
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Item

class MethilArmorItem(
    material: Holder<ArmorMaterial>,
    slot: ArmorItem.Type,
    properties: Item.Properties
) : ArmorItem(material, slot, properties)
