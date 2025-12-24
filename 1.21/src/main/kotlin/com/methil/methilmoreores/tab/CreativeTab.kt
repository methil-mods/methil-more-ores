package com.methil.methilmoreores.tab

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.block.MethilBlock
import com.methil.methilmoreores.item.emerald.EmeraldItem
import com.methil.methilmoreores.item.methil.MethilItem
import com.methil.methilmoreores.item.methil.MethilItem.METHIL_ITEM
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.CreativeModeTabs
import net.minecraft.world.item.Item
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import thedarkcolour.kotlinforforge.neoforge.forge.getValue
import java.util.function.Supplier


object CreativeTab {

    val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
        DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID)

    val EXAMPLE_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> = CREATIVE_MODE_TABS.register("creative_tab",
        Supplier {
            CreativeModeTab.builder()
                .title(Component.translatable("itemGroup.methil.methilmoreores")) //The language key for the title of your CreativeModeTab
                .withTabsBefore(CreativeModeTabs.COMBAT)
                .icon { METHIL_ITEM.get().defaultInstance }
                .displayItems { parameters: ItemDisplayParameters?, output: CreativeModeTab.Output ->
                    val addedItems = HashSet<Item>()
                    EmeraldItem.ITEMS.getEntries()
                        .stream()
                        .map { item -> item.get().asItem() }
                        .filter(addedItems::add)
                        .forEach(output::accept)
                    MethilItem.ITEMS.getEntries()
                        .stream()
                        .map { item -> item.get().asItem() }
                        .filter(addedItems::add)
                        .forEach(output::accept)
                    StarlightMethilItem.ITEMS.getEntries()
                        .stream()
                        .map { item -> item.get().asItem() }
                        .filter(addedItems::add)
                        .forEach(output::accept)
                    MethilBlock.BLOCKS.getEntries()
                        .stream()
                        .map { block -> block.get().asItem() }
                        .filter(addedItems::add)
                        .forEach(output::accept)
                }.build()
        })

    fun register(modEventBus: IEventBus){
        CREATIVE_MODE_TABS.register(modEventBus)
    }

    fun addCreative(event: BuildCreativeModeTabContentsEvent) {
        // if (event.tabKey === CreativeModeTabs.BUILDING_BLOCKS) event.accept(METHIL_ORE_BLOCK_ITEM)
    }
}