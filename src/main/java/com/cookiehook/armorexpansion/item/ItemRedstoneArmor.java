package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemRedstoneArmor extends BaseArmor {
	
	/**
	 * Creates an armor object, using the following parameters.
	 * @param material - The ArmorMaterial needed. This sets properties such as durability, damage reduction etc.
	 * @param renderIndex - Used by vanilla armor to choose a texture. We override this with the ArmorMaterial.
	 * @param armorType - Whether this is a helmet, chestplate, leggings or boots. Uses EntityEquipmenSlot Enum values as arguments
	 * @param name - Name used for unlocalised and registry name.
	 */
	public ItemRedstoneArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String name) {
		//This super call passes all the arguments to the BaseArmor constructor, which actually does the work.
		super(material, renderIndex, armorType, name);
	}

	/*
	 * Called every time the armor is updated by vanilla minecraft (20 times per second).
	 * This checks that the armor in each slot (head, chest, legs, feet) is this type of armor. 
	 * If this is true, the fireResistance effect is added for 10 ticks (0.5 seconds).
	 * The result of this is players having the potion effect, only when wearing the entire armor set.
	 */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if (	player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof ItemRedstoneArmor
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemRedstoneArmor
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof ItemRedstoneArmor
				&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof ItemRedstoneArmor) {
			player.addPotionEffect(new PotionEffect(MobEffects.FIRE_RESISTANCE, 10, 0, false, false));
		}
	}
	
	/*
	 * Used to set which material can be used to repair this armor in an anvil.
	 * Unlike ToolMaterial, ArmorMaterial doesn't have a seetRepairMaterial method, so we have to
	 * set it in the class.
	 * Result is that any armor of this class can be repaired using a the item shown below.
	 */
	@Override
	public boolean getIsRepairable(ItemStack armor, ItemStack stack) {
		return stack.getItem() == ModItems.redstone_ingot;
	}
}
