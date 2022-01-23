package main;

import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class App extends JavaPlugin {
	    @Override
	    public void onEnable() {
	    	new EventsClass(this);
	    	this.getCommand("errorban").setExecutor(new ErrorCommand());
	    	this.getCommand("errorban").setTabCompleter(new TabComplete());
	    	File theDir = new File("plugins/ErrorBan");
	    	if (!theDir.exists()){
	    	    theDir.mkdirs();
	    	    Bukkit.getConsoleSender().sendMessage("[Error-Ban] I see this is your first time loading, creating necessary files...");
	    	    ErrorCommand.banList.createSection("config");
				try {
					ErrorCommand.banList.set("config.message", "Connection refused: no further information");
					ErrorCommand.banList.save(ErrorCommand.f);
				} catch (IOException e) {e.printStackTrace();} 
	    	}
	    	File f = new File("plugins/ErrorBan/Ban-List.yml");
			if (!f.exists()) {
				try{f.createNewFile();} catch (IOException e) {e.printStackTrace();}}
	    }
	    @Override
	    public void onDisable() {

	}

}
