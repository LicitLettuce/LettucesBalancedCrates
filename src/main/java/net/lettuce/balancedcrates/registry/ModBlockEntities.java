package net.lettuce.balancedcrates.registry;

import net.lettuce.common.blockentity.CrateBlockEntity;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModBlockEntities {
	public static final DeferredRegister<BlockEntityType<?>> REGISTRY =
			DeferredRegister.create(Registries.BLOCK_ENTITY_TYPE, "balanced_crates");

	public static final Supplier<BlockEntityType<CrateBlockEntity>> CRATE =
			REGISTRY.register("crate", () -> BlockEntityType.Builder.of(CrateBlockEntity::new,
					ModBlocks.allCrates()).build(null));
}