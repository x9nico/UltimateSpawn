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

public class MainCommand implements CommandExecutor {
	
	MainClass instance = MainClass.getInstance();
	
	public MainCommand() {}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Only-Player")));
	        return true;
		}
		
		Player p = (Player)sender;
		
		if(label.equalsIgnoreCase("UltimateSpawn") || label.equalsIgnoreCase("Us") && p.hasPermission("UltimateSpawn.help")){
			if((args.length == 0) || (args[0].equalsIgnoreCase("help"))){
				p.sendMessage("§3//§m---------------§r §c[§rUltimateSpawn§c] §3§m---------------§r§3\\\\");
				p.sendMessage("");
				p.sendMessage(" §8>> §7/setspawn - §eSet the spawn");
				p.sendMessage(" §8>> §7/spawn - §eGo to spawn");
				p.sendMessage(" §8>> §7/us reload - §eReload the plugin");
				p.sendMessage(" §8>> §7/cc - §eHelp of clearchat");
				p.sendMessage("");
				p.sendMessage("§3\\\\§m---------------§r §c[§rUltimateSpawn§c] §3§m---------------§r§3//");
			}
		    else if (args[0].equalsIgnoreCase("reload")) {
		    	if (p.hasPermission("UltimateSpawn.reload")) {
		    		ConfigGlobal.reloadConfig();
		    		ConfigMessage.reloadConfig();
		          
		    		if ((sender instanceof Player)) {
		    			Bukkit.getLogger().info("UltimateSpawn : Config reloaded (Just config.yml and message.yml)");
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
