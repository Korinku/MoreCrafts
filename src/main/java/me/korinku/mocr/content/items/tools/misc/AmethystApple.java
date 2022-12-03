package me.korinku.mocr.content.items.tools.misc;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

public class AmethystApple extends Item {

	public AmethystApple(Settings settings) {
		super(settings);
		settings.rarity(Rarity.EPIC);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return true;
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		// formatted red text
		tooltip.add(Text.literal("Uma maça levezinha para comer depois do almoço").formatted(Formatting.DARK_PURPLE));
	}
}
