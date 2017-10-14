package fr.Dianox.US.MainClass.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerCommandPreprocessEvent;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigBlockCommands;

public class OnCommand implements Listener {
	
	@EventHandler
	public void onBlockCommand(PlayerCommandPreprocessEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigBlockCommands.getConfig().getBoolean("Block-Commands.Bypass")) {
			if (!p.hasPermission("ultimatespawn.event.bypass.blockcommands")) {
				for (String i : ConfigBlockCommands.getConfig().getStringList("Block-Commands.List")) {
					if (e.getMessage().equalsIgnoreCase(i)) {
						e.setCancelled(true);
						if (ConfigBlockCommands.getConfig().getBoolean("Block-Commands.Message-Enable")) {
							PlaceHolderMessageUtils.ReplaceCharMessagePlayer("Block-Commands.Message", p);
						}
					}
				}
			}
		} else {
			for (String i : ConfigBlockCommands.getConfig().getStringList("Block-Commands.List")) {
				if (e.getMessage().equalsIgnoreCase(i)) {
					e.setCancelled(true);
					if (ConfigBlockCommands.getConfig().getBoolean("Block-Commands.Message-Enable")) {
						PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigBlockCommands.getConfig().getString("Block-Commands.Message"), p);
					}
				}
			}
		}
	}
}
