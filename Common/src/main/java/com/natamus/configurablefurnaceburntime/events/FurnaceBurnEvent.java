package com.natamus.configurablefurnaceburntime.events;

import com.natamus.configurablefurnaceburntime.config.ConfigHandler;

import net.minecraft.world.item.ItemStack;

public class FurnaceBurnEvent {
	public static int furnaceBurnTimeEvent(ItemStack itemStack, int burntime) {
		return (int)Math.ceil(burntime * ConfigHandler.burnTimeModifier);
	}
}
