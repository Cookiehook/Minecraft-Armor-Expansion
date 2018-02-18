package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.item.ItemSpade;

public class ItemModSpade extends ItemSpade {
	/**
	 * Creates a spade object, using the following parameters:
	 * @param material - The ToolMaterial needed. This sets properties such as efficiency, durability reduction etc.
	 * @param name - Name used for unlocalised and registry name.
	 */
	public ItemModSpade(ToolMaterial toolMaterial, String name) {
		//Passes the toolMaterial parameter to the ItemSpade constructor, which actually does the work.
		super(toolMaterial);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModTabs.getToolsTab());
	}

}