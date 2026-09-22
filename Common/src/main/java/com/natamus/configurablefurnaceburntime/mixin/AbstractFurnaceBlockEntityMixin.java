package com.natamus.configurablefurnaceburntime.mixin;

import com.natamus.configurablefurnaceburntime.events.FurnaceBurnEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.AbstractFurnaceBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = AbstractFurnaceBlockEntity.class, priority = 1001)
public class AbstractFurnaceBlockEntityMixin {
	@Inject(method = "getBurnDuration", at = @At(value = "RETURN"), cancellable = true)
	public void getBurnDuration(ServerLevel serverLevel, ItemStack fuelItem, CallbackInfoReturnable<Integer> cir) {
		if (fuelItem.isEmpty()) {
			return;
		}

		int burnTime = cir.getReturnValue();
		int newBurnTime = FurnaceBurnEvent.furnaceBurnTimeEvent(fuelItem, burnTime);

		if (burnTime != newBurnTime) {
			cir.setReturnValue(newBurnTime);
		}
	}
}
