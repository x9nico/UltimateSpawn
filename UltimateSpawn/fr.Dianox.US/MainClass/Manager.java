package fr.Dianox.US.MainClass;

import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;

import fr.Dianox.US.MainClass.event.BasicFeatures;
import fr.Dianox.US.MainClass.event.ChangeWorldEvent;
import fr.Dianox.US.MainClass.event.CustomJoinItem;
import fr.Dianox.US.MainClass.event.FunFeatures;
import fr.Dianox.US.MainClass.event.LittlesEvent;
import fr.Dianox.US.MainClass.event.OnChat;
import fr.Dianox.US.MainClass.event.OnCommand;
import fr.Dianox.US.MainClass.event.OnJoin;
import fr.Dianox.US.MainClass.event.OnQuit;

public class Manager {
	
	public MainClass pl;
	
	public Manager(MainClass us) {
		this.pl = us;
	}
	
	public void registerEvents() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BasicFeatures(), pl);
		pm.registerEvents(new OnJoin(), pl);
		pm.registerEvents(new OnQuit(), pl);
		pm.registerEvents(new OnChat(), pl);
		pm.registerEvents(new FunFeatures(), pl);
		pm.registerEvents(new LittlesEvent(), pl);
		pm.registerEvents(new ChangeWorldEvent(), pl);
		pm.registerEvents(new OnCommand(), pl);
		pm.registerEvents(new CustomJoinItem(), pl);
	}
}
