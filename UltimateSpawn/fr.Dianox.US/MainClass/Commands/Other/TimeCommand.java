package fr.Dianox.US.MainClass.Commands.Other;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.command.ConfigCWeatherTime;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;
import fr.Dianox.US.MainClass.config.messages.ConfigMWeatherTime;

public class TimeCommand implements CommandExecutor {
	
	public TimeCommand() {}

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
		
		if (!(sender instanceof Player)) {
			for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Only-Player")) {
				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
			}
            return true;
		}
		
		Player p = (Player) sender;
		
		if (cmd.getName().equalsIgnoreCase("night")) {
			if (ConfigCWeatherTime.getConfig().getBoolean("Time.Set.Night.Enable")) {
				if (p.hasPermission("ultimatespawn.command.time.night")) {
					p.getWorld().setTime(ConfigCWeatherTime.getConfig().getLong("Time.Set.Night.Value"));
					if (ConfigMWeatherTime.getConfig().getBoolean("Time.Set.Night.Enable")) {
						for (String msg: ConfigMWeatherTime.getConfig().getStringList("Time.Set.Night.Message")) {
							PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						}
					}
				}
			} else {
				if (ConfigCWeatherTime.getConfig().getBoolean("Time.Set.Night.Disable-Message")) {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
	            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	            	}
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("day")) {
			if (ConfigCWeatherTime.getConfig().getBoolean("Time.Set.Day.Enable")) {
				if (p.hasPermission("ultimatespawn.command.time.day")) {
					p.getWorld().setTime(ConfigCWeatherTime.getConfig().getLong("Time.Set.Day.Value"));
					if (ConfigMWeatherTime.getConfig().getBoolean("Time.Set.Day.Enable")) {
						for (String msg: ConfigMWeatherTime.getConfig().getStringList("Time.Set.Day.Message")) {
							PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						}
					}
				}
			} else {
				if (ConfigCWeatherTime.getConfig().getBoolean("Time.Set.Day.Disable-Message")) {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
	            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	            	}
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("sun") || cmd.getName().equalsIgnoreCase("clear")) {
			if (ConfigCWeatherTime.getConfig().getBoolean("Weather.Set.Sun.Enable")) {
				if (p.hasPermission("ultimatespawn.command.weather.sun")) {
					p.getWorld().setThundering(false);
					p.getWorld().setStorm(false);
					if (ConfigMWeatherTime.getConfig().getBoolean("Weather.Set.Sun.Enable")) {
						for (String msg: ConfigMWeatherTime.getConfig().getStringList("Weather.Set.Sun.Message")) {
							PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						}
					}
				}
			} else {
				if (ConfigCWeatherTime.getConfig().getBoolean("Weather.Set.Sun.Disable-Message")) {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
	            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	            	}
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("rain")) {
			if (ConfigCWeatherTime.getConfig().getBoolean("Weather.Set.Rain.Enable")) {
				if (p.hasPermission("ultimatespawn.command.weather.rain")) {
					p.getWorld().setThundering(false);
					p.getWorld().setStorm(true);
					if (ConfigMWeatherTime.getConfig().getBoolean("Weather.Set.Rain.Enable")) {
						for (String msg: ConfigMWeatherTime.getConfig().getStringList("Weather.Set.Rain.Message")) {
							PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						}
					}
				}
			} else {
				if (ConfigCWeatherTime.getConfig().getBoolean("Weather.Set.Rain.Disable-Message")) {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
	            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	            	}
				}
			}
		}
		
		if (cmd.getName().equalsIgnoreCase("thunder")) {
			if (ConfigCWeatherTime.getConfig().getBoolean("Weather.Set.Thunder.Enable")) {
				if (p.hasPermission("ultimatespawn.command.weather.thunder")) {
					p.getWorld().setThundering(true);
					p.getWorld().setStorm(true);
					if (ConfigMWeatherTime.getConfig().getBoolean("Weather.Set.Thunder.Enable")) {
						for (String msg: ConfigMWeatherTime.getConfig().getStringList("Weather.Set.Thunder.Message")) {
							PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
						}
					}
				}
			} else {
				if (ConfigCWeatherTime.getConfig().getBoolean("Weather.Set.Thunder.Disable-Message")) {
					for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
	            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	            	}
				}
			}
		}
		
		return true;
	}
}
