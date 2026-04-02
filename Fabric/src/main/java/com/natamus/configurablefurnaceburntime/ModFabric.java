package com.natamus.configurablefurnaceburntime;

import com.natamus.collective.check.RegisterMod;
import com.natamus.collective.check.ShouldLoadCheck;
import com.natamus.collective.fabric.callbacks.CollectiveFurnaceEvents;
import com.natamus.configurablefurnaceburntime.events.FurnaceBurnEvent;
import com.natamus.configurablefurnaceburntime.util.Reference;
import net.fabricmc.api.ModInitializer;
import net.minecraft.world.item.ItemStack;

public class ModFabric implements ModInitializer {
	
	@Override
	public void onInitialize() {
		if (!ShouldLoadCheck.shouldLoad(Reference.MOD_ID)) {
			return;
		}

		setGlobalConstants();
		ModCommon.init();

		loadEvents();

		RegisterMod.register(Reference.NAME, Reference.MOD_ID, Reference.VERSION, Reference.ACCEPTED_VERSIONS);
	}

	private void loadEvents() {
		CollectiveFurnaceEvents.CALCULATE_FURNACE_BURN_TIME.register((ItemStack itemStack, int burntime) -> {
			return FurnaceBurnEvent.furnaceBurnTimeEvent(itemStack, burntime);
		});
	}

	private static void setGlobalConstants() {

	}
}
