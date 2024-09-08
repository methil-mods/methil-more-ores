package com.methil.methilmoreores

import com.methil.methilmoreores.block.MethilBlock
import com.methil.methilmoreores.item.MethilItem
import com.methil.methilmoreores.item.MethilItem.ITEMS
import com.methil.methilmoreores.item.MethilItem.METHIL_ITEM
import com.methil.methilmoreores.item.MethilItem.METHIL_ORE_BLOCK_ITEM
import com.methil.methilmoreores.item.MethilItem.METHIL_PICKAXE
import com.methil.methilmoreores.item.MethilItem.METHIL_SWORD
import com.methil.methilmoreores.tab.CreativeTab
import com.methil.methilmoreores.tab.CreativeTab.addCreative
import com.mojang.logging.LogUtils
import net.minecraft.client.Minecraft
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.item.*
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.level.block.Blocks
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.IEventBus
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Consumer
import java.util.function.Supplier

@Mod(MethilMoreOres.MODID)
class MethilMoreOres (modEventBus: IEventBus, modContainer: ModContainer) {
    companion object {
        const val MODID = "methilmoreores"
        public val LOGGER = LogUtils.getLogger();
    }

    init {
        modEventBus.addListener(::commonSetup)
        MethilBlock.register(modEventBus)
        MethilItem.register(modEventBus)
        CreativeTab.register(modEventBus)
        modEventBus.addListener(::addCreative)

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        // NeoForge.EVENT_BUS.register(this);

        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC)
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {
        // Fired when setup is good
        Config.items.forEach(Consumer { item: Item ->
            LOGGER.info(
                "METHIL ITEM >> {}",
                item.toString()
            )
        })
    }

}