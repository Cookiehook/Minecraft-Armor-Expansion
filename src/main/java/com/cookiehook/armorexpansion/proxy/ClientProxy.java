package com.cookiehook.armorexpansion.proxy;

import com.cookiehook.armorexpansion.init.ModItems;

public class ClientProxy extends CommonProxy {

	/**
	 * Registers the rendering, only on the client. If this were called on the server, the server would crash.
	 */
	@Override
	public void registerRenders() {
		ModItems.registerRenders();
	}
}
