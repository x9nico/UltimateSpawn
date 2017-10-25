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
import fr.Dianox.US.MainClass.config.messages.ConfigMMuteChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;

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
						for (String msg: ConfigMMuteChat.getConfig().getStringList("MuteChat.Admin.On")) {
							Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
						}
						for (String msg: ConfigMMuteChat.getConfig().getStringList("MuteChat.Admin.On")) {
							PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(msg, Bukkit.getServer());
						}
						ConfigCMuteChat.getConfig().set("MuteChat.Mute.Enable", Boolean.valueOf(false));
					} else {
						for (String msg: ConfigMMuteChat.getConfig().getStringList("MuteChat.Admin.Off")) {
							Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
						}
						for (String msg: ConfigMMuteChat.getConfig().getStringList("MuteChat.Admin.Off")) {
							PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(msg, Bukkit.getServer());
						}
						ConfigCMuteChat.getConfig().set("MuteChat.Mute.Enable", Boolean.valueOf(true));
					}
				} else {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
                	}
		        }
			} else {
				if (ConfigCMuteChat.getConfig().getBoolean("MuteChat.Disable-Message")) {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
	            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	            	}
				}
			}
		}
		
		return true;
	}
	
	public void consoleMuteChatGLobal() {
		if (ConfigCMuteChat.getConfig().getBoolean("MuteChat.Mute.Enable")) {
			for (String msg: ConfigMMuteChat.getConfig().getStringList("MuteChat.Admin.On")) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
			for (String msg: ConfigMMuteChat.getConfig().getStringList("MuteChat.Admin.On")) {
				PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(msg, Bukkit.getServer());
			}
			ConfigCMuteChat.getConfig().set("MuteChat.Mute.Enable", Boolean.valueOf(false));
		} else {
			for (String msg: ConfigMMuteChat.getConfig().getStringList("MuteChat.Admin.Off")) {
				Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
			for (String msg: ConfigMMuteChat.getConfig().getStringList("MuteChat.Admin.Off")) {
				PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(msg, Bukkit.getServer());
			}
			ConfigCMuteChat.getConfig().set("MuteChat.Mute.Enable", Boolean.valueOf(true));
		}
	}	
	
}
