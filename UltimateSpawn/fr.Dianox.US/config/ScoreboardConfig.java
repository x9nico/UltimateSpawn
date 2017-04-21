package fr.Dianox.US.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;

public class ScoreboardConfig implements Listener {

	private static Plugin pl;
	private static File ScoreboardConfigfile;
	private static YamlConfiguration ScoreboardConfig;
	  
	public ScoreboardConfig() {}
	  
	public static void loadConfig(Plugin plugin){
	    pl = plugin;
	    
	    ScoreboardConfigfile = new File(pl.getDataFolder(), "scoreboard.yml");
	    ScoreboardConfig = YamlConfiguration.loadConfiguration(ScoreboardConfigfile);
	    
	    if (!pl.getDataFolder().exists()) {
	    	pl.getDataFolder().mkdirs();
	    }
	    create();
	    
	    saveConfigFile();
	}
	  
	public static File getFile() {
	    return ScoreboardConfigfile;
	}
	  
	public static YamlConfiguration getConfig() {
	    return ScoreboardConfig;
	}
	  
	public static void reloadConfig() {
		loadConfig(pl);
	}
	  
	public static void saveConfigFile() {
		try {
			ScoreboardConfig.save(ScoreboardConfigfile);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	  
	private static void create() {
		if (!ScoreboardConfigfile.exists()) {
			try {
				ScoreboardConfigfile.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
	      
			//Spawn
			ScoreboardConfig.set("animatedboard.1.content", java.util.Arrays.asList(new String[] { "&6Welcome", "&con", "&6UltimateSpawn"}));
			ScoreboardConfig.set("animatedboard.1.update", 10);
			ScoreboardConfig.set("animatedboard.2.content", java.util.Arrays.asList(new String[] { "&6Welcome", "&cdfgdfg"}));
			ScoreboardConfig.set("animatedboard.2.update", 10);
			ScoreboardConfig.set("animatedboard.3.content", java.util.Arrays.asList(new String[] { "&6Welcome", "&cdfgdfg"}));
			ScoreboardConfig.set("animatedboard.3.update", 10);
	      
	      	saveConfigFile();
		}
	}
	
}
