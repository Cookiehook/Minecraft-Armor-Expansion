package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.item.ItemArmor;

public class BaseArmor extends ItemArmor {

	/**
	 * Used by each armor type to create an Armor object, setting thhe following properties.
	 * @param material - The ArmorMaterial needed. This sets properties such as durability, efficiency etc.
	 * @param renderIndex - Used by vanilla armor to choose a texture. We override this with getArmorTexture.
	 * @param armorType - Whether this is a helmet (0), chestplate (1), leggings (2) or boots (3).
	 * @param name - Name used for unlocalised name.
	 */
	public BaseArmor(ArmorMaterial material, int renderIndex, int armorType, String name) {
		//This super passes all of the vanilla armor parameters to ItemArmor, which does the actual work.
		super(material, renderIndex, armorType);
		setUnlocalizedName(name);
		setCreativeTab(ModTabs.getArmorTab());
	}

}
