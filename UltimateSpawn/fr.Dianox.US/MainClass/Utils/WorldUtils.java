package fr.Dianox.US.MainClass.Utils;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.Bukkit;

import fr.Dianox.US.MainClass.config.event.ConfigEColorSign;
import fr.Dianox.US.MainClass.config.event.ConfigEVoidTP;
import fr.Dianox.US.MainClass.config.event.CWE.ConfigCWEGM;
import fr.Dianox.US.MainClass.config.event.CWE.ConfigCWEKeepFly;
import fr.Dianox.US.MainClass.config.fun.ConfigFDoubleJump;
import fr.Dianox.US.MainClass.config.fun.ConfigFJumpad;
import fr.Dianox.US.MainClass.config.global.ConfigGActionBar;
import fr.Dianox.US.MainClass.config.global.ConfigGCos;
import fr.Dianox.US.MainClass.config.global.ConfigGDoubleJump;
import fr.Dianox.US.MainClass.config.global.ConfigGFly;
import fr.Dianox.US.MainClass.config.global.ConfigGGM;
import fr.Dianox.US.MainClass.config.global.ConfigGHF;
import fr.Dianox.US.MainClass.config.global.ConfigGInventory;
import fr.Dianox.US.MainClass.config.global.ConfigGJoinCommand;
import fr.Dianox.US.MainClass.config.global.ConfigGMessage;
import fr.Dianox.US.MainClass.config.global.ConfigGMessageQ;
import fr.Dianox.US.MainClass.config.global.ConfigGPlayerItems;
import fr.Dianox.US.MainClass.config.global.ConfigGProtection;
import fr.Dianox.US.MainClass.config.global.ConfigGQuitCommand;
import fr.Dianox.US.MainClass.config.global.ConfigGServerEvent;
import fr.Dianox.US.MainClass.config.global.ConfigGTitle;
import fr.Dianox.US.MainClass.config.global.ConfigGXP;

public class WorldUtils {
	
	public static List<String> worlds_damage = new ArrayList<String>();
	public static List<String> worlds_hunger = new ArrayList<String>();
	public static List<String> worlds_weather = new ArrayList<String>();
	public static List<String> worlds_ThunderChange = new ArrayList<String>();
	public static List<String> worlds_burn_block = new ArrayList<String>();
	public static List<String> worlds_firespread = new ArrayList<String>();
	public static List<String> worlds_explosions = new ArrayList<String>();
	public static List<String> worlds_death_message = new ArrayList<String>();
	public static List<String> worlds_spawning_mob_animals = new ArrayList<String>();
	public static List<String> worlds_c_place = new ArrayList<String>();
	public static List<String> worlds_c_break = new ArrayList<String>();
	public static List<String> worlds_XP_Exp = new ArrayList<String>();
	public static List<String> worlds_XP_Lvl = new ArrayList<String>();
	public static List<String> worlds_Fly = new ArrayList<String>();
	public static List<String> worlds_Fly_KeepOnChangeWorld = new ArrayList<String>();
	public static List<String> worlds_GM = new ArrayList<String>();
	public static List<String> worlds_GM_OnChangeWorld = new ArrayList<String>();
	public static List<String> worlds_Food = new ArrayList<String>();
	public static List<String> worlds_Health = new ArrayList<String>();
	public static List<String> worlds_firework = new ArrayList<String>();
	public static List<String> worlds_sounds_join = new ArrayList<String>();
	public static List<String> worlds_force_selected_slot = new ArrayList<String>();
	public static List<String> worlds_inventory = new ArrayList<String>();
	public static List<String> worlds_first_join_title = new ArrayList<String>();
	public static List<String> worlds_join_title = new ArrayList<String>();
	public static List<String> worlds_message_join = new ArrayList<String>();
	public static List<String> worlds_broadcast_message_join = new ArrayList<String>();
	public static List<String> worlds_message_newjoin = new ArrayList<String>();
	public static List<String> worlds_broadcast_message_newjoin = new ArrayList<String>();
	public static List<String> worlds_clear_chat = new ArrayList<String>();
	public static List<String> worlds_broadcast_quit = new ArrayList<String>();
	public static List<String> worlds_item_drop = new ArrayList<String>();
	public static List<String> worlds_item_pickup = new ArrayList<String>();
	public static List<String> worlds_item_damageitem = new ArrayList<String>();
	public static List<String> worlds_item_clearondrop = new ArrayList<String>();
	public static List<String> worlds_item_move = new ArrayList<String>();
	public static List<String> worlds_jumppads = new ArrayList<String>();
	public static List<String> worlds_voidTP = new ArrayList<String>();
	public static List<String> worlds_ColorSign = new ArrayList<String>();
	public static List<String> worlds_LeaveDecay = new ArrayList<String>();
	public static List<String> worlds_LightningStrike = new ArrayList<String>();
	public static List<String> worlds_BlockFade = new ArrayList<String>();
	public static List<String> worlds_HagingBreakByEntity = new ArrayList<String>();
	public static List<String> worlds_PlayerInteractEntity_ItemFrame = new ArrayList<String>();
	public static List<String> worlds_ActionBar_Join = new ArrayList<String>();
	public static List<String> worlds_JoinCommands_Player_New = new ArrayList<String>();
	public static List<String> worlds_JoinCommands_Player_No_New = new ArrayList<String>();
	public static List<String> worlds_JoinCommands_Console_New = new ArrayList<String>();
	public static List<String> worlds_JoinCommands_Console_No_New = new ArrayList<String>();
	public static List<String> worlds_QuitCommands_Console = new ArrayList<String>();
	public static List<String> worlds_fun_infinitejump = new ArrayList<String>();
	public static List<String> worlds_fun_fivejump = new ArrayList<String>();
	public static List<String> worlds_fun_forjump = new ArrayList<String>();
	public static List<String> worlds_fun_threejump  = new ArrayList<String>();
	public static List<String> worlds_fun_doublejump  = new ArrayList<String>();
	public static List<String> worlds_fun_doublejump_onjoin  = new ArrayList<String>();
	
	public static void setWGetDoubleJumpOnJoin() {
		if (ConfigGDoubleJump.getConfig().getBoolean("DoubleJump.Enable")) {
	        if (!ConfigGDoubleJump.getConfig().getBoolean("DoubleJump.World.All_World")) {
	            for (String world : ConfigGDoubleJump.getConfig().getStringList("DoubleJump.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in DoubleJump-OnJoin.yml, DoubleJump.World: "+world);
	            	} else {
	            		worlds_fun_doublejump_onjoin.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetFunInfiniteJump() {
		if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.Enable")) {
	        if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Infinite.World.All_World")) {
	            for (String world : ConfigFDoubleJump.getConfig().getStringList("DoubleJump.Infinite.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in DoubleJump.yml, DoubleJump.Infinite.World: "+world);
	            	} else {
	            		worlds_fun_infinitejump.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetFunFivefoldJump() {
		if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.Enable")) {
	        if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Fivefold.World.All_World")) {
	            for (String world : ConfigFDoubleJump.getConfig().getStringList("DoubleJump.Fivefold.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in DoubleJump.yml, DoubleJump.Fivefold.World: "+world);
	            	} else {
	            		worlds_fun_fivejump.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetFunTripleJump() {
		if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.Enable")) {
	        if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Triple.World.All_World")) {
	            for (String world : ConfigFDoubleJump.getConfig().getStringList("DoubleJump.Triple.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in DoubleJump.yml, DoubleJump.Triple.World: "+world);
	            	} else {
	            		worlds_fun_threejump.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetFunDoubleJump() {
		if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.Enable")) {
	        if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Double.World.All_World")) {
	            for (String world : ConfigFDoubleJump.getConfig().getStringList("DoubleJump.Double.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in DoubleJump.yml, DoubleJump.Double.World: "+world);
	            	} else {
	            		worlds_fun_doublejump.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetFunQuadrupleJump() {
		if (ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.Enable")) {
	        if (!ConfigFDoubleJump.getConfig().getBoolean("DoubleJump.Quadruple.World.All_World")) {
	            for (String world : ConfigFDoubleJump.getConfig().getStringList("DoubleJump.Quadruple.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in DoubleJump.yml, DoubleJump.Quadruple.World: "+world);
	            	} else {
	            		worlds_fun_forjump.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldJoinCommandPlayerNew() {
		if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.New.JoinCommand-Player.Enable")) {
	        if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.New.JoinCommand-Player.World.All_World")) {
	            for (String worldHunger : ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.New.JoinCommand-Player.World.Worlds")) {
	            	if (Bukkit.getWorld(worldHunger) == null) {
	            		System.out.println("| Invalid world in JoinCommand.yml, JoinCommand.Options.New.JoinCommand-Player.World: "+worldHunger);
	            	} else {
	            		worlds_JoinCommands_Player_New.add(worldHunger);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldQuitCommandConsole() {
		if (ConfigGQuitCommand.getConfig().getBoolean("QuitCommand.Enable")) {
	        if (!ConfigGQuitCommand.getConfig().getBoolean("QuitCommand.QuitCommand-Console.World.All_World")) {
	            for (String worldHunger : ConfigGQuitCommand.getConfig().getStringList("QuitCommand.QuitCommand-Console.World.Worlds")) {
	            	if (Bukkit.getWorld(worldHunger) == null) {
	            		System.out.println("| Invalid world in QuitCommand.yml, QuitCommand.QuitCommand-Console.World: "+worldHunger);
	            	} else {
	            		worlds_QuitCommands_Console.add(worldHunger);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldJoinCommandPlayerNoNew() {
		if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Player.Enable")) {
	        if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Player.World.All_World")) {
	            for (String worldHunger : ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Player.World.Worlds")) {
	            	if (Bukkit.getWorld(worldHunger) == null) {
	            		System.out.println("| Invalid world in JoinCommand.yml, JoinCommand.Options.No-New.JoinCommand-Player.World: "+worldHunger);
	            	} else {
	            		worlds_JoinCommands_Player_No_New.add(worldHunger);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldJoinCommandConsoleNew() {
		if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.New.JoinCommand-Console.Enable")) {
	        if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.New.JoinCommand-Console.World.All_World")) {
	            for (String worldHunger : ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.New.JoinCommand-Console.World.Worlds")) {
	            	if (Bukkit.getWorld(worldHunger) == null) {
	            		System.out.println("| Invalid world in JoinCommand.yml, JoinCommand.Options.New.JoinCommand-Console.World: "+worldHunger);
	            	} else {
	            		worlds_JoinCommands_Console_New.add(worldHunger);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldJoinCommandConsoleNoNew() {
		if (ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Console.Enable")) {
	        if (!ConfigGJoinCommand.getConfig().getBoolean("JoinCommand.Options.No-New.JoinCommand-Console.World.All_World")) {
	            for (String worldHunger : ConfigGJoinCommand.getConfig().getStringList("JoinCommand.Options.No-New.JoinCommand-Console.World.Worlds")) {
	            	if (Bukkit.getWorld(worldHunger) == null) {
	            		System.out.println("| Invalid world in JoinCommand.yml, JoinCommand.Options.No-New.JoinCommand-Console.World: "+worldHunger);
	            	} else {
	            		worlds_JoinCommands_Console_No_New.add(worldHunger);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldServerDisableHunger() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Hunger.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Hunger.World.All_World")) {
	            for (String worldHunger : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Hunger.World.Worlds")) {
	            	if (Bukkit.getWorld(worldHunger) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Hunger.World: "+worldHunger);
	            	} else {
	            		worlds_hunger.add(worldHunger);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldServerDisableDamage() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Damage.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Damage.World.All_World")) {
	            for (String worldDamage : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Damage.World.Worlds")) {
	            	if (Bukkit.getWorld(worldDamage) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Damage.World: "+worldDamage);
	            	} else {
	            		worlds_damage.add(worldDamage);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldServerDisableWeather() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Weather.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Weather.World.All_World")) {
	            for (String worldWeather : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Weather.World.Worlds")) {
	            	if (Bukkit.getWorld(worldWeather) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Weather.World: "+worldWeather);
	            	} else {
	            		worlds_weather.add(worldWeather);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldServerDisableBurnBlock() {
		if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Burn-block.World.All_World")) {
            for (String worldBurnblock : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Burn-block.World.Worlds")) {
            	if (Bukkit.getWorld(worldBurnblock) == null) {
            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Burn-block.World: "+worldBurnblock);
            	} else {
            		worlds_burn_block.add(worldBurnblock);
            	}
            }
        }
	}
	
	public static void setWGetWorldServerDisableExplosion() {
		if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Explosion.World.All_World")) {
            for (String worldExplosion : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Explosion.World.Worlds")) {
            	if (Bukkit.getWorld(worldExplosion) == null) {
            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Explosion.World: "+worldExplosion);
            	} else {
            		worlds_explosions.add(worldExplosion);
            	}
            }
        }
	}
	
	public static void setWGetWorldServerDisableDeathMessage() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Death-Message.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Death-Message.World.All_World")) {
	            for (String worldDM : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Death-Message.World.Worlds")) {
	            	if (Bukkit.getWorld(worldDM) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Death-Message.World: "+worldDM);
	            	} else {
	            		worlds_death_message.add(worldDM);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldServerDisableSpawningMobAnimals() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals.World.All_World")) {
	            for (String worldSMA : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Spawning-Monster-Animals.World.Worlds")) {
	            	if (Bukkit.getWorld(worldSMA) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Spawning-Monster-Animals.World: "+worldSMA);
	            	} else {
	            		worlds_spawning_mob_animals.add(worldSMA);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldProtectionPlace() {
		if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.Enable")) {
	        if (!ConfigGProtection.getConfig().getBoolean("Protection.Construct.Place.World.All_World")) {
	            for (String world : ConfigGProtection.getConfig().getStringList("Protection.Construct.Place.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-Protection.yml, Protection.Construct.Place.World: "+world);
	            	} else {
	            		worlds_c_place.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldProtectionBreak() {
		if (ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.Enable")) {
	        if (!ConfigGProtection.getConfig().getBoolean("Protection.Construct.Break.World.All_World")) {
	            for (String world : ConfigGProtection.getConfig().getStringList("Protection.Construct.Break.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-Protection.yml, Protection.Construct.Break.World: "+world);
	            	} else {
	            		worlds_c_break.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldResetExperience() {
		if (ConfigGXP.getConfig().getBoolean("XP.Options.Exp.Enable")) {
	        if (!ConfigGXP.getConfig().getBoolean("XP.Options.Exp.World.All_World")) {
	            for (String world : ConfigGXP.getConfig().getStringList("XP.Options.Exp.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Experience-OnJoin-config.yml, XP.Options.Exp.World: "+world);
	            	} else {
	            		worlds_XP_Exp.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldResetLevel() {
		if (ConfigGXP.getConfig().getBoolean("XP.Options.Level.Enable")) {
	        if (!ConfigGXP.getConfig().getBoolean("XP.Options.Level.World.All_World")) {
	            for (String world : ConfigGXP.getConfig().getStringList("XP.Options.Level.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Experience-OnJoin.yml, XP.Options.Level.World: "+world);
	            	} else {
	            		worlds_XP_Lvl.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldFly() {
		if (ConfigGFly.getConfig().getBoolean("Fly.Enable")) {
	        if (!ConfigGFly.getConfig().getBoolean("Fly.World.All_World")) {
	            for (String world : ConfigGFly.getConfig().getStringList("Fly.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Fly-OnJoin.yml, Fly.World: "+world);
	            	} else {
	            		worlds_Fly.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldGamemode() {
		if (ConfigGGM.getConfig().getBoolean("Gamemode.Enable")) {
	        if (!ConfigGGM.getConfig().getBoolean("Gamemode.World.All_World")) {
	            for (String world : ConfigGGM.getConfig().getStringList("Gamemode.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Gamemode-OnJoin.yml, Gamemode.World: "+world);
	            	} else {
	            		worlds_GM.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldFood() {
		if (ConfigGHF.getConfig().getBoolean("Restore.Food.Enable")) {
	        if (!ConfigGHF.getConfig().getBoolean("Restore.Food.World.All_World")) {
	            for (String world : ConfigGHF.getConfig().getStringList("Restore.Food.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Health-Food-OnJoin.yml, Restore.Food.World: "+world);
	            	} else {
	            		worlds_Food.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldHealth() {
		if (ConfigGHF.getConfig().getBoolean("Restore.Health.Enable")) {
	        if (!ConfigGHF.getConfig().getBoolean("Restore.Health.World.All_World")) {
	            for (String world : ConfigGHF.getConfig().getStringList("Restore.Health.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Health-Food-OnJoin.yml, Restore.Health.World: "+world);
	            	} else {
	            		worlds_Health.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldFirework() {
		if (ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.Enable")) {
	        if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Firework.World.All_World")) {
	            for (String world : ConfigGCos.getConfig().getStringList("Cosmetics.Firework.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Cosmetics-OnJoin.yml, Cosmetics.Firework.World: "+world);
	            	} else {
	            		worlds_firework.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldSoundJoin() {
		if (ConfigGCos.getConfig().getBoolean("Cosmetics.Sounds.Enable")) {
	        if (!ConfigGCos.getConfig().getBoolean("Cosmetics.Sounds.World.All_World")) {
	            for (String world : ConfigGCos.getConfig().getStringList("Cosmetics.Sounds.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Cosmetics-OnJoin.yml, Cosmetics.Sounds.World: "+world);
	            	} else {
	            		worlds_sounds_join.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldForceSelectedJoin() {
		if (ConfigGInventory.getConfig().getBoolean("Inventory.Force-Selected-Slot.Enable")) {
	        if (!ConfigGInventory.getConfig().getBoolean("Inventory.Force-Selected-Slot.World.All_World")) {
	            for (String world : ConfigGInventory.getConfig().getStringList("Inventory.Force-Selected-Slot.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Inventory-OnJoin.yml, Inventory.Force-Selected-Slot.World: "+world);
	            	} else {
	            		worlds_force_selected_slot.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldInventory() {
		if (ConfigGInventory.getConfig().getBoolean("Inventory.Clear.Enable")) {
	        if (!ConfigGInventory.getConfig().getBoolean("Inventory.Clear.World.All_World")) {
	            for (String world : ConfigGInventory.getConfig().getStringList("Inventory.Clear.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Inventory-OnJoin.yml, Inventory.Clear.World: "+world);
	            	} else {
	            		worlds_inventory.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldFirstJoinTitle() {
		if (ConfigGTitle.getConfig().getBoolean("Title.First-Join.Enable")) {
	        if (!ConfigGTitle.getConfig().getBoolean("Title.First-Join.World.All_World")) {
	            for (String world : ConfigGTitle.getConfig().getStringList("Title.First-Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Title-OnJoin.yml, Title.First-Join.World: "+world);
	            	} else {
	            		worlds_first_join_title.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldJoinTitle() {
        if (ConfigGTitle.getConfig().getBoolean("Title.Join.Enable")) {
	        if (!ConfigGTitle.getConfig().getBoolean("Title.Join.World.All_World")) {
	            for (String world : ConfigGTitle.getConfig().getStringList("Title.Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Title-OnJoin.yml, Title.Join.World: "+world);
	            	} else {
	            		worlds_join_title.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldMessageOnJoin() {
		if (ConfigGMessage.getConfig().getBoolean("Message.Join.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Message.Join.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Message.Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Message.Join.World: "+world);
	            	} else {
	            		worlds_message_join.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldBroadcastJoin() {
		if (ConfigGMessage.getConfig().getBoolean("Broadcast.Join.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Broadcast.Join.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Broadcast.Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Broadcast.Join.World: "+world);
	            	} else {
	            		worlds_broadcast_message_join.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldFirstJoinMessageOnJoin() {
		if (ConfigGMessage.getConfig().getBoolean("Message.First-Join.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Message.First-Join.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Message.First-Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Message.First-Join.World: "+world);
	            	} else {
	            		worlds_message_newjoin.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldBroadcastNewJoin() {
		if (ConfigGMessage.getConfig().getBoolean("Broadcast.First-Join.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Broadcast.First-Join.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Broadcast.First-Join.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Broadcast.First-Join.World: "+world);
	            	} else {
	            		worlds_broadcast_message_newjoin.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldClearChat() {
		if (ConfigGMessage.getConfig().getBoolean("Chat.Clear.Enable")) {
	        if (!ConfigGMessage.getConfig().getBoolean("Chat.Clear.World.All_World")) {
	            for (String world : ConfigGMessage.getConfig().getStringList("Chat.Clear.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-Chat-OnJoin.yml, Chat.Clear.World: "+world);
	            	} else {
	            		worlds_clear_chat.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldBroadcastQuit() {
		if (ConfigGMessageQ.getConfig().getBoolean("Broadcast.Quit.Enable")) {
	        if (!ConfigGMessageQ.getConfig().getBoolean("Broadcast.Quit.World.All_World")) {
	            for (String world : ConfigGMessageQ.getConfig().getStringList("Broadcast.Quit.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Messages-OnQuit.yml, Broadcast.Quit.World: "+world);
	            	} else {
	            		worlds_broadcast_quit.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldItemDrop() {
		if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Drop.Disable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Drop.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.Drop.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.Drop.World: "+world);
	            	} else {
	            		worlds_item_drop.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldItemPickUP() {
		if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.PickUp.Disable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.PickUp.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.PickUp.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.PickUp.World: "+world);
	            	} else {
	            		worlds_item_pickup.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldItemDamage() {
		if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Damage-Item.Disable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Damage-Item.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.Damage-Item.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.Damage-Item.World: "+world);
	            	} else {
	            		worlds_item_damageitem.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldClearDropOnDeath() {
		if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.Enable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.Clear-Drops-On-Death.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.Clear-Drops-On-Death.World: "+world);
	            	} else {
	            		worlds_item_clearondrop.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldMoveItem() {
		if (ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Move.Disable")) {
	        if (!ConfigGPlayerItems.getConfig().getBoolean("Server.Items.Move.World.All_World")) {
	            for (String world : ConfigGPlayerItems.getConfig().getStringList("Server.Items.Move.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-PlayersItems.yml, Server.Items.Move.World: "+world);
	            	} else {
	            		worlds_item_move.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldJumpPads() {
		if (ConfigFJumpad.getConfig().getBoolean("JumpPads.Enable")) {
	        if (!ConfigFJumpad.getConfig().getBoolean("JumpPads.World.All_World")) {
	            for (String worldWeather : ConfigFJumpad.getConfig().getStringList("JumpPads.World.Worlds")) {
	            	if (Bukkit.getWorld(worldWeather) == null) {
	            		System.out.println("| Invalid world in JumpPads.yml, JumpPads.World: "+worldWeather);
	            	} else {
	            		worlds_jumppads.add(worldWeather);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldEventVoidTP() {
		if (ConfigEVoidTP.getConfig().getBoolean("VoidTP.Enable")) {
	        if (!ConfigEVoidTP.getConfig().getBoolean("VoidTP.World.All_World")) {
	            for (String world : ConfigEVoidTP.getConfig().getStringList("VoidTP.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in VoidTP.yml, VoidTP.World: "+world);
	            	} else {
	            		worlds_voidTP.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldEventColorSign() {
		if (ConfigEColorSign.getConfig().getBoolean("ColorSign.Enable")) {
	        if (!ConfigEColorSign.getConfig().getBoolean("ColorSign.World.All_World")) {
	            for (String world : ConfigEColorSign.getConfig().getStringList("ColorSign.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in ColorSign.yml, ColorSign.World: "+world);
	            	} else {
	            		worlds_ColorSign.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldServerDisableLeaveDecay() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Leave-Decay.Disable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Leave-Decay.World.All_World")) {
	            for (String worldSMA : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Leave-Decay.World.Worlds")) {
	            	if (Bukkit.getWorld(worldSMA) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Leave-Decay.World: "+worldSMA);
	            	} else {
	            		worlds_LeaveDecay.add(worldSMA);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldServerDisableLightningStrike() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.LightningStrike.Disable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.LightningStrike.World.All_World")) {
	            for (String worldSMA : ConfigGServerEvent.getConfig().getStringList("Server.Disable.LightningStrike.World.Worlds")) {
	            	if (Bukkit.getWorld(worldSMA) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.LightningStrike.World: "+worldSMA);
	            	} else {
	            		worlds_LightningStrike.add(worldSMA);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldServerDisableblockFade() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Block-Fade.Disable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.Block-Fade.World.All_World")) {
	            for (String worldSMA : ConfigGServerEvent.getConfig().getStringList("Server.Disable.Block-Fade.World.Worlds")) {
	            	if (Bukkit.getWorld(worldSMA) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.Block-Fade.World: "+worldSMA);
	            	} else {
	            		worlds_BlockFade.add(worldSMA);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldProtectionHagingBreakByEntity() {
		if (ConfigGProtection.getConfig().getBoolean("Protection.HagingBreakByEntity.Enable")) {
	        if (!ConfigGProtection.getConfig().getBoolean("Protection.HagingBreakByEntity.World.All_World")) {
	            for (String world : ConfigGProtection.getConfig().getStringList("Protection.HagingBreakByEntity.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in Server-Protection.yml, Protection.HagingBreakByEntity.World: "+world);
	            	} else {
	            		worlds_HagingBreakByEntity.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldProtectionPlayerInteractEntityItemFrame() {
		if (!ConfigGProtection.getConfig().getBoolean("Protection.PlayerInteractEntity-ItemFrame.World.All_World")) {
            for (String world : ConfigGProtection.getConfig().getStringList("Protection.PlayerInteractEntity-ItemFrame.World.Worlds")) {
            	if (Bukkit.getWorld(world) == null) {
            		System.out.println("| Invalid world in Server-Protection.yml, Protection.PlayerInteractEntity-ItemFrame.World: "+world);
            	} else {
            		worlds_PlayerInteractEntity_ItemFrame.add(world);
            	}
            }
        }
	}
	
	public static void setWGetWorldServerDisableThunderChange() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.ThunderChange.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.ThunderChange.World.All_World")) {
	            for (String worldWeather : ConfigGServerEvent.getConfig().getStringList("Server.Disable.ThunderChange.World.Worlds")) {
	            	if (Bukkit.getWorld(worldWeather) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.ThunderChange.World: "+worldWeather);
	            	} else {
	            		worlds_ThunderChange.add(worldWeather);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldServerDisableFireSpread() {
		if (ConfigGServerEvent.getConfig().getBoolean("Server.Disable.BlockIgnite-FireSpread.Enable")) {
	        if (!ConfigGServerEvent.getConfig().getBoolean("Server.Disable.BlockIgnite-FireSpread.World.All_World")) {
	            for (String worldBurnblock : ConfigGServerEvent.getConfig().getStringList("Server.Disable.BlockIgnite-FireSpread.World.Worlds")) {
	            	if (Bukkit.getWorld(worldBurnblock) == null) {
	            		System.out.println("| Invalid world in Server-Event.yml, Server.Disable.BlockIgnite-FireSpread.World: "+worldBurnblock);
	            	} else {
	            		worlds_firespread.add(worldBurnblock);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldKeepFlyChangeWorld() {
		if (ConfigCWEKeepFly.getConfig().getBoolean("KeepFly.Enable.Enable")) {
	        if (!ConfigCWEKeepFly.getConfig().getBoolean("KeepFly.World.All_World")) {
	            for (String world : ConfigCWEKeepFly.getConfig().getStringList("KeepFly.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in KeepFly.yml, KeepFly.World: "+world);
	            	} else {
	            		worlds_Fly_KeepOnChangeWorld.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldGamemodeChangeWorld() {
		if (ConfigCWEGM.getConfig().getBoolean("GM.Enable")) {
	        if (!ConfigCWEGM.getConfig().getBoolean("GM.World.All_World")) {
	            for (String world : ConfigCWEGM.getConfig().getStringList("GM.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in GameMode.yml, GM.World: "+world);
	            	} else {
	            		worlds_GM_OnChangeWorld.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static void setWGetWorldActionBarJoin() {
		if (ConfigGActionBar.getConfig().getBoolean("ActionBar.Enable")) {
	        if (!ConfigGActionBar.getConfig().getBoolean("ActionBar.World.All_World")) {
	            for (String world : ConfigGActionBar.getConfig().getStringList("ActionBar.World.Worlds")) {
	            	if (Bukkit.getWorld(world) == null) {
	            		System.out.println("| Invalid world in ActionBar-OnJoin.yml, ActionBar.World: "+world);
	            	} else {
	            		worlds_ActionBar_Join.add(world);
	            	}
	            }
	        }
        }
	}
	
	public static List<String> getWOptionDoubleJumpJoin() {
		return worlds_fun_doublejump_onjoin;
	}
	
	public static List<String> getWFInfiniteJump() {
		return worlds_fun_infinitejump;
	}
	
	public static List<String> getWFFivefoldJump() {
		return worlds_fun_fivejump;
	}
	
	public static List<String> getWFQuadrupleJump() {
		return worlds_fun_forjump;
	}
	
	public static List<String> getWFTripleJump() {
		return worlds_fun_threejump;
	}
	
	public static List<String> getWFDoubleJump() {
		return worlds_fun_doublejump;
	}
	
	public static List<String> getWD() {
		return worlds_damage;
	}
	
	public static List<String> getWH() {
		return worlds_hunger;
	}
	
	public static List<String> getWW() {
		return worlds_weather;
	}
	
	public static List<String> getWBB() {
		return worlds_burn_block;
	}
	
	public static List<String> getWE() {
		return worlds_explosions;
	}
	
	public static List<String> getWDM() {
		return worlds_death_message;
	}
	
	public static List<String> getWSMA() {
		return worlds_spawning_mob_animals;
	}
	
	public static List<String> getWPCP() {
		return worlds_c_place;
	}
	
	public static List<String> getWPCB() {
		return worlds_c_break;
	}
	
	public static List<String> getWXPEXP() {
		return worlds_XP_Exp;
	}
	
	public static List<String> getWXPLVL() {
		return worlds_XP_Lvl;
	}
	
	public static List<String> getWFly() {
		return worlds_Fly;
	}
	
	public static List<String> getWGM() {
		return worlds_GM;
	}
	
	public static List<String> getWFood() {
		return worlds_Food;
	}
	
	public static List<String> getWHealth() {
		return worlds_Health;
	}
	
	public static List<String> getWFirework() {
		return worlds_firework;
	}
	
	public static List<String> getWSoundsJoin() {
		return worlds_sounds_join;
	}
	
	public static List<String> getWOForceSelectedSlot() {
		return worlds_force_selected_slot;
	}
	
	public static List<String> getWInventory() {
		return worlds_inventory;
	}
	
	public static List<String> getWFirstJoinTitle() {
		return worlds_first_join_title;
	}
	
	public static List<String> getWJoinTitle() {
		return worlds_join_title;
	}
	
	public static List<String> getWMsgJoin() {
		return worlds_message_join;
	}
	
	public static List<String> getWBroadcastMsgJoin() {
		return worlds_broadcast_message_join;
	}
	
	public static List<String> getWNewMsgJoin() {
		return worlds_message_newjoin;
	}
	
	public static List<String> getWNewBroadcastMsgJoin() {
		return worlds_broadcast_message_newjoin;
	}
	
	public static List<String> getWClearChat() {
		return worlds_clear_chat;
	}
	
	public static List<String> getWBroadcastQuit() {
		return worlds_broadcast_quit;
	}
	
	public static List<String> getWItemDrop() {
		return worlds_item_drop;
	}
	
	public static List<String> getWItemPickUp() {
		return worlds_item_pickup;
	}
	
	public static List<String> getWItemDamage() {
		return worlds_item_damageitem;
	}
	
	public static List<String> getWClearOnDropsOnDeath() {
		return worlds_item_clearondrop;
	}
	
	public static List<String> getWMoveItem() {
		return worlds_item_move;
	}
	
	public static List<String> getWJumpPads() {
		return worlds_jumppads;
	}
	
	public static List<String> getWVoidTP() {
		return worlds_voidTP;
	}
	
	public static List<String> getWColorSign() {
		return worlds_ColorSign;
	}
	
	public static List<String> getWLD() {
		return worlds_LeaveDecay;
	}
	
	public static List<String> getWLS() {
		return worlds_LightningStrike;
	}
	
	public static List<String> getWBF() {
		return worlds_BlockFade;
	}
	
	public static List<String> getWHBBE() {
		return worlds_HagingBreakByEntity;
	}
	
	public static List<String> getWPIEIF() {
		return worlds_PlayerInteractEntity_ItemFrame;
	}
	
	public static List<String> getWTC() {
		return worlds_ThunderChange;
	}
	
	public static List<String> getWFS() {
		return worlds_firespread;
	}
	
	public static List<String> getWFlyKeepOnChangeWorld() {
		return worlds_Fly_KeepOnChangeWorld;
	}
	
	public static List<String> getWGamemodeOnChangeWorld() {
		return worlds_GM_OnChangeWorld;
	}
	
	public static List<String> getWABOJ() {
		return worlds_ActionBar_Join;
	}
	
	public static List<String> getWConsoleJoinCommandNew() {
		return worlds_JoinCommands_Console_New;
	}
	
	public static List<String> getWConsoleJoinCommandNoNew() {
		return worlds_JoinCommands_Console_No_New;
	}
	
	public static List<String> getWPlayerJoinCommandNew() {
		return worlds_JoinCommands_Player_New;
	}
	
	public static List<String> getWPlayerJoinCommandNoNew() {
		return worlds_JoinCommands_Player_No_New;
	}
	
	public static List<String> getWConsoleQuitCommand() {
		return worlds_QuitCommands_Console;
	}

}
