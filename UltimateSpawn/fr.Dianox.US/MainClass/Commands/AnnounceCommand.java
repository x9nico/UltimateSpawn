package fr.Dianox.US.MainClass.Commands;

import java.util.Objects;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;

public class AnnounceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (!(sender instanceof Player)) {

            if (args.length == 0) {
                return true;
            }

            String msg = "";
            for (String s: args) {
                if (!Objects.equals(msg, "")) {
                    msg = msg + " ";
                }
                msg = msg + s;
            }

            Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.Broadcast")) + msg);

            MusicConsole();

            return true;
        }

        Player p = (Player) sender;

        if (ConfigGlobal.getConfig().getBoolean("Command.Broadcast.Enable")) {
            if (cmd.getName().equalsIgnoreCase("bc") || cmd.getName().equalsIgnoreCase("broadcast") && p.hasPermission("UltimateSpawn.Broadcast")) {

                if (args.length == 0) {
                    return true;
                }

                String msg = "";
                for (String s: args) {
                    if (!Objects.equals(msg, "")) {
                        msg = msg + " ";
                    }
                    msg = msg + s;
                }

                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.Broadcast")) + msg);

                if (ConfigGlobal.getConfig().getBoolean("Command.Broadcast.Sounds.Enabled")) {
                    for (Player player: Bukkit.getServer().getOnlinePlayers()) {
                        String sound = ConfigGlobal.getConfig().getString("Command.Broadcast.Sounds.Sound");
                        int volume = ConfigGlobal.getConfig().getInt("Command.Broadcast.Sounds.Volume");
                        int pitch = ConfigGlobal.getConfig().getInt("Command.Broadcast.Sounds.Pitch");
                        player.playSound(player.getLocation(), Sound.valueOf(sound), volume, pitch);
                    }
                }

            } else {
                sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.No-permission")));
            }
        } else {
            if (ConfigGlobal.getConfig().getBoolean("Command.Broadcast.Disable-Message")) {
                p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Command-disable")));
            }
        }

        return true;
    }

    private static void MusicConsole() {
        if (ConfigGlobal.getConfig().getBoolean("Command.Broadcast.Sounds-Console.Enabled")) {
            for (Player player: Bukkit.getServer().getOnlinePlayers()) {
                String sound = ConfigGlobal.getConfig().getString("Command.Broadcast.Sounds-Console.Sound");
                int volume = ConfigGlobal.getConfig().getInt("Command.Broadcast.Sounds-Console.Volume");
                int pitch = ConfigGlobal.getConfig().getInt("Command.Broadcast.Sounds-Console.Pitch");
                player.playSound(player.getLocation(), Sound.valueOf(sound), volume, pitch);
            }
        }
    }

}
