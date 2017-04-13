package fr.Dianox.US.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass;
import fr.Dianox.US.Utils;
import fr.Dianox.US.config.ConfigMessage;
import fr.Dianox.US.config.ConfigSpawn;
import fr.Dianox.US.config.ConfigUtils;

public class CommandSpawn implements CommandExecutor {

	MainClass instance = MainClass.getInstance();
	
	public CommandSpawn() {}
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(!(sender instanceof Player)){
			sender.sendMessage(ConfigUtils.console_use_command);
			return true;
		}
		
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("setspawn") || cmd.getName().equalsIgnoreCase("sethub") || cmd.getName().equalsIgnoreCase("setlobby")) {
			if(p.hasPermission("UltimateSpawn.SetSpawn")){
				if (!(sender instanceof Player)) {
					sender.sendMessage(ConfigUtils.console_use_command);
					return true;
				}
					      
				Location l = p.getLocation();
					        
				ConfigSpawn.getConfig().set("spawn.world", l.getWorld().getName());
			    ConfigSpawn.getConfig().set("spawn.x", Double.valueOf(l.getX()));
			    ConfigSpawn.getConfig().set("spawn.y", Double.valueOf(l.getY()));
			    ConfigSpawn.getConfig().set("spawn.z", Double.valueOf(l.getZ()));
			    ConfigSpawn.getConfig().set("spawn.yaw", Float.valueOf(l.getYaw()));
			    ConfigSpawn.getConfig().set("spawn.pitch", Float.valueOf(l.getPitch()));
					        
			    ConfigSpawn.saveConfigFile();
				        
			    p.getWorld().setSpawnLocation((int)l.getX(), (int)l.getY(), (int)l.getZ());
				        
			    p.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("spawn.Spawn-create")));
			} else {
				sender.sendMessage(ConfigUtils.no_permission);
			}
		} 
		
		else if(label.equalsIgnoreCase("spawn") || label.equalsIgnoreCase("hub") || label.equalsIgnoreCase("lobby") || label.equalsIgnoreCase("h") || label.equalsIgnoreCase("l")){
			if(args.length == 0){
				if (!(sender instanceof Player)) {
					sender.sendMessage(ConfigUtils.console_use_command);
		            return true;
				}
				Utils.teleportToSpawn(p, true);
			} else if (args.length == 1) {
				if(p.hasPermission("UltimateSpawn.TeleportOthers")) {
					Player target = Bukkit.getServer().getPlayer(args[0]);
			          
					if (target == null) {
						sender.sendMessage(ConfigUtils.player_not_found);
						return true;
					}
			          
					Utils.teleportToSpawn(target, sender);
				} else {
					sender.sendMessage(ConfigUtils.no_permission);
				}
			}
		} else {
			sender.sendMessage(ConfigUtils.no_permission);
		}
		return true;
	}
}
