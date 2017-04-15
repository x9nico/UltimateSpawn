package fr.Dianox.US;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Dianox.US.Commands.CommandSpawn;
import fr.Dianox.US.Commands.MainCommand;
import fr.Dianox.US.Protection.AntiDamage;
import fr.Dianox.US.Protection.AntiSpawning;
import fr.Dianox.US.Protection.AntiWeather;
import fr.Dianox.US.Protection.ProtecBlock;
import fr.Dianox.US.Protection.ProtectItem;
import fr.Dianox.US.Protection.ProtectExplosion;
import fr.Dianox.US.config.ConfigMessage;
import fr.Dianox.US.config.ConfigSpawn;
import fr.Dianox.US.config.ConfigUtils;
import fr.Dianox.US.config.MainConfig;

public class MainClass extends JavaPlugin{
	
	private static MainClass instance;
	
	public MainClass(){}
	
	public void onEnable(){
		instance = this;
		
		ConfigSpawn.loadSpawnConfig(this);
		ConfigMessage.loadMessageConfig(this);
		MainConfig.loadConfig(this);
		ConfigUtils.load();
		
		getCommand("spawn").setExecutor(new CommandSpawn());
		getCommand("setspawn").setExecutor(new CommandSpawn());
		getCommand("ultimatespawn").setExecutor(new MainCommand());
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new Events(), this);
		pm.registerEvents(new ProtecBlock(), this);
		pm.registerEvents(new ProtectItem(), this);
		pm.registerEvents(new ProtectExplosion(), this);
		pm.registerEvents(new AntiWeather(), this);
		pm.registerEvents(new AntiSpawning(), this);
		pm.registerEvents(new AntiDamage(), this);
		
		System.out.println("|=============================");
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
