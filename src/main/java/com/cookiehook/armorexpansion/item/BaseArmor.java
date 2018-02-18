package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModTabs;

import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemArmor;

public class BaseArmor extends ItemArmor {

	/**
	 * Used by each armor type to create an Armor object, setting thhe following properties.
	 * @param material - The ArmorMaterial needed. This sets properties such as durability, efficiency etc.
	 * @param renderIndex - Used by vanilla armor to choose a texture. We override this with getArmorTexture.
	 * @param armorType - Whether this is a helmet, chestplate, leggings or boots. Uses EntityEquipmenSlot Enum values as arguments
	 * @param name - Name used for unlocalised and registry name.
	 */
	public BaseArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String name) {
		//This super passes all of the vanilla armor parameters to ItemArmor, which does the actual work.
		super(material, renderIndex, armorType);
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(ModTabs.getArmorTab());
	}
}
