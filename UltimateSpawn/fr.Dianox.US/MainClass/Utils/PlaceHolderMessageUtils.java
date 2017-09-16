package fr.Dianox.US.MainClass.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Commands.PingCommand;
import fr.Dianox.US.MainClass.Commands.Chat.DelaychatCommand;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import me.clip.placeholderapi.PlaceholderAPI;

public class PlaceHolderMessageUtils {
	
	public PlaceHolderMessageUtils() {}
	
	public static void ReplaceCharMessagePlayer(String str, Player player) {
		Player p = player;
		
		if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, str)
					.replaceAll("%player%", p.getName())
					.replaceAll("%target%", p.getName())
					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
					));
		} else {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', str
					.replaceAll("%player%", p.getName())
					.replaceAll("%target%", p.getName())
					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
					));
		}
	}
	
	public static void ReplaceCharBroadcastPlayer(String str, Server server) {
		if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
			for (Player p: Bukkit.getServer().getOnlinePlayers()) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, str)
						.replaceAll("%player%", p.getName())
						.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
						.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
						));
			}
		} else {
			for (Player p: Bukkit.getServer().getOnlinePlayers()) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', str)
						.replaceAll("%player%", p.getName())
						.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
						.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
						);
			}
		}
	}
	
	public static void ReplaceCharBroadcastPlayerExceptionConsole(String str, Server server) {
		if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
			for (Player p: Bukkit.getServer().getOnlinePlayers()) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, str)
						.replaceAll("%player%", "CONSOLE")
						.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
						.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
						));
			}
		} else {
			for (Player p: Bukkit.getServer().getOnlinePlayers()) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', str)
						.replaceAll("%player%", "CONSOLE")
						.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
						.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
						);
			}
		}
	}

}
