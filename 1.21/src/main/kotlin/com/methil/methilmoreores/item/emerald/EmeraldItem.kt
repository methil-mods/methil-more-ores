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

    val EMERALD_TIER = SimpleTier(
        Tags.Blocks.ORES,
        750,
        7f,
        2.5f,
        32,
        Supplier { Ingredient.of(EMERALD) }
    )

    val EMERALD_SWORD = ITEMS.register("emerald_sword", Supplier { SwordItem(
        EMERALD_TIER, Item.Properties().rarity(Rarity.RARE)
            .attributes(SwordItem.createAttributes(EMERALD_TIER, 2.5f, -2.1f))) } )

    val EMERALD_AXE = ITEMS.register("emerald_axe", Supplier { AxeItem(
        EMERALD_TIER, Item.Properties().rarity(Rarity.RARE)
            .attributes(AxeItem.createAttributes(EMERALD_TIER, 4.5f, -3.4f))) } )

    val EMERALD_PICKAXE = ITEMS.register("emerald_pickaxe", Supplier { PickaxeItem(
        EMERALD_TIER, Item.Properties().rarity(Rarity.RARE)
            .attributes(PickaxeItem.createAttributes(EMERALD_TIER, 1.5f, -2.1f))) } )

    val EMERALD_SHOVEL = ITEMS.register("emerald_shovel", Supplier { ShovelItem(
        EMERALD_TIER, Item.Properties().rarity(Rarity.RARE)
            .attributes(ShovelItem.createAttributes(EMERALD_TIER, 1f, -2.1f))) } )

    val EMERALD_HOE = ITEMS.register("emerald_hoe", Supplier { HoeItem(
        EMERALD_TIER, Item.Properties().rarity(Rarity.RARE)
            .attributes(HoeItem.createAttributes(EMERALD_TIER, 1f, -2.1f))) } )


    val EMERALD_HELMET: Supplier<ArmorItem> = ITEMS.register("emerald_helmet", Supplier {
        ArmorItem(
            EMERALD_ARMOR_MATERIAL,
            ArmorItem.Type.HELMET,
            Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15)).rarity(Rarity.RARE)
        )
    })
    val EMERALD_CHESTPLATE: Supplier<ArmorItem> = ITEMS.register("emerald_chestplate", Supplier {
        ArmorItem(
            EMERALD_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15)).rarity(Rarity.RARE)
        )
    })
    val EMERALD_LEGGINGS: Supplier<ArmorItem> = ITEMS.register("emerald_leggings", Supplier {
        ArmorItem(
            EMERALD_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15)).rarity(Rarity.RARE)
        )
    })
    val EMERALD_BOOTS: Supplier<ArmorItem> = ITEMS.register("emerald_boots", Supplier {
        ArmorItem(
            EMERALD_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15)).rarity(Rarity.RARE)
        )
    })

    fun register(modEventBus: IEventBus){
        ITEMS.register(modEventBus)
    }
}