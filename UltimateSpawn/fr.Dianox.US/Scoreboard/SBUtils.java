package fr.Dianox.US.Scoreboard;

import java.util.ArrayList;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class SBUtils {
	
	  private static String CHAT_PREFIX = "&c&lScoreboard &7� &f";
	  
	  public static String color(String c)
	  {
	    if (c == null) {
	      return "";
	    }
	    return ChatColor.translateAlternateColorCodes('&', c);
	  }
	  
	  public static boolean hasPerms(Player p, String permission)
	  {
	    if (p.hasPermission("scoreboard." + permission)) {
	      return true;
	    }
	    msg(p, "You do not have sufficient permission");
	    return false;
	  }
	  
	  public static boolean hasSilentPerms(Player p, String permission)
	  {
	    if (p.hasPermission("scoreboard." + permission)) {
	      return true;
	    }
	    return false;
	  }
	  
	  public static void msg(Player p, String c)
	  {
	    p.sendMessage(color(CHAT_PREFIX + c));
	  }
	  
	  public static void warn(String c)
	  {
	    System.out.println(c);
	    for (Player p : Bukkit.getOnlinePlayers()) {
	      if (hasSilentPerms(p, "admin.debug"))
	      {
	        msg(p, "Debug message. Urgency: warning.");
	        msg(p, c);
	      }
	    }
	  }
	  
	  public static boolean isTwoArrayListsWithSameValues(ArrayList<String> dups, ArrayList<String> last)
	  {
	    if ((dups == null) && (last == null)) {
	      return true;
	    }
	    if (((dups == null) && (last != null)) || ((dups != null) && (last == null))) {
	      return false;
	    }
	    if (dups.size() != last.size()) {
	      return false;
	    }
	    for (Object itemList1 : dups) {
	      if (!last.contains(itemList1)) {
	        return false;
	      }
	    }
	    return true;
	  }

	public static void fatal(String c, Player p) {
	        if (p.hasPermission("UltimateSpawn.admin")){
	          p.sendMessage("Debug message. Urgency: fatal.");
	          p.sendMessage(c);
	        }
	}

}
