package fr.Dianox.US.MainClass.Commands.Other;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.command.ConfigCFly;
import fr.Dianox.US.MainClass.config.messages.ConfigMFly;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;

public class FlyCommand implements CommandExecutor {
	
	public FlyCommand() {}
	
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {
    	
        if (!(sender instanceof Player)) {
        	if (cmd.getName().equalsIgnoreCase("fly")) {
        		if ((args.length == 1)) {
        			Player target = Bukkit.getServer().getPlayer(args[0]);
        			if (target == null) {
        				for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Not-Found")) {
        					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
        				}
                        return true;
                    }
        			UUID pT = target.getUniqueId();
        			if (ConfigTemp.getConfig().getBoolean(pT+".Options.Fly.Enable")) {
                    	for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, target);
            			}
                    	for (String msg: ConfigMFly.getConfig().getStringList("Fly.Other.Disable")) {
                    		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg.replaceAll("%target%", String.valueOf(target))));
                    	}
                    	ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(false));
	       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(false));
	       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
	       	        	ConfigTemp.saveConfigFile();
	       	        	target.setAllowFlight(false);
	       	        	target.setFlying(false);
	       			} else {
	       				for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Enable")) {
                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, target);
            			}
                    	for (String msg: ConfigMFly.getConfig().getStringList("Fly.Other.Enable")) {
                    		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg.replaceAll("%target%", String.valueOf(target))));
                    	}
                    	ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(true));
	       				ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(true));
	       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
	       	        	ConfigTemp.saveConfigFile();
		       			target.setAllowFlight(true);
		       			target.setFlying(true);
	       			}
        		} else {
        			for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Arguments-Missing")) {
        				sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	            	}
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
		                    	for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
		                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
		            			}
		                    	
		                    	ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
			       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
			       	        	ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
			       				
			       	        	ConfigTemp.saveConfigFile();
			       	        	
				       			p.setAllowFlight(false);
				       			p.setFlying(false);
			       			} else {
			       				for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Enable")) {
		                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
		            			}
		                    	
			       				ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(true));
			       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(true));
			       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
			       				
			       				ConfigTemp.saveConfigFile();
			       	        	
				       			p.setAllowFlight(true);
				       			p.setFlying(true);
			       			}
	                	} else {
	                		for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                    	}
	                	}
                	} else {
                		if (ConfigTemp.getConfig().getBoolean(pU+".Options.Fly.Enable")) {
                			for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	            			}
	                    	
	                    	ConfigTemp.getConfig().set(pU+".Options.Fly.Enable", Boolean.valueOf(false));
		       				ConfigTemp.getConfig().set(pU+".Options.Fly.SetFlying", Boolean.valueOf(false));
		       	        	ConfigTemp.getConfig().set(pU+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
		       				
		       	        	ConfigTemp.saveConfigFile();
		       	        	
			       			p.setAllowFlight(false);
			       			p.setFlying(false);
		       			} else {
		       				for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Enable")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	            			}
	                    	
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
                    	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
    	            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
    	            	}
                    }
                }
            } else if ((args.length == 1)) {
            	if (ConfigCFly.getConfig().getBoolean("Fly.Other.Enable")) {
            		if (ConfigCFly.getConfig().getBoolean("Fly.Other.Use_Permission")) {
            			if (p.hasPermission("ultimatespawn.command.fly.other")) {
			            	Player target = Bukkit.getServer().getPlayer(args[0]);
			    			if (target == null) {
			    				for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Not-Found")) {
		        					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
		        				}
			                    return true;
			                }
			    			
			    			UUID pT = target.getUniqueId();
			    			
			    			if (ConfigTemp.getConfig().getBoolean(pT+".Options.Fly.Enable")) {
			                	for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
		                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, target);
		            			}
			                	
			                	for (String msg: ConfigMFly.getConfig().getStringList("Fly.Other.Disable")) {
		                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg.replaceAll("%target%", String.valueOf(target)), p);
		            			}
			                	
			                	ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(false));
			                	ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(false));
			       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
			       				
			       	        	ConfigTemp.saveConfigFile();
			       	        	
			       	        	target.setAllowFlight(false);
			       	        	target.setFlying(false);
			       			} else {
			       				for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Enable")) {
		                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, target);
		            			}
			                	
			       				for (String msg: ConfigMFly.getConfig().getStringList("Fly.Other.Enable")) {
		                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg.replaceAll("%target%", String.valueOf(target)), p);
		            			}
			       				
			       				ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(true));
			       				ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(true));
			       				ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(true));
			       				
			       				ConfigTemp.saveConfigFile();
			       	        	
				       			target.setAllowFlight(true);
				       			target.setFlying(true);
			       			}
            			} else {
            				for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                    	}
            			}
            		} else {
            			Player target = Bukkit.getServer().getPlayer(args[0]);
		    			if (target == null) {
		    				for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Not-Found")) {
	        					sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
	        				}
		                    return true;
		                }
		    			
		    			UUID pT = target.getUniqueId();
		    			
		    			if (ConfigTemp.getConfig().getBoolean(pT+".Options.Fly.Enable")) {
		    				for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Disable")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, target);
	            			}
		                	
		                	for (String msg: ConfigMFly.getConfig().getStringList("Fly.Other.Disable")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg.replaceAll("%target%", String.valueOf(target)), p);
	            			}
		                	
		                	ConfigTemp.getConfig().set(pT+".Options.Fly.Enable", Boolean.valueOf(false));
		                	ConfigTemp.getConfig().set(pT+".Options.Fly.SetFlying", Boolean.valueOf(false));
		       	        	ConfigTemp.getConfig().set(pT+".Options.Fly.SetAllowFlight", Boolean.valueOf(false));
		       				
		       	        	ConfigTemp.saveConfigFile();
		       	        	
		       	        	target.setAllowFlight(false);
		       	        	target.setFlying(false);
		       			} else {
		       				for (String msg: ConfigMFly.getConfig().getStringList("Fly.Self.Enable")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, target);
	            			}
		                	
		       				for (String msg: ConfigMFly.getConfig().getStringList("Fly.Other.Enable")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg.replaceAll("%target%", String.valueOf(target)), p);
	            			}
		       				
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
	            		for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
		            		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
		            	}
	            	}
	            }
            } else {
            	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Arguments-Missing")) {
					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
            	}
            }
        }

        return true;
    }

}
