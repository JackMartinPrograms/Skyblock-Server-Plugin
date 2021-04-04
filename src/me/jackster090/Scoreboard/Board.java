package me.jackster090.Scoreboard;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.bukkit.Bukkit;

public class Board {
	
	private static Map<UUID, Integer> TASKS = new HashMap<UUID, Integer>();
	private final UUID uuid;
	
	public Board(UUID uuid) {
		this.uuid = uuid;
	}
	
	public void stop() {
		Bukkit.getScheduler().cancelTask(TASKS.get(uuid));
		TASKS.remove(uuid);
	}
	
	public boolean hasID() {
		if (TASKS.containsKey(uuid)) return true;
		
		return false;
	}
	
	public int getID() {
		return TASKS.get(uuid);
	}
	
	public void setID(int id) {
		TASKS.put(uuid, id);
	}
}
