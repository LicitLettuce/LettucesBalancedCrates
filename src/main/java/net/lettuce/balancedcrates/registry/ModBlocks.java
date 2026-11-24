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

	public static final DeferredHolder<Block, Block> CRATE      = crate("crate", MapColor.WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_CRATE = crate("open_crate", MapColor.WOOD, true);
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
	public static final DeferredHolder<Block, Block> CRIMSON_CRATE        = crate("crimson_crate", MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_CRIMSON_CRATE   = crate("open_crimson_crate", MapColor.CRIMSON_STEM, SoundType.NETHER_WOOD, true);
	public static final DeferredHolder<Block, Block> WARPED_CRATE         = crate("warped_crate", MapColor.WARPED_STEM, SoundType.NETHER_WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_WARPED_CRATE    = crate("open_warped_crate", MapColor.WARPED_STEM, SoundType.NETHER_WOOD, true);

	// Quark
	public static final DeferredHolder<Block, Block> AZALEA_CRATE         = crate("azalea_crate", MapColor.COLOR_GREEN, false);
	public static final DeferredHolder<Block, Block> OPEN_AZALEA_CRATE    = crate("open_azalea_crate", MapColor.COLOR_GREEN, true);
	public static final DeferredHolder<Block, Block> ASHEN_CRATE          = crate("ashen_crate", MapColor.TERRACOTTA_WHITE, false);
	public static final DeferredHolder<Block, Block> OPEN_ASHEN_CRATE     = crate("open_ashen_crate", MapColor.TERRACOTTA_WHITE, true);
	public static final DeferredHolder<Block, Block> TRUMPET_CRATE        = crate("trumpet_crate", MapColor.TERRACOTTA_RED, false);
	public static final DeferredHolder<Block, Block> OPEN_TRUMPET_CRATE   = crate("open_trumpet_crate", MapColor.TERRACOTTA_RED, true);

	// Atmospheric
	public static final DeferredHolder<Block, Block> ROSEWOOD_CRATE         = crate("rosewood_crate", MapColor.COLOR_PINK, false);
	public static final DeferredHolder<Block, Block> OPEN_ROSEWOOD_CRATE    = crate("open_rosewood_crate", MapColor.COLOR_PINK, true);
	public static final DeferredHolder<Block, Block> MORADO_CRATE          = crate("morado_crate", MapColor.TERRACOTTA_RED, false);
	public static final DeferredHolder<Block, Block> OPEN_MORADO_CRATE     = crate("open_morado_crate", MapColor.TERRACOTTA_RED, true);
	public static final DeferredHolder<Block, Block> YUCCA_CRATE        = crate("yucca_crate", MapColor.TERRACOTTA_ORANGE, false);
	public static final DeferredHolder<Block, Block> OPEN_YUCCA_CRATE   = crate("open_yucca_crate", MapColor.TERRACOTTA_ORANGE, true);
	public static final DeferredHolder<Block, Block> LAUREL_CRATE        = crate("laurel_crate", MapColor.TERRACOTTA_WHITE, false);
	public static final DeferredHolder<Block, Block> OPEN_LAUREL_CRATE   = crate("open_laurel_crate", MapColor.TERRACOTTA_WHITE, true);
	public static final DeferredHolder<Block, Block> ASPEN_CRATE        = crate("aspen_crate", MapColor.TERRACOTTA_YELLOW, false);
	public static final DeferredHolder<Block, Block> OPEN_ASPEN_CRATE   = crate("open_aspen_crate", MapColor.TERRACOTTA_YELLOW, true);
	public static final DeferredHolder<Block, Block> KOUSA_CRATE        = crate("kousa_crate", MapColor.TERRACOTTA_LIGHT_GREEN, false);
	public static final DeferredHolder<Block, Block> OPEN_KOUSA_CRATE   = crate("open_kousa_crate", MapColor.TERRACOTTA_LIGHT_GREEN, true);
	public static final DeferredHolder<Block, Block> GRIMWOOD_CRATE        = crate("grimwood_crate", MapColor.TERRACOTTA_BROWN, false);
	public static final DeferredHolder<Block, Block> OPEN_GRIMWOOD_CRATE   = crate("open_grimwood_crate", MapColor.TERRACOTTA_BROWN, true);

	// Evironmental
	public static final DeferredHolder<Block, Block> WILLOW_CRATE        = crate("willow_crate", MapColor.TERRACOTTA_LIGHT_GREEN, false);
	public static final DeferredHolder<Block, Block> OPEN_WILLOW_CRATE   = crate("open_willow_crate", MapColor.TERRACOTTA_LIGHT_GREEN, true);
	public static final DeferredHolder<Block, Block> PINE_CRATE        = crate("pine_crate", MapColor.WOOD, false);
	public static final DeferredHolder<Block, Block> OPEN_PINE_CRATE   = crate("open_pine_crate", MapColor.WOOD, true);
	public static final DeferredHolder<Block, Block> PLUM_CRATE        = crate("plum_crate", MapColor.COLOR_RED, false);
	public static final DeferredHolder<Block, Block> OPEN_PLUM_CRATE   = crate("open_plum_crate", MapColor.COLOR_RED, true);
	public static final DeferredHolder<Block, Block> WISTERIA_CRATE        = crate("wisteria_crate", MapColor.TERRACOTTA_WHITE, false);
	public static final DeferredHolder<Block, Block> OPEN_WISTERIA_CRATE   = crate("open_wisteria_crate", MapColor.TERRACOTTA_WHITE, true);

	// Autumnity
	public static final DeferredHolder<Block, Block> MAPLE_CRATE        = crate("maple_crate", MapColor.COLOR_ORANGE, false);
	public static final DeferredHolder<Block, Block> OPEN_MAPLE_CRATE   = crate("open_maple_crate", MapColor.COLOR_ORANGE, true);

	// Upgrade Aquatic
	public static final DeferredHolder<Block, Block> DRIFTWOOD_CRATE        = crate("driftwood_crate", MapColor.COLOR_GRAY, false);
	public static final DeferredHolder<Block, Block> OPEN_DRIFTWOOD_CRATE   = crate("open_driftwood_crate", MapColor.COLOR_GRAY, true);
	public static final DeferredHolder<Block, Block> RIVER_CRATE        = crate("river_crate", MapColor.TERRACOTTA_BROWN, false);
	public static final DeferredHolder<Block, Block> OPEN_RIVER_CRATE   = crate("open_river_crate", MapColor.TERRACOTTA_BROWN, true);

	// Caverns & Chasms
	public static final DeferredHolder<Block, Block> CCAZALEA_CRATE        = crate("ccazalea_crate", MapColor.TERRACOTTA_LIGHT_BLUE, false);
	public static final DeferredHolder<Block, Block> OPEN_CCAZALEA_CRATE   = crate("open_ccazalea_crate", MapColor.TERRACOTTA_LIGHT_BLUE, true);
}