package com.methil.methilmoreores.data.loottable

import com.google.common.collect.Sets
import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import net.minecraft.core.HolderLookup
import net.minecraft.core.WritableRegistry
import net.minecraft.data.PackOutput
import net.minecraft.data.loot.LootTableProvider
import net.minecraft.resources.ResourceKey
import net.minecraft.util.ProblemReporter
import net.minecraft.world.level.storage.loot.BuiltInLootTables
import net.minecraft.world.level.storage.loot.LootTable
import net.minecraft.world.level.storage.loot.ValidationContext
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets
import java.util.List
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import java.util.stream.Collectors

class ModLootTables(pOutput: PackOutput, pRegistries: CompletableFuture<HolderLookup.Provider>) :
    LootTableProvider(
        pOutput, setOf(), List.of(SubProviderEntry(::ModBlockLootTables, LootContextParamSets.BLOCK)), pRegistries
    ) {
    override fun validate(
        writableregistry: WritableRegistry<LootTable>,
        validationcontext: ValidationContext,
        `problemreporter$collector`: ProblemReporter.Collector
    ) {
        val modLootTablesId = BuiltInLootTables.all()
            .stream()
            .filter { id: ResourceKey<LootTable?> -> id.registry().namespace == MODID }
            .collect(Collectors.toSet<ResourceKey<LootTable>>())

        for (id in Sets.difference(modLootTablesId, writableregistry.keySet())) {
            validationcontext.reportProblem("Missing built-in table: $id")
        }

        writableregistry.forEach((Consumer { lootTable: LootTable -> lootTable.validate(validationcontext) }))
    }
}