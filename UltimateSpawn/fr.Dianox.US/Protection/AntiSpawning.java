package fr.Dianox.US.Protection;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import fr.Dianox.US.config.MainConfig;

public class AntiSpawning implements Listener {
	
	@EventHandler
	public void onMob(CreatureSpawnEvent e) {
        if (MainConfig.getConfig().getBoolean("Protection.MobSpawning")) {
        	e.setCancelled(true);
        }
	}

}
