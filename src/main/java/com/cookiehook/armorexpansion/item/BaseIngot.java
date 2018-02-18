package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.item.Item;

public class BaseIngot extends Item {

	/**
	 * Uses the input name to set the unlocalised and registry name.
	 * Automatically adds this to the Tools tab from the ModTabs class.
	 * @param name - Name to be used for the unlocalised and registry name.
	 */
	public BaseIngot(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModTabs.getToolsTab());
	}
}
