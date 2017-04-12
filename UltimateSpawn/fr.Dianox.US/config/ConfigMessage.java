package fr.Dianox.US.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMessage {
	
	  private static Plugin pl;
	  private static File filemessage;
	  private static YamlConfiguration configmessage;
	  
	  public ConfigMessage() {}
	  
	  public static void loadMessageConfig(Plugin plugin){
	    pl = plugin;
	    
	    filemessage = new File(pl.getDataFolder(), "message.yml");
	    configmessage = YamlConfiguration.loadConfiguration(filemessage);
	    
	    if (!pl.getDataFolder().exists()) {
	      pl.getDataFolder().mkdirs(); 
	    }
	    create();

	    saveConfigFile();
	  }
	  
	  public static File getFile() {
	    return filemessage;
	  }
	  
	  public static YamlConfiguration getConfig() {
	    return configmessage;
	  }
	  
	  public static void reloadConfig() {
	    loadMessageConfig(pl);
	  }
	  
	  public static void saveConfigFile() {
	    try {
	      configmessage.save(filemessage);
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	  }
	  
	  private static void create() {
	    if (!filemessage.exists()) {
	      try {
	        filemessage.createNewFile();
	      } catch (IOException e) {
	        e.printStackTrace();
	      }
	      
	      //Spawn
	      configmessage.set("spawn.Teleport-to-spawn", "&7Teleport to spawn...");
	      configmessage.set("spawn.Teleport-other-player", "&7%target% teleported to spawn.");
	      configmessage.set("spawn.Spawn-not-set", "&eUltimate&cSpawn &7: &cSpawn is not set");
	      configmessage.set("spawn.Spawn-create", "&eUltimate&cSpawn &7: &eThe spawn has been &6created");
	      //Join
	      configmessage.set("join.message.First-join-message", java.util.Arrays.asList(new String[] { "&6Welcome %player%!" }));
	      configmessage.set("join.message.Join-message", java.util.Arrays.asList(new String[] { "&6Welcome %player%!" }));
	      configmessage.set("join.broadcast.First-join-message", java.util.Arrays.asList(new String[] { "&6Welcome, %player%!" }));
	      configmessage.set("join.broadcast.Join-message", java.util.Arrays.asList(new String[] { "&6%player% joined the lobby!" }));
	      //Quit
	      configmessage.set("quit.broadcast.Quit-message", java.util.Arrays.asList(new String[] { "&6%player% left the lobby!" }));
	      //Others
	      configmessage.set("others.No-permission-message", "&cSorry, but you don't have permission to execute this command!");
	      configmessage.set("others.Player-not-found", "&cPlayer not found.");
	      configmessage.set("others.Console-use-command", "&eUltimate&cSpawn &7: &cOnly players can run this command.");
	      configmessage.set("others.Config-reloaded", "&eUltimate&cSpawn &7: &eConfig reloaded.");
	      
	      saveConfigFile();
	    }
	  }

}
