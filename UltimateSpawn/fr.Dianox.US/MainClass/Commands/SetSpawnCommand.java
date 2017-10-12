package fr.Dianox.US.MainClass.Commands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigSpawn;

public class SetSpawnCommand implements CommandExecutor {

    MainClass instance = MainClass.getInstance();

    public SetSpawnCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Only-Player")));
            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("setspawn") || cmd.getName().equalsIgnoreCase("sethub") || cmd.getName().equalsIgnoreCase("setlobby")) {
        	if (p.hasPermission("ultimatespawn.command.setspawn.setspawn") || p.hasPermission("ultimatespawn.command.setspawn.voidtp") || p.hasPermission("ultimatespawn.command.setspawn.firstspawn")) {
	        	if (args.length == 0) {
		        	if (p.hasPermission("ultimatespawn.command.setspawn.setspawn")) {
		                if (!(sender instanceof Player)) {
		                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Only-Player"), p);
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
		                
		                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.Spawn.Set"), p);
		            } else {
		            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
		            }
	        	} else if (args[0].equalsIgnoreCase("voidtp")) {
	        		if (p.hasPermission("ultimatespawn.command.setspawn.voidtp")) {
		                if (!(sender instanceof Player)) {
		                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Only-Player"), p);
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
		
		                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.Spawn.Set"), p);
		            } else {
		            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
		            }	
	        	} else if (args[0].equalsIgnoreCase("firstspawn")) {
	        		if (p.hasPermission("ultimatespawn.command.setspawn.firstspawn")) {
		                if (!(sender instanceof Player)) {
		                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Only-Player"), p);
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
		
		                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.Spawn.Set"), p);
		            } else {
		            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
		            }
	        	} else {
	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Arguments-Missing"), p);
	        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer("&cPlease... /setspawn [voidTP|firstspawn]", p);
	            }
	        } else {
	        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
	        }
        }
        return true;
    }
}
