package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.item.ItemHoe;

public class ItemModHoe extends ItemHoe {

	/**
	 * Creates a hoe object, using the following parameters:
	 * @param material - The ToolMaterial needed. This sets properties such as efficiency, durability reduction etc.
	 * @param name - Name used for unlocalised and registry name.
	 */
	public ItemModHoe(ToolMaterial toolMaterial, String name) {
		//Passes the toolMaterial parameter to the ItemHoe constructor, which actually does the work.
		super(toolMaterial);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModTabs.getToolsTab());
	}
}