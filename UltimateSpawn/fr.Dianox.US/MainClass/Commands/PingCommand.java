package fr.Dianox.US.MainClass.Commands;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;

public class PingCommand implements CommandExecutor {

    private static Method getHandleMethod;
    private static Field pingField;

    public PingCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (!(sender instanceof Player)) {

            if ((args.length == 0)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
                return true;
            }

            final int ping_by_console = getPing(Bukkit.getPlayer(sender.getName()));

            String console_player_ping = new String(args[0]);

            if ((args.length == 1)) {
                Player other = Bukkit.getPlayer(args[0]);

                if (cmd.getName().equalsIgnoreCase("ping")) {
                    if (other == null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
                        return true;
                    }

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Player.Ping.Other")).replaceAll("%ping%", String.valueOf(ping_by_console)).replace("%target%", console_player_ping));
                }
            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
            }

            return true;
        }

        Player p = (Player) sender;
        final int ping = getPing(Bukkit.getPlayer(p.getName()));

        if (cmd.getName().equalsIgnoreCase("ping") && p.hasPermission("UltimateSpawn.ping")) {
            if ((args.length == 0)) {
                if (ConfigGlobal.getConfig().getBoolean("Command.Ping.Self.Enable")) {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Player.Ping.Self")).replaceAll("%ping%", String.valueOf(ping)).replaceAll("%player%", p.getName()));
                } else {
                    if (ConfigGlobal.getConfig().getBoolean("Command.Ping.Self.Disable-Message")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Command-disable")));
                    }
                }
            } else if ((args.length == 1)) {
                Player other = Bukkit.getPlayer(args[0]);
                if (ConfigGlobal.getConfig().getBoolean("Command.Ping.Other.Enable")) {
                    if (other == null) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
                        return true;
                    }
                    int po = getPing(Bukkit.getPlayer(other.getName()));
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Player.Ping.Other")).replaceAll("%ping%", String.valueOf(po)).replaceAll("%target%", other.getName()));
                } else {
                    if (ConfigGlobal.getConfig().getBoolean("Command.Ping.Other.Disable-Message")) {
                        p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Command-disable")));
                    }
                }
            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.No-permission")));
        }

        return true;
    }

    public static int getPing(Player p) {
        try {
            if (getHandleMethod == null) {
                getHandleMethod = p.getClass().getDeclaredMethod("getHandle", new Class[0]);
                getHandleMethod.setAccessible(true);
            }
            Object entityPlayer = getHandleMethod.invoke(p, new Object[0]);
            if (pingField == null) {
                pingField = entityPlayer.getClass().getDeclaredField("ping");
                pingField.setAccessible(true);
            }
            int ping = pingField.getInt(entityPlayer);

            return ping > 0 ? ping : 0;
        } catch (Exception e) {}
        return 1;
    }

}
