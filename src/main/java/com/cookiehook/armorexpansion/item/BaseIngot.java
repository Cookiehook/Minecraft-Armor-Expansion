package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.Main;
import com.cookiehook.armorexpansion.init.ModItems;
import com.cookiehook.armorexpansion.util.IHasModel;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class BaseIngot extends Item implements IHasModel {

	/**
	 * Uses the input name to set the unlocalised and registry name.
	 * Automatically adds this to the Tools tab from the ModTabs class.
	 * @param name - Name to be used for the unlocalised and registry name.
	 */
	public BaseIngot(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(CreativeTabs.MATERIALS);
		ModItems.ITEMS.add(this);
	}
	
	@Override
	public void registerModels() {
		Main.proxy.registerItemRenderer(this, 0, "inventory");
	}
}
