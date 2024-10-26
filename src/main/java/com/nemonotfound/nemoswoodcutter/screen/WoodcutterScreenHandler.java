package com.nemonotfound.nemoswoodcutter.screen;

import com.nemonotfound.nemoswoodcutter.NemosWoodcutter;
import com.nemonotfound.nemoswoodcutter.block.ModBlocks;
import com.nemonotfound.nemoswoodcutter.recipe.WoodcuttingRecipe;
import com.nemonotfound.nemoswoodcutter.recipe.display.WoodcuttingRecipeDisplay;
import net.minecraft.client.world.ClientWorld;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.CraftingResultInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.RecipeEntry;
import net.minecraft.recipe.input.SingleStackRecipeInput;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.world.World;

import java.util.List;
import java.util.Optional;

//TODO: Needs refactoring
public class WoodcutterScreenHandler
extends ScreenHandler {

    private final ScreenHandlerContext context;
    private final Property selectedRecipe = Property.create();
    private final World world;
    private WoodcuttingRecipeDisplay.Grouping availableRecipes = WoodcuttingRecipeDisplay.Grouping.empty();
    private ItemStack inputStack = ItemStack.EMPTY;
    long lastTakeTime;
    final Slot inputSlot;
    final Slot outputSlot;
    Runnable contentsChangedListener = () -> {};
    public final Inventory input = new SimpleInventory(1){

        @Override
        public void markDirty() {
            super.markDirty();
            WoodcutterScreenHandler.this.onContentChanged(this);
            WoodcutterScreenHandler.this.contentsChangedListener.run();
        }
    };

    final CraftingResultInventory output = new CraftingResultInventory();

    public WoodcutterScreenHandler(int syncId, PlayerInventory playerInventory) {
        this(syncId, playerInventory, ScreenHandlerContext.EMPTY);
    }

    public WoodcutterScreenHandler(int syncId, PlayerInventory playerInventory, final ScreenHandlerContext context) {
        super(NemosWoodcutter.WOODCUTTER_SCREEN_HANDLER, syncId);
        int i;
        this.context = context;
        this.world = playerInventory.player.getWorld();
        this.inputSlot = this.addSlot(new Slot(this.input, 0, 20, 33));
        this.outputSlot = this.addSlot(new Slot(this.output, 1, 143, 33) {

            @Override
            public boolean canInsert(ItemStack stack) {
                return false;
            }

            @Override
            public void onTakeItem(PlayerEntity player, ItemStack stack) {
                stack.onCraftByPlayer(player.getWorld(), player, stack.getCount());
                WoodcutterScreenHandler.this.output.unlockLastRecipe(player, this.getInputStacks());
                int recipeInputCount = availableRecipes.entries().get(selectedRecipe.get()).inputCount();
                ItemStack itemStack = WoodcutterScreenHandler.this.inputSlot.takeStack(recipeInputCount);

                if (!itemStack.isEmpty()) {
                    WoodcutterScreenHandler.this.populateResult(WoodcutterScreenHandler.this.selectedRecipe.get());
                }
                context.run((world, pos) -> {
                    long l = world.getTime();
                    if (WoodcutterScreenHandler.this.lastTakeTime != l) {
                        world.playSound(null, pos, SoundEvents.UI_STONECUTTER_TAKE_RESULT,
                                SoundCategory.BLOCKS, 1.0f, 1.0f);
                        WoodcutterScreenHandler.this.lastTakeTime = l;
                    }
                });
                super.onTakeItem(player, stack);
            }

            private List<ItemStack> getInputStacks() {
                return List.of(WoodcutterScreenHandler.this.inputSlot.getStack());
            }
        });

        for (i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
            }
        }

        for (i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 142));
        }

        this.addProperty(this.selectedRecipe);
    }

    public int getSelectedRecipe() {
        return this.selectedRecipe.get();
    }

    public WoodcuttingRecipeDisplay.Grouping getAvailableRecipes() {
        return this.availableRecipes;
    }

    public int getAvailableRecipeCount() {
        return this.availableRecipes.size();
    }

    public boolean canCraft() {
        return this.inputSlot.hasStack() && !this.availableRecipes.isEmpty();
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return WoodcutterScreenHandler.canUse(this.context, player, ModBlocks.WOODCUTTER);
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (this.isInBounds(id)) {
            this.selectedRecipe.set(id);
            this.populateResult(id);
        }

        return true;
    }

    private boolean isInBounds(int id) {
        return id >= 0 && id < this.availableRecipes.size();
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        ItemStack itemStack = this.inputSlot.getStack();

        if (!itemStack.isOf(this.inputStack.getItem())) {
            this.inputStack = itemStack.copy();
            this.updateInput(itemStack);
        }
    }

    private void updateInput(ItemStack stack) {
        this.selectedRecipe.set(-1);
        this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);

        if (!stack.isEmpty()) {
            if (this.world instanceof ServerWorld serverWorld) {
                this.availableRecipes = serverWorld.getRecipeManager().nemo_sWoodcutter$getWoodcutterRecipes().filter(stack);
            } else if (this.world instanceof ClientWorld clientWorld) {
                this.availableRecipes = clientWorld.nemo_sWoodcutter$getModRecipeManager().getWoodcutterRecipes().filter(stack);
            }
        } else {
            this.availableRecipes = WoodcuttingRecipeDisplay.Grouping.empty();
        }
    }

    private void populateResult(int selectedId) {
        Optional<RecipeEntry<WoodcuttingRecipe>> optionalRecipe;

        if (!this.availableRecipes.isEmpty() && this.isInBounds(selectedId)) {
            WoodcuttingRecipeDisplay.GroupEntry groupEntry = this.availableRecipes.entries().get(selectedId);
            optionalRecipe = groupEntry.recipe().recipe();

        } else {
            optionalRecipe = Optional.empty();
        }

        optionalRecipe.ifPresentOrElse(
                recipeEntry -> {
                    WoodcuttingRecipe woodcuttingRecipe = recipeEntry.value();
                    var inputCount = inputSlot.getStack().getCount();

                    if (inputCount < woodcuttingRecipe.inputCount()) {
                        this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
                        this.output.setLastRecipe(null);
                    } else {
                        this.output.setLastRecipe(recipeEntry);
                        this.outputSlot.setStackNoCallbacks(woodcuttingRecipe.craft(createRecipeInput(), this.world.getRegistryManager()));
                    }
                },
                () -> {
                    this.outputSlot.setStackNoCallbacks(ItemStack.EMPTY);
                    this.output.setLastRecipe(null);
                }
        );

        this.sendContentUpdates();
    }

    private SingleStackRecipeInput createRecipeInput() {
        return new SingleStackRecipeInput(this.input.getStack(0));
    }

    @Override
    public ScreenHandlerType<?> getType() {
        return NemosWoodcutter.WOODCUTTER_SCREEN_HANDLER;
    }

    public void setContentsChangedListener(Runnable contentsChangedListener) {
        this.contentsChangedListener = contentsChangedListener;
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return slot.inventory != this.output && super.canInsertIntoSlot(stack, slot);
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2 != null && slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            Item item = itemStack2.getItem();
            itemStack = itemStack2.copy();
            if (slot == 1) {
                item.onCraftByPlayer(itemStack2, player.getWorld(), player);
                if (!this.insertItem(itemStack2, 2, 38, true)) {
                    return ItemStack.EMPTY;
                }

                slot2.onQuickTransfer(itemStack2, itemStack);
            } else if (slot == 0) {
                if (!this.insertItem(itemStack2, 2, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (isWoodcuttingRecipe(itemStack2)) {
                if (!this.insertItem(itemStack2, 0, 1, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 2 && slot < 29) {
                if (!this.insertItem(itemStack2, 29, 38, false)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot >= 29 && slot < 38 && !this.insertItem(itemStack2, 2, 29, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            }

            slot2.markDirty();
            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTakeItem(player, itemStack2);
            if (slot == 1) {
                player.dropItem(itemStack2, false);
            }

            this.sendContentUpdates();
        }

        return itemStack;
    }

    private boolean isWoodcuttingRecipe(ItemStack itemStack2) {
        return (this.world instanceof ServerWorld serverWorld &&
                serverWorld.getRecipeManager().nemo_sWoodcutter$getWoodcutterRecipes().contains(itemStack2)) ||
                (this.world instanceof ClientWorld clientWorld &&
                        clientWorld.nemo_sWoodcutter$getModRecipeManager().getWoodcutterRecipes().contains(itemStack2));
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.output.removeStack(1);
        this.context.run((world, pos) -> this.dropInventory(player, this.input));
    }
}

