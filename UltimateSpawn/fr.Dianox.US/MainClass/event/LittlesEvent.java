package fr.Dianox.US.MainClass.event;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.SignChangeEvent;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

import fr.Dianox.US.MainClass.Utils.WorldUtils;
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.event.ConfigEColorSign;

public class LittlesEvent implements Listener {
	
	@EventHandler
	public void onSign(SignChangeEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigEColorSign.getConfig().getBoolean("ColorSign.Enable")) {
			if (!ConfigEColorSign.getConfig().getBoolean("ColorSign.World.All_World")) {
				if (WorldUtils.getWColorSign().contains(p.getWorld().getName())) {
					if (!p.hasPermission("ultimatespawn.sign.color")) {
						return;
					}
					for (int i = 0; i <= 3; i++) {
				        String line = e.getLine(i);
				        
				        line = ChatColor.translateAlternateColorCodes('&', line);
				        e.setLine(i, line);
					}
				}
			} else {
				if (!p.hasPermission("ultimatespawn.sign.color")) {
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
	
	@EventHandler
	public void onChangeGM(PlayerGameModeChangeEvent e) {
		Player p = e.getPlayer();
        UUID pU = e.getPlayer().getUniqueId();
        
		int GamemodeTemp1 = 0; 
        if (e.getNewGameMode() == GameMode.SURVIVAL) {
        	GamemodeTemp1 = 0;
        } else if (e.getNewGameMode() == GameMode.CREATIVE) {
        	GamemodeTemp1 = 1;
        } else if (e.getNewGameMode() == GameMode.ADVENTURE) {
        	GamemodeTemp1 = 2;
        } else if (e.getNewGameMode() == GameMode.SPECTATOR) {
        	GamemodeTemp1 = 3;
        }
        int GamemodeTemp2 = Integer.valueOf(GamemodeTemp1);
        
        if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
        	ConfigTemp.getConfig().set(pU+".Player", String.valueOf(p));
        	ConfigTemp.getConfig().set(pU+".Options.Gamemode", Integer.valueOf(GamemodeTemp2));
        	
        	ConfigTemp.saveConfigFile();
        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
        	ConfigTemp.getConfig().set(pU+".Player", String.valueOf(p));
        	ConfigTemp.getConfig().set(pU+".Options.Gamemode", Integer.valueOf(GamemodeTemp2));
        	
        	ConfigTemp.saveConfigFile();
        }
	}

}

