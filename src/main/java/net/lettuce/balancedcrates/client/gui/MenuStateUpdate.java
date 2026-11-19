package net.lettuce.balancedcrates.client.gui;

import net.lettuce.balancedcrates.BalancedCrates;
import net.lettuce.balancedcrates.registry.ModScreens;
import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.client.Minecraft;

import net.lettuce.balancedcrates.registry.ModMenus;

@EventBusSubscriber
public record MenuStateUpdate(int elementType, String name, Object elementState) implements CustomPacketPayload {
	public static final Type<MenuStateUpdate> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(BalancedCrates.MOD_ID, "guistate_update"));
	public static final StreamCodec<RegistryFriendlyByteBuf, MenuStateUpdate> STREAM_CODEC = StreamCodec.of(MenuStateUpdate::write, MenuStateUpdate::read);

	public static void write(FriendlyByteBuf buffer, MenuStateUpdate message) {
		buffer.writeInt(message.elementType);
		buffer.writeUtf(message.name);
		if (message.elementType == 0) {
			buffer.writeUtf((String) message.elementState);
		} else if (message.elementType == 1) {
			buffer.writeBoolean((boolean) message.elementState);
		} else if (message.elementType == 2 && message.elementState instanceof Number n) {
			buffer.writeDouble(n.doubleValue());
		}
	}

	public static MenuStateUpdate read(FriendlyByteBuf buffer) {
		int elementType = buffer.readInt();
		String name = buffer.readUtf();
		Object elementState = null;
		if (elementType == 0) {
			elementState = buffer.readUtf();
		} else if (elementType == 1) {
			elementState = buffer.readBoolean();
		} else if (elementType == 2) {
			elementState = buffer.readDouble();
		}
		return new MenuStateUpdate(elementType, name, elementState);
	}

	@Override
	public Type<MenuStateUpdate> type() {
		return TYPE;
	}

	public static void handleMenuState(final MenuStateUpdate message, final IPayloadContext context) {
		if (message.name.length() > 256 || message.elementState instanceof String string && string.length() > 8192)
			return;
		context.enqueueWork(() -> {
			if (context.player().containerMenu instanceof ModMenus.MenuAccessor menu) {
				menu.getMenuState().put(message.elementType + ":" + message.name, message.elementState);
				if (context.flow() == PacketFlow.CLIENTBOUND && Minecraft.getInstance().screen instanceof ModScreens.ScreenAccessor accessor) {
					accessor.updateMenuState(message.elementType, message.name, message.elementState);
				}
			}
		}).exceptionally(e -> {
			context.connection().disconnect(Component.literal(e.getMessage()));
			return null;
		});
	}

	@SubscribeEvent
	public static void registerMessage(FMLCommonSetupEvent event) {
		BalancedCrates.addNetworkMessage(MenuStateUpdate.TYPE, MenuStateUpdate.STREAM_CODEC, MenuStateUpdate::handleMenuState);
	}
}