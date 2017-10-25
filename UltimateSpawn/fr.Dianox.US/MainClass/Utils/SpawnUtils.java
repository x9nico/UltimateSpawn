package fr.Dianox.US.MainClass.Utils;

import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.config.ConfigPlayerStats;
import fr.Dianox.US.MainClass.config.ConfigSpawn;
import fr.Dianox.US.MainClass.config.event.ConfigEVoidTP;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;
import fr.Dianox.US.MainClass.config.messages.ConfigMSpawn;

public class SpawnUtils {

    public static void teleportToSpawn(Player player) {
        try {
            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigSpawn.getConfig().getString("spawn.world"));
            double x = ConfigSpawn.getConfig().getDouble("spawn.x");
            double y = ConfigSpawn.getConfig().getDouble("spawn.y");
            double z = ConfigSpawn.getConfig().getDouble("spawn.z");
            float yaw = ConfigSpawn.getConfig().getInt("spawn.yaw");
            float pitch = ConfigSpawn.getConfig().getInt("spawn.pitch");

            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));
        } catch (Exception e) {
            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");
            
            for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Spawn-not-set")) {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
            }
        }
    }
    
    public static void teleportToSpawnStats(Player player) {
        try {
            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigPlayerStats.getConfig().getString(player.getUniqueId()+".Position.Last_logout.World"));
            double x = ConfigPlayerStats.getConfig().getDouble(player.getUniqueId()+".Position.Last_logout.x");
            double y = ConfigPlayerStats.getConfig().getDouble(player.getUniqueId()+".Position.Last_logout.y");
            double z = ConfigPlayerStats.getConfig().getDouble(player.getUniqueId()+".Position.Last_logout.z");
            float yaw = ConfigPlayerStats.getConfig().getInt(player.getUniqueId()+".Position.Last_logout.yaw");
            float pitch = ConfigPlayerStats.getConfig().getInt(player.getUniqueId()+".Position.Last_logout.pitch");

            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));
        } catch (Exception e) {
            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Error either in the plugin or in your configuration");
        }
    }

    public static void teleportToSpawn(Player player, boolean message) {
        try {
            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigSpawn.getConfig().getString("spawn.world"));
            double x = ConfigSpawn.getConfig().getDouble("spawn.x");
            double y = ConfigSpawn.getConfig().getDouble("spawn.y");
            double z = ConfigSpawn.getConfig().getDouble("spawn.z");
            float yaw = ConfigSpawn.getConfig().getInt("spawn.yaw");
            float pitch = ConfigSpawn.getConfig().getInt("spawn.pitch");

            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));

            if (message) {
            	for (String msg: ConfigMSpawn.getConfig().getStringList("Teleport.Spawn")) {
                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
                }
            }
        } catch (Exception e) {
            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");

            for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Spawn-not-set")) {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
            }
        }
    }

    public static void teleportToSpawn(Player player, org.bukkit.command.CommandSender sender) {
        try {
            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigSpawn.getConfig().getString("spawn.world"));
            double x = ConfigSpawn.getConfig().getDouble("spawn.x");
            double y = ConfigSpawn.getConfig().getDouble("spawn.y");
            double z = ConfigSpawn.getConfig().getDouble("spawn.z");
            float yaw = ConfigSpawn.getConfig().getInt("spawn.yaw");
            float pitch = ConfigSpawn.getConfig().getInt("spawn.pitch");

            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));

            for (String msg: ConfigMSpawn.getConfig().getStringList("Teleport.Spawn")) {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
            }
            for (String msg: ConfigMSpawn.getConfig().getStringList("Teleport.Spawn-Other")) {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
            }
        } catch (Exception e) {
            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");

            for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Spawn-not-set")) {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
            }
        }
    }
    
    public static void teleportToVoidTP(Player player) {
    	if (!ConfigEVoidTP.getConfig().getBoolean("VoidTP.Options.Custom-Spawn")) {
	        try {
	            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigSpawn.getConfig().getString("spawn.world"));
	            double x = ConfigSpawn.getConfig().getDouble("spawn.x");
	            double y = ConfigSpawn.getConfig().getDouble("spawn.y");
	            double z = ConfigSpawn.getConfig().getDouble("spawn.z");
	            float yaw = ConfigSpawn.getConfig().getInt("spawn.yaw");
	            float pitch = ConfigSpawn.getConfig().getInt("spawn.pitch");
	
	            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));
	        } catch (Exception e) {
	            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");
	
	            for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Spawn-not-set")) {
	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
	            }
	        }
    	} else {
    		try {
	            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigEVoidTP.getConfig().getString("VoidTP.Options.Spawn.world"));
	            double x = ConfigSpawn.getConfig().getDouble("VoidTP.Spawn.x");
	            double y = ConfigSpawn.getConfig().getDouble("VoidTP.Spawn.y");
	            double z = ConfigSpawn.getConfig().getDouble("VoidTP.Spawn.z");
	            float yaw = ConfigSpawn.getConfig().getInt("VoidTP.Spawn.yaw");
	            float pitch = ConfigSpawn.getConfig().getInt("VoidTP.Spawn.pitch");
	
	            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));
	        } catch (Exception e) {
	            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");
	
	            for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Spawn-not-set")) {
	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
	            }
	        }
    	}
    }
    
    public static void teleportToFirstSpawn(Player player) {
        try {
            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigSpawn.getConfig().getString("FirstSpawn.Spawn.world"));
            double x = ConfigSpawn.getConfig().getDouble("FirstSpawn.Spawn.x");
            double y = ConfigSpawn.getConfig().getDouble("FirstSpawn.Spawn.y");
            double z = ConfigSpawn.getConfig().getDouble("FirstSpawn.Spawn.z");
            float yaw = ConfigSpawn.getConfig().getInt("FirstSpawn.Spawn.yaw");
            float pitch = ConfigSpawn.getConfig().getInt("FirstSpawn.Spawn.pitch");

            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));
        } catch (Exception e) {
            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");

            for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Spawn-not-set")) {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
            }
        }
    }

}
