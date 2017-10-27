package fr.Dianox.US.MainClass.Utils.Server;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.messages.ConfigMServer;

public class Warn {
	
	static final int[] warnSystem = new int[1];
	
	public static void runWarnSystemTask(MainClass plugin) {
		
		new BukkitRunnable() {

			public void run() {
				double ticks = Tps.getTPS();
				if (ticks <= 15.0D) {
					onPrevient();
				} else if (ticks <= 5.0D) {
					onCritique();
					Bukkit.getServer().savePlayers();
					for (World world : Bukkit.getWorlds()) {
			            world.save();
					}
				}
				
			}
			
		}.runTaskTimerAsynchronously(plugin, 40L, 60L);
		
	}
	
	public static void onPrevient() {
		for (Player player: Bukkit.getOnlinePlayers()) {
			if (player.hasPermission("ultimatespawn.event.warn.tps")) {
				for (String msg: ConfigMServer.getConfig().getStringList("TPS.Check.15")) {
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
				}
			}
		}
	}
	
	public static void onCritique() {
		for (Player player: Bukkit.getOnlinePlayers()) {
			if (player.hasPermission("ultimatespawn.event.warn.tps")) {
				for (String msg: ConfigMServer.getConfig().getStringList("TPS.Check.5")) {
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, player);
				}
			}
		}
	}

}
