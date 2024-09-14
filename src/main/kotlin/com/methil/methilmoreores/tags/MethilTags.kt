package com.methil.methilmoreores.data.init


import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import net.minecraft.core.registries.BuiltInRegistries
import net.minecraft.resources.ResourceLocation
import net.minecraft.tags.BlockTags
import net.minecraft.tags.ItemTags
import net.minecraft.tags.TagKey
import net.minecraft.world.item.Item
import net.minecraft.world.level.block.Block

object MethilTags {
    fun createOreLocation(name: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(MODID, "ores/$name")
    }

    fun createBlockLocation(name: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(MODID, name)
    }

    fun createGenericItemsLocation(name: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(MODID, name)
    }

    fun createRawItemsLocation(name: String): ResourceLocation {
        return ResourceLocation.fromNamespaceAndPath(MODID, "raw/$name")
    }

    fun createToolTag(name: String): TagKey<Block> {
        return TagKey.create<Block>(
            BuiltInRegistries.BLOCK.key(),
            ResourceLocation.fromNamespaceAndPath(MODID, name)
        )
    }

    object ItemTagsInit {
        // Items
        val METHIL_ORE_TAG: TagKey<Item> = ItemTags.create(createOreLocation("methil_ore"))

    }

    object BlockTagsInit {
        val METHIL_ORE_TAG: TagKey<Block> = BlockTags.create(createOreLocation("methil_ore"))
    }
}