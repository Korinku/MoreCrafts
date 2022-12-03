package me.korinku.mocr.content.items.tools.misc;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

public class AppleTotem extends Item {

	public AppleTotem(Settings settings) {
		super(settings);
		settings.rarity(Rarity.EPIC);
	}

	@Override
	public boolean hasGlint(ItemStack stack) {
		return true;
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.literal("An apple a day keeps the doctor away").formatted(Formatting.DARK_PURPLE));
	}

}
