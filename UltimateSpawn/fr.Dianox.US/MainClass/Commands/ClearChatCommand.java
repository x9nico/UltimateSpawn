package fr.Dianox.US.MainClass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;

public class ClearChatCommand implements CommandExecutor {
	
	public ClearChatCommand () {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Only-Player")));
	        return true;
		}
		
		Player p = (Player)sender;
		int lines = ConfigGlobal.getConfig().getInt("On-Join.Clear.Chat.Lines-To-Clear");
		
		if(ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Enable")){
			if(label.equalsIgnoreCase("cc") && p.hasPermission("UltimateSpawn.clearchat")){
				if((args.length == 0)){
					p.sendMessage("§3//§m---------------§r §c[§rUltimateSpawn§c] §3§m---------------§r§3\\\\");
					p.sendMessage("");
					p.sendMessage(" >> ClearChat");
					p.sendMessage("");
					p.sendMessage(" §8>> §7/cc a - §eClear the chat anonymously");
					p.sendMessage(" §8>> §7/cc o - §eClear your own chat");
					p.sendMessage(" §8>> §7/cc c - §eClear the chat");
					p.sendMessage(" §8>> §7/cc other [player] - §eClear someone elses chat");
					p.sendMessage("");
					p.sendMessage("§3\\\\§m---------------§r §c[§rUltimateSpawn§c] §3§m---------------§r§3//");
				} else if (args[0].equalsIgnoreCase("a")) {
					if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Anonymous.Enable")) {
						for (int i = 0; i < lines; i++) {
					        Bukkit.broadcastMessage(" ");
					    }
					    if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Anonymous.Message-Clear")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.ClearChat.Anonymously")));
						}
					} else {
						if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Anonymous.Disable-Message")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Command-disable")));
						}
					}
				} else if (args[0].equalsIgnoreCase("c")) {
					if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Normal.Enable")) {
						for (int i = 0; i < lines; i++) {
					        Bukkit.broadcastMessage(" ");
					    }
					    if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Normal.Message-Clear")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.ClearChat.Normal").replaceAll("%player%", p.getName())));
						}
					} else {
						if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Normal.Disable-Message")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Command-disable")));
						}
					}
				} else if (args[0].equalsIgnoreCase("o")) {
					if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Own.Enable")) {
						for (int i = 0; i < lines; i++) {
					        p.sendMessage(" ");
					    }
					    if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Own.Message-Clear")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.ClearChat.Own")));
						}
					} else {
						if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Own.Disable-Message")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Command-disable")));
						}
					}
				} else if (args[0].equalsIgnoreCase("other")) {
					if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Other.Enable")) {
						
						if (args.length != 2) {
					        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Enter-Player-Name")));
					        sender.sendMessage(ChatColor.RED + "/cc other [player]");
					        return true;
					    }
						Player target = Bukkit.getServer().getPlayer(args[1]);
						
						if (target == null) {
							sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
					        return true;
					    }
						
						for (int i = 0; i < lines; i++) {
					        target.sendMessage(" ");
					    }
					    if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Other.Message-Clear")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.ClearChat.Other")));
						}
					} else {
						if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Other.Disable-Message")) {
							p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Command-disable")));
						}
					}
				}
			} else {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.No-permission")));
			}
		} else {
			if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Disable-Message")) {
				p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Command-disable")));
			}
		}
		
		return true;
	}
	
	

}
