package fr.Dianox.US.MainClass.Commands;

import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.command.ConfigCAnnounce;
import fr.Dianox.US.MainClass.config.messages.ConfigMAnnounce;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;

public class AnnounceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (!(sender instanceof Player)) {
            if (args.length == 0) {
            	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Arguments-Missing")) {
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            	}
                return true;
            }
            String msg = "";
            for (String s: args) {
                if (!Objects.equals(msg, "")) {
                    msg = msg + " ";
                }
                msg = msg + s;
            }
            for (String msg1: ConfigMAnnounce.getConfig().getStringList("Announce.Broadcast")) {
            	Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1.replaceAll("%broadcast%", msg)));
            	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(msg1.replaceAll("%broadcast%", msg), Bukkit.getServer());
            }
            MusicConsole();
            return true;
        }

        Player p = (Player) sender;

        if (ConfigCAnnounce.getConfig().getBoolean("Announce.Broadcast.Enable")) {
            if (cmd.getName().equalsIgnoreCase("bc") || cmd.getName().equalsIgnoreCase("broadcast")) {
            	if (p.hasPermission("ultimatespawn.command.broadcast")) {
	                if (args.length == 0) {
	                	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Arguments-Missing")) {
	                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                	}
	                    return true;
	                }
	                String msg = "";
	                for (String s: args) {
	                    if (!Objects.equals(msg, "")) {
	                        msg = msg + " ";
	                    }
	                    msg = msg + s;
	                }
	                for (String msg1: ConfigMAnnounce.getConfig().getStringList("Announce.Broadcast")) {
	                	Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg1.replaceAll("%broadcast%", msg)));
	                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(msg1.replaceAll("%broadcast%", msg), Bukkit.getServer());
	                }
	                if (ConfigCAnnounce.getConfig().getBoolean("Announce.Broadcast.Sounds.Enabled")) {
	                    for (Player player: Bukkit.getServer().getOnlinePlayers()) {
	                        String sound = ConfigCAnnounce.getConfig().getString("Announce.Broadcast.Sounds.Sound");
	                        int volume = ConfigCAnnounce.getConfig().getInt("Announce.Broadcast.Sounds.Volume");
	                        int pitch = ConfigCAnnounce.getConfig().getInt("Announce.Broadcast.Sounds.Pitch");
	                        player.playSound(player.getLocation(), Sound.valueOf(sound), volume, pitch);
	                    }
	                }
            	} else {
            		for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
                	}
                }
            }
        } else {
            if (ConfigCAnnounce.getConfig().getBoolean("Announce.Broadcast.Disable-Message")) {
                for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
            	}
            }
        }
        return true;
    }

    private static void MusicConsole() {
        if (ConfigCAnnounce.getConfig().getBoolean("Announce.Broadcast.Sounds-Console.Enabled")) {
            for (Player player: Bukkit.getServer().getOnlinePlayers()) {
                String sound = ConfigCAnnounce.getConfig().getString("Announce.Broadcast.Sounds-Console.Sound");
                int volume = ConfigCAnnounce.getConfig().getInt("Announce.Broadcast.Sounds-Console.Volume");
                int pitch = ConfigCAnnounce.getConfig().getInt("Announce.Broadcast.Sounds-Console.Pitch");
                player.playSound(player.getLocation(), Sound.valueOf(sound), volume, pitch);
            }
        }
    }

}
