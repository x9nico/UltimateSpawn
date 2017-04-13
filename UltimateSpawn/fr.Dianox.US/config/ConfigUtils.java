package fr.Dianox.US.config;

import org.bukkit.ChatColor;

public class ConfigUtils {
	
	public static String no_permission;
	public static String player_not_found;
	public static String console_use_command;
	  
	public ConfigUtils() {}
	  
	public static void load() {
		no_permission = ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("others.No-permission-message"));
		player_not_found = ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("others.Player-not-found"));
		console_use_command = ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("others.Console-use-command"));
	}
}
