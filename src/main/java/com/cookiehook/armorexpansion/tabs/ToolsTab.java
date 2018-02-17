package com.cookiehook.armorexpansion.tabs;

import com.cookiehook.armorexpansion.init.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ToolsTab extends CreativeTabs {

	/**
	 * Creates a new creative tab object, which requires a name.
	 * @param label - Name used in the list of creative tabs.
	 */
	public ToolsTab(String label) {
		//Label is passed to the CreativeTabs constructor, which actually does the work.
		super(label);
	}

	/**
	 * Called by Minecraft to decide which icon to show in the creative menu.
	 */
	@Override
	public Item getTabIconItem() {
		return ModItems.glowstone_sword;
	}
}