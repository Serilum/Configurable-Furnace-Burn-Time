package com.natamus.configurablefurnaceburntime.forge.events;

import com.natamus.configurablefurnaceburntime.events.FurnaceBurnEvent;
import net.minecraftforge.event.furnace.FurnaceFuelBurnTimeEvent;
import net.minecraftforge.eventbus.api.bus.BusGroup;
import net.minecraftforge.eventbus.api.listener.SubscribeEvent;

import java.lang.invoke.MethodHandles;

public class ForgeFurnaceBurnEvent {
	public static void registerEventsInBus() {
		// BusGroup.DEFAULT.register(MethodHandles.lookup(), ForgeFurnaceBurnEvent.class);

		FurnaceFuelBurnTimeEvent.BUS.addListener(ForgeFurnaceBurnEvent::furnaceBurnTimeEvent);
	}

	@SubscribeEvent
	public static void furnaceBurnTimeEvent(FurnaceFuelBurnTimeEvent e) {
		int burnTime = e.getBurnTime();
		int newBurnTime = FurnaceBurnEvent.furnaceBurnTimeEvent(e.getItemStack(), burnTime);

		if (burnTime != newBurnTime) {
			e.setBurnTime(newBurnTime);
		}
	}
}
