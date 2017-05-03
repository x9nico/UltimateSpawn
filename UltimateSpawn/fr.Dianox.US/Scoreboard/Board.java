package fr.Dianox.US.Scoreboard;

import java.util.ArrayList;
import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

import fr.Dianox.US.MainClass;
import fr.Dianox.US.config.ScoreboardConfig;

public class Board{
	
	  public static ArrayList<Board> boards = new ArrayList();
	  public static ArrayList<Player> disabled = new ArrayList();
	  public static HashMap<Player, Board> btp = new HashMap();
	  static FileConfiguration config = ScoreboardConfig.getConfig();
	  public Scoreboard scoreboard;
	  public Objective objective;
	  int c;
	  int updates;
	  Player player;
	  ArrayList<String> cache = new ArrayList();
	  ArrayList<Line> lines = new ArrayList();
	  
	  public Board(Player p){
	    boards.add(this);
	    btp.put(p, this);
	    
	    config = ScoreboardConfig.getConfig();
	    this.scoreboard = Bukkit.getScoreboardManager().getNewScoreboard();
	    this.player = p;
	    
	    this.c = (config.getConfigurationSection("animatedboard").getKeys(false).size() - 1);
	    this.updates = config.getInt("settings.update-ticks");
	    
	    this.objective = this.scoreboard.registerNewObjective(p.getName(), "dummy");
	    this.objective.setDisplaySlot(DisplaySlot.SIDEBAR);
	    this.objective.setDisplayName(SBUtils.color(config.getString("board.title")));
	    
	    int score = this.c;
	    int count = 0;
	    for (String key : config.getConfigurationSection("animatedboard").getKeys(false)){
	      int keyInt = 1;
	      try{
	        keyInt = Integer.parseInt(key);
	      }catch (NumberFormatException e){
	        SBUtils.fatal("Line number " + (count + 1) + " has a non-numeric name.", p);
	      }
	      if (keyInt != 1){
	        Team t = this.scoreboard.registerNewTeam(""+count+"");
	        t.addEntry(String.valueOf(org.bukkit.ChatColor.values()[count]));
	        
	        this.objective.getScore(String.valueOf(org.bukkit.ChatColor.values()[count])).setScore(score);
	        
	        count++;
	        score--;
	      }
	      Line l = new Line(this.player, key);
	      this.lines.add(l);
	      
	      
	    }
	    p.setScoreboard(this.scoreboard);
	    
	    update();
	  }

	String last = "";
	  
	  private void title(String s){
	    if (this.last == s) {
	      return;
	    }
	    this.last = s;
	    this.objective.setDisplayName(s);
	  }
	  
	  public void update(){
	    if (disabled.contains(this.player)) {
	      return;
	    }
	    ArrayList<String> newCache = new ArrayList();
	    
	    int count = 0;
	    boolean first = true;
	    for (Line line : this.lines){
	      String s = line.next();
	      if (first){
	        title(s);
	        first = false;
	      }else{
	        first = false;
	        if (MainClass.hook_placeholderapi) {
	          s = me.clip.placeholderapi.PlaceholderAPI.setPlaceholders(this.player, s);
	        }
	        
	        if (MainClass.hook_mvdw) {
	            if (MainClass.uses_uuid) {
	              s = be.maximvdw.placeholderapi.PlaceholderAPI.replacePlaceholders(Bukkit.getOfflinePlayer(this.player.getUniqueId()), s);
	            } else {
	              s = be.maximvdw.placeholderapi.PlaceholderAPI.replacePlaceholders(Bukkit.getOfflinePlayer(this.player.getName()), s);
	            }
	          }
	        
	        newCache.add(s);
	        if (this.cache.contains(s))
	        {
	          count++;
	        }
	        else
	        {
	          if (s.length() > 31) {
	            s.substring(31);
	          }
	          if (s.length() > 16)
	          {
	            String last = "";
	            for (int i = 0; i < s.substring(0, 16).length(); i++)
	            {
	              char c = s.charAt(i);
	              if (c == '�') {
	                last = last + "�" + s.charAt(i + 1);
	              }
	            }
	            String s1 = s.substring(0, 16);
	            String s2 = s.substring(16, s.length());
	            if (s2.length() > 15) {
	              s2 = s.substring(0, 15);
	            }
	            if (!last.isEmpty()) {
	              s2 = last + s2;
	            } else {
	              s2 = "�f" + s2;
	            }
	            Team t = this.scoreboard.getTeam(""+count);
	            t.setPrefix(SBUtils.color(s1));
	            t.setSuffix(SBUtils.color(s2));
	          }
	          else
	          {
	            Team t = this.scoreboard.getTeam(""+count);
	            t.setPrefix(SBUtils.color(s));
	            t.setSuffix("");
	          }
	          count++;
	        }
	      }
	    }
	    this.cache = newCache;
	  }

}
