package com.methil.methilmoreores.item

import com.methil.methilmoreores.block.MethilBlock.METHIL_ORE_BLOCK
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.MethilArmor.METHIL_ARMOR_MATERIAL
import net.minecraft.world.item.*
import net.minecraft.world.item.crafting.Ingredient
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.common.SimpleTier
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.*
import java.util.function.Supplier

object MethilItem {
    val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(
        MODID
    )
    val METHIL_ORE_BLOCK_ITEM: DeferredItem<BlockItem> = ITEMS.registerSimpleBlockItem("methil_ore", METHIL_ORE_BLOCK)

    val METHIL_ITEM: DeferredItem<Item> = ITEMS.registerSimpleItem(
        "methil", Item.Properties().rarity(Rarity.EPIC)
    )

    val METHIL_TIER = SimpleTier(
        Tags.Blocks.ORES,
        1900,
        9f,
        5.5f,
        26,
        Supplier { Ingredient.of(METHIL_ITEM) }
    )

    val METHIL_SWORD = ITEMS.register("methil_sword", Supplier { SwordItem(METHIL_TIER, Item.Properties().rarity(Rarity.EPIC)
        .attributes(
            SwordItem.createAttributes(
                METHIL_TIER,
                4.5f,
                -2.1f
            )
        )) } )
    val METHIL_PICKAXE = ITEMS.register("methil_pickaxe", Supplier { PickaxeItem(METHIL_TIER, Item.Properties()
        .rarity(Rarity.EPIC).attributes(PickaxeItem.createAttributes(METHIL_TIER, 1.3f, -2.8f))) } )
    val METHIL_DOUBLE_PICKAXE = ITEMS.register("methil_double_pickaxe", Supplier { PickaxeItem(METHIL_TIER, Item.Properties()
        .rarity(Rarity.EPIC).attributes(PickaxeItem.createAttributes(METHIL_TIER, 2f, -2.8f))) } )

    val METHIL_HELMET: Supplier<ArmorItem> = ITEMS.register("methil_helmet", Supplier {
        ArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.HELMET,
            Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(15))
        )
    })
    val METHIL_CHESTPLATE: Supplier<ArmorItem> = ITEMS.register("methil_chestplate", Supplier {
        ArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.CHESTPLATE,
            Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(15))
        )
    })
    val METHIL_LEGGINGS: Supplier<ArmorItem> = ITEMS.register("methil_leggings", Supplier {
        ArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.LEGGINGS,
            Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(15))
        )
    })
    val METHIL_BOOTS: Supplier<ArmorItem> = ITEMS.register("methil_boots", Supplier {
        ArmorItem(
            METHIL_ARMOR_MATERIAL,
            ArmorItem.Type.BOOTS,
            Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(15))
        )
    })


    fun register(modEventBus: IEventBus){
        ITEMS.register(modEventBus)
    }
}