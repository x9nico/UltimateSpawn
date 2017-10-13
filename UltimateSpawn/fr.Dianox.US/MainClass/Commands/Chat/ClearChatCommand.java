package fr.Dianox.US.MainClass.Commands.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCClearChat;

public class ClearChatCommand implements CommandExecutor {

    public ClearChatCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        int lines = ConfigCClearChat.getConfig().getInt("ClearChat.Lines-To-Clear");

        if (!(sender instanceof Player)) {
            if (label.equalsIgnoreCase("cc")) {
                if ((args.length == 0)) {
                	sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
                    sender.sendMessage("");
                    sender.sendMessage("     §l>> §e§o§lClearChat Help");
                    sender.sendMessage("");
                    sender.sendMessage(" §8>> §7/cc a - §eClear the chat anonymously");
                    sender.sendMessage(" §8>> §7/cc o - §cClear your own chat (You can't)");
                    sender.sendMessage(" §8>> §7/cc c - §eClear the chat");
                    sender.sendMessage(" §8>> §7/cc other <player> - §eClear someone elses chat");
                    sender.sendMessage("");
                    sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
                } else if (args[0].equalsIgnoreCase("a")) {
                    if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous.Enable")) {
                        for (int i = 0; i < lines; i++) {
                            Bukkit.broadcastMessage(" ");
                        }
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Anonymously")));
                        ccac();
                    }
                } else if (args[0].equalsIgnoreCase("c")) {
                    for (int i = 0; i < lines; i++) {
                        Bukkit.broadcastMessage(" ");
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Normal.Console")));
                    cccc();
                } else if (args[0].equalsIgnoreCase("other")) {
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
                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Other"), target);
                }
            }

            return true;
        }

        Player p = (Player) sender;

        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Enable")) {
            if (label.equalsIgnoreCase("cc")) {
                if ((args.length == 0)) {
                	if (p.hasPermission("ultimatespawn.command.clearchat.help")) {
	                    p.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
	                    p.sendMessage("");
	                    p.sendMessage("     §l>> §e§o§lClearChat Help");
	                    p.sendMessage("");
	                    p.sendMessage(" §8>> §7/cc a - §eClear the chat anonymously");
	                    p.sendMessage(" §8>> §7/cc o - §eClear your own chat");
	                    p.sendMessage(" §8>> §7/cc c - §eClear the chat");
	                    p.sendMessage(" §8>> §7/cc other <player> - §eClear someone elses chat");
	                    p.sendMessage("");
	                    p.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
                	}
                } else if (args[0].equalsIgnoreCase("a")) {
                    if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous.Enable")) {
                    	if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous.Use_Permission")) {
                    		if (p.hasPermission("ultimatespawn.command.clearchat.anonymous")) {
		                        for (int i = 0; i < lines; i++) {
		                            Bukkit.broadcastMessage(" ");
		                        }
		                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous.Message-Clear")) {
		                        	Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Anonymously")));
		                        	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Anonymously"), Bukkit.getServer());
		                        }
                    		} else {
                    			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
                    		}
                    	} else {
                    		for (int i = 0; i < lines; i++) {
	                            Bukkit.broadcastMessage(" ");
	                        }
                    		if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous.Message-Clear")) {
	                        	Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Anonymously")));
	                        	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Anonymously"), Bukkit.getServer());
	                        }
                    	}
                    } else {
                    	if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous.Disable-Message")) {
                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                        }
                    }
                } else if (args[0].equalsIgnoreCase("c")) {
                    if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Normal.Enable")) {
                    	if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Normal.Use_Permission")) {
                    		if (p.hasPermission("ultimatespawn.command.clearchat.normal")) {
		                        for (int i = 0; i < lines; i++) {
		                            Bukkit.broadcastMessage(" ");
		                        }
		                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Normal.Message-Clear")) {
		                        	Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Normal.Player").replaceAll("%player%", String.valueOf(p))));
		                            PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Normal"), Bukkit.getServer());
		                        }
                    		} else {
                    			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
                    		}
                    	} else {
                    		for (int i = 0; i < lines; i++) {
	                            Bukkit.broadcastMessage(" ");
	                        }
	                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Normal.Message-Clear")) {
	                        	Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Normal.Player").replaceAll("%player%", String.valueOf(p))));
	                            PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Normal"), Bukkit.getServer());
	                        }
                    	}
                    } else {
                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Normal.Disable-Message")) {
                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                        }
                    }
                } else if (args[0].equalsIgnoreCase("o") || args[0].equalsIgnoreCase("own")) {
                    if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Own.Enable")) {
                    	if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Own.Use_Permission")) {
                    		if (p.hasPermission("ultimatespawn.command.clearchat.own")) {
		                        for (int i = 0; i < lines; i++) {
		                            p.sendMessage(" ");
		                        }
		                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Own.Message-Clear")) {
		                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Own"), p);
		                        }
                    		} else {
                    			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
                    		}
                    	} else {
                    		for (int i = 0; i < lines; i++) {
	                            p.sendMessage(" ");
	                        }
	                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Own.Message-Clear")) {
	                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Own"), p);
	                        }
                    	}
                    } else {
                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Own.Disable-Message")) {
                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                        }
                    }
                } else if (args[0].equalsIgnoreCase("other")) {
                    if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Other.Enable")) {
                    	if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Other.Use_Permission")) {
                    		if (p.hasPermission("ultimatespawn.command.clearchat.other")) {
		                        if (args.length != 2) {
		                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Player.Enter-Player-Name"), (Player) sender);
		                            sender.sendMessage(ChatColor.RED + "/cc other [player]");
		                            return true;
		                        }
		                        Player target = Bukkit.getServer().getPlayer(args[1]);
		                        if (target == null) {
		                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Player.Not-found"), (Player) sender);
		                            return true;
		                        }
		                        for (int i = 0; i < lines; i++) {
		                            target.sendMessage(" ");
		                        }
		                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Other.Message-Clear")) {
		                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Other"), target);
		                        }
                    		} else {
                    			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
                    		}
                    	} else {
                    		if (args.length != 2) {
	                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Player.Enter-Player-Name"), (Player) sender);
	                            sender.sendMessage(ChatColor.RED + "/cc other [player]");
	                            return true;
	                        }
	                        Player target = Bukkit.getServer().getPlayer(args[1]);
	                        if (target == null) {
	                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Player.Not-found"), (Player) sender);
	                            return true;
	                        }
	                        for (int i = 0; i < lines; i++) {
	                            target.sendMessage(" ");
	                        }
	                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Other.Message-Clear")) {
	                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Other"), target);
	                        }
                    	}
                    } else {
                    	if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Own.Disable-Message")) {
                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                        }
                    }
                }
            }
        }

        return true;
    }

    public void ccac() {
        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Console.Anonymous-Message-Clear")) {
            PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Anonymously"), Bukkit.getServer());
        }
    }

    public void cccc() {
        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Console.Normal-Message-Clear")) {
            PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(ConfigMessage.getConfig().getString("Admin.ClearChat.Normal"), Bukkit.getServer());
        }
    }

}
