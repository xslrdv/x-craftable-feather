package com.xslrdv.xcraftablefeather.registry;

import com.xslrdv.xcraftablefeather.XCraftableFeather;

import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(XCraftableFeather.MODID);

    public static final DeferredItem<Item> CANE_FIBERS = ITEMS.registerSimpleItem("cane_fibers");

    public static final DeferredItem<Item> TAR_CLUMP = ITEMS.registerSimpleItem("tar_clump");

    public static final DeferredItem<Item> FEATHER_BLANK = ITEMS.registerSimpleItem("feather_blank");
        
    public static void register(IEventBus bus) {
        ITEMS.register(bus);
    }
}
