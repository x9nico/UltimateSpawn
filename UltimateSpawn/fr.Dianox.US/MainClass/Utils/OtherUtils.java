package fr.Dianox.US.MainClass.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.bukkit.Color;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.config.ConfigBlockCommands;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigPlayerOptions;
import fr.Dianox.US.MainClass.config.ConfigPlayerStats;
import fr.Dianox.US.MainClass.config.ConfigSpawn;
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.command.ConfigCAnnounce;
import fr.Dianox.US.MainClass.config.command.ConfigCClearChat;
import fr.Dianox.US.MainClass.config.command.ConfigCDelayChat;
import fr.Dianox.US.MainClass.config.command.ConfigCFly;
import fr.Dianox.US.MainClass.config.command.ConfigCMuteChat;
import fr.Dianox.US.MainClass.config.command.ConfigCPing;
import fr.Dianox.US.MainClass.config.command.ConfigCPlayerOption;
import fr.Dianox.US.MainClass.config.command.ConfigCSpawn;
import fr.Dianox.US.MainClass.config.command.ConfigCWeatherTime;
import fr.Dianox.US.MainClass.config.event.ConfigEColorSign;
import fr.Dianox.US.MainClass.config.event.ConfigERespawn;
import fr.Dianox.US.MainClass.config.event.ConfigEVoidTP;
import fr.Dianox.US.MainClass.config.event.CWE.ConfigCWEGM;
import fr.Dianox.US.MainClass.config.event.CWE.ConfigCWEKeepFly;
import fr.Dianox.US.MainClass.config.fun.ConfigFDoubleJump;
import fr.Dianox.US.MainClass.config.fun.ConfigFJumpad;
import fr.Dianox.US.MainClass.config.global.ConfigGActionBar;
import fr.Dianox.US.MainClass.config.global.ConfigGCos;
import fr.Dianox.US.MainClass.config.global.ConfigGFly;
import fr.Dianox.US.MainClass.config.global.ConfigGGM;
import fr.Dianox.US.MainClass.config.global.ConfigGHF;
import fr.Dianox.US.MainClass.config.global.ConfigGInventory;
import fr.Dianox.US.MainClass.config.global.ConfigGJoinCommand;
import fr.Dianox.US.MainClass.config.global.ConfigGMessage;
import fr.Dianox.US.MainClass.config.global.ConfigGMessageQ;
import fr.Dianox.US.MainClass.config.global.ConfigGPlayerItems;
import fr.Dianox.US.MainClass.config.global.ConfigGProtection;
import fr.Dianox.US.MainClass.config.global.ConfigGQuitCommand;
import fr.Dianox.US.MainClass.config.global.ConfigGServerEvent;
import fr.Dianox.US.MainClass.config.global.ConfigGSpawn;
import fr.Dianox.US.MainClass.config.global.ConfigGTitle;
import fr.Dianox.US.MainClass.config.global.ConfigGXP;
import fr.Dianox.US.MainClass.config.messages.ConfigMAnnounce;
import fr.Dianox.US.MainClass.config.messages.ConfigMClearChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMConstruct;
import fr.Dianox.US.MainClass.config.messages.ConfigMDelayChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMFly;
import fr.Dianox.US.MainClass.config.messages.ConfigMMuteChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMPing;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;
import fr.Dianox.US.MainClass.config.messages.ConfigMSpawn;
import fr.Dianox.US.MainClass.config.messages.ConfigMVoidTP;
import fr.Dianox.US.MainClass.config.messages.ConfigMWeatherTime;;

public class OtherUtils {
	
    public OtherUtils() {}
    
	public static String getDate() {
		String currentDate = new SimpleDateFormat(ConfigGlobal.getConfig().getString("Plugin.Date-Format")).format(System.currentTimeMillis());
		
		return currentDate;
	}
	
	public static int getHours() {
		Calendar calendar = GregorianCalendar.getInstance();
		int hours = calendar.get(Calendar.HOUR_OF_DAY);
		
		return hours;
	}
	
	public static int getMinutes() {
		Calendar calendar = GregorianCalendar.getInstance();
		int minutes = calendar.get(Calendar.MINUTE);
		
		return minutes;
	}
	
	public static int getSeconds() {
		Calendar calendar = GregorianCalendar.getInstance();
		int seconds = calendar.get(Calendar.SECOND);
		
		return seconds;
	}
	
	  public static Color getColor(String paramString) {
	    String temp = paramString;
	    if (temp.equalsIgnoreCase("AQUA")) {
	      return Color.AQUA;
	    }
	    if (temp.equalsIgnoreCase("BLACK")) {
	      return Color.BLACK;
	    }
	    if (temp.equalsIgnoreCase("BLUE")) {
	      return Color.BLUE;
	    }
	    if (temp.equalsIgnoreCase("FUCHSIA")) {
	      return Color.FUCHSIA;
	    }
	    if (temp.equalsIgnoreCase("GRAY")) {
	      return Color.GRAY;
	    }
	    if (temp.equalsIgnoreCase("GREEN")) {
	      return Color.GREEN;
	    }
	    if (temp.equalsIgnoreCase("LIME")) {
	      return Color.LIME;
	    }
	    if (temp.equalsIgnoreCase("MAROON")) {
	      return Color.MAROON;
	    }
	    if (temp.equalsIgnoreCase("NAVY")) {
	      return Color.NAVY;
	    }
	    if (temp.equalsIgnoreCase("OLIVE")) {
	      return Color.OLIVE;
	    }
	    if (temp.equalsIgnoreCase("ORANGE")) {
	      return Color.ORANGE;
	    }
	    if (temp.equalsIgnoreCase("PURPLE")) {
	      return Color.PURPLE;
	    }
	    if (temp.equalsIgnoreCase("RED")) {
	      return Color.RED;
	    }
	    if (temp.equalsIgnoreCase("SILVER")) {
	      return Color.SILVER;
	    }
	    if (temp.equalsIgnoreCase("TEAL")) {
	      return Color.TEAL;
	    }
	    if (temp.equalsIgnoreCase("WHITE")) {
	      return Color.WHITE;
	    }
	    if (temp.equalsIgnoreCase("YELLOW")) {
	      return Color.YELLOW;
	    }
	    
	    return null;
	  }
	  
	  public static void reloadconfig() {
		  ConfigGlobal.reloadConfig();
          ConfigSpawn.reloadConfig();
          ConfigCClearChat.reloadConfig();
          ConfigGMessageQ.reloadConfig();
          ConfigGPlayerItems.reloadConfig();
          ConfigGProtection.reloadConfig();
          ConfigGServerEvent.reloadConfig();
          ConfigGCos.reloadConfig();
          ConfigGMessage.reloadConfig();
          ConfigGSpawn.reloadConfig();
          ConfigGTitle.reloadConfig();
          ConfigGGM.reloadConfig();
          ConfigGHF.reloadConfig();
          ConfigGFly.reloadConfig();
          ConfigGXP.reloadConfig();
          ConfigPlayerStats.reloadConfig();
          ConfigGInventory.reloadConfig();
          ConfigPlayerOptions.reloadConfig();
          ConfigEVoidTP.reloadConfig();
          ConfigEColorSign.reloadConfig();
          ConfigCWEGM.reloadConfig();
          ConfigCWEKeepFly.reloadConfig();
          ConfigTemp.reloadConfig();
          ConfigGActionBar.reloadConfig();
          ConfigGJoinCommand.reloadConfig();
          ConfigFJumpad.reloadConfig();
          ConfigGQuitCommand.reloadConfig();
          ConfigCSpawn.reloadConfig();
          ConfigCPing.reloadConfig();
          ConfigCDelayChat.reloadConfig();
          ConfigCAnnounce.reloadConfig();
          ConfigCMuteChat.reloadConfig();
          ConfigCFly.reloadConfig();
          ConfigBlockCommands.reloadConfig();
          ConfigFDoubleJump.reloadConfig();
          ConfigPlayerOptions.reloadConfig();
          ConfigCPlayerOption.reloadConfig();
          
          // Commands
          ConfigCWeatherTime.reloadConfig();
          
          // >> Messages
          // > Commands
          ConfigMWeatherTime.reloadConfig();
          ConfigMAnnounce.reloadConfig();
          ConfigMPing.reloadConfig();
          ConfigMClearChat.reloadConfig();
          ConfigMMuteChat.reloadConfig();
          ConfigMDelayChat.reloadConfig();
          ConfigMSpawn.reloadConfig();
          // > Event
          ConfigMVoidTP.reloadConfig();
          // > Main
          ConfigMFly.reloadConfig();
          ConfigMConstruct.reloadConfig();
          ConfigMPlugin.reloadConfig();
          
          // >> Event
          ConfigERespawn.reloadConfig();
	  }
	  
	  public static void fixConfig() {
		  if (!MainClass.getInstance().getServerVersion().contains("1.8")) {
			  if (ConfigGCos.getConfig().getString("Cosmetics.Sounds.Sound") == String.valueOf("NOTE_PIANO")) {
				  ConfigGCos.getConfig().set("Cosmetics.Sounds.Sound", "BLOCK_NOTE_HARP");
			  }
			  if (ConfigEVoidTP.getConfig().getString("VoidTP.Options.Sounds.Sound") == "NOTE_PIANO") {
				  ConfigEVoidTP.getConfig().set("VoidTP.Options.Sounds.Sound", "BLOCK_NOTE_HARP");
			  }
			  if (ConfigFJumpad.getConfig().getString("JumpPads.Sounds.Sound") == "NOTE_PIANO") {
				  ConfigFJumpad.getConfig().set("JumpPads.Sounds.Sound", "BLOCK_NOTE_HARP");
			  }
			  if (ConfigCAnnounce.getConfig().getString("Announce.Broadcast.Sounds.Sound") == "NOTE_PIANO") {
				  ConfigCAnnounce.getConfig().set("Announce.Broadcast.Sounds.Sound", "BLOCK_NOTE_HARP");
				  ConfigCAnnounce.getConfig().set("Announce.Broadcast.Sounds-Console.Sound", "BLOCK_NOTE_HARP");
			  }
			  if (ConfigFDoubleJump.getConfig().getString("DoubleJump.Double.Sounds.Sound") == "NOTE_PIANO") {
				  ConfigFDoubleJump.getConfig().set("DoubleJump.Double.Sounds.Sound", "BLOCK_NOTE_HARP");
				  ConfigFDoubleJump.getConfig().set("DoubleJump.Triple.Sounds.Sound", "BLOCK_NOTE_HARP");
				  ConfigFDoubleJump.getConfig().set("DoubleJump.Quadruple.Sounds.Sound", "BLOCK_NOTE_HARP");
				  ConfigFDoubleJump.getConfig().set("DoubleJump.Fivefold.Sounds.Sound", "BLOCK_NOTE_HARP");
				  ConfigFDoubleJump.getConfig().set("DoubleJump.Infinite.Sounds.Sound", "BLOCK_NOTE_HARP");
			  }
			  
			  ConfigFDoubleJump.saveConfigFile();
			  ConfigGCos.saveConfigFile();
			  ConfigEVoidTP.saveConfigFile();
			  ConfigFJumpad.saveConfigFile();
			  ConfigCAnnounce.saveConfigFile();
		  }
	  }
}
