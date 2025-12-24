package com.methil.methilmoreores.item.emerald

import com.methil.methilmoreores.MethilMoreOres
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.methil.MethilArmor.METHIL_ARMOR_MATERIAL
import com.methil.methilmoreores.item.methil.MethilArmorItem
import com.methil.methilmoreores.item.methil.MethilItem.ITEMS
import net.minecraft.Util
import net.minecraft.core.registries.Registries
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.Item
import net.minecraft.world.item.Items.EMERALD
import net.minecraft.world.item.Rarity
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.*
import java.util.function.Supplier


object EmeraldArmor{
    val ARMOR_MATERIALS : DeferredRegister<ArmorMaterial> = DeferredRegister.create(Registries.ARMOR_MATERIAL, MODID);

    val EMERALD_ARMOR_MATERIAL = ARMOR_MATERIALS.register("emerald_armor", Supplier {
        ArmorMaterial( // Determines the defense value of this armor material, depending on what armor piece it is.
            Util.make(Supplier {
                EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
                    put(ArmorItem.Type.BOOTS, 2)
                    put(ArmorItem.Type.LEGGINGS, 3)
                    put(ArmorItem.Type.CHESTPLATE, 6)
                    put(ArmorItem.Type.HELMET, 3)
                    put(ArmorItem.Type.BODY, 4)
                }
            }),
            20,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            { Ingredient.of(EMERALD) },

            listOf(
                ArmorMaterial.Layer(
                    MethilMoreOres.location("emerald"),
                ),
            ),
            0.5f,
            1f
        )
    });



    fun register(modEventBus: IEventBus){
        ARMOR_MATERIALS.register(modEventBus)
    }
}