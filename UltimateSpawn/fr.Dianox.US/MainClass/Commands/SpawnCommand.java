package fr.Dianox.US.MainClass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.SpawnUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCSpawn;

public class SpawnCommand implements CommandExecutor {
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	    
		if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Only-Player")));
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
				                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Only-Player"), p);
				                    return true;
				                }
				                SpawnUtils.teleportToSpawn(p, true);
				            } else if (args.length == 1 && p.hasPermission("ultimatespawn.command.spawn.teleportothers")) {
				            	Player target = Bukkit.getServer().getPlayer(args[0]);
				
				            	if (target == null) {
				            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Player-not-found"), p);
				            		return true;
				            	}
				
				            	SpawnUtils.teleportToSpawn(target, sender);
				            } else {
				            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
				            }
				        }
	        		} else {
	        			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
	        		}
	        	} else {
	        		if (args.length == 0) {
	        			if (!(sender instanceof Player)) {
	        				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Only-Player"), p);
	        				return true;
	        			}
	        			SpawnUtils.teleportToSpawn(p, true);
	        		} else if (args.length == 1 && p.hasPermission("ultimatespawn.command.spawn.teleportothers")) {
	        			Player target = Bukkit.getServer().getPlayer(args[0]);
			
	        			if (target == null) {
	        				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Player-not-found"), p);
	        				return true;
	        			}
			
	        			SpawnUtils.teleportToSpawn(target, sender);
	        		}
	        	}
	    	}
	    } else {
	    	if (ConfigCSpawn.getConfig().getBoolean("Spawn.Disable-Message")) {
                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
            }
	    }
		return true;
    }

}
