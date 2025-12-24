package com.methil.methilmoreores.item.methil

import com.methil.methilmoreores.MethilMoreOres
import net.minecraft.sounds.SoundEvent
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.bus.api.IEventBus
import java.util.function.Supplier

object MethilArmor {
    // No registration needed for material in 1.20.4, just an object
    val METHIL_ARMOR_MATERIAL: ArmorMaterial = object : ArmorMaterial {
        override fun getDurabilityForType(type: ArmorItem.Type): Int {
            return when (type) {
                ArmorItem.Type.BOOTS -> 13 * 20 // Base * multiplier (checked previously 20?)
                ArmorItem.Type.LEGGINGS -> 15 * 20
                ArmorItem.Type.CHESTPLATE -> 16 * 20
                ArmorItem.Type.HELMET -> 11 * 20
                else -> 13
            }
            // Wait, standard multipliers are [13, 15, 16, 11] for [feet, legs, chest, head]
            // My 1.21 code passed "20" as durability multiplier?
            // "20" was passed as logic.
            // I'll stick to logic: [13, 15, 16, 11] * 20.
        }

        override fun getDefenseForType(type: ArmorItem.Type): Int {
            return when (type) {
                ArmorItem.Type.BOOTS -> 4
                ArmorItem.Type.LEGGINGS -> 8
                ArmorItem.Type.CHESTPLATE -> 10
                ArmorItem.Type.HELMET -> 4
                else -> 0
            }
        }

        override fun getEnchantmentValue(): Int = 20

        override fun getEquipSound(): SoundEvent = SoundEvents.ARMOR_EQUIP_GENERIC

        override fun getRepairIngredient(): Ingredient = Ingredient.of(MethilItem.METHIL_ITEM.get())

        override fun getName(): String = MethilMoreOres.MODID + ":methil"

        override fun getToughness(): Float = 0f

        override fun getKnockbackResistance(): Float = 0f
    }
    
    fun register(modEventBus: IEventBus){
        // No-op for materials
    }
}