package fr.Dianox.US.MainClass.event;

import java.util.UUID;

import org.bukkit.Effect;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerToggleFlightEvent;
import org.bukkit.util.Vector;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.WorldUtils;
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.fun.ConfigFDoubleJump;
import fr.Dianox.US.MainClass.config.fun.ConfigFJumpad;
import fr.Dianox.US.MainClass.config.messages.ConfigMFly;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlayerOption;

public class FunFeatures implements Listener {
	
	// JumpPads
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerMoveEvent(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Enable")) {
			if (!ConfigFJumpad.getConfig().getBoolean("JumpPads.World.All_World")) {
				if (WorldUtils.getWJumpPads().contains(p.getWorld().getName())) {
					if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Use_Permission")) {
						if (p.hasPermission("ultimatespawn.fun.jumppads")) {
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
			} else {
				if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Use_Permission")) {
					if (p.hasPermission("ultimatespawn.fun.jumppads")) {
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
	
	// Double Jump
	@EventHandler
	public void onMoveDoubleJump(PlayerMoveEvent e) {
		Player p = e.getPlayer();
		UUID pU = e.getPlayer().getUniqueId();
		if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
        	if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
        		for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.DoubleJump-Fly")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
    			}
	          	
        		ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
        		ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
        		ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
        		
        		ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
        			 				
        		ConfigTemp.saveConfigFile();
        		
        		for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
    			}
        		
        		p.setFlying(false);
        		p.setAllowFlight(false);
        	}
        }
		if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
	        if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
	        	for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
    			}
	        	for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.DoubleJump-Fly")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
    			}
	          	
				 ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
				 ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
				 ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
				 
				 ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
	 				
				 ConfigTemp.saveConfigFile();
	 	        	
				 p.setFlying(false);
				 p.setAllowFlight(false);
			} else {
				p.setAllowFlight(true);
				p.setFlying(false);
			}
        }
	}
	
	@EventHandler
	public void onInfiniteJump(PlayerToggleFlightEvent e) {
		Player p = e.getPlayer();
		UUID pU = e.getPlayer().getUniqueId();
		if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
        	if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
        		for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.DoubleJump-Fly")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
    			}
	          	
        		ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
        		ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
        		ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
        		
        		ConfigTemp.getConfig().set(pU+".Options.DoubleJump-Enable", Boolean.valueOf(false));
        			 				
        		ConfigTemp.saveConfigFile();
        		
        		for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
    			}
        		
        		p.setFlying(false);
        		p.setAllowFlight(false);
        	}
        }
		if (ConfigTemp.getConfig().getBoolean(pU+".Options.DoubleJump-Enable")) {
			if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Enable")) {
				if (p.getGameMode() == GameMode.CREATIVE || p.getGameMode() == GameMode.SPECTATOR) {
					return;
				}
				p.setAllowFlight(true);
				if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.Enable")) {
					if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.World.All_World")) {
						if (WorldUtils.getWFInfiniteJump().contains(p.getWorld().getName())) {
							if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.Use_Permission")) {
								if (p.hasPermission("ultimatespawn.fun.doublejump.infite")) {
									e.setCancelled(true);
								    p.setAllowFlight(false);
								    p.setFlying(false);
								    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
								    
								    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.Sounds.Enable")) {
								    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Infinite.Sounds.Sound");
						            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Infinite.Sounds.Volume");
						            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Infinite.Sounds.Pitch");
						            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
								    }
								} else {
									onQuintupleJump(p, pU, e);
								}
							} else {
								e.setCancelled(true);
							    p.setAllowFlight(false);
							    p.setFlying(false);
							    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
							    
							    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.Sounds.Enable")) {
							    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Infinite.Sounds.Sound");
					            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Infinite.Sounds.Volume");
					            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Infinite.Sounds.Pitch");
					            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
							    }
							}
						}
					} else {
						if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.Use_Permission")) {
							if (p.hasPermission("ultimatespawn.fun.doublejump.infite")) {								
								e.setCancelled(true);
							    p.setAllowFlight(false);
							    p.setFlying(false);
							    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
							    
							    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.Sounds.Enable")) {
							    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Infinite.Sounds.Sound");
					            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Infinite.Sounds.Volume");
					            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Infinite.Sounds.Pitch");
					            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
							    }
							} else {
								onQuintupleJump(p, pU, e);
							}
						} else {
							e.setCancelled(true);
						    p.setAllowFlight(false);
						    p.setFlying(false);
						    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
						    
						    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.Sounds.Enable")) {
						    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Infinite.Sounds.Sound");
				            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Infinite.Sounds.Volume");
				            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Infinite.Sounds.Pitch");
				            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
						    }
						}
					}
				} else {
					onQuintupleJump(p, pU, e);
				}
			}
		}
	}
	
	public void onQuintupleJump(Player p, UUID pU, Event e) {
		if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.Enable")) {
			if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.World.All_World")) {
				if (WorldUtils.getWFFivefoldJump().contains(p.getWorld().getName())) {
					if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.Use_Permission")) {
						if (p.hasPermission("ultimatespawn.fun.doublejump.fivefold")) {
							int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
							if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
								number = 4;
								ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
								ConfigTemp.saveConfigFile();
							} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
								return;
							}
							
							if (number > 0) {
								number--;
								ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
								ConfigTemp.saveConfigFile();
							}
							
							if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
					        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
					        	
					        	ConfigTemp.saveConfigFile();
					        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
					        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
					        	
					        	ConfigTemp.saveConfigFile();
					        }
							
							((PlayerToggleFlightEvent) e).setCancelled(true);
						    p.setAllowFlight(false);
						    p.setFlying(false);
						    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
						    
						    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.Sounds.Enable")) {
						    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Fivefold.Sounds.Sound");
				            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Fivefold.Sounds.Volume");
				            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Fivefold.Sounds.Pitch");
				            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
						    }
						} else {
							onQuadrupleJump(p, pU, e);
						}
					} else {
						int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
						if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
							number = 4;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
							return;
						}
						
						if (number > 0) {
							number--;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						}
						
						if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        }
						
						((PlayerToggleFlightEvent) e).setCancelled(true);
					    p.setAllowFlight(false);
					    p.setFlying(false);
					    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
					    
					    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.Sounds.Enable")) {
					    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Fivefold.Sounds.Sound");
			            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Fivefold.Sounds.Volume");
			            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Fivefold.Sounds.Pitch");
			            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
					    }
					}
				}
			} else {
				if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.Use_Permission")) {
					if (p.hasPermission("ultimatespawn.fun.doublejump.fivefold")) {
						int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
						if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
							number = 4;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
							return;
						}
						
						if (number > 0) {
							number--;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						}
						
						if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        }
						
						((PlayerToggleFlightEvent) e).setCancelled(true);
					    p.setAllowFlight(false);
					    p.setFlying(false);
					    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
					    
					    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.Sounds.Enable")) {
					    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Fivefold.Sounds.Sound");
			            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Fivefold.Sounds.Volume");
			            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Fivefold.Sounds.Pitch");
			            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
					    }
					} else {
						onQuadrupleJump(p, pU, e);
					}
				} else {
					int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
					if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
						number = 4;
						ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
						ConfigTemp.saveConfigFile();
					} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
						return;
					}
					
					if (number > 0) {
						number--;
						ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
						ConfigTemp.saveConfigFile();
					}
					
					if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
			        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
			        	
			        	ConfigTemp.saveConfigFile();
			        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
			        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
			        	
			        	ConfigTemp.saveConfigFile();
			        }
					
					((PlayerToggleFlightEvent) e).setCancelled(true);
				    p.setAllowFlight(false);
				    p.setFlying(false);
				    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
				    
				    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.Sounds.Enable")) {
				    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Fivefold.Sounds.Sound");
		            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Fivefold.Sounds.Volume");
		            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Fivefold.Sounds.Pitch");
		            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
				    }
				}
			}
		} else {
			onQuadrupleJump(p, pU, e);
		}
	}

	public void onQuadrupleJump(Player p, UUID pU, Event e) {
		if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.Enable")) {
			if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.World.All_World")) {
				if (WorldUtils.getWFQuadrupleJump().contains(p.getWorld().getName())) {
					if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.Use_Permission")) {
						if (p.hasPermission("ultimatespawn.fun.doublejump.quadruple")) {
							int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
							if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
								number = 3;
								ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
								ConfigTemp.saveConfigFile();
							} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
								return;
							}
							
							if (number > 0) {
								number--;
								ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
								ConfigTemp.saveConfigFile();
							}
							
							if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
					        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
					        	
					        	ConfigTemp.saveConfigFile();
					        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
					        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
					        	
					        	ConfigTemp.saveConfigFile();
					        }
							
							((PlayerToggleFlightEvent) e).setCancelled(true);
						    p.setAllowFlight(false);
						    p.setFlying(false);
						    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
						    
						    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.Sounds.Enable")) {
						    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Quadruple.Sounds.Sound");
				            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Quadruple.Sounds.Volume");
				            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Quadruple.Sounds.Pitch");
				            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
						    }
						} else {
							onTripleJump(p, pU, e);
						}
					} else {
						int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
						if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
							number = 3;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
							return;
						}
						
						if (number > 0) {
							number--;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						}
						
						if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        }
						
						((PlayerToggleFlightEvent) e).setCancelled(true);
					    p.setAllowFlight(false);
					    p.setFlying(false);
					    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
					    
					    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.Sounds.Enable")) {
					    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Quadruple.Sounds.Sound");
			            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Quadruple.Sounds.Volume");
			            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Quadruple.Sounds.Pitch");
			            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
					    }
					}
				}
			} else {
				if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.Use_Permission")) {
					if (p.hasPermission("ultimatespawn.fun.doublejump.quadruple")) {
						int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
						if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
							number = 3;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
							return;
						}
						
						if (number > 0) {
							number--;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						}
						
						if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        }
						
						((PlayerToggleFlightEvent) e).setCancelled(true);
					    p.setAllowFlight(false);
					    p.setFlying(false);
					    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
					    
					    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.Sounds.Enable")) {
					    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Quadruple.Sounds.Sound");
			            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Quadruple.Sounds.Volume");
			            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Quadruple.Sounds.Pitch");
			            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
					    }
					} else {
						onTripleJump(p, pU, e);
					}
				} else {
					int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
					if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
						number = 3;
						ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
						ConfigTemp.saveConfigFile();
					} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
						return;
					}
					
					if (number > 0) {
						number--;
						ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
						ConfigTemp.saveConfigFile();
					}
					
					if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
			        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
			        	
			        	ConfigTemp.saveConfigFile();
			        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
			        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
			        	
			        	ConfigTemp.saveConfigFile();
			        }
					
					((PlayerToggleFlightEvent) e).setCancelled(true);
				    p.setAllowFlight(false);
				    p.setFlying(false);
				    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
				    
				    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.Sounds.Enable")) {
				    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Quadruple.Sounds.Sound");
		            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Quadruple.Sounds.Volume");
		            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Quadruple.Sounds.Pitch");
		            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
				    }
				}
			}
		} else {
			onTripleJump(p, pU, e);
		}
}

	public void onTripleJump(Player p, UUID pU, Event e) {
		if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.Enable")) {
			if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.World.All_World")) {
				if (WorldUtils.getWFTripleJump().contains(p.getWorld().getName())) {
					if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.Use_Permission")) {
						if (p.hasPermission("ultimatespawn.fun.doublejump.triple")) {
							int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
							if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
								number = 2;
								ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
								ConfigTemp.saveConfigFile();
							} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
								return;
							}
							
							if (number > 0) {
								number--;
								ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
								ConfigTemp.saveConfigFile();
							}
							
							if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
					        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
					        	
					        	ConfigTemp.saveConfigFile();
					        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
					        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
					        	
					        	ConfigTemp.saveConfigFile();
					        }
							
							((PlayerToggleFlightEvent) e).setCancelled(true);
						    p.setAllowFlight(false);
						    p.setFlying(false);
						    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
						    
						    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.Sounds.Enable")) {
						    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Triple.Sounds.Sound");
				            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Triple.Sounds.Volume");
				            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Triple.Sounds.Pitch");
				            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
						    }
						} else {
							onDoubleJump(p, pU, e);
						}
					} else {
						int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
						if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
							number = 2;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
							return;
						}
						
						if (number > 0) {
							number--;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						}
						
						if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        }
						
						((PlayerToggleFlightEvent) e).setCancelled(true);
					    p.setAllowFlight(false);
					    p.setFlying(false);
					    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
					    
					    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.Sounds.Enable")) {
					    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Triple.Sounds.Sound");
			            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Triple.Sounds.Volume");
			            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Triple.Sounds.Pitch");
			            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
					    }
					}
				}
			} else {
				if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.Use_Permission")) {
					if (p.hasPermission("ultimatespawn.fun.doublejump.triple")) {
						int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
						if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
							number = 2;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
							return;
						}
						
						if (number > 0) {
							number--;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						}
						
						if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        }
						
						((PlayerToggleFlightEvent) e).setCancelled(true);
					    p.setAllowFlight(false);
					    p.setFlying(false);
					    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
					    
					    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.Sounds.Enable")) {
					    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Triple.Sounds.Sound");
			            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Triple.Sounds.Volume");
			            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Triple.Sounds.Pitch");
			            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
					    }
					} else {
						onDoubleJump(p, pU, e);
					}
				} else {
					int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
					if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
						number = 2;
						ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
						ConfigTemp.saveConfigFile();
					} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
						return;
					}
					
					if (number > 0) {
						number--;
						ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
						ConfigTemp.saveConfigFile();
					}
					
					if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
			        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
			        	
			        	ConfigTemp.saveConfigFile();
			        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
			        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
			        	
			        	ConfigTemp.saveConfigFile();
			        }
					
					((PlayerToggleFlightEvent) e).setCancelled(true);
				    p.setAllowFlight(false);
				    p.setFlying(false);
				    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
				    
				    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.Sounds.Enable")) {
				    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Triple.Sounds.Sound");
		            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Triple.Sounds.Volume");
		            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Triple.Sounds.Pitch");
		            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
				    }
				}
			}
		} else {
			onDoubleJump(p, pU, e);
		}
}

	public void onDoubleJump(Player p, UUID pU, Event e) {
		if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.Enable")) {
			if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.World.All_World")) {
				if (WorldUtils.getWFDoubleJump().contains(p.getWorld().getName())) {
					if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.Use_Permission")) {
						if (p.hasPermission("ultimatespawn.fun.doublejump.double")) {
							int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
							if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
								number = 1;
								ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
								ConfigTemp.saveConfigFile();
							} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
								return;
							}
							
							if (number > 0) {
								number--;
								ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
								ConfigTemp.saveConfigFile();
							}
							
							if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
					        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
					        	
					        	ConfigTemp.saveConfigFile();
					        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
					        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
					        	
					        	ConfigTemp.saveConfigFile();
					        }
							
							((PlayerToggleFlightEvent) e).setCancelled(true);
						    p.setAllowFlight(false);
						    p.setFlying(false);
						    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
						    
						    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.Sounds.Enable")) {
						    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Double.Sounds.Sound");
				            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Double.Sounds.Volume");
				            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Double.Sounds.Pitch");
				            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
						    }
						}
					} else {
						int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
						if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
							number = 1;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
							return;
						}
						
						if (number > 0) {
							number--;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						}
						
						if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        }
						
						((PlayerToggleFlightEvent) e).setCancelled(true);
					    p.setAllowFlight(false);
					    p.setFlying(false);
					    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
					    
					    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.Sounds.Enable")) {
					    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Double.Sounds.Sound");
			            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Double.Sounds.Volume");
			            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Double.Sounds.Pitch");
			            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
					    }
					}
				}
			} else {
				if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.Use_Permission")) {
					if (p.hasPermission("ultimatespawn.fun.doublejump.triple")) {
						int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
						if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
							number = 1;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
							return;
						}
						
						if (number > 0) {
							number--;
							ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
							ConfigTemp.saveConfigFile();
						}
						
						if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
				        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
				        	
				        	ConfigTemp.saveConfigFile();
				        }
						
						((PlayerToggleFlightEvent) e).setCancelled(true);
					    p.setAllowFlight(false);
					    p.setFlying(false);
					    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
					    
					    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.Sounds.Enable")) {
					    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Double.Sounds.Sound");
			            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Double.Sounds.Volume");
			            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Double.Sounds.Pitch");
			            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
					    }
					}
				} else {
					int number = ConfigTemp.getConfig().getInt(pU+".Options.DoubleJump");
					if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() != Material.AIR)) {
						number = 1;
						ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
						ConfigTemp.saveConfigFile();
					} else if (number == 0 && (p.getLocation().subtract(0.0D, 1.0D, 0.0D).getBlock().getType() == Material.AIR)) {
						return;
					}
					
					if (number > 0) {
						number--;
						ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
						ConfigTemp.saveConfigFile();
					}
					
					if (!ConfigTemp.getConfig().contains(String.valueOf(pU))) {
			        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
			        	
			        	ConfigTemp.saveConfigFile();
			        } else if (ConfigTemp.getConfig().contains(String.valueOf(pU))) {
			        	ConfigTemp.getConfig().set(pU+".Options.DoubleJump", Integer.valueOf(number));
			        	
			        	ConfigTemp.saveConfigFile();
			        }
					
					((PlayerToggleFlightEvent) e).setCancelled(true);
				    p.setAllowFlight(false);
				    p.setFlying(false);
				    p.setVelocity(p.getLocation().getDirection().multiply(1.5D).setY(1));
				    
				    if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.Sounds.Enable")) {
				    	String sound = ConfigFDoubleJump.getConfig().getString("DoubleJump.Double.Sounds.Sound");
		            	int volume = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Double.Sounds.Volume");
		            	int pitch = ConfigFDoubleJump.getConfig().getInt("DoubleJump.Double.Sounds.Pitch");
		            	p.playSound(p.getLocation(), Sound.valueOf(sound), volume, pitch);
				    }
				}
			}
		}
	}

}
