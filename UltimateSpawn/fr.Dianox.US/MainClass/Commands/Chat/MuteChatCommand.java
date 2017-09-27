package fr.Dianox.US.MainClass.Commands.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCGlobal;

public class MuteChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			consoleMuteChatGLobal();
			
            return true;
        }
		
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("GlobalMute") || cmd.getName().equalsIgnoreCase("gmute") && p.hasPermission("UltimateSpawn.mutechat")) {
			if (ConfigCGlobal.getConfig().getBoolean("Command.MuteChat.Enable")) {
				if (ConfigCGlobal.getConfig().getBoolean("Command.MuteChat.Mute.Enable")) {
					Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.MuteChat.ON")));
					PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.MuteChat.On"), Bukkit.getServer());
					ConfigCGlobal.getConfig().set("Command.MuteChat.Mute.Enable", Boolean.valueOf(false));
				} else {
					Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.MuteChat.OFF")));
					PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.MuteChat.Off"), Bukkit.getServer());
					ConfigCGlobal.getConfig().set("Command.MuteChat.Mute.Enable", Boolean.valueOf(true));
				}
			} else {
	            if (ConfigCGlobal.getConfig().getBoolean("Command.MuteChat.Disable-Message")) {
	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
	            }
	        }
		} else {
			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
        }
		
		return true;
	}
	
	public void consoleMuteChatGLobal() {
		if (ConfigCGlobal.getConfig().getBoolean("Command.MuteChat.Mute.Enable")) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.MuteChat.ON")));
			PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(ConfigMessage.getConfig().getString("Admin.MuteChat.On"), Bukkit.getServer());
			ConfigCGlobal.getConfig().set("Command.MuteChat.Mute.Enable", Boolean.valueOf(false));
		} else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.MuteChat.OFF")));
			PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(ConfigMessage.getConfig().getString("Admin.MuteChat.Off"), Bukkit.getServer());
			ConfigCGlobal.getConfig().set("Command.MuteChat.Mute.Enable", Boolean.valueOf(true));
		}
	}
	
	

}
