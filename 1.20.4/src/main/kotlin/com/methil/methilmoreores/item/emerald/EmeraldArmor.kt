package com.methil.methilmoreores.item.emerald

import com.methil.methilmoreores.MethilMoreOres
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Items
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.bus.api.IEventBus

object EmeraldArmor{
    val EMERALD_ARMOR_MATERIAL: ArmorMaterial = object : ArmorMaterial {
        override fun getDurabilityForType(type: ArmorItem.Type): Int {
            return when (type) {
                ArmorItem.Type.BOOTS -> 13 * 20
                ArmorItem.Type.LEGGINGS -> 15 * 20
                ArmorItem.Type.CHESTPLATE -> 16 * 20
                ArmorItem.Type.HELMET -> 11 * 20
                else -> 13
            }
        }

        override fun getDefenseForType(type: ArmorItem.Type): Int {
             return when (type) {
                ArmorItem.Type.BOOTS -> 2
                ArmorItem.Type.LEGGINGS -> 3
                ArmorItem.Type.CHESTPLATE -> 6
                ArmorItem.Type.HELMET -> 3
                else -> 0
            }
        }

        override fun getEnchantmentValue(): Int = 20

        override fun getEquipSound(): SoundEvent = SoundEvents.ARMOR_EQUIP_GENERIC

        override fun getRepairIngredient(): Ingredient = Ingredient.of(Items.EMERALD)

        override fun getName(): String = MethilMoreOres.MODID + ":emerald"

        override fun getToughness(): Float = 0.5f

        override fun getKnockbackResistance(): Float = 1f
    }

    fun register(modEventBus: IEventBus){
    }
}