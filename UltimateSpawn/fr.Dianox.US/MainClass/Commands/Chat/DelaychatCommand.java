package fr.Dianox.US.MainClass.Commands.Chat;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCDelayChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMDelayChat;

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
					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Arguments-Missing")));
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
						PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Arguments-Missing"), p);
					}
				} else {
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
				}
			} else {
	            if (ConfigCDelayChat.getConfig().getBoolean("DelayChat.Disable-Message")) {
	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
	            }
	        }
		}
		
		return true;
	}
}
