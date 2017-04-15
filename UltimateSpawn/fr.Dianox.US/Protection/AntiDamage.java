package fr.Dianox.US.Protection;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;

import fr.Dianox.US.config.MainConfig;

public class AntiDamage implements Listener {
	
	@EventHandler
	public void onDamageEvent(EntityDamageEvent e){
        if (MainConfig.getConfig().getBoolean("Protection.DamageEvent")) {
        	e.setCancelled(true);
        }
	}

}
