package fr.Dianox.US.MainClass;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import fr.Dianox.US.MainClass.Commands.AnnounceCommand;
import fr.Dianox.US.MainClass.Commands.MainCommand;
import fr.Dianox.US.MainClass.Commands.PingCommand;
import fr.Dianox.US.MainClass.Commands.PlayerOption;
import fr.Dianox.US.MainClass.Commands.SetSpawnCommand;
import fr.Dianox.US.MainClass.Commands.SpawnCommand;
import fr.Dianox.US.MainClass.Commands.Chat.ClearChatCommand;
import fr.Dianox.US.MainClass.Commands.Chat.DelaychatCommand;
import fr.Dianox.US.MainClass.Commands.Chat.MuteChatCommand;
import fr.Dianox.US.MainClass.Commands.Other.FlyCommand;
import fr.Dianox.US.MainClass.Commands.Other.TimeCommand;
import fr.Dianox.US.MainClass.Utils.OtherUtils;
import fr.Dianox.US.MainClass.Utils.WorldUtils;
import fr.Dianox.US.MainClass.config.ConfigBlockCommands;
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
import fr.Dianox.US.MainClass.config.command.ConfigCPlayerOption;
import fr.Dianox.US.MainClass.config.command.ConfigCSpawn;
import fr.Dianox.US.MainClass.config.command.ConfigCWeatherTime;
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
import fr.Dianox.US.MainClass.config.global.ConfigGSpawn;
import fr.Dianox.US.MainClass.config.global.ConfigGTitle;
import fr.Dianox.US.MainClass.config.global.ConfigGXP;
import fr.Dianox.US.MainClass.config.messages.ConfigMAnnounce;
import fr.Dianox.US.MainClass.config.messages.ConfigMClearChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMDelayChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMMuteChat;
import fr.Dianox.US.MainClass.config.messages.ConfigMPing;
import fr.Dianox.US.MainClass.config.messages.ConfigMWeatherTime;

public class MainClass extends JavaPlugin implements Listener {
	
	private static MainClass instance;
	String version;
	public static String nmsver;
	public boolean useOldMethods = false;
	
	public MainClass() {}
	
	@Override
	public void onEnable() {
		getCSC("|=============================");
		getCSC("|");
		String version1 = Bukkit.getServer().getBukkitVersion();
		this.version = version1;
		getCSC("| "+ChatColor.AQUA+"Ultimate Spawn load!"+ChatColor.RED+" Please wait!");
		getCSC("| "+ChatColor.YELLOW+">>> Version 0.6.0.6-Alpha");
		getCSC("|");
		getCSC("| "+ChatColor.YELLOW+">> Bukkit version "+version);
		getCSC("|");
		
		super.onEnable();
		
		instance = this;
		
		ConfigGXP.loadConfig((Plugin) this);
		ConfigGFly.loadConfig((Plugin) this);
		ConfigGGM.loadConfig((Plugin) this);
		ConfigGHF.loadConfig((Plugin) this);
		ConfigGCos.loadConfig((Plugin) this);
		ConfigGInventory.loadConfig((Plugin) this);
		ConfigGTitle.loadConfig((Plugin) this);
		ConfigGMessage.loadConfig((Plugin) this);
		ConfigGSpawn.loadConfig((Plugin) this);
		ConfigGMessageQ.loadConfig((Plugin) this);
		ConfigGServerEvent.loadConfig((Plugin) this);
		ConfigGPlayerItems.loadConfig((Plugin) this);
		ConfigGProtection.loadConfig((Plugin) this);
		ConfigCWEKeepFly.loadConfig((Plugin) this);
		ConfigCWEGM.loadConfig((Plugin) this);
		ConfigGActionBar.loadConfig((Plugin) this);
		ConfigGJoinCommand.loadConfig((Plugin) this);
		ConfigGQuitCommand.loadConfig((Plugin) this);
		ConfigBlockCommands.loadConfig((Plugin) this);
		ConfigGDoubleJump.loadConfig((Plugin) this);
		ConfigCClearChat.loadConfig((Plugin) this);
		ConfigCSpawn.loadConfig((Plugin) this);
		ConfigCPing.loadConfig((Plugin) this);
		ConfigCDelayChat.loadConfig((Plugin) this);
		ConfigCMuteChat.loadConfig((Plugin) this);
		ConfigCAnnounce.loadConfig((Plugin) this);
		ConfigCFly.loadConfig((Plugin) this);
		ConfigCPlayerOption.loadConfig((Plugin) this);
		ConfigFJumpad.loadConfig((Plugin) this);
		ConfigFDoubleJump.loadConfig((Plugin) this);
		ConfigEVoidTP.loadConfig((Plugin) this);
		ConfigEColorSign.loadConfig((Plugin) this);
		ConfigTemp.loadConfig((Plugin) this);
		ConfigGlobal.loadConfig((Plugin) this);
		ConfigMessage.loadConfig((Plugin) this);
		ConfigSpawn.loadConfig((Plugin) this);
		ConfigPlayerOptions.loadConfig((Plugin) this);
		ConfigPlayerStats.loadConfig((Plugin) this);
		// Commands
		ConfigCWeatherTime.loadConfig((Plugin) this);
		// >> Messages
		// > Commands
		ConfigMWeatherTime.loadConfig((Plugin) this);
		ConfigMAnnounce.loadConfig((Plugin) this);
		ConfigMPing.loadConfig((Plugin) this);
		ConfigMClearChat.loadConfig((Plugin) this);
		ConfigMMuteChat.loadConfig((Plugin) this);
		ConfigMDelayChat.loadConfig((Plugin) this);
		getCSC("| "+ChatColor.YELLOW+"All configuration files have been loaded :o");
		
		getCSC("|");
		
		getCommand("ultimatespawn").setExecutor(new MainCommand());
		
		getCommand("spawn").setExecutor(new SpawnCommand());
		getCommand("setspawn").setExecutor(new SetSpawnCommand());
		getCommand("ping").setExecutor(new PingCommand());
		getCommand("cc").setExecutor(new ClearChatCommand());
		getCommand("bc").setExecutor(new AnnounceCommand());
		getCommand("globalmute").setExecutor(new MuteChatCommand());
		getCommand("delaychat").setExecutor(new DelaychatCommand());
		getCommand("fly").setExecutor(new FlyCommand());
		getCommand("playeroption").setExecutor(new PlayerOption());
		getCommand("night").setExecutor(new TimeCommand());
		getCommand("day").setExecutor(new TimeCommand());
		getCommand("sun").setExecutor(new TimeCommand());
		getCommand("rain").setExecutor(new TimeCommand());
		getCommand("thunder").setExecutor(new TimeCommand());
		getCSC("| "+ChatColor.YELLOW+"Commands loaded");
		
		getCSC("|");
		
		new Manager(this).registerEvents();
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
        // > DoubleJump
        WorldUtils.setWGetDoubleJumpOnJoin();
        
        // >> DoubleJump
        WorldUtils.setWGetFunDoubleJump();
        WorldUtils.setWGetFunFivefoldJump();
        WorldUtils.setWGetFunInfiniteJump();
        WorldUtils.setWGetFunTripleJump();
        WorldUtils.setWGetFunQuadrupleJump();
        
        // >> DoubleJump
        WorldUtils.setWGetFunDoubleJump();
        WorldUtils.setWGetFunTripleJump();
        WorldUtils.setWGetFunQuadrupleJump();
        WorldUtils.setWGetFunFivefoldJump();
        WorldUtils.setWGetFunInfiniteJump();
        
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
