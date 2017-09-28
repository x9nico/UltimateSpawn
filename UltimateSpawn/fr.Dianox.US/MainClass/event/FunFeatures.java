package fr.Dianox.US.MainClass.event;

import org.bukkit.Effect;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.util.Vector;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.config.fun.ConfigFJumpad;

public class FunFeatures implements Listener {
	
	// JumpPads
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Enable")) {
			if (!ConfigFJumpad.getConfig().getBoolean("JumpPads.World.All_World")) {
				if (MainClass.getWJumpPads().contains(p.getWorld().getName())) {
					int block = ConfigFJumpad.getConfig().getInt("JumpPads.Options.Block-ID");
					int plate = ConfigFJumpad.getConfig().getInt("JumpPads.Options.Plate-ID");
					if ((p.getLocation().getBlock().getType().getId() == plate) && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType().getId() == block)) {
						double height = ConfigFJumpad.getConfig().getDouble("JumpPads.Options.Height");
						double length = ConfigFJumpad.getConfig().getDouble("JumpPads.Options.Length");
						Vector v = p.getLocation().getDirection().multiply(length).setY(height);
						p.setVelocity(v);
						p.setFallDistance(-999.0F);
						String sound = ConfigFJumpad.getConfig().getString("JumpPads.Sounds.Sound");
						int volume = ConfigFJumpad.getConfig().getInt("JumpPads.Sounds.Volume");
						int pitch = ConfigFJumpad.getConfig().getInt("JumpPads.Sounds.Pitch");
						if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Sounds.Enable")) {
							p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.valueOf(sound), volume, pitch);
						}
						String effect = ConfigFJumpad.getConfig().getString("JumpPads.Effect.Effect");
						int pitch2 = ConfigFJumpad.getConfig().getInt("JumpPads.Effect.Pitch");
						if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Effect.Enable")) {
							p.playEffect(p.getPlayer().getLocation(), Effect.valueOf(effect), pitch2);
						}
					}
				}
			} else {
				int block = ConfigFJumpad.getConfig().getInt("JumpPads.Options.Block-ID");
				int plate = ConfigFJumpad.getConfig().getInt("JumpPads.Options.Plate-ID");
				if ((p.getLocation().getBlock().getType().getId() == plate) && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType().getId() == block)) {
					double height = ConfigFJumpad.getConfig().getDouble("JumpPads.Options.Height");
					double length = ConfigFJumpad.getConfig().getDouble("JumpPads.Options.Length");
					Vector v = p.getLocation().getDirection().multiply(length).setY(height);
					p.setVelocity(v);
					p.setFallDistance(-999.0F);
					String sound = ConfigFJumpad.getConfig().getString("JumpPads.Sounds.Sound");
					int volume = ConfigFJumpad.getConfig().getInt("JumpPads.Sounds.Volume");
					int pitch = ConfigFJumpad.getConfig().getInt("JumpPads.Sounds.Pitch");
					if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Sounds.Enable")) {
						p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.valueOf(sound), volume, pitch);
					}
					String effect = ConfigFJumpad.getConfig().getString("JumpPads.Effect.Effect");
					int pitch2 = ConfigFJumpad.getConfig().getInt("JumpPads.Effect.Pitch");
					if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Effect.Enable")) {
						p.playEffect(p.getPlayer().getLocation(), Effect.valueOf(effect), pitch2);
					}
				}
			}
		}
	}	

}
