package com.cookiehook.armorexpansion.item;

import com.cookiehook.armorexpansion.init.ModItems;
import com.cookiehook.armorexpansion.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemQuartzArmor extends BaseArmor {
	
	/**
	 * Creates an armor item, using the following parameters.
	 * @param material - The ArmorMaterial needed. This sets properties such as durability, efficiency etc.
	 * @param renderIndex - Used by vanilla armor to choose a texture. We override this with getArmorTexture.
	 * @param armorType - Whether this is a helmet (0), chestplate (1), leggings (2) or boots (3).
	 * @param name - Name used for unlocalised name.
	 */
	public ItemQuartzArmor(ArmorMaterial material, int renderIndex, int armorType, String name) {
		//This super call passes all the arguments to the BaseArmor constructor, which actually does the work.
		super(material, renderIndex, armorType, name);
	}

	/*
	 * Called every time the armor is updated by vanilla minecraft (20 times per second).
	 * This checks that the armor in each slot (head, chest, legs, feet) is not empty, and is this
	 * type of armor. If this is true, the fireResistance effect is added for 10 ticks (0.5 seconds).
	 * The result of this is players having the potion effect, only when wearing the entire armor set.
	 */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if (player.getCurrentArmor(3) != null 
				&& player.getCurrentArmor(3).getItem() instanceof ItemQuartzArmor 
				&& player.getCurrentArmor(2) != null 
				&& player.getCurrentArmor(2).getItem() instanceof ItemQuartzArmor
				&& player.getCurrentArmor(1) != null 
				&& player.getCurrentArmor(1).getItem() instanceof ItemQuartzArmor 
				&& player.getCurrentArmor(0) != null 
				&& player.getCurrentArmor(0).getItem() instanceof ItemQuartzArmor) {
			player.addPotionEffect(new PotionEffect(Potion.digSpeed.id, 10, 2));
		}
	}

	/*
	 * Used to set the display texture of the armor when worn.
	 * Leggings use a different texture file to the rest of the armor, hence this if / else statement.
	 */
	@Override
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
		if (armor.getItem() == ModItems.quartz_leggings) {
			return Reference.MOD_ID + ":textures/models/armor/quartz_layer_2.png";
		} else {
			return Reference.MOD_ID + ":textures/models/armor/quartz_layer_1.png";
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
		return stack.getItem() == ModItems.quartz_ingot;
	}
}
