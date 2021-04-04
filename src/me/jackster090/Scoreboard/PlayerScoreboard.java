package me.jackster090.Scoreboard;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

import me.jackster090.Utils.Utils;

public class PlayerScoreboard {
	
	private Utils utils;
	
	public PlayerScoreboard() {}
	
	public PlayerScoreboard(Player player) {
		utils = new Utils();
		
		ScoreboardManager manager = Bukkit.getScoreboardManager(); //Get scoreboard manager
		Scoreboard board = manager.getNewScoreboard(); //Create a new custom scoreboard

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
