package com.xslrdv.xcraftablefeather.recipe;

import com.mojang.serialization.MapCodec;
import com.xslrdv.xcraftablefeather.registry.ModItems;

import net.minecraft.core.NonNullList;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.CraftingInput;
import net.minecraft.world.item.crafting.CustomRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.common.Tags;

public class CaneFibersRecipe extends CustomRecipe {
    public static final CaneFibersRecipe INSTANCE = new CaneFibersRecipe();

    public static final RecipeSerializer<CaneFibersRecipe> SERIALIZER =
            new RecipeSerializer<>(MapCodec.unit(INSTANCE), StreamCodec.unit(INSTANCE));

    private static final int FIBERS_COUNT = 1;

    private CaneFibersRecipe() {}

    private static boolean isShears(ItemStack stack) {
        return stack.is(Items.SHEARS) || stack.is(Tags.Items.TOOLS_SHEAR);
    }

    @Override
    public boolean matches(CraftingInput input, Level level) {
        boolean hasShears = false;
        boolean hasCane = false;
        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (stack.isEmpty()) continue;
            if (isShears(stack) && !hasShears) {
                hasShears = true;
            } else if (stack.is(Items.SUGAR_CANE) && !hasCane) {
                hasCane = true;
            } else {
                return false;
            }
        }
        return hasShears && hasCane;
    }

    @Override
    public ItemStack assemble(CraftingInput input) {
        return new ItemStack(ModItems.CANE_FIBERS.get(), FIBERS_COUNT);
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(CraftingInput input) {
        NonNullList<ItemStack> remaining = NonNullList.withSize(input.size(), ItemStack.EMPTY);
        for (int i = 0; i < input.size(); i++) {
            ItemStack stack = input.getItem(i);
            if (isShears(stack) && stack.isDamageableItem()) {
                ItemStack copy = stack.copy();
                copy.setCount(1);
                copy.setDamageValue(copy.getDamageValue() + 1);
                if (copy.getDamageValue() < copy.getMaxDamage()) {
                    remaining.set(i, copy);
                }
            }
        }
        return remaining;
    }

    @Override
    public RecipeSerializer<? extends CustomRecipe> getSerializer() {
        return SERIALIZER;
    }
}
