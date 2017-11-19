package fr.Dianox.US.MainClass.event;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.Utils.WorldUtils;
import fr.Dianox.US.MainClass.Utils.NeedLobby.PlayerVisibility;
import fr.Dianox.US.MainClass.config.command.ConfigCPlayerOption;
import fr.Dianox.US.MainClass.config.global.cji.ConfigGPlayerVisibility;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlayerOption;

public class CustomJoinItem implements Listener {

	public static String Check = ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Name");
	public static String CheckTwo = ConfigGPlayerVisibility.getConfig().getString("PV.ON.Name");
	
	public static String getCheck() {
		return Check;
	}
	
	public static String getCheckTwo() {
		return CheckTwo;
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onBreakWithItemVisibility(BlockBreakEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Enable")) {
			if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Ultimate-Protection-Of-The-Items")) {
				if ((p.getItemInHand().getItemMeta().getDisplayName() == Check) || (p.getItemInHand().getItemMeta().getDisplayName() == CheckTwo)) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onPlaceWithItemVisibility(BlockPlaceEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Enable")) {
			if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Ultimate-Protection-Of-The-Items")) {
				if ((p.getItemInHand().getItemMeta().getDisplayName() == Check) || (p.getItemInHand().getItemMeta().getDisplayName() == CheckTwo)) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onDropWithItemVisibility(PlayerDropItemEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Enable")) {
			if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Ultimate-Protection-Of-The-Items")) {
				if ((p.getItemInHand().getItemMeta().getDisplayName() == Check) || (p.getItemInHand().getItemMeta().getDisplayName() == CheckTwo)) {
					e.setCancelled(true);
				}
			}
		}
	}
	
	@EventHandler(priority=EventPriority.HIGHEST)
	public void onInventoryClickWithItemVisibility(InventoryClickEvent e) {
		Player p = (Player) e.getWhoClicked();
		String name = e.getWhoClicked().getName();
		
		if(e.getCurrentItem() == null || e.getCurrentItem().getType() == Material.AIR) return;
		if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Enable")) {
			if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Ultimate-Protection-Of-The-Items")) {
				e.setCancelled(true);
			}
			if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Interact-With-The-Object")) {
				if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Use_Permission")) {
					if (p.hasPermission("ultimatespawn.event.interact.item.playervisibility")) {
						if (e.getCurrentItem().getItemMeta().getDisplayName() == Check) {
							e.setCancelled(true);
							if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Enable")) {
								if (PlayerVisibility.Cooling().contains(name)) {
									for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.Player-Visibility.Time")) {
							    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
							    	}
								} else {
									PlayerVisibility.Cooling().add(name);
									PlayerVisibility.hidePlayer(p);
									swithPVItemsOnJoinToON(p);
									soundInventoryClickPVOJI(p);
									if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
										messageitemPVON(p);
									}
									if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Take-Delay-Of-The-Command")) {
										if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.PlayerVisivility.Delay.Enable")) {
											Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			
												@Override
												public void run() {
													PlayerVisibility.Cooling().remove(name);
												}
												
											}, ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")*20);
										} else {
											Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
												
												@Override
												public void run() {
													PlayerVisibility.Cooling().remove(name);
												}
												
											}, 5L);
										}
									} else {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")*20);
									}
								}
							} else {
								e.setCancelled(true);
								PlayerVisibility.hidePlayer(p);
								swithPVItemsOnJoinToON(p);
								soundInventoryClickPVOJI(p);
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
									messageitemPVON(p);
								}
							}
						} else if (e.getCurrentItem().getItemMeta().getDisplayName() == CheckTwo) {
							e.setCancelled(true);
							if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Enable")) {
								if (PlayerVisibility.Cooling().contains(name)) {
									for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.Player-Visibility.Time")) {
							    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
							    	}
								} else {
									PlayerVisibility.Cooling().add(name);
									PlayerVisibility.hidePlayer(p);
									swithPVItemsOnJoinToOFF(p);
									soundInventoryClickPVOJI(p);
									if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
										messageitemPVOFF(p);
									}
									if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Take-Delay-Of-The-Command")) {
										if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.PlayerVisivility.Delay.Enable")) {
											Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			
												@Override
												public void run() {
													PlayerVisibility.Cooling().remove(name);
												}
												
											}, ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")*20);
										} else {
											Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
												
												@Override
												public void run() {
													PlayerVisibility.Cooling().remove(name);
												}
												
											}, 5L);
										}
									} else {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")*20);
									}
								}
							} else {
								e.setCancelled(true);
								PlayerVisibility.hidePlayer(p);
								swithPVItemsOnJoinToOFF(p);
								soundInventoryClickPVOJI(p);
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
									messageitemPVOFF(p);
								}
							}
						}
					}
				} else {
					if (e.getCurrentItem().getItemMeta().getDisplayName() == Check) {
						e.setCancelled(true);
						if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Enable")) {
							if (PlayerVisibility.Cooling().contains(name)) {
								for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.Player-Visibility.Time")) {
						    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						    	}
							} else {
								PlayerVisibility.Cooling().add(name);
								PlayerVisibility.hidePlayer(p);
								swithPVItemsOnJoinToON(p);
								soundInventoryClickPVOJI(p);
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
									messageitemPVON(p);
								}
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Take-Delay-Of-The-Command")) {
									if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.PlayerVisivility.Delay.Enable")) {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
		
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")*20);
									} else {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, 5L);
									}
								} else {
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										
										@Override
										public void run() {
											PlayerVisibility.Cooling().remove(name);
										}
										
									}, ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")*20);
								}
							}
						} else {
							e.setCancelled(true);
							PlayerVisibility.hidePlayer(p);
							swithPVItemsOnJoinToON(p);
							soundInventoryClickPVOJI(p);
							if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
								messageitemPVON(p);
							}
						}
					} else if (e.getCurrentItem().getItemMeta().getDisplayName() == CheckTwo) {
						e.setCancelled(true);
						if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Enable")) {
							if (PlayerVisibility.Cooling().contains(name)) {
								for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.Player-Visibility.Time")) {
						    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						    	}
							} else {
								PlayerVisibility.Cooling().add(name);
								PlayerVisibility.hidePlayer(p);
								swithPVItemsOnJoinToOFF(p);
								soundInventoryClickPVOJI(p);
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
									messageitemPVOFF(p);
								}
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Take-Delay-Of-The-Command")) {
									if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.PlayerVisivility.Delay.Enable")) {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
		
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")*20);
									} else {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, 5L);
									}
								} else {
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										
										@Override
										public void run() {
											PlayerVisibility.Cooling().remove(name);
										}
										
									}, ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")*20);
								}
							}
						} else {
							e.setCancelled(true);
							PlayerVisibility.hidePlayer(p);
							swithPVItemsOnJoinToOFF(p);
							soundInventoryClickPVOJI(p);
							if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
								messageitemPVOFF(p);
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onInteract(PlayerInteractEvent e) {
		Player p = e.getPlayer();
		String name = e.getPlayer().getName();
		
		if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Enable")) {
			if (e.getAction() == Action.RIGHT_CLICK_AIR) {
				if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Use_Permission")) {
					if (p.hasPermission("ultimatespawn.event.interact.item.playervisibility")) {
						if (p.getItemInHand().getItemMeta().getDisplayName() == Check) {
							if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Enable")) {
								if (PlayerVisibility.Cooling().contains(name)) {
									for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.Player-Visibility.Time")) {
							    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
							    	}
								} else {
									PlayerVisibility.Cooling().add(name);
									PlayerVisibility.hidePlayer(p);
									swithPVItemsOnJoinToON(p);
									soundInventoryClickPVOJI(p);
									if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
										messageitemPVON(p);
									}
									if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Take-Delay-Of-The-Command")) {
										if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.PlayerVisivility.Delay.Enable")) {
											Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			
												@Override
												public void run() {
													PlayerVisibility.Cooling().remove(name);
												}
												
											}, ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")*20);
										} else {
											Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
												
												@Override
												public void run() {
													PlayerVisibility.Cooling().remove(name);
												}
												
											}, 5L);
										}
									} else {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")*20);
									}
								}
							} else {
								PlayerVisibility.hidePlayer(p);
								swithPVItemsOnJoinToON(p);
								soundInventoryClickPVOJI(p);
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
									messageitemPVON(p);
								}
							}
						} else if (p.getItemInHand().getItemMeta().getDisplayName() == CheckTwo) {
							if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Enable")) {
								if (PlayerVisibility.Cooling().contains(name)) {
									for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.Player-Visibility.Time")) {
							    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
							    	}
								} else {
									PlayerVisibility.Cooling().add(name);
									PlayerVisibility.hidePlayer(p);
									swithPVItemsOnJoinToOFF(p);
									soundInventoryClickPVOJI(p);
									if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
										messageitemPVOFF(p);
									}
									if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Take-Delay-Of-The-Command")) {
										if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.PlayerVisivility.Delay.Enable")) {
											Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
			
												@Override
												public void run() {
													PlayerVisibility.Cooling().remove(name);
												}
												
											}, ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")*20);
										} else {
											Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
												
												@Override
												public void run() {
													PlayerVisibility.Cooling().remove(name);
												}
												
											}, 5L);
										}
									} else {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")*20);
									}
								}
							} else {
								PlayerVisibility.hidePlayer(p);
								swithPVItemsOnJoinToOFF(p);
								soundInventoryClickPVOJI(p);
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
									messageitemPVOFF(p);
								}
							}
						}
					}
				} else {
					if (p.getItemInHand().getItemMeta().getDisplayName() == Check) {
						if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Enable")) {
							if (PlayerVisibility.Cooling().contains(name)) {
								for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.Player-Visibility.Time")) {
						    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						    	}
							} else {
								PlayerVisibility.Cooling().add(name);
								PlayerVisibility.hidePlayer(p);
								swithPVItemsOnJoinToON(p);
								soundInventoryClickPVOJI(p);
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
									messageitemPVON(p);
								}
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Take-Delay-Of-The-Command")) {
									if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.PlayerVisivility.Delay.Enable")) {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
		
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")*20);
									} else {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, 5L);
									}
								} else {
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										
										@Override
										public void run() {
											PlayerVisibility.Cooling().remove(name);
										}
										
									}, ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")*20);
								}
							}
						} else {
							PlayerVisibility.hidePlayer(p);
							swithPVItemsOnJoinToON(p);
							soundInventoryClickPVOJI(p);
							if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
								messageitemPVON(p);
							}
						}
					} else if (p.getItemInHand().getItemMeta().getDisplayName() == CheckTwo) {
						if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Enable")) {
							if (PlayerVisibility.Cooling().contains(name)) {
								for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.Error.Player-Visibility.Time")) {
						    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						    	}
							} else {
								PlayerVisibility.Cooling().add(name);
								PlayerVisibility.hidePlayer(p);
								swithPVItemsOnJoinToOFF(p);
								soundInventoryClickPVOJI(p);
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
									messageitemPVOFF(p);
								}
								if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Item-Delay.Take-Delay-Of-The-Command")) {
									if (ConfigCPlayerOption.getConfig().getBoolean("PlayerOption.PlayerVisivility.Delay.Enable")) {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
		
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, ConfigCPlayerOption.getConfig().getInt("PlayerOption.PlayerVisivility.Delay.Delay")*20);
									} else {
										Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
											
											@Override
											public void run() {
												PlayerVisibility.Cooling().remove(name);
											}
											
										}, 5L);
									}
								} else {
									Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(MainClass.getInstance(), new Runnable() {
										
										@Override
										public void run() {
											PlayerVisibility.Cooling().remove(name);
										}
										
									}, ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Item-Delay.Delay")*20);
								}
							}
						} else {
							PlayerVisibility.hidePlayer(p);
							swithPVItemsOnJoinToOFF(p);
							soundInventoryClickPVOJI(p);
							if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Show-Messages")) {
								messageitemPVOFF(p);
							}
						}
					}
				}
			}
		}
	}
	
	@EventHandler
	public void onPlayerJoinEvent(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		
		if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Enable")) {
			if (!ConfigGPlayerVisibility.getConfig().getBoolean("PV.World.All_World")) {
				if (WorldUtils.getWItemPVOnJoin().contains(p.getWorld().getName())) {
					if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Use_Permission")) {
						if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.OnJoin-ShowPlayers")) {
							CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Amount"), (short) 1, 
									(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Name"), 
									ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Slot"), p, ConfigGPlayerVisibility.getConfig().getStringList("PV.OFF.Lore"));
							PlayerVisibility.showPlayer(p);
						} else {
							CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.ON.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Amount"), (short) 1, 
									(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.ON.Name"), 
									ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Slot"), p, ConfigGPlayerVisibility.getConfig().getStringList("PV.ON.Lore"));
							PlayerVisibility.hidePlayer(p);
						}
					} else {
						if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.OnJoin-ShowPlayers")) {
							CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Amount"), (short) 1, 
									(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Name"), 
									ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Slot"), p, ConfigGPlayerVisibility.getConfig().getStringList("PV.OFF.Lore"));
							PlayerVisibility.showPlayer(p);
						} else {
							CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.ON.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Amount"), (short) 1, 
									(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.ON.Name"), 
									ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Slot"), p, ConfigGPlayerVisibility.getConfig().getStringList("PV.ON.Lore"));
							PlayerVisibility.hidePlayer(p);
						}
					}
				}
			} else {
				if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Use_Permission")) {
					if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.OnJoin-ShowPlayers")) {
						CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Amount"), (short) 1, 
								(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Name"), 
								ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Slot"), p, ConfigGPlayerVisibility.getConfig().getStringList("PV.OFF.Lore"));
						PlayerVisibility.showPlayer(p);
					} else {
						CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.ON.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Amount"), (short) 1, 
								(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.ON.Name"), 
								ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Slot"), p, ConfigGPlayerVisibility.getConfig().getStringList("PV.ON.Lore"));
						PlayerVisibility.hidePlayer(p);
					}
				} else {
					if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.OnJoin-ShowPlayers")) {
						CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Amount"), (short) 1, 
								(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Name"), 
								ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Slot"), p, ConfigGPlayerVisibility.getConfig().getStringList("PV.OFF.Lore"));
						PlayerVisibility.showPlayer(p);
					} else {
						CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.ON.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Amount"), (short) 1, 
								(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.ON.Name"), 
								ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Slot"), p, ConfigGPlayerVisibility.getConfig().getStringList("PV.ON.Lore"));
						PlayerVisibility.hidePlayer(p);
					}
				}
			}
		}
	}
	
	public static void swithPVItemsOnJoinToON(Player p) {
		for (int i = 0 ; i <= 35; ++i) {
			if (p.getInventory().getItem(i).getItemMeta().getDisplayName() == CustomJoinItem.Check) {
				p.getInventory().clear(i);
				CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.ON.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Amount"), (short) 1, 
						(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.ON.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.ON.Name"), 
						i, p, ConfigGPlayerVisibility.getConfig().getStringList("PV.ON.Lore"));
				break;
			}
		}
	}
	
	public static void swithPVItemsOnJoinToOFF(Player p) {
		for (int i = 0 ; i <= 35; ++i) {
			if (p.getInventory().getItem(i).getItemMeta().getDisplayName() == CustomJoinItem.CheckTwo) {
				p.getInventory().clear(i);
				CreateItems(Material.getMaterial(ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Material.Meterial")), ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Amount"), (short) 1, 
						(byte) ConfigGPlayerVisibility.getConfig().getInt("PV.OFF.Material.Data"), ConfigGPlayerVisibility.getConfig().getString("PV.OFF.Name"), 
						i, p, ConfigGPlayerVisibility.getConfig().getStringList("PV.OFF.Lore"));
				break;
			}
		}
	}
	
	public static void messageitemPVON(Player p) {
		for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.PlayerVisibility.ON")) {
    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
    	}
	}
	
	public static void messageitemPVOFF(Player p) {
		for (String msg: ConfigMPlayerOption.getConfig().getStringList("PlayerOption.PlayerVisibility.OFF")) {
    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
    	}
	}
	
	// Sound
	public void soundInventoryClickPVOJI(Player p) {
		String sound = ConfigGPlayerVisibility.getConfig().getString("PV.Option.Inventory-Click.Sounds.Sound");
		int volume = ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Inventory-Click.Sounds.Volume");
		int pitch = ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Inventory-Click.Sounds.Pitch");
		if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Inventory-Click.Sounds.Enable")) {
			p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.valueOf(sound), volume, pitch);
		}
	}
	
	public void soundInteractPVOJI(Player p) {
		String sound = ConfigGPlayerVisibility.getConfig().getString("PV.Option.Interact-With-Item.Sounds.Sound");
		int volume = ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Interact-With-Item.Sounds.Volume");
		int pitch = ConfigGPlayerVisibility.getConfig().getInt("PV.Option.Interact-With-Item.Sounds.Pitch");
		if (ConfigGPlayerVisibility.getConfig().getBoolean("PV.Option.Interact-With-Item.Sounds.Enable")) {
			p.getPlayer().playSound(p.getPlayer().getLocation(), Sound.valueOf(sound), volume, pitch);
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void CreateItems(Material mat, Integer amount, short damage, byte bytes, String str, Integer ints, Player p, List<String> list) {
		ArrayList<String> lel = new ArrayList<String>();
		
		lel.addAll(list);
		
		ItemStack matt = new ItemStack(mat, amount, damage, bytes);
		ItemMeta matts = matt.getItemMeta();
		matts.setDisplayName(str);
		matts.setLore(lel);
		matt.setItemMeta(matts);
		
		p.getInventory().setItem(ints, matt);
	}
	
}
