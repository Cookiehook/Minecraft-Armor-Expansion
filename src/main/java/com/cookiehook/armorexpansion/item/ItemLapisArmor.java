package com.cookiehook.armorexpansion.item;

import java.util.Map;

import com.cookiehook.armorexpansion.init.ModItems;
import com.cookiehook.armorexpansion.util.Reference;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLapisArmor extends BaseArmor {
	
	/**
	 * Creates an armor object, using the following parameters.
	 * @param material - The ArmorMaterial needed. This sets properties such as durability, damage reduction etc.
	 * @param renderIndex - Used by vanilla armor to choose a texture. We override this with getArmorTexture.
	 * @param armorType - Whether this is a helmet (0), chestplate (1), leggings (2) or boots (3).
	 * @param name - Name used for unlocalised name.
	 */
	public ItemLapisArmor(ArmorMaterial material, int renderIndex, int armorType, String name) {
		//This super call passes all the arguments to the BaseArmor constructor, which actually does the work.
		super(material, renderIndex, armorType, name);
	}
	/*
	 * Called every time the armor is updated by vanilla minecraft (20 times per second).
	 * This checks that the armor in each slot (head, chest, legs, feet) is not empty, and is this
	 * type of armor. If this is true, the waterBreathing effect is added for 10 ticks (0.5 seconds).
	 * This also handles adding and removing the enchantement.
	 * The result of this is players having the potion effect, only when wearing the entire armor set.
	 */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if (player.getCurrentArmor(3) != null 
				&& player.getCurrentArmor(3).getItem() instanceof ItemLapisArmor 
				&& player.getCurrentArmor(2) != null 
				&& player.getCurrentArmor(2).getItem() instanceof ItemLapisArmor
				&& player.getCurrentArmor(1) != null 
				&& player.getCurrentArmor(1).getItem() instanceof ItemLapisArmor 
				&& player.getCurrentArmor(0) != null 
				&& player.getCurrentArmor(0).getItem() instanceof ItemLapisArmor) {
			player.addPotionEffect(new PotionEffect(Potion.waterBreathing.id, 10, 0));
			
			//Gets a Map (called a dictionary in some languages) containing all the
			//enchantments on this armor, indexed by enchantment ID.
			Map<Integer, Integer> ench = EnchantmentHelper.getEnchantments(armor);
			
			//If the enchantment with ID 6 (aqua affinity) is not on the armor, add it.
			if (!ench.containsKey(6))
				armor.addEnchantment(Enchantment.aquaAffinity, 1);
			//If the enchantment with ID 8 (depth strider) is not on the armor, add it.
			if (!ench.containsKey(8))
				armor.addEnchantment(Enchantment.depthStrider, 3);
		} 
		
		//If the player isn't currently wearing a full set of lapis armor, remove
		//the enchantments from the currently worn armor.
		else {
			Map<Integer, Integer> ench = EnchantmentHelper.getEnchantments(armor);
			ench.remove(6);
			ench.remove(8);
			EnchantmentHelper.setEnchantments(ench, armor);
		}
	}

	/*
	 * Used to set the display texture of the armor when worn.
	 * Leggings use a different texture file to the rest of the armor, hence this if / else statement.
	 */
	@Override
	public String getArmorTexture(ItemStack armor, Entity entity, int slot, String type) {
		if (armor.getItem() == ModItems.lapis_leggings) {
			return Reference.MOD_ID + ":textures/models/armor/lapis_layer_2.png";
		} else {
			return Reference.MOD_ID + ":textures/models/armor/lapis_layer_1.png";
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
		return stack.getItem() == ModItems.lapis_lazuli_ingot;
	}
}
