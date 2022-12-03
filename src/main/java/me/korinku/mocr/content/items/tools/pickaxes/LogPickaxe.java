package me.korinku.mocr.content.items.tools.pickaxes;

import java.util.List;
import java.util.Random;

import net.minecraft.block.BlockState;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.ItemEntity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class LogPickaxe extends PickaxeItem {

	public LogPickaxe(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
	}

	Item[] drops = new Item[] { Items.OAK_SAPLING, Items.APPLE };

	@Override
	public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {

		world.spawnEntity(new ItemEntity(world, pos.getX(), pos.getY(), pos.getZ(),
				new ItemStack(drops[new Random().nextInt(drops.length)])));

		return super.postMine(stack, world, state, pos, miner);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.literal("Picareta meio inútil, mas não passa fome").formatted(Formatting.DARK_PURPLE));
	}

}
