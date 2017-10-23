package fr.Dianox.US.MainClass.Commands.Chat;

import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCClearChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMClearChat;

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
                    sender.sendMessage(" §8>> §7/cc a [reason] - §eClear the chat anonymously");
                    sender.sendMessage(" §8>> §7/cc o - §eClear your own chat");
                    sender.sendMessage(" §8>> §7/cc c [reason] - §eClear the chat");
                    sender.sendMessage(" §8>> §7/cc other <player> [reason] - §eClear someone elses chat");
                    sender.sendMessage("");
                    sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
                } else if (args[0].equalsIgnoreCase("a")) {
                    if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous.Enable")) {
                        for (int i = 0; i < lines; i++) {
                        	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(" ", Bukkit.getServer());
                        }
                        
                        String msg = ConfigMClearChat.getConfig().getString("ClearChat.No-Reason");
                        
                        if (args.length == 2) {
	                        if (!args[1].isEmpty()) {
	                        	for (String s: args) {
	                        		if (!Objects.equals(msg, "")) {
		    	                    	msg = msg + " ";
	                        		}
	                        		msg = "" + s;
	                        	}
	                        }
                        }
                        
                        for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Anonymously")) {
                        	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ms1.replaceAll("%reason%", msg)));
                        }
                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Console.Anonymous-Message-Clear")) {
                        	for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Anonymously")) {
                        		PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ms1.replaceAll("%reason%", msg), Bukkit.getServer());
                        	}
                        }
                    }
                } else if (args[0].equalsIgnoreCase("c")) {
                    for (int i = 0; i < lines; i++) {
                    	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(" ", Bukkit.getServer());
                    }
                    
                    String msg = ConfigMClearChat.getConfig().getString("ClearChat.No-Reason");
                    
                    if (args.length == 2) {
                        if (!args[1].isEmpty()) {
                        	for (String s: args) {
                        		if (!Objects.equals(msg, "")) {
	    	                    	msg = msg + " ";
                        		}
                        		msg = "" + s;
                        	}
                        }
                    }
                    
                    for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Normal")) {
                    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ms1.replaceAll("%reason%", msg)));
                    }
                    if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Console.Normal-Message-Clear")) {
                    	for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Normal")) {
                    		PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(ms1.replaceAll("%reason%", msg), Bukkit.getServer());
                    	}
                    }
                } else if (args[0].equalsIgnoreCase("o")) {
                	for (int i = 0; i < lines; i++) {
                		sender.sendMessage(" ");
                	}
                } else if (args[0].equalsIgnoreCase("other")) {
                	String msg = ConfigMClearChat.getConfig().getString("ClearChat.No-Reason");
                	
                    if (args.length == 1) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Enter-Player-Name")));
                        sender.sendMessage(ChatColor.RED + "/cc other <player> [reason]");
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
                    
                    if (args.length == 2) {
                        if (!args[1].isEmpty()) {
                        	for (String s: args) {
                        		if (!Objects.equals(msg, "")) {
	    	                    	msg = msg + " ";
                        		}
                        		msg = "" + s;
                        	}
                        }
                    }
                    
                    for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Other.Sender")) {
                    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ms1.replaceAll("%reason%", msg)));
                    }
                    for (String ms2: ConfigMClearChat.getConfig().getStringList("ClearChat.Other.Target")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ms2.replaceAll("%reason%", msg), target);
                    }
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
	                    p.sendMessage(" §8>> §7/cc a [reason] - §eClear the chat anonymously");
	                    p.sendMessage(" §8>> §7/cc o - §eClear your own chat");
	                    p.sendMessage(" §8>> §7/cc c [reason] - §eClear the chat");
	                    p.sendMessage(" §8>> §7/cc other <player> [reason] - §eClear someone elses chat");
	                    p.sendMessage("");
	                    p.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
                	}
                } else if (args[0].equalsIgnoreCase("a")) {
                    if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous.Enable")) {
                    	if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous.Use_Permission")) {
                    		if (p.hasPermission("ultimatespawn.command.clearchat.anonymous")) {
		                        for (int i = 0; i < lines; i++) {
		                        	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(" ", Bukkit.getServer());
		                        }
		                        
		                        String msg = ConfigMClearChat.getConfig().getString("ClearChat.No-Reason");
		                        
		                        if (args.length == 2) {
		                            if (!args[1].isEmpty()) {
		                            	for (String s: args) {
		                            		if (!Objects.equals(msg, "")) {
		    	    	                    	msg = msg + " ";
		                            		}
		                            		msg = "" + s;
		                            	}
		                            }
		                        }
		                        
		                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Console.Anonymous-Message-Clear")) {
		                        	for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Anonymously")) {
		                        		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ms1.replaceAll("%reason%", msg)));
		                        		PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ms1.replaceAll("%reason%", msg), Bukkit.getServer());
		                        	}
		                        }
                    		} else {
                    			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
                    		}
                    	} else {
                    		for (int i = 0; i < lines; i++) {
	                        	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(" ", Bukkit.getServer());
	                        }
	                        
	                        String msg = ConfigMClearChat.getConfig().getString("ClearChat.No-Reason");
	                        
	                        if (args.length == 2) {
	                            if (!args[1].isEmpty()) {
	                            	for (String s: args) {
	                            		if (!Objects.equals(msg, "")) {
	    	    	                    	msg = msg + " ";
	                            		}
	                            		msg = "" + s;
	                            	}
	                            }
	                        }
	                        
	                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Anonymous-Message-Clear")) {
	                        	for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Anonymously")) {
	                        		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ms1.replaceAll("%reason%", msg)));
	                        		PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ms1.replaceAll("%reason%", msg), Bukkit.getServer());
	                        	}
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
    	                        	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(" ", Bukkit.getServer());
    	                        }
    	                        
    	                        String msg = ConfigMClearChat.getConfig().getString("ClearChat.No-Reason");
    	                        
    	                        if (args.length == 2) {
    	                            if (!args[1].isEmpty()) {
    	                            	for (String s: args) {
    	                            		if (!Objects.equals(msg, "")) {
    	    	    	                    	msg = msg + " ";
    	                            		}
    	                            		msg = "" + s;
    	                            	}
    	                            }
    	                        }
		                        
		                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Normal.Message-Clear")) {
		                        	for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Normal")) {
		                        		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ms1.replaceAll("%reason%", msg)));
		                        		PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ms1.replaceAll("%reason%", msg), Bukkit.getServer());
		                        	}
		                        }
                    		} else {
                    			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
                    		}
                    	} else {
                    		for (int i = 0; i < lines; i++) {
	                        	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(" ", Bukkit.getServer());
	                        }
	                        
	                        String msg = ConfigMClearChat.getConfig().getString("ClearChat.No-Reason");
	                        
	                        if (args.length == 2) {
	                            if (!args[1].isEmpty()) {
	                            	for (String s: args) {
	                            		if (!Objects.equals(msg, "")) {
	    	    	                    	msg = msg + " ";
	                            		}
	                            		msg = "" + s;
	                            	}
	                            }
	                        }
	                        
	                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Normal.Message-Clear")) {
	                        	for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Normal")) {
	                        		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ms1.replaceAll("%reason%", msg)));
	                        		PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ms1.replaceAll("%reason%", msg), Bukkit.getServer());
	                        	}
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
			                        for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Own")) {
			                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ms1, p);
		                        	}
		                        }
                    		} else {
                    			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
                    		}
                    	} else {
                    		for (int i = 0; i < lines; i++) {
	                            p.sendMessage(" ");
	                        }
	                        if (ConfigCClearChat.getConfig().getBoolean("ClearChat.Own.Message-Clear")) {
		                        for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Own")) {
	                        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ms1, p);
	                        	}
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
    	                        
    	                        String msg = ConfigMClearChat.getConfig().getString("ClearChat.No-Reason");
    	                        
    	                        if (args.length == 2) {
    	                            if (!args[1].isEmpty()) {
    	                            	for (String s: args) {
    	                            		if (!Objects.equals(msg, "")) {
    	    	    	                    	msg = msg + " ";
    	                            		}
    	                            		msg = "" + s;
    	                            	}
    	                            }
    	                        }
    	                        
    	                        for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Other.Sender")) {
    	                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ms1.replaceAll("%reason%", msg), p);
    	                        }
    	                        for (String ms2: ConfigMClearChat.getConfig().getStringList("ClearChat.Other.Target")) {
    	                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ms2.replaceAll("%reason%", msg), target);
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
	                        
	                        String msg = ConfigMClearChat.getConfig().getString("ClearChat.No-Reason");
	                        
	                        if (args.length == 2) {
	                            if (!args[1].isEmpty()) {
	                            	for (String s: args) {
	                            		if (!Objects.equals(msg, "")) {
	    	    	                    	msg = msg + " ";
	                            		}
	                            		msg = "" + s;
	                            	}
	                            }
	                        }
	                        
	                        for (String ms1: ConfigMClearChat.getConfig().getStringList("ClearChat.Other.Sender")) {
	                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ms1.replaceAll("%reason%", msg), p);
	                        }
	                        for (String ms2: ConfigMClearChat.getConfig().getStringList("ClearChat.Other.Target")) {
	                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ms2.replaceAll("%reason%", msg), target);
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
}
