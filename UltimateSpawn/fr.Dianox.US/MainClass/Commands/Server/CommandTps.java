package fr.Dianox.US.MainClass.Commands.Server;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.command.ConfigCTps;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;
import fr.Dianox.US.MainClass.config.messages.ConfigMServer;

public class CommandTps implements CommandExecutor {
	
	public CommandTps() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			if (cmd.getName().equalsIgnoreCase("tps")) {
				if (args.length == 0) {
					for (String msg: ConfigMServer.getConfig().getStringList("TPS.Normal")) {
						sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	                }
				}
			}
            return true;
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("tps") && p.hasPermission("ultimatespawn.command.tps")) {
			if (ConfigCTps.getConfig().getBoolean("Tps.Enable")) {
				for (String msg: ConfigMServer.getConfig().getStringList("TPS.Normal")) {
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
				}
			} else {
				if (ConfigCTps.getConfig().getBoolean("Tps.Disable-Message")) {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
						PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
					}
				}
			}
		}
		
		return true;
	}

}
