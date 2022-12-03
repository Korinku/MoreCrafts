package me.korinku.mocr.content.items.tools.swords;

import java.util.List;
import java.util.Random;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Box;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class CoalSword extends SwordItem {

	public CoalSword(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
		super(toolMaterial, attackDamage, attackSpeed, settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		target.setFireTicks(100);
		Vec3d loc = target.getPos();
		Box bounds = target.getBoundingBox();
		loc.add(bounds.getZLength() / 2, bounds.getYLength() / 2, bounds.getZLength() / 2);
		for (int i = 0; i < 25; i++) {
			target.getWorld().addParticle(ParticleTypes.FLAME, loc.getX(), loc.getY(), loc.getZ(),
					new Random().nextInt(100) / 100f * (bounds.getXLength() / 2),
					new Random().nextInt(100) / 100f * (bounds.getYLength() / 2),
					new Random().nextInt(100) / 100f * (bounds.getZLength() / 2));
		}
		return super.postHit(stack, target, attacker);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.literal("Esquenta coisa").formatted(Formatting.DARK_PURPLE));
	}

}
