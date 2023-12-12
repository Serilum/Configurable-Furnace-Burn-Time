package com.natamus.configurablefurnaceburntime.neoforge.events;

import com.natamus.configurablefurnaceburntime.events.FurnaceBurnEvent;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber
public class NeoForgeFurnaceBurnEvent {
	@SubscribeEvent
	public static void furnaceBurnTimeEvent(FurnaceFuelBurnTimeEvent e) {
		int burnTime = e.getBurnTime();
		int newBurnTime = FurnaceBurnEvent.furnaceBurnTimeEvent(e.getItemStack(), burnTime);

		if (burnTime != newBurnTime) {
			e.setBurnTime(newBurnTime);
		}
	}
}
