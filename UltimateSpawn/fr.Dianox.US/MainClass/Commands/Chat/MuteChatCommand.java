package fr.Dianox.US.MainClass.Commands.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCMuteChat;

public class MuteChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			consoleMuteChatGLobal();
			
            return true;
        }
		
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("globalmute") || cmd.getName().equalsIgnoreCase("gmute")) {
			if (ConfigCMuteChat.getConfig().getBoolean("MuteChat.Enable")) {
				if (p.hasPermission("ultimatespawn.command.mutechat")) {
					if (ConfigCMuteChat.getConfig().getBoolean("MuteChat.Mute.Enable")) {
						Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.MuteChat.ON")));
						PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.MuteChat.On"), Bukkit.getServer());
						ConfigCMuteChat.getConfig().set("MuteChat.Mute.Enable", Boolean.valueOf(false));
					} else {
						Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.MuteChat.OFF")));
						PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.MuteChat.Off"), Bukkit.getServer());
						ConfigCMuteChat.getConfig().set("MuteChat.Mute.Enable", Boolean.valueOf(true));
					}
				} else {
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
		        }
			} else {
				if (ConfigCMuteChat.getConfig().getBoolean("MuteChat.Disable-Message")) {
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
				}
			}
		}
		
		return true;
	}
	
	public void consoleMuteChatGLobal() {
		if (ConfigCMuteChat.getConfig().getBoolean("MuteChat.Mute.Enable")) {
			Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.MuteChat.ON")));
			PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(ConfigMessage.getConfig().getString("Admin.MuteChat.On"), Bukkit.getServer());
			ConfigCMuteChat.getConfig().set("MuteChat.Mute.Enable", Boolean.valueOf(false));
		} else {
			Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.MuteChat.OFF")));
			PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(ConfigMessage.getConfig().getString("Admin.MuteChat.Off"), Bukkit.getServer());
			ConfigCMuteChat.getConfig().set("MuteChat.Mute.Enable", Boolean.valueOf(true));
		}
	}
	
	
}
