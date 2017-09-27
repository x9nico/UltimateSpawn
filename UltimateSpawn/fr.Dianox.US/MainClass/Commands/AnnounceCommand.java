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
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.command.ConfigCGlobal;

public class AnnounceCommand implements CommandExecutor {

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (!(sender instanceof Player)) {

            if (args.length == 0) {
            	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Arguments-Missing")));
                return true;
            }

            String msg = "";
            for (String s: args) {
                if (!Objects.equals(msg, "")) {
                    msg = msg + " ";
                }
                msg = msg + s;
            }
            
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.Broadcast")+msg));

            PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.Broadcast") + msg, Bukkit.getServer());
            
            MusicConsole();

            return true;
        }

        Player p = (Player) sender;

        if (ConfigCGlobal.getConfig().getBoolean("Command.Broadcast.Enable")) {
            if (cmd.getName().equalsIgnoreCase("bc") || cmd.getName().equalsIgnoreCase("broadcast") && p.hasPermission("UltimateSpawn.Broadcast")) {

                if (args.length == 0) {
                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Error.Arguments-Missing"), Bukkit.getServer());
                    return true;
                }

                String msg = "";
                for (String s: args) {
                    if (!Objects.equals(msg, "")) {
                        msg = msg + " ";
                    }
                    msg = msg + s;
                }

                Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.Broadcast")+msg));

                PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.Broadcast") + msg, Bukkit.getServer());
                
                if (ConfigCGlobal.getConfig().getBoolean("Command.Broadcast.Sounds.Enabled")) {
                    for (Player player: Bukkit.getServer().getOnlinePlayers()) {
                        String sound = ConfigCGlobal.getConfig().getString("Command.Broadcast.Sounds.Sound");
                        int volume = ConfigCGlobal.getConfig().getInt("Command.Broadcast.Sounds.Volume");
                        int pitch = ConfigCGlobal.getConfig().getInt("Command.Broadcast.Sounds.Pitch");
                        player.playSound(player.getLocation(), Sound.valueOf(sound), volume, pitch);
                    }
                }

            } else {
                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
            }
        } else {
            if (ConfigCGlobal.getConfig().getBoolean("Command.Broadcast.Disable-Message")) {
                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
            }
        }

        return true;
    }

    private static void MusicConsole() {
        if (ConfigCGlobal.getConfig().getBoolean("Command.Broadcast.Sounds-Console.Enabled")) {
            for (Player player: Bukkit.getServer().getOnlinePlayers()) {
                String sound = ConfigCGlobal.getConfig().getString("Command.Broadcast.Sounds-Console.Sound");
                int volume = ConfigCGlobal.getConfig().getInt("Command.Broadcast.Sounds-Console.Volume");
                int pitch = ConfigCGlobal.getConfig().getInt("Command.Broadcast.Sounds-Console.Pitch");
                player.playSound(player.getLocation(), Sound.valueOf(sound), volume, pitch);
            }
        }
    }

}
