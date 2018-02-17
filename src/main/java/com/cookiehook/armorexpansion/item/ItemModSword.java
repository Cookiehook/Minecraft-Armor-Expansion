package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword {
	
	/**
	 * Creates a sword object, using the following parameters:
	 * @param material - The ToolMaterial needed. This sets properties such as efficiency, durability reduction etc.
	 * @param name - Name used for unlocalised name.
	 */
	public ItemModSword(ToolMaterial toolMaterial, String name) {
		//Passes the toolMaterial parameter to the ItemSword constructor, which actually does the work.
		super(toolMaterial);
		setUnlocalizedName(name);
		setCreativeTab(ModTabs.getToolsTab());
	}
}