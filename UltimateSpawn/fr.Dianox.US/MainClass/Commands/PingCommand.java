package fr.Dianox.US.MainClass.Commands;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.Commands.Chat.DelaychatCommand;
import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.command.ConfigCPing;
import fr.Dianox.US.MainClass.config.messages.ConfigMPing;
import fr.Dianox.US.MainClass.config.messages.ConfigMPlugin;
import me.clip.placeholderapi.PlaceholderAPI;

public class PingCommand implements CommandExecutor {

    public PingCommand() {}

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String str, String[] args) {

        if (!(sender instanceof Player)) {

            if ((args.length == 0)) {
            	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Not-found")) {
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
            	}
                return true;
            } else if ((args.length == 1)) {
            	for (String msg: ConfigMPing.getConfig().getStringList("Ping.Other")) {
            		sender.sendMessage(ChatColor.translateAlternateColorCodes('&', msg.replaceAll("%ping%", ConfigMPing.getConfig().getString("Ping.Console-Trool")).replaceAll("%target%", args[0])));
            	}
            }

            return true;
        }

        Player p = (Player) sender;

        if (cmd.getName().equalsIgnoreCase("ping")) {
            if ((args.length == 0)) {
            	if (ConfigCPing.getConfig().getBoolean("Ping.Self.Use_Permission")) {
            		if (ConfigCPing.getConfig().getBoolean("Ping.Self.Enable")) {
            			if (p.hasPermission("ultimatespawn.command.ping.self")) {
            				for (String msg: ConfigMPing.getConfig().getStringList("Ping.Self")) {
            					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
            				}
            			} else {
            				for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
                        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
                        	}
            			}
            		} else {
            			if (ConfigCPing.getConfig().getBoolean("Ping.Self.Disable-Message")) {
            				for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
                        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
                        	}
            			}
            		}
            	} else {
            		if (ConfigCPing.getConfig().getBoolean("Ping.Self.Enable")) {
            			for (String msg: ConfigMPing.getConfig().getStringList("Ping.Self")) {
        					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
        				}
	                } else {
	                    if (ConfigCPing.getConfig().getBoolean("Ping.Self.Disable-Message")) {
	                    	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                    	}
	                    }
	                }
            	}
            } else if ((args.length == 1)) {
                Player other = Bukkit.getPlayer(args[0]);
                if (ConfigCPing.getConfig().getBoolean("Ping.Other.Use_Permission")) {
                	if (ConfigCPing.getConfig().getBoolean("Ping.Other.Enable")) {
                		if (p.hasPermission("ultimatespawn.command.ping.other")) {
                			if (other == null) {
                				for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Not-found")) {
                					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
                				}
                				return true;
                			}
                			if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
                				for (String msg: ConfigMPing.getConfig().getStringList("Ping.Other")) {
	                				p.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, msg)
			            					.replaceAll("%target%", other.getName())
			            					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
			            					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(other)))
			            					));
                				}
                			} else {
                				for (String msg: ConfigMPing.getConfig().getStringList("Ping.Other")) {
	                				p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg
			            					.replaceAll("%target%", other.getName())
			            					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
			            					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(other)))
			            					));
                				}
                			}
                		} else {
                			for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
                        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
                        	}
                		}
                	} else {
                		if (ConfigCPing.getConfig().getBoolean("Ping.Other.Disable-Message")) {
                			for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
                        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
                        	}
            			}
                	}
                } else {
                	if (ConfigCPing.getConfig().getBoolean("Ping.Other.Enable")) {
	                    if (other == null) {
	                    	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Player.Not-found")) {
            					PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
            				}
	                        return true;
	                    }
	            		if (ConfigGlobal.getConfig().getBoolean("Plugin.Use.PlaceholderAPI")) {
	            			for (String msg: ConfigMPing.getConfig().getStringList("Ping.Other")) {
		            			p.sendMessage(ChatColor.translateAlternateColorCodes('&', PlaceholderAPI.setPlaceholders(p, msg)
		            					.replaceAll("%target%", other.getName())
		            					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
		            					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(other)))
		            					));
	            			}
	            		} else {
	            			for (String msg: ConfigMPing.getConfig().getStringList("Ping.Other")) {
		            			p.sendMessage(ChatColor.translateAlternateColorCodes('&', msg
		            					.replaceAll("%target%", other.getName())
		            					.replaceAll("%DELAY%", String.valueOf(DelaychatCommand.delay))
		            					.replaceAll("%ping%", String.valueOf(PingCommand.getPing(other)))
		            					));
	            			}
	            		}
	                } else {
	                    if (ConfigCPing.getConfig().getBoolean("Ping.Other.Disable-Message")) {
	                    	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.Command-disable")) {
	                    		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
	                    	}
	                    }
	                }
                }
            }
        } else {
        	for (String msg: ConfigMPlugin.getConfig().getStringList("Error.No-Permission")) {
        		PlaceHolderMessageUtils.ReplaceCharMessagePlayer(msg, p);
        	}
        }

        return true;
    }

    public static int getPing(Player p) {
        String bpName = Bukkit.getServer().getClass().getPackage().getName();
        String version = bpName.substring(bpName.lastIndexOf(".") + 1, bpName.length());
        try {
          Class<?> CPClass = Class.forName("org.bukkit.craftbukkit." + version + ".entity.CraftPlayer");
          Object CraftPlayer = CPClass.cast(p);
          
          Method getHandle = CraftPlayer.getClass().getMethod("getHandle", new Class[0]);
          Object EntityPlayer = getHandle.invoke(CraftPlayer, new Object[0]);
          
          Field ping = EntityPlayer.getClass().getDeclaredField("ping");
          
          return ping.getInt(EntityPlayer);
        } catch (Exception e) {
          e.printStackTrace();
        }
        return 0;
    }

}
