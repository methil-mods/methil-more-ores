package com.methil.methilmoreores.data.tag

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.item.emerald.EmeraldItem
import com.methil.methilmoreores.item.methil.MethilItem
import com.methil.methilmoreores.item.starlight_methil.StarlightMethilItem
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.data.tags.ItemTagsProvider
import net.minecraft.data.tags.TagsProvider
import net.minecraft.tags.ItemTags
import net.minecraft.world.level.block.Block
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ModItemTagsProvider(output: PackOutput, lookupProvider: CompletableFuture<HolderLookup.Provider>, blockTags: CompletableFuture<TagsProvider.TagLookup<Block>>, existingFileHelper: ExistingFileHelper?) : ItemTagsProvider(output, lookupProvider, blockTags, MODID, existingFileHelper) {
    override fun addTags(p0: HolderLookup.Provider) {
        tag(ItemTags.SWORDS)
            .add(MethilItem.METHIL_SWORD.get())
            .add(MethilItem.METHIL_LONG_STICK_SWORD.get())
            .add(EmeraldItem.EMERALD_SWORD.get())
            .add(StarlightMethilItem.STARLIGHT_METHIL_SWORD.get())

        tag(ItemTags.PICKAXES)
            .add(MethilItem.METHIL_PICKAXE.get())
            .add(MethilItem.METHIL_DOUBLE_PICKAXE.get())
            .add(EmeraldItem.EMERALD_PICKAXE.get())
            .add(StarlightMethilItem.STARLIGHT_METHIL_PICKAXE.get())

        tag(ItemTags.HOES)
            .add(MethilItem.METHIL_HOE.get())
            .add(EmeraldItem.EMERALD_HOE.get())
            .add(StarlightMethilItem.STARLIGHT_METHIL_HOE.get())

        tag(ItemTags.AXES)
            .add(MethilItem.METHIL_AXE.get())
            .add(EmeraldItem.EMERALD_AXE.get())
            .add(StarlightMethilItem.STARLIGHT_METHIL_AXE.get())

        tag(ItemTags.SHOVELS)
            .add(MethilItem.METHIL_SHOVEL.get())
            .add(EmeraldItem.EMERALD_SHOVEL.get())
            .add(StarlightMethilItem.STARLIGHT_METHIL_SHOVEL.get())

        tag(ItemTags.HEAD_ARMOR_ENCHANTABLE)
            .add(MethilItem.METHIL_HELMET.get())
            .add(EmeraldItem.EMERALD_HELMET.get())
            .add(StarlightMethilItem.STARLIGHT_METHIL_HELMET.get())

        tag(ItemTags.CHEST_ARMOR_ENCHANTABLE)
            .add(MethilItem.METHIL_CHESTPLATE.get())
            .add(EmeraldItem.EMERALD_CHESTPLATE.get())
            .add(StarlightMethilItem.STARLIGHT_METHIL_CHESTPLATE.get())

        tag(ItemTags.LEG_ARMOR_ENCHANTABLE)
            .add(MethilItem.METHIL_LEGGINGS.get())
            .add(EmeraldItem.EMERALD_LEGGINGS.get())
            .add(StarlightMethilItem.STARLIGHT_METHIL_LEGGINGS.get())

        tag(ItemTags.FOOT_ARMOR_ENCHANTABLE)
            .add(MethilItem.METHIL_BOOTS.get())
            .add(EmeraldItem.EMERALD_BOOTS.get())
            .add(StarlightMethilItem.STARLIGHT_METHIL_BOOTS.get())
    }
}