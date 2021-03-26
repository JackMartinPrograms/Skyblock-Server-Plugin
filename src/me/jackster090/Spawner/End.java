package me.jackster090.Spawner;

import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld;
import org.bukkit.entity.Player;

import me.jackster090.Mobs.ObsidianDefender;
import net.minecraft.server.v1_16_R3.WorldServer;

public class End {	
	
	@SuppressWarnings("unused")
	private final int OBSDEF_CAP = 5;
	
	public void spawnObsidianDefender(Player player, Location loc) {
		ObsidianDefender joe = new ObsidianDefender(player.getLocation(), 100, 1);
		WorldServer world = ((CraftWorld)player.getWorld()).getHandle();		
		world.addEntity(joe);
	}

}
