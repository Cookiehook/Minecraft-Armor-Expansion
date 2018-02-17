package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.Main;
import com.cookiehook.armorexpansion.help.Reference;
import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.item.Item;

public class BaseIngot extends Item {

	/**
	 * Uses the input name and MOD_ID from the reference class to set the unlocalised and reference names.
	 * Automatically adds this to the Tools tab from the ModTabs class.
	 * @param name - Name to be used for the unlocalised and texture name.
	 */
	public BaseIngot(String name) {
		setUnlocalizedName(name);
		setTextureName(Reference.MOD_ID + ":" + name);
		setCreativeTab(ModTabs.getToolsTab());
	}
}
