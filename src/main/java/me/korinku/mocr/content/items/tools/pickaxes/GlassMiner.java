package me.korinku.mocr.content.items.tools.pickaxes;

import java.util.Arrays;
import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.PickaxeItem;
import net.minecraft.item.ToolMaterial;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;
import net.minecraft.util.Hand;
import net.minecraft.util.TypedActionResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.explosion.Explosion.DestructionType;

public class GlassMiner extends PickaxeItem {

	public GlassMiner(ToolMaterial material, int attackDamage, float attackSpeed, Settings settings) {
		super(material, attackDamage, attackSpeed, settings);
	}

	private final List<Block> ores = Arrays.asList(
			Blocks.COAL_ORE,
			Blocks.IRON_ORE,
			Blocks.COPPER_ORE,
			Blocks.GOLD_ORE,
			Blocks.EMERALD_ORE,
			Blocks.REDSTONE_ORE,
			Blocks.LAPIS_ORE,
			Blocks.DIAMOND_ORE,
			Blocks.DEEPSLATE_COAL_ORE,
			Blocks.DEEPSLATE_IRON_ORE,
			Blocks.DEEPSLATE_COPPER_ORE,
			Blocks.DEEPSLATE_GOLD_ORE,
			Blocks.DEEPSLATE_EMERALD_ORE,
			Blocks.DEEPSLATE_REDSTONE_ORE,
			Blocks.DEEPSLATE_LAPIS_ORE,
			Blocks.DEEPSLATE_DIAMOND_ORE,
			Blocks.BEDROCK,
			Blocks.COAL_BLOCK,
			Blocks.IRON_BLOCK,
			Blocks.COPPER_BLOCK,
			Blocks.GOLD_BLOCK,
			Blocks.EMERALD_BLOCK,
			Blocks.REDSTONE_BLOCK,
			Blocks.LAPIS_BLOCK,
			Blocks.DIAMOND_BLOCK,
			Blocks.CRAFTING_TABLE,
			Blocks.SMITHING_TABLE,
			Blocks.FLETCHING_TABLE,
			Blocks.FURNACE,
			Blocks.SMOKER,
			Blocks.BLAST_FURNACE,
			Blocks.CARTOGRAPHY_TABLE,
			Blocks.RAIL,
			Blocks.ACTIVATOR_RAIL,
			Blocks.POWERED_RAIL,
			Blocks.DETECTOR_RAIL,
			Blocks.CHEST,
			Blocks.TRAPPED_CHEST,
			Blocks.ENDER_CHEST,
			Blocks.BARREL,
			Blocks.OAK_SIGN,
			Blocks.SPRUCE_SIGN,
			Blocks.ACACIA_SIGN,
			Blocks.BIRCH_SIGN,
			Blocks.CRIMSON_SIGN,
			Blocks.DARK_OAK_SIGN,
			Blocks.JUNGLE_SIGN,
			Blocks.WARPED_SIGN,
			Blocks.OAK_WALL_SIGN,
			Blocks.SPRUCE_WALL_SIGN,
			Blocks.ACACIA_WALL_SIGN,
			Blocks.BIRCH_WALL_SIGN,
			Blocks.CRIMSON_WALL_SIGN,
			Blocks.DARK_OAK_WALL_SIGN,
			Blocks.JUNGLE_WALL_SIGN,
			Blocks.WARPED_WALL_SIGN,
			Blocks.END_PORTAL_FRAME,
			Blocks.DRAGON_EGG,
			Blocks.BLACK_BED,
			Blocks.BLUE_BED,
			Blocks.BROWN_BED,
			Blocks.CYAN_BED,
			Blocks.GRAY_BED,
			Blocks.GREEN_BED,
			Blocks.LIGHT_BLUE_BED,
			Blocks.LIGHT_GRAY_BED,
			Blocks.LIME_BED,
			Blocks.MAGENTA_BED,
			Blocks.ORANGE_BED,
			Blocks.PINK_BED,
			Blocks.PURPLE_BED,
			Blocks.RED_BED,
			Blocks.WHITE_BED,
			Blocks.YELLOW_BED,
			Blocks.ANCIENT_DEBRIS);

	@Override
	public TypedActionResult<ItemStack> use(World world, PlayerEntity user, Hand hand) {

		BlockPos pos = user.getBlockPos();
		int rad = 10;
		for (int y = -rad; y < rad; y++)
			for (int x = -rad; x < rad; x++)
				for (int z = -rad; z < rad; z++)
					if (Math.sqrt((x * x) + (y * y) + (z * z)) <= rad) {
						BlockPos newBlockPos = new BlockPos(pos.getX() + x, pos.getY() + y, pos.getZ() + z);
						Block block = world.getBlockState(newBlockPos).getBlock();
						if (!block.getDefaultState().isAir() && !ores.contains(block)) {
							world.setBlockState(newBlockPos, Blocks.GLASS.getDefaultState());
						}
					}

		world.createExplosion(user, pos.getX(), pos.getY(), pos.getZ(), (float) 2,
				DestructionType.NONE);
		world.playSound(user, pos, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 0.5F, 1.0F);
		user.getItemCooldownManager().set(this, 300);

		return super.use(world, user, hand);
	}

	@Override
	public void appendTooltip(ItemStack itemStack, World world, List<Text> tooltip, TooltipContext tooltipContext) {
		tooltip.add(Text.literal("O xray do pai tá on").formatted(Formatting.DARK_PURPLE));
	}
}
