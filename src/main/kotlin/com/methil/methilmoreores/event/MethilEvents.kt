package com.methil.methilmoreores.event

import com.methil.methilmoreores.MethilMoreOres
import com.methil.methilmoreores.MethilMoreOres.Companion.LOGGER
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.MethilItem
import net.minecraft.util.RandomSource
import net.minecraft.world.entity.Entity
import net.minecraft.world.entity.npc.VillagerProfession
import net.minecraft.world.entity.npc.VillagerTrades.ItemListing
import net.minecraft.world.item.EnchantedBookItem
import net.minecraft.world.item.ItemStack
import net.minecraft.world.item.Items
import net.minecraft.world.item.enchantment.EnchantmentInstance
import net.minecraft.world.item.trading.ItemCost
import net.minecraft.world.item.trading.MerchantOffer
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.neoforge.event.village.VillagerTradesEvent


object MethilEvents {
    @SubscribeEvent
    fun addCustomTrades(event: VillagerTradesEvent) {
        if(event.getType() == VillagerProfession.MASON) {
            LOGGER.warn("RECEIVE AN EVENT FOR MASON VILLAGER")
            val trades = event.trades
            // Add on level three a possible merchent offer with MethilItem
            // TODO : Test it !
            trades[3].add(ItemListing { pTrader: Entity?, pRandom: RandomSource? ->
                MerchantOffer(
                    ItemCost(Items.EMERALD, 12),
                    ItemStack(MethilItem.METHIL_ITEM.get(), 2),
                    10, 8, 0.02f
                )
            })
        }




    }
}

