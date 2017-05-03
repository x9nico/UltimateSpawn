package fr.Dianox.US;

import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.event.player.PlayerRespawnEvent;
import org.bukkit.event.player.PlayerTeleportEvent;

import fr.Dianox.US.Scoreboard.Board;
import fr.Dianox.US.config.ConfigMessage;
import fr.Dianox.US.config.MainConfig;

public class Events implements Listener {
	
	public Events(){}
	  
	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player p = e.getPlayer();
	    
	    //Broadcast Join
	    if (MainConfig.getConfig().getBoolean("broadcast.player-join.enabled")) {
	    	if (MainConfig.getConfig().getBoolean("broadcast.player-join.hide")) {
	    		e.setJoinMessage(null);
	    	} else {
	    		e.setJoinMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("join.broadcast.Join-message").replaceAll("%player%", p.getName())));
	    	}
	    }
	    
	    //Message join
	    if (MainConfig.getConfig().getBoolean("Join.Join-message-enabled")) {
	    	for (String message : ConfigMessage.getConfig().getStringList("join.message.Join-message")) {
	    		p.sendMessage(ChatColor.translateAlternateColorCodes('&', message.replaceAll("%player%", p.getName())));
	    	}
	    }
	    
	    //Join by a normal player
	    if (p.hasPlayedBefore()) {
	    	if (MainConfig.getConfig().getBoolean("spawn.Teleport-to-spawn-on.join")) {
	    		Utils.teleportToSpawn(p);
	    	} else {
	    		if (MainConfig.getConfig().getBoolean("spawn.Teleport-to-spawn-on.first-join")) {
	    			Utils.teleportToSpawn(p);
	    		}
	    		if (MainConfig.getConfig().getBoolean("broadcast.first-join.enabled")) {
	    			org.bukkit.Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("join.broadcast.First-join-message").replaceAll("%player%", p.getName())));
	    		}
	    	}
	    	
		    if (MainConfig.getConfig().getBoolean("Join.First-join-message-enabled")) {
		    	for (String message : ConfigMessage.getConfig().getStringList("join.broadcast.Join-message")) {
		    		p.sendMessage(ChatColor.translateAlternateColorCodes('&', message.replaceAll("%player%", p.getName())));
		    	}
		    }
	    }
	    
	    int gm = MainConfig.getConfig().getInt("options.set-gamemode-on-join.gamemode");
	    
	    if (MainConfig.getConfig().getBoolean("options.set-gamemode-on-join.enabled")) {
	    	if (gm == 0) {
	    		p.setGameMode(GameMode.SURVIVAL);
	    	}
	    	else if (gm == 1) {
	    		p.setGameMode(GameMode.CREATIVE);
	    	}
	    	else if (gm == 2) {
	    		p.setGameMode(GameMode.ADVENTURE);
	    	}
	    	else if (gm == 3) {
	    		p.setGameMode(GameMode.SPECTATOR);
	    	}
	    }
	    
	    if ((MainConfig.getConfig().getBoolean("options.set-fly-on-join.enabled")) && (gm != 3)) {
	    	p.setAllowFlight(MainConfig.getConfig().getBoolean("options.set-fly-on-join.fly"));
	    }
	    
	    if (MainConfig.getConfig().getBoolean("options.set-max-health-on-join")) {
	    	p.setHealth(20.0D);
	    }
	    
	    if (MainConfig.getConfig().getBoolean("options.set-max-food-level-on-join")) {
	    	p.setFoodLevel(20);
	    }
	}
	  
	@EventHandler
	public void onPlayerQuit(PlayerQuitEvent e) {
		Player p = e.getPlayer();
	    
	    if (MainConfig.getConfig().getBoolean("options.set-fly-on-join.fly")) {
	    	p.setAllowFlight(false);
	    }
	    if (MainConfig.getConfig().getBoolean("broadcast.player-quit.enabled")) {
	    	if (MainConfig.getConfig().getBoolean("broadcast.player-quit.hide")) {
	    		e.setQuitMessage(null);
	    	} else {
	    		e.setQuitMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("quit.broadcast.Quit-message").replaceAll("%player%", e.getPlayer().getName())));
	    	}
	    }
	}
	    
	  
	@EventHandler
	public void onPlayerRespawn(PlayerRespawnEvent e) {
		final PlayerRespawnEvent e1 = e;
	    
	    org.bukkit.Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
	    	public void run() {
	    		if (MainConfig.getConfig().getBoolean("spawn.Teleport-to-spawn-on.respawn")) {
	    			Utils.teleportToSpawn(e1.getPlayer());
	    		}
	    	}
	    }, 5L);
	}
	  
	@EventHandler
	public void onEntityDamage(EntityDamageEvent e) {
		if (((e.getEntity() instanceof Player)) && (e.getCause().equals(EntityDamageEvent.DamageCause.VOID)) && (MainConfig.getConfig().getBoolean("spawn.Teleport-to-spawn-on.void-fall"))) {
			Utils.teleportToSpawn((Player)e.getEntity());
			e.setCancelled(true);
		}
	}
	
    @EventHandler
    public void onJoin(PlayerJoinEvent e)
    {
      new Board(e.getPlayer());
    }
    
    @EventHandler
    public void onQuit(PlayerQuitEvent e)
    {
      e.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
      Board.boards.remove(e.getPlayer());
    }
    
    @EventHandler
    public void onTeleport(PlayerTeleportEvent e){
      List<String> disabled = MainConfig.getConfig().getStringList("Scoreboard.disabled_worlds");
      if (disabled != null){
        boolean isDisabled = false;
        for (String world : disabled) {
          if (world.toLowerCase().equals(e.getPlayer().getLocation().getWorld().getName().toLowerCase())){
            isDisabled = true;
            
            Board.disabled.add(e.getPlayer());
            Board b = (Board)Board.btp.get(e.getCause());
            Board.btp.remove(b);
            Board.boards.remove(b);
            e.getPlayer().setScoreboard(Bukkit.getScoreboardManager().getNewScoreboard());
          }
        }
        if ((!isDisabled) && (Board.disabled.contains(e.getPlayer()))){
          Board.disabled.remove(e.getPlayer());
          new Board(e.getPlayer());
        }
      }
    }
}
