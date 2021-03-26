package me.jackster090.Mobs;

import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.LivingEntity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.LeatherArmorMeta;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntitySkeletonWither;
import net.minecraft.server.v1_16_R3.EntityTypes;

public class ObsidianDefender extends EntitySkeletonWither {
	
	private LivingEntity obsDef;
	
	public ObsidianDefender(Location loc, int health, int level) {
		super(EntityTypes.WITHER_SKELETON, ((CraftWorld) loc.getWorld()).getHandle());
		obsDef = (LivingEntity) this.getBukkitEntity(); //Convert to living entity
		
		// Mob settings
		this.setPosition(loc.getX(), loc.getY(), loc.getZ()); //Set position of mob		
		this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',
				"&8[&7Lvl " + level + "&8] &dObsidian Defender " + "❤ " + 
						health + "/" + health))); //Set mob name (above head)
		this.setCustomNameVisible(true); //Set custom mob name to be visible
		this.setSprinting(true);
		
		AttributeInstance healthAttribute = obsDef.getAttribute(Attribute.GENERIC_MAX_HEALTH);
		if (healthAttribute != null) {
			healthAttribute.setBaseValue(health);
		}
		
		// Mob Armour/Tools
		
		ItemStack chestplate = new ItemStack(Material.LEATHER_CHESTPLATE);
		LeatherArmorMeta chestplateMeta = (LeatherArmorMeta) chestplate.getItemMeta();
		chestplateMeta.setColor(Color.BLACK);
		chestplate.setItemMeta(chestplateMeta);
		
		obsDef.getEquipment().setHelmet(new ItemStack(Material.OBSIDIAN));		
		obsDef.getEquipment().setChestplate(chestplate);
		
		// Path finding
		
		//this.goalSelector.a(new PathfinderGoalZombieAttack());
	}	
	
	
}
