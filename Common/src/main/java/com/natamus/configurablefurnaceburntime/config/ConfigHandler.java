package com.natamus.configurablefurnaceburntime.config;

import com.natamus.collective.config.DuskConfig;
import com.natamus.configurablefurnaceburntime.util.Reference;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class ConfigHandler extends DuskConfig {
	public static HashMap<String, List<String>> configMetaData = new HashMap<String, List<String>>();

	@Entry(min = 0.0, max = 1000.0) public static double burnTimeModifier = 1.0;

	public static void initConfig() {
		configMetaData.put("burnTimeModifier", Arrays.asList(
			"How much the fuel burn time should be modified. It's calculated by default burn time * burnTimeModifier. For example: sticks are by default 100 ticks (5 seconds). A burnTimeModifier of 2.0 makes it 200 ticks (10 seconds)."
		));

		DuskConfig.init(Reference.NAME, Reference.MOD_ID, ConfigHandler.class);
	}
}