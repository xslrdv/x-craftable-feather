package com.xslrdv.xcraftablefeather.registry;

import net.minecraft.world.item.CreativeModeTabs;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

public class ModCreativeTabs {
    private static void addToTabs(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.accept(ModItems.CANE_FIBERS);
            event.accept(ModItems.TAR_CLUMP);
            event.accept(ModItems.FEATHER_BLANK);
        }
    }

    public static void register(IEventBus modEventBus) {
        modEventBus.addListener(ModCreativeTabs::addToTabs);
    }
}
