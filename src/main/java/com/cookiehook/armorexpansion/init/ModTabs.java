package com.cookiehook.armorexpansion.init;

import com.cookiehook.armorexpansion.tabs.ArmourTab;
import com.cookiehook.armorexpansion.tabs.ToolsTab;

import net.minecraft.creativetab.CreativeTabs;

public class ModTabs {

	/*
	 * Creates and initialises a new creative tab, to be used later.
	 * It is good practise to keep variables private, and access them through getter methods.
	 */
	private static final CreativeTabs tabarmor = new ArmourTab("tabArmor");
	private static final CreativeTabs tabtools = new ToolsTab("tabTools");

	/** Gets the armorTab, to be used in setCreativeTab methods*/
	public static CreativeTabs getArmorTab() {
		return tabarmor;
	}

	/** Gets the toolsTab, to be used in setCreativeTab methods*/
	public static CreativeTabs getToolsTab() {
		return tabtools;
	}
}
