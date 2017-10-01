package fr.Dianox.US.MainClass.event;

import org.bukkit.Location;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.SpawnUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.event.ConfigEVoidTP;
import fr.Dianox.US.MainClass.config.global.ConfigGPlayerItems;
import fr.Dianox.US.MainClass.config.global.ConfigGProtection;
import fr.Dianox.US.MainClass.config.global.ConfigGServerEvent;

public class BasicFeatures implements Listener {

    //Disable Hunger
    @EventHandler
    public void foodChangeLevel(FoodLevelChangeEvent e) {
    	if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Hunger.Enable")) {
    		if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Hunger.World.All_World")) {
    			if (MainClass.getWH().contains(e.getEntity().getLocation().getWorld().getName())) {
			        if (e.getEntityType() == EntityType.PLAYER) {
			            Player p = (Player) e.getEntity();
			            	
			            e.setCancelled(true);
			                
			            if (p.getFoodLevel() < 19.0D) {
			            	p.setFoodLevel(20);
			            }
			        }
    			}
    		} else {
    			if (e.getEntityType() == EntityType.PLAYER) {
		            Player p = (Player) e.getEntity();
		            	
		            e.setCancelled(true);
		                
		            if (p.getFoodLevel() < 19.0D) {
		            	p.setFoodLevel(20);
		            }
		        }
    		}
    	}
    }

    //Disable Damage
    @EventHandler
    public void DisableDamage(EntityDamageEvent e) {
    	if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Damage.Enable")) {
    		if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Damage.World.All_World")) {
		    	if (MainClass.getWD().contains(e.getEntity().getLocation().getWorld().getName())) {
		    		if (ConfigGlobal.getConfig().getBoolean("Debug-in-case-of-problem.Disable.Damage-TO-EVERYTHING")) {
		    			e.setCancelled(true);
		    		} else {
		    			if (e.getEntity() instanceof Player) {
		    				e.setCancelled(true);
		    			}
		    		}
		    	}
    		} else {
	    		if (ConfigGlobal.getConfig().getBoolean("Debug-in-case-of-problem.Disable.Damage-TO-EVERYTHING")) {
	    			e.setCancelled(true);
	    		} else {
	    			if (e.getEntity() instanceof Player) {
	    				e.setCancelled(true);
	    			}
	    		}
    		}
    	}
    }

    //Disable Weather
    @EventHandler
    public void WeatherDisable(WeatherChangeEvent e) {
    	if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Weather.Enable")) {
    		if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Weather.World.All_World")) {
    			if (MainClass.getWW().contains(e.getWorld().getName())) {
    				e.setCancelled(true);
    			}
    		} else {
    			e.setCancelled(true);
    		}
        }
    }

    // Disable construct
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.Enable")) {
        	if (!ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.World.All_World")) {
        		if (MainClass.getWPCP().contains(p.getWorld().getName())) {
        			if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.Bypass")) {
        		        if (!p.hasPermission("UltimateSpawn.bypass.ConstructPlace")) {
        		            e.setCancelled(true);
        		            if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.Message")) {
        		                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Message.Place"), p);
        		            }
        		        }
        		    } else {
        		        e.setCancelled(true);
        		        if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.Message")) {
        		            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Message.Place"), p);
        		        }
        		    }
        		}
        	} else {
        		if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.Bypass")) {
        	        if (!p.hasPermission("UltimateSpawn.bypass.ConstructPlace")) {
        	            e.setCancelled(true);
        	            if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.Message")) {
        	                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Message.Place"), p);
        	            }
        	        }
        	    } else {
        	        e.setCancelled(true);
        	        if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.Message")) {
        	            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Message.Place"), p);
        	        }
        	    }
        	}
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.Enable")) {
        	if (!ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.World.All_World")) {
        		if (MainClass.getWPCB().contains(p.getWorld().getName())) {
        			if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.Bypass")) {
        		        if (!p.hasPermission("UltimateSpawn.bypass.ConstructBreak")) {
        		            e.setCancelled(true);
        		            if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.Message")) {
        		                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Message.Break"), p);
        		            }
        		        }
        		    } else {
        		        e.setCancelled(true);
        		        if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.Message")) {
        		            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Message.Break"), p);
        		        }
        		    }
        		}
        	} else {
        		if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.Bypass")) {
    		        if (!p.hasPermission("UltimateSpawn.bypass.ConstructBreak")) {
    		            e.setCancelled(true);
    		            if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.Message")) {
    		                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Message.Break"), p);
    		            }
    		        }
    		    } else {
    		        e.setCancelled(true);
    		        if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.Message")) {
    		            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Message.Break"), p);
    		        }
    		    }
        	}
        }
    }

    // Block Burn
    @EventHandler
    public void BlockBurn(BlockBurnEvent e) {
    	if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Burn-block.Enable")) {
    		if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Burn-block.World.All_World")) {
    			if (MainClass.getWBB().contains(e.getBlock().getWorld().getName())) {
    				e.setCancelled(true);
    			}
    		} else {
    			e.setCancelled(true);
    		}
        }
    }

    // Protect item for player
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();

    	if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Drop.Disable")) {
    		if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Drop.World.All_World")) {
    			if (MainClass.getWItemDrop().contains(p.getWorld().getName())) {
	    			if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Drop.Bypass")) {
	                    if (!p.hasPermission("UltimateSpawn.bypass.DropItem")) {
	                        e.setCancelled(true);
	                    }
	                } else {
	                    e.setCancelled(true);
	                }
    			}
    		} else {
    			if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Drop.Bypass")) {
                    if (!p.hasPermission("UltimateSpawn.bypass.DropItem")) {
                        e.setCancelled(true);
                    }
                } else {
                    e.setCancelled(true);
                }
    		}
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();
        
        if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.PickUp.Disable")) {
    		if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.PickUp.World.All_World")) {
    			if (MainClass.getWItemPickUp().contains(p.getWorld().getName())) {
	    			if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.PickUp.Bypass")) {
	                    if (!p.hasPermission("UltimateSpawn.bypass.PickUpItem")) {
	                        e.setCancelled(true);
	                    }
	                } else {
	                    e.setCancelled(true);
	                }
    			}
    		} else {
    			if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.PickUp.Bypass")) {
                    if (!p.hasPermission("UltimateSpawn.bypass.PickUpItem")) {
                        e.setCancelled(true);
                    }
                } else {
                    e.setCancelled(true);
                }
    		}
        }
    }

    @EventHandler
    public void onMove(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        
        if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Move.Disable")) {
    		if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Move.World.All_World")) {
    			if (MainClass.getWMoveItem().contains(p.getWorld().getName())) {
	    			if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Move.Bypass")) {
	                    if (!p.hasPermission("UltimateSpawn.bypass.MoveItem")) {
	                        e.setCancelled(true);
	                    }
	                } else {
	                    e.setCancelled(true);
	                }
    			}
    		} else {
    			if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Move.Bypass")) {
                    if (!p.hasPermission("UltimateSpawn.bypass.MoveItem")) {
                        e.setCancelled(true);
                    }
                } else {
                    e.setCancelled(true);
                }
    		}
        }
    }

    @EventHandler
    public void onDamageItem(PlayerItemDamageEvent e) {
        Player p = e.getPlayer();
        
        if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Damage-Item.Disable")) {
    		if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Damage-Item.World.All_World")) {
    			if (MainClass.getWItemDamage().contains(p.getWorld().getName())) {
	    			if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Damage-Item.Bypass")) {
	                    if (!p.hasPermission("UltimateSpawn.bypass.DamageItem")) {
	                        e.setCancelled(true);
	                    }
	                } else {
	                    e.setCancelled(true);
	                }
    			}
    		} else {
    			if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Damage-Item.Bypass")) {
                    if (!p.hasPermission("UltimateSpawn.bypass.DamageItem")) {
                        e.setCancelled(true);
                    }
                } else {
                    e.setCancelled(true);
                }
    		}
        }
    }

    // Explosion
    @EventHandler
    public void onExplode(ExplosionPrimeEvent e) {
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Explosion.Enable")) {
        	if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Explosion.World.All_World")) {
        		if (MainClass.getWE().contains(e.getEntity().getWorld().getName())) {
        			e.setCancelled(true);
        		}
        	} else {
        		e.setCancelled(true);
        	}
        }
    }

    // Death event
    @EventHandler
    public void onDeathEvent(PlayerDeathEvent e) {
        Player p = e.getEntity();
        
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Death-Message.Enable")) {
        	if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Death-Message.World.All_World")) {
        		if (MainClass.getWDM().contains(e.getEntity().getWorld().getName())) {
        			e.setDeathMessage(null);
        		}
        	} else {
        		e.setDeathMessage(null);
        	}
        }

        if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.Enable")) {
        	if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.World.All_World")) {
        		if (MainClass.getWClearOnDropsOnDeath().contains(e.getEntity().getWorld().getName())) {
        			if (ConfigGlobal.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.Bypass")) {
                        if (!p.hasPermission("UltimateSpawn.bypass.ClearDropOnDeath")) {
                            if ((e.getEntity() instanceof Player)) {
                                e.getDrops().clear();
                                forceDelete(e);
                            }
                        }
                    } else {
                        if ((e.getEntity() instanceof Player)) {
                            e.getDrops().clear();
                            forceDelete(e);
                        }
                    }
        		}
        	} else {
        		if (ConfigGlobal.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.Bypass")) {
                    if (!p.hasPermission("UltimateSpawn.bypass.ClearDropOnDeath")) {
                        if ((e.getEntity() instanceof Player)) {
                            e.getDrops().clear();
                            forceDelete(e);
                        }
                    }
                } else {
                    if ((e.getEntity() instanceof Player)) {
                        e.getDrops().clear();
                        forceDelete(e);
                    }
                }
        	}
        }
    }

    public void forceDelete(EntityDeathEvent e) {
        for (int i = 0; i < e.getDrops().size(); i++) e.getDrops().remove(i);
    }

    // Disable Spawning
    @EventHandler
    public void onSpawning(CreatureSpawnEvent e) {
        if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.Enable")) {
        	if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.World.All_World")) {
        		if (MainClass.getWSMA().contains(e.getEntity().getWorld().getName())) {
        			e.setCancelled(true);
        		}
        	} else {
        		e.setCancelled(true);
        	}
        }
    }
    
    // VoidTP
    @EventHandler
    public void onVoidTP(PlayerMoveEvent e) {
    	Player p = e.getPlayer();
    	Location loc = p.getLocation();
    	Integer getYConfig = Integer.valueOf(ConfigEVoidTP.getConfig().getInt("VoidTP.Options.TP-y"));
    	
        if (ConfigEVoidTP.getConfig().getBoolean("VoidTP.Enable")) {
        	if (!ConfigEVoidTP.getConfig().getBoolean("VoidTP.World.All_World")) {
        		if (MainClass.getWVoidTP().contains(p.getWorld().getName())) {
        			if(loc.getY() <= getYConfig) {
        				SpawnUtils.teleportToVoidTP(p);
        				if (ConfigEVoidTP.getConfig().getBoolean("VoidTP.Options.Message.Custom")) {
        					if (!ConfigEVoidTP.getConfig().getBoolean("VoidTP.Options.Message.Disable")) {
        						PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.VoidTP"), p);
        					}
        				} else {
        					if (!ConfigEVoidTP.getConfig().getBoolean("VoidTP.Options.Message.Disable")) {
        						PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Teleport.To-spawn"), p);
        					}
        				}
        			}
        		}
        	} else {
        		if(loc.getY() <= getYConfig) {
    				SpawnUtils.teleportToVoidTP(p);
    				if (ConfigEVoidTP.getConfig().getBoolean("VoidTP.Options.Message.Custom")) {
    					if (!ConfigEVoidTP.getConfig().getBoolean("VoidTP.Options.Message.Disable")) {
    						PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.VoidTP"), p);
    					}
    				} else {
    					if (!ConfigEVoidTP.getConfig().getBoolean("VoidTP.Options.Message.Disable")) {
    						PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Teleport.To-spawn"), p);
    					}
    				}
    			}
        	}
        }
    }

}
