package fr.Dianox.US.MainClass.Utils.NeedLobby;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class PlayerVisibility {
	
	private static List<Player> PVPlayer = new ArrayList<Player>();
	private static List<String> Cooling = new ArrayList<String>();
	
	public static List<Player> getPlayerVisibility() {
		return PVPlayer;
	}
	
	public static void showPlayer(Player p) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			p.showPlayer(player);
		}
		
		PVPlayer.add(p);
	}
	
	public static void hidePlayer(Player p) {
		for (Player player : Bukkit.getOnlinePlayers()) {
			p.hidePlayer(player);
		}
		
		PVPlayer.remove(p);
	}

	public static List<String> Cooling() {
		return Cooling;
	}

}
