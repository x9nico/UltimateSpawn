package fr.Dianox.US.MainClass.event;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.FireworkMeta;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.ActionBar;
import fr.Dianox.US.MainClass.Utils.OtherUtils;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.SpawnUtils;
import fr.Dianox.US.MainClass.Utils.TitleUtils;
import fr.Dianox.US.MainClass.Utils.WorldUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigPlayerOptions;
import fr.Dianox.US.MainClass.config.ConfigPlayerStats;
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.global.ConfigGActionBar;
import fr.Dianox.US.MainClass.config.global.ConfigGCos;
import fr.Dianox.US.MainClass.config.global.ConfigGDoubleJump;
import fr.Dianox.US.MainClass.config.global.ConfigGFly;
import fr.Dianox.US.MainClass.config.global.ConfigGGM;
import fr.Dianox.US.MainClass.config.global.ConfigGHF;
import fr.Dianox.US.MainClass.config.global.ConfigGInventory;
import fr.Dianox.US.MainClass.config.global.ConfigGJoinCommand;
import fr.Dianox.US.MainClass.config.global.ConfigGMessage;
import fr.Dianox.US.MainClass.config.global.ConfigGSpawn;
import fr.Dianox.US.MainClass.config.global.ConfigGTitle;
import fr.Dianox.US.MainClass.config.global.ConfigGXP;

public class OnJoin implements Listener {
	
    @SuppressWarnings("deprecation")
	@EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Player p = e.getPlayer();
        UUID pU = e.getPlayer().getUniqueId();
        PlayerInventory inv = p.getInventory();
        Location l = p.getLocation();

        int lines = ConfigGMessage.getConfig().getInt("Chat.Clear.Lines-To-Clear");

        // Options
        if (!ConfigPlayerOptions.getConfig().contains(String.valueOf(pU))) {
        	ConfigPlayerOptions.getConfig().set(pU+".Player", String.valueOf(p));
        	ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Enable", ConfigGFly.getConfig().getBoolean("Fly.Enable"));
        	ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetFlying", ConfigGFly.getConfig().getBoolean("Fly.Option.SetFlying"));
        	ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetAllowFlight", ConfigGFly.getConfig().getBoolean("Fly.Option.SetAllowFlight"));
        	ConfigPlayerOptions.getConfig().set(pU+".Options.DoubleJump", ConfigGFly.getConfig().getBoolean("Fly.Enable"));
        	
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
	        	ConfigPlayerStats.getConfig().set(pU+".IP", String.valueOf(e.getPlayer().getAddress()));
	        	if (!p.hasPlayedBefore()) {
	        		ConfigPlayerStats.getConfig().set(pU+".Date.First_Login", String.valueOf(OtherUtils.getDate()+" || "+OtherUtils.getHours()+" "+ConfigMessage.getConfig().getString("Others.Hours")+", "+OtherUtils.getMinutes()+" "+ConfigMessage.getConfig().getString("Others.Minutes")+", "+OtherUtils.getSeconds()+" "+ConfigMessage.getConfig().getString("Others.Seconds")));
	        	}
	        	ConfigPlayerStats.getConfig().set(pU+".Date.Last_login", String.valueOf(OtherUtils.getDate()+" || "+OtherUtils.getHours()+" "+ConfigMessage.getConfig().getString("Others.Hours")+", "+OtherUtils.getMinutes()+" "+ConfigMessage.getConfig().getString("Others.Minutes")+", "+OtherUtils.getSeconds()+" "+ConfigMessage.getConfig().getString("Others.Seconds")));
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
	        		ConfigPlayerStats.getConfig().set(pU+".IP", String.valueOf(e.getPlayer().getAddress()));
	        		ConfigPlayerStats.getConfig().set(pU+".Date.Last_login", String.valueOf(OtherUtils.getDate()+" || "+OtherUtils.getHours()+" "+ConfigMessage.getConfig().getString("Others.Hours")+", "+OtherUtils.getMinutes()+" "+ConfigMessage.getConfig().getString("Others.Minutes")+", "+OtherUtils.getSeconds()+" "+ConfigMessage.getConfig().getString("Others.Seconds")));
	        		
	        		ConfigPlayerStats.saveConfigFile();
	        	}
	        }
    	}
        
        // Force selected slot
        if (ConfigGInventory.getConfig().getBoolean("Inventory.Force-Selected-Slot.Enable")) {
        	if (!ConfigGInventory.getConfig().getBoolean("Inventory.Force-Selected-Slot.World.All_World")) {
        		if (WorldUtils.getWOForceSelectedSlot().contains(p.getWorld().getName())) {
        			inv.setHeldItemSlot(ConfigGInventory.getConfig().getInt("Inventory.Force-Selected-Slot.Slot") - 1);
        		}
        	} else {
        		inv.setHeldItemSlot(ConfigGInventory.getConfig().getInt("Inventory.Force-Selected-Slot.Slot") - 1);
        	}
        }
        
        // Inventory
        if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Enable")) {
        	if (!ConfigGInventory.getConfig().getBoolean("Inventory.Clear.World.All_World")) {
        		if (WorldUtils.getWInventory().contains(p.getWorld().getName())) {
        	        if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Bypass")) {
        	            if (!p.hasPermission("UltimateSpawn.bypass.ClearInvOnJoin")) {
        	            	if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Options.Inventory")) {
        	            		inv.clear();
        	            	}
        	                if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Options.Armor")) {
        	                    inv.setArmorContents(new ItemStack[4]);
        	                }
        	            }
        	        } else {
        	        	if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Options.Inventory")) {
        	        		inv.clear();
        	        	}
        	            if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Options.Armor")) {
        	                inv.setArmorContents(new ItemStack[4]);
        	            }
        	        }
        		}
        	} else {
                if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Bypass")) {
                    if (!p.hasPermission("UltimateSpawn.bypass.ClearInvOnJoin")) {
                    	if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Options.Inventory")) {
                    		inv.clear();
                    	}
                        if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Options.Armor")) {
                            inv.setArmorContents(new ItemStack[4]);
                        }
                    }
                } else {
                	if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Options.Inventory")) {
                		inv.clear();
                	}
                    if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Options.Armor")) {
                        inv.setArmorContents(new ItemStack[4]);
                    }
                }
        	}
        }

        // Chat
        if (ConfigGMessage.getConfig().getBoolean("Chat.Clear.Enable")) {
        	if (!ConfigGMessage.getConfig().getBoolean("Chat.Clear.World.All_World")) {
        		if (WorldUtils.getWClearChat().contains(p.getWorld().getName())) {
		            if (ConfigGMessage.getConfig().getBoolean("Chat.Clear.Bypass")) {
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
        	} else {
        		if (ConfigGMessage.getConfig().getBoolean("Chat.Clear.Bypass")) {
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
        }

        // Teleport spawn || broadcast new
        if (p.hasPlayedBefore()) {
            if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.Enable")) {
            	if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.Use_Permission")) {
	            	if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.If_stats_is_enable.Use_stats_Of_UltimateSpawn.To_teleport_players.To_their_last_location")) {
	            		if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.If_stats_is_enable.Use_stats_Of_UltimateSpawn.To_teleport_players.Use_Permission")) {
	            			if (p.hasPermission("ultimatespawn.spawn.teleport.lastlocation")) {
	            				SpawnUtils.teleportToSpawnStats(p);
	            			} else {
	            				if (p.hasPermission("ultimatespawn.spawn.teleport.spawn")) {
	    	            			SpawnUtils.teleportToSpawn(p);
	    	            		}
	            			}
	            		} else {
	            			SpawnUtils.teleportToSpawnStats(p);
	            		}
	            	} else {
	            		if (p.hasPermission("ultimatespawn.spawn.teleport.spawn")) {
	            			SpawnUtils.teleportToSpawn(p);
	            		}
	            	}
	            } else {
	            	if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.If_stats_is_enable.Use_stats_Of_UltimateSpawn.To_teleport_players.To_their_last_location")) {
	            		if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.If_stats_is_enable.Use_stats_Of_UltimateSpawn.To_teleport_players.Use_Permission")) {
	            			if (p.hasPermission("ultimatespawn.spawn.teleport.lastlocation")) {
	            				SpawnUtils.teleportToSpawnStats(p);
	            			} else {
	            				SpawnUtils.teleportToSpawn(p);
	            			}
	            		} else {
	            			SpawnUtils.teleportToSpawnStats(p);
	            		}
	            	} else {
	            		SpawnUtils.teleportToSpawn(p);
	            	}
	            }
            }
        } else {
            if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.On-First-Join.Enable")) {
            	if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.On-First-Join.Custom-Spawn")) {
        			SpawnUtils.teleportToFirstSpawn(p);
        		} else {
        			SpawnUtils.teleportToSpawn(p);
        		}
            }
            if (ConfigGMessage.getConfig().getBoolean("Broadcast.First-Join.Enable")) {
            	if (!ConfigGMessage.getConfig().getBoolean("Broadcast.First-Join.World.All_World")) {
            		if (WorldUtils.getWNewBroadcastMsgJoin().contains(p.getWorld().getName())) {
		                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.First-Join.Message")) {
		                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
		                }
            		}
            	} else {
            		for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.First-Join.Message")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
                    }
            	}
            }
            if (ConfigGMessage.getConfig().getBoolean("Message.First-Join.Enable")) {
            	if (!ConfigGMessage.getConfig().getBoolean("Message.First-Join.World.All_World")) {
            		if (WorldUtils.getWNewMsgJoin().contains(p.getWorld().getName())) {
    		            for (String message: ConfigGMessage.getConfig().getStringList("Message.First-Join.Message")) {
    		            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
    		            }
            		}
            	} else {
            		for (String message: ConfigGMessage.getConfig().getStringList("Message.First-Join.Message")) {
    	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
    	            }
            	}
            }
        }

        // Gamemode
        int gm = ConfigGlobal.getConfig().getInt("On-Join.Spawn.Gamemode.Gamemode");
        
        if (ConfigGGM.getConfig().getBoolean("Gamemode.Value")) {
        	if (!ConfigGGM.getConfig().getBoolean("Gamemode.World.All_World")) {
        		if (WorldUtils.getWGM().contains(p.getWorld().getName())) {
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
        	} else {
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
        }

        // Fly
        if ((ConfigGFly.getConfig().getBoolean("Fly.Enable")) && (gm != 3)) {
        	if (!ConfigGFly.getConfig().getBoolean("Fly.World.All_World")) {
	       		if (WorldUtils.getWFly().contains(p.getWorld().getName())) {
	       			if (ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
		       			if (ConfigGFly.getConfig().getBoolean("Fly.Option.SetAllowFlight")) {
		       				p.setAllowFlight(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Options.SetAllowFlight"));
		       			}
		       			if (ConfigGFly.getConfig().getBoolean("Fly.Option.SetFlying")) {
		       				p.setFlying(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Options.setFlying"));
		       			}
	       			}
	       		}
        	} else {
        		if (ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
	        		if (ConfigGFly.getConfig().getBoolean("Fly.Option.SetAllowFlight")) {
	        			p.setAllowFlight(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Options.SetAllowFlight"));
	       			}
	       			if (ConfigGFly.getConfig().getBoolean("Fly.Option.SetFlying")) {
	       				p.setFlying(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Options.setFlying"));
	       			}
        		}
        	}
        }
        
        // DoubleJump
        if ((ConfigGDoubleJump.getConfig().getBoolean("DoubleJump.Enable")) && (gm != 3)) {
        	if (!ConfigGDoubleJump.getConfig().getBoolean("DoubleJump.World.All_World")) {
	       		if (WorldUtils.getWOptionDoubleJumpJoin().contains(p.getWorld().getName())) {
	       			ConfigPlayerOptions.getConfig().get(pU+".Options.DoubleJump", Boolean.valueOf(true));
	       		}
        	} else {
        		ConfigPlayerOptions.getConfig().get(pU+".Options.DoubleJump", Boolean.valueOf(true));
        	}
        } else {
        	ConfigPlayerOptions.getConfig().get(pU+".Options.DoubleJump", Boolean.valueOf(false));
        }

        // Reset XP
        String XPValueEXP = String.valueOf(ConfigGXP.getConfig().getDouble("XP.Options.Exp.Value"));
        String XPValueLvl = String.valueOf(ConfigGXP.getConfig().getInt("XP.Options.Level.Value"));
        
        if (ConfigGXP.getConfig().getBoolean("XP.Enable")) {
        	if (ConfigGXP.getConfig().getBoolean("XP.Options.Exp.Enable")) {
        		if (!ConfigGXP.getConfig().getBoolean("XP.Options.Exp.World.All_World")) {
	        		if (WorldUtils.getWXPEXP().contains(p.getWorld().getName())) {
	        			p.setExp(Float.valueOf(XPValueEXP));
	        		}
        		} else {
        			p.setExp(Float.valueOf(XPValueEXP));
        		}
        	}
        	if (ConfigGXP.getConfig().getBoolean("XP.Options.Level.Enable")) {
        		if (!ConfigGXP.getConfig().getBoolean("XP.Options.Level.World.All_World")) {
	        		if (WorldUtils.getWXPLVL().contains(p.getWorld().getName())) {
	        			p.setLevel(Integer.valueOf(XPValueLvl));
	        		}
        		} else {
        			p.setLevel(Integer.valueOf(XPValueLvl));
        		}
        	}
        }
        
        // Restore Health and food
        String FoodValue = String.valueOf(ConfigGHF.getConfig().getInt("Restore.Food.Value"));
        String HealthValue = String.valueOf(ConfigGHF.getConfig().getDouble("Restore.Health.Value"));
        
        if (ConfigGHF.getConfig().getBoolean("Restore.Food.Enable")) {
        	if (!ConfigGHF.getConfig().getBoolean("Restore.Food.World.All_World")) {
	       		if (WorldUtils.getWFood().contains(p.getWorld().getName())) {
	       			p.setFoodLevel(Integer.valueOf(FoodValue));
	       		}
        	} else {
        		p.setFoodLevel(Integer.valueOf(FoodValue));
        	}
        }
        
        if (ConfigGHF.getConfig().getBoolean("Restore.Health.Enable")) {
        	if (!ConfigGHF.getConfig().getBoolean("Restore.Health.World.All_World")) {
	       		if (WorldUtils.getWHealth().contains(p.getWorld().getName())) {
	       			p.setHealth(Double.valueOf(HealthValue));
	       		}
        	} else {
        		p.setHealth(Double.valueOf(HealthValue));
        	}
        }

        // Cosmetics
        
        Firework(p);
        
        // Sounds
        if (ConfigGCos.getConfig().getBoolean("Cosmetics.Sounds.Enable")) {
        	if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Sounds.World.All_World")) {
        		if (WorldUtils.getWSoundsJoin().contains(p.getWorld().getName())) {
		            String sound = ConfigGCos.getConfig().getString("Cosmetics.Sounds.Sound");
		            int volume = ConfigGCos.getConfig().getInt("Cosmetics.Sounds.Volume");
		            int pitch = ConfigGCos.getConfig().getInt("Cosmetics.Sounds.Pitch");
		            p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
        		}
        	} else {
	            String sound = ConfigGCos.getConfig().getString("Cosmetics.Sounds.Sound");
	            int volume = ConfigGCos.getConfig().getInt("Cosmetics.Sounds.Volume");
	            int pitch = ConfigGCos.getConfig().getInt("Cosmetics.Sounds.Pitch");
	            p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
        	}
        }

        // Broadcast Join Player
        if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Enable")) {
        	if (!ConfigGMessage.getConfig().getBoolean("Broadcast.Join.World.All_World")) {
        		if (WorldUtils.getWBroadcastMsgJoin().contains(p.getWorld().getName())) {
        			if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Silent_Staff_Join")) {
            			if (!p.hasPermission("UltimateSpawn.SilentStaffJoin")) {
    		        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide_New_Players")) {
    			        		if (p.hasPlayedBefore()) {
    					            if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
    					                e.setJoinMessage(null);
    					            } else {
    					                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
    					                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(message, Bukkit.getServer());
    					                }
    					                e.setJoinMessage(null);
    					            }
    			        		}
    			        	} else {
    			        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
    				                e.setJoinMessage(null);
    				            } else {
    				                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
    				                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(message, Bukkit.getServer());
    				                }
    				                e.setJoinMessage(null);
    				            }
    			        	}
            			} else {
            				e.setJoinMessage(null);
            			}
            		} else {
            			if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide_New_Players")) {
    		        		if (p.hasPlayedBefore()) {
    				            if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
    				                e.setJoinMessage(null);
    				            } else {
    				                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
    				                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(message, Bukkit.getServer());
    				                }
    				                e.setJoinMessage(null);
    				            }
    		        		}
    		        	} else {
    		        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
    			                e.setJoinMessage(null);
    			            } else {
    			                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
    			                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(message, Bukkit.getServer());
    			                }
    			                e.setJoinMessage(null);
    			            }
    		        	}
            		}
        		}
        	} else {
        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Silent_Staff_Join")) {
        			if (!p.hasPermission("UltimateSpawn.SilentStaffJoin")) {
		        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide_New_Players")) {
			        		if (p.hasPlayedBefore()) {
					            if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
					                e.setJoinMessage(null);
					            } else {
					                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
					                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(message, Bukkit.getServer());
					                }
					                e.setJoinMessage(null);
					            }
			        		}
			        	} else {
			        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
				                e.setJoinMessage(null);
				            } else {
				                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
				                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(message, Bukkit.getServer());
				                }
				                e.setJoinMessage(null);
				            }
			        	}
        			} else {
        				e.setJoinMessage(null);
        			}
        		} else {
        			if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide_New_Players")) {
		        		if (p.hasPlayedBefore()) {
				            if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
				                e.setJoinMessage(null);
				            } else {
				                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
				                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(message, Bukkit.getServer());
				                }
				                e.setJoinMessage(null);
				            }
		        		}
		        	} else {
		        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
			                e.setJoinMessage(null);
			            } else {
			                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
			                	PlaceHolderMessageUtils.ReplaceCharBroadcastPlayer(message, Bukkit.getServer());
			                }
			                e.setJoinMessage(null);
			            }
		        	}
        		}
        	}
        }

        // Message join
        if (ConfigGMessage.getConfig().getBoolean("Message.Join.Enable")) {
        	if (!ConfigGMessage.getConfig().getBoolean("Message.Join.World.All_World")) {
        		if (WorldUtils.getWMsgJoin().contains(p.getWorld().getName())) {
		            for (String message: ConfigGMessage.getConfig().getStringList("Message.Join.Message")) {
		            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
		            }
        		}
        	} else {
        		for (String message: ConfigGMessage.getConfig().getStringList("Message.Join.Message")) {
	            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
	            }
        	}
        }
        
        // TitleJoin
        if (ConfigGTitle.getConfig().getBoolean("Title.Enable")) {
        	if (ConfigGTitle.getConfig().getBoolean("Title.First-Join.Enable")) {
        		if (!ConfigGTitle.getConfig().getBoolean("Title.First-Join.World.All_World")) {
        			if (WorldUtils.getWFirstJoinTitle().contains(p.getWorld().getName())) {
		        		if (p.hasPlayedBefore()) {
		            		if (ConfigGTitle.getConfig().getBoolean("Title.Join.Enable")) {
		            			if (!ConfigGTitle.getConfig().getBoolean("Title.Join.World.All_World")) {
		            				if (WorldUtils.getWJoinTitle().contains(p.getWorld().getName())) {
		    				        	if (ConfigGTitle.getConfig().getBoolean("Title.Join.Title.Enable")) {
		    				        		TitleUtils.sendTitle(p, ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.Title.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.Title.Message"));
		    				        	}
		    				        	if (ConfigGTitle.getConfig().getBoolean("Title.Join.SubTitle.Enable")) {
		    				        		TitleUtils.sendSubtitle(p, ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.SubTitle.Message"));
		    				        	}
		            				}
		            			} else {
		            				if (ConfigGTitle.getConfig().getBoolean("Title.Join.Title.Enable")) {
		    			        		TitleUtils.sendTitle(p, ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.Title.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.Title.Message"));
		    			        	}
		    			        	if (ConfigGTitle.getConfig().getBoolean("Title.Join.SubTitle.Enable")) {
		    			        		TitleUtils.sendSubtitle(p, ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.SubTitle.Message"));
		    			        	}
		            			}
		            		}
		        		} else {
		        			if (ConfigGTitle.getConfig().getBoolean("Title.First-Join.Title.Enable")) {
				        		TitleUtils.sendTitle(p, ConfigGTitle.getConfig().getInt("Title.First-Join.Title.FadeIn"), ConfigGTitle.getConfig().getInt("Title.First-Join.Title.Stay"), ConfigGTitle.getConfig().getInt("Title.First-Join.Title.FadeOut"), ConfigGTitle.getConfig().getString("Title.First-Join.Title.Message"));
				        	}
				        	if (ConfigGTitle.getConfig().getBoolean("Title.First-Join.SubTitle.Enable")) {
				        		TitleUtils.sendSubtitle(p, ConfigGTitle.getConfig().getInt("Title.First-Join.SubTitle.FadeIn"), ConfigGTitle.getConfig().getInt("Title.First-Join.SubTitle.Stay"), ConfigGTitle.getConfig().getInt("Title.First-Join.SubTitle.FadeOut"), ConfigGTitle.getConfig().getString("Title.First-Join.SubTitle.Message"));
				        	}
		        		}
        			}
        		} else {
        			if (p.hasPlayedBefore()) {
	            		if (ConfigGTitle.getConfig().getBoolean("Title.Join.Enable")) {
	            			if (!ConfigGTitle.getConfig().getBoolean("Title.Join.World.All_World")) {
	            				if (WorldUtils.getWJoinTitle().contains(p.getWorld().getName())) {
	    				        	if (ConfigGTitle.getConfig().getBoolean("Title.Join.Title.Enable")) {
	    				        		TitleUtils.sendTitle(p, ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.Title.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.Title.Message"));
	    				        	}
	    				        	if (ConfigGTitle.getConfig().getBoolean("Title.Join.SubTitle.Enable")) {
	    				        		TitleUtils.sendSubtitle(p, ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.SubTitle.Message"));
	    				        	}
	            				}
	            			} else {
	            				if (ConfigGTitle.getConfig().getBoolean("Title.Join.Title.Enable")) {
	    			        		TitleUtils.sendTitle(p, ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.Title.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.Title.Message"));
	    			        	}
	    			        	if (ConfigGTitle.getConfig().getBoolean("Title.Join.SubTitle.Enable")) {
	    			        		TitleUtils.sendSubtitle(p, ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.SubTitle.Message"));
	    			        	}
	            			}
	            		}
	        		} else {
	        			if (ConfigGTitle.getConfig().getBoolean("Title.First-Join.Title.Enable")) {
			        		TitleUtils.sendTitle(p, ConfigGTitle.getConfig().getInt("Title.First-Join.Title.FadeIn"), ConfigGTitle.getConfig().getInt("Title.First-Join.Title.Stay"), ConfigGTitle.getConfig().getInt("Title.First-Join.Title.FadeOut"), ConfigGTitle.getConfig().getString("Title.First-Join.Title.Message"));
			        	}
			        	if (ConfigGTitle.getConfig().getBoolean("Title.First-Join.SubTitle.Enable")) {
			        		TitleUtils.sendSubtitle(p, ConfigGTitle.getConfig().getInt("Title.First-Join.SubTitle.FadeIn"), ConfigGTitle.getConfig().getInt("Title.First-Join.SubTitle.Stay"), ConfigGTitle.getConfig().getInt("Title.First-Join.SubTitle.FadeOut"), ConfigGTitle.getConfig().getString("Title.First-Join.SubTitle.Message"));
			        	}
	        		}
        		}
        	} else {
        		if (ConfigGTitle.getConfig().getBoolean("Title.Join.Enable")) {
        			if (!ConfigGTitle.getConfig().getBoolean("Title.Join.World.All_World")) {
        				if (WorldUtils.getWJoinTitle().contains(p.getWorld().getName())) {
				        	if (ConfigGTitle.getConfig().getBoolean("Title.Join.Title.Enable")) {
				        		TitleUtils.sendTitle(p, ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.Title.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.Title.Message"));
				        	}
				        	if (ConfigGTitle.getConfig().getBoolean("Title.Join.SubTitle.Enable")) {
				        		TitleUtils.sendSubtitle(p, ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.SubTitle.Message"));
				        	}
        				}
        			} else {
        				if (ConfigGTitle.getConfig().getBoolean("Title.Join.Title.Enable")) {
			        		TitleUtils.sendTitle(p, ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.Title.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.Title.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.Title.Message"));
			        	}
			        	if (ConfigGTitle.getConfig().getBoolean("Title.Join.SubTitle.Enable")) {
			        		TitleUtils.sendSubtitle(p, ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeIn"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.Stay"), ConfigGTitle.getConfig().getInt("Title.Join.SubTitle.FadeOut"), ConfigGTitle.getConfig().getString("Title.Join.SubTitle.Message"));
			        	}
        			}
        		}
        	}
        }
    
        // Action Bar
        if (ConfigGActionBar.getConfig().getBoolean("ActionBar.Enable")) {
        	if (!ConfigGActionBar.getConfig().getBoolean("ActionBar.World.All_World")) {
        		if (WorldUtils.getWABOJ().contains(p.getWorld().getName())) {
	        		if (p.hasPlayedBefore()) {
	        			if (ConfigGActionBar.getConfig().getBoolean("ActionBar.Options.No-New.Enable")) {
	        				ActionBar.sendActionBar(p, ConfigGActionBar.getConfig().getString("ActionBar.Options.No-New.Message"), ConfigGActionBar.getConfig().getInt("ActionBar.Options.No-New.Duration"));
	        			}
	        		} else {
	        			if (ConfigGActionBar.getConfig().getBoolean("ActionBar.Options.New.Enable")) {
	        				ActionBar.sendActionBar(p, ConfigGActionBar.getConfig().getString("ActionBar.Options.New.Message"), ConfigGActionBar.getConfig().getInt("ActionBar.Options.New.Duration"));
	        			} else {
	        				if (ConfigGActionBar.getConfig().getBoolean("ActionBar.Options.No-New.Enable")) {
	        					ActionBar.sendActionBar(p, ConfigGActionBar.getConfig().getString("ActionBar.Options.No-New.Message"), ConfigGActionBar.getConfig().getInt("ActionBar.Options.No-New.Duration"));
	        				}
	        			}
	        		}
        		}
        	} else {
        		if (p.hasPlayedBefore()) {
        			if (ConfigGActionBar.getConfig().getBoolean("ActionBar.Options.No-New.Enable")) {
        				ActionBar.sendActionBar(p, ConfigGActionBar.getConfig().getString("ActionBar.Options.No-New.Message"), ConfigGActionBar.getConfig().getInt("ActionBar.Options.No-New.Duration"));
        			}
        		} else {
        			if (ConfigGActionBar.getConfig().getBoolean("ActionBar.Options.New.Enable")) {
        				ActionBar.sendActionBar(p, ConfigGActionBar.getConfig().getString("ActionBar.Options.New.Message"), ConfigGActionBar.getConfig().getInt("ActionBar.Options.New.Duration"));
        			} else {
        				if (ConfigGActionBar.getConfig().getBoolean("ActionBar.Options.No-New.Enable")) {
        					ActionBar.sendActionBar(p, ConfigGActionBar.getConfig().getString("ActionBar.Options.No-New.Message"), ConfigGActionBar.getConfig().getInt("ActionBar.Options.No-New.Duration"));
        				}
        			}
        		}
        	}
        }
        
        // Join Command
        if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Enable")) {
        	if (p.hasPlayedBefore()) {
        		 if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Player.Enable")) {
        			 if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Player.World.All_World")) {
        				 if(WorldUtils.getWPlayerJoinCommandNoNew().contains(p.getWorld().getName())) {
		        			 for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Player.Commands")) {
		        				 p.performCommand(commands);
		        			 }
        				 }
        			 } else {
        				 for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Player.Commands")) {
	        				 p.performCommand(commands);
	        			 }
        			 }
        		 }
        		 if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Console.Enable")) {
        			 if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Console.World.All_World")) {
        				 if(WorldUtils.getWConsoleJoinCommandNoNew().contains(p.getWorld().getName())) {
		        			 for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Console.Commands")) {
		        				 Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), commands.replaceAll("%player%", p.getName()));
		        			 }
        				 }
        			 } else {
        				 for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Console.Commands")) {
        					 Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), commands.replaceAll("%player%", p.getName()));
	        			 }
        			 }
        		 }
        	} else {
        		if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.New.JoinCommand-Player.Enable")) {
        			if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.New.JoinCommand-Player.World.All_World")) {
        				if(WorldUtils.getWPlayerJoinCommandNew().contains(p.getWorld().getName())) {
        					for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.New.JoinCommand-Player.Commands")) {
        						p.performCommand(commands);
        					}
        				}
        			} else {
        				for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.New.JoinCommand-Player.Commands")) {
        					p.performCommand(commands);
        				}
        			}
        		} else {
        			if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Player.Enable")) {
        				if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Player.World.All_World")) {
        					if(WorldUtils.getWPlayerJoinCommandNoNew().contains(p.getWorld().getName())) {
        						for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Player.Commands")) {
        							p.performCommand(commands);
        						}
        					}
        				} else {
        					for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Player.Commands")) {
        						p.performCommand(commands);
        					}
        				}
        			}
        		}
        		if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.New.JoinCommand-Console.Enable")) {
        			if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.New.JoinCommand-Console.World.All_World")) {
        				if(WorldUtils.getWConsoleJoinCommandNew().contains(p.getWorld().getName())) {
        					for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.New.JoinCommand-Console.Commands")) {
        						Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), commands.replaceAll("%player%", p.getName()));
        					}
        				}
        			} else {
        				for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.New.JoinCommand-Console.Commands")) {
        					Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), commands.replaceAll("%player%", p.getName()));
        				}
        			}
        		} else {
        			if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Console.Enable")) {
            			if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Console.World.All_World")) {
            				if(WorldUtils.getWConsoleJoinCommandNoNew().contains(p.getWorld().getName())) {
            					for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Console.Commands")) {
            						Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), commands.replaceAll("%player%", p.getName()));
            					}
            				}
            			} else {
            				for (String commands: ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Console.Commands")) {
            					Bukkit.dispatchCommand(Bukkit.getServer().getConsoleSender(), commands.replaceAll("%player%", p.getName()));
            				}
            			}
            		}
        		}
        	}
        }
        
        // Temporary
        int GamemodeTemp1 = 0;
        if (p.getGameMode() == GameMode.SURVIVAL) {
        	GamemodeTemp1 = 0;
        } else if (p.getGameMode() == GameMode.CREATIVE) {
        	GamemodeTemp1 = 1;
        } else if (p.getGameMode() == GameMode.ADVENTURE) {
        	GamemodeTemp1 = 2;
        } else if (p.getGameMode() == GameMode.SPECTATOR) {
        	GamemodeTemp1 = 3;
        }
        int GamemodeTemp2 = Integer.valueOf(GamemodeTemp1);
        
        if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
        	ConfigTemp.getConfig().set(pU+".Player", String.valueOf(p));
        	ConfigTemp.getConfig().set(pU+".Options.Gamemode", Integer.valueOf(GamemodeTemp2));
        	ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Enable"));
       		ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Options.SetAllowFlight"));
       		ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Options.SetFlying"));
       		ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(0));
       		ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.DoubleJump"));
       		
        	ConfigTemp.saveConfigFile();
        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
        	ConfigTemp.getConfig().set(pU+".Player", String.valueOf(p));
        	ConfigTemp.getConfig().set(pU+".Options.Gamemode", Integer.valueOf(GamemodeTemp2));
        	ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Enable"));
       		ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Options.SetAllowFlight"));
       		ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Options.SetFlying"));
       		ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(0));
       		ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.DoubleJump"));
       		
        	ConfigTemp.saveConfigFile();
        }
        if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
	        if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
				 PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), p);
	          	
				 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
				 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
				 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
	 				
				 ConfigTemp.saveConfigFile();
	 	        	
				 p.setAllowFlight(false);
				 p.setFlying(false);
			}
        }
    }
    
    public void Firework(Player p) {
    	if (ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Enable")) {
        	if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.World.All_World")) {
        		if (WorldUtils.getWFirework().contains(p.getWorld().getName())) {
		        	for (int i = 1; i < ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Amount"); i++) {
		        		ArrayList<Color> colors = new ArrayList<Color>();
		        		ArrayList<Color> fade = new ArrayList<Color>();
		        		List<String> lore = ConfigGCos.getConfig().getStringList("Cosmetics.Firework.Options.Colors");
		        		List<String> lore2 = ConfigGCos.getConfig().getStringList("Cosmetics.Firework.Options.Fade");
		        		for (String l1 : lore) {
		        			colors.add(OtherUtils.getColor(l1));
		        	    }
		        		for (String l2 : lore2) {
		        			fade.add(OtherUtils.getColor(l2));
		        		}
		                final Firework f = p.getWorld().spawn(p.getLocation().add(0.5D, ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Height"), 0.5D), Firework.class);
		                
		                FireworkMeta fm = f.getFireworkMeta();
		                fm.addEffect(FireworkEffect.builder().flicker(ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Flicker"))
		                		.trail(ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Trail"))
		                		.with(FireworkEffect.Type.valueOf(ConfigGCos.getConfig().getString("Cosmetics.Firework.Options.Type"))).withColor(colors).withFade(fade)
		                		.build());
		                
		                if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Instant-explode")) {
		                	fm.setPower(ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Power"));
		                }
		                f.setFireworkMeta(fm);
		                if (ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Instant-explode")) { 
		                	Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable(){
		                      public void run() {
		                        f.detonate();
		                      }
		                    }, 5L);
		                }
		        	}
        		}
        	} else {
        		for (int i = 1; i < ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Amount"); i++) {
	        		ArrayList<Color> colors = new ArrayList<Color>();
	        		ArrayList<Color> fade = new ArrayList<Color>();
	        		List<String> lore = ConfigGCos.getConfig().getStringList("Cosmetics.Firework.Options.Colors");
	        		List<String> lore2 = ConfigGCos.getConfig().getStringList("Cosmetics.Firework.Options.Fade");
	        		for (String l1 : lore) {
	        			colors.add(OtherUtils.getColor(l1));
	        	    }
	        		for (String l2 : lore2) {
	        			fade.add(OtherUtils.getColor(l2));
	        		}
	                final Firework f = p.getWorld().spawn(p.getLocation().add(0.5D, ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Height"), 0.5D), Firework.class);
	                
	                FireworkMeta fm = f.getFireworkMeta();
	                fm.addEffect(FireworkEffect.builder().flicker(ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Flicker"))
	                		.trail(ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Trail"))
	                		.with(FireworkEffect.Type.valueOf(ConfigGCos.getConfig().getString("Cosmetics.Firework.Options.Type"))).withColor(colors).withFade(fade)
	                		.build());
	                
	                if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Instant-explode")) {
	                	fm.setPower(ConfigGCos.getConfig().getInt("Cosmetics.Firework.Options.Power"));
	                }
	                f.setFireworkMeta(fm);
	                if (ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Options.Instant-explode")) { 
	                	Bukkit.getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable(){
	                      public void run() {
	                        f.detonate();
	                      }
	                    }, 5L);
	                }
	        	}
        	}
        }
    }

}
