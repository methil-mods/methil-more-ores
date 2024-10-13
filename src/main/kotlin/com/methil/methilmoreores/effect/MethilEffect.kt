package com.methil.methilmoreores.effect

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import net.minecraft.core.Registry
import net.minecraft.core.registries.Registries
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.effect.MobEffect
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import net.neoforged.neoforge.registries.NeoForgeRegistries
import java.util.function.Supplier


object MethilEffect {
    val MOB_EFFECTS: DeferredRegister<MobEffect> = DeferredRegister.create(Registries.MOB_EFFECT, MODID)

    val STARLIGHT_METHILFY = MOB_EFFECTS.register("starlight_methilfy", Supplier { StarlightMethilEffect() })

    fun register(modEventBus: IEventBus) {
        MOB_EFFECTS.register(modEventBus)
    }
}