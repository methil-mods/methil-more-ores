package com.methil.methilmoreores

import com.methil.methilmoreores.block.MethilBlock
import com.methil.methilmoreores.item.MethilItem
import com.methil.methilmoreores.item.MethilItem.ITEMS
import com.methil.methilmoreores.item.MethilItem.METHIL_ITEM
import com.methil.methilmoreores.item.MethilItem.METHIL_ORE_BLOCK_ITEM
import com.methil.methilmoreores.item.MethilItem.METHIL_PICKAXE
import com.methil.methilmoreores.item.MethilItem.METHIL_SWORD
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

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MethilMoreOres.MODID)
class MethilMoreOres// Register the commonSetup method for modloading
    (modEventBus: IEventBus, modContainer: ModContainer) {
    companion object {
        const val MODID = "methilmoreores"

        private val LOGGER = LogUtils.getLogger();
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
                        output.accept(METHIL_ORE_BLOCK_ITEM.get())
                        output.accept(METHIL_PICKAXE.get())
                        output.accept(METHIL_SWORD.get())
                    }.build()
            })

        // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
        @EventBusSubscriber(modid = MODID, bus = EventBusSubscriber.Bus.MOD, value = [Dist.CLIENT])
        object ClientModEvents {
            @SubscribeEvent
            fun onClientSetup(event: FMLClientSetupEvent?) {
                // Some client setup code
                LOGGER.info("HELLO FROM CLIENT SETUP")
                LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().user.name)
            }
        }
    }

    init {
        modEventBus.addListener(::commonSetup)
        MethilBlock.register(modEventBus)
        MethilItem.register(modEventBus)

        // Register ourselves for server and other game events we are interested in.
        // Note that this is necessary if and only if we want *this* class (ExampleMod) to respond directly to events.
        // Do not add this line if there are no @SubscribeEvent-annotated functions in this class, like onServerStarting() below.
        // NeoForge.EVENT_BUS.register(this);

        modEventBus.addListener(::addCreative)
        CREATIVE_MODE_TABS.register(modEventBus)
        modContainer.registerConfig(ModConfig.Type.COMMON, Config.SPEC)
    }

    private fun commonSetup(event: FMLCommonSetupEvent) {
        // Some common setup code
        LOGGER.info("HELLO FROM COMMON SETUP")

        if (Config.logDirtBlock) LOGGER.info("DIRT BLOCK >> {}", BuiltInRegistries.BLOCK.getKey(Blocks.DIRT))

        LOGGER.info(Config.magicNumberIntroduction + Config.magicNumber)

        Config.items.forEach(Consumer { item: Item ->
            LOGGER.info(
                "ITEM >> {}",
                item.toString()
            )
        })
    }

    private fun addCreative(event: BuildCreativeModeTabContentsEvent) {
        if (event.tabKey === CreativeModeTabs.BUILDING_BLOCKS) event.accept(METHIL_ORE_BLOCK_ITEM)
    }

}