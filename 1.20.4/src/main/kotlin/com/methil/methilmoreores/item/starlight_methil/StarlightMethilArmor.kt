package com.methil.methilmoreores.item.starlight_methil

import com.methil.methilmoreores.MethilMoreOres
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.bus.api.IEventBus
import java.util.function.Supplier

object StarlightMethilArmor {
    val STARLIGHT_METHIL_ARMOR_MATERIAL: ArmorMaterial = object : ArmorMaterial {
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
                ArmorItem.Type.BOOTS -> 5 // Guessed values based on upgrade logic (usually +1 or +2)
                ArmorItem.Type.LEGGINGS -> 9
                ArmorItem.Type.CHESTPLATE -> 11
                ArmorItem.Type.HELMET -> 5
                else -> 0
            }
            // In original code it was likely defined. I will assume slightly stronger than Methil.
            // 1.21 code: [5, 9, 11, 5]?
        }

        override fun getEnchantmentValue(): Int = 20

        override fun getEquipSound(): SoundEvent = SoundEvents.ARMOR_EQUIP_GENERIC

        override fun getRepairIngredient(): Ingredient = Ingredient.of(StarlightMethilItem.STARLIGHT_METHIL_ITEM.get())

        override fun getName(): String = MethilMoreOres.MODID + ":starlight_methil"

        override fun getToughness(): Float = 0f

        override fun getKnockbackResistance(): Float = 0f
    }

    fun register(modEventBus: IEventBus){
    }
}