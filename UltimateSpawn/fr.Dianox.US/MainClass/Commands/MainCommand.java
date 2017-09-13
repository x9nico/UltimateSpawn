package fr.Dianox.US.MainClass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigSpawn;

public class MainCommand implements CommandExecutor {

    MainClass instance = MainClass.getInstance();

    public MainCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (!(sender instanceof Player)) {
            if (cmd.getName().equalsIgnoreCase("UltimateSpawn") || cmd.getName().equalsIgnoreCase("Us")) {
                if ((args.length == 0) || (args[0].equalsIgnoreCase("help"))) {
                    sender.sendMessage("§3//§m---------------§r §c[§bUltimateSpawn§c] §3§m---------------§r§3\\\\");
                    sender.sendMessage("");
                    sender.sendMessage(" §8>> §7/setspawn - §cSet the spawn (You can't)");
                    sender.sendMessage(" §8>> §7/spawn - §cGo to spawn (You can't)");
                    sender.sendMessage(" §8>> §7/us reload - §eReload the plugin");
                    sender.sendMessage(" §8>> §7/cc - §eHelp of clearchat");
                    sender.sendMessage(" §8>> §7/bc - §eBroadcast ");
                    sender.sendMessage(" §8>> §7/ping - §ePing ");
                    sender.sendMessage("");
                    sender.sendMessage("§3\\\\§m---------------§r §c[§bUltimateSpawn§c] §3§m---------------§r§3//");
                } else if (args[0].equalsIgnoreCase("reload")) {
                    ConfigGlobal.reloadConfig();
                    ConfigMessage.reloadConfig();
                    ConfigSpawn.reloadConfig();

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.Plugin-Reload")));

                }
            }
            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("UltimateSpawn") || cmd.getName().equalsIgnoreCase("Us") && p.hasPermission("UltimateSpawn.help")) {
            if ((args.length == 0) || (args[0].equalsIgnoreCase("help"))) {
                p.sendMessage("§3//§m---------------§r §c[§bUltimateSpawn§c] §3§m---------------§r§3\\\\");
                p.sendMessage("");
                p.sendMessage(" §8>> §7/setspawn - §eSet the spawn");
                p.sendMessage(" §8>> §7/spawn - §eGo to spawn");
                p.sendMessage(" §8>> §7/us reload - §eReload the plugin");
                p.sendMessage(" §8>> §7/cc - §eHelp of clearchat");
                p.sendMessage(" §8>> §7/bc - §eBroadcast ");
                p.sendMessage(" §8>> §7/ping - §ePing ");
                p.sendMessage("");
                p.sendMessage("§3\\\\§m---------------§r §c[§bUltimateSpawn§c] §3§m---------------§r§3//");
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (p.hasPermission("UltimateSpawn.reload")) {
                    ConfigGlobal.reloadConfig();
                    ConfigMessage.reloadConfig();
                    ConfigSpawn.reloadConfig();

                    if ((sender instanceof Player)) {
                        Bukkit.getLogger().info("UltimateSpawn : Config reloaded (Just config.yml, message.yml and spawn.yml)");
                    }
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.Plugin-Reload")));
                } else {
                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.No-permission")));
                }

            }
        } else {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.No-permission")));
        }
        return true;

    }

}
