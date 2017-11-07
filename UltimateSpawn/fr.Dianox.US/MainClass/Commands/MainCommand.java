package fr.Dianox.US.MainClass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.OtherUtils;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.Server.Tps;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;
import fr.Dianox.US.MainClass.config.messages.ConfigMServer;

public class MainCommand implements CommandExecutor {

    MainClass instance = MainClass.getInstance();

    public MainCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (!(sender instanceof Player)) {
            if (cmd.getName().equalsIgnoreCase("ultimatespawn") || cmd.getName().equalsIgnoreCase("us")) {
                if ((args.length == 0) || (args[0].equalsIgnoreCase("help") || (args[0].equalsIgnoreCase("?")))) {
                	if (args.length == 2) {
         				if (args[1].equalsIgnoreCase("2")) {
         					sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
         					sender.sendMessage("");
         					sender.sendMessage("     §l>> §e§o§lGlobal Help §c(Page 2)");
         					sender.sendMessage("");
         					sender.sendMessage(" §8>> §7/us tps or /tps - §eCheck TPS");
         					sender.sendMessage(" §8>> §7/us v - §eSee the version of the plugin");
         					sender.sendMessage("");
         					sender.sendMessage(" §l> §c§l/us help ???? x'D");
         					sender.sendMessage("");
         					sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
         				}
         				return true;
         			}
                    sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
                    sender.sendMessage("");
                    sender.sendMessage("     §l>> §e§o§lGlobal Help §c(Page 1)");
                    sender.sendMessage("");
                    sender.sendMessage(" §8>> §7/setspawn - §cSet the spawn (You can't)");
                    sender.sendMessage(" §8>> §7/spawn - §cGo to spawn (You can't)");
                    sender.sendMessage(" §8>> §7/us reload - §eReload the plugin");
                    sender.sendMessage(" §8>> §7/cc - §bHelp of clearchat");
                    sender.sendMessage(" §8>> §7/bc - §eBroadcast");
                    sender.sendMessage(" §8>> §7/ping - §ePing");
                    sender.sendMessage(" §8>> §7/gmute - §eMute chat");
                    sender.sendMessage(" §8>> §7/dchat <delay> - §eDelayChat");
                    sender.sendMessage(" §8>> §7/fly [player] - §eEnable or disable the fly §6for a player");
                    sender.sendMessage("");
                    sender.sendMessage(" §l> §c§l/us help 2");
                    sender.sendMessage("");
                    sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
                } else if (args[0].equalsIgnoreCase("reload")) {
                	OtherUtils.reloadconfig();
                    
                    MainClass.getInstance().GetSetWorld();
                    
                    for (String msg: ConfigMPlugin.getConfig().getStringList("Admin.Reload")) {
                    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
                    }
                } else if (args[0].equalsIgnoreCase("tps")) {
                	for (String msg: ConfigMServer.getConfig().getStringList("TPS.Normal")) {
                		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg).replaceAll("%tps%", String.valueOf(Tps.getTPS())));
                	}
                } else if (args[0].equalsIgnoreCase("v") || args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("ver")) {
                	sender.sendMessage("§b"+MainClass.getInstance().getPluginVersion());
                }
            }
            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("ultimatespawn") || cmd.getName().equalsIgnoreCase("us")) {
        	if (p.hasPermission("ultimatespawn.command.main")) {
         		if ((args.length == 0) || args[0].equalsIgnoreCase("help") || args[0].equalsIgnoreCase("?")) {
         			if (args.length == 2) {
         				if (args[1].equalsIgnoreCase("2")) {
	         				p.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
	    	                p.sendMessage("");
	    	                p.sendMessage("     §l>> §e§o§lGlobal Help §c(Page 2)");
	    	                p.sendMessage("");
	    	                p.sendMessage(" §8>> §7/us tps - §eCheck TPS");
	    	                p.sendMessage(" §8>> §7/us v - §eSee the version of the plugin");
	    	                p.sendMessage("");
	    	                p.sendMessage(" §l> §c§l/us help ???? x'D");
	    	                p.sendMessage("");
	    	                p.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
         				}
         				return true;
         			}
         			p.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
	                p.sendMessage("");
	                p.sendMessage("     §l>> §e§o§lGlobal Help §c(Page 1)");
	                p.sendMessage("");
	                p.sendMessage(" §8>> §7/setspawn [§evoidtp§7|§efirstjoin§7] - §eSet the spawn");
	                p.sendMessage(" §8>> §7/spawn - §eGo to spawn");
	                p.sendMessage(" §8>> §7/us reload - §eReload the plugin");
	                p.sendMessage(" §8>> §7/cc - §bHelp of clearchat");
	                p.sendMessage(" §8>> §7/bc - §eBroadcast");
	                p.sendMessage(" §8>> §7/ping - §ePing");
	                p.sendMessage(" §8>> §7/gmute - §eMute chat");
	                p.sendMessage(" §8>> §7/dchat <delay> - §eDelayChat");
	                p.sendMessage(" §8>> §7/fly [player] - §eEnable or disable the fly");
	                p.sendMessage("");
	                p.sendMessage(" §l> §c§l/us help 2");
	                p.sendMessage("");
	                p.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
         		} else if (args[0].equalsIgnoreCase("reload") && p.hasPermission("ultimatespawn.command.main.reload")) {
	                OtherUtils.reloadconfig();
	                    
	                MainClass.getInstance().GetSetWorld();
	                    
	                if (!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
	                	ConfigGlobal.getConfig().set("Plugin.Use.PlaceholderAPI", Boolean.valueOf(false));
	                }
	                    
	                if ((sender instanceof Player)) {
	                	for (String msg: ConfigMPlugin.getConfig().getStringList("Admin.Reload")) {
	                		Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	                	}
	                }
	                for (String msg: ConfigMPlugin.getConfig().getStringList("Admin.Reload")) {
	                	 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                }
	            } else if (args[0].equalsIgnoreCase("tps") && p.hasPermission("ultimatespawn.command.tps")) {
	            	for (String msg: ConfigMServer.getConfig().getStringList("TPS.Normal")) {
	                	 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                }
	            } else if (args[0].equalsIgnoreCase("v") || args[0].equalsIgnoreCase("version") || args[0].equalsIgnoreCase("ver")) {
                	p.sendMessage("§b"+MainClass.getInstance().getPluginVersion());
                }
        	} else {
            	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
            	}
            }
        }
        return true;
    
    }

}
