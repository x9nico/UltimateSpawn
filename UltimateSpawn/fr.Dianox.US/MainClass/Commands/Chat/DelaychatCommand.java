package fr.Dianox.US.MainClass.Commands.Chat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;

public class DelaychatCommand implements CommandExecutor {

	public static int delay = ConfigGlobal.getConfig().getInt("Command.DelayChat.Delay.Delay_By_Default");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			if (cmd.getName().equalsIgnoreCase("DelayChat") || cmd.getName().equalsIgnoreCase("dchat")) {
				if (args.length == 1) {
					delay = Integer.parseInt(args[0]);
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.DelayChat.Set").replaceAll("%player%", "CONSOLE").replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))));
				} else {
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Arguments-Missing")));
				}
			}
			return true;
		}
		
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("DelayChat") || cmd.getName().equalsIgnoreCase("dchat") && p.hasPermission("UltimateSpawn.delaychat")) {
			if (ConfigGlobal.getConfig().getBoolean("Command.DelayChat.Enable")) {
				if (args.length == 1) {
					delay = Integer.parseInt(args[0]);
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.DelayChat.Set").replaceAll("%player%", p.getName()).replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))));
				} else {
					p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Arguments-Missing")));
				}
			} else {
	            if (ConfigGlobal.getConfig().getBoolean("Command.DelayChat.Disable-Message")) {
	                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Command-disable")));
	            }
	        }
		} else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.No-permission")));
        }
		
		return true;
	}
	
	

}
