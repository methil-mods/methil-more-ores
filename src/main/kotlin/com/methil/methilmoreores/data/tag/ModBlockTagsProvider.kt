package com.methil.methilmoreores.data.tag


import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import com.methil.methilmoreores.block.MethilBlock.DEEPSLATE_METHIL_ORE_BLOCK
import com.methil.methilmoreores.block.MethilBlock.METHIL_BLOCK
import com.methil.methilmoreores.block.MethilBlock.METHIL_ORE_BLOCK
import com.methil.methilmoreores.block.MethilBlock.NETHER_METHIL_ORE_BLOCK
import com.methil.methilmoreores.data.init.MethilTags
import net.minecraft.core.HolderLookup
import net.minecraft.data.PackOutput
import net.minecraft.tags.BlockTags
import net.neoforged.neoforge.common.data.BlockTagsProvider
import net.neoforged.neoforge.common.data.ExistingFileHelper
import java.util.concurrent.CompletableFuture

class ModBlockTagsProvider(
    output: PackOutput?,
    lookupProvider: CompletableFuture<HolderLookup.Provider?>?,
    existingFileHelper: ExistingFileHelper?
) :
    BlockTagsProvider(output, lookupProvider, MODID, existingFileHelper) {
    override fun addTags(pProvider: HolderLookup.Provider) {
        LOGGER.info("Generate TAG")
        tag(MethilTags.BlockTagsInit.METHIL_ORE_TAG)
            .add(METHIL_ORE_BLOCK.get())
            .add(NETHER_METHIL_ORE_BLOCK.get())
            .add(DEEPSLATE_METHIL_ORE_BLOCK.get())

        tag(MethilTags.BlockTagsInit.METHIL_BLOCK_TAG)
            .add(METHIL_BLOCK.get())

        tag(BlockTags.MINEABLE_WITH_PICKAXE)
            .addTag(MethilTags.BlockTagsInit.METHIL_ORE_TAG)
            .addTag(MethilTags.BlockTagsInit.METHIL_BLOCK_TAG)

        tag(BlockTags.NEEDS_IRON_TOOL)
            .addTag(MethilTags.BlockTagsInit.METHIL_ORE_TAG)
            .addTag(MethilTags.BlockTagsInit.METHIL_BLOCK_TAG)
    }
}