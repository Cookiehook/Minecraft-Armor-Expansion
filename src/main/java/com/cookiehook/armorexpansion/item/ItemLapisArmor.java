package com.cookiehook.armorexpansion.item;

import java.util.Map;

import com.cookiehook.armorexpansion.init.ModItems;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLapisArmor extends BaseArmor {
	
	/**
	 * Creates an armor object, using the following parameters.
	 * @param material - The ArmorMaterial needed. This sets properties such as durability, damage reduction etc.
	 * @param renderIndex - Used by vanilla armor to choose a texture. We override this with the ArmorMaterial.
	 * @param armorType - Whether this is a helmet, chestplate, leggings or boots. Uses EntityEquipmenSlot Enum values as arguments
	 * @param name - Name used for unlocalised and registry name.
	 */
	public ItemLapisArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String name) {
		//This super call passes all the arguments to the BaseArmor constructor, which actually does the work.
		super(material, renderIndex, armorType, name);
	}
	/*
	 * Called every time the armor is updated by vanilla minecraft (20 times per second).
	 * This checks that the armor in each slot (head, chest, legs, feet) is not empty, and is this
	 * type of armor. If this is true, the waterBreathing effect is added for 10 ticks (0.5 seconds).
	 * This also handles adding and removing the enchantements.
	 * The result of this is players having the potion effect, only when wearing the entire armor set.
	 */
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
		if (	player.getItemStackFromSlot(EntityEquipmentSlot.HEAD) != null
				&& player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof ItemLapisArmor
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST) != null
				&& player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemLapisArmor
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS) != null
				&& player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof ItemLapisArmor
				&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET) != null
				&& player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof ItemLapisArmor) {
			player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 10, 0, false, false));
			
			//Gets the list of enchantments, then adds aqua affinity (id 6) and depth strider (id 8) to the armor.
			//The map contains the enchantment object, and the amplifier value.
			Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(armor);
			ench.put(Enchantment.getEnchantmentByID(6), 1); //Aqua Affinity I
			ench.put(Enchantment.getEnchantmentByID(8), 3); //Depth Strider III
			EnchantmentHelper.setEnchantments(ench, armor);
		} else {
			//When a full set isn't worn, removes the aqua affinity and depth strider enchantments.
			Map<Enchantment, Integer> ench = EnchantmentHelper.getEnchantments(armor);
			ench.remove(Enchantment.getEnchantmentByID(6));
			ench.remove(Enchantment.getEnchantmentByID(8));
			EnchantmentHelper.setEnchantments(ench, armor);
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
