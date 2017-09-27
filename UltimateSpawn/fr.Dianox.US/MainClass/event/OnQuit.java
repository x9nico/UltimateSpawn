package fr.Dianox.US.MainClass.event;

import java.util.UUID;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.OtherUtils;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigPlayerStats;
import fr.Dianox.US.MainClass.config.global.ConfigGFly;
import fr.Dianox.US.MainClass.config.global.ConfigGMessageQ;

public class OnQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        Location l = p.getLocation();
        UUID pU = e.getPlayer().getUniqueId();

        if (ConfigGFly.getConfig().getBoolean("Fly.Enable")) {
            p.setAllowFlight(false);
            p.setFlying(false);
        }

        if (ConfigGMessageQ.getConfig().getBoolean("Broadcast.Quit.Enable")) {
        	if (!ConfigGMessageQ.getConfig().getBoolean("Broadcast.Quit.World.All_World")) {
        		if (MainClass.getWBroadcastQuit().contains(p.getWorld().getName())) {
		            if (ConfigGMessageQ.getConfig().getBoolean("Broadcast.Quit.Hide")) {
		                e.setQuitMessage(null);
		            } else {
		                for (String message: ConfigGMessageQ.getConfig().getStringList("Broadcast.Quit.Message")) {
		                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
		                }
		                e.setQuitMessage(null);
		            }
        		}
        	} else {
        		if (ConfigGMessageQ.getConfig().getBoolean("Broadcast.Quit.Hide")) {
	                e.setQuitMessage(null);
	            } else {
	                for (String message: ConfigGMessageQ.getConfig().getStringList("Broadcast.Quit.Message")) {
	                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
	                }
	                e.setQuitMessage(null);
	            }
        	}
        }
        
        // Stats
        if (ConfigGlobal.getConfig().getBoolean("Plugin.Create.Stats")) {
        	ConfigPlayerStats.getConfig().set(pU+".Date.Last_logout", String.valueOf(OtherUtils.getDate()+" || "+OtherUtils.getHours()+" "+ConfigMessage.getConfig().getString("Others.Hours")+", "+OtherUtils.getMinutes()+" "+ConfigMessage.getConfig().getString("Others.Minutes")+", "+OtherUtils.getSeconds()+" "+ConfigMessage.getConfig().getString("Others.Seconds")));
	        ConfigPlayerStats.getConfig().set(pU+".Position.Last_logout.World", l.getWorld().getName());
	        ConfigPlayerStats.getConfig().set(pU+".Position.Last_logout.x", Double.valueOf(l.getX()));
	        ConfigPlayerStats.getConfig().set(pU+".Position.Last_logout.y", Double.valueOf(l.getY()));
	        ConfigPlayerStats.getConfig().set(pU+".Position.Last_logout.z", Double.valueOf(l.getZ()));
	        ConfigPlayerStats.getConfig().set(pU+".Position.Last_logout.yaw", Float.valueOf(l.getYaw()));
	        ConfigPlayerStats.getConfig().set(pU+".Position.Last_logout.pitch", Float.valueOf(l.getPitch()));
	        	
	        ConfigPlayerStats.saveConfigFile();
    	}
    }

}
