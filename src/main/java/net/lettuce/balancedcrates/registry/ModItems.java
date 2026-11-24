package net.lettuce.balancedcrates.registry;

import net.lettuce.balancedcrates.BalancedCrates;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {

	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(BalancedCrates.MOD_ID);

	public static final DeferredItem<Item> CRATE = block(ModBlocks.CRATE);
	public static final DeferredItem<Item> OAK_CRATE = block(ModBlocks.OAK_CRATE);
	public static final DeferredItem<Item> SPRUCE_CRATE = block(ModBlocks.SPRUCE_CRATE);
	public static final DeferredItem<Item> BIRCH_CRATE = block(ModBlocks.BIRCH_CRATE);
	public static final DeferredItem<Item> JUNGLE_CRATE = block(ModBlocks.JUNGLE_CRATE);
	public static final DeferredItem<Item> ACACIA_CRATE = block(ModBlocks.ACACIA_CRATE);
	public static final DeferredItem<Item> DARK_OAK_CRATE = block(ModBlocks.DARK_OAK_CRATE);
	public static final DeferredItem<Item> MANGROVE_CRATE = block(ModBlocks.MANGROVE_CRATE);
	public static final DeferredItem<Item> CHERRY_CRATE = block(ModBlocks.CHERRY_CRATE);
	public static final DeferredItem<Item> BAMBOO_CRATE = block(ModBlocks.BAMBOO_CRATE);
	public static final DeferredItem<Item> PALE_OAK_CRATE = block(ModBlocks.PALE_OAK_CRATE);
	public static final DeferredItem<Item> CRIMSON_CRATE = block(ModBlocks.CRIMSON_CRATE);
	public static final DeferredItem<Item> WARPED_CRATE = block(ModBlocks.WARPED_CRATE);

	// Quark
	public static final DeferredItem<Item> AZALEA_CRATE = block(ModBlocks.AZALEA_CRATE);
	public static final DeferredItem<Item> ASHEN_CRATE = block(ModBlocks.ASHEN_CRATE);
	public static final DeferredItem<Item> TRUMPET_CRATE = block(ModBlocks.TRUMPET_CRATE);

	// Atmospheric
	public static final DeferredItem<Item> ROSEWOOD_CRATE = block(ModBlocks.ROSEWOOD_CRATE);
	public static final DeferredItem<Item> MORADO_CRATE = block(ModBlocks.MORADO_CRATE);
	public static final DeferredItem<Item> YUCCA_CRATE = block(ModBlocks.YUCCA_CRATE);
	public static final DeferredItem<Item> LAUREL_CRATE = block(ModBlocks.LAUREL_CRATE);
	public static final DeferredItem<Item> ASPEN_CRATE = block(ModBlocks.ASPEN_CRATE);
	public static final DeferredItem<Item> KOUSA_CRATE = block(ModBlocks.KOUSA_CRATE);
	public static final DeferredItem<Item> GRIMWOOD_CRATE = block(ModBlocks.GRIMWOOD_CRATE);

	// Environmental
	public static final DeferredItem<Item> WILLOW_CRATE = block(ModBlocks.WILLOW_CRATE);
	public static final DeferredItem<Item> PINE_CRATE = block(ModBlocks.PINE_CRATE);
	public static final DeferredItem<Item> PLUM_CRATE = block(ModBlocks.PLUM_CRATE);
	public static final DeferredItem<Item> WISTERIA_CRATE = block(ModBlocks.WISTERIA_CRATE);

	// Autumnity
	public static final DeferredItem<Item> MAPLE_CRATE = block(ModBlocks.MAPLE_CRATE);

	// Upgrade Aquatic
	public static final DeferredItem<Item> DRIFTWOOD_CRATE = block(ModBlocks.DRIFTWOOD_CRATE);
	public static final DeferredItem<Item> RIVER_CRATE = block(ModBlocks.RIVER_CRATE);

	// Caverns & Chasms
	public static final DeferredItem<Item> CCAZALEA_CRATE = block(ModBlocks.CCAZALEA_CRATE);

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}