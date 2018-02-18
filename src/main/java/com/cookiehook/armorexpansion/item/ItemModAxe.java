package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.item.ItemAxe;

public class ItemModAxe extends ItemAxe {	
	
	/**
	 * Creates an axe object, using the following parameters:
	 * @param material - The ToolMaterial needed. This sets properties such as efficiency, durability reduction etc.
	 * @param name - Name used for unlocalised and registry name.
	 */
	public ItemModAxe(ToolMaterial toolMaterial, String name) {
		//Passes the toolMaterial parameter to the ItemAxe constructor, which actually does the work.
		super(toolMaterial, 8.0F, -3.2F);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModTabs.getToolsTab());
	}
}