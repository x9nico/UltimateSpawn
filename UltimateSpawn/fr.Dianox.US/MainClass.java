package fr.Dianox.US;

import org.bukkit.plugin.java.JavaPlugin;

import fr.Dianox.US.Commands.CommandSpawn;
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
		getCommand("ultimatespawn").setExecutor(new CommandSpawn());
		
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
