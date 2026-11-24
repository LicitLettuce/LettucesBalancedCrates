package net.lettuce.balancedcrates.client.events;

import net.lettuce.balancedcrates.registry.CrateVariants;
import net.lettuce.balancedcrates.registry.ModSounds;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

public class CrateClose {

	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null || world.isClientSide())
			return;

		BlockPos pos = BlockPos.containing(x, y, z);
		BlockState oldState = world.getBlockState(pos);
		Block closed = CrateVariants.closedVersionOf(oldState.getBlock());
		if (closed == null)
			return;

		if (entity instanceof Player player)
			player.closeContainer();

		BlockState newState = closed.defaultBlockState();
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
			level.playSound(null, pos, ModSounds.CRATE_CLOSE.get(), SoundSource.BLOCKS, 0.5f, 0.8f);
		}
	}
}