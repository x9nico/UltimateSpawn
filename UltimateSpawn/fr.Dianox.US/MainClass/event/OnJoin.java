package fr.Dianox.US.MainClass.event;

import org.bukkit.GameMode;
import org.bukkit.Sound;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.SpawnUtils;
import fr.Dianox.US.MainClass.Utils.TitleUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;

public class OnJoin implements Listener {

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        PlayerInventory inv = p.getInventory();

        int lines = ConfigGlobal.getConfig().getInt("On-Join.Clear.Chat.Lines-To-Clear");

        // Inventory
        if (ConfigGlobal.getConfig().getBoolean("On-Join.Clear.Inventory.Enable")) {
            if (ConfigGlobal.getConfig().getBoolean("On-Join.Clear.Inventory.Bypass")) {
                if (!p.hasPermission("UltimateSpawn.bypass.ClearInvOnJoin")) {
                    inv.clear();

                    if (ConfigGlobal.getConfig().getBoolean("On-Join.Clear.Inventory.Armor")) {
                        inv.setArmorContents(new ItemStack[4]);
                    }
                }
            } else {
                inv.clear();

                if (ConfigGlobal.getConfig().getBoolean("On-Join.Clear.Inventory.Armor")) {
                    inv.setArmorContents(new ItemStack[4]);
                }
            }
        }

        // Chat
        if (ConfigGlobal.getConfig().getBoolean("On-Join.Clear.Chat.Enable")) {
            if (ConfigGlobal.getConfig().getBoolean("On-Join.Clear.Chat.Bypass")) {
                if (!p.hasPermission("UltimateSpawn.bypass.ClearChatOnJoin")) {
                    for (int i = 0; i < lines; i++) {
                        p.sendMessage("");
                    }
                }
            } else {
                for (int i = 0; i < lines; i++) {
                    p.sendMessage("");
                }
            }
        }


        // Teleport spawn // broadcast new
        if (p.hasPlayedBefore()) {
            if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Teleport.Enable")) {
                SpawnUtils.teleportToSpawn(p);
            }
        } else {
            if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Teleport.On-First-Join")) {
                SpawnUtils.teleportToSpawn(p);
            }
            if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Broadcast.First-Join.Enable")) {
                for (String message: ConfigGlobal.getConfig().getStringList("On-Join.Spawn.Broadcast.First-Join.Message")) {
                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
                }
            }
            if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Message.First-Join.Enable")) {
                for (String message: ConfigGlobal.getConfig().getStringList("On-Join.Spawn.Message.First-Join.Message")) {
                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
                }
            }
        }

        // Gamemode
        int gm = ConfigGlobal.getConfig().getInt("On-Join.Spawn.Gamemode.Gamemode");

        if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Gamemode.Change")) {
            if (gm == 0) {
                p.setGameMode(GameMode.SURVIVAL);
            } else if (gm == 1) {
                p.setGameMode(GameMode.CREATIVE);
            } else if (gm == 2) {
                p.setGameMode(GameMode.ADVENTURE);
            } else if (gm == 3) {
                p.setGameMode(GameMode.SPECTATOR);
            }
        }

        // Fly
        if ((ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Fly")) && (gm != 3)) {
            p.setAllowFlight(ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Fly"));
            p.setFlying(ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Fly"));
        }

        // Restore Health and food
        if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Restore.Health")) {
            p.setHealth(20.0D);
        }

        if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Restore.Food")) {
            p.setFoodLevel(20);
        }

        // Cosmetics
        if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Firework")) {
            p.getWorld().spawnEntity(p.getLocation(), EntityType.FIREWORK);
        }

        if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Sounds.Enabled")) {
            String sound = ConfigGlobal.getConfig().getString("On-Join.Spawn.Sounds.Sound");
            int volume = ConfigGlobal.getConfig().getInt("On-Join.Spawn.Sounds.Volume");
            int pitch = ConfigGlobal.getConfig().getInt("On-Join.Spawn.Sounds.Pitch");
            p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
        }

        // Join
        if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Broadcast.Join.Enable")) {
            if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Broadcast.Join.Hide")) {
                e.setJoinMessage(null);
            } else {
                for (String message: ConfigGlobal.getConfig().getStringList("On-Join.Spawn.Broadcast.Join.Message")) {
                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
                }
                e.setJoinMessage(null);
            }
        }

        //Message join
        if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Message.Join.Enable")) {
            for (String message: ConfigGlobal.getConfig().getStringList("On-Join.Spawn.Message.Join.Message")) {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
            }
        }
        
        // TitleJoin
        if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.Enable")) {
        	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.Title.Enable")) {
        		TitleUtils.sendTitle(p, ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Title.FadeIn"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Title.Stay"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Title.FadeOut"), ConfigGlobal.getConfig().getString("On-Join.Spawn.Title.Title.Message"));
        	}
        	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.SubTitle.Enable")) {
        		TitleUtils.sendSubtitle(p, ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.SubTitle.FadeIn"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.SubTitle.Stay"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.SubTitle.FadeOut"), ConfigGlobal.getConfig().getString("On-Join.Spawn.Title.SubTitle.Message"));
        	}
        }
    }

}
