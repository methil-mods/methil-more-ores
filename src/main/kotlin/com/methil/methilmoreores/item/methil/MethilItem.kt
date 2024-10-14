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
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object MethilItem {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(
        MODID
    )

    val METHIL_ITEM: DeferredItem<Item> = ITEMS.registerSimpleItem(
        "methil", Item.Properties().rarity(Rarity.EPIC)
    )

    val METHIL_APPLE: DeferredItem<Item> = ITEMS.registerSimpleItem("methil_apple",
        Item.Properties().rarity(Rarity.EPIC).food(FoodProperties.Builder()
            .alwaysEdible().nutrition(8).effect(
                 Supplier { MobEffectInstance(MethilEffect.METHILFY, 600, 1) },
                1.0f
            ).effect(
                Supplier { MobEffectInstance(MobEffects.REGENERATION, 600, 1) },
                1.0f
            )
            .build()
        )
    )

    val STARLIGHT_METHIL_APPLE: DeferredItem<Item> = ITEMS.registerSimpleItem("starlight_methil_apple",
        Item.Properties().rarity(Rarity.EPIC).food(FoodProperties.Builder()
            .alwaysEdible().nutrition(8).effect(
                Supplier { MobEffectInstance(MethilEffect.STARLIGHT_METHILFY, 600, 1) },
                1.0f
            ).effect(
                Supplier { MobEffectInstance(MobEffects.REGENERATION, 600, 1) },
                1.0f
            )
            .build()
        )
    )

    val METHIL_TIER = SimpleTier(
        Tags.Blocks.ORES,
        1900,
        9f,
        5.5f,
        26,
        Supplier { Ingredient.of(METHIL_ITEM) }
    )

    val METHIL_SWORD = ITEMS.register("methil_sword", Supplier { SwordItem(
        METHIL_TIER, Item.Properties().rarity(Rarity.EPIC)
        .attributes(
            SwordItem.createAttributes(
                METHIL_TIER,
                4.5f,
                -2.1f
            )
        )) } )

    val METHIL_LONG_STICK_SWORD = ITEMS.register("methil_long_stick_sword", Supplier { MethilLongStickSword(Item.Properties().rarity(Rarity.EPIC)
        .attributes(
            SwordItem.createAttributes(
                METHIL_TIER,
                4.5f,
                -1f
            )
        )) } )

    val METHIL_PICKAXE = ITEMS.register("methil_pickaxe", Supplier { PickaxeItem(
        METHIL_TIER, Item.Properties()
        .rarity(Rarity.EPIC).attributes(PickaxeItem.createAttributes(METHIL_TIER, 1.3f, -2.8f))) } )

    val METHIL_DOUBLE_PICKAXE = ITEMS.register("methil_double_pickaxe", Supplier { MethilDoublePickaxe(Item.Properties()
        .rarity(Rarity.EPIC).attributes(PickaxeItem.createAttributes(METHIL_TIER, 2f, -2.8f))) } )

    val METHIL_AXE = ITEMS.register("methil_axe", Supplier { AxeItem(
        METHIL_TIER, Item.Properties()
        .rarity(Rarity.EPIC).attributes(AxeItem.createAttributes(METHIL_TIER, 1.3f, -2.8f))) } )

    val METHIL_HOE = ITEMS.register("methil_hoe", Supplier { HoeItem(
        METHIL_TIER, Item.Properties()
        .rarity(Rarity.EPIC).attributes(HoeItem.createAttributes(METHIL_TIER, 1.3f, -2.8f))) } )

    val METHIL_SHOVEL = ITEMS.register("methil_shovel", Supplier { ShovelItem(
        METHIL_TIER, Item.Properties()
        .rarity(Rarity.EPIC).attributes(ShovelItem.createAttributes(METHIL_TIER, 1.3f, -2.8f))) } )

    val METHIL_HELMET: Supplier<ArmorItem> = ITEMS.register("methil_helmet", Supplier {
        MethilArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.HELMET,
            Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15)).rarity(Rarity.EPIC)
        )
    })
    val METHIL_CHESTPLATE: Supplier<ArmorItem> = ITEMS.register("methil_chestplate", Supplier {
        MethilArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15)).rarity(Rarity.EPIC)
        )
    })
    val METHIL_LEGGINGS: Supplier<ArmorItem> = ITEMS.register("methil_leggings", Supplier {
        MethilArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15)).rarity(Rarity.EPIC)
        )
    })
    val METHIL_BOOTS: Supplier<ArmorItem> = ITEMS.register("methil_boots", Supplier {
        MethilArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15)).rarity(Rarity.EPIC)
        )
    })


    fun register(modEventBus: IEventBus){
        ITEMS.register(modEventBus)
    }
}