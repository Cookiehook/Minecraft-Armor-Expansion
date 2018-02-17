package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.item.Item;

public class BaseIngot extends Item {

	/**
	 * Uses the input name and MOD_ID from the reference class to set the unlocalised name.
	 * Automatically adds this to the Tools tab from the ModTabs class.
	 * @param name - Name to be used for the unlocalised name.
	 */
	public BaseIngot(String name) {
		setUnlocalizedName(name);
		setCreativeTab(ModTabs.getToolsTab());
	}
}
