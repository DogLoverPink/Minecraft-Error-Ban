package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.bukkit.command.Command;
public class TabComplete implements TabCompleter {
	@Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String alias, String[] args) {
        if (cmd.getName().equalsIgnoreCase("errorban") || cmd.getName().equalsIgnoreCase("Error-Ban:errorban")) {
            if (!sender.hasPermission("errorban.use")) return Collections.EMPTY_LIST;
            final List<String> completions = new ArrayList<>();
            if (args.length == 1) {
            	completions.add("ban");
            	completions.add("unban");
            	completions.add("list");
            	completions.add("setmessage");
            	Collections.sort(completions);
            	//StringUtil.copyPartialMatches(args[0], COMMANDS, completions);
            	return completions;
            }
            if (args.length == 2) {
            	if (args[0].equalsIgnoreCase("unban") || args[0].equalsIgnoreCase("pardon")) {
            		for (String key : ErrorCommand.banList.getConfigurationSection("players").getKeys(false)) {
            		   if (ErrorCommand.banList.getString("players."+key).equals("true"))completions.add(key);}
            		return completions;
            	}
            }
            if (args.length >= 1) {
            	if (args[0].equalsIgnoreCase("setmessage")) {
            		completions.add("!RECOMENDED:");
            		completions.add("internal exception java.net.socketexception connection reset");
            		completions.add("Connection refused: no further information");
            		completions.add("Unknown host");
            		completions.add("java.net.ConnectException: Connection timed out: no further information");
            		completions.add("Outdated server! Im still on {0}");
            		return completions;
            	}
            }
            Collections.sort(completions);
            for(Player plr : Bukkit.getServer().getOnlinePlayers()) {
                completions.add(plr.getName());}
            return completions;
        }
        return Collections.EMPTY_LIST;
    }
}