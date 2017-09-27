package fr.Dianox.US.MainClass.Commands.Chat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCGlobal;

public class DelaychatCommand implements CommandExecutor {

	public static int delay = ConfigCGlobal.getConfig().getInt("Command.DelayChat.Delay.Delay_By_Default");
	
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
			if (ConfigCGlobal.getConfig().getBoolean("Command.DelayChat.Enable")) {
				if (args.length == 1) {
					delay = Integer.parseInt(args[0]);
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.DelayChat.Set"), p);
				} else {
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Arguments-Missing"), p);
				}
			} else {
	            if (ConfigCGlobal.getConfig().getBoolean("Command.DelayChat.Disable-Message")) {
	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
	            }
	        }
		} else {
			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
        }
		
		return true;
	}
	
	

}
