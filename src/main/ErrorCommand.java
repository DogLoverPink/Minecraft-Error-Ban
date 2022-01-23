package main;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.configuration.file.YamlConfiguration;

public class ErrorCommand implements CommandExecutor {
	public static File f = new File("plugins/ErrorBan/Ban-List.yml");
	public static YamlConfiguration banList = YamlConfiguration.loadConfiguration(f);
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		/*if (sender instanceof Player) {
            Player plr = (Player) sender;
        }*/
		CommandSender s = (CommandSender) sender;
		if (args.length == 0) {
			return false;
		}
		if (!args[0].equalsIgnoreCase("setMessage")&& !args[0].equalsIgnoreCase("add") && !args[0].equalsIgnoreCase("remove") && !args[0].equalsIgnoreCase("list")&& !args[0].equalsIgnoreCase("ban") && !args[0].equalsIgnoreCase("unban")&& !args[0].equalsIgnoreCase("pardon")) {
	            //s.sendMessage(ChatColor.RED+"Invalid Usage! do "+ChatColor.LIGHT_PURPLE+"/<Error-Ban> <ban/unban/list/setMessage> [<player/newMessage>]");
	            return false;
		}
		if (!f.exists()) {
			try{f.createNewFile();
			banList.createSection("banned-players");
			banList.save(f);
			} catch (IOException e) {e.printStackTrace();}}
		if (args[0].equalsIgnoreCase("add") || args[0].equalsIgnoreCase("ban")) {
			if (args.length == 1) {
				s.sendMessage(ChatColor.RED+"Please Specify A Player!");
				return true;}
			if (banList.get("players."+args[1].toLowerCase()) != null && banList.getString("players."+args[1].toLowerCase()).equalsIgnoreCase("true")) {
				s.sendMessage(ChatColor.RED+"Nothing changed, "+args[1]+ChatColor.RED+" is already error-banned");
				return true;
			}
			if (Bukkit.getPlayerExact(args[1]) != null) {
				try{banList.set("players."+args[1].toLowerCase(), true);banList.save(f); } catch (IOException e) {e.printStackTrace();}
				s.sendMessage(ChatColor.GREEN+"Succesfully Error-Banned "+ChatColor.AQUA+args[1]);
				Bukkit.getPlayerExact(args[1]).kickPlayer("Timed Out");
			} else {
			try{banList.set("players."+args[1].toLowerCase(), true);banList.save(f); } catch (IOException e) {e.printStackTrace();}
			s.sendMessage(ChatColor.GREEN+"Succesfully Error-Banned "+ChatColor.AQUA+args[1]+ChatColor.GREEN+" (Currently Offline)");
			}}
		
		if (args[0].equalsIgnoreCase("unban") || args[0].equalsIgnoreCase("pardon")) {
			if (args.length == 1) {
				s.sendMessage(ChatColor.RED+"Please Specify A Player!");
				return true;}
			if (banList.get("players."+args[1].toLowerCase()) == null || !banList.getString("players."+args[1].toLowerCase()).equals("true")) {
				s.sendMessage(ChatColor.RED+"Nothing changed, "+args[1]+ChatColor.RED+" is already not error-banned");
				return true;
			}
			try{banList.set("players."+args[1].toLowerCase(), false);banList.save(f); } catch (IOException e) {e.printStackTrace();}
			s.sendMessage(ChatColor.GREEN+"Succesfully Un-Error-Banned "+ChatColor.AQUA+args[1]+ChatColor.GREEN);
		}
		if (args[0].equalsIgnoreCase("list")) {
			    ArrayList<String> listofbans = new ArrayList<String>();
			    String message = "";//ChatColor.YELLOW+"The currently error-banned players are:\n";
        		for (String key : banList.getConfigurationSection("players").getKeys(false)) {
        		   if (ErrorCommand.banList.getString("players."+key).equals("true")) {
        			   listofbans.add(key);
        		   	   message=message+", "+key;}}
        		  if (listofbans.size() == 0) {
        			  s.sendMessage(ChatColor.YELLOW+"There are current no error-banned players!");
        			  return true;
        		  }
        		  s.sendMessage(ChatColor.YELLOW+"The currently error-banned players are:\n"+ChatColor.AQUA+message.substring(2));
        		  return true;
		}
		if (args[0].equalsIgnoreCase("setmessage")) {
			if (args.length == 1) {
				s.sendMessage(ChatColor.YELLOW+"This command specifies what the error message will be when someone tries to connect!");
				s.sendMessage(ChatColor.YELLOW+"Set it by doing: "+ChatColor.LIGHT_PURPLE+"/errorban setmessage Whatever You Want!");
				return true;}
			if (args[1].equalsIgnoreCase("!RECOMENDED:")) {
				s.sendMessage(ChatColor.RED+"Ya werent supposed to do that... Please try again...");
				return true;
			}
			String banMessage = "";
			for (int i =0;i < args.length; i++) {
				if (i != 0) {
					banMessage = banMessage+" "+args[i];
				}
			}
			try{banList.set("config.message", banMessage.substring(1));banList.save(f); } catch (IOException e) {e.printStackTrace();}
		s.sendMessage(ChatColor.GREEN+"Succesfully changed the connection error message to: "+ChatColor.AQUA+banMessage);
		}
		
		return true;
	}
} 