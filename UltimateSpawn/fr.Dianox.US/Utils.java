package fr.Dianox.US;

import org.bukkit.entity.Player;

import fr.Dianox.US.config.ConfigMessage;
import fr.Dianox.US.config.ConfigSpawn;

public class Utils {
	
	public Utils() {}
	  
	public static void teleportToSpawn(Player player){
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
			
			player.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("spawn.Spawn-not-set")));
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
	      
			if (message){
				player.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("spawn.Teleport-to-spawn")));
			}
		} catch (Exception e) {
			org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");
	      
			player.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("spawn.Spawn-not-set")));
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
	      
			player.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("spawn.Teleport-to-spawn")));
			sender.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("spawn.Teleport-other-player")).replaceAll("%target%", player.getName()));
		} catch (Exception e) {
			org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");
	      
			sender.sendMessage(org.bukkit.ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("spawn.Spawn-not-set")));
		}
	}
	
	
}
