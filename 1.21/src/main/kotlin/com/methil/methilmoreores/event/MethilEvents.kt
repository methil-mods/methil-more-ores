package com.methil.methilmoreores.event

import com.methil.methilmoreores.item.methil.MethilItem
import net.minecraft.util.RandomSource
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.npc.VillagerProfession
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.trading.ItemCost
import net.minecraft.world.item.trading.MerchantOffer
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.event.village.VillagerTradesEvent


object MethilEvents {
    @SubscribeEvent
    fun addCustomTrades(event: VillagerTradesEvent) {
        if(event.type == VillagerProfession.MASON) {
            val trades = event.trades
            trades[3].add(ItemListing { pTrader: Entity?, pRandom: RandomSource? ->
                MerchantOffer(
                    ItemCost(Items.EMERALD, 12),
                    ItemStack(MethilItem.METHIL_ITEM.get(), 2),
                    7, 8, 0.02f
                )
            })
        }

        if(event.type == VillagerProfession.WEAPONSMITH) {
            val trades = event.trades
            trades[4].add(ItemListing { pTrader: Entity?, pRandom: RandomSource? ->
                MerchantOffer(
                    ItemCost(Items.EMERALD, 21),
                    ItemStack(MethilItem.METHIL_LONG_STICK_SWORD.get(), 1),
                    3, 8, 0.02f
                )
            })
        }
    }
}

