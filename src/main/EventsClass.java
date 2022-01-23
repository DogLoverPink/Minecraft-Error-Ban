package main;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;
public class EventsClass implements Listener {
	private App plugin;
	public EventsClass(App plugin) {
        this.plugin = plugin;
        Bukkit.getPluginManager().registerEvents(this, plugin);
        
    } 
	@EventHandler
	public void OnPlayerLoginEvent(PlayerLoginEvent evt) {
		if (ErrorCommand.banList.getString(("players."+evt.getPlayer().getName().toLowerCase())).equalsIgnoreCase("true")) {
        evt.disallow(PlayerLoginEvent.Result.KICK_BANNED, ErrorCommand.banList.getString("config.message"));
            }}}

//send message: player.sendMessage(ChatColor.GOLD + "I eat dogs");