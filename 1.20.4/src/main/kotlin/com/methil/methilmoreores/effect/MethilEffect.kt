package com.methil.methilmoreores.effect

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import net.minecraft.core.registries.Registries
import net.minecraft.world.effect.MobEffect
import net.neoforged.bus.api.IEventBus
import net.neoforged.neoforge.registries.DeferredRegister
import java.util.function.Supplier


object MethilEffect {
    val MOB_EFFECTS: DeferredRegister<MobEffect> = DeferredRegister.create(Registries.MOB_EFFECT, MODID)

    val METHILFY = MOB_EFFECTS.register("methilfy", Supplier { MethilfyEffect() })
    val STARLIGHT_METHILFY = MOB_EFFECTS.register("starlight_methilfy", Supplier { StarlightMethilfyEffect() })

    fun register(modEventBus: IEventBus) {
        MOB_EFFECTS.register(modEventBus)
    }
}