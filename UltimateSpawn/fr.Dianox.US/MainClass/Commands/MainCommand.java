package fr.Dianox.US.MainClass.Commands;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.MainClass;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigSpawn;

public class MainCommand implements CommandExecutor {

    MainClass instance = MainClass.getInstance();

    public MainCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (!(sender instanceof Player)) {
            if (cmd.getName().equalsIgnoreCase("UltimateSpawn") || cmd.getName().equalsIgnoreCase("Us")) {
                if ((args.length == 0) || (args[0].equalsIgnoreCase("help"))) {
                    sender.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
                    sender.sendMessage("");
                    sender.sendMessage("     §l>> §e§o§lGlobal Help");
                    sender.sendMessage("");
                    sender.sendMessage(" §8>> §7/setspawn - §cSet the spawn (You can't)");
                    sender.sendMessage(" §8>> §7/spawn - §cGo to spawn (You can't)");
                    sender.sendMessage(" §8>> §7/us reload - §eReload the plugin");
                    sender.sendMessage(" §8>> §7/cc - §bHelp of clearchat");
                    sender.sendMessage(" §8>> §7/bc - §eBroadcast ");
                    sender.sendMessage(" §8>> §7/ping - §ePing ");
                    sender.sendMessage(" §8>> §7/gmute - §eMute chat ");
                    sender.sendMessage(" §8>> §7/dchat [delay] - §eDelayChat ");
                    sender.sendMessage("");
                    sender.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
                } else if (args[0].equalsIgnoreCase("reload")) {
                    ConfigGlobal.reloadConfig();
                    ConfigMessage.reloadConfig();
                    ConfigSpawn.reloadConfig();
                    
                    MainClass.worlds_hunger.clear();
                    MainClass.worlds_damage.clear();
                    MainClass.worlds_weather.clear();
                    MainClass.worlds_burn_block.clear();
                    MainClass.worlds_explosions.clear();
                    MainClass.worlds_death_message.clear();
                    MainClass.worlds_spawning_mob_animals.clear();
                    MainClass.worlds_c_place.clear();
                    MainClass.worlds_c_break.clear();
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Hunger.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Hunger.World.All_World")) {
            	            for (String worldHunger : ConfigGlobal.getConfig().getStringList("Server.Disable.Hunger.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldHunger) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Hunger.World: "+worldHunger);
            	            	} else {
            	            		MainClass.worlds_hunger.add(worldHunger);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Damage.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Damage.World.All_World")) {
            	            for (String worldDamage : ConfigGlobal.getConfig().getStringList("Server.Disable.Damage.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldDamage) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Damage.World: "+worldDamage);
            	            	} else {
            	            		MainClass.worlds_damage.add(worldDamage);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Weather.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Weather.World.All_World")) {
            	            for (String worldWeather : ConfigGlobal.getConfig().getStringList("Server.Disable.Weather.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldWeather) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Weather.World: "+worldWeather);
            	            	} else {
            	            		MainClass.worlds_weather.add(worldWeather);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Burn-block.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Burn-block.World.All_World")) {
            	            for (String worldBurnBlock : ConfigGlobal.getConfig().getStringList("Server.Disable.Burn-block.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldBurnBlock) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Burn-block.World: "+worldBurnBlock);
            	            	} else {
            	            		MainClass.worlds_burn_block.add(worldBurnBlock);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Burn-block.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Burn-block.World.All_World")) {
            	            for (String worldBurnBlock : ConfigGlobal.getConfig().getStringList("Server.Disable.Burn-block.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldBurnBlock) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Burn-block.World: "+worldBurnBlock);
            	            	} else {
            	            		MainClass.worlds_burn_block.add(worldBurnBlock);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Explosion.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Explosion.World.All_World")) {
            	            for (String worldExplosion : ConfigGlobal.getConfig().getStringList("Server.Disable.Explosion.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldExplosion) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Explosion.World: "+worldExplosion);
            	            	} else {
            	            		MainClass.worlds_burn_block.add(worldExplosion);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Death-Message.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Death-Message.World.All_World")) {
            	            for (String worldDM : ConfigGlobal.getConfig().getStringList("Server.Disable.Death-Message.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldDM) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Death-Message.World: "+worldDM);
            	            	} else {
            	            		MainClass.worlds_death_message.add(worldDM);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.World.All_World")) {
            	            for (String worldSMA : ConfigGlobal.getConfig().getStringList("Server.Disable.Spawning-Monster-Animals.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldSMA) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Spawning-Monster-Animals.World: "+worldSMA);
            	            	} else {
            	            		MainClass.worlds_spawning_mob_animals.add(worldSMA);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Place.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Protection.Construct.Place.World.All_World")) {
            	            for (String worldSMA : ConfigGlobal.getConfig().getStringList("Protection.Construct.Place.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldSMA) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Protection.Construct.Place.World: "+worldSMA);
            	            	} else {
            	            		MainClass.worlds_c_place.add(worldSMA);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Break.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Protection.Construct.Break.World.All_World")) {
            	            for (String worldSMA : ConfigGlobal.getConfig().getStringList("Protection.Construct.Break.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldSMA) == null) {
            	            		sender.sendMessage("§4ERROR: §cConfig.yml, Protection.Construct.Break.World: "+worldSMA);
            	            	} else {
            	            		MainClass.worlds_c_break.add(worldSMA);
            	            	}
            	            }
            	        }
                    }

                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.Plugin-Reload")));
                }
            }
            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("UltimateSpawn") || cmd.getName().equalsIgnoreCase("Us") && p.hasPermission("UltimateSpawn.help")) {
            if ((args.length == 0) || (args[0].equalsIgnoreCase("help") && p.hasPermission("UltimateSpawn.help"))) {
            	p.sendMessage("§8//§7§m---------------§r§8\\\\ §3[§bUltimateSpawn§3] §8//§7§m---------------§r§8\\\\");
                p.sendMessage("");
                p.sendMessage("     §l>> §e§o§lGlobal Help");
                p.sendMessage("");
                p.sendMessage(" §8>> §7/setspawn - §eSet the spawn");
                p.sendMessage(" §8>> §7/spawn - §eGo to spawn");
                p.sendMessage(" §8>> §7/us reload - §eReload the plugin");
                p.sendMessage(" §8>> §7/cc - §bHelp of clearchat");
                p.sendMessage(" §8>> §7/bc - §eBroadcast ");
                p.sendMessage(" §8>> §7/ping - §ePing ");
                p.sendMessage(" §8>> §7/gmute - §eMute chat ");
                p.sendMessage(" §8>> §7/dchat [delay] - §eDelayChat ");
                p.sendMessage("");
                p.sendMessage("§8\\\\§7§m---------------§r§8// §3[§bUltimateSpawn§3] §8\\\\§7§m---------------§r§8//");
            } else if (args[0].equalsIgnoreCase("reload")) {
                if (p.hasPermission("UltimateSpawn.reload")) {
                    ConfigGlobal.reloadConfig();
                    ConfigMessage.reloadConfig();
                    ConfigSpawn.reloadConfig();

                    if (!Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
                    	ConfigGlobal.getConfig().set("Plugin.Use.PlaceholderAPI", Boolean.valueOf(false));
                    }
                    
                    MainClass.worlds_hunger.clear();
                    MainClass.worlds_damage.clear();
                    MainClass.worlds_weather.clear();
                    MainClass.worlds_burn_block.clear();
                    MainClass.worlds_explosions.clear();
                    MainClass.worlds_death_message.clear();
                    MainClass.worlds_spawning_mob_animals.clear();
                    MainClass.worlds_c_place.clear();
                    MainClass.worlds_c_break.clear();
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Hunger.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Hunger.World.All_World")) {
            	            for (String worldHunger : ConfigGlobal.getConfig().getStringList("Server.Disable.Hunger.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldHunger) == null) {
            	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Damage.World: "+worldHunger);
            	            		p.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Hunger.World: "+worldHunger);
            	            	} else {
            	            		MainClass.worlds_hunger.add(worldHunger);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Damage.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Damage.World.All_World")) {
            	            for (String worldDamage : ConfigGlobal.getConfig().getStringList("Server.Disable.Damage.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldDamage) == null) {
            	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Damage.World: "+worldDamage);
            	            		p.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Damage.World: "+worldDamage);
            	            	} else {
            	            		MainClass.worlds_damage.add(worldDamage);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Weather.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Weather.World.All_World")) {
            	            for (String worldWeather : ConfigGlobal.getConfig().getStringList("Server.Disable.Weather.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldWeather) == null) {
            	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Weather.World: "+worldWeather);
            	            		p.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Weather.World: "+worldWeather);
            	            	} else {
            	            		MainClass.worlds_hunger.add(worldWeather);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Burn-block.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Burn-block.World.All_World")) {
            	            for (String worldBurnBlock : ConfigGlobal.getConfig().getStringList("Server.Disable.Burn-block.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldBurnBlock) == null) {
            	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Burn-block.World: "+worldBurnBlock);
            	            		p.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Burn-block.World: "+worldBurnBlock);
            	            	} else {
            	            		MainClass.worlds_burn_block.add(worldBurnBlock);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Explosion.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Explosion.World.All_World")) {
            	            for (String worldExplosion : ConfigGlobal.getConfig().getStringList("Server.Disable.Explosion.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldExplosion) == null) {
            	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Explosion.World: "+worldExplosion);
            	            		p.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Explosion.World: "+worldExplosion);
            	            	} else {
            	            		MainClass.worlds_explosions.add(worldExplosion);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Death-Message.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Death-Message.World.All_World")) {
            	            for (String worldDM : ConfigGlobal.getConfig().getStringList("Server.Disable.Death-Message.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldDM) == null) {
            	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Death-Message.World: "+worldDM);
            	            		p.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Death-Message.World: "+worldDM);
            	            	} else {
            	            		MainClass.worlds_death_message.add(worldDM);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.World.All_World")) {
            	            for (String worldSMA : ConfigGlobal.getConfig().getStringList("Server.Disable.Spawning-Monster-Animals.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldSMA) == null) {
            	            		System.out.println("| Invalid world in Config.yml, Server.Disable.Spawning-Monster-Animals.World: "+worldSMA);
            	            		p.sendMessage("§4ERROR: §cConfig.yml, Server.Disable.Spawning-Monster-Animals.World: "+worldSMA);
            	            	} else {
            	            		MainClass.worlds_spawning_mob_animals.add(worldSMA);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Place.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Protection.Construct.Place.World.All_World")) {
            	            for (String worldSMA : ConfigGlobal.getConfig().getStringList("Protection.Construct.Place.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldSMA) == null) {
            	            		System.out.println("| Invalid world in Config.yml, Protection.Construct.Place.World: "+worldSMA);
            	            		p.sendMessage("§4ERROR: §cConfig.yml, Protection.Construct.Place.World: "+worldSMA);
            	            	} else {
            	            		MainClass.worlds_c_place.add(worldSMA);
            	            	}
            	            }
            	        }
                    }
                    
                    if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Break.Enable")) {
            	        if (!ConfigGlobal.getConfig().getBoolean("Protection.Construct.Break.World.All_World")) {
            	            for (String worldSMA : ConfigGlobal.getConfig().getStringList("Protection.Construct.Break.World.Worlds")) {
            	            	if (Bukkit.getWorld(worldSMA) == null) {
            	            		System.out.println("| Invalid world in Config.yml, Protection.Construct.Break.World: "+worldSMA);
            	            		p.sendMessage("§4ERROR: §cConfig.yml, Protection.Construct.Break.World: "+worldSMA);
            	            	} else {
            	            		MainClass.worlds_c_break.add(worldSMA);
            	            	}
            	            }
            	        }
                    }
                    
                    if ((sender instanceof Player)) {
                        Bukkit.getConsoleSender().sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Admin.Plugin-Reload")));
                    }
                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Admin.Plugin-Reload"), p);

                } else {
                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
                }

            }
        } else {
        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
        }
        return true;

    }

}
