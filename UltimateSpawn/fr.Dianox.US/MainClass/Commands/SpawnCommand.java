package fr.Dianox.US.MainClass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.SpawnUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigSpawn;
import fr.Dianox.US.MainClass.config.event.ConfigEVoidTP;

public class SpawnCommand implements CommandExecutor {

    MainClass instance = MainClass.getInstance();

    public SpawnCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Only-Player")));
            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("setspawn") || cmd.getName().equalsIgnoreCase("sethub") || cmd.getName().equalsIgnoreCase("setlobby")) {
        	if (args.length == 0) {
	        	if (p.hasPermission("UltimateSpawn.SetSpawn")) {
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
        		if (p.hasPermission("UltimateSpawn.SetSpawn")) {
	                if (!(sender instanceof Player)) {
	                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Only-Player"), p);
	                    return true;
	                }
	
	                Location l = p.getLocation();
	
	                ConfigEVoidTP.getConfig().set("VoidTP.Options.Spawn.world", l.getWorld().getName());
	                ConfigEVoidTP.getConfig().set("VoidTP.Options.Spawn.x", Double.valueOf(l.getX()));
	                ConfigEVoidTP.getConfig().set("VoidTP.Options.Spawn.y", Double.valueOf(l.getY()));
	                ConfigEVoidTP.getConfig().set("VoidTP.Options.Spawn.z", Double.valueOf(l.getZ()));
	                ConfigEVoidTP.getConfig().set("VoidTP.Options.Spawn.yaw", Float.valueOf(l.getYaw()));
	                ConfigEVoidTP.getConfig().set("VoidTP.Options.Spawn.pitch", Float.valueOf(l.getPitch()));
	
	                ConfigEVoidTP.saveConfigFile();
	
	                p.getWorld().setSpawnLocation((int) l.getX(), (int) l.getY(), (int) l.getZ());
	
	                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.Spawn.Set"), p);
	            } else {
	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
	            }
        	} else {
        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer("&cPlease... /setspawn voidTP", p);
        	}
        } else if (label.equalsIgnoreCase("spawn") || label.equalsIgnoreCase("hub") || label.equalsIgnoreCase("lobby") || label.equalsIgnoreCase("h") || label.equalsIgnoreCase("l")) {
            if (args.length == 0) {
                if (!(sender instanceof Player)) {
                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Only-Player"), p);
                    return true;
                }
                SpawnUtils.teleportToSpawn(p, true);
            } else if (args.length == 1) {
                if (p.hasPermission("UltimateSpawn.TeleportOthers")) {
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
        return true;
    }

}
