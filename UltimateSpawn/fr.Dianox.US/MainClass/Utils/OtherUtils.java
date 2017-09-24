package fr.Dianox.US.MainClass.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

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

}
