package fr.Dianox.US.MainClass.Commands.Other;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.config.ConfigMessage;

public class TimeCommand implements CommandExecutor {
	
	public TimeCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Only-Player")));
            return true;
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("night")) {
			if (p.hasPermission("ultimatespawn.command.time.night")) {
				p.getWorld().setTime(16000L);
			}
		}
		if (cmd.getName().equalsIgnoreCase("day")) {
			if (p.hasPermission("ultimatespawn.command.time.day")) {
				p.getWorld().setTime(0L);
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("sun")) {
			if (p.hasPermission("ultimatespawn.command.weather.sun")) {
				p.getWorld().setThundering(false);
				p.getWorld().setStorm(false);
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("rain")) {
			if (p.hasPermission("ultimatespawn.command.weather.rain")) {
				p.getWorld().setThundering(false);
				p.getWorld().setStorm(true);
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("thunder")) {
			if (p.hasPermission("ultimatespawn.command.weather.thunder")) {
				p.getWorld().setThundering(true);
				p.getWorld().setStorm(true);
			}
		}
		
		return true;
	}
	
	

}
