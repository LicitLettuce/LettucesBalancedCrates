
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package balanced.crates.init;

import net.minecraftforge.registries.RegistryObject;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.DeferredRegister;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.BlockItem;

import balanced.crates.BalancedCratesMod;

public class BalancedCratesModItems {
	public static final DeferredRegister<Item> REGISTRY = DeferredRegister.create(ForgeRegistries.ITEMS, BalancedCratesMod.MODID);
	public static final RegistryObject<Item> INDUSTRIAL_CRATE = block(BalancedCratesModBlocks.INDUSTRIAL_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> OAK_CRATE = block(BalancedCratesModBlocks.OAK_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> SPRUCE_CRATE = block(BalancedCratesModBlocks.SPRUCE_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> BIRCH_CRATE = block(BalancedCratesModBlocks.BIRCH_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> JUNGLE_CRATE = block(BalancedCratesModBlocks.JUNGLE_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> ACACIA_CRATE = block(BalancedCratesModBlocks.ACACIA_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> DARK_OAK_CRATE = block(BalancedCratesModBlocks.DARK_OAK_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> MANGROVE_CRATE = block(BalancedCratesModBlocks.MANGROVE_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> CRIMSON_CRATE = block(BalancedCratesModBlocks.CRIMSON_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> WARPED_CRATE = block(BalancedCratesModBlocks.WARPED_CRATE, CreativeModeTab.TAB_DECORATIONS);
	public static final RegistryObject<Item> OPEN_OAK_CRATE = block(BalancedCratesModBlocks.OPEN_OAK_CRATE, null);
	public static final RegistryObject<Item> CRATE_UI = block(BalancedCratesModBlocks.CRATE_UI, null);
	public static final RegistryObject<Item> OPEN_SPRUCE_CRATE = block(BalancedCratesModBlocks.OPEN_SPRUCE_CRATE, null);
	public static final RegistryObject<Item> OPEN_BIRCH_CRATE = block(BalancedCratesModBlocks.OPEN_BIRCH_CRATE, null);
	public static final RegistryObject<Item> JUNGLE_CRATE_OPEN = block(BalancedCratesModBlocks.JUNGLE_CRATE_OPEN, null);
	public static final RegistryObject<Item> OPEN_ACACIA_CRATE = block(BalancedCratesModBlocks.OPEN_ACACIA_CRATE, null);
	public static final RegistryObject<Item> OPEN_DARK_OAK_CRATE = block(BalancedCratesModBlocks.OPEN_DARK_OAK_CRATE, null);
	public static final RegistryObject<Item> OPEN_CRIMSON_CRATE = block(BalancedCratesModBlocks.OPEN_CRIMSON_CRATE, null);
	public static final RegistryObject<Item> OPEN_WARPED_CRATE = block(BalancedCratesModBlocks.OPEN_WARPED_CRATE, null);
	public static final RegistryObject<Item> OPEN_INDUSTRIAL_CRATE = block(BalancedCratesModBlocks.OPEN_INDUSTRIAL_CRATE, null);
	public static final RegistryObject<Item> OPEN_MANGROVE_CRATE = block(BalancedCratesModBlocks.OPEN_MANGROVE_CRATE, null);

	private static RegistryObject<Item> block(RegistryObject<Block> block, CreativeModeTab tab) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties().tab(tab)));
	}
}
