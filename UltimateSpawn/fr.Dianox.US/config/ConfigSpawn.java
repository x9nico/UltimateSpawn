package fr.Dianox.US.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigSpawn {
	
	private static Plugin pl;
	private static File filespawn;
	private static YamlConfiguration ConfigSpawn;
	  
	public ConfigSpawn() {}
	  
	public static void loadSpawnConfig(Plugin plugin){
		pl = plugin;
	    
	    filespawn = new File(pl.getDataFolder(), "spawn.yml");
	    ConfigSpawn = YamlConfiguration.loadConfiguration(filespawn);
	    
	    if (!pl.getDataFolder().exists()) {
	    	pl.getDataFolder().mkdirs();
	    }
	    create();
	    
	    saveConfigFile();
	}
	  
	public static File getFile() {
		return filespawn;
	}
	  
	public static YamlConfiguration getConfig() {
	    return ConfigSpawn;
	}
	  
	public static void reloadConfig() {
	    loadSpawnConfig(pl);
	}
	  
	public static void saveConfigFile() {
		try {
			ConfigSpawn.save(filespawn);
		} catch (IOException e) {
			e.printStackTrace();
	    }
	}
	  
	private static void create() {
		if (!filespawn.exists()) {
			try {
				filespawn.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	      
			ConfigSpawn.set("spawn.world", null);
			ConfigSpawn.set("spawn.x", null);
			ConfigSpawn.set("spawn.y", null);
			ConfigSpawn.set("spawn.z", null);
			ConfigSpawn.set("spawn.yaw", null);
			ConfigSpawn.set("spawn.pitch", null);
	      
			saveConfigFile();
		}
	}

}
