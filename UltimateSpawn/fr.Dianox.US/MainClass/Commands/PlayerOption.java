package fr.Dianox.US.MainClass.Commands;

import java.util.UUID;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.command.ConfigCPlayerOption;

public class PlayerOption implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Only-Player")));
            return true;
        }

		 Player p = (Player) sender;
		 UUID pU = p.getUniqueId();
		 
		 if (cmd.getName().equalsIgnoreCase("playeroption") || cmd.getName().equalsIgnoreCase("playeroptions") || cmd.getName().equalsIgnoreCase("playersoption") || cmd.getName().equalsIgnoreCase("playersoptions") || cmd.getName().equalsIgnoreCase("poption") || cmd.getName().equalsIgnoreCase("poptions") || cmd.getName().equalsIgnoreCase("option") || cmd.getName().equalsIgnoreCase("options")) {
			 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.Fly.Enable")) {
				 if (args.length == 0) {
					 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.Help.Use_Permission")) {
						 if (p.hasPermission("ultimatespawn.command.playeroption.help")) {
							 sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bPlayerOption§3] §8//§7§m---------------§r§8\\\\");
			                 sender.sendMessage("");
			                 sender.sendMessage("     §l>> §e§o§lPlayer option Help");
			                 sender.sendMessage("");
			                 sender.sendMessage(" §8>> §7/option fly - §eSet the fly");
			                 sender.sendMessage(" §8>> §7/option doublejump - §eEnable or disable the doublejump");
			                 sender.sendMessage("");
			                 sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bPlayerOption§3] §8\\\\§7§m---------------§r§8//");
						 } else {
							 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
						 }
					 } else {
						 sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bPlayerOption§3] §8//§7§m---------------§r§8\\\\");
		                 sender.sendMessage("");
		                 sender.sendMessage("     §l>> §e§o§lPlayer option Help");
		                 sender.sendMessage("");
		                 sender.sendMessage(" §8>> §7/option fly - §eSet the fly");
		                 sender.sendMessage(" §8>> §7/option doublejump - §eEnable or disable the doublejump");
		                 sender.sendMessage("");
		                 sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bPlayerOption§3] §8\\\\§7§m---------------§r§8//");
					 }
				 } else if (args[0].equalsIgnoreCase("fly")) {
					 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.Fly.Enable")) {
						 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.Fly.Use_Permission")) {
							 if (p.hasPermission("ultimatespawn.command.playeroption.fly")) {
								 if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
									 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), p);
				                    	
									 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
									 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
									 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
					       				
									 ConfigTemp.saveConfigFile();
					       	        	
									 p.setAllowFlight(false);
									 p.setFlying(false);
								 } else {
									 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), p);
					       				
									 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(true));
									 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(true));
									 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
					       				
									 ConfigTemp.saveConfigFile();
					       	        	
									 p.setAllowFlight(true);
									 p.setFlying(true);
									 
									 if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
										 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
										 
										 ConfigTemp.saveConfigFile();
									 }
								 }
							 } else {
								 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
							 }
						 } else {
							 if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
								 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), p);
			                    	
								 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
								 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
								 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
				       				
								 ConfigTemp.saveConfigFile();
				       	        	
								 p.setAllowFlight(false);
								 p.setFlying(false);
								 
								 if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
									 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
									 
									 ConfigTemp.saveConfigFile();
								 }
							 } else {
								 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), p);
				       				
								 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(true));
								 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(true));
								 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
				       				
								 ConfigTemp.saveConfigFile();
				       	        	
								 p.setAllowFlight(true);
								 p.setFlying(true);
							 }
						 }
					 } else {
						 if (ConfigCPlayerOption.getConfig().getBoolean("Announce.Broadcast.Disable-Message")) {
							 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
						 }
					 }
				 } else if (args[0].equalsIgnoreCase("doublejump") || args[0].equalsIgnoreCase("dj")) {
					 if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.DoubleJump.Use_Permission")) {
						 if (p.hasPermission("ultimatespawn.command.playeroption.fly")) {
							 if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
								 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
								 
								 ConfigTemp.saveConfigFile();
							 } else {
								 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(true));
								 
								 ConfigTemp.saveConfigFile();
							 }
						 } else {
							 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
						 }
					 } else {
						 if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
							 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
							 
							 ConfigTemp.saveConfigFile();
						 } else {
							 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(true));
							 
							 ConfigTemp.saveConfigFile();
						 }
					 }
				 }
			 } else {
				 if (ConfigCPlayerOption.getConfig().getBoolean("Announce.Broadcast.Disable-Message")) {
					 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
				 }
			 }
		 }
		
		return true;
	}
	
	

}
