package fr.Dianox.US.MainClass.Utils;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Commands.PingCommand;
import fr.Dianox.US.MainClass.Commands.Chat.DelaychatCommand;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import me.clip.placeholderapi.PlaceholderAPI;
import net.md_5.bungee.api.ChatColor;

public class ActionBar {

    public static boolean works = true;

    public static void sendActionBar(Player player, String message) {
        if (!player.isOnline()) {
            return;
        }
        ActionBarMessageEvent actionBarMessageEvent = new ActionBarMessageEvent(player, message);
        Bukkit.getPluginManager().callEvent(actionBarMessageEvent);
        if (actionBarMessageEvent.isCancelled()) {
            return;
        }
        if (MainClass.nmsver.startsWith("v1_12_")) {

            message = ChatColor.translateAlternateColorCodes('&', message);

            if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
                message = PlaceholderAPI.setPlaceholders(player, message).replaceAll("%player%", player.getDisplayName()).replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay)).replaceAll("%ping%", String.valueOf(PingCommand.getPing(player)));
            } else {
                message = message.replaceAll("%player%", player.getDisplayName()).replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay)).replaceAll("%ping%", String.valueOf(PingCommand.getPing(player)));
            }

            sendActionBarPost112(player, message);
        } else {
            message = ChatColor.translateAlternateColorCodes('&', message);

            if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
                message = PlaceholderAPI.setPlaceholders(player, message).replaceAll("%player%", player.getDisplayName()).replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay)).replaceAll("%ping%", String.valueOf(PingCommand.getPing(player)));
            } else {
                message = message.replaceAll("%player%", player.getDisplayName()).replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay)).replaceAll("%ping%", String.valueOf(PingCommand.getPing(player)));
            }

            sendActionBarPre112(player, message);
        }
    }

    private static void sendActionBarPost112(Player player, String message) {
        if (!player.isOnline()) {
            return;
        }
        try {
            Class < ? > craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + MainClass.nmsver + ".entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(player);

            Class < ? > c4 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".PacketPlayOutChat");
            Class < ? > c5 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".Packet");
            Class < ? > c2 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".ChatComponentText");
            Class < ? > c3 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".IChatBaseComponent");
            Class < ? > chatMessageTypeClass = Class.forName("net.minecraft.server." + MainClass.nmsver + ".ChatMessageType");
            Object[] chatMessageTypes = chatMessageTypeClass.getEnumConstants();
            Object chatMessageType = null;
            for (Object obj: chatMessageTypes) {
                if (obj.toString().equals("GAME_INFO")) {
                    chatMessageType = obj;
                }
            }
            Object o = c2.getConstructor(new Class[] {
                String.class
            }).newInstance(new Object[] {
                message
            });
            Object ppoc = c4.getConstructor(new Class[] {
                c3,
                chatMessageTypeClass
            }).newInstance(new Object[] {
                o,
                chatMessageType
            });
            Method m1 = craftPlayerClass.getDeclaredMethod("getHandle", new Class[0]);
            Object h = m1.invoke(craftPlayer, new Object[0]);
            Field f1 = h.getClass().getDeclaredField("playerConnection");
            Object pc = f1.get(h);
            Method m5 = pc.getClass().getDeclaredMethod("sendPacket", new Class[] {
                c5
            });
            m5.invoke(pc, new Object[] {
                ppoc
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            works = false;
        }
    }

    private static void sendActionBarPre112(Player player, String message) {
        if (!player.isOnline()) {
            return;
        }
        try {
            Class < ? > craftPlayerClass = Class.forName("org.bukkit.craftbukkit." + MainClass.nmsver + ".entity.CraftPlayer");
            Object craftPlayer = craftPlayerClass.cast(player);

            Class < ? > c4 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".PacketPlayOutChat");
            Class < ? > c5 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".Packet");
            Object ppoc1;
            if (MainClass.getInstance().useOldMethods) {
                Class < ? > c2 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".ChatSerializer");
                Class < ? > c3 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".IChatBaseComponent");
                Method m3 = c2.getDeclaredMethod("a", new Class[] {
                    String.class
                });
                Object cbc = c3.cast(m3.invoke(c2, new Object[] {
                    "{\"text\": \"" + message + "\"}"
                }));
                ppoc1 = c4.getConstructor(new Class[] {
                    c3,
                    Byte.TYPE
                }).newInstance(new Object[] {
                    cbc,
                    Byte.valueOf((byte) 2)
                });
            } else {
                Class < ? > c2 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".ChatComponentText");
                Class < ? > c3 = Class.forName("net.minecraft.server." + MainClass.nmsver + ".IChatBaseComponent");
                Object o = c2.getConstructor(new Class[] {
                    String.class
                }).newInstance(new Object[] {
                    message
                });
                ppoc1 = c4.getConstructor(new Class[] {
                    c3,
                    Byte.TYPE
                }).newInstance(new Object[] {
                    o,
                    Byte.valueOf((byte) 2)
                });
            }
            Method m1 = craftPlayerClass.getDeclaredMethod("getHandle", new Class[0]);
            Object h = m1.invoke(craftPlayer, new Object[0]);
            Field f1 = h.getClass().getDeclaredField("playerConnection");
            Object pc = f1.get(h);
            Method m5 = pc.getClass().getDeclaredMethod("sendPacket", new Class[] {
                c5
            });
            m5.invoke(pc, new Object[] {
                ppoc1
            });
        } catch (Exception ex) {
            ex.printStackTrace();
            works = false;
        }
    }

    public static void sendActionBar(final Player player, final String message, int duration) {
        Bukkit.getScheduler().runTaskLater(MainClass.getInstance(), new Runnable() {

            @Override
            public void run() {
                ActionBar.sendActionBar(player, message);
            }

        }, duration);
    }

}
