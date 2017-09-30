package fr.Dianox.US.MainClass.Commands.Other;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigPlayerOptions;
import fr.Dianox.US.MainClass.config.command.ConfigCGlobal;

public class FlyCommand implements CommandExecutor {
	
	public FlyCommand() {}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
    	
        if (!(sender instanceof Player)) {
        	if (cmd.getName().equalsIgnoreCase("fly")) {
        		if ((args.length == 1)) {
        			Player target = Bukkit.getServer().getPlayer(args[0]);
        			if (target == null) {
                        sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
                        return true;
                    }
        			
        			UUID pT = target.getUniqueId();
        			
        			if (ConfigPlayerOptions.getConfig().getBoolean(pT+".Options.Fly.Enable")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), target);
                    	
                    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Disable").replaceAll("%target%", String.valueOf(target))));
                    	
	       				ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(false));
	       	        	ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Options.SetFlying", Boolean.valueOf(false));
	       	        	ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Options.SetAllowFlight", Boolean.valueOf(false));
	       				
	       	        	ConfigPlayerOptions.saveConfigFile();
	       	        	
	       	        	target.setAllowFlight(false);
	       	        	target.setFlying(false);
	       			} else {
	       				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), target);
                    	
	       				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Enable").replaceAll("%target%", String.valueOf(target))));
	       				
	       				ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(true));
	       	        	ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Options.SetFlying", Boolean.valueOf(true));
	       	        	ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Options.SetAllowFlight", Boolean.valueOf(true));
	       				
	       	        	ConfigPlayerOptions.saveConfigFile();
	       	        	
		       			target.setAllowFlight(true);
		       			target.setFlying(true);
	       			}
        		} else {
        			sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Arguments-Missing")));
        		}
        	}
            return true;
        }

        Player p = (Player) sender;
        UUID pU = p.getUniqueId();
        
        if (cmd.getName().equalsIgnoreCase("fly") && p.hasPermission("UltimateSpawn.fly")) {
            if ((args.length == 0)) {
                if (ConfigCGlobal.getConfig().getBoolean("Command.Fly.Self.Enable")) {
                    if (ConfigPlayerOptions.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), p);
                    	
	       				ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
	       	        	ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetFlying", Boolean.valueOf(false));
	       	        	ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetAllowFlight", Boolean.valueOf(false));
	       				
	       	        	ConfigPlayerOptions.saveConfigFile();
	       	        	
		       			p.setAllowFlight(false);
		       			p.setFlying(false);
	       			} else {
	       				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), p);
                    	
	       				ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(true));
	       	        	ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetFlying", Boolean.valueOf(true));
	       	        	ConfigPlayerOptions.getConfig().set(pU+".Options.Fly.Options.SetAllowFlight", Boolean.valueOf(true));
	       				
	       	        	ConfigPlayerOptions.saveConfigFile();
	       	        	
		       			p.setAllowFlight(true);
		       			p.setFlying(true);
	       			}
                } else {
                    if (ConfigCGlobal.getConfig().getBoolean("Command.Fly.Self.Disable-Message")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                    }
                }
            } else if ((args.length == 1)) {
            	if (ConfigCGlobal.getConfig().getBoolean("Command.Fly.Other.Enable")) {
	            	Player target = Bukkit.getServer().getPlayer(args[0]);
	    			if (target == null) {
	                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
	                    return true;
	                }
	    			
	    			UUID pT = target.getUniqueId();
	    			
	    			if (ConfigPlayerOptions.getConfig().getBoolean(pT+".Options.Fly.Enable")) {
	                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), target);
	                	
	                	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Disable").replaceAll("%target%", String.valueOf(target))));
	                	
	       				ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(false));
	       	        	ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Options.SetFlying", Boolean.valueOf(false));
	       	        	ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Options.SetAllowFlight", Boolean.valueOf(false));
	       				
	       	        	ConfigPlayerOptions.saveConfigFile();
	       	        	
	       	        	target.setAllowFlight(false);
	       	        	target.setFlying(false);
	       			} else {
	       				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), target);
	                	
	       				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Enable").replaceAll("%target%", String.valueOf(target))));
	       				
	       				ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(true));
	       	        	ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Options.SetFlying", Boolean.valueOf(true));
	       	        	ConfigPlayerOptions.getConfig().set(pT+".Options.Fly.Options.SetAllowFlight", Boolean.valueOf(true));
	       				
	       	        	ConfigPlayerOptions.saveConfigFile();
	       	        	
		       			target.setAllowFlight(true);
		       			target.setFlying(true);
	       			}
	            } else {
	            	if (ConfigCGlobal.getConfig().getBoolean("Command.Fly.Other.Disable-Message")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                    }
	            }
            } else {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Arguments-Missing"), p);
            }
        } else {
        	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
        }

        return true;
    }

}
