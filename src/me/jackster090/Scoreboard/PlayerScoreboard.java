package me.jackster090.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.jackster090.Main.ZenergySkyblock;
import me.jackster090.Utils.Utils;

public class PlayerScoreboard {
	
	private ZenergySkyblock mainClass;	
	private ScoreboardManager manager;
	private Scoreboard board;
	private Utils utils;
	
	private int taskID;
	
	public PlayerScoreboard() {}
	
	public PlayerScoreboard(Player player) {
		utils = new Utils();
		
		createScoreboard(player);
	}
	
	public void start(Player player) {
		mainClass = ZenergySkyblock.getInstance();
		taskID = Bukkit.getScheduler().scheduleSyncRepeatingTask(mainClass, new Runnable() {
			
			int count = 0;
			Board board = new Board(player.getUniqueId());
			
			@Override
			public void run() {
				if (!board.hasID()) {
					board.setID(taskID);
				}
				
				if (count == 13) count = 0; 
				
				switch (count) {
				case 0:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKYBLOCK"));
					break;
				case 1:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&6&lS&e&lKYBLOCK"));
					break;
				case 2:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lS&6&lK&e&lYBLOCK"));
					break;
				case 3:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSK&6&lY&e&lBLOCK"));
					break;
				case 4:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKY&6&lB&e&lLOCK"));
					break;
				case 5:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKYB&6&lL&e&lOCK"));
					break;
				case 6:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKYBL&6&lO&e&lCK"));
					break;
				case 7:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKYBLO&6&lC&e&lK"));
					break;
				case 8:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKYBLOC&6&lK"));
					break;
				case 9:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKYBLOCK"));
					break;
				case 10:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKYBLOCK"));
					break;
				case 11:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKYBLOCK"));
					break;
				case 12:
					player.getScoreboard().getObjective(DisplaySlot.SIDEBAR).setDisplayName(
							utils.translateColors("&e&lSKYBLOCK"));
					createScoreboard(player);
					break;
				}
				count++;
			}
		}, 0, 5); //every 5 ticks (quarter of a second), this will run
	}
	
	public void createScoreboard(Player player) {
		manager = Bukkit.getScoreboardManager(); //Get scoreboard manager
		board = manager.getNewScoreboard(); //Create a new custom scoreboard

		Objective obj = board.registerNewObjective("mainBoard", "dummy", 
				utils.translateColors("&e&lSKYBLOCK")); //set board name, criteria and title
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
		
		//Each individual line is a score (limit is 0-15)
		Score score = obj.getScore("=-=-=-=-=-=-=-=-=-=");
		score.setScore(3);
		
		Score score1 = obj.getScore("2");
		score1.setScore(2);
		
		Score score2 = obj.getScore("1");
		score2.setScore(1);
		
		Score score3 = obj.getScore("0");
		score3.setScore(0);
		
		player.setScoreboard(board); //Set the scoreboard to the player
	}

}
