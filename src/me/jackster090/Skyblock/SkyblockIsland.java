package me.jackster090.Skyblock;

import org.bukkit.WorldCreator;

import me.jackster090.Main.ZenergySkyblock;
import me.jackster090.Utils.EmptyChunkGenerator;

public class SkyblockIsland {
	
	public SkyblockIsland(ZenergySkyblock plugin) {
		
	}
	
	public void createIslandWorld(String worldName) {
		WorldCreator wc = new WorldCreator(worldName);
		wc.generator(new EmptyChunkGenerator());
        wc.createWorld();
        
        //add in skyblock island here
	}
	
	public void loadSchematic() {
		
	}

}
