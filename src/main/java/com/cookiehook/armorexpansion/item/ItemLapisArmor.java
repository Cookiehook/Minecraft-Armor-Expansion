package com.cookiehook.armorexpansion.item;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentData;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.init.MobEffects;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.ItemEnchantedBook;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

public class ItemLapisArmor extends BaseArmor {

    private static final Enchantment aquaAffinity = Enchantment.getEnchantmentByID(6);
    private static final Enchantment depthStrider = Enchantment.getEnchantmentByID(8);

    /**
     * Creates an armor object, using the following parameters.
     *
     * @param material    - The ArmorMaterial needed. This sets properties such as durability, damage reduction etc.
     * @param renderIndex - Used by vanilla armor to choose a texture. We override this with the ArmorMaterial.
     * @param armorType   - Whether this is a helmet, chestplate, leggings or boots. Uses EntityEquipmenSlot Enum values as arguments
     * @param name        - Name used for unlocalised and registry name.
     */
    public ItemLapisArmor(ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType, String name) {
        //This super call passes all the arguments to the BaseArmor constructor, which actually does the work.
        super(material, renderIndex, armorType, name);
    }

    /*
     * Called every time the armor is updated by vanilla minecraft (20 times per second).
     * This checks that the armor in each slot (head, chest, legs, feet) is this type of armor.
     * If this is true, the waterBreathing effect is added for 10 ticks (0.5 seconds).
     * This also handles adding and removing the enchantements.
     * The result of this is players having the potion effect, only when wearing the entire armor set.
     */
    @Override
    public void onArmorTick(World world, EntityPlayer player, ItemStack armor) {
        Map<Enchantment, Integer> enchantments = EnchantmentHelper.getEnchantments(armor);
        NBTTagList tags = armor.getEnchantmentTagList();

        if (player.getItemStackFromSlot(EntityEquipmentSlot.HEAD).getItem() instanceof ItemLapisArmor
                && player.getItemStackFromSlot(EntityEquipmentSlot.CHEST).getItem() instanceof ItemLapisArmor
                && player.getItemStackFromSlot(EntityEquipmentSlot.LEGS).getItem() instanceof ItemLapisArmor
                && player.getItemStackFromSlot(EntityEquipmentSlot.FEET).getItem() instanceof ItemLapisArmor) {
            player.addPotionEffect(new PotionEffect(MobEffects.WATER_BREATHING, 10, 0, false, false));

            //Gets the list of enchantments, then adds aqua affinity (id 6) and depth strider (id 8) to the armor.
            if (!(enchantments.containsKey(aquaAffinity) && enchantments.containsKey(depthStrider))) {
                NBTTagCompound aquaAffinityTag = new NBTTagCompound();
                aquaAffinityTag.setShort("id", (short) 6);
                aquaAffinityTag.setShort("lvl", (short) 1);

                NBTTagCompound waterBreathingTag = new NBTTagCompound();
                waterBreathingTag.setShort("id", (short) 8);
                waterBreathingTag.setShort("lvl", (short) 3);

                tags.appendTag(aquaAffinityTag);
                tags.appendTag(waterBreathingTag);
            }
        } else {
            //When a full set isn't worn, removes the aqua affinity and depth strider enchantments.
            if (enchantments.containsKey(aquaAffinity) && enchantments.containsKey(depthStrider)) {
                ArrayList<Integer> deleteMe = new ArrayList(tags.tagCount());

                for (int i = 0; i < tags.tagCount(); i++) {
                    NBTTagCompound tag = (NBTTagCompound) tags.get(i);
                    Enchantment tagEnch = Enchantment.getEnchantmentByID(tag.getShort("id"));
                    if (tagEnch == aquaAffinity || tagEnch == depthStrider) {
                        deleteMe.add(i);
                    }
                }
                Collections.reverse(deleteMe);
                for (int delete : deleteMe) {
                    tags.removeTag(delete);
                }

            }
        }
    }
}
