package com.cookiehook.armorexpansion;

import com.cookiehook.armorexpansion.init.ModItems;

import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModRecipes {

	/**
	 * Registers furnace recipes into the game.
	 * All crafting table recipes are now implemented in .json files in assets\MOD_ID\recipes.
	 */
	public static void addSmeltingRecipes() {
		/*
		 * The addSmelting method is an overloaded method. This means there are multiple copies that can take different arguments.
		 * The first takes an input itemstack, which allows you to set metadata on the item.
		 * The second takes an input item, with default metadata.
		 * In both methods, the second argument is the output, third argument is the amount of XP recieved.
		 * Some vanilla XP values are:
		 *  Iron - 0.7F
		 *  Gold - 1.0F
		 *  Food - 0.35F
		 *  Sand - 0.1F
		 */
		GameRegistry.addSmelting(new ItemStack(Items.DYE, 1, 4), new ItemStack(ModItems.lapis_lazuli_ingot), 1.0F);
		GameRegistry.addSmelting(Items.REDSTONE, new ItemStack(ModItems.redstone_ingot), 1.0F);
		GameRegistry.addSmelting(Items.QUARTZ, new ItemStack(ModItems.quartz_ingot), 1.0F);
		GameRegistry.addSmelting(Items.GLOWSTONE_DUST, new ItemStack(ModItems.glowstone_ingot), 1.0F);
	}
	
}
