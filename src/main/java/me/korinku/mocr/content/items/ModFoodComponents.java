package me.korinku.mocr.content.items;

import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.FoodComponent;

public class ModFoodComponents {
	public static final FoodComponent AMETHYST_APPLE;
	public static final FoodComponent APPLE_TOTEM;

	static {
		AMETHYST_APPLE = (new FoodComponent.Builder()).hunger(4).saturationModifier(1.0F)
				.statusEffect(new StatusEffectInstance(StatusEffects.LEVITATION, 60, 1), 1.0F)
				.alwaysEdible()
				.build();

		APPLE_TOTEM = (new FoodComponent.Builder()).hunger(8).saturationModifier(3.0F)
				.statusEffect(new StatusEffectInstance(StatusEffects.REGENERATION, 1000, 4), 1.0F)
				.statusEffect(new StatusEffectInstance(StatusEffects.RESISTANCE, 1000, 4), 1.0F)
				.statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 1000, 1), 1.0F)
				.alwaysEdible()
				.build();
	}

}
