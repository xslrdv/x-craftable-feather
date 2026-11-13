/*
 * X Craftable Feather - A vanilla-friendly, balanced full crafting cycle for a Feather Blank that smelts into a vanilla Feather. No need to kill animals.
 * Copyright (C) 2026 xslrdv
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Affero General Public License as published
 * by the Free Software Foundation, version 3 of the License.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Affero General Public License for more details.
 *
 * You should have received a copy of the GNU Affero General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.xslrdv.xcraftablefeather;

import com.xslrdv.xcraftablefeather.registry.ModCreativeTabs;
import com.xslrdv.xcraftablefeather.registry.ModItems;
import com.xslrdv.xcraftablefeather.registry.ModRecipes;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(XCraftableFeather.MODID)
public class XCraftableFeather {
    public static final String MODID = "xcraftablefeather";

    public XCraftableFeather(IEventBus modEventBus) {
        ModItems.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModCreativeTabs.register(modEventBus);
    }
}
