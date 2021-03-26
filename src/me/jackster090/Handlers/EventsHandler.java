package me.jackster090.Handlers;

import org.bukkit.attribute.Attribute;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemStack;

import me.jackster090.CustomItems.SkyblockMenuItem;
import me.jackster090.PlayerAddons.SkyblockMenu;
import me.jackster090.Utils.Utils;

public class EventsHandler implements Listener {
	
	private SkyblockMenuItem skyblockMenuItem;
	private SkyblockMenu skyblockMenu;
	private Utils utils;
	//private End end;
	
	public EventsHandler() {
		skyblockMenuItem = new SkyblockMenuItem();
		skyblockMenu = new SkyblockMenu();
		utils = new Utils();
		//end = new End();
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageEvent event) {
		if (event.getEntity() == null) return; 
		if (event.getEntity().getCustomName() == null) return;
		if (event.getEntity().getCustomName().contains("Obsidian Defender")) {
			LivingEntity obsDef = (LivingEntity) event.getEntity();
			obsDef.setCustomName(utils.translateColors(
					"&8[&7Lvl " + 1 + "&8] &dObsidian Defender " + "❤ " + 
							Math.round(obsDef.getHealth()) + "/" + 
							obsDef.getAttribute(Attribute.GENERIC_MAX_HEALTH).getValue()));
			
		}
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent event) {
		if (event.getEntity() == null) return;
		if (event.getEntity().getCustomName() == null) return;
		if (event.getEntity().getKiller() instanceof Player) {
			if (event.getEntity().getCustomName().contains("Obsidian Defender")) {
				event.getDrops().clear();
				event.setDroppedExp(0);
			}
		}
	}
	
	@EventHandler
	public void onPlayerMove(PlayerMoveEvent event) {
		if (event.getPlayer().getWorld().getName().equals("world")) {
			//if player is in specific region in world, spawn mobs (world is for testing)
		}
	}
	
	@EventHandler
	public void onPlayerInteract(PlayerInteractEvent event) {
		Player player = event.getPlayer();	
		ItemStack item = event.getItem();
		if (event.getAction() == Action.RIGHT_CLICK_AIR || 
				event.getAction() == Action.RIGHT_CLICK_BLOCK) {
			if (utils.checkIfItemsAreTheSame(item, skyblockMenuItem.getMenuItem())) {
				skyblockMenu.openMenu(player);
			}
		}
	}
	
	@EventHandler
	public void onInventoryClick(InventoryClickEvent event) {
		ItemStack item = event.getCurrentItem();
		if (utils.checkIfItemsAreTheSame(item, skyblockMenuItem.getMenuItem())) {
			event.setCancelled(true);
			skyblockMenu.openMenu((Player) event.getWhoClicked());
		}
		
		if (utils.checkIfItemsAreTheSame(item, skyblockMenu.closeMenu)) {
			event.setCancelled(true);
			event.getWhoClicked().closeInventory();
			return;
		}
		
		//Skyblock Menu Inventory
		
		if (event.getClickedInventory() == skyblockMenu.getInventory()) {
			event.setCancelled(true);
			if (utils.checkIfItemsAreTheSame(item, skyblockMenu.workbench)) {
				event.getWhoClicked().openWorkbench(event.getWhoClicked().getLocation(), true);
			}
		}
	}
	
	@EventHandler
	public void onPlayerThrow(PlayerDropItemEvent event) {
		ItemStack item = event.getItemDrop().getItemStack();
		if (utils.checkIfItemsAreTheSame(item, skyblockMenuItem.getMenuItem())) {
			event.setCancelled(true);
		}
	}
	
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		skyblockMenuItem.givePlayerItem(event.getPlayer());
	}
	
	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		event.getPlayer().getInventory().removeItem(skyblockMenuItem.getMenuItem());
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
