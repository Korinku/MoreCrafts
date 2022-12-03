package me.korinku.mocr;

import me.korinku.mocr.content.items.ModItems;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.client.itemgroup.FabricItemGroupBuilder;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;

public class MoreCrafts implements ModInitializer {

	public static final String MOD_ID = "mocr";

	public static final ItemGroup CUSTOM_GROUP = FabricItemGroupBuilder
			.build(new Identifier(MOD_ID, "morecrafs_group"), () -> new ItemStack(ModItems.AMETHYST_APPLE));

	@Override
	public void onInitialize() {

		ModItems.init();

	}
}
