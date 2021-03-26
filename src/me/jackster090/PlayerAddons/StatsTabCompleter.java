package me.jackster090.PlayerAddons;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;

public class StatsTabCompleter implements TabCompleter {
	
	private List<String> arguments = new ArrayList<String>();

	@Override
	public List<String> onTabComplete(CommandSender sender, Command cmd,
			String label, String[] args) {
		if (arguments.isEmpty()) {
			arguments.add("deaths");
			arguments.add("logins");
			arguments.add("mobKills");
			arguments.add("playerKills");
		}
		
		List<String> result = new ArrayList<String>();
		if (args.length == 1) {
			for (String i : arguments) {
				if (i.toLowerCase().startsWith(args[0].toLowerCase())) {
					result.add(i);
				}
			}
			return result;
		}		
		return null;
	}

}
