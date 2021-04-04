package me.jackster090.Utils;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.world.World;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import com.sk89q.worldguard.protection.regions.RegionQuery;

import net.md_5.bungee.api.ChatColor;

public class Utils {
	
	public boolean isPlayerInRegion(Player player, String regionName) {
		RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
		com.sk89q.worldedit.util.Location loc = BukkitAdapter.adapt(player.getLocation());
		RegionQuery query = container.createQuery();
		ApplicableRegionSet set = query.getApplicableRegions(loc);
		
		for (ProtectedRegion region : set) {
			if (region.getId().equalsIgnoreCase(regionName)) {
				return true;
			}
		}		
		return false;
	}
	
	public ProtectedRegion getRegion(World world, String regionName) {
		RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
		RegionManager regions = container.get(world);
		
		if (regions.getRegion(regionName) == null) {
			ProtectedRegion region = regions.getRegion("No Region Found");
			regions.addRegion(region);
			return regions.getRegion(region.getId());
		}
		
		return regions.getRegion(regionName);
	}
	
	public boolean checkIfItemsAreTheSame(ItemStack item1, ItemStack item2) {
		if (item1 != null && item1.getItemMeta().getDisplayName() != null) {
			if (item1.getType() == item2.getType()) {
				if (item1.getItemMeta().getDisplayName().equals(
						item2.getItemMeta().getDisplayName())) {
					return true;
				}
			}
		}
		return false;
	}
	
	public String translateColors(String string) {
		return ChatColor.translateAlternateColorCodes('&', string);
	}
	
	public void fillEmptyGUISlots(Inventory inv) {	
		for (int i = 0; i < inv.getSize(); i++) {
			ItemStack item = inv.getItem(i);
			if (item == null || item.getType() == Material.AIR) {
				inv.setItem(i, new ItemStack(Material.BLACK_STAINED_GLASS_PANE));
			} 
		}
	}

}
