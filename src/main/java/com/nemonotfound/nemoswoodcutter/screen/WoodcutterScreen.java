package com.nemonotfound.nemoswoodcutter.screen;

import com.mojang.datafixers.util.Pair;
import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipe;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.DrawContext;
import net.minecraft.client.gui.screen.ingame.HandledScreen;
import net.minecraft.client.sound.PositionedSoundInstance;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.recipe.Ingredient;
import net.minecraft.sound.SoundEvents;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.MathHelper;

import java.util.List;

import static com.nemonotfound.nemoswoodcutter.NemosWoodcutter.MOD_ID;

@Environment(value = EnvType.CLIENT) //TODO: Whole class needs refactoring
public class WoodcutterScreen extends HandledScreen<WoodcutterScreenHandler> {
    private static final Identifier TEXTURE = new Identifier(MOD_ID, "textures/gui/container/woodcutter.png");
    private float scrollAmount;
    private boolean mouseClicked;
    private int scrollOffset;
    private boolean canCraft;

    public WoodcutterScreen(WoodcutterScreenHandler handler, PlayerInventory inventory, Text title) {
        super(handler, inventory, title);
        handler.setContentsChangedListener(this::onInventoryChange);
        --this.titleY;
    }

    @Override
    public void render(DrawContext context, int mouseX, int mouseY, float delta) {
        super.render(context, mouseX, mouseY, delta);
        this.drawMouseoverTooltip(context, mouseX, mouseY);
    }

    @Override
    protected void drawBackground(DrawContext context, float delta, int mouseX, int mouseY) {
        context.drawTexture(TEXTURE, x, y, 0, 0, this.backgroundWidth, this.backgroundHeight);
        drawScroll(context);

        int xPosForRecipe = this.x + 52;
        int yPosForRecipe = this.y + 14;
        int scrollOffset = this.scrollOffset + 12;
        this.renderRecipeBackground(context, mouseX, mouseY, xPosForRecipe, yPosForRecipe, scrollOffset);
        this.renderRecipeIcons(context, xPosForRecipe, yPosForRecipe, scrollOffset);
    }

    private void drawScroll(DrawContext context) {
        int scrollOffset = (int) (41.0f * this.scrollAmount);
        context.drawTexture(TEXTURE, x + 119, y + 15 + scrollOffset, 176 + (this.shouldScroll() ? 0 : 12), 0, 12, 15);
    }

    @Override
    protected void drawMouseoverTooltip(DrawContext context, int x, int y) {
        super.drawMouseoverTooltip(context, x, y);

        int toolPosX = this.x + 52;
        int toolPosY = this.y + 14;
        int scrollOffset = this.scrollOffset + 12;
        List<WoodcuttingRecipe> availableRecipes = this.handler.getAvailableRecipes();

        for (int l = this.scrollOffset; l < scrollOffset && l < this.handler.getAvailableRecipeCount(); ++l) {
            int m = l - this.scrollOffset;
            int n = toolPosX + m % 4 * 16;
            int o = toolPosY + m / 4 * 18 + 2;
            if (x < n || x >= n + 16 || y < o || y >= o + 18) continue;
            context.drawItemTooltip(this.textRenderer, availableRecipes.get(l)
                    .getOutput(this.client.world.getRegistryManager()), x, y);
        }

    }

    private void renderRecipeBackground(DrawContext context, int mouseX, int mouseY, int xPosForRecipe,
                                        int yPosForRecipe, int scrollOffset) {
        for (int i = this.scrollOffset; i < scrollOffset && i < this.handler.getAvailableRecipeCount(); ++i) {
            int yPosWithoutScrollOffset = i - this.scrollOffset;
            int k = xPosForRecipe + yPosWithoutScrollOffset % 4 * 16;
            int l = yPosWithoutScrollOffset / 4;
            int m = yPosForRecipe + l * 18 + 2;
            int n = this.backgroundHeight;
            int inputCount = this.handler.inputSlot.getStack().getCount();
            WoodcuttingRecipe recipe = this.handler.getAvailableRecipes().get(i);
            Pair<Ingredient, Integer> ingredientPair = recipe.getIngredientPair();
            int requiredInputCount = ingredientPair.getSecond();

            if (i == this.handler.getSelectedRecipe()) {
                n += 54;
            } else if (mouseX >= k && mouseY >= m && mouseX < k + 16 && mouseY < m + 18) {
                n += 36;
            }

            if (inputCount < requiredInputCount) {
                n += 18;

            }
            context.drawTexture(TEXTURE, k, m - 1,  0,n, 16, 18);
        }
    }

    private void renderRecipeIcons(DrawContext context, int x, int y, int scrollOffset) {
        List<WoodcuttingRecipe> availableRecipes = this.handler.getAvailableRecipes();
        for (int i = this.scrollOffset; i < scrollOffset && i < availableRecipes.size(); ++i) {
            int yPosWithoutScrollOffset = i - this.scrollOffset;
            int k = x + yPosWithoutScrollOffset % 4 * 16;
            int l = yPosWithoutScrollOffset / 4;
            int m = y + l * 18 + 2;
            var recipeEntry = availableRecipes.get(i);

            context.drawItem(recipeEntry.getOutput(this.client.world.getRegistryManager()), k, m);
        }
    }

    //TODO: Needs refactoring
    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        this.mouseClicked = false;
        if (this.canCraft) {
            int i = this.x + 52;
            int j = this.y + 14;
            int k = this.scrollOffset + 12;
            for (int l = this.scrollOffset; l < k; ++l) {
                int m = l - this.scrollOffset;
                double d = mouseX - (double) (i + m % 4 * 16);
                double e = mouseY - (double) (j + m / 4 * 18);

                if (!(d >= 0.0) || !(e >= 0.0) || !(d < 16.0) || !(e < 18.0) || !(this.handler).onButtonClick(this.client.player, l)) {
                    continue;
                }

                if (this.handler.getAvailableRecipeCount() > l) {
                    WoodcuttingRecipe recipe = this.handler.getAvailableRecipes().get(l);
                    Pair<Ingredient, Integer> ingredientPair = recipe.getIngredientPair();
                    int requiredInputCount = ingredientPair.getSecond();
                    int inputCount = this.handler.inputSlot.getStack().getCount();

                    if (inputCount < requiredInputCount) {
                        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 4.0f));
                    } else {
                        MinecraftClient.getInstance().getSoundManager().play(PositionedSoundInstance.master(SoundEvents.UI_STONECUTTER_SELECT_RECIPE, 1.0f));
                    }
                }

                this.client.interactionManager.clickButton((this.handler).syncId, l);
                return true;
            }
            i = this.x + 119;
            j = this.y + 9;
            if (mouseX >= (double) i && mouseX < (double) (i + 12) && mouseY >= (double) j && mouseY < (double) (j + 54)) {
                this.mouseClicked = true;
            }
        }
        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double deltaX, double deltaY) {
        if (this.mouseClicked && this.shouldScroll()) {
            int i = this.y + 14;
            int j = i + 54;
            this.scrollAmount = ((float) mouseY - (float) i - 7.5f) / ((float) (j - i) - 15.0f);
            this.scrollAmount = MathHelper.clamp(this.scrollAmount, 0.0f, 1.0f);
            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) this.getMaxScroll()) + 0.5) * 4;

            return true;
        }

        return super.mouseDragged(mouseX, mouseY, button, deltaX, deltaY);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double amount) {
        if (this.shouldScroll()) {
            int i = this.getMaxScroll();
            float f = (float) amount / (float) i;
            this.scrollAmount = MathHelper.clamp(this.scrollAmount - f, 0.0f, 1.0f);
            this.scrollOffset = (int) ((double) (this.scrollAmount * (float) i) + 0.5) * 4;
        }

        return true;
    }

    private boolean shouldScroll() {
        return this.canCraft && (this.handler).getAvailableRecipeCount() > 12;
    }

    protected int getMaxScroll() {
        return ((this.handler).getAvailableRecipeCount() + 4 - 1) / 4 - 3;
    }

    private void onInventoryChange() {
        this.canCraft = (this.handler).canCraft();
        if (!this.canCraft) {
            this.scrollAmount = 0.0f;
            this.scrollOffset = 0;
        }
    }
}

