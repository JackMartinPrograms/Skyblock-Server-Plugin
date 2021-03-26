package me.jackster090.CustomItems;

import java.util.ArrayList;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import net.md_5.bungee.api.ChatColor;

public class SkyblockMenuItem {
	
	private ItemStack menu = new ItemStack(Material.NETHER_STAR);
	private ItemMeta menuMeta = menu.getItemMeta();
	
	private ArrayList<String> menuLore = new ArrayList<String>();
	
	public SkyblockMenuItem() {
		menuMeta.setDisplayName(ChatColor.translateAlternateColorCodes('&',
				"&d&lSKYBLOCK MENU"));
		
		menuLore.add(ChatColor.translateAlternateColorCodes('&', 
				"&7Open Me!"));		
		menuMeta.setLore(menuLore);
		menu.setItemMeta(menuMeta);
	}
	
	public void givePlayerItem(Player player) {
		player.getInventory().setItem(8, menu);
	}
	
	public ItemStack getMenuItem() {
		return menu;
	}
	
	public ItemMeta getMenuItemMeta() {
		return menuMeta;
	}

}
