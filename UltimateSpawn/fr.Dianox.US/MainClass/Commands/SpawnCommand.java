package fr.Dianox.US.MainClass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.SpawnUtils;
import fr.Dianox.US.MainClass.config.command.ConfigCSpawn;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;

public class SpawnCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    
		if (!(sender instanceof Player)) {
			for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Only-Player")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
            return true;
        }

        Player p = (Player) sender;
		
		if (ConfigCSpawn.getConfig().getBoolean("Spawn.Enable")) {
	    	if (label.equalsIgnoreCase("spawn") || label.equalsIgnoreCase("hub") || label.equalsIgnoreCase("lobby") || label.equalsIgnoreCase("h") || label.equalsIgnoreCase("l")) {
	        	if (ConfigCSpawn.getConfig().getBoolean("Spawn.Use_Permission")) {
	        		if (p.hasPermission("ultimatespawn.command.spawn")) {
				        if (label.equalsIgnoreCase("spawn") || label.equalsIgnoreCase("hub") || label.equalsIgnoreCase("lobby") || label.equalsIgnoreCase("h") || label.equalsIgnoreCase("l")) {
				            if (args.length == 0) {
				                if (!(sender instanceof Player)) {
				                	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Only-Player")) {
				                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
				        			}
				                    return true;
				                }
				                SpawnUtils.teleportToSpawn(p, true);
				            } else if (args.length == 1 && p.hasPermission("ultimatespawn.command.spawn.teleportothers")) {
				            	Player target = Bukkit.getServer().getPlayer(args[0]);
				
				            	if (target == null) {
				            		for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Not-found")) {
	                					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                				}
				            		return true;
				            	}
				
				            	SpawnUtils.teleportToSpawn(target, sender);
				            } else {
				            	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
			                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
			                	}
				            }
				        }
	        		} else {
	        			for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
	                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                	}
	        		}
	        	} else {
	        		if (args.length == 0) {
	        			if (!(sender instanceof Player)) {
	        				for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Only-Player")) {
		                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
		        			}
	        				return true;
	        			}
	        			SpawnUtils.teleportToSpawn(p, true);
	        		} else if (args.length == 1 && p.hasPermission("ultimatespawn.command.spawn.teleportothers")) {
	        			Player target = Bukkit.getServer().getPlayer(args[0]);
			
	        			if (target == null) {
	        				for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Not-found")) {
            					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
            				}
	        				return true;
	        			}
			
	        			SpawnUtils.teleportToSpawn(target, sender);
	        		}
	        	}
	    	}
	    } else {
	    	if (ConfigCSpawn.getConfig().getBoolean("Spawn.Disable-Message")) {
	    		for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
            	}
            }
	    }
		return true;
    }

}
