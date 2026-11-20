package net.lettuce.balancedcrates.registry;

import net.lettuce.balancedcrates.BalancedCrates;
import net.lettuce.common.block.CrateBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.ArrayList;
import java.util.List;

public class ModBlocks {
	public static final DeferredRegister.Blocks REGISTRY = DeferredRegister.createBlocks(BalancedCrates.MOD_ID);

	private static final List<DeferredHolder<Block, Block>> ALL_CRATES = new ArrayList<>();

	private static BlockBehaviour.Properties crateProperties(MapColor color, SoundType sound) {
		return BlockBehaviour.Properties.of()
				.mapColor(color)
				.sound(sound)
				.strength(2.5f)
				.noOcclusion()
				.isRedstoneConductor((state, level, pos) -> false)
				.ignitedByLava()
				.instrument(NoteBlockInstrument.BASS);
	}

	private static DeferredHolder<Block, Block> crate(String name, MapColor color, SoundType sound, boolean open) {
		DeferredHolder<Block, Block> block = REGISTRY.register(name, () -> new CrateBlock(crateProperties(color, sound), open));
		ALL_CRATES.add(block);
		return block;
	}

	private static DeferredHolder<Block, Block> crate(String name, MapColor color, boolean open) {
		return crate(name, color, SoundType.WOOD, open);
	}

	public static Block[] allCrates() {
		return ALL_CRATES.stream().map(DeferredHolder::get).toArray(Block[]::new);
	}

	// Base Crate
	public static final DeferredHolder<Block, Block> CRATE      = crate("crate", MapColor.WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_CRATE = crate("open_crate", MapColor.WOOD, true);

	// Overworld woods
	public static final DeferredHolder<Block, Block> OAK_CRATE            = crate("oak_crate", MapColor.WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_OAK_CRATE       = crate("open_oak_crate", MapColor.WOOD, true);
	public static final DeferredHolder<Block, Block> SPRUCE_CRATE         = crate("spruce_crate", MapColor.PODZOL, false);
	public static final DeferredHolder<Block, Block> OPEN_SPRUCE_CRATE    = crate("open_spruce_crate", MapColor.PODZOL, true);
	public static final DeferredHolder<Block, Block> BIRCH_CRATE          = crate("birch_crate", MapColor.SAND, false);
	public static final DeferredHolder<Block, Block> OPEN_BIRCH_CRATE     = crate("open_birch_crate", MapColor.SAND, true);
	public static final DeferredHolder<Block, Block> JUNGLE_CRATE         = crate("jungle_crate", MapColor.DIRT, false);
	public static final DeferredHolder<Block, Block> OPEN_JUNGLE_CRATE    = crate("open_jungle_crate", MapColor.DIRT, true);
	public static final DeferredHolder<Block, Block> ACACIA_CRATE         = crate("acacia_crate", MapColor.TERRACOTTA_ORANGE, false);
	public static final DeferredHolder<Block, Block> OPEN_ACACIA_CRATE    = crate("open_acacia_crate", MapColor.TERRACOTTA_ORANGE, true);
	public static final DeferredHolder<Block, Block> DARK_OAK_CRATE       = crate("dark_oak_crate", MapColor.COLOR_BROWN, false);
	public static final DeferredHolder<Block, Block> OPEN_DARK_OAK_CRATE  = crate("open_dark_oak_crate", MapColor.COLOR_BROWN, true);
	public static final DeferredHolder<Block, Block> MANGROVE_CRATE       = crate("mangrove_crate", MapColor.COLOR_RED, false);
	public static final DeferredHolder<Block, Block> OPEN_MANGROVE_CRATE  = crate("open_mangrove_crate", MapColor.COLOR_RED, true);
	public static final DeferredHolder<Block, Block> CHERRY_CRATE         = crate("cherry_crate", MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_CHERRY_CRATE    = crate("open_cherry_crate", MapColor.TERRACOTTA_WHITE, SoundType.CHERRY_WOOD,true);
	public static final DeferredHolder<Block, Block> BAMBOO_CRATE         = crate("bamboo_crate", MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD,false);
	public static final DeferredHolder<Block, Block> OPEN_BAMBOO_CRATE    = crate("open_bamboo_crate", MapColor.COLOR_YELLOW, SoundType.BAMBOO_WOOD,true);
	public static final DeferredHolder<Block, Block> PALE_OAK_CRATE       = crate("pale_oak_crate", MapColor.QUARTZ, false);
	public static final DeferredHolder<Block, Block> OPEN_PALE_OAK_CRATE  = crate("open_pale_oak_crate", MapColor.QUARTZ, true);

	// Nether crates
	public static final DeferredHolder<Block, Block> CRIMSON_CRATE        = crate("crimson_crate", MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_CRIMSON_CRATE   = crate("open_crimson_crate", MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, true);
	public static final DeferredHolder<Block, Block> WARPED_CRATE         = crate("warped_crate", MapColor.WARPED_STEM, SoundType.NETHER_WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_WARPED_CRATE    = crate("open_warped_crate", MapColor.WARPED_STEM, SoundType.NETHER_WOOD, true);

	// Quark Crates
	public static final DeferredHolder<Block, Block> A_CRATE            = crate("oak_crate", MapColor.WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_OAK_CRATE       = crate("open_oak_crate", MapColor.WOOD, true);
	public static final DeferredHolder<Block, Block> SPRUCE_CRATE         = crate("spruce_crate", MapColor.PODZOL, false);
	public static final DeferredHolder<Block, Block> OPEN_SPRUCE_CRATE    = crate("open_spruce_crate", MapColor.PODZOL, true);
	public static final DeferredHolder<Block, Block> BIRCH_CRATE          = crate("birch_crate", MapColor.SAND, false);
	public static final DeferredHolder<Block, Block> OPEN_BIRCH_CRATE     = crate("open_birch_crate", MapColor.SAND, true);
}