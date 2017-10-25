package fr.Dianox.US.MainClass.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigSpawn;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;
import fr.Dianox.US.MainClass.config.messages.ConfigMSpawn;

public class SetSpawnCommand implements CommandExecutor {

    MainClass instance = MainClass.getInstance();

    public SetSpawnCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
        	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Only-Player")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("setspawn") || cmd.getName().equalsIgnoreCase("sethub") || cmd.getName().equalsIgnoreCase("setlobby")) {
        	if (p.hasPermission("ultimatespawn.command.setspawn.setspawn") || p.hasPermission("ultimatespawn.command.setspawn.voidtp") || p.hasPermission("ultimatespawn.command.setspawn.firstspawn")) {
	        	if (args.length == 0) {
		        	if (p.hasPermission("ultimatespawn.command.setspawn.setspawn")) {
		                if (!(sender instanceof Player)) {
		                	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Only-Player")) {
		                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
		        			}
		                    return true;
		                }
		                
		                Location l = p.getLocation();
		                
		                ConfigSpawn.getConfig().set("spawn.world", l.getWorld().getName());
		                ConfigSpawn.getConfig().set("spawn.x", Double.valueOf(l.getX()));
		                ConfigSpawn.getConfig().set("spawn.y", Double.valueOf(l.getY()));
		                ConfigSpawn.getConfig().set("spawn.z", Double.valueOf(l.getZ()));
		                ConfigSpawn.getConfig().set("spawn.yaw", Float.valueOf(l.getYaw()));
		                ConfigSpawn.getConfig().set("spawn.pitch", Float.valueOf(l.getPitch()));
		                
		                ConfigSpawn.saveConfigFile();
		                
		                p.getWorld().setSpawnLocation((int) l.getX(), (int) l.getY(), (int) l.getZ());
		                
		                for (String msg: ConfigMSpawn.getConfig().getStringList("Admin.Spawn-set")) {
	                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                	}
		            } else {
		            	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
	                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                	}
		            }
	        	} else if (args[0].equalsIgnoreCase("voidtp")) {
	        		if (p.hasPermission("ultimatespawn.command.setspawn.voidtp")) {
		                if (!(sender instanceof Player)) {
		                	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Only-Player")) {
		                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
		        			}
		                    return true;
		                }
		
		                Location l = p.getLocation();
		
		                ConfigSpawn.getConfig().set("VoidTP.Spawn.world", l.getWorld().getName());
		                ConfigSpawn.getConfig().set("VoidTP.Spawn.x", Double.valueOf(l.getX()));
		                ConfigSpawn.getConfig().set("VoidTP.Spawn.y", Double.valueOf(l.getY()));
		                ConfigSpawn.getConfig().set("VoidTP.Spawn.z", Double.valueOf(l.getZ()));
		                ConfigSpawn.getConfig().set("VoidTP.Spawn.yaw", Float.valueOf(l.getYaw()));
		                ConfigSpawn.getConfig().set("VoidTP.Spawn.pitch", Float.valueOf(l.getPitch()));
		
		                ConfigSpawn.saveConfigFile();
		
		                p.getWorld().setSpawnLocation((int) l.getX(), (int) l.getY(), (int) l.getZ());
		
		                for (String msg: ConfigMSpawn.getConfig().getStringList("Admin.Spawn-set")) {
	                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                	}
		            } else {
		            	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
	                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                	}
		            }	
	        	} else if (args[0].equalsIgnoreCase("firstspawn")) {
	        		if (p.hasPermission("ultimatespawn.command.setspawn.firstspawn")) {
		                if (!(sender instanceof Player)) {
		                	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Only-Player")) {
		                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
		        			}
		                    return true;
		                }
		
		                Location l = p.getLocation();
		
		                ConfigSpawn.getConfig().set("FirstSpawn.Spawn.world", l.getWorld().getName());
		                ConfigSpawn.getConfig().set("FirstSpawn.Spawn.x", Double.valueOf(l.getX()));
		                ConfigSpawn.getConfig().set("FirstSpawn.Spawn.y", Double.valueOf(l.getY()));
		                ConfigSpawn.getConfig().set("FirstSpawn.Spawn.z", Double.valueOf(l.getZ()));
		                ConfigSpawn.getConfig().set("FirstSpawn.Spawn.yaw", Float.valueOf(l.getYaw()));
		                ConfigSpawn.getConfig().set("FirstSpawn.Spawn.pitch", Float.valueOf(l.getPitch()));
		
		                ConfigSpawn.saveConfigFile();
		
		                p.getWorld().setSpawnLocation((int) l.getX(), (int) l.getY(), (int) l.getZ());
		
		                for (String msg: ConfigMSpawn.getConfig().getStringList("Admin.Spawn-set")) {
	                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                	}
		            } else {
		            	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
	                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                	}
		            }
	        	} else {
	        		for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Arguments-Missing")) {
                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
                	}
	        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer("&c/setspawn [voidTP|firstspawn]", p);
	            }
	        } else {
	        	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
            	}
	        }
        }
        return true;
    }
}
