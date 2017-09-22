package fr.Dianox.US.MainClass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
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
                    sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
                    sender.sendMessage("");
                    sender.sendMessage("     §l>> §e§o§lGlobal Help");
                    sender.sendMessage("");
                    sender.sendMessage(" §8>> §7/setspawn - §cSet the spawn (You can't)");
                    sender.sendMessage(" §8>> §7/spawn - §cGo to spawn (You can't)");
                    sender.sendMessage(" §8>> §7/us reload - §eReload the plugin");
                    sender.sendMessage(" §8>> §7/cc - §bHelp of clearchat");
                    sender.sendMessage(" §8>> §7/bc - §eBroadcast ");
                    sender.sendMessage(" §8>> §7/ping - §ePing ");
                    sender.sendMessage(" §8>> §7/gmute - §eMute chat ");
                    sender.sendMessage(" §8>> §7/dchat [delay] - §eDelayChat ");
                    sender.sendMessage("");
                    sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
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
            if ((args.length == 0) || (args[0].equalsIgnoreCase("help") && p.hasPermission("UltimateSpawn.help"))) {
            	p.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
                p.sendMessage("");
                p.sendMessage("     §l>> §e§o§lGlobal Help");
                p.sendMessage("");
                p.sendMessage(" §8>> §7/setspawn - §eSet the spawn");
                p.sendMessage(" §8>> §7/spawn - §eGo to spawn");
                p.sendMessage(" §8>> §7/us reload - §eReload the plugin");
                p.sendMessage(" §8>> §7/cc - §bHelp of clearchat");
                p.sendMessage(" §8>> §7/bc - §eBroadcast ");
                p.sendMessage(" §8>> §7/ping - §ePing ");
                p.sendMessage(" §8>> §7/gmute - §eMute chat ");
                p.sendMessage(" §8>> §7/dchat [delay] - §eDelayChat ");
                p.sendMessage("");
                p.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (p.hasPermission("UltimateSpawn.reload")) {
                    ConfigGlobal.reloadConfig();
                    ConfigMessage.reloadConfig();
                    ConfigSpawn.reloadConfig();

                    if (!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                    	ConfigGlobal.getConfig().set("Plugin.Use.PlaceholderAPI", Boolean.valueOf(false));
                    }
                    
                    if ((sender instanceof Player)) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.Plugin-Reload")));
                    }
                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.Plugin-Reload"), p);

                } else {
                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
                }

            }
        } else {
        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
        }
        return true;

    }

}
