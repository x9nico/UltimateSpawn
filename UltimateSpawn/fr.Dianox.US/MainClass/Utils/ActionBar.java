package fr.Dianox.US.MainClass.Utils;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

public class ActionBar {
	
	private static HashMap<Class<? extends Entity>, Method> handles = new HashMap<Class<? extends Entity>, Method>();
	private static Field playerConnection = null;
	private static Method playerSendPacket = null;

	public static void sendActionBar(Player p, String msg) {
		try {
			msg = ChatColor.translateAlternateColorCodes('&', msg);
			Class<?> packetClass = NMSClass.getNMSClass("PacketPlayOutChat");
			Class<?> componentClass = NMSClass.getNMSClass("IChatBaseComponent");
			Class<?> serializerClass = NMSClass.getNMSClass("IChatBaseComponent$ChatSerializer");
			Constructor<?> packetConstructor = packetClass.getConstructor(new Class[] { componentClass, Byte.TYPE });
	      
			Object baseComponent = serializerClass.getMethod("a", new Class[] { String.class }).invoke(null, new Object[] { "{\"text\": \"" + msg + "\"}" });
			Object packet = packetConstructor.newInstance(new Object[] { baseComponent, Byte.valueOf((byte) 2) });
			sendPacket(p, packet);
	    } catch (Exception localException) {}
	}
	
	public static void sendPacket(Player p, Object packet) {
		try {
			if (playerConnection == null) {
				playerConnection = getHandle(p).getClass().getField("playerConnection");
				for (Method m : playerConnection.get(getHandle(p)).getClass().getMethods()) {
					if (m.getName().equalsIgnoreCase("sendPacket")) {
						playerSendPacket = m;
					}
				}
			}
			playerSendPacket.invoke(playerConnection.get(getHandle(p)), new Object[] { packet });
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Object getHandle(Entity entity) {
		try {
			if (handles.get(entity.getClass()) != null) {
				return ((Method)handles.get(entity.getClass())).invoke(entity, new Object[0]);
			}
			Method entity_getHandle = entity.getClass().getMethod("getHandle", new Class[0]);
	      	handles.put(entity.getClass(), entity_getHandle);
	      	return entity_getHandle.invoke(entity, new Object[0]);
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	    return null;
	}
}
