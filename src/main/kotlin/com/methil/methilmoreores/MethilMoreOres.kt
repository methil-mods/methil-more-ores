package com.methil.methilmoreores

import com.mojang.logging.LogUtils
import io.github.realyusufismail.data.DataGenerators
import net.minecraft.client.Minecraft
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.core.registries.Registries
import net.minecraft.network.chat.Component
import net.minecraft.world.food.FoodProperties
import net.minecraft.world.item.*
import net.minecraft.world.item.CreativeModeTab.ItemDisplayParameters
import net.minecraft.world.item.crafting.Ingredient
import net.minecraft.world.level.block.Block
import net.minecraft.world.level.block.Blocks
import net.minecraft.world.level.block.state.BlockBehaviour
import net.minecraft.world.level.material.MapColor
import net.neoforged.api.distmarker.Dist
import net.neoforged.bus.api.IEventBus
import net.neoforged.bus.api.SubscribeEvent
import net.neoforged.fml.ModContainer
import net.neoforged.fml.common.EventBusSubscriber
import net.neoforged.fml.common.Mod
import net.neoforged.fml.config.ModConfig
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent
import net.neoforged.neoforge.common.NeoForge
import net.neoforged.neoforge.common.SimpleTier
import net.neoforged.neoforge.common.Tags
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent
import net.neoforged.neoforge.event.server.ServerStartingEvent
import net.neoforged.neoforge.registries.DeferredBlock
import net.neoforged.neoforge.registries.DeferredHolder
import net.neoforged.neoforge.registries.DeferredItem
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Consumer
import java.util.function.Supplier

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(MethilMoreOres.MODID)
class MethilMoreOres {
    companion object {

        const val MODID = "methilmoreores"

        private val LOGGER = LogUtils.getLogger();

        val BLOCKS: DeferredRegister.Blocks = DeferredRegister.createBlocks(
            MODID
        )
        val ITEMS: DeferredRegister.Items = DeferredRegister.createItems(
            MODID
        )
        val CREATIVE_MODE_TABS: DeferredRegister<CreativeModeTab> =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID)

        // Register block and ore
        val METHIL_ORE_BLOCK: DeferredBlock<Block> =
            BLOCKS.registerSimpleBlock("methil_ore", BlockBehaviour.Properties.of().mapColor(MapColor.STONE))
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

        val METHIL_SWORD = ITEMS.register("methil_sword", Supplier { SwordItem(METHIL_TIER, Item.Properties().rarity(Rarity.EPIC)) } )
        val METHIL_PICKAXE = ITEMS.register("methil_pickaxe", Supplier { PickaxeItem(METHIL_TIER, Item.Properties().rarity(Rarity.EPIC)) } )

        val EXAMPLE_TAB: DeferredHolder<CreativeModeTab, CreativeModeTab> = CREATIVE_MODE_TABS.register("example_tab",
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

    constructor(modEventBus: IEventBus, modContainer: ModContainer) {
        // Register the commonSetup method for modloading
        modEventBus.addListener(::commonSetup)
        modEventBus.addListener(DataGenerators::gatherData)

        BLOCKS.register(modEventBus)
        ITEMS.register(modEventBus)
        CREATIVE_MODE_TABS.register(modEventBus)


        NeoForge.EVENT_BUS.register(this)
        modEventBus.addListener(::addCreative)

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

    // Add the example block item to the building blocks tab
    private fun addCreative(event: BuildCreativeModeTabContentsEvent) {
        if (event.tabKey === CreativeModeTabs.BUILDING_BLOCKS) event.accept(METHIL_ORE_BLOCK_ITEM)
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    fun onServerStarting(event: ServerStartingEvent) {
        // Do something when the server starts
        LOGGER.info("HELLO from server starting")
    }
}