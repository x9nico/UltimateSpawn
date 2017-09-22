package fr.Dianox.US.MainClass.Commands.Chat;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;

public class ClearChatCommand implements CommandExecutor {

    public ClearChatCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        int lines = ConfigGlobal.getConfig().getInt("On-Join.Clear.Chat.Lines-To-Clear");

        if (!(sender instanceof Player)) {
            if (label.equalsIgnoreCase("cc")) {
                if ((args.length == 0)) {
                	sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
                    sender.sendMessage("");
                    sender.sendMessage("     §l>> §e§o§lClearChat Help");
                    sender.sendMessage("");
                    sender.sendMessage(" §8>> §7/cc a - §eClear the chat anonymously");
                    sender.sendMessage(" §8>> §7/cc o - §cClear your own chat (You can't)");
                    sender.sendMessage(" §8>> §7/cc c - §eClear the chat");
                    sender.sendMessage(" §8>> §7/cc other [player] - §eClear someone elses chat");
                    sender.sendMessage("");
                    sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
                } else if (args[0].equalsIgnoreCase("a")) {
                    if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Anonymous.Enable")) {
                        for (int i = 0; i < lines; i++) {
                            Bukkit.broadcastMessage(" ");
                        }

                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Anonymously")));
                        ccac();
                    }
                } else if (args[0].equalsIgnoreCase("c")) {
                    for (int i = 0; i < lines; i++) {
                        Bukkit.broadcastMessage(" ");
                    }

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Normal.Console")));
                    cccc();
                } else if (args[0].equalsIgnoreCase("other")) {

                    if (args.length != 2) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Enter-Player-Name")));
                        sender.sendMessage(ChatColor.RED + "/cc other [player]");
                        return true;
                    }
                    Player target = Bukkit.getServer().getPlayer(args[1]);

                    if (target == null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
                        return true;
                    }

                    for (int i = 0; i < lines; i++) {
                        target.sendMessage(" ");
                    }

                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Other"), target);
                }
            }

            return true;
        }

        Player p = (Player) sender;

        if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Enable")) {
            if (label.equalsIgnoreCase("cc") && p.hasPermission("UltimateSpawn.clearchat")) {
                if ((args.length == 0)) {
                    p.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
                    p.sendMessage("");
                    p.sendMessage("     §l>> §e§o§lClearChat Help");
                    p.sendMessage("");
                    p.sendMessage(" §8>> §7/cc a - §eClear the chat anonymously");
                    p.sendMessage(" §8>> §7/cc o - §eClear your own chat");
                    p.sendMessage(" §8>> §7/cc c - §eClear the chat");
                    p.sendMessage(" §8>> §7/cc other [player] - §eClear someone elses chat");
                    p.sendMessage("");
                    p.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
                } else if (args[0].equalsIgnoreCase("a")) {
                    if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Anonymous.Enable")) {
                        for (int i = 0; i < lines; i++) {
                            Bukkit.broadcastMessage(" ");
                        }
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Anonymously")));
                        PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Anonymously"), Bukkit.getServer());
                    } else {
                        if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Anonymous.Console.Message-Clear")) {
                        	Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Anonymously")));
                            PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Anonymously"), Bukkit.getServer());
                        }
                    }
                } else if (args[0].equalsIgnoreCase("c")) {
                    if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Normal.Enable")) {
                        for (int i = 0; i < lines; i++) {
                            Bukkit.broadcastMessage(" ");
                        }
                        if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Normal.Message-Clear")) {
                        	Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Console.ClearChat.Normal.Player").replaceAll("%player%", String.valueOf(p))));
                            PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Normal"), Bukkit.getServer());
                        }
                    } else {
                        if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Normal.Disable-Message")) {
                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                        }
                    }
                } else if (args[0].equalsIgnoreCase("o")) {
                    if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Own.Enable")) {
                        for (int i = 0; i < lines; i++) {
                            p.sendMessage(" ");
                        }
                        if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Own.Message-Clear")) {
                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Own"), p);
                        }
                    } else {
                        if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Own.Disable-Message")) {
                        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                        }
                    }
                } else if (args[0].equalsIgnoreCase("other")) {
                    if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Other.Enable")) {

                        if (args.length != 2) {
                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Player.Enter-Player-Name"), (Player) sender);
                            sender.sendMessage(ChatColor.RED + "/cc other [player]");
                            return true;
                        }
                        Player target = Bukkit.getServer().getPlayer(args[1]);

                        if (target == null) {
                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Player.Not-found"), (Player) sender);
                            return true;
                        }

                        for (int i = 0; i < lines; i++) {
                            target.sendMessage(" ");
                        }
                        if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Other.Message-Clear")) {
                            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Other"), target);
                        }
                    }
                }
            } else {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
            }
        }

        return true;
    }

    public void ccac() {
        if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Console.Anonymous-Message-Clear")) {
            PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.ClearChat.Anonymously"), Bukkit.getServer());
        }
    }

    public void cccc() {
        if (ConfigGlobal.getConfig().getBoolean("Command.ClearChat.Console.Normal-Message-Clear")) {
            PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(ConfigMessage.getConfig().getString("Admin.ClearChat.Normal"), Bukkit.getServer());
        }
    }

}
