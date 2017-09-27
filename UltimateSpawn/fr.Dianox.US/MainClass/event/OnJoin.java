package fr.Dianox.US.MainClass.event;

import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.OtherUtils;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.SpawnUtils;
import fr.Dianox.US.MainClass.Utils.TitleUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigPlayerOptions;
import fr.Dianox.US.MainClass.config.ConfigPlayerStats;
import fr.Dianox.US.MainClass.config.global.ConfigGCos;
import fr.Dianox.US.MainClass.config.global.ConfigGFly;
import fr.Dianox.US.MainClass.config.global.ConfigGGM;
import fr.Dianox.US.MainClass.config.global.ConfigGHF;
import fr.Dianox.US.MainClass.config.global.ConfigGInventory;
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
	        	ConfigPlayerStats.getConfig().set(pU+".IP", String.valueOf(e.getPlayer().getAddress()));
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
        		if (MainClass.getWOForceSelectedSlot().contains(p.getWorld().getName())) {
        			inv.setHeldItemSlot(ConfigGInventory.getConfig().getInt("Inventory.Force-Selected-Slot.Slot") - 1);
        		}
        	} else {
        		inv.setHeldItemSlot(ConfigGInventory.getConfig().getInt("Inventory.Force-Selected-Slot.Slot") - 1);
        	}
        }
        
        // Inventory
        if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Enable")) {
        	if (!ConfigGInventory.getConfig().getBoolean("Inventory.Clear.World.All_World")) {
        		if (MainClass.getWInventory().contains(p.getWorld().getName())) {
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
        		if (MainClass.getWClearChat().contains(p.getWorld().getName())) {
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
            	if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.If_stats_is_enable.Use_stats_Of_UltimateSpawn.To_teleport_players.To_their_last_location")) {
            		SpawnUtils.teleportToSpawnStats(p);
            	} else {
            		SpawnUtils.teleportToSpawn(p);
            	}
            } else if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.If_stats_is_enable.If_Teleport_on_join_is_disable.Use_stats_Of_UltimateSpawn.To_teleport_players.To_their_last_location")) {
            	SpawnUtils.teleportToSpawnStats(p);
            }
        } else {
            if (ConfigGSpawn.getConfig().getBoolean("Spawn.Teleport.On-First-Join")) {
                SpawnUtils.teleportToSpawn(p);
            }
            if (ConfigGMessage.getConfig().getBoolean("Broadcast.First-Join.Enable")) {
            	if (!ConfigGMessage.getConfig().getBoolean("Broadcast.First-Join.World.All_World")) {
            		if (MainClass.getWNewBroadcastMsgJoin().contains(p.getWorld().getName())) {
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
            		if (MainClass.getWNewMsgJoin().contains(p.getWorld().getName())) {
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
        		if (MainClass.getWGM().contains(p.getWorld().getName())) {
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
	       		if (MainClass.getWFly().contains(p.getWorld().getName())) {
	       			if (ConfigGFly.getConfig().getBoolean("Fly.Option.SetAllowFlight")) {
	       				p.setAllowFlight(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly"));
	       			}
	       			if (ConfigGFly.getConfig().getBoolean("Fly.Option.SetFlying")) {
	       				p.setFlying(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly"));
	       			}
	       		}
        	} else {
        		if (ConfigGFly.getConfig().getBoolean("Fly.Option.SetAllowFlight")) {
       				p.setAllowFlight(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly"));
       			}
       			if (ConfigGFly.getConfig().getBoolean("Fly.Option.SetFlying")) {
       				p.setFlying(ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly"));
       			}
        	}
        }

        // Reset XP
        String XPValueEXP = String.valueOf(ConfigGXP.getConfig().getDouble("XP.Options.Exp.Value"));
        String XPValueLvl = String.valueOf(ConfigGXP.getConfig().getInt("XP.Options.Level.Value"));
        
        if (ConfigGXP.getConfig().getBoolean("XP.Enable")) {
        	if (ConfigGXP.getConfig().getBoolean("XP.Options.Exp.Enable")) {
        		if (!ConfigGXP.getConfig().getBoolean("XP.Options.Exp.World.All_World")) {
	        		if (MainClass.getWXPEXP().contains(p.getWorld().getName())) {
	        			p.setExp(Float.valueOf(XPValueEXP));
	        		}
        		} else {
        			p.setExp(Float.valueOf(XPValueEXP));
        		}
        	}
        	if (ConfigGXP.getConfig().getBoolean("XP.Options.Level.Enable")) {
        		if (!ConfigGXP.getConfig().getBoolean("XP.Options.Level.World.All_World")) {
	        		if (MainClass.getWXPLVL().contains(p.getWorld().getName())) {
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
	       		if (MainClass.getWFood().contains(p.getWorld().getName())) {
	       			p.setFoodLevel(Integer.valueOf(FoodValue));
	       		}
        	} else {
        		p.setFoodLevel(Integer.valueOf(FoodValue));
        	}
        }
        
        if (ConfigGHF.getConfig().getBoolean("Restore.Health.Enable")) {
        	if (!ConfigGHF.getConfig().getBoolean("Restore.Health.World.All_World")) {
	       		if (MainClass.getWHealth().contains(p.getWorld().getName())) {
	       			p.setHealth(Double.valueOf(HealthValue));
	       		}
        	} else {
        		p.setHealth(Double.valueOf(HealthValue));
        	}
        }

        // Cosmetics
        
        // Firework ==> MainClass //
        // Sounds
        if (ConfigGCos.getConfig().getBoolean("Cosmetics.Sounds.Enable")) {
        	if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Sounds.World.All_World")) {
        		if (MainClass.getWSoundsJoin().contains(p.getWorld().getName())) {
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
        		if (MainClass.getWBroadcastMsgJoin().contains(p.getWorld().getName())) {
		        	if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide_New_Players")) {
		        		if (p.hasPlayedBefore()) {
				            if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
				                e.setJoinMessage(null);
				            } else {
				                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
				                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
				                }
				                e.setJoinMessage(null);
				            }
		        		}
		        	} else {
		        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
			                e.setJoinMessage(null);
			            } else {
			                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
			                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
			                }
			                e.setJoinMessage(null);
			            }
		        	}
        		}
        	} else {
        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide_New_Players")) {
	        		if (p.hasPlayedBefore()) {
			            if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
			                e.setJoinMessage(null);
			            } else {
			                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
			                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
			                }
			                e.setJoinMessage(null);
			            }
	        		}
	        	} else {
	        		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Hide")) {
		                e.setJoinMessage(null);
		            } else {
		                for (String message: ConfigGMessage.getConfig().getStringList("Broadcast.Join.Message")) {
		                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(message, p);
		                }
		                e.setJoinMessage(null);
		            }
	        	}
        	}
        }

        // Message join
        if (ConfigGMessage.getConfig().getBoolean("Message.Join.Enable")) {
        	if (!ConfigGMessage.getConfig().getBoolean("Message.Join.World.All_World")) {
        		if (MainClass.getWMsgJoin().contains(p.getWorld().getName())) {
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
        			if (MainClass.getWFirstJoinTitle().contains(p.getWorld().getName())) {
		        		if (p.hasPlayedBefore()) {
		            		if (ConfigGTitle.getConfig().getBoolean("Title.Join.Enable")) {
		            			if (!ConfigGTitle.getConfig().getBoolean("Title.Join.World.All_World")) {
		            				if (MainClass.getWJoinTitle().contains(p.getWorld().getName())) {
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
	            				if (MainClass.getWJoinTitle().contains(p.getWorld().getName())) {
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
        				if (MainClass.getWJoinTitle().contains(p.getWorld().getName())) {
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
    }
}
