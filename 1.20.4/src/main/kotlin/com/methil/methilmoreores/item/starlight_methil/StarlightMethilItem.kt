package com.methil.methilmoreores.item.starlight_methil

import com.methil.methilmoreores.item.methil.MethilArmorItem
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilArmor.STARLIGHT_METHIL_ARMOR_MATERIAL
import com.methil.methilmoreores.item.methil.custom.MethilDoublePickaxe
import com.methil.methilmoreores.item.methil.custom.MethilLongStickSword
import net.minecraft.world.item.*
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.common.SimpleTier
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object StarlightMethilItem {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(
        MODID
    )

    val STARLIGHT_METHIL_ITEM = ITEMS.register("starlight_methil", Supplier {
        Item(Item.Properties().rarity(Rarity.EPIC))
    })

    val STARLIGHT_METHIL_TIER = object : Tier {
        override fun getUses(): Int = 1900
        override fun getSpeed(): Float = 11f
        override fun getAttackDamageBonus(): Float = 8.5f
        override fun getLevel(): Int = 4
        override fun getEnchantmentValue(): Int = 26
        override fun getRepairIngredient(): Ingredient = Ingredient.of(STARLIGHT_METHIL_ITEM.get())
    }

    val STARLIGHT_METHIL_SWORD = ITEMS.register("starlight_methil_sword", Supplier { SwordItem(
        STARLIGHT_METHIL_TIER, 4, -2.1f, Item.Properties().rarity(Rarity.EPIC)
    ) } )

    val STARLIGHT_METHIL_PICKAXE = ITEMS.register("starlight_methil_pickaxe", Supplier { PickaxeItem(
        STARLIGHT_METHIL_TIER, 1, -2.8f, Item.Properties().rarity(Rarity.EPIC)) } )

    val STARLIGHT_METHIL_AXE = ITEMS.register("starlight_methil_axe", Supplier { AxeItem(
        STARLIGHT_METHIL_TIER, 6.0f, -2.8f, Item.Properties().rarity(Rarity.EPIC)) } )

    val STARLIGHT_METHIL_HOE = ITEMS.register("starlight_methil_hoe", Supplier { HoeItem(
        STARLIGHT_METHIL_TIER, 0, -2.8f, Item.Properties().rarity(Rarity.EPIC)) } )

    val STARLIGHT_METHIL_SHOVEL = ITEMS.register("starlight_methil_shovel", Supplier { ShovelItem(
        STARLIGHT_METHIL_TIER, 1.5f, -2.8f, Item.Properties().rarity(Rarity.EPIC)) } )

    val STARLIGHT_METHIL_HELMET: Supplier<ArmorItem> = ITEMS.register("starlight_methil_helmet", Supplier {
        StarlightMethilArmorItem(
            STARLIGHT_METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.HELMET,
            Item.Properties().durability(195).rarity(Rarity.EPIC)
        )
    })
    val STARLIGHT_METHIL_CHESTPLATE: Supplier<ArmorItem> = ITEMS.register("starlight_methil_chestplate", Supplier {
        StarlightMethilArmorItem(
            STARLIGHT_METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            Item.Properties().durability(225).rarity(Rarity.EPIC)
        )
    })
    val STARLIGHT_METHIL_LEGGINGS: Supplier<ArmorItem> = ITEMS.register("starlight_methil_leggings", Supplier {
        StarlightMethilArmorItem(
            STARLIGHT_METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            Item.Properties().durability(240).rarity(Rarity.EPIC)
        )
    })
    val STARLIGHT_METHIL_BOOTS: Supplier<ArmorItem> = ITEMS.register("starlight_methil_boots", Supplier {
        StarlightMethilArmorItem(
            STARLIGHT_METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            Item.Properties().durability(165).rarity(Rarity.EPIC)
        )
    })


    fun register(modEventBus: IEventBus){
        ITEMS.register(modEventBus)
    }
}