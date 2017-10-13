package fr.Dianox.US.MainClass;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Dianox.US.MainClass.Commands.AnnounceCommand;
import fr.Dianox.US.MainClass.Commands.MainCommand;
import fr.Dianox.US.MainClass.Commands.PingCommand;
import fr.Dianox.US.MainClass.Commands.SetSpawnCommand;
import fr.Dianox.US.MainClass.Commands.SpawnCommand;
import fr.Dianox.US.MainClass.Commands.Chat.ClearChatCommand;
import fr.Dianox.US.MainClass.Commands.Chat.DelaychatCommand;
import fr.Dianox.US.MainClass.Commands.Chat.MuteChatCommand;
import fr.Dianox.US.MainClass.Commands.Other.FlyCommand;
import fr.Dianox.US.MainClass.Utils.OtherUtils;
import fr.Dianox.US.MainClass.Utils.WorldUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigPlayerOptions;
import fr.Dianox.US.MainClass.config.ConfigPlayerStats;
import fr.Dianox.US.MainClass.config.ConfigSpawn;
import fr.Dianox.US.MainClass.config.ConfigTemp;
import fr.Dianox.US.MainClass.config.command.ConfigCAnnounce;
import fr.Dianox.US.MainClass.config.command.ConfigCClearChat;
import fr.Dianox.US.MainClass.config.command.ConfigCDelayChat;
import fr.Dianox.US.MainClass.config.command.ConfigCFly;
import fr.Dianox.US.MainClass.config.command.ConfigCMuteChat;
import fr.Dianox.US.MainClass.config.command.ConfigCPing;
import fr.Dianox.US.MainClass.config.command.ConfigCSpawn;
import fr.Dianox.US.MainClass.config.event.ConfigEColorSign;
import fr.Dianox.US.MainClass.config.event.ConfigEVoidTP;
import fr.Dianox.US.MainClass.config.event.CWE.ConfigCWEGM;
import fr.Dianox.US.MainClass.config.event.CWE.ConfigCWEKeepFly;
import fr.Dianox.US.MainClass.config.fun.ConfigFJumpad;
import fr.Dianox.US.MainClass.config.global.ConfigGActionBar;
import fr.Dianox.US.MainClass.config.global.ConfigGCos;
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
import fr.Dianox.US.MainClass.config.global.ConfigGSpawn;
import fr.Dianox.US.MainClass.config.global.ConfigGTitle;
import fr.Dianox.US.MainClass.config.global.ConfigGXP;
import fr.Dianox.US.MainClass.event.BasicFeatures;
import fr.Dianox.US.MainClass.event.ChangeWorldEvent;
import fr.Dianox.US.MainClass.event.FunFeatures;
import fr.Dianox.US.MainClass.event.LittlesEvent;
import fr.Dianox.US.MainClass.event.OnChat;
import fr.Dianox.US.MainClass.event.OnJoin;
import fr.Dianox.US.MainClass.event.OnQuit;

public class MainClass extends JavaPlugin implements Listener {
	
	private static MainClass instance;
	String version;
	public static String nmsver;
	public boolean useOldMethods = false;
	
	short config_number = 18;
	short config_number_commands = 7;
	short config_number_fun = 1;
	short config_number_event = 2;
	short config_number_other = 1;
	short config_number_player = 2;
	
	public MainClass() {}
	
	@Override
	public void onEnable() {
		getCSC("|=============================");
		getCSC("|");
		String version1 = Bukkit.getServer().getBukkitVersion();
		this.version = version1;
		getCSC("| "+ChatColor.AQUA+"Ultimate Spawn load!"+ChatColor.RED+" Please wait!");
		getCSC("| "+ChatColor.YELLOW+">>> Version 0.5.5-Alpha");
		getCSC("|");
		getCSC("| "+ChatColor.YELLOW+">> Bukkit version "+version);
		getCSC("|");
		
		super.onEnable();
		
		instance = this;
		
		ConfigGXP.loadConfig((Plugin) this);
		getCSC("| ("+ChatColor.GREEN+"Global"+ChatColor.GRAY+") "+ChatColor.YELLOW+"Config 1"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGFly.loadConfig((Plugin) this);
		getCSC("|          "+ChatColor.YELLOW+"Config 2"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGGM.loadConfig((Plugin) this);
		getCSC("|          "+ChatColor.YELLOW+"Config 3"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGHF.loadConfig((Plugin) this);
		getCSC("|          "+ChatColor.YELLOW+"Config 4"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGCos.loadConfig((Plugin) this);
		getCSC("|          "+ChatColor.YELLOW+"Config 5"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGInventory.loadConfig((Plugin) this);
		getCSC("|          "+ChatColor.YELLOW+"Config 6"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGTitle.loadConfig((Plugin) this);
		getCSC("|          "+ChatColor.YELLOW+"Config 7"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGMessage.loadConfig((Plugin) this);
		getCSC("|          "+ChatColor.YELLOW+"Config 8"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGSpawn.loadConfig((Plugin) this);
		getCSC("|          "+ChatColor.YELLOW+"Config 9"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGMessageQ.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 10"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGServerEvent.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 11"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGPlayerItems.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 12"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGProtection.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 13"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigCWEKeepFly.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 14"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigCWEGM.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 15"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGActionBar.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 16"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGJoinCommand.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 17"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigGQuitCommand.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 18"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number+""+ChatColor.YELLOW+" loaded");
		ConfigCClearChat.loadConfig((Plugin) this);
		getCSC("| ("+ChatColor.GREEN+"Commands"+ChatColor.GRAY+") "+ChatColor.YELLOW+"Config 1"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_commands+""+ChatColor.YELLOW+" loaded");
		ConfigCSpawn.loadConfig((Plugin) this);
		getCSC("|            "+ChatColor.YELLOW+"Config 2"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_commands+""+ChatColor.YELLOW+" loaded");
		ConfigCPing.loadConfig((Plugin) this);
		getCSC("|            "+ChatColor.YELLOW+"Config 3"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_commands+""+ChatColor.YELLOW+" loaded");
		ConfigCDelayChat.loadConfig((Plugin) this);
		getCSC("|            "+ChatColor.YELLOW+"Config 4"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_commands+""+ChatColor.YELLOW+" loaded");
		ConfigCMuteChat.loadConfig((Plugin) this);
		getCSC("|            "+ChatColor.YELLOW+"Config 5"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_commands+""+ChatColor.YELLOW+" loaded");
		ConfigCAnnounce.loadConfig((Plugin) this);
		getCSC("|            "+ChatColor.YELLOW+"Config 6"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_commands+""+ChatColor.YELLOW+" loaded");
		ConfigCFly.loadConfig((Plugin) this);
		getCSC("|            "+ChatColor.YELLOW+"Config 7"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_commands+""+ChatColor.YELLOW+" loaded");
		ConfigFJumpad.loadConfig((Plugin) this);
		getCSC("| ("+ChatColor.GREEN+"Fun"+ChatColor.GRAY+") "+ChatColor.YELLOW+"Config 1"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_fun+""+ChatColor.YELLOW+" loaded");
		ConfigEVoidTP.loadConfig((Plugin) this);
		getCSC("| ("+ChatColor.GREEN+"Event"+ChatColor.GRAY+") "+ChatColor.YELLOW+"Config 1"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_event+""+ChatColor.YELLOW+" loaded");
		ConfigEColorSign.loadConfig((Plugin) this);
		getCSC("|         "+ChatColor.YELLOW+"Config 2"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_event+""+ChatColor.YELLOW+" loaded");
		ConfigTemp.loadConfig((Plugin) this);
		getCSC("| ("+ChatColor.GREEN+"Others"+ChatColor.GRAY+") "+ChatColor.YELLOW+"Config 1"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_other+""+ChatColor.YELLOW+" loaded");
		ConfigGlobal.loadConfig((Plugin) this);
		getCSC("| "+ChatColor.GOLD+"Main config loaded");
		ConfigMessage.loadConfig((Plugin) this);
		getCSC("| "+ChatColor.GOLD+"Message config loaded");
		ConfigSpawn.loadConfig((Plugin) this);
		getCSC("| "+ChatColor.GOLD+"Spawn config loaded");
		ConfigPlayerOptions.loadConfig((Plugin) this);
		getCSC("| ("+ChatColor.GREEN+"Player"+ChatColor.GRAY+") "+ChatColor.YELLOW+"Config 1"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_player+""+ChatColor.YELLOW+" loaded");
		ConfigPlayerStats.loadConfig((Plugin) this);
		getCSC("|          "+ChatColor.YELLOW+"Config 2"+ChatColor.GRAY+"/"+ChatColor.GOLD+""+config_number_player+""+ChatColor.YELLOW+" loaded");
		
		getCSC("|");
		
		getCommand("ultimatespawn").setExecutor(new MainCommand());
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("cc").setExecutor(new ClearChatCommand());
		getCommand("bc").setExecutor(new AnnounceCommand());
		getCommand("GlobalMute").setExecutor(new MuteChatCommand());
		getCommand("DelayChat").setExecutor(new DelaychatCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCSC("| "+ChatColor.YELLOW+"Commands loaded");
		
		getCSC("|");
		
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(new BasicFeatures(), this);
		pm.registerEvents(new OnJoin(), this);
		pm.registerEvents(new OnQuit(), this);
		pm.registerEvents(new OnChat(), this);
		pm.registerEvents(new FunFeatures(), this);
		pm.registerEvents(new LittlesEvent(), this);
		pm.registerEvents(new ChangeWorldEvent(), this);
		getCSC("| "+ChatColor.YELLOW+"Events loaded");
		
        if (Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI")) {
            Bukkit.getPluginManager().registerEvents(this, this);
            getCSC("|");
            getCSC("| "+ChatColor.YELLOW+"PlaceHolderApi detected");
        	getCSC("|");
        } else {
        	ConfigGlobal.getConfig().set("Plugin.Use.PlaceholderAPI", Boolean.valueOf(false));
        	getCSC("|");
        	getCSC("| "+ChatColor.RED+"USE PLACEHOLDERAPI IS VERY VERY HIGHLY RECOMMENDED");
        	getCSC("|");
        }

        GetSetWorld();
        OtherUtils.fixConfig();
        
        nmsver = Bukkit.getServer().getClass().getPackage().getName();
        nmsver = nmsver.substring(nmsver.lastIndexOf(".") + 1);
        if ((nmsver.equalsIgnoreCase("v1_8_R1")) || (nmsver.startsWith("v1_7_"))) {
        	useOldMethods = true;
        }
        
        getCSC("| "+ChatColor.YELLOW+"And many things.... I think... x'D");
		getCSC("|");
		getCSC("| "+ChatColor.AQUA+"Ultimate Spawn loaded!");
		getCSC("|");
		getCSC("|=============================");
		getCSC("|");
		getCSC("| "+ChatColor.AQUA+"If you see a lot of warning in loading the plugin... it's normal... Everything works without problems... Don't worry ^^");
	}

	@Override
	public void onDisable() {
		super.onDisable();
	}
	
	public static void getCSC(String str) {
		Bukkit.getConsoleSender().sendMessage(str);
	}
	
	public static MainClass getInstance() {
		return instance;
	}
	
	public void GetSetWorld() {
		// ////////
        // World //
        // ////////
        // >> Disable-Event
        WorldUtils.setWGetWorldServerDisableHunger();
        WorldUtils.setWGetWorldServerDisableDamage();
        WorldUtils.setWGetWorldServerDisableWeather();
        WorldUtils.setWGetWorldServerDisableBurnBlock();
        WorldUtils.setWGetWorldServerDisableExplosion();
        WorldUtils.setWGetWorldServerDisableDeathMessage();
        WorldUtils.setWGetWorldServerDisableSpawningMobAnimals();
        WorldUtils.setWGetWorldServerDisableLeaveDecay();
        WorldUtils.setWGetWorldServerDisableLightningStrike();
        WorldUtils.setWGetWorldServerDisableblockFade();
        WorldUtils.setWGetWorldServerDisableThunderChange();
        WorldUtils.setWGetWorldServerDisableFireSpread();
        
        // >> Protection
        WorldUtils.setWGetWorldProtectionPlace();
        WorldUtils.setWGetWorldProtectionBreak();
        WorldUtils.setWGetWorldProtectionHagingBreakByEntity();
        WorldUtils.setWGetWorldProtectionPlayerInteractEntityItemFrame();
        
        // >> OnJoin
        // > Reset XP
        WorldUtils.setWGetWorldResetExperience();
        WorldUtils.setWGetWorldResetLevel();
        // > Fly
        WorldUtils.setWGetWorldFly();
        // > Gamemode
        WorldUtils.setWGetWorldGamemode();
        // > Restore Health and Food
        WorldUtils.setWGetWorldFood();
        WorldUtils.setWGetWorldHealth();
        // > Firework
        WorldUtils.setWGetWorldFirework();
        // > SoundJoin
        WorldUtils.setWGetWorldSoundJoin();
        // > Force Selected Slot
        WorldUtils.setWGetWorldForceSelectedJoin();
        // > Inventory
        WorldUtils.setWGetWorldInventory();
        // > Title
        WorldUtils.setWGetWorldFirstJoinTitle();
        WorldUtils.setWGetWorldJoinTitle();
        // > Message
        WorldUtils.setWGetWorldMessageOnJoin();
        WorldUtils.setWGetWorldFirstJoinMessageOnJoin();
        // > Broadcast
        WorldUtils.setWGetWorldBroadcastJoin();
        WorldUtils.setWGetWorldBroadcastNewJoin();
        // > Chat
        WorldUtils.setWGetWorldClearChat();
        // > ActionBar
        WorldUtils.setWGetWorldActionBarJoin();
        // > JoinCommand
        WorldUtils.setWGetWorldJoinCommandPlayerNew();
        WorldUtils.setWGetWorldJoinCommandPlayerNoNew();
        WorldUtils.setWGetWorldJoinCommandConsoleNew();
        WorldUtils.setWGetWorldJoinCommandConsoleNoNew();
        
        // >> OnQuit
        // > BroadCast Quit
        WorldUtils.setWGetWorldBroadcastQuit();
        // > QuitCommand
        WorldUtils.setWGetWorldQuitCommandConsole();
        
        // >> Server Player Item
        WorldUtils.setWGetWorldItemDrop();
        WorldUtils.setWGetWorldItemPickUP();
        WorldUtils.setWGetWorldItemDamage();
        WorldUtils.setWGetWorldClearDropOnDeath();
        WorldUtils.setWGetWorldMoveItem();
        
        // >> Fun
        WorldUtils.setWGetWorldJumpPads();
        
        // >> Event
        WorldUtils.setWGetWorldEventVoidTP();
        WorldUtils.setWGetWorldEventColorSign();
        // > ChangeWorld
        WorldUtils.setWGetWorldKeepFlyChangeWorld();
        WorldUtils.setWGetWorldGamemodeChangeWorld();
	}
	
	public String getServerVersion() {
		return version;
	}
	
}
