package com.methil.methilmoreores

import com.methil.methilmoreores.block.MethilBlock
import com.methil.methilmoreores.data.DataGenerators
import com.methil.methilmoreores.effect.MethilEffect
import com.methil.methilmoreores.effect.MethilfyEffect
import com.methil.methilmoreores.effect.StarlightMethilfyEffect
import com.methil.methilmoreores.event.MethilEvents
import com.methil.methilmoreores.item.emerald.EmeraldArmor
import com.methil.methilmoreores.item.emerald.EmeraldItem
import com.methil.methilmoreores.item.methil.MethilArmor
import com.methil.methilmoreores.item.methil.MethilItem
import com.methil.methilmoreores.item.methil.custom.MethilLongStickSword
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilArmor
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem
import com.methil.methilmoreores.tab.CreativeTab
import com.methil.methilmoreores.tab.CreativeTab.addCreative
import com.mojang.logging.LogUtils
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.item.*
import net.neoforged.bus.api.IEventBus
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.neoforge.common.NeoForge.EVENT_BUS
import java.util.function.Consumer


@Mod(MethilMoreOres.MODID)
class MethilMoreOres (modEventBus: IEventBus, modContainer: ModContainer) {
    companion object {
        const val MODID = "methilmoreores"
        public val LOGGER = LogUtils.getLogger();

        fun location(path: String): ResourceLocation {
            return ResourceLocation.fromNamespaceAndPath(MODID, path)
        }
    }



    init {
        modEventBus.addListener(::commonSetup)

        // Methil register
        MethilBlock.register(modEventBus)
        MethilItem.register(modEventBus)
        MethilArmor.register(modEventBus)
        MethilEffect.register(modEventBus)

        // Starlight Methil register
        StarlightMethilItem.register(modEventBus)
        StarlightMethilArmor.register(modEventBus)

        // Emerald register
        EmeraldItem.register(modEventBus)
        EmeraldArmor.register(modEventBus)

        CreativeTab.register(modEventBus)
        modEventBus.addListener(::addCreative)
        modEventBus.addListener(DataGenerators::gatherData)
        EVENT_BUS.addListener(MethilEvents::addCustomTrades)
        EVENT_BUS.addListener(MethilLongStickSword::onPlayerTick)
        EVENT_BUS.addListener(MethilfyEffect::onPlayerTick)
        EVENT_BUS.addListener(StarlightMethilfyEffect::onPlayerTick)



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