package fr.Dianox.US.MainClass.event;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerQuitEvent;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;

public class OnQuit implements Listener {

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();

        if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Fly")) {
            p.setAllowFlight(false);
            p.setFlying(false);
        }

        if (ConfigGlobal.getConfig().getBoolean("On-Quit.Broadcast.Quit.Enable")) {
            if (ConfigGlobal.getConfig().getBoolean("On-Quit.Broadcast.Quit.Hide")) {
                e.setQuitMessage(null);
            } else {
                for (String message: ConfigGlobal.getConfig().getStringList("On-Quit.Broadcast.Quit.Message")) {
                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
                }
                e.setQuitMessage(null);
            }
        }
    }

}
