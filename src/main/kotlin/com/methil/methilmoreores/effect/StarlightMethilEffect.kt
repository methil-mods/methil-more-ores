package com.methil.methilmoreores.effect

import com.methil.methilmoreores.MethilMoreOres.Companion.MODID
import net.minecraft.resources.ResourceLocation
import net.minecraft.world.effect.MobEffect
import net.minecraft.world.effect.MobEffectCategory
import net.minecraft.world.entity.ai.attributes.AttributeModifier
import net.minecraft.world.entity.ai.attributes.Attributes

class StarlightMethilEffect : MobEffect(MobEffectCategory.BENEFICIAL, 0x00FFFF) { // HARMFUL effect with a light blue color
    init {
        this.addAttributeModifier(
            Attributes.MAX_HEALTH,
            ResourceLocation.fromNamespaceAndPath(MODID, "starlight_methilfy"),
            0.5,
            AttributeModifier.Operation.ADD_MULTIPLIED_TOTAL
        )
    }
}