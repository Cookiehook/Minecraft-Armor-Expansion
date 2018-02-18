package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.Main;
import com.cookiehook.armorexpansion.init.ModItems;
import com.cookiehook.armorexpansion.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemSword;

public class ItemModSword extends ItemSword implements IHasModel {
	
	/**
	 * Creates a sword object, using the following parameters:
	 * @param material - The ToolMaterial needed. This sets properties such as efficiency, durability reduction etc.
	 * @param name - Name used for unlocalised and registry name.
	 */
	public ItemModSword(ToolMaterial toolMaterial, String name) {
		//Passes the toolMaterial parameter to the ItemSword constructor, which actually does the work.
		super(toolMaterial);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.COMBAT);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}