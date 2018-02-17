package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.help.Reference;
import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.item.ItemPickaxe;

public class ItemModPickaxe extends ItemPickaxe {
	
	/**
	 * Creates a pickaxe object, using the following parameters:
	 * @param material - The ToolMaterial needed. This sets properties such as efficiency, durability reduction etc.
	 * @param name - Name used for unlocalised and texture names.
	 */
	public ItemModPickaxe(ToolMaterial toolMaterial, String name) {
		//Passes the toolMaterial parameter to the ItemPickaxe constructor, which actually does the work.
		super(toolMaterial);
		setUnlocalizedName(name);
		setTextureName(Reference.MOD_ID + ":" + name);
		setCreativeTab(ModTabs.getToolsTab());
	}
}
