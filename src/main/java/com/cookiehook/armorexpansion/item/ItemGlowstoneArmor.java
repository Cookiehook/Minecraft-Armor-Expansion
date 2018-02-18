package com.cookiehook.armorexpansion.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemGlowstoneArmor extends BaseArmor {
	
	/**
	 * Creates an armor object, using the following parameters.
	 * @param material - The ArmorMaterial needed. This sets properties such as durability, damage reduction etc.
	 * @param renderIndex - Used by vanilla armor to choose a texture. We override this with the ArmorMaterial.
	 * @param armorType - Whether this is a helmet, chestplate, leggings or boots. Uses EntityEquipmenSlot Enum values as arguments
	 * @param name - Name used for unlocalised and registry name.
	 */
	public ItemGlowstoneArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String name) {
		//This super call passes all the arguments to the BaseArmor constructor, which actually does the work.
		super(material, renderIndex, armorType, name);
	}

	/*
	 * Called every time the armor is updated by vanilla minecraft (20 times per second).
	 * This checks that the armor in each slot (head, chest, legs, feet) is this type of armor.
	 * If this is true, the potion effect is added for 210 ticks (10.5 seconds).
	 * 210 ticks are used here as the NightVision effect starts to fluctuate below 10 seconds.
	 * The result of this is players having the potion effect, only when wearing the entire armor set.
	 */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if (	player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof ItemGlowstoneArmor
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemGlowstoneArmor
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof ItemGlowstoneArmor
				&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof ItemGlowstoneArmor) {
			player.addPotionEffect(new PotionEffect(MobEffects.NIGHT_VISION, 210, 0, false, false));
			player.addPotionEffect(new PotionEffect(MobEffects.GLOWING, 10, 0, false, false));
		}
	}
}
