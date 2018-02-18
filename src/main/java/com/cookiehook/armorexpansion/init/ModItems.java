package com.cookiehook.armorexpansion.init;

import java.util.ArrayList;
import java.util.List;

import com.cookiehook.armorexpansion.item.BaseIngot;
import com.cookiehook.armorexpansion.item.ItemEmeraldArmor;
import com.cookiehook.armorexpansion.item.ItemGlowstoneArmor;
import com.cookiehook.armorexpansion.item.ItemLapisArmor;
import com.cookiehook.armorexpansion.item.ItemModAxe;
import com.cookiehook.armorexpansion.item.ItemModHoe;
import com.cookiehook.armorexpansion.item.ItemModPickaxe;
import com.cookiehook.armorexpansion.item.ItemModSpade;
import com.cookiehook.armorexpansion.item.ItemModSword;
import com.cookiehook.armorexpansion.item.ItemQuartzArmor;
import com.cookiehook.armorexpansion.item.ItemRedstoneArmor;
import com.cookiehook.armorexpansion.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModItems {

	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
	/*
	 * 
	 * The Tool Material and Armor Material blocks create a new material to be used
	 * by these items. Materials control properties such as harvest level, damage
	 * reduction, enchantibility etc.
	 */

	/*
	 * Unlike most modding tutorials, I have used Constructors for each item to
	 * automatically set the unlocalisedName, registryName and creativeTab. This
	 * reduces the amount of code needed to add a new item. The constructor looks
	 * like "BaseIngot("lapis_lazuli_ingot")", which takes in different arguments.
	 * When using Eclipse, hover over the constructor to see what each parameter is
	 * for.
	 */

	// Ingots
	/*
	 * Initialises each ingot item as a new object, setting names in the
	 * constructor.
	 */
	public static Item lapis_lazuli_ingot = new BaseIngot("lapis_lazuli_ingot");
	public static Item redstone_ingot = new BaseIngot("redstone_ingot");
	public static Item quartz_ingot = new BaseIngot("quartz_ingot");
	public static Item glowstone_ingot = new BaseIngot("glowstone_ingot");

	/*
	 * A tool material defines how durable and effective a tool will be.
	 * The addToolMaterial takes the following inputs: 
	 * String name - The used for the list of tool materials. 
	 * int harvestLevel - What level of block it can break. 
	 * int maxUses - Durability. 
	 * float efficiency - How fast it breaks a block 
	 * float damage - How much damage is dealt when used as a weapon. 
	 * int enchantability - Chance of getting a high level enchantment.
	 * 
	 * Vanilla values (excluding names) are: 
	 * WOOD(0, 59, 2.0F, 0.0F, 15), 
	 * STONE(1, 131, 4.0F, 1.0F, 5),
	 * IRON(2, 250, 6.0F, 2.0F, 14),
	 * DIAMOND(3, 1561, 8.0F, 3.0F, 10),
	 * GOLD(0, 32, 12.0F, 0.0F, 22);
	 */
	public static ToolMaterial LapisToolMaterial = EnumHelper.addToolMaterial("LapisToolMaterial", 2, 200, 7.0F, 2.0F, 20);
	public static ToolMaterial RedstoneToolMaterial = EnumHelper.addToolMaterial("RedstoneToolMaterial", 2, 200, 7.0F, 2.0F, 20);
	public static ToolMaterial QuartzToolMaterial = EnumHelper.addToolMaterial("QuartzToolMaterial", 2, 200, 7.0F, 2.0F, 20);
	public static ToolMaterial GlowstoneToolMaterial = EnumHelper.addToolMaterial("GlowstoneToolMaterial", 2, 200, 7.0F, 2.0F, 20);
	public static ToolMaterial EmeraldToolMaterial = EnumHelper.addToolMaterial("EmeraldToolMaterial", 4, 2000, 12.0F, 4.0F, 22);

	/*
	 * An armor material defines how durable and effective a piece of armor will be.
	 * The addArmorMaterial takes the following inputs: 
	 * String name - The used for the list of armor materials. 
	 * String textureName - This registers the armor_layer_1 and armor_layer_2 textures in textures/models/armor. For example:
	 * 		If your texture files are called emerald_layer_1 and emerald_layer_2, the textureName should be MOD_ID:emerald.
	 * int durability - How much damage the armor can take 
	 * int[] reductionAmounts - An array determining how much damage the helmet, chestplate, leggings and boot reduce when hit. 
	 * int enchantability - Chance of getting a high level enchantment.
	 * SoundEvent soundOnEquip - Sound played when armor is equipped.
	 * float toughness - Hack used to make diamond a little tougher. Set to 0.0F for all other armors.
	 * 
	 * 
	 * Vanilla values (excluding texture name) are:
	 * LEATHER("leather", 5, new int[]{1, 2, 3, 1}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F),
	 * CHAIN("chainmail", 15, new int[]{1, 4, 5, 2}, 12, SoundEvents.ITEM_ARMOR_EQUIP_CHAIN, 0.0F),
	 * IRON("iron", 15, new int[]{2, 5, 6, 2}, 9, SoundEvents.ITEM_ARMOR_EQUIP_IRON, 0.0F),
	 * GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F),
	 * DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ITEM_ARMOR_EQUIP_DIAMOND, 2.0F);
	 */
	public static ArmorMaterial LapisArmorMaterial = EnumHelper.addArmorMaterial("LapisArmorMaterial", Reference.MOD_ID + ":lapis", 10, new int[] { 2, 6, 5, 2 }, 30, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	public static ArmorMaterial RedstoneArmorMaterial = EnumHelper.addArmorMaterial("RedstoneArmorMaterial", Reference.MOD_ID + ":redstone", 10, new int[] { 2, 6, 5, 2 },14, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	public static ArmorMaterial QuartzArmorMaterial = EnumHelper.addArmorMaterial("QuartzArmorMaterial", Reference.MOD_ID + ":quartz", 10, new int[] { 2, 6, 5, 2 }, 14, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	public static ArmorMaterial GlowstoneArmorMaterial = EnumHelper.addArmorMaterial("GlowstoneArmorMaterial", Reference.MOD_ID + ":glowstone", 10,	new int[] { 2, 6, 5, 2 }, 14, SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);
	public static ArmorMaterial EmeraldArmorMaterial = EnumHelper.addArmorMaterial("EmeraldArmorMaterial", Reference.MOD_ID + ":emerald", 40, new int[] { 4, 8, 6, 4 }, 20,	SoundEvents.ITEM_ARMOR_EQUIP_GOLD, 0.0F);

	// Tools
	public static Item lapis_sword = new ItemModSword(LapisToolMaterial, "lapis_sword");
	public static Item lapis_pickaxe = new ItemModPickaxe(LapisToolMaterial, "lapis_pickaxe");
	public static Item lapis_spade = new ItemModSpade(LapisToolMaterial, "lapis_spade");
	public static Item lapis_axe = new ItemModAxe(LapisToolMaterial, "lapis_axe");
	public static Item lapis_hoe = new ItemModHoe(LapisToolMaterial, "lapis_hoe");

	public static Item redstone_sword = new ItemModSword(RedstoneToolMaterial, "redstone_sword");
	public static Item redstone_pickaxe = new ItemModPickaxe(RedstoneToolMaterial, "redstone_pickaxe");
	public static Item redstone_spade = new ItemModSpade(RedstoneToolMaterial, "redstone_spade");
	public static Item redstone_axe = new ItemModAxe(RedstoneToolMaterial, "redstone_axe");
	public static Item redstone_hoe = new ItemModHoe(RedstoneToolMaterial, "redstone_hoe");

	public static Item quartz_sword = new ItemModSword(QuartzToolMaterial, "quartz_sword");
	public static Item quartz_pickaxe = new ItemModPickaxe(QuartzToolMaterial, "quartz_pickaxe");
	public static Item quartz_spade = new ItemModSpade(QuartzToolMaterial, "quartz_spade");
	public static Item quartz_axe = new ItemModAxe(QuartzToolMaterial, "quartz_axe");
	public static Item quartz_hoe = new ItemModHoe(QuartzToolMaterial, "quartz_hoe");

	public static Item glowstone_sword = new ItemModSword(GlowstoneToolMaterial, "glowstone_sword");
	public static Item glowstone_pickaxe = new ItemModPickaxe(GlowstoneToolMaterial, "glowstone_pickaxe");
	public static Item glowstone_spade = new ItemModSpade(GlowstoneToolMaterial, "glowstone_spade");
	public static Item glowstone_axe = new ItemModAxe(GlowstoneToolMaterial, "glowstone_axe");
	public static Item glowstone_hoe = new ItemModHoe(GlowstoneToolMaterial, "glowstone_hoe");

	public static Item emerald_sword = new ItemModSword(EmeraldToolMaterial, "emerald_sword");
	public static Item emerald_pickaxe = new ItemModPickaxe(EmeraldToolMaterial, "emerald_pickaxe");
	public static Item emerald_spade = new ItemModSpade(EmeraldToolMaterial, "emerald_spade");
	public static Item emerald_axe = new ItemModAxe(EmeraldToolMaterial, "emerald_axe");
	public static Item emerald_hoe = new ItemModHoe(EmeraldToolMaterial, "emerald_hoe");

	// Armor
	public static Item lapis_helmet = new ItemLapisArmor(LapisArmorMaterial, 0, EntityEquipmentSlot.HEAD, "lapis_helmet");
	public static Item lapis_chestplate = new ItemLapisArmor(LapisArmorMaterial, 0, EntityEquipmentSlot.CHEST, "lapis_chestplate");
	public static Item lapis_leggings = new ItemLapisArmor(LapisArmorMaterial, 0, EntityEquipmentSlot.LEGS, "lapis_leggings");
	public static Item lapis_boots = new ItemLapisArmor(LapisArmorMaterial, 0, EntityEquipmentSlot.FEET, "lapis_boots");

	public static Item redstone_helmet = new ItemRedstoneArmor(RedstoneArmorMaterial, 0, EntityEquipmentSlot.HEAD, "redstone_helmet");
	public static Item redstone_chestplate = new ItemRedstoneArmor(RedstoneArmorMaterial, 0, EntityEquipmentSlot.CHEST, "redstone_chestplate");
	public static Item redstone_leggings = new ItemRedstoneArmor(RedstoneArmorMaterial, 0, EntityEquipmentSlot.LEGS, "redstone_leggings");
	public static Item redstone_boots = new ItemRedstoneArmor(RedstoneArmorMaterial, 0, EntityEquipmentSlot.FEET, "redstone_boots");

	public static Item quartz_helmet = new ItemQuartzArmor(QuartzArmorMaterial, 0, EntityEquipmentSlot.HEAD, "quartz_helmet");
	public static Item quartz_chestplate = new ItemQuartzArmor(QuartzArmorMaterial, 0, EntityEquipmentSlot.CHEST, "quartz_chestplate");
	public static Item quartz_leggings = new ItemQuartzArmor(QuartzArmorMaterial, 0, EntityEquipmentSlot.LEGS, "quartz_leggings");
	public static Item quartz_boots = new ItemQuartzArmor(QuartzArmorMaterial, 0, EntityEquipmentSlot.FEET, "quartz_boots");

	public static Item glowstone_helmet = new ItemGlowstoneArmor(GlowstoneArmorMaterial, 0, EntityEquipmentSlot.HEAD, "glowstone_helmet");
	public static Item glowstone_chestplate = new ItemGlowstoneArmor(GlowstoneArmorMaterial, 0, EntityEquipmentSlot.CHEST, "glowstone_chestplate");
	public static Item glowstone_leggings = new ItemGlowstoneArmor(GlowstoneArmorMaterial, 0, EntityEquipmentSlot.LEGS, "glowstone_leggings");
	public static Item glowstone_boots = new ItemGlowstoneArmor(GlowstoneArmorMaterial, 0, EntityEquipmentSlot.FEET, "glowstone_boots");

	public static Item emerald_helmet = new ItemEmeraldArmor(EmeraldArmorMaterial, 0, EntityEquipmentSlot.HEAD, "emerald_helmet");
	public static Item emerald_chestplate = new ItemEmeraldArmor(EmeraldArmorMaterial, 0, EntityEquipmentSlot.CHEST, "emerald_chestplate");
	public static Item emerald_leggings = new ItemEmeraldArmor(EmeraldArmorMaterial, 0, EntityEquipmentSlot.LEGS, "emerald_leggings");
	public static Item emerald_boots = new ItemEmeraldArmor(EmeraldArmorMaterial, 0, EntityEquipmentSlot.FEET, "emerald_boots");

	/**
	 * This sets the item used to repair a tool material in an anvil. The
	 * setRepairItem constructor requires an ItemStack. The ItemStack constructor
	 * requires an Item. The result of this is that any tools using the given armor
	 * material can be repaired with the ingot listed below.
	 */
	public static void setRepairMaterials() {

		LapisToolMaterial.setRepairItem(new ItemStack(ModItems.lapis_lazuli_ingot));
		RedstoneToolMaterial.setRepairItem(new ItemStack(ModItems.redstone_ingot));
		QuartzToolMaterial.setRepairItem(new ItemStack(ModItems.quartz_ingot));
		GlowstoneToolMaterial.setRepairItem(new ItemStack(ModItems.glowstone_ingot));
		EmeraldToolMaterial.setRepairItem(new ItemStack(Items.EMERALD));
	}
	
	public static void register() {
		// Ingots
		GameRegistry.register(lapis_lazuli_ingot);
		GameRegistry.register(redstone_ingot);
		GameRegistry.register(quartz_ingot);
		GameRegistry.register(glowstone_ingot);
		// Tools
		GameRegistry.register(lapis_sword);
		GameRegistry.register(lapis_pickaxe);
		GameRegistry.register(lapis_spade);
		GameRegistry.register(lapis_axe);
		GameRegistry.register(lapis_hoe);
		GameRegistry.register(redstone_sword);
		GameRegistry.register(redstone_pickaxe);
		GameRegistry.register(redstone_spade);
		GameRegistry.register(redstone_axe);
		GameRegistry.register(redstone_hoe);
		GameRegistry.register(quartz_sword);
		GameRegistry.register(quartz_pickaxe);
		GameRegistry.register(quartz_spade);
		GameRegistry.register(quartz_axe);
		GameRegistry.register(quartz_hoe);
		GameRegistry.register(glowstone_sword);
		GameRegistry.register(glowstone_pickaxe);
		GameRegistry.register(glowstone_spade);
		GameRegistry.register(glowstone_axe);
		GameRegistry.register(glowstone_hoe);
		GameRegistry.register(emerald_sword);
		GameRegistry.register(emerald_pickaxe);
		GameRegistry.register(emerald_spade);
		GameRegistry.register(emerald_axe);
		GameRegistry.register(emerald_hoe);
		// Armor
		GameRegistry.register(lapis_helmet);
		GameRegistry.register(lapis_chestplate);
		GameRegistry.register(lapis_leggings);
		GameRegistry.register(lapis_boots);
		GameRegistry.register(redstone_helmet);
		GameRegistry.register(redstone_chestplate);
		GameRegistry.register(redstone_leggings);
		GameRegistry.register(redstone_boots);
		GameRegistry.register(quartz_helmet);
		GameRegistry.register(quartz_chestplate);
		GameRegistry.register(quartz_leggings);
		GameRegistry.register(quartz_boots);
		GameRegistry.register(glowstone_helmet);
		GameRegistry.register(glowstone_chestplate);
		GameRegistry.register(glowstone_leggings);
		GameRegistry.register(glowstone_boots);
		GameRegistry.register(emerald_helmet);
		GameRegistry.register(emerald_chestplate);
		GameRegistry.register(emerald_leggings);
		GameRegistry.register(emerald_boots);
	}
	
	/** 
	 * Implements rendering of the items in the inventory. Otherwise we get the black and purple cubes.
	 * Should be called in init.
	 * */
	  public static void registerRenders()
	  {
	    registerRender(lapis_lazuli_ingot);
	    registerRender(redstone_ingot);
	    registerRender(quartz_ingot);
	    registerRender(glowstone_ingot);
	    
	    registerRender(lapis_sword);
	    registerRender(lapis_pickaxe);
	    registerRender(lapis_spade);
	    registerRender(lapis_axe);
	    registerRender(lapis_hoe);
	    registerRender(redstone_sword);
	    registerRender(redstone_pickaxe);
	    registerRender(redstone_spade);
	    registerRender(redstone_axe);
	    registerRender(redstone_hoe);
	    registerRender(quartz_sword);
	    registerRender(quartz_pickaxe);
	    registerRender(quartz_spade);
	    registerRender(quartz_axe);
	    registerRender(quartz_hoe);
	    registerRender(glowstone_sword);
	    registerRender(glowstone_pickaxe);
	    registerRender(glowstone_spade);
	    registerRender(glowstone_axe);
	    registerRender(glowstone_hoe);
	    registerRender(emerald_sword);
	    registerRender(emerald_pickaxe);
	    registerRender(emerald_spade);
	    registerRender(emerald_axe);
	    registerRender(emerald_hoe);
	    
	    registerRender(lapis_helmet);
	    registerRender(lapis_chestplate);
	    registerRender(lapis_leggings);
	    registerRender(lapis_boots);
	    registerRender(redstone_helmet);
	    registerRender(redstone_chestplate);
	    registerRender(redstone_leggings);
	    registerRender(redstone_boots);
	    registerRender(quartz_helmet);
	    registerRender(quartz_chestplate);
	    registerRender(quartz_leggings);
	    registerRender(quartz_boots);
	    registerRender(glowstone_helmet);
	    registerRender(glowstone_chestplate);
	    registerRender(glowstone_leggings);
	    registerRender(glowstone_boots);
	    registerRender(emerald_helmet);
	    registerRender(emerald_chestplate);
	    registerRender(emerald_leggings);
	    registerRender(emerald_boots);
	  }
	  
	  private static void registerRender(Item item)
	  {
	    Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(Reference.MOD_ID + ":" + item.getUnlocalizedName().substring(5), "inventory"));
	  }
}
