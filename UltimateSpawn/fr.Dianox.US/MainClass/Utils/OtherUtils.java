package fr.Dianox.US.MainClass.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

import org.bukkit.Color;

import fr.Dianox.US.MainClass.config.ConfigGlobal;

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

}
