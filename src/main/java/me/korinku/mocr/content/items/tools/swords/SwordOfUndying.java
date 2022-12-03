package me.korinku.mocr.content.items.tools.swords;

import java.util.List;

import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.SwordItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

public class SwordOfUndying extends SwordItem {

	public SwordOfUndying(ToolMaterial toolMaterial, int attackDamage, float attackSpeed, Settings settings) {
		super(toolMaterial, attackDamage, attackSpeed, settings);
	}

	@Override
	public boolean postHit(ItemStack stack, LivingEntity target, LivingEntity attacker) {

		if (target instanceof HostileEntity) {
			Vec3d loc = target.getPos().add(0, 1, 0);

			target.getWorld().spawnEntity(new ItemEntity(target.getWorld(), loc.getX(), loc.getY(), loc.getZ(),
					new ItemStack(Items.TOTEM_OF_UNDYING)));

			target.getWorld().addParticle(ParticleTypes.TOTEM_OF_UNDYING, loc.getX(), loc.getY(), loc.getZ(), 0.2, 0.1,
					0.2);
		}

		return super.postHit(stack, target, attacker);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.literal("Para quê morrer quando podemos viver?").formatted(Formatting.DARK_PURPLE));
	}

}
