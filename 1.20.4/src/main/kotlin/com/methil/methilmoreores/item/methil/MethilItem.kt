package com.methil.methilmoreores.item.methil

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.effect.MethilEffect
import com.methil.methilmoreores.item.methil.MethilArmor.METHIL_ARMOR_MATERIAL
import com.methil.methilmoreores.item.methil.custom.MethilDoublePickaxe
import com.methil.methilmoreores.item.methil.custom.MethilLongStickSword
import net.minecraft.world.effect.MobEffectInstance
import net.minecraft.world.effect.MobEffects
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.*
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.common.SimpleTier
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object MethilItem {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(
        MODID
    )

    val METHIL_ITEM = ITEMS.register("methil", Supplier {
        Item(Item.Properties().rarity(Rarity.EPIC))
    })

    val METHIL_APPLE = ITEMS.register("methil_apple", Supplier {
        Item(Item.Properties().rarity(Rarity.EPIC).food(FoodProperties.Builder()
            .alwaysEat().nutrition(8).effect(
                 Supplier { MobEffectInstance(MethilEffect.METHILFY.get(), 600, 1) },
                1.0f
            ).effect(
                Supplier { MobEffectInstance(MobEffects.REGENERATION, 100, 1) },
                1.0f
            )
            .build()
        ))
    })

    val STARLIGHT_METHIL_APPLE = ITEMS.register("starlight_methil_apple", Supplier {
        Item(Item.Properties().rarity(Rarity.EPIC).food(FoodProperties.Builder()
            .alwaysEat().nutrition(8).effect(
                Supplier { MobEffectInstance(MethilEffect.STARLIGHT_METHILFY.get(), 600, 1) },
                1.0f
            ).effect(
                Supplier { MobEffectInstance(MobEffects.REGENERATION, 300, 2) },
                1.0f
            )
            .build()
        ))
    })

    val METHIL_TIER = object : Tier {
        override fun getUses(): Int = 1900
        override fun getSpeed(): Float = 9f
        override fun getAttackDamageBonus(): Float = 5.5f
        override fun getLevel(): Int = 4
        override fun getEnchantmentValue(): Int = 26
        override fun getRepairIngredient(): Ingredient = Ingredient.of(METHIL_ITEM.get())
    }

    val METHIL_SWORD = ITEMS.register("methil_sword", Supplier { SwordItem(
        METHIL_TIER, 4, -2.1f, Item.Properties().rarity(Rarity.EPIC)
    ) } )

    val METHIL_LONG_STICK_SWORD = ITEMS.register("methil_long_stick_sword", Supplier { MethilLongStickSword(Item.Properties().rarity(Rarity.EPIC)) } )

    val METHIL_PICKAXE = ITEMS.register("methil_pickaxe", Supplier { PickaxeItem(
        METHIL_TIER, 1, -2.8f, Item.Properties().rarity(Rarity.EPIC)) } )

    val METHIL_DOUBLE_PICKAXE = ITEMS.register("methil_double_pickaxe", Supplier { MethilDoublePickaxe(Item.Properties().rarity(Rarity.EPIC)) } )

    val METHIL_AXE = ITEMS.register("methil_axe", Supplier { AxeItem(
        METHIL_TIER, 6.0f, -2.8f, Item.Properties().rarity(Rarity.EPIC)) } )

    val METHIL_HOE = ITEMS.register("methil_hoe", Supplier { HoeItem(
        METHIL_TIER, 0, -2.8f, Item.Properties().rarity(Rarity.EPIC)) } )

    val METHIL_SHOVEL = ITEMS.register("methil_shovel", Supplier { ShovelItem(
        METHIL_TIER, 1.5f, -2.8f, Item.Properties().rarity(Rarity.EPIC)) } )

    val METHIL_HELMET: Supplier<ArmorItem> = ITEMS.register("methil_helmet", Supplier {
        MethilArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.HELMET,
            Item.Properties().durability(195).rarity(Rarity.EPIC)
        )
    })
    val METHIL_CHESTPLATE: Supplier<ArmorItem> = ITEMS.register("methil_chestplate", Supplier {
        MethilArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            Item.Properties().durability(225).rarity(Rarity.EPIC)
        )
    })
    val METHIL_LEGGINGS: Supplier<ArmorItem> = ITEMS.register("methil_leggings", Supplier {
        MethilArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            Item.Properties().durability(240).rarity(Rarity.EPIC)
        )
    })
    val METHIL_BOOTS: Supplier<ArmorItem> = ITEMS.register("methil_boots", Supplier {
        MethilArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            Item.Properties().durability(165).rarity(Rarity.EPIC)
        )
    })


    fun register(modEventBus: IEventBus){
        ITEMS.register(modEventBus)
    }
}