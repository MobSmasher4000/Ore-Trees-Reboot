package org.mob.ore_trees_reboot.screen.custom;

import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Inventory;
import org.mob.ore_trees_reboot.Ore_trees_reboot;
import org.mob.ore_trees_reboot.inventory.EnergyBarWidget;

import java.util.List;

import static org.mob.ore_trees_reboot.Ore_trees_reboot.resourceLocation;

public class ResourceProcessorScreen extends AbstractContainerScreen<ResourceProcessorMenu> {
    private static final ResourceLocation GUI_TEXTURE =
            resourceLocation("textures/gui/resource_processor/resource_processor_gui.png");
    private static final ResourceLocation ARROW_TEXTURE =
            resourceLocation("textures/gui/arrow_progress.png");

    public ResourceProcessorScreen(ResourceProcessorMenu menu, Inventory playerInventory, Component title) {
        super(menu, playerInventory, title);
    }

    @Override
    protected void renderBg(GuiGraphics guiGraphics, float v, int i, int i1) {
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);
        RenderSystem.setShaderTexture(0, GUI_TEXTURE);

        int x = ((this.width - imageWidth) / 2);
        int y = ((this.height - imageHeight) / 2);

        guiGraphics.blit(GUI_TEXTURE, x, y, 0, 0, imageWidth, imageHeight + 28);

        this.addRenderableWidget(new EnergyBarWidget(x + 7, y + 17, this.menu::getEnergyStored, this.menu::getMaxEnergyStored));

        renderProgressArrow(guiGraphics, x, y);
    }

    private void renderProgressArrow(GuiGraphics guiGraphics, int x, int y) {
        if(menu.isCrafting()) {
            guiGraphics.blit(ARROW_TEXTURE,x + 80, y + 50, 0, 0, menu.getScaledArrowProgress(), 16, 24, 16);
        }
    }

    @Override
    public void render(GuiGraphics pGuiGraphics, int pMouseX, int pMouseY, float pPartialTick) {
        super.render(pGuiGraphics, pMouseX, pMouseY, pPartialTick);
        this.renderTooltip(pGuiGraphics, pMouseX, pMouseY);
    }

    @Override
    protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
        guiGraphics.drawString(this.font, this.playerInventoryTitle, 8, this.imageHeight - 65, 4210752, false);
        guiGraphics.drawString(this.font, this.title, 8, 6, 4210752, false);

        // --- draw progress text above arrow ---
        int progress = menu.getProgress();
        int maxProgress = menu.getMaxProgress();

        String progressText = progress + " / " + maxProgress;
        int textX = 84 - 17;
        int textY = 52 - 12;

        guiGraphics.drawString(this.font, progressText, textX, textY, 4210752, false);
    }

}