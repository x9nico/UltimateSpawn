package fr.Dianox.US.MainClass.event;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.config.event.ConfigEColorSign;

public class LittlesEvent implements Listener {
	
	@EventHandler
	public void onSign(SignChangeEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigEColorSign.getConfig().getBoolean("ColorSign.Enable")) {
			if (!ConfigEColorSign.getConfig().getBoolean("ColorSign.World.All_World")) {
				if (MainClass.getWColorSign().contains(p.getWorld().getName())) {
					if (!p.hasPermission("UltimateSpawn.event.colorsign")) {
						return;
					}
					for (int i = 0; i <= 3; i++) {
				        String line = e.getLine(i);
				        
				        line = ChatColor.translateAlternateColorCodes('&', line);
				        e.setLine(i, line);
					}
				}
			} else {
				if (!p.hasPermission("UltimateSpawn.event.colorsign")) {
					return;
				}
				for (int i = 0; i <= 3; i++) {
			        String line = e.getLine(i);
			        
			        line = ChatColor.translateAlternateColorCodes('&', line);
			        e.setLine(i, line);
				}
			}
		}
	}

}
