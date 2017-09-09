package fr.Dianox.US.MainClass;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Dianox.US.MainClass.Commands.MainCommand;
import fr.Dianox.US.MainClass.Commands.PingCommand;
import fr.Dianox.US.MainClass.Commands.SpawnCommand;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigSpawn;
import fr.Dianox.US.MainClass.event.BasicFeatures;
import fr.Dianox.US.MainClass.event.OnJoin;
import fr.Dianox.US.MainClass.event.OnQuit;

public class MainClass extends JavaPlugin {
	
	private static MainClass instance;
	
	public MainClass() {}
	
	public void onEnable() {
		System.out.println("|=============================");
		System.out.println("|");
		System.out.println("| Ultimate Spawn load! Please wait!");
		System.out.println("| ");
		
		instance = this;
		
		ConfigGlobal.loadConfig((Plugin) this);
		System.out.println("| Main config loaded");
		ConfigMessage.loadConfig((Plugin) this);
		System.out.println("| Message config loaded");
		ConfigSpawn.loadConfig((Plugin) this);
		System.out.println("| Message config loaded");
		
		System.out.println("|");
		
		getCommand("ultimatespawn").setExecutor(new MainCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("setspawn").setExecutor(new SpawnCommand());
		getCommand("ping").setExecutor(new PingCommand());
		System.out.println("| Commands loaded");
		
		System.out.println("|");
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BasicFeatures(), this);
		pm.registerEvents(new OnJoin(), this);
		pm.registerEvents(new OnQuit(), this);
		System.out.println("| Events loaded");
		
		System.out.println("| And many things....");
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

}
