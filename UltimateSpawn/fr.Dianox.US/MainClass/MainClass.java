package fr.Dianox.US.MainClass;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Dianox.US.MainClass.Commands.AnnounceCommand;
import fr.Dianox.US.MainClass.Commands.MainCommand;
import fr.Dianox.US.MainClass.Commands.PingCommand;
import fr.Dianox.US.MainClass.Commands.SpawnCommand;
import fr.Dianox.US.MainClass.Commands.Chat.ClearChatCommand;
import fr.Dianox.US.MainClass.Commands.Chat.DelaychatCommand;
import fr.Dianox.US.MainClass.Commands.Chat.MuteChatCommand;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigPlayerOptions;
import fr.Dianox.US.MainClass.config.ConfigPlayerStats;
import fr.Dianox.US.MainClass.config.ConfigSpawn;
import fr.Dianox.US.MainClass.event.BasicFeatures;
import fr.Dianox.US.MainClass.event.OnChat;
import fr.Dianox.US.MainClass.event.OnJoin;
import fr.Dianox.US.MainClass.event.OnQuit;

public class MainClass extends JavaPlugin implements Listener {
	
	private static MainClass instance;
	public static List<String> worlds_damage = new ArrayList<String>();
	public static List<String> worlds_hunger = new ArrayList<String>();
	public static List<String> worlds_weather = new ArrayList<String>();
	public static List<String> worlds_burn_block = new ArrayList<String>();
	public static List<String> worlds_explosions = new ArrayList<String>();
	public static List<String> worlds_death_message = new ArrayList<String>();
	public static List<String> worlds_spawning_mob_animals = new ArrayList<String>();
	public static List<String> worlds_c_place = new ArrayList<String>();
	public static List<String> worlds_c_break = new ArrayList<String>();
	
	public MainClass() {}
	
	public void onEnable() {
		System.out.println("|=============================");
		System.out.println("|");
		System.out.println("| Ultimate Spawn load! Please wait!");
		System.out.println("| >>> Version 0.3-Alpha");
		System.out.println("| ");
		
		instance = this;
		
		ConfigGlobal.loadConfig((Plugin) this);
		System.out.println("| Main config loaded");
		ConfigMessage.loadConfig((Plugin) this);
		System.out.println("| Message config loaded");
		ConfigSpawn.loadConfig((Plugin) this);
		System.out.println("| Spawn config loaded");
		ConfigPlayerOptions.loadConfig((Plugin) this);
		System.out.println("| Player config 1/2 loaded");
		ConfigPlayerStats.loadConfig((Plugin) this);
		System.out.println("|               2/2 loaded");
		
		System.out.println("|");
		
		getCommand("ultimatespawn").setExecutor(new MainCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("setspawn").setExecutor(new SpawnCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("cc").setExecutor(new ClearChatCommand());
		getCommand("bc").setExecutor(new AnnounceCommand());
		getCommand("GlobalMute").setExecutor(new MuteChatCommand());
		getCommand("DelayChat").setExecutor(new DelaychatCommand());
		System.out.println("| Commands loaded");
		
		System.out.println("|");
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BasicFeatures(), this);
		pm.registerEvents(new OnJoin(), this);
		pm.registerEvents(new OnQuit(), this);
		pm.registerEvents(new OnChat(), this);
		System.out.println("| Events loaded");
		
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            Bukkit.getPluginManager().registerEvents(this, this);
        	System.out.println("|");
        	System.out.println("| PlaceHolderApi detected");
        	System.out.println("|");
        } else {
        	ConfigGlobal.getConfig().set("Plugin.Use.PlaceholderAPI", Boolean.valueOf(false));
        	System.out.println("|");
        	System.out.println("| USE PLACEHOLDERAPI IS VERY VERY HIGHLY RECOMMENDED");
        	System.out.println("|");
        }
		
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Hunger.Enable")) {
	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Hunger.World.All_World")) {
	            for (String worldHunger : ConfigGlobal.getConfig().getStringList("Server.Disable.Hunger.World.Worlds")) {
	            	if (Bukkit.getWorld(worldHunger) == null) {
	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Hunger.World: "+worldHunger);
	            	} else {
	            		worlds_hunger.add(worldHunger);
	            	}
	            }
	        }
        }
        
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Damage.Enable")) {
	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Damage.World.All_World")) {
	            for (String worldDamage : ConfigGlobal.getConfig().getStringList("Server.Disable.Damage.World.Worlds")) {
	            	if (Bukkit.getWorld(worldDamage) == null) {
	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Damage.World: "+worldDamage);
	            	} else {
	            		worlds_damage.add(worldDamage);
	            	}
	            }
	        }
        }
        
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Weather.Enable")) {
	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Weather.World.All_World")) {
	            for (String worldWeather : ConfigGlobal.getConfig().getStringList("Server.Disable.Weather.World.Worlds")) {
	            	if (Bukkit.getWorld(worldWeather) == null) {
	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Weather.World: "+worldWeather);
	            	} else {
	            		worlds_weather.add(worldWeather);
	            	}
	            }
	        }
        }
        
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Burn-block.Enable")) {
	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Burn-block.World.All_World")) {
	            for (String worldBurnblock : ConfigGlobal.getConfig().getStringList("Server.Disable.Burn-block.World.Worlds")) {
	            	if (Bukkit.getWorld(worldBurnblock) == null) {
	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Burn-block.World: "+worldBurnblock);
	            	} else {
	            		worlds_burn_block.add(worldBurnblock);
	            	}
	            }
	        }
        }
        
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Explosion.Enable")) {
	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Explosion.World.All_World")) {
	            for (String worldExplosion : ConfigGlobal.getConfig().getStringList("Server.Disable.Explosion.World.Worlds")) {
	            	if (Bukkit.getWorld(worldExplosion) == null) {
	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Explosion.World: "+worldExplosion);
	            	} else {
	            		worlds_explosions.add(worldExplosion);
	            	}
	            }
	        }
        }
        
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Death-Message.Enable")) {
	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Death-Message.World.All_World")) {
	            for (String worldDM : ConfigGlobal.getConfig().getStringList("Server.Disable.Death-Message.World.Worlds")) {
	            	if (Bukkit.getWorld(worldDM) == null) {
	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Death-Message.World: "+worldDM);
	            	} else {
	            		worlds_death_message.add(worldDM);
	            	}
	            }
	        }
        }
        
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.Enable")) {
	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.World.All_World")) {
	            for (String worldSMA : ConfigGlobal.getConfig().getStringList("Server.Disable.Spawning-Monster-Animals.World.Worlds")) {
	            	if (Bukkit.getWorld(worldSMA) == null) {
	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Spawning-Monster-Animals.World: "+worldSMA);
	            	} else {
	            		worlds_spawning_mob_animals.add(worldSMA);
	            	}
	            }
	        }
        }
        
        if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Place.Enable")) {
	        if (!ConfigGlobal.getConfig().getBoolean("Protection.Construct.Place.World.All_World")) {
	            for (String world : ConfigGlobal.getConfig().getStringList("Protection.Construct.Place.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Config.yml, Protection.Construct.Place.World: "+world);
	            	} else {
	            		worlds_c_place.add(world);
	            	}
	            }
	        }
        }
        
        if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Break.Enable")) {
	        if (!ConfigGlobal.getConfig().getBoolean("Protection.Construct.Break.World.All_World")) {
	            for (String world : ConfigGlobal.getConfig().getStringList("Protection.Construct.Break.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Config.yml, Protection.Construct.Break.World: "+world);
	            	} else {
	            		worlds_c_break.add(world);
	            	}
	            }
	        }
        }
        
		System.out.println("| And many things.... I think... x'D");
		System.out.println("|");
		System.out.println("| Ultimate Spawn loaded!");
		System.out.println("|");
		System.out.println("|=============================");
	}

	public void onDisable() {
		
	}
		
	public static MainClass getInstance() {
		return instance;
	}
	
	public static List<String> getWD () {
		return worlds_damage;
	}
	
	public static List<String> getWH () {
		return worlds_hunger;
	}
	
	public static List<String> getWW () {
		return worlds_weather;
	}
	
	public static List<String> getWBB () {
		return worlds_burn_block;
	}
	
	public static List<String> getWE () {
		return worlds_explosions;
	}
	
	public static List<String> getWDM () {
		return worlds_death_message;
	}
	
	public static List<String> getWSMA () {
		return worlds_spawning_mob_animals;
	}
	
	public static List<String> getWPCP () {
		return worlds_c_place;
	}
	
	public static List<String> getWPCB () {
		return worlds_c_break;
	}

}
