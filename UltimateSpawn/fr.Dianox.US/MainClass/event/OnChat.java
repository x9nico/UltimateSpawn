package fr.Dianox.US.MainClass.event;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Commands.Chat.DelaychatCommand;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCDelayChat;
import fr.Dianox.US.MainClass.config.command.ConfigCMuteChat;

public class OnChat implements Listener {
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	List<String> cooling = new ArrayList();
	
	@EventHandler
	public void onChat(AsyncPlayerChatEvent e) {
		final String name = e.getPlayer().getName();
		
		Player p = e.getPlayer();
		
		if (ConfigCMuteChat.getConfig().getBoolean("MuteChat.Mute.Enable")) {
			if (ConfigCMuteChat.getConfig().getBoolean("MuteChat.Mute.Bypass")) {
				if (!p.hasPermission("ultimatespawn.event.chat.bypass.mutechat")) {
					e.setCancelled(true);
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Chat.Can_t_speak"), p);
				}
			} else {
				e.setCancelled(true);
				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Chat.Can_t_speak"), p);
			}
		}
		
		if (ConfigCDelayChat.getConfig().getBoolean("DelayChat.Delay.Enable")) {
			if (ConfigCDelayChat.getConfig().getBoolean("DelayChat.Delay.Bypass")) {
				if (!p.hasPermission("ultimatespawn.event.chat.bypass.chatdelay")) {
					if (cooling.contains(name)) {
				    	e.setCancelled(true);
				        PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Chat.Delay"), p);
					} else {
				        cooling.add(name);
				        
				        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
				          public void run() {
				            OnChat.this.cooling.remove(name);
				          }
				        }, DelaychatCommand.delay * 20);
				      }
				}
			} else {
				if (cooling.contains(name)) {
			    	e.setCancelled(true);
			    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Chat.Delay"), p);
			      } else {
			        cooling.add(name);
			        
			        Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			          public void run() {
			            OnChat.this.cooling.remove(name);
			          }
			        }, DelaychatCommand.delay * 20);
			      }
			}
		}
	}

}
