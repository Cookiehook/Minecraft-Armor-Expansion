package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.Main;
import com.cookiehook.armorexpansion.init.ModItems;
import com.cookiehook.armorexpansion.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class ItemModHoe extends ItemHoe implements IHasModel {

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
		setCreativeTab(CreativeTabs.TOOLS);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}