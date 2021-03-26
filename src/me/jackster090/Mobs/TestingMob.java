package me.jackster090.Mobs;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;

import net.md_5.bungee.api.ChatColor;
import net.minecraft.server.v1_16_R3.ChatComponentText;
import net.minecraft.server.v1_16_R3.EntityPlayer;
import net.minecraft.server.v1_16_R3.EntityTypes;
import net.minecraft.server.v1_16_R3.EntityVillager;
import net.minecraft.server.v1_16_R3.PathfinderGoalAvoidTarget;
import net.minecraft.server.v1_16_R3.PathfinderGoalPanic;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomLookaround;
import net.minecraft.server.v1_16_R3.PathfinderGoalRandomStrollLand;

public class TestingMob extends EntityVillager {
	
	public TestingMob(Location loc, int health, int level) {
		super(EntityTypes.VILLAGER, ((CraftWorld) loc.getWorld()).getHandle());
		
		//Mob settings
		this.setPosition(loc.getX(), loc.getY(), loc.getZ()); //Set position of mob		
		this.setCustomName(new ChatComponentText(ChatColor.translateAlternateColorCodes('&',
				"&bThe &oSucking &bMan"))); //Set mob name (above head)
		this.setCustomNameVisible(true); //Set custom mob name to be visible		
		this.setHealth(health); //Set Mob Health
		
		//Path finding
		this.goalSelector.a(0, new PathfinderGoalAvoidTarget<EntityPlayer>(this, EntityPlayer.class,
				15, 1.0D, 1.0D)); //Number 1 priority - avoid the player
		this.goalSelector.a(1, new PathfinderGoalPanic(this, 2.0D)); //Number 2 priority - panic
		this.goalSelector.a(2,
				new PathfinderGoalRandomStrollLand(this, 0.6D)); //Number 3 priority - walk around
		this.goalSelector.a(3,
				new PathfinderGoalRandomLookaround(this)); //Number 4 priority - look around
		
	}

}
