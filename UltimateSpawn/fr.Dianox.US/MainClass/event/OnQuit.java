package fr.Dianox.US.MainClass.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.Dianox.US.MainClass.config.ConfigGlobal;

public class OnQuit implements Listener {
	
	@EventHandler
	public void onQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Fly")) {
	    	p.setAllowFlight(false);
	    	p.setFlying(false);
	    }
		
	    if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Broadcast.Quit.Enable")) {
	    	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Broadcast.Quit.Hide")) {
	    		e.setQuitMessage(null);
	    	} else {
	    		for (String message : ConfigGlobal.getConfig().getStringList("On-Join.Spawn.Broadcast.Quit.Message")) {
		    		p.sendMessage(ChatColor.translateAlternateColorCodes('&', message.replaceAll("%player%", p.getName())));
	    		}
	    		e.setQuitMessage(null);
	    	}
	    }
	}

}
