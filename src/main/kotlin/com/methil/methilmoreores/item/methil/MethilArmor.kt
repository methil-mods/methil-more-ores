package com.methil.methilmoreores.item.methil

import com.methil.methilmoreores.MethilMoreOres
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import net.minecraft.Util
import net.minecraft.core.registries.Registries
import net.minecraft.sounds.SoundEvents
import net.minecraft.world.item.ArmorItem
import net.minecraft.world.item.ArmorMaterial
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.*
import java.util.function.Supplier


object MethilArmor{
    val ARMOR_MATERIALS : DeferredRegister<ArmorMaterial> = DeferredRegister.create(Registries.ARMOR_MATERIAL, MODID);

    val METHIL_ARMOR_MATERIAL = ARMOR_MATERIALS.register("methil_armor", Supplier {
        ArmorMaterial( // Determines the defense value of this armor material, depending on what armor piece it is.
            Util.make(Supplier {
                EnumMap<ArmorItem.Type, Int>(ArmorItem.Type::class.java).apply {
                    put(ArmorItem.Type.BOOTS, 4)
                    put(ArmorItem.Type.LEGGINGS, 8)
                    put(ArmorItem.Type.CHESTPLATE, 10)
                    put(ArmorItem.Type.HELMET, 4)
                    put(ArmorItem.Type.BODY, 8)
                }
            }),
            20,
            SoundEvents.ARMOR_EQUIP_GENERIC,
            { Ingredient.of(MethilItem.METHIL_ITEM) },

            listOf(
                ArmorMaterial.Layer(
                    MethilMoreOres.location("methil")
                ),
            ),
            0f,
            0f
        )
    });


    fun register(modEventBus: IEventBus){
        ARMOR_MATERIALS.register(modEventBus)
    }
}