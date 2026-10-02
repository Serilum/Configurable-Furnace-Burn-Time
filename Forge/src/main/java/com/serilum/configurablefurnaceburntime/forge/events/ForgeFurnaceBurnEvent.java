package com.serilum.configurablefurnaceburntime.forge.events;

import com.serilum.configurablefurnaceburntime.events.FurnaceBurnEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class ForgeFurnaceBurnEvent {
	@SubscribeEvent
	public static void furnaceBurnTimeEvent(FurnaceFuelBurnTimeEvent e) {
		int burnTime = e.getBurnTime();
		int newBurnTime = FurnaceBurnEvent.furnaceBurnTimeEvent(e.getItemStack(), burnTime);

		if (burnTime != newBurnTime) {
			e.setBurnTime(newBurnTime);
		}
	}
}
