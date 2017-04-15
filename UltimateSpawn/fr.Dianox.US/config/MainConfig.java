package fr.Dianox.US.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class MainConfig {
	private static Plugin pl;
	private static File file;
	private static YamlConfiguration Config;
	  
	public MainConfig() {}
	  
	public static void loadConfig(Plugin plugin){
	    pl = plugin;
	    
	    file = new File(pl.getDataFolder(), "config.yml");
	    Config = YamlConfiguration.loadConfiguration(file);
	    
	    if (!pl.getDataFolder().exists()) {
	    	pl.getDataFolder().mkdirs();
	    }
	    create();
	    
	    int gamemode = Config.getInt("options.set-gamemode-on-join.gamemode");
	    
	    if ((gamemode != 0) && (gamemode != 1) && (gamemode != 2) && (gamemode != 3)) {
	    	Config.set("options.set-gamemode-on-join.gamemode", Integer.valueOf(0));
	    }
	    
	    saveConfigFile();
	}
	  
	public static File getFile() {
	    return file;
	}
	  
	public static YamlConfiguration getConfig() {
	    return Config;
	}
	  
	public static void reloadConfig() {
		loadConfig(pl);
	}
	  
	public static void saveConfigFile() {
		try {
			Config.save(file);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  
	private static void create() {
		if (!file.exists()) {
			try {
				file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	      
			//Spawn
			Config.set("spawn.Teleport-to-spawn-on.first-join", Boolean.valueOf(true));
			Config.set("spawn.Teleport-to-spawn-on.join", Boolean.valueOf(true));
			Config.set("spawn.Teleport-to-spawn-on.respawn", Boolean.valueOf(true));
			Config.set("spawn.Teleport-to-spawn-on.void-fall", Boolean.valueOf(true));
			//Options
			Config.set("options.set-gamemode-on-join.enabled", Boolean.valueOf(true));
			Config.set("options.set-gamemode-on-join.gamemode", Integer.valueOf(2));
			Config.set("options.set-fly-on-join.enabled", Boolean.valueOf(true));
			Config.set("options.set-fly-on-join.fly", Boolean.valueOf(true));
	      		Config.set("options.set-max-health-on-join", Boolean.valueOf(true));
	     	 	Config.set("options.set-max-food-level-on-join", Boolean.valueOf(true));
	    	  	//Broadcast
	    	  	Config.set("broadcast.player-join.enabled", Boolean.valueOf(true));
	      		Config.set("broadcast.player-join.hide", Boolean.valueOf(true));
	    	  	Config.set("broadcast.player-quit.enabled", Boolean.valueOf(true));
	    	  	Config.set("broadcast.player-quit.hide", Boolean.valueOf(true));
	      		Config.set("broadcast.first-join.enabled", Boolean.valueOf(true));
	      		//Join
	      		Config.set("Join.Join-message-enabled", Boolean.valueOf(true));
	      		Config.set("Join.First-join-message-enabled", Boolean.valueOf(true));
	      		//Protection
	      		Config.set("Protection.Block.Place-block", Boolean.valueOf(true));
	      		Config.set("Protection.Block.Place-block-message", Boolean.valueOf(true));
	      		Config.set("Protection.Block.Place-block-bypass", Boolean.valueOf(false));
	      		Config.set("Protection.Block.Break-block", Boolean.valueOf(true));
	      		Config.set("Protection.Block.Break-block-message", Boolean.valueOf(true));
	      		Config.set("Protection.Block.Break-block-bypass", Boolean.valueOf(false));
			Config.set("Protection.Drop.Item", Boolean.valueOf(true));
	      		Config.set("Protection.Drop.Item-bypass", Boolean.valueOf(false));
	      		Config.set("Protection.Pickup.Item", Boolean.valueOf(true));
	      		Config.set("Protection.Pickup.Item-bypass", Boolean.valueOf(false));
			Config.set("Protection.Explosion", Boolean.valueOf(true));
	      		Config.set("Protection.AntiWeather", Boolean.valueOf(true));
	      		Config.set("Protection.MobSpawning", Boolean.valueOf(true));
	      		Config.set("Protection.DamageEvent", Boolean.valueOf(true));
	      
	 	     	saveConfigFile();
		}
	}
}
