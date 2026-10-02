package com.serilum.configurablefurnaceburntime.neoforge.events;

import com.serilum.configurablefurnaceburntime.events.FurnaceBurnEvent;
import net.neoforged.neoforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.neoforged.bus.api.SubscribeEvent;

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
