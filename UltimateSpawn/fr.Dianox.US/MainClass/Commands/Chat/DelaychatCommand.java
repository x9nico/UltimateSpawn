package fr.Dianox.US.MainClass.Commands.Chat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.command.ConfigCDelayChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMDelayChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;

public class DelaychatCommand implements CommandExecutor {

	public static int delay = ConfigCDelayChat.getConfig().getInt("DelayChat.Delay.Delay_By_Default");
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			if (cmd.getName().equalsIgnoreCase("delaychat") || cmd.getName().equalsIgnoreCase("dchat")) {
				if (args.length == 1) {
					delay = Integer.parseInt(args[0]);
					for (String msg: ConfigMDelayChat.getConfig().getStringList("ChatDelay.Admin.Set")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg.replaceAll("%player%", "CONSOLE").replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))));
					}
				} else {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Arguments-Missing")) {
	            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	            	}
				}
			}
			return true;
		}
		
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("delaychat") || cmd.getName().equalsIgnoreCase("dchat")) {
			if (ConfigCDelayChat.getConfig().getBoolean("DelayChat.Enable")) {
				if (p.hasPermission("ultimatespawn.command.delaychat")) {
					if (args.length == 1) {
						delay = Integer.parseInt(args[0]);
						for (String msg: ConfigMDelayChat.getConfig().getStringList("ChatDelay.Admin.Set")) {
							PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						}
					} else {
						for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Arguments-Missing")) {
							PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
		            	}
					}
				} else {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
                	}
				}
			} else {
	            if (ConfigCDelayChat.getConfig().getBoolean("DelayChat.Disable-Message")) {
	            	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
	            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	            	}
	            }
	        }
		}
		
		return true;
	}
}
