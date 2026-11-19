package net.lettuce.balancedcrates.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.lettuce.balancedcrates.registry.ModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CrateGUIScreen extends AbstractContainerScreen<CrateGUIMenu> implements ModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	private Button button_close_crate;
	private static final ResourceLocation BACKGROUND = ResourceLocation.parse("balanced_crates:textures/screens/crate_gui.png");

	public CrateGUIScreen(CrateGUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 222;
		this.imageHeight = 223;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		boolean customTooltipShown = false;
		if (mouseX > leftPos + 160 && mouseX < leftPos + 184 && mouseY > topPos + -7 && mouseY < topPos + 17) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.balanced_crates.crate_gui.tooltip_closes_crate_and_inventory_when"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 145 && mouseX < leftPos + 169 && mouseY > topPos + -7 && mouseY < topPos + 17) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.balanced_crates.crate_gui.tooltip_closed_crate_and_inventory_when"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 180 && mouseX < leftPos + 204 && mouseY > topPos + -8 && mouseY < topPos + 16) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.balanced_crates.crate_gui.tooltip_closes_crate_and_inventory_when1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 126 && mouseX < leftPos + 150 && mouseY > topPos + -7 && mouseY < topPos + 17) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.balanced_crates.crate_gui.tooltip_empty"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (mouseX > leftPos + 183 && mouseX < leftPos + 207 && mouseY > topPos + -7 && mouseY < topPos + 17) {
			guiGraphics.renderTooltip(font, Component.translatable("gui.balanced_crates.crate_gui.tooltip_empty1"), mouseX, mouseY);
			customTooltipShown = true;
		}
		if (!customTooltipShown)
			this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(BACKGROUND, this.leftPos, this.topPos, 0, 0, this.imageWidth, this.imageHeight, this.imageWidth, this.imageHeight);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
		guiGraphics.drawString(this.font, Component.translatable("gui.balanced_crates.crate_gui.label_inventory"), 31, 129, -12829636, false);
		guiGraphics.drawString(this.font, Component.translatable("gui.balanced_crates.crate_gui.label_crate"), 14, 7, -12829636, false);
	}

	@Override
	public void init() {
		super.init();
		button_close_crate = Button.builder(Component.translatable("gui.balanced_crates.crate_gui.button_close_crate"), e -> {
			int x = CrateGUIScreen.this.x;
			int y = CrateGUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CrateGUIButton(0, x, y, z));
				CrateGUIButton.handleButtonAction(entity, 0, x, y, z);
			}
		}).bounds(this.leftPos + 126, this.topPos + -4, 82, 20).build();
		this.addRenderableWidget(button_close_crate);
	}
}