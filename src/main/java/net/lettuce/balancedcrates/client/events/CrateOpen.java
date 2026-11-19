package net.lettuce.balancedcrates.client.events;

import net.lettuce.balancedcrates.registry.ModBlocks;
import net.lettuce.balancedcrates.registry.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

import java.util.Map;

public class CrateOpen {

	private static Map<Block, Block> closedToOpen;

	private static Block openVersionOf(Block closed) {
		if (closedToOpen == null) {
			closedToOpen = Map.ofEntries(
					Map.entry(ModBlocks.CRATE.get(), ModBlocks.OPEN_CRATE.get()),
					Map.entry(ModBlocks.OAK_CRATE.get(), ModBlocks.OPEN_OAK_CRATE.get()),
					Map.entry(ModBlocks.SPRUCE_CRATE.get(), ModBlocks.OPEN_SPRUCE_CRATE.get()),
					Map.entry(ModBlocks.BIRCH_CRATE.get(), ModBlocks.OPEN_BIRCH_CRATE.get()),
					Map.entry(ModBlocks.JUNGLE_CRATE.get(), ModBlocks.OPEN_JUNGLE_CRATE.get()),
					Map.entry(ModBlocks.ACACIA_CRATE.get(), ModBlocks.OPEN_ACACIA_CRATE.get()),
					Map.entry(ModBlocks.DARK_OAK_CRATE.get(), ModBlocks.OPEN_DARK_OAK_CRATE.get()),
					Map.entry(ModBlocks.MANGROVE_CRATE.get(), ModBlocks.OPEN_MANGROVE_CRATE.get()),
					Map.entry(ModBlocks.CHERRY_CRATE.get(), ModBlocks.OPEN_CHERRY_CRATE.get()),
					Map.entry(ModBlocks.BAMBOO_CRATE.get(), ModBlocks.OPEN_BAMBOO_CRATE.get()),
					Map.entry(ModBlocks.PALE_OAK_CRATE.get(), ModBlocks.OPEN_PALE_OAK_CRATE.get()),
					Map.entry(ModBlocks.CRIMSON_CRATE.get(), ModBlocks.OPEN_CRIMSON_CRATE.get()),
					Map.entry(ModBlocks.WARPED_CRATE.get(), ModBlocks.OPEN_WARPED_CRATE.get())
			);
		}
		return closedToOpen.get(closed);
	}

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null || world.isClientSide())
			return;
		if (entity.isShiftKeyDown())
			return;

		BlockPos pos = BlockPos.containing(x, y, z);
		BlockState oldState = world.getBlockState(pos);
		Block open = openVersionOf(oldState.getBlock());
		if (open == null)
			return;

		BlockState newState = open.defaultBlockState();
		for (Property<?> oldProp : oldState.getProperties()) {
			Property newProp = newState.getBlock().getStateDefinition().getProperty(oldProp.getName());
			if (newProp != null && newState.getValue(newProp) != null) {
				try {
					newState = newState.setValue(newProp, oldState.getValue(oldProp));
				} catch (Exception ignored) {
				}
			}
		}


		BlockEntity be = world.getBlockEntity(pos);
		CompoundTag nbt = null;
		if (be != null) {
			nbt = be.saveWithFullMetadata(world.registryAccess());
			be.setRemoved();
		}
		world.setBlock(pos, newState, 3);
		if (nbt != null) {
			BlockEntity newBe = world.getBlockEntity(pos);
			if (newBe != null) {
				try {
					newBe.loadWithComponents(nbt, world.registryAccess());
				} catch (Exception ignored) {
				}
			}
		}

		if (world instanceof Level level) {
			level.playSound(null, pos, ModSounds.CRATE_OPEN.get(), SoundSource.BLOCKS, 0.5f, 0.75f);
		}
	}
}