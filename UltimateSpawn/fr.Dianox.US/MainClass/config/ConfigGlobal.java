package fr.Dianox.US.MainClass.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGlobal {
	
	private static Plugin pl;
	private static File file;
	private static YamlConfiguration Config;
	
	public ConfigGlobal() {}
	
	public static void loadConfig(Plugin plugin) {
		pl = plugin;
		
		file = new File(pl.getDataFolder(), "config.yml");
		Config = YamlConfiguration.loadConfiguration(file);
		
		if (!pl.getDataFolder().exists()) {
			pl.getDataFolder().mkdir();
		}
		
		create();
		
		int gamemode = Config.getInt("On-Join.Spawn.Gamemode.Gamemode");
	    
	    if ((gamemode != 0) && (gamemode != 1) && (gamemode != 2) && (gamemode != 3)) {
	    	Config.set("On-Join.Spawn.Gamemode.Gamemode", Integer.valueOf(0));
	    }
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
			
			//Server
			Config.set("Server.Disable.Hunger", Boolean.valueOf(true));
			Config.set("Server.Disable.Damage", Boolean.valueOf(true));
			Config.set("Server.Disable.Weather", Boolean.valueOf(true));
			Config.set("Server.Disable.Burn-block", Boolean.valueOf(true));
			Config.set("Server.Disable.Explosion", Boolean.valueOf(true));
			Config.set("Server.Disable.Death-Message", Boolean.valueOf(true));
			Config.set("Server.Disable.Spawning-Monster-Animals", Boolean.valueOf(true));
			Config.set("Server.Items.Drop.Disable", Boolean.valueOf(true));
			Config.set("Server.Items.Drop.Bypass", Boolean.valueOf(true));
			Config.set("Server.Items.PickUp.Disable", Boolean.valueOf(true));
			Config.set("Server.Items.PickUp.Bypass", Boolean.valueOf(true));
			Config.set("Server.Items.Damage-Item.Disable", Boolean.valueOf(true));
			Config.set("Server.Items.Damage-Item.Bypass", Boolean.valueOf(true));
			Config.set("Server.Items.Clear-Drops-On-Death.Enable", Boolean.valueOf(true));
			Config.set("Server.Items.Clear-Drops-On-Death.Bypass", Boolean.valueOf(true));
			
			// Construct
			Config.set("Protection.Construct.Construct", Boolean.valueOf(true));
			Config.set("Protection.Construct.Construct-Bypass", Boolean.valueOf(true));
			Config.set("Protection.Construct.Message", Boolean.valueOf(true));
			
			// On join
			Config.set("On-Join.Clear.Inventory.Enable", Boolean.valueOf(true));
			Config.set("On-Join.Clear.Inventory.Bypass", Boolean.valueOf(true));
			Config.set("On-Join.Clear.Inventory.Armor", Boolean.valueOf(true));
			Config.set("On-Join.Clear.Chat.Enable", Boolean.valueOf(true));
			Config.set("On-Join.Clear.Chat.Bypass", Boolean.valueOf(true));
			Config.set("On-Join.Clear.Chat.Lines-To-Clear", Integer.valueOf(150));
			Config.set("On-Join.Spawn.Teleport.Enable", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Teleport.On-First-Join", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Broadcast.First-Join.Enable", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Broadcast.First-Join.Message", java.util.Arrays.asList(new String[] { "&6Welcome %player%!", "&eSay welcome ;)" }));
			Config.set("On-Join.Spawn.Broadcast.Join.Enable", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Broadcast.Join.Hide", Boolean.valueOf(false));
			Config.set("On-Join.Spawn.Broadcast.Join.Message", java.util.Arrays.asList(new String[] { "&8[&a+&8] [&a+&8] [&a+&8] ", "Hey, %player%" }));
			Config.set("On-Join.Spawn.Message.First-Join.Enable", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Message.First-Join.Message", java.util.Arrays.asList(new String[] { "&6Welcome %player%!", "&cDon't forget to see our rules" }));
			Config.set("On-Join.Spawn.Message.Join.Enable", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Message.Join.Message", java.util.Arrays.asList(new String[] { "&8&m<=====-------<&r &6UltimateSpawn &8&m>-------=====>", "&cHello %player%", "&cDon't forget to see our rules", "&8&m<=====-------<&r &6UltimateSpawn &8&m>-------=====>" }));			
			Config.set("On-Join.Spawn.Gamemode.Change", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Gamemode.Gamemode", Integer.valueOf(2));
			Config.set("On-Join.Spawn.Fly", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Restore.Health", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Restore.Food", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Firework", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Sounds.Enabled", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Sounds.Sound", "NOTE_PIANO");
			Config.set("On-Join.Spawn.Sounds.Volume", Integer.valueOf(10));
			Config.set("On-Join.Spawn.Sounds.Pitch", Integer.valueOf(1));
			
			// On quit
			Config.set("On-Join.Spawn.Broadcast.Quit.Enable", Boolean.valueOf(true));
			Config.set("On-Join.Spawn.Broadcast.Quit.Hide", Boolean.valueOf(false));
			Config.set("On-Join.Spawn.Broadcast.Quit.Message", java.util.Arrays.asList(new String[] { "&8[&c-&8] [&c-&8] [&c-&8] ", "Hey, %player%" }));
			
			// Command 
			Config.set("Command.Ping.Self.Enable", Boolean.valueOf(true));
			Config.set("Command.Ping.Self.Disable-Message", Boolean.valueOf(true));
			Config.set("Command.Ping.Other.Enable", Boolean.valueOf(true));
			Config.set("Command.Ping.Other.Disable-Message", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Enable", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Lines-To-Clear", Integer.valueOf(150));
			Config.set("Command.ClearChat.Disable-Message", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Anonymous.Enable", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Anonymous.Message-Clear", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Anonymous.Disable-Message", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Normal.Enable", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Normal.Message-Clear", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Normal.Disable-Message", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Own.Enable", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Own.Message-Clear", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Own.Disable-Message", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Other.Enable", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Other.Message-Clear", Boolean.valueOf(true));
			Config.set("Command.ClearChat.Other.Disable-Message", Boolean.valueOf(true));
			Config.set("Command.Broadcast.Enable", Boolean.valueOf(true));
			Config.set("Command.Broadcast.Disable-Message", Boolean.valueOf(true));
			Config.set("Command.Broadcast.Sounds.Enabled", Boolean.valueOf(true));
			Config.set("Command.Broadcast.Sounds.Sound", "NOTE_PIANO");
			Config.set("Command.Broadcast.Sounds.Volume", Integer.valueOf(10));
			Config.set("Command.Broadcast.Sounds.Pitch", Integer.valueOf(1));
			
			// Debug
			Config.set("Debug-in-case-of-problem.Disable.Damage-TO-EVERYTHING", Boolean.valueOf(false));
			
			saveConfigFile();
			
		}
	}

}