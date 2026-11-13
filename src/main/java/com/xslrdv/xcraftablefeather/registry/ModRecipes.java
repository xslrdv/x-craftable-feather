package com.xslrdv.xcraftablefeather.registry;

import com.xslrdv.xcraftablefeather.XCraftableFeather;
import com.xslrdv.xcraftablefeather.recipe.CaneFibersRecipe;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
        DeferredRegister.create(Registries.RECIPE_SERIALIZER, XCraftableFeather.MODID);

    public static final DeferredHolder<RecipeSerializer<?>, RecipeSerializer<CaneFibersRecipe>> CANE_FIBERS =
        SERIALIZERS.register("cane_fibers", () -> CaneFibersRecipe.SERIALIZER);

    public static void register(IEventBus bus) {
        SERIALIZERS.register(bus);
    }
}
