package fr.Dianox.US.MainClass.Utils;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Commands.PingCommand;
import fr.Dianox.US.MainClass.Commands.Chat.DelaychatCommand;
import fr.Dianox.US.MainClass.Utils.Server.Tps;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.command.ConfigCPlayerOption;
import fr.Dianox.US.MainClass.config.global.cji.ConfigGPlayerVisibility;
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
					.replaceAll("%tps%", String.valueOf(Tps.getTPS()))
					.replaceAll("%timedelaypvcji%", String.valueOf(ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")))
					.replaceAll("%timedelaypvcommands%", String.valueOf(ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")))
					));
		} else {
			p.sendMessage(ChatColor.translateAlternateColorCodes('&', str
					.replaceAll("%player%", p.getName())
					.replaceAll("%target%", p.getName())
					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
					.replaceAll("%tps%", String.valueOf(Tps.getTPS()))
					.replaceAll("%timedelaypvcji%", String.valueOf(ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")))
					.replaceAll("%timedelaypvcommands%", String.valueOf(ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")))
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
						.replaceAll("%tps%", String.valueOf(Tps.getTPS()))
						.replaceAll("%timedelaypvcji%", String.valueOf(ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")))
						.replaceAll("%timedelaypvcommands%", String.valueOf(ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")))
						));
			}
		} else {
			for (Player p: Bukkit.getServer().getOnlinePlayers()) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', str)
						.replaceAll("%player%", p.getName())
						.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
						.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
						.replaceAll("%tps%", String.valueOf(Tps.getTPS()))
						.replaceAll("%timedelaypvcji%", String.valueOf(ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")))
						.replaceAll("%timedelaypvcommands%", String.valueOf(ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")))
						);
			}
		}
	}
	
	public static void ReplaceCharBroadcastPlayerMoreGeneral(String str, Server server, Player player) {
		if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(player, str)
					.replaceAll("%player%", player.getName())
					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(player)))
					.replaceAll("%tps%", String.valueOf(Tps.getTPS()))
					.replaceAll("%timedelaypvcji%", String.valueOf(ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")))
					.replaceAll("%timedelaypvcommands%", String.valueOf(ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")))
					));
		} else {
			Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', str)
					.replaceAll("%player%", player.getName())
					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(player)))
					.replaceAll("%tps%", String.valueOf(Tps.getTPS()))
					.replaceAll("%timedelaypvcji%", String.valueOf(ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")))
					.replaceAll("%timedelaypvcommands%", String.valueOf(ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")))
					);
		}
	}
	
	public static void ReplaceCharBroadcastPlayerExceptionConsole(String str, Server server) {
		if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
			for (Player p: Bukkit.getServer().getOnlinePlayers()) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, str)
						.replaceAll("%player%", "CONSOLE")
						.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
						.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
						.replaceAll("%tps%", String.valueOf(Tps.getTPS()))
						.replaceAll("%timedelaypvcji%", String.valueOf(ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")))
						.replaceAll("%timedelaypvcommands%", String.valueOf(ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")))
						));
			}
		} else {
			for (Player p: Bukkit.getServer().getOnlinePlayers()) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', str)
						.replaceAll("%player%", "CONSOLE")
						.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
						.replaceAll("%ping%", String.valueOf(PingCommand.getPing(p)))
						.replaceAll("%tps%", String.valueOf(Tps.getTPS()))
						.replaceAll("%timedelaypvcji%", String.valueOf(ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")))
						.replaceAll("%timedelaypvcommands%", String.valueOf(ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")))
						);
			}
		}
	}

}

