package fr.Dianox.US.Scoreboard;

import java.util.ArrayList;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass;
import fr.Dianox.US.config.ScoreboardConfig;
import me.clip.placeholderapi.PlaceholderAPI;

public class Line {
	  static FileConfiguration config = ScoreboardConfig.getConfig();
	  ArrayList<String> lines = new ArrayList();
	  int iterations_needed;
	  int scroll_pos = -1;
	  int iterations = 0;
	  Player p;
	  int entries = 0;
	  
	  public Line(Player p, String row)
	  {
	    this.p = p;
	    this.iterations_needed = config.getInt("animatedboard." + row + ".update");
	    this.iterations = this.iterations_needed;
	    for (String s : config.getStringList("animatedboard." + row + ".content"))
	    {
	      this.lines.add(s);
	      this.entries += 1;
	    }
	  }
	  
	  public String next()
	  {
	    this.iterations += 1;
	    if (this.iterations >= this.iterations_needed) {
	      this.scroll_pos += 1;
	    }
	    if (this.iterations >= this.iterations_needed) {
	      this.iterations = 0;
	    }
	    if (this.scroll_pos >= this.entries) {
	      this.scroll_pos = 0;
	    }
	    String s = (String)this.lines.get(this.scroll_pos);
	    if (MainClass.placeholders) {
	      s = PlaceholderAPI.setPlaceholders(this.p, s);
	    }
	    s = SBUtils.color(s);
	    return s;
	  }
}
