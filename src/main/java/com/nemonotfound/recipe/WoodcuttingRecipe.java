package com.nemonotfound.recipe;

import com.nemonotfound.NemosWoodcutter;
import com.nemonotfound.block.ModBlocks;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.recipe.CuttingRecipe;
import net.minecraft.recipe.Ingredient;
import net.minecraft.util.Identifier;
import net.minecraft.world.World;

public class WoodcuttingRecipe
extends CuttingRecipe {

    public WoodcuttingRecipe(Identifier id, String group, Ingredient input, ItemStack output) {
        super(NemosWoodcutter.WOODCUTTING, NemosWoodcutter.WOODCUTTING_RECIPE_RECIPE_SERIALIZER, id, group, input, output);
    }

    @Override
    public boolean matches(Inventory inventory, World world) {
        return this.input.test(inventory.getStack(0));
    }

    @Override
    public ItemStack createIcon() {
        return new ItemStack(ModBlocks.WOODCUTTER_BLOCK);
    }
}

