package fr.Dianox.US.MainClass.event;

import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Location;
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
import fr.Dianox.US.MainClass.config.ConfigPlayerOptions;
import fr.Dianox.US.MainClass.config.ConfigPlayerStats;

public class OnJoin implements Listener {

    @SuppressWarnings("deprecation")
	@EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID pU = e.getPlayer().getUniqueId();
        PlayerInventory inv = p.getInventory();
        Location l = p.getLocation();

        int lines = ConfigGlobal.getConfig().getInt("On-Join.Clear.Chat.Lines-To-Clear");

        // Options
        if (!ConfigPlayerOptions.getConfig().contains(String.valueOf(pU))) {
        	ConfigPlayerOptions.getConfig().set(pU+".Player", String.valueOf(p));
        	ConfigPlayerOptions.getConfig().set(pU+".Options.Fly", ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Fly"));
        	
        	ConfigPlayerOptions.saveConfigFile();
        } else {
        	// Check player name
        	if (ConfigPlayerOptions.getConfig().getString(pU+".Player") != String.valueOf(p)) {
        		ConfigPlayerOptions.getConfig().set(pU+".Player", String.valueOf(p));
        		
        		ConfigPlayerOptions.saveConfigFile();
        	}
        }
        
        // Stats
        if (ConfigGlobal.getConfig().getBoolean("Plugin.Create.Stats")) {
	        if (!ConfigPlayerStats.getConfig().contains(String.valueOf(pU))) {
	        	ConfigPlayerStats.getConfig().set(pU+".Player", String.valueOf(p));
	        	ConfigPlayerStats.getConfig().set(pU+".Position.Last_login.World", l.getWorld().getName());
	        	ConfigPlayerStats.getConfig().set(pU+".Position.Last_login.x", Double.valueOf(l.getX()));
	        	ConfigPlayerStats.getConfig().set(pU+".Position.Last_login.y", Double.valueOf(l.getY()));
	        	ConfigPlayerStats.getConfig().set(pU+".Position.Last_login.z", Double.valueOf(l.getZ()));
	        	ConfigPlayerStats.getConfig().set(pU+".Position.Last_login.yaw", Float.valueOf(l.getYaw()));
	        	ConfigPlayerStats.getConfig().set(pU+".Position.Last_login.pitch", Float.valueOf(l.getPitch()));
	        	
	        	ConfigPlayerStats.saveConfigFile();
	        } else {
	        	// Check player name
	        	if (ConfigPlayerStats.getConfig().getString(pU+".Player") != String.valueOf(p)) {
	        		ConfigPlayerStats.getConfig().set(pU+".Player", String.valueOf(p));
	        		
	        		ConfigPlayerStats.saveConfigFile();
	        	}
	        }
    	}
        
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
            	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Teleport.If_stats_is_enable.Use_stats_Of_UltimateSpawn.To_teleport_players.To_their_last_location")) {
            		SpawnUtils.teleportToSpawnStats(p);
            	} else {
            		SpawnUtils.teleportToSpawn(p);
            	}
            } else if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Teleport.If_stats_is_enable.If_Teleport_on_join_is_disable.Use_stats_Of_UltimateSpawn.To_teleport_players.To_their_last_location")) {
            	SpawnUtils.teleportToSpawnStats(p);
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
            p.setAllowFlight(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly"));
            p.setFlying(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly"));
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
        	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.First-Join.Enable")) {
        		if (p.hasPlayedBefore()) {
            		if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.Join.Enable")) {
    		        	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.Join.Title.Enable")) {
    		        		TitleUtils.sendTitle(p, ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.Title.FadeIn"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.Title.Stay"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.Title.FadeOut"), ConfigGlobal.getConfig().getString("On-Join.Spawn.Title.Join.Title.Message"));
    		        	}
    		        	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.Join.SubTitle.Enable")) {
    		        		TitleUtils.sendSubtitle(p, ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.SubTitle.FadeIn"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.SubTitle.Stay"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.SubTitle.FadeOut"), ConfigGlobal.getConfig().getString("On-Join.Spawn.Title.Join.SubTitle.Message"));
    		        	}
            		}
        		} else {
        			if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.First-Join.Title.Enable")) {
		        		TitleUtils.sendTitle(p, ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.First-Join.Title.FadeIn"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.First-Join.Title.Stay"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.First-Join.Title.FadeOut"), ConfigGlobal.getConfig().getString("On-Join.Spawn.Title.First-Join.Title.Message"));
		        	}
		        	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.First-Join.SubTitle.Enable")) {
		        		TitleUtils.sendSubtitle(p, ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.First-Join.SubTitle.FadeIn"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.First-Join.SubTitle.Stay"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.First-Join.SubTitle.FadeOut"), ConfigGlobal.getConfig().getString("On-Join.Spawn.Title.First-Join.SubTitle.Message"));
		        	}
        		}
	        	
        	} else {
        		if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.Join.Enable")) {
		        	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.Join.Title.Enable")) {
		        		TitleUtils.sendTitle(p, ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.Title.FadeIn"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.Title.Stay"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.Title.FadeOut"), ConfigGlobal.getConfig().getString("On-Join.Spawn.Title.Join.Title.Message"));
		        	}
		        	if (ConfigGlobal.getConfig().getBoolean("On-Join.Spawn.Title.Join.SubTitle.Enable")) {
		        		TitleUtils.sendSubtitle(p, ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.SubTitle.FadeIn"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.SubTitle.Stay"), ConfigGlobal.getConfig().getInt("On-Join.Spawn.Title.Join.SubTitle.FadeOut"), ConfigGlobal.getConfig().getString("On-Join.Spawn.Title.Join.SubTitle.Message"));
		        	}
        		}
        	}
        	
        }
    }

}
