package me.jackster090.PlayerAddons;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import me.jackster090.Utils.Utils;

public class SkyblockMenu {
	
	private Inventory inv;
	private Utils utils;
	
	public ItemStack workbench;
	public ItemStack goToIsland;
	public ItemStack islandSettings;
	public ItemStack pets;
	public ItemStack enderChest;
	public ItemStack closeMenu;
	
	public void openMenu(Player player) {
		utils = new Utils();
		inv = Bukkit.createInventory(player, 54, "Skyblock Menu");
		setupItems();		
		player.openInventory(inv);
	}
	
	public void setupItems() {
		workbench = new ItemStack(Material.CRAFTING_TABLE);
		ItemMeta workbenchMeta = workbench.getItemMeta();
		workbenchMeta.setDisplayName(utils.translateColors("&bWorkbench"));
		workbench.setItemMeta(workbenchMeta);
		inv.setItem(31, workbench);
		
		goToIsland = new ItemStack(Material.RED_BED);
		ItemMeta goToIslandMeta = goToIsland.getItemMeta();
		goToIslandMeta.setDisplayName(utils.translateColors("&bGo To Island"));
		goToIsland.setItemMeta(goToIslandMeta);
		inv.setItem(22, goToIsland);
		
		islandSettings = new ItemStack(Material.OAK_SAPLING);
		ItemMeta islandSettingsMeta = goToIsland.getItemMeta();
		islandSettingsMeta.setDisplayName(utils.translateColors("&bIsland Settings"));
		islandSettings.setItemMeta(islandSettingsMeta);
		inv.setItem(21, islandSettings);
		
		pets = new ItemStack(Material.BONE);
		ItemMeta petsMeta = goToIsland.getItemMeta();
		petsMeta.setDisplayName(utils.translateColors("&bPets"));
		pets.setItemMeta(petsMeta);
		inv.setItem(30, pets);
		
		enderChest = new ItemStack(Material.ENDER_CHEST);
		ItemMeta enderChestMeta = goToIsland.getItemMeta();
		enderChestMeta.setDisplayName(utils.translateColors("&bEnder Chest"));
		enderChest.setItemMeta(enderChestMeta);
		inv.setItem(32, enderChest);	
		
		closeMenu = new ItemStack(Material.BARRIER);
		ItemMeta closeMenuMeta = closeMenu.getItemMeta();
		closeMenuMeta.setDisplayName(utils.translateColors("&cClose Menu"));
		closeMenu.setItemMeta(closeMenuMeta);
		inv.setItem(49, closeMenu);
		
		utils.fillEmptyGUISlots(inv);
	}
	
	public Inventory getInventory() {
		return inv;
	}
	
}
