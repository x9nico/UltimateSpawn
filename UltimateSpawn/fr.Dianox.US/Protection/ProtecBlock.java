package fr.Dianox.US.Protection;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

import fr.Dianox.US.config.ConfigMessage;
import fr.Dianox.US.config.MainConfig;

public class ProtecBlock implements Listener {

    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();
        
        if (MainConfig.getConfig().getBoolean("Protection.Block.Place-block")) {
        	if (MainConfig.getConfig().getBoolean("Protection.Block.Place-block-bypass")) {
        		if (p.hasPermission("UltimateSpawn.bypass.placeblock")){
        			//nothing
        		} else {
        			e.setCancelled(true);
        			if (MainConfig.getConfig().getBoolean("Protection.Block.Place-block-message")) {
        				p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Protection.Block.Place-block").replaceAll("%player%", p.getName())));
        			}
        		}
        	} else {
        		e.setCancelled(true);
    			if (MainConfig.getConfig().getBoolean("Protection.Block.Place-block-message")) {
    				p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Protection.Block.Place-block").replaceAll("%player%", p.getName())));
    			}
        	}
        }
    }
    
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();
        
        if (MainConfig.getConfig().getBoolean("Protection.Block.Break-block")) {
        	if (MainConfig.getConfig().getBoolean("Protection.Block.Break-block-bypass")) {
        		if (p.hasPermission("UltimateSpawn.bypass.placeblock")){
        			//nothing
        		} else {
        			e.setCancelled(true);
        			if (MainConfig.getConfig().getBoolean("Protection.Block.Break-block-message")) {
        				p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Protection.Block.Break-block").replaceAll("%player%", p.getName())));
        			}
        		}
        	} else {
        		e.setCancelled(true);
    			if (MainConfig.getConfig().getBoolean("Protection.Block.Break-block-message")) {
    				p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Protection.Block.Break-block").replaceAll("%player%", p.getName())));
    			}
        	}
        }
    }
	 
}
