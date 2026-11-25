package net.lettuce.balancedcrates;

import net.lettuce.balancedcrates.registry.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ItemLike;
import net.neoforged.fml.ModList;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.neoforge.network.registration.PayloadRegistrar;
import net.neoforged.neoforge.network.handling.IPayloadHandler;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.event.tick.ServerTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.util.thread.SidedThreadGroups;
import net.neoforged.fml.common.Mod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.IEventBus;
import net.minecraft.server.TickTask;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.FriendlyByteBuf;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Queue;
import java.util.PriorityQueue;
import java.util.Map;
import java.util.HashMap;
import java.util.Comparator;
import it.unimi.dsi.fastutil.ints.IntObjectPair;
import it.unimi.dsi.fastutil.ints.IntObjectImmutablePair;

@Mod("balanced_crates")
public class BalancedCrates {
	public static final String MOD_ID = "balanced_crates";

	public BalancedCrates(IEventBus modEventBus) {
		NeoForge.EVENT_BUS.register(this);
		modEventBus.addListener(this::registerNetworking);
		ModBlocks.REGISTRY.register(modEventBus);
		ModBlockEntities.REGISTRY.register(modEventBus);
		ModItems.REGISTRY.register(modEventBus);
		ModMenus.REGISTRY.register(modEventBus);
		modEventBus.addListener(this::addCreative);
		ModCreativeTabs.register(modEventBus);
		ModSounds.SOUNDS.register(modEventBus);
	}

	private static boolean networkingRegistered = false;
	private static final Map<CustomPacketPayload.Type<?>, NetworkMessage<?>> MESSAGES = new HashMap<>();

	private record NetworkMessage<T extends CustomPacketPayload>(StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
	}

	private void addCreative(BuildCreativeModeTabContentsEvent event) {
		if (event.getTabKey() != CreativeModeTabs.FUNCTIONAL_BLOCKS)
			return;

		ItemStack last = Items.BARREL.getDefaultInstance();

		last = insertAll(event, last,
				ModItems.CRATE.get(),
				ModItems.OAK_CRATE.get(),
				ModItems.SPRUCE_CRATE.get(),
				ModItems.BIRCH_CRATE.get(),
				ModItems.JUNGLE_CRATE.get(),
				ModItems.ACACIA_CRATE.get(),
				ModItems.DARK_OAK_CRATE.get(),
				ModItems.MANGROVE_CRATE.get(),
				ModItems.CHERRY_CRATE.get(),
				ModItems.BAMBOO_CRATE.get(),
				ModItems.CRIMSON_CRATE.get(),
				ModItems.WARPED_CRATE.get());

		last = insertIfLoaded(event, last, "quark",
				ModItems.AZALEA_CRATE.get(),
				ModItems.ASHEN_CRATE.get(),
				ModItems.TRUMPET_CRATE.get());

		last = insertIfLoaded(event, last, "atmospheric",
				ModItems.ROSEWOOD_CRATE.get(),
				ModItems.MORADO_CRATE.get(),
				ModItems.YUCCA_CRATE.get(),
				ModItems.LAUREL_CRATE.get(),
				ModItems.ASPEN_CRATE.get(),
				ModItems.KOUSA_CRATE.get(),
				ModItems.GRIMWOOD_CRATE.get());

		last = insertIfLoaded(event, last, "environmental",
				ModItems.WILLOW_CRATE.get(),
				ModItems.PINE_CRATE.get(),
				ModItems.PLUM_CRATE.get(),
				ModItems.WISTERIA_CRATE.get());

		last = insertIfLoaded(event, last, "autumnity",
				ModItems.MAPLE_CRATE.get());

		last = insertIfLoaded(event, last, "upgrade_aquatic",
				ModItems.DRIFTWOOD_CRATE.get(),
				ModItems.RIVER_CRATE.get());

		insertIfLoaded(event, last, "caverns_and_chasms",
				ModItems.CCAZALEA_CRATE.get());
	}

	private static ItemStack insertAll(BuildCreativeModeTabContentsEvent event, ItemStack after, ItemLike... items) {
		for (ItemLike item : items) {
			ItemStack stack = item.asItem().getDefaultInstance();
			event.insertAfter(after, stack, CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
			after = stack;
		}
		return after;
	}

	private static ItemStack insertIfLoaded(BuildCreativeModeTabContentsEvent event, ItemStack after, String modId, ItemLike... items) {
		return ModList.get().isLoaded(modId) ? insertAll(event, after, items) : after;
	}


	public static <T extends CustomPacketPayload> void addNetworkMessage(CustomPacketPayload.Type<T> id, StreamCodec<? extends FriendlyByteBuf, T> reader, IPayloadHandler<T> handler) {
		if (networkingRegistered)
			throw new IllegalStateException("Cannot register new network messages after networking has been registered");
		MESSAGES.put(id, new NetworkMessage<>(reader, handler));
	}

	@SuppressWarnings({"rawtypes", "unchecked"})
	private void registerNetworking(final RegisterPayloadHandlersEvent event) {
		final PayloadRegistrar registrar = event.registrar(MOD_ID);
		MESSAGES.forEach((id, networkMessage) -> registrar.playBidirectional(id, ((NetworkMessage) networkMessage).reader(), ((NetworkMessage) networkMessage).handler()));
		networkingRegistered = true;
	}

	private static final Queue<IntObjectPair<Runnable>> workToBeScheduled = new ConcurrentLinkedQueue<>();
	private static final PriorityQueue<TickTask> workQueue = new PriorityQueue<>(Comparator.comparingInt(TickTask::getTick));

	public static void queueServerWork(int delay, Runnable action) {
		if (Thread.currentThread().getThreadGroup() == SidedThreadGroups.SERVER)
			workToBeScheduled.add(new IntObjectImmutablePair<>(delay, action));
	}

	@SubscribeEvent
	public void tick(ServerTickEvent.Post event) {
		int currentTick = event.getServer().getTickCount();
		IntObjectPair<Runnable> work;
		while ((work = workToBeScheduled.poll()) != null) {
			workQueue.add(new TickTask(currentTick + work.leftInt(), work.right()));
		}
		while (!workQueue.isEmpty() && currentTick >= workQueue.peek().getTick()) {
			workQueue.poll().run();
		}
	}
}