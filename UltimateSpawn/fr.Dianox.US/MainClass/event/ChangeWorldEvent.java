package fr.Dianox.US.MainClass.event;

import java.util.UUID;

import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerChangedWorldEvent;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.config.ConfigPlayerOptions;
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.event.CWE.ConfigCWEGM;
import fr.Dianox.US.MainClass.config.event.CWE.ConfigCWEKeepFly;

public class ChangeWorldEvent implements Listener {
	
	@EventHandler
	public void onChangeWorld(PlayerChangedWorldEvent e) {
		Player p = e.getPlayer();
		UUID pU = e.getPlayer().getUniqueId();
		
		// Fly
		if (ConfigCWEKeepFly.getConfig().getBoolean("KeepFly.Enable.Enable")) {
			if (!ConfigCWEKeepFly.getConfig().getBoolean("KeepFly.World.All_World")) {
				if (MainClass.getWFlyKeepOnChangeWorld().contains(p.getWorld().getName())) {
					if (ConfigCWEKeepFly.getConfig().getBoolean("KeepFly.Enable.SetFlyOnChangeWorld")) {
						if (p.getGameMode() != GameMode.SPECTATOR) {
							if (!ConfigPlayerOptions.getConfig().contains(String.valueOf(pU))) {
								p.sendMessage("§cError in your config");
							} else {
								p.setAllowFlight(true);
								p.setFlying(true);
								
								ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Enable",  Boolean.valueOf(true));
								ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetAllowFlight",  Boolean.valueOf(true));
					       		ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetFlying", Boolean.valueOf(true));
					       		ConfigPlayerOptions.saveConfigFile();
							}
						}
					}
				} else {
					if (ConfigCWEKeepFly.getConfig().getBoolean("KeepFly.Enable.DisableFlyIfAWorldIsNotListed")) {
						if (!ConfigPlayerOptions.getConfig().contains(String.valueOf(pU))) {
							p.sendMessage("§cError in your config");
						} else {
							p.setAllowFlight(false);
							p.setFlying(false);
							
							ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Enable",  Boolean.valueOf(false));
							ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetAllowFlight",  Boolean.valueOf(false));
				       		ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetFlying", Boolean.valueOf(false));
				       		ConfigPlayerOptions.saveConfigFile();
						}
					}
				}
			} else {
				if (ConfigCWEKeepFly.getConfig().getBoolean("KeepFly.Enable.SetFlyOnChangeWorld")) {
					if (p.getGameMode() != GameMode.SPECTATOR) {
						if (!ConfigPlayerOptions.getConfig().contains(String.valueOf(pU))) {
							p.sendMessage("§cError in your config");
						} else {
							p.setAllowFlight(true);
							p.setFlying(true);
							
							ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Enable",  Boolean.valueOf(true));
							ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetAllowFlight",  Boolean.valueOf(true));
				       		ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetFlying", Boolean.valueOf(true));
				       		ConfigPlayerOptions.saveConfigFile();
						}
					}
				}
			}
		} else {
			if (!ConfigPlayerOptions.getConfig().contains(String.valueOf(pU))) {
				p.sendMessage("§cError in your config");
			} else {
				p.setAllowFlight(false);
				p.setFlying(false);
				
				ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Enable",  Boolean.valueOf(false));
				ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetAllowFlight",  Boolean.valueOf(false));
	       		ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetFlying", Boolean.valueOf(false));
	       		ConfigPlayerOptions.saveConfigFile();
			}
		}
		
		// Gamemode
		if (ConfigCWEGM.getConfig().getBoolean("GM.Enable")) {
			if (!ConfigCWEGM.getConfig().getBoolean("GM.World.All_World")) {
				if (MainClass.getWGamemodeOnChangeWorld().contains(p.getWorld().getName())) {
					if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.Enable")) {
						if (p.getGameMode() == GameMode.SURVIVAL) {
							if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.If-player-have.Survival")) {
								if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 0) {
									p.setGameMode(GameMode.SURVIVAL);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 1) {
									p.setGameMode(GameMode.CREATIVE);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 2) {
									p.setGameMode(GameMode.ADVENTURE);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 3) {
									p.setGameMode(GameMode.SPECTATOR);
								}
							}
						} else if (p.getGameMode() == GameMode.CREATIVE) {
							if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.If-player-have.Creative")) {
								if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 0) {
									p.setGameMode(GameMode.SURVIVAL);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 1) {
									p.setGameMode(GameMode.CREATIVE);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 2) {
									p.setGameMode(GameMode.ADVENTURE);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 3) {
									p.setGameMode(GameMode.SPECTATOR);
								}
							}
						} else if (p.getGameMode() == GameMode.ADVENTURE) {
							if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.If-player-have.Adventure")) {
								if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 0) {
									p.setGameMode(GameMode.SURVIVAL);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 1) {
									p.setGameMode(GameMode.CREATIVE);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 2) {
									p.setGameMode(GameMode.ADVENTURE);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 3) {
									p.setGameMode(GameMode.SPECTATOR);
								}
							}
						} else if (p.getGameMode() == GameMode.SPECTATOR) {
							if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.If-player-have.Spectator")) {
								if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 0) {
									p.setGameMode(GameMode.SURVIVAL);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 1) {
									p.setGameMode(GameMode.CREATIVE);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 2) {
									p.setGameMode(GameMode.ADVENTURE);
								} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 3) {
									p.setGameMode(GameMode.SPECTATOR);
								}
							}
						}
					} else {
						if (ConfigTemp.getConfig().getInt(pU+".Options.Gamemode") == 0) {
							p.setGameMode(GameMode.SURVIVAL);
						} else if (ConfigTemp.getConfig().getInt(pU+".Options.Gamemode") == 1) {
							p.setGameMode(GameMode.CREATIVE);
						} else if (ConfigTemp.getConfig().getInt(pU+".Options.Gamemode") == 2) {
							p.setGameMode(GameMode.ADVENTURE);
						} else if (ConfigTemp.getConfig().getInt(pU+".Options.Gamemode") == 3) {
							p.setGameMode(GameMode.SPECTATOR);
						}
					}
				}
			} else {
				if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.Enable")) {
					if (p.getGameMode() == GameMode.SURVIVAL) {
						if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.If-player-have.Survival")) {
							if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 0) {
								p.setGameMode(GameMode.SURVIVAL);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 1) {
								p.setGameMode(GameMode.CREATIVE);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 2) {
								p.setGameMode(GameMode.ADVENTURE);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 3) {
								p.setGameMode(GameMode.SPECTATOR);
							}
						}
					} else if (p.getGameMode() == GameMode.CREATIVE) {
						if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.If-player-have.Creative")) {
							if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 0) {
								p.setGameMode(GameMode.SURVIVAL);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 1) {
								p.setGameMode(GameMode.CREATIVE);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 2) {
								p.setGameMode(GameMode.ADVENTURE);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 3) {
								p.setGameMode(GameMode.SPECTATOR);
							}
						}
					} else if (p.getGameMode() == GameMode.ADVENTURE) {
						if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.If-player-have.Adventure")) {
							if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 0) {
								p.setGameMode(GameMode.SURVIVAL);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 1) {
								p.setGameMode(GameMode.CREATIVE);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 2) {
								p.setGameMode(GameMode.ADVENTURE);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 3) {
								p.setGameMode(GameMode.SPECTATOR);
							}
						}
					} else if (p.getGameMode() == GameMode.SPECTATOR) {
						if (ConfigCWEGM.getConfig().getBoolean("GM.CustomMode.If-player-have.Spectator")) {
							if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 0) {
								p.setGameMode(GameMode.SURVIVAL);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 1) {
								p.setGameMode(GameMode.CREATIVE);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 2) {
								p.setGameMode(GameMode.ADVENTURE);
							} else if (ConfigCWEGM.getConfig().getInt("GM.CustomMode.GameMode") == 3) {
								p.setGameMode(GameMode.SPECTATOR);
							}
						}
					}
				} else {
					if (ConfigTemp.getConfig().getInt(pU+".Options.Gamemode") == 0) {
						p.setGameMode(GameMode.SURVIVAL);
					} else if (ConfigTemp.getConfig().getInt(pU+".Options.Gamemode") == 1) {
						p.setGameMode(GameMode.CREATIVE);
					} else if (ConfigTemp.getConfig().getInt(pU+".Options.Gamemode") == 2) {
						p.setGameMode(GameMode.ADVENTURE);
					} else if (ConfigTemp.getConfig().getInt(pU+".Options.Gamemode") == 3) {
						p.setGameMode(GameMode.SPECTATOR);
					}
				}
			}
		}
	}

}
