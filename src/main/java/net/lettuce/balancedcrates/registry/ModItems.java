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

	public static final DeferredItem<Item> AZALEA_CRATE = block(ModBlocks.AZALEA_CRATE);
	public static final DeferredItem<Item> ASHEN_CRATE = block(ModBlocks.ASHEN_CRATE);
	public static final DeferredItem<Item> TRUMPET_CRATE = block(ModBlocks.TRUMPET_CRATE);

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return REGISTRY.register(block.getId().getPath(), () -> new BlockItem(block.get(), new Item.Properties()));
	}
}