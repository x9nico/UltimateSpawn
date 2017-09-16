package fr.Dianox.US.MainClass.Commands.Chat;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;

public class MuteChatCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			
			consoleMuteChatGLobal();
			
            return true;
        }
		
		Player p = (Player)sender;
		
		if (cmd.getName().equalsIgnoreCase("GlobalMute") || cmd.getName().equalsIgnoreCase("gmute") && p.hasPermission("UltimateSpawn.mutechat")) {
			if (ConfigGlobal.getConfig().getBoolean("Command.MuteChat.Enable")) {
				if (ConfigGlobal.getConfig().getBoolean("Command.MuteChat.Mute.Enable")) {
					Bukkit.getLogger().info("UltimateSpawn : Chat - ON");
					PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.MuteChat.On"), Bukkit.getServer());
					ConfigGlobal.getConfig().set("Command.MuteChat.Mute.Enable", Boolean.valueOf(false));
				} else {
					Bukkit.getLogger().info("UltimateSpawn : Chat - OFF");
					PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(ConfigMessage.getConfig().getString("Admin.MuteChat.Off"), Bukkit.getServer());
					ConfigGlobal.getConfig().set("Command.MuteChat.Mute.Enable", Boolean.valueOf(true));
				}
			} else {
	            if (ConfigGlobal.getConfig().getBoolean("Command.MuteChat.Disable-Message")) {
	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
	            }
	        }
		} else {
			PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
        }
		
		return true;
	}
	
	public void consoleMuteChatGLobal() {
		if (ConfigGlobal.getConfig().getBoolean("Command.MuteChat.Mute.Enable")) {
			Bukkit.getLogger().info("UltimateSpawn : Chat - ON");
			PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(ConfigMessage.getConfig().getString("Admin.MuteChat.On"), Bukkit.getServer());
			ConfigGlobal.getConfig().set("Command.MuteChat.Mute.Enable", Boolean.valueOf(false));
		} else {
			Bukkit.getLogger().info("UltimateSpawn : Chat - OFF");
			PlaceHolderMessageUtils.ReplaceCharBroadcastPlayerExceptionConsole(ConfigMessage.getConfig().getString("Admin.MuteChat.Off"), Bukkit.getServer());
			ConfigGlobal.getConfig().set("Command.MuteChat.Mute.Enable", Boolean.valueOf(true));
		}
	}
	
	

}
