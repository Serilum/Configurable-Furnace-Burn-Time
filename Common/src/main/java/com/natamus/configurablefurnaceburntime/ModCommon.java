package com.natamus.configurablefurnaceburntime;

import com.natamus.configurablefurnaceburntime.config.ConfigHandler;

public class ModCommon {

	public static void init() {
		ConfigHandler.initConfig();
		load();
	}

	private static void load() {
		
	}
}