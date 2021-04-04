package me.jackster090.Main;

import org.bukkit.Statistic;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;

import me.jackster090.Handlers.EventsHandler;
import me.jackster090.PlayerAddons.SkyblockMenu;
import me.jackster090.PlayerAddons.StatsTabCompleter;
import me.jackster090.Skyblock.SkyblockIsland;
import me.jackster090.Spawner.End;
import me.jackster090.Utils.Utils;

public class ZenergySkyblock extends JavaPlugin {
	
	private static ZenergySkyblock instance;
	
	public WorldGuardPlugin worldGuard;
	
	private SkyblockIsland skyblockIsland;
	private SkyblockMenu skyblockMenu;
	private Utils utils;
	private End end;
	
	public void onEnable() {
		PluginManager pm = this.getServer().getPluginManager();
		pm.registerEvents(new EventsHandler(), this);
		
		this.getCommand("stat").setTabCompleter(new StatsTabCompleter());
		
		instance = this;
		
		worldGuard = getWorldGuard();
		
		skyblockIsland = new SkyblockIsland(this);
		skyblockMenu = new SkyblockMenu();
		utils = new Utils();
		end = new End();
	}
	
	public void onDisable() {

	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if (label.equalsIgnoreCase("spawnjoe")) {
				end.spawnObsidianDefender(player, player.getLocation());
				sender.sendMessage("Mob Spawned Successfully");
				return true;
			}
			
			if (label.equalsIgnoreCase("openmenu")) {
				skyblockMenu.openMenu(player);
				return true;
			}
			
			if (label.equalsIgnoreCase("voidworld")) {
				skyblockIsland.createIslandWorld(player.getName());
				return true;
			}
			
			if (label.equalsIgnoreCase("ec")) {
				return true;
			}

			if (label.equalsIgnoreCase("stat")) {
				if (args.length == 0) {
					player.sendMessage(utils.translateColors(
							"&cUsage: /stat {deaths/logins/mobKills/playerKills}"));
					return true;
				}
				
				if (args.length == 1) {
					if (args[0].equalsIgnoreCase("deaths")) {
						player.sendMessage(utils.translateColors("&bYou Have " + 
								player.getStatistic(Statistic.DEATHS) + " Deaths!"));
						return true;
					}
					if (args[0].equalsIgnoreCase("logins")) {
						player.sendMessage(utils.translateColors("&bYou Have " + 
								player.getStatistic(Statistic.LEAVE_GAME) + " Logins!"));
						return true;	
					}
					if (args[0].equalsIgnoreCase("mobKills")) {
						player.sendMessage(utils.translateColors("&bYou Have " + 
								player.getStatistic(Statistic.MOB_KILLS) + " Mob Kills!"));
						return true;
					}
					if (args[0].equalsIgnoreCase("playerKills")) {
						player.sendMessage(utils.translateColors("&bYou Have " + 
								player.getStatistic(Statistic.PLAYER_KILLS) + " Player Kills!"));
						return true;
					}
				}				
			}
		}
		return false;
	}
	
	public WorldGuardPlugin getWorldGuard() {
		Plugin plugin = this.getServer().getPluginManager().getPlugin("WorldGuard");		
		if (plugin == null || !(plugin instanceof WorldGuardPlugin)) return null;
		
		return (WorldGuardPlugin) plugin;
	}
	
	public static ZenergySkyblock getInstance() {
		return instance;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
