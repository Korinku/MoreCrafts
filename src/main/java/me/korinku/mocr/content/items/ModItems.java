package me.korinku.mocr.content.items;

import me.korinku.mocr.MoreCrafts;
import me.korinku.mocr.content.items.armor.CopperArmorItem;
import me.korinku.mocr.content.items.armor.material.ModArmorMaterials;
import me.korinku.mocr.content.items.tools.misc.AmethystApple;
import me.korinku.mocr.content.items.tools.misc.AppleTotem;
import me.korinku.mocr.content.items.tools.misc.ThrowableTNT;
import me.korinku.mocr.content.items.tools.pickaxes.CoalPickaxe;
import me.korinku.mocr.content.items.tools.pickaxes.GlassMiner;
import me.korinku.mocr.content.items.tools.pickaxes.LogPickaxe;
import me.korinku.mocr.content.items.tools.swords.AmethystSword;
import me.korinku.mocr.content.items.tools.swords.CoalSword;
import me.korinku.mocr.content.items.tools.swords.DiamondBlockSword;
import me.korinku.mocr.content.items.tools.swords.DiamondBroadSword;
import me.korinku.mocr.content.items.tools.swords.SwordOfUndying;
import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ToolMaterials;
import net.minecraft.util.Identifier;
import net.minecraft.util.Rarity;
import net.minecraft.util.registry.Registry;

public class ModItems {

	public static final Item AMETHYST_APPLE = registerItem("amethyst_apple",
			new AmethystApple(
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).food(ModFoodComponents.AMETHYST_APPLE)
							.rarity(Rarity.EPIC)));

	public static final Item APPLE_TOTEM = registerItem("apple_totem",
			new AppleTotem(
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).food(ModFoodComponents.APPLE_TOTEM)
							.rarity(Rarity.EPIC)));

	public static final Item AMETHYST_SWORD = registerItem("amethyst_sword",
			new AmethystSword(ToolMaterials.DIAMOND, 2, -1.5F,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item COAL_SWORD = registerItem("coal_sword",
			new CoalSword(ToolMaterials.STONE, 2, -1.5F,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item DIAMOND_BLOCK_SWORD = registerItem("diamond_block_sword",
			new DiamondBlockSword(ToolMaterials.DIAMOND, 11, -1.4F,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item DIAMOND_BROADSWORD = registerItem("diamond_broadsword",
			new DiamondBroadSword(ToolMaterials.DIAMOND, 9, -1.4F,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item SWORD_OF_UNDYING = registerItem("sword_of_undying",
			new SwordOfUndying(ToolMaterials.DIAMOND, 5, -1.4F,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.UNCOMMON)));

	public static final Item COAL_PICKAXE = registerItem("coal_pickaxe",
			new CoalPickaxe(ToolMaterials.DIAMOND, 1, -1.5F,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item LOG_PICKAXE = registerItem("log_pickaxe",
			new LogPickaxe(ToolMaterials.IRON, 1, -1.5F,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item GLASS_MINER = registerItem("glass_miner",
			new GlassMiner(ToolMaterials.DIAMOND, 2, -1.5F,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item THROWABLE_TNT = registerItem("throwable_tnt",
			new ThrowableTNT(new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item COPPER_HELMET = registerItem("copper_helmet",
			new CopperArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.HEAD,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item COPPER_CHESTPLATE = registerItem("copper_chestplate",
			new CopperArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.CHEST,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item COPPER_LEGGINGS = registerItem("copper_legs",
			new CopperArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.LEGS,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	public static final Item COPPER_BOOTS = registerItem("copper_boots",
			new CopperArmorItem(ModArmorMaterials.COPPER, EquipmentSlot.FEET,
					new FabricItemSettings().group(MoreCrafts.CUSTOM_GROUP).rarity(Rarity.RARE)));

	private static Item registerItem(String name, Item item) {
		return Registry.register(Registry.ITEM, new Identifier(MoreCrafts.MOD_ID, name), item);
	}

	public static void init() {
	}

}
