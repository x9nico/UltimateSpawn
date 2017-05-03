package fr.Dianox.US;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Dianox.US.Commands.CommandSpawn;
import fr.Dianox.US.Commands.MainCommand;
import fr.Dianox.US.Protection.AntiDamage;
import fr.Dianox.US.Protection.AntiSpawning;
import fr.Dianox.US.Protection.AntiWeather;
import fr.Dianox.US.Protection.ProtecBlock;
import fr.Dianox.US.Protection.ProtectItem;
import fr.Dianox.US.Scoreboard.Board;
import fr.Dianox.US.Scoreboard.Updater;
import fr.Dianox.US.Protection.ProtectExplosion;
import fr.Dianox.US.config.ConfigMessage;
import fr.Dianox.US.config.ConfigSpawn;
import fr.Dianox.US.config.ConfigUtils;
import fr.Dianox.US.config.MainConfig;
import fr.Dianox.US.config.ScoreboardConfig;

public class MainClass extends JavaPlugin{
	
	private static MainClass instance;
	public static boolean hook_placeholderapi = false;
	public static boolean hook_mvdw = false;
	public static boolean uses_uuid = true;
	
	public MainClass(){}
	
	public void onEnable(){
		System.out.println("|=============================");
		System.out.println("|");
		System.out.println("| Ultimate Spawn load ! Please wait !");
		System.out.println("| ");
		
		instance = this;
		
		ScoreboardConfig.loadConfig(this);
		System.out.println("| Config for Scoreboard loaded");
		ConfigSpawn.loadSpawnConfig(this);
		System.out.println("| Config for Spawn loaded");
		ConfigMessage.loadMessageConfig(this);
		System.out.println("| Config for Message loaded");
		MainConfig.loadConfig(this);
		System.out.println("| Main config loaded");
		System.out.println("| ");
		ConfigUtils.load();
		System.out.println("| Utils for config loaded");
		System.out.println("| ");
		
		getCommand("spawn").setExecutor(new CommandSpawn());
		getCommand("setspawn").setExecutor(new CommandSpawn());
		getCommand("ultimatespawn").setExecutor(new MainCommand());
		System.out.println("| Commands loaded");
		System.out.println("| ");
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Events(), this);
		pm.registerEvents(new ProtecBlock(), this);
		pm.registerEvents(new ProtectItem(), this);
		pm.registerEvents(new ProtectExplosion(), this);
		pm.registerEvents(new AntiWeather(), this);
		pm.registerEvents(new AntiSpawning(), this);
		pm.registerEvents(new AntiDamage(), this);
		System.out.println("| Events loaded");
		System.out.println("| ");
		
	    if ((Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) && (MainConfig.getConfig().getBoolean("Placeholder.PlaceholderAPI"))){
	      hook_placeholderapi = true;
	      System.out.println("| Detected PlaceholderAPI, hooking in");
	    }
	    if ((Bukkit.getPluginManager().isPluginEnabled("MVdWPlaceholderAPI")) && (MainConfig.getConfig().getBoolean("Placeholder.MVdWPlaceholderAPI"))){
	      hook_placeholderapi = true;
	      System.out.println("| Detected MVdWPlaceholderAPI, hooking in");
	    }
	    System.out.println("| ");
	    
	    if (!MainConfig.getConfig().getBoolean("Set_UUID")){
	      uses_uuid = false;
	    }	    
	    for (Player p : Bukkit.getOnlinePlayers()){
	        new Board(p);
	    }
	    
	    new Updater();
	    
	    System.out.println("| And many things... loaded !");
	    
		System.out.println("|");
		System.out.println("| Ultimate Spawn loaded !");
		System.out.println("|");
		System.out.println("|=============================");
	}
	
	public static MainClass getInstance(){
		return instance;
	}

    protected boolean checkVersion(){
	  return false;
	}
}
