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
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier

object StarlightMethilItem {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(
        MODID
    )

    val STARLIGHT_METHIL_ITEM: DeferredItem<Item> = ITEMS.registerSimpleItem(
        "starlight_methil", Item.Properties().rarity(Rarity.EPIC)
    )

    val STARLIGHT_METHIL_TIER = SimpleTier(
        Tags.Blocks.ORES,
        1900,
        9f,
        5.5f,
        26,
        Supplier { Ingredient.of(STARLIGHT_METHIL_ITEM) }
    )

    val STARLIGHT_METHIL_SWORD = ITEMS.register("starlight_methil_sword", Supplier { SwordItem(
        STARLIGHT_METHIL_TIER, Item.Properties().rarity(Rarity.EPIC)
            .attributes(
                SwordItem.createAttributes(
                    STARLIGHT_METHIL_TIER,
                    4.5f,
                    -2.1f
                )
            )) } )

    val STARLIGHT_METHIL_PICKAXE = ITEMS.register("starlight_methil_pickaxe", Supplier { PickaxeItem(
        STARLIGHT_METHIL_TIER, Item.Properties()
            .rarity(Rarity.EPIC).attributes(PickaxeItem.createAttributes(STARLIGHT_METHIL_TIER, 1.3f, -2.8f))) } )

    val STARLIGHT_METHIL_AXE = ITEMS.register("starlight_methil_axe", Supplier { AxeItem(
        STARLIGHT_METHIL_TIER, Item.Properties()
            .rarity(Rarity.EPIC).attributes(AxeItem.createAttributes(STARLIGHT_METHIL_TIER, 1.3f, -2.8f))) } )

    val STARLIGHT_METHIL_HOE = ITEMS.register("starlight_methil_hoe", Supplier { HoeItem(
        STARLIGHT_METHIL_TIER, Item.Properties()
            .rarity(Rarity.EPIC).attributes(HoeItem.createAttributes(STARLIGHT_METHIL_TIER, 1.3f, -2.8f))) } )

    val STARLIGHT_METHIL_SHOVEL = ITEMS.register("starlight_methil_shovel", Supplier { ShovelItem(
        STARLIGHT_METHIL_TIER, Item.Properties()
            .rarity(Rarity.EPIC).attributes(ShovelItem.createAttributes(STARLIGHT_METHIL_TIER, 1.3f, -2.8f))) } )

    val STARLIGHT_METHIL_HELMET: Supplier<ArmorItem> = ITEMS.register("starlight_methil_helmet", Supplier {
        MethilArmorItem(
            STARLIGHT_METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.HELMET,
            Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15)).rarity(Rarity.EPIC)
        )
    })
    val STARLIGHT_METHIL_CHESTPLATE: Supplier<ArmorItem> = ITEMS.register("starlight_methil_chestplate", Supplier {
        MethilArmorItem(
            STARLIGHT_METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15)).rarity(Rarity.EPIC)
        )
    })
    val STARLIGHT_METHIL_LEGGINGS: Supplier<ArmorItem> = ITEMS.register("starlight_methil_leggings", Supplier {
        MethilArmorItem(
            STARLIGHT_METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15)).rarity(Rarity.EPIC)
        )
    })
    val STARLIGHT_METHIL_BOOTS: Supplier<ArmorItem> = ITEMS.register("starlight_methil_boots", Supplier {
        MethilArmorItem(
            STARLIGHT_METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15)).rarity(Rarity.EPIC)
        )
    })


    fun register(modEventBus: IEventBus){
        ITEMS.register(modEventBus)
    }
}