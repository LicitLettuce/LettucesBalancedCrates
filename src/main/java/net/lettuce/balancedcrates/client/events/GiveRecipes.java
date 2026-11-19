package net.lettuce.balancedcrates.client.events;

import net.neoforged.neoforge.event.tick.PlayerTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

import java.util.Collections;

@EventBusSubscriber
public class GiveRecipes {
	@SubscribeEvent
	public static void onPlayerTick(PlayerTickEvent.Post event) {
		execute(event, event.getEntity());
	}

	public static void execute(Entity entity) {
		execute(null, entity);
	}

	private static void execute(@Nullable Event event, Entity entity) {
		if (entity == null)
			return;
		if (hasEntityInInventory(entity, new ItemStack(Blocks.CHEST))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.OAK_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:oak_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.SPRUCE_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:spruce_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.BIRCH_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:birch_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.JUNGLE_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:jungle_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.ACACIA_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:acacia_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.DARK_OAK_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:dark_oak_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.MANGROVE_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:mangrove_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.CHERRY_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:cherry_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.BAMBOO_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:bamboo_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.CRIMSON_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:crimson_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.WARPED_PLANKS))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:warped_crate")));
		} else if (hasEntityInInventory(entity, new ItemStack(Blocks.AIR))) {
			if (entity instanceof ServerPlayer _serverPlayer)
				_serverPlayer.awardRecipesByKey(Collections.singletonList(ResourceLocation.parse("balanced_crates:pale_oak_crate")));
		}
	}

	private static boolean hasEntityInInventory(Entity entity, ItemStack itemstack) {
		if (entity instanceof Player player)
			return player.getInventory().contains(stack -> !stack.isEmpty() && ItemStack.isSameItem(stack, itemstack));
		return false;
	}
}