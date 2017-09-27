package fr.Dianox.US.MainClass.Commands;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Commands.Chat.DelaychatCommand;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCGlobal;
import me.clip.placeholderapi.PlaceholderAPI;

public class PingCommand implements CommandExecutor {

    public PingCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (!(sender instanceof Player)) {

            if ((args.length == 0)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
                return true;
            } else if ((args.length == 1)) {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Player.Ping.Other")).replaceAll("%ping%", "Error no seriously ? But... Why ? you can only execute this command in game").replaceAll("%target%", args[0]));
            }

            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("ping") && p.hasPermission("UltimateSpawn.ping")) {
            if ((args.length == 0)) {
                if (ConfigCGlobal.getConfig().getBoolean("Command.Ping.Self.Enable")) {
                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Ping.Self"), p);
                } else {
                    if (ConfigCGlobal.getConfig().getBoolean("Command.Ping.Self.Disable-Message")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                    }
                }
            } else if ((args.length == 1)) {
                Player other = Bukkit.getPlayer(args[0]);
                if (ConfigCGlobal.getConfig().getBoolean("Command.Ping.Other.Enable")) {
                    if (other == null) {
                        PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Player.Not-found"), p);
                        return true;
                    }
            		if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
            			p.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, ConfigMessage.getConfig().getString("Player.Ping.Other"))
            					.replaceAll("%target%", other.getName())
            					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
            					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(other)))
            					));
            		} else {
            			p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Player.Ping.Other")
            					.replaceAll("%target%", other.getName())
            					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
            					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(other)))
            					));
            		}
                } else {
                    if (ConfigCGlobal.getConfig().getBoolean("Command.Ping.Other.Disable-Message")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                    }
                }
            }
        } else {
        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
        }

        return true;
    }

    public static int getPing(Player p) {
        String bpName = Bukkit.getServer().getClass().getPackage().getName();
        String version = bpName.substring(bpName.lastIndexOf(".") + 1, bpName.length());
        try {
          Class<?> CPClass = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
          Object CraftPlayer = CPClass.cast(p);
          
          Method getHandle = CraftPlayer.getClass().getMethod("getHandle", new Class[0]);
          Object EntityPlayer = getHandle.invoke(CraftPlayer, new Object[0]);
          
          Field ping = EntityPlayer.getClass().getDeclaredField("ping");
          
          return ping.getInt(EntityPlayer);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return 0;
    }

}
