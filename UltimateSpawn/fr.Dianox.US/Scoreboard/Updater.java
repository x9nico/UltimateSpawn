package fr.Dianox.US.Scoreboard;

import org.bukkit.Bukkit;

import fr.Dianox.US.MainClass;

public class Updater {
	
	  public Updater(){
	    Bukkit.getScheduler().scheduleSyncRepeatingTask(MainClass.getInstance(), new Runnable(){
	      public void run(){
	        for (Board b : Board.boards) {
	          b.update();
	        }
	      }
	    }, 0L, 1L);
	  }
}
