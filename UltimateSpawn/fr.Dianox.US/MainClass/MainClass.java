package fr.Dianox.US.MainClass;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
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
import fr.Dianox.US.MainClass.Utils.OtherUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigPlayerOptions;
import fr.Dianox.US.MainClass.config.ConfigPlayerStats;
import fr.Dianox.US.MainClass.config.ConfigSpawn;
import fr.Dianox.US.MainClass.config.command.ConfigCGlobal;
import fr.Dianox.US.MainClass.config.fun.ConfigFJumpad;
import fr.Dianox.US.MainClass.config.global.ConfigGCos;
import fr.Dianox.US.MainClass.config.global.ConfigGFly;
import fr.Dianox.US.MainClass.config.global.ConfigGGM;
import fr.Dianox.US.MainClass.config.global.ConfigGHF;
import fr.Dianox.US.MainClass.config.global.ConfigGInventory;
import fr.Dianox.US.MainClass.config.global.ConfigGMessage;
import fr.Dianox.US.MainClass.config.global.ConfigGMessageQ;
import fr.Dianox.US.MainClass.config.global.ConfigGPlayerItems;
import fr.Dianox.US.MainClass.config.global.ConfigGProtection;
import fr.Dianox.US.MainClass.config.global.ConfigGServerEvent;
import fr.Dianox.US.MainClass.config.global.ConfigGSpawn;
import fr.Dianox.US.MainClass.config.global.ConfigGTitle;
import fr.Dianox.US.MainClass.config.global.ConfigGXP;
import fr.Dianox.US.MainClass.event.BasicFeatures;
import fr.Dianox.US.MainClass.event.FunFeatures;
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
	public static List<String> worlds_XP_Exp = new ArrayList<String>();
	public static List<String> worlds_XP_Lvl = new ArrayList<String>();
	public static List<String> worlds_Fly = new ArrayList<String>();
	public static List<String> worlds_GM = new ArrayList<String>();
	public static List<String> worlds_Food = new ArrayList<String>();
	public static List<String> worlds_Health = new ArrayList<String>();
	public static List<String> worlds_firework = new ArrayList<String>();
	public static List<String> worlds_sounds_join = new ArrayList<String>();
	public static List<String> worlds_force_selected_slot = new ArrayList<String>();
	public static List<String> worlds_inventory = new ArrayList<String>();
	public static List<String> worlds_first_join_title = new ArrayList<String>();
	public static List<String> worlds_join_title = new ArrayList<String>();
	public static List<String> worlds_message_join = new ArrayList<String>();
	public static List<String> worlds_broadcast_message_join = new ArrayList<String>();
	public static List<String> worlds_message_newjoin = new ArrayList<String>();
	public static List<String> worlds_broadcast_message_newjoin = new ArrayList<String>();
	public static List<String> worlds_clear_chat = new ArrayList<String>();
	public static List<String> worlds_broadcast_quit = new ArrayList<String>();
	public static List<String> worlds_item_drop = new ArrayList<String>();
	public static List<String> worlds_item_pickup = new ArrayList<String>();
	public static List<String> worlds_item_damageitem = new ArrayList<String>();
	public static List<String> worlds_item_clearondrop = new ArrayList<String>();
	public static List<String> worlds_item_move = new ArrayList<String>();
	public static List<String> worlds_jumppads = new ArrayList<String>();
	
	short config_number = 13;
	short config_number_commands = 1;
	short config_number_fun = 1;
	
	public MainClass() {}
	
	public void onEnable() {
		System.out.println("|=============================");
		System.out.println("|");
		System.out.println("| Ultimate Spawn load! Please wait!");
		System.out.println("| >>> Version 0.4.1-Alpha");
		System.out.println("| ");
		
		instance = this;
		
		ConfigGXP.loadConfig((Plugin) this);
		System.out.println("| (Global) Config 1/"+config_number+" loaded");
		ConfigGFly.loadConfig((Plugin) this);
		System.out.println("|                 2/"+config_number+" loaded");
		ConfigGGM.loadConfig((Plugin) this);
		System.out.println("|                 3/"+config_number+" loaded");
		ConfigGHF.loadConfig((Plugin) this);
		System.out.println("|                 4/"+config_number+" loaded");
		ConfigGCos.loadConfig((Plugin) this);
		System.out.println("|                 5/"+config_number+" loaded");
		ConfigGInventory.loadConfig((Plugin) this);
		System.out.println("|                 6/"+config_number+" loaded");
		ConfigGTitle.loadConfig((Plugin) this);
		System.out.println("|                 7/"+config_number+" loaded");
		ConfigGMessage.loadConfig((Plugin) this);
		System.out.println("|                 8/"+config_number+" loaded");
		ConfigGSpawn.loadConfig((Plugin) this);
		System.out.println("|                 9/"+config_number+" loaded");
		ConfigGMessageQ.loadConfig((Plugin) this);
		System.out.println("|                10/"+config_number+" loaded");
		ConfigGServerEvent.loadConfig((Plugin) this);
		System.out.println("|                11/"+config_number+" loaded");
		ConfigGPlayerItems.loadConfig((Plugin) this);
		System.out.println("|                12/"+config_number+" loaded");
		ConfigGProtection.loadConfig((Plugin) this);
		System.out.println("|                13/"+config_number+" loaded");
		ConfigCGlobal.loadConfig((Plugin) this);
		System.out.println("| (Commands) Config 1/"+config_number_commands+" loaded");
		ConfigFJumpad.loadConfig((Plugin) this);
		System.out.println("| (Fun)      Config 1/"+config_number_fun+" loaded");
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
		pm.registerEvents(new FunFeatures(), this);
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
		
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Hunger.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Hunger.World.All_World")) {
	            for (String worldHunger : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Hunger.World.Worlds")) {
	            	if (Bukkit.getWorld(worldHunger) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Hunger.World: "+worldHunger);
	            	} else {
	            		worlds_hunger.add(worldHunger);
	            	}
	            }
	        }
        }
        
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Damage.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Damage.World.All_World")) {
	            for (String worldDamage : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Damage.World.Worlds")) {
	            	if (Bukkit.getWorld(worldDamage) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Damage.World: "+worldDamage);
	            	} else {
	            		worlds_damage.add(worldDamage);
	            	}
	            }
	        }
        }
        
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Weather.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Weather.World.All_World")) {
	            for (String worldWeather : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Weather.World.Worlds")) {
	            	if (Bukkit.getWorld(worldWeather) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Weather.World: "+worldWeather);
	            	} else {
	            		worlds_weather.add(worldWeather);
	            	}
	            }
	        }
        }
        
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Burn-block.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Burn-block.World.All_World")) {
	            for (String worldBurnblock : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Burn-block.World.Worlds")) {
	            	if (Bukkit.getWorld(worldBurnblock) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Burn-block.World: "+worldBurnblock);
	            	} else {
	            		worlds_burn_block.add(worldBurnblock);
	            	}
	            }
	        }
        }
        
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Explosion.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Explosion.World.All_World")) {
	            for (String worldExplosion : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Explosion.World.Worlds")) {
	            	if (Bukkit.getWorld(worldExplosion) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Explosion.World: "+worldExplosion);
	            	} else {
	            		worlds_explosions.add(worldExplosion);
	            	}
	            }
	        }
        }
        
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Death-Message.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Death-Message.World.All_World")) {
	            for (String worldDM : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Death-Message.World.Worlds")) {
	            	if (Bukkit.getWorld(worldDM) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Death-Message.World: "+worldDM);
	            	} else {
	            		worlds_death_message.add(worldDM);
	            	}
	            }
	        }
        }
        
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.World.All_World")) {
	            for (String worldSMA : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Spawning-Monster-Animals.World.Worlds")) {
	            	if (Bukkit.getWorld(worldSMA) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Spawning-Monster-Animals.World: "+worldSMA);
	            	} else {
	            		worlds_spawning_mob_animals.add(worldSMA);
	            	}
	            }
	        }
        }
        
        if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.Enable")) {
	        if (!ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.World.All_World")) {
	            for (String world : ConfigGProtection.getConfig().getStringList("Protection.Construct.Place.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-Protection.yml, Protection.Construct.Place.World: "+world);
	            	} else {
	            		worlds_c_place.add(world);
	            	}
	            }
	        }
        }
        
        if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.Enable")) {
	        if (!ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.World.All_World")) {
	            for (String world : ConfigGProtection.getConfig().getStringList("Protection.Construct.Break.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-Protection.yml, Protection.Construct.Break.World: "+world);
	            	} else {
	            		worlds_c_break.add(world);
	            	}
	            }
	        }
        }
        
        // Reset XP
        if (ConfigGXP.getConfig().getBoolean("XP.Options.Exp.Enable")) {
	        if (!ConfigGXP.getConfig().getBoolean("XP.Options.Exp.World.All_World")) {
	            for (String world : ConfigGXP.getConfig().getStringList("XP.Options.Exp.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Experience-OnJoin-config.yml, XP.Options.Exp.World: "+world);
	            	} else {
	            		worlds_XP_Exp.add(world);
	            	}
	            }
	        }
        }
        
        if (ConfigGXP.getConfig().getBoolean("XP.Options.Level.Enable")) {
	        if (!ConfigGXP.getConfig().getBoolean("XP.Options.Level.World.All_World")) {
	            for (String world : ConfigGXP.getConfig().getStringList("XP.Options.Level.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Experience-OnJoin.yml, XP.Options.Level.World: "+world);
	            	} else {
	            		worlds_XP_Lvl.add(world);
	            	}
	            }
	        }
        }
        
        // Fly
        if (ConfigGFly.getConfig().getBoolean("Fly.Enable")) {
	        if (!ConfigGFly.getConfig().getBoolean("Fly.World.All_World")) {
	            for (String world : ConfigGFly.getConfig().getStringList("Fly.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Fly-OnJoin.yml, Fly.World: "+world);
	            	} else {
	            		worlds_Fly.add(world);
	            	}
	            }
	        }
        }
        
        // Gamemode
        if (ConfigGGM.getConfig().getBoolean("Gamemode.Enable")) {
	        if (!ConfigGGM.getConfig().getBoolean("Gamemode.World.All_World")) {
	            for (String world : ConfigGGM.getConfig().getStringList("Gamemode.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Gamemode-OnJoin.yml, Gamemode.World: "+world);
	            	} else {
	            		worlds_GM.add(world);
	            	}
	            }
	        }
        }
        
        // REstore Food and Health
        if (ConfigGHF.getConfig().getBoolean("Restore.Food.Enable")) {
	        if (!ConfigGHF.getConfig().getBoolean("Restore.Food.World.All_World")) {
	            for (String world : ConfigGHF.getConfig().getStringList("Restore.Food.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Health-Food-OnJoin.yml, Restore.Food.World: "+world);
	            	} else {
	            		worlds_Food.add(world);
	            	}
	            }
	        }
        }
        
        if (ConfigGHF.getConfig().getBoolean("Restore.Health.Enable")) {
	        if (!ConfigGHF.getConfig().getBoolean("Restore.Health.World.All_World")) {
	            for (String world : ConfigGHF.getConfig().getStringList("Restore.Health.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Health-Food-OnJoin.yml, Restore.Health.World: "+world);
	            	} else {
	            		worlds_Health.add(world);
	            	}
	            }
	        }
        }
        
        // Firework
        if (ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Enable")) {
	        if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.World.All_World")) {
	            for (String world : ConfigGCos.getConfig().getStringList("Cosmetics.Firework.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Cosmetics-OnJoin.yml, Cosmetics.Firework.World: "+world);
	            	} else {
	            		worlds_firework.add(world);
	            	}
	            }
	        }
        }
        
        // Sounds
        if (ConfigGCos.getConfig().getBoolean("Cosmetics.Sounds.Enable")) {
	        if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Sounds.World.All_World")) {
	            for (String world : ConfigGCos.getConfig().getStringList("Cosmetics.Sounds.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Cosmetics-OnJoin.yml, Cosmetics.Sounds.World: "+world);
	            	} else {
	            		worlds_sounds_join.add(world);
	            	}
	            }
	        }
        }
        
        // Inventory //
        // Force selected slot
        if (ConfigGInventory.getConfig().getBoolean("Inventory.Force-Selected-Slot.Enable")) {
	        if (!ConfigGInventory.getConfig().getBoolean("Inventory.Force-Selected-Slot.World.All_World")) {
	            for (String world : ConfigGInventory.getConfig().getStringList("Inventory.Force-Selected-Slot.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Inventory-OnJoin.yml, Inventory.Force-Selected-Slot.World: "+world);
	            	} else {
	            		worlds_force_selected_slot.add(world);
	            	}
	            }
	        }
        }
        
        // inventory
        if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Enable")) {
	        if (!ConfigGInventory.getConfig().getBoolean("Inventory.Clear.World.All_World")) {
	            for (String world : ConfigGInventory.getConfig().getStringList("Inventory.Clear.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Inventory-OnJoin.yml, Inventory.Clear.World: "+world);
	            	} else {
	            		worlds_inventory.add(world);
	            	}
	            }
	        }
        }
        
        // Title //
        // First Join
        if (ConfigGTitle.getConfig().getBoolean("Title.First-Join.Enable")) {
	        if (!ConfigGTitle.getConfig().getBoolean("Title.First-Join.World.All_World")) {
	            for (String world : ConfigGTitle.getConfig().getStringList("Title.First-Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Title-OnJoin.yml, Title.First-Join.World: "+world);
	            	} else {
	            		worlds_first_join_title.add(world);
	            	}
	            }
	        }
        }
        
        // Join
        if (ConfigGTitle.getConfig().getBoolean("Title.Join.Enable")) {
	        if (!ConfigGTitle.getConfig().getBoolean("Title.Join.World.All_World")) {
	            for (String world : ConfigGTitle.getConfig().getStringList("Title.Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Title-OnJoin.yml, Title.Join.World: "+world);
	            	} else {
	            		worlds_join_title.add(world);
	            	}
	            }
	        }
        }
        
        // Messages //
        // Join
        if (ConfigGMessage.getConfig().getBoolean("Message.Join.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Message.Join.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Message.Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Message.Join.World: "+world);
	            	} else {
	            		worlds_message_join.add(world);
	            	}
	            }
	        }
        }
        
        // Broadcast Join
        if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Broadcast.Join.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Broadcast.Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Broadcast.Join.World: "+world);
	            	} else {
	            		worlds_broadcast_message_join.add(world);
	            	}
	            }
	        }
        }
        
        // Join New
        if (ConfigGMessage.getConfig().getBoolean("Message.First-Join.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Message.First-Join.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Message.First-Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Message.First-Join.World: "+world);
	            	} else {
	            		worlds_message_newjoin.add(world);
	            	}
	            }
	        }
        }
        
        // Broadcast Join New
        if (ConfigGMessage.getConfig().getBoolean("Broadcast.First-Join.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Broadcast.First-Join.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Broadcast.First-Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Broadcast.First-Join.World: "+world);
	            	} else {
	            		worlds_broadcast_message_newjoin.add(world);
	            	}
	            }
	        }
        }
        
        // Clear chat
        if (ConfigGMessage.getConfig().getBoolean("Chat.Clear.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Chat.Clear.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Chat.Clear.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Chat.Clear.World: "+world);
	            	} else {
	            		worlds_clear_chat.add(world);
	            	}
	            }
	        }
        }
        
        // Broadcast Quit
        if (ConfigGMessageQ.getConfig().getBoolean("Broadcast.Quit.Enable")) {
	        if (!ConfigGMessageQ.getConfig().getBoolean("Broadcast.Quit.World.All_World")) {
	            for (String world : ConfigGMessageQ.getConfig().getStringList("Broadcast.Quit.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-OnQuit.yml, Broadcast.Quit.World: "+world);
	            	} else {
	            		worlds_broadcast_quit.add(world);
	            	}
	            }
	        }
        }
        
        // SERVER PLAYER ITEM //
        // Drop
        if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Drop.Disable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Drop.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.Drop.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.Drop.World: "+world);
	            	} else {
	            		worlds_item_drop.add(world);
	            	}
	            }
	        }
        }
        
        // PickUp
        if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.PickUp.Disable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.PickUp.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.PickUp.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.PickUp.World: "+world);
	            	} else {
	            		worlds_item_pickup.add(world);
	            	}
	            }
	        }
        }
        
        // Damage item
        if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Damage-Item.Disable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Damage-Item.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.Damage-Item.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.Damage-Item.World: "+world);
	            	} else {
	            		worlds_item_damageitem.add(world);
	            	}
	            }
	        }
        }
        
        // Clear Drops
        if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.Enable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.Clear-Drops-On-Death.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.Clear-Drops-On-Death.World: "+world);
	            	} else {
	            		worlds_item_clearondrop.add(world);
	            	}
	            }
	        }
        }
        
        // Move Item
        if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Move.Disable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Move.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.Move.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.Move.World: "+world);
	            	} else {
	            		worlds_item_move.add(world);
	            	}
	            }
	        }
        }
        
        // FUN //
        // Jump Pads
        if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Enable")) {
	        if (!ConfigFJumpad.getConfig().getBoolean("JumpPads.World.All_World")) {
	            for (String world : ConfigFJumpad.getConfig().getStringList("JumpPads.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in JumpPads.yml, JumpPads.World: "+world);
	            	} else {
	            		worlds_jumppads.add(world);
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
	
	public static List<String> getWD() {
		return worlds_damage;
	}
	
	public static List<String> getWH() {
		return worlds_hunger;
	}
	
	public static List<String> getWW() {
		return worlds_weather;
	}
	
	public static List<String> getWBB() {
		return worlds_burn_block;
	}
	
	public static List<String> getWE() {
		return worlds_explosions;
	}
	
	public static List<String> getWDM() {
		return worlds_death_message;
	}
	
	public static List<String> getWSMA() {
		return worlds_spawning_mob_animals;
	}
	
	public static List<String> getWPCP() {
		return worlds_c_place;
	}
	
	public static List<String> getWPCB() {
		return worlds_c_break;
	}
	
	public static List<String> getWXPEXP() {
		return worlds_XP_Exp;
	}
	
	public static List<String> getWXPLVL() {
		return worlds_XP_Lvl;
	}
	
	public static List<String> getWFly() {
		return worlds_Fly;
	}
	
	public static List<String> getWGM() {
		return worlds_GM;
	}
	
	public static List<String> getWFood() {
		return worlds_Food;
	}
	
	public static List<String> getWHealth() {
		return worlds_Health;
	}
	
	public static List<String> getWFirework() {
		return worlds_firework;
	}
	
	public static List<String> getWSoundsJoin() {
		return worlds_sounds_join;
	}
	
	public static List<String> getWOForceSelectedSlot() {
		return worlds_force_selected_slot;
	}
	
	public static List<String> getWInventory() {
		return worlds_inventory;
	}
	
	public static List<String> getWFirstJoinTitle() {
		return worlds_first_join_title;
	}
	
	public static List<String> getWJoinTitle() {
		return worlds_join_title;
	}
	
	public static List<String> getWMsgJoin() {
		return worlds_message_join;
	}
	
	public static List<String> getWBroadcastMsgJoin() {
		return worlds_broadcast_message_join;
	}
	
	public static List<String> getWNewMsgJoin() {
		return worlds_message_newjoin;
	}
	
	public static List<String> getWNewBroadcastMsgJoin() {
		return worlds_broadcast_message_newjoin;
	}
	
	public static List<String> getWClearChat() {
		return worlds_clear_chat;
	}
	
	public static List<String> getWBroadcastQuit() {
		return worlds_broadcast_quit;
	}
	
	public static List<String> getWItemDrop() {
		return worlds_item_drop;
	}
	
	public static List<String> getWItemPickUp() {
		return worlds_item_pickup;
	}
	
	public static List<String> getWItemDamage() {
		return worlds_item_damageitem;
	}
	
	public static List<String> getWClearOnDropsOnDeath() {
		return worlds_item_clearondrop;
	}
	
	public static List<String> getWMoveItem() {
		return worlds_item_move;
	}
	
	public static List<String> getWJumpPads() {
		return worlds_jumppads;
	}
	
	@EventHandler
	public void OnJoinFirework(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
        if (ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Enable")) {
        	if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.World.All_World")) {
        		if (MainClass.getWFirework().contains(p.getWorld().getName())) {
		        	for (int i = 1; i < ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Amount"); i++) {
		        		ArrayList<Color> colors = new ArrayList<Color>();
		        		ArrayList<Color> fade = new ArrayList<Color>();
		        		List<String> lore = ConfigGCos.getConfig().getStringList("Cosmetics.Firework.Options.Colors");
		        		List<String> lore2 = ConfigGCos.getConfig().getStringList("Cosmetics.Firework.Options.Fade");
		        		for (String l1 : lore) {
		        			colors.add(OtherUtils.getColor(l1));
		        	    }
		        		for (String l2 : lore2) {
		        			fade.add(OtherUtils.getColor(l2));
		        		}
		                final Firework f = (Firework)e.getPlayer().getWorld().spawn(e.getPlayer().getLocation().add(0.5D, ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Height"), 0.5D), Firework.class);
		                
		                FireworkMeta fm = f.getFireworkMeta();
		                fm.addEffect(FireworkEffect.builder().flicker(ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Flicker"))
		                		.trail(ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Trail"))
		                		.with(FireworkEffect.Type.valueOf(ConfigGCos.getConfig().getString("Cosmetics.Firework.Options.Type"))).withColor(colors).withFade(fade)
		                		.build());
		                
		                if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Instant-explode")) {
		                	fm.setPower(ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Power"));
		                }
		                f.setFireworkMeta(fm);
		                if (ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Instant-explode")) { 
		                	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
		                      public void run() {
		                        f.detonate();
		                      }
		                    }, 5L);
		                }
		        	}
        		}
        	} else {
        		for (int i = 1; i < ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Amount"); i++) {
	        		ArrayList<Color> colors = new ArrayList<Color>();
	        		ArrayList<Color> fade = new ArrayList<Color>();
	        		List<String> lore = ConfigGCos.getConfig().getStringList("Cosmetics.Firework.Options.Colors");
	        		List<String> lore2 = ConfigGCos.getConfig().getStringList("Cosmetics.Firework.Options.Fade");
	        		for (String l1 : lore) {
	        			colors.add(OtherUtils.getColor(l1));
	        	    }
	        		for (String l2 : lore2) {
	        			fade.add(OtherUtils.getColor(l2));
	        		}
	                final Firework f = (Firework)e.getPlayer().getWorld().spawn(e.getPlayer().getLocation().add(0.5D, ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Height"), 0.5D), Firework.class);
	                
	                FireworkMeta fm = f.getFireworkMeta();
	                fm.addEffect(FireworkEffect.builder().flicker(ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Flicker"))
	                		.trail(ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Trail"))
	                		.with(FireworkEffect.Type.valueOf(ConfigGCos.getConfig().getString("Cosmetics.Firework.Options.Type"))).withColor(colors).withFade(fade)
	                		.build());
	                
	                if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Instant-explode")) {
	                	fm.setPower(ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Power"));
	                }
	                f.setFireworkMeta(fm);
	                if (ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Instant-explode")) { 
	                	Bukkit.getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
	                      public void run() {
	                        f.detonate();
	                      }
	                    }, 5L);
	                }
	        	}
        	}
        }
	}
}
