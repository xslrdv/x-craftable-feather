package com.xslrdv.xcraftablefeather.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.common.Tags;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(Inventory.class)
public class StackedContentsMixin {

    @WrapOperation(
            method = "isUsableForCrafting",
            at = @At(value = "INVOKE", target = "Lnet/minecraft/world/item/ItemStack;isDamaged()Z")
    )
    private static boolean xcraftablefeather$allowDamagedShears(ItemStack stack, Operation<Boolean> original) {
        if (stack.is(Tags.Items.TOOLS_SHEAR)) {
            return false;
        }
        return original.call(stack);
    }
}
