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
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.command.ConfigCFly;

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
        			if (ConfigTemp.getConfig().getBoolean(pT+".Options.Fly.Enable")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), target);	
                    	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Disable").replaceAll("%target%", String.valueOf(target))));
                    	ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(false));
	       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(false));
	       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
	       	        	ConfigTemp.saveConfigFile();
	       	        	target.setAllowFlight(false);
	       	        	target.setFlying(false);
	       			} else {
	       				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), target);
	       				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Enable").replaceAll("%target%", String.valueOf(target))));
	       				ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(true));
	       				ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(true));
	       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
	       	        	ConfigTemp.saveConfigFile();
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
        
        if (cmd.getName().equalsIgnoreCase("fly")) {
            if ((args.length == 0)) {
                if (ConfigCFly.getConfig().getBoolean("Fly.Self.Enable")) {
                	if (ConfigCFly.getConfig().getBoolean("Fly.Self.Use_Permission")) {
	                	if (p.hasPermission("ultimatespawn.command.fly.self")) {
		                    if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
		                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), p);
		                    	
		                    	ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
			       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
			       	        	ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
			       				
			       	        	ConfigTemp.saveConfigFile();
			       	        	
				       			p.setAllowFlight(false);
				       			p.setFlying(false);
			       			} else {
			       				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), p);
		                    	
			       				ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(true));
			       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(true));
			       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
			       				
			       				ConfigTemp.saveConfigFile();
			       	        	
				       			p.setAllowFlight(true);
				       			p.setFlying(true);
			       			}
	                	} else {
	                		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
	                	}
                	} else {
                		if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
	                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), p);
	                    	
	                    	ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
		       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
		       	        	ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
		       				
		       	        	ConfigTemp.saveConfigFile();
		       	        	
			       			p.setAllowFlight(false);
			       			p.setFlying(false);
		       			} else {
		       				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), p);
	                    	
		       				ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(true));
		       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(true));
		       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
		       				
		       				ConfigTemp.saveConfigFile();
		       	        	
			       			p.setAllowFlight(true);
			       			p.setFlying(true);
		       			}
                	}
                } else {
                    if (ConfigCFly.getConfig().getBoolean("Fly.Self.Disable-Message")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
                    }
                }
            } else if ((args.length == 1)) {
            	if (ConfigCFly.getConfig().getBoolean("Fly.Other.Enable")) {
            		if (ConfigCFly.getConfig().getBoolean("Fly.Other.Use_Permission")) {
            			if (p.hasPermission("ultimatespawn.command.fly.other")) {
			            	Player target = Bukkit.getServer().getPlayer(args[0]);
			    			if (target == null) {
			                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
			                    return true;
			                }
			    			
			    			UUID pT = target.getUniqueId();
			    			
			    			if (ConfigTemp.getConfig().getBoolean(pT+".Options.Fly.Enable")) {
			                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), target);
			                	
			                	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Disable").replaceAll("%target%", String.valueOf(target))));
			                	
			                	ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(false));
			                	ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(false));
			       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
			       				
			       	        	ConfigTemp.saveConfigFile();
			       	        	
			       	        	target.setAllowFlight(false);
			       	        	target.setFlying(false);
			       			} else {
			       				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), target);
			                	
			       				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Enable").replaceAll("%target%", String.valueOf(target))));
			       				
			       				ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(true));
			       				ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(true));
			       				ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
			       				
			       				ConfigTemp.saveConfigFile();
			       	        	
				       			target.setAllowFlight(true);
				       			target.setFlying(true);
			       			}
            			} else {
            				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.No-permission"), p);
            			}
            		} else {
            			Player target = Bukkit.getServer().getPlayer(args[0]);
		    			if (target == null) {
		                    sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Error.Player.Not-found")));
		                    return true;
		                }
		    			
		    			UUID pT = target.getUniqueId();
		    			
		    			if (ConfigTemp.getConfig().getBoolean(pT+".Options.Fly.Enable")) {
		                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Disable"), target);
		                	
		                	sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Disable").replaceAll("%target%", String.valueOf(target))));
		                	
		                	ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(false));
		                	ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(false));
		       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
		       				
		       	        	ConfigTemp.saveConfigFile();
		       	        	
		       	        	target.setAllowFlight(false);
		       	        	target.setFlying(false);
		       			} else {
		       				PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Others.Fly.Self.Enable"), target);
		                	
		       				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', ConfigMessage.getConfig().getString("Others.Fly.Other.Enable").replaceAll("%target%", String.valueOf(target))));
		       				
		       				ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(true));
		       				ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(true));
		       				ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
		       				
		       				ConfigTemp.saveConfigFile();
		       	        	
			       			target.setAllowFlight(true);
			       			target.setFlying(true);
		       			}
            		}
	            } else {
	            	if (ConfigCFly.getConfig().getBoolean("Fly.Other.Disable-Message")) {
                    	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Command-disable"), p);
	            	}
	            }
            } else {
            	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Arguments-Missing"), p);
            }
        }

        return true;
    }

}
