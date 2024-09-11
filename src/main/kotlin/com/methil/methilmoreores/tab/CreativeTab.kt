package com.methil.methilmoreores.tab

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.MethilItem.ITEMS
import com.methil.methilmoreores.item.MethilItem.METHIL_AXE
import com.methil.methilmoreores.item.MethilItem.METHIL_BOOTS
import com.methil.methilmoreores.item.MethilItem.METHIL_CHESTPLATE
import com.methil.methilmoreores.item.MethilItem.METHIL_DOUBLE_PICKAXE
import com.methil.methilmoreores.item.MethilItem.METHIL_HELMET
import com.methil.methilmoreores.item.MethilItem.METHIL_HOE
import com.methil.methilmoreores.item.MethilItem.METHIL_ITEM
import com.methil.methilmoreores.item.MethilItem.METHIL_LEGGINGS
import com.methil.methilmoreores.item.MethilItem.METHIL_PICKAXE
import com.methil.methilmoreores.item.MethilItem.METHIL_SHOVEL
import com.methil.methilmoreores.item.MethilItem.METHIL_SWORD
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.CreativeModeTab
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.CreativeModeTabs
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
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
                    output.accept(METHIL_ITEM.get())
                        // output.accept(METHIL_ORE_BLOCK_ITEM.get())
                    output.accept(METHIL_SWORD.get())
                    output.accept(METHIL_AXE.get())
                    output.accept(METHIL_HOE.get())
                    output.accept(METHIL_SHOVEL.get())
                    output.accept(METHIL_PICKAXE.get())
                    output.accept(METHIL_DOUBLE_PICKAXE.get())
                    output.accept(METHIL_HELMET.get())
                    output.accept(METHIL_CHESTPLATE.get())
                    output.accept(METHIL_LEGGINGS.get())
                    output.accept(METHIL_BOOTS.get())
                }.build()
        })


    fun register(modEventBus: IEventBus){
        CREATIVE_MODE_TABS.register(modEventBus)
    }

    fun addCreative(event: BuildCreativeModeTabContentsEvent) {
        // if (event.tabKey === CreativeModeTabs.BUILDING_BLOCKS) event.accept(METHIL_ORE_BLOCK_ITEM)
    }
}