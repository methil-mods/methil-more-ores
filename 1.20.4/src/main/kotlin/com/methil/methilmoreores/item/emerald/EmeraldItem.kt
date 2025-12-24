package com.methil.methilmoreores.item.emerald

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.emerald.EmeraldArmor.EMERALD_ARMOR_MATERIAL
import com.methil.methilmoreores.item.methil.MethilItem
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_ITEM
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_TIER
import net.minecraft.world.item.*
import net.minecraft.world.item.Items.EMERALD
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.common.SimpleTier
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object EmeraldItem {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(
        MODID
    )

    val EMERALD_TIER = object : Tier {
        override fun getUses(): Int = 750
        override fun getSpeed(): Float = 7f
        override fun getAttackDamageBonus(): Float = 2.5f
        override fun getLevel(): Int = 3
        override fun getEnchantmentValue(): Int = 32
        override fun getRepairIngredient(): Ingredient = Ingredient.of(EMERALD)
    }

    val EMERALD_SWORD = ITEMS.register("emerald_sword", Supplier { SwordItem(
        EMERALD_TIER, 2, -2.1f, Item.Properties().rarity(Rarity.RARE)) } )

    val EMERALD_AXE = ITEMS.register("emerald_axe", Supplier { AxeItem(
        EMERALD_TIER, 4.5f, -3.4f, Item.Properties().rarity(Rarity.RARE)) } )

    val EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", Supplier { PickaxeItem(
        EMERALD_TIER, 1, -2.1f, Item.Properties().rarity(Rarity.RARE)) } )

    val EMERALD_SHOVEL = ITEMS.register("emerald_shovel", Supplier { ShovelItem(
        EMERALD_TIER, 1.5f, -2.1f, Item.Properties().rarity(Rarity.RARE)) } )

    val EMERALD_HOE = ITEMS.register("emerald_hoe", Supplier { HoeItem(
        EMERALD_TIER, 1, -2.1f, Item.Properties().rarity(Rarity.RARE)) } )


    val EMERALD_HELMET: Supplier<ArmorItem> = ITEMS.register("emerald_helmet", Supplier {
        ArmorItem(
            EMERALD_ARMOR_MATERIAL,
            ArmorItem.Type.HELMET,
            Item.Properties().durability(195).rarity(Rarity.RARE)
        )
    })
    val EMERALD_CHESTPLATE: Supplier<ArmorItem> = ITEMS.register("emerald_chestplate", Supplier {
        ArmorItem(
            EMERALD_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            Item.Properties().durability(225).rarity(Rarity.RARE)
        )
    })
    val EMERALD_LEGGINGS: Supplier<ArmorItem> = ITEMS.register("emerald_leggings", Supplier {
        ArmorItem(
            EMERALD_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            Item.Properties().durability(240).rarity(Rarity.RARE)
        )
    })
    val EMERALD_BOOTS: Supplier<ArmorItem> = ITEMS.register("emerald_boots", Supplier {
        ArmorItem(
            EMERALD_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            Item.Properties().durability(165).rarity(Rarity.RARE)
        )
    })

    fun register(modEventBus: IEventBus){
        ITEMS.register(modEventBus)
    }
}