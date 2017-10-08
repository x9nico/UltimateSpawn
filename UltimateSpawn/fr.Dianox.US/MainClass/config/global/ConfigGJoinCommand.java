package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGJoinCommand {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGJoinCommand() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/JoinCommand.yml");
        Config = YamlConfiguration.loadConfiguration(file);

        if (!pl.getDataFolder().exists()) {
            pl.getDataFolder().mkdir();
        }

        create();

    }

    public static File getFile() {
        return file;
    }

    public static YamlConfiguration getConfig() {
        return Config;
    }

    public static void reloadConfig() {
        loadConfig(pl);
    }

    public static void saveConfigFile() {
        try {
            Config.save(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void create() {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Config.set("JoinCommand.Enable", Boolean.valueOf(true));
            Config.set("JoinCommand.Options.New.JoinCommand-Player.Enable", Boolean.valueOf(true));
            Config.set("JoinCommand.Options.New.JoinCommand-Player.Commands",java.util.Arrays.asList(new String[] {
            		"spawn",
            		"an unknow command"
            }));
            Config.set("JoinCommand.Options.New.JoinCommand-Player.World.All_World", Boolean.valueOf(false));
            Config.set("JoinCommand.Options.New.JoinCommand-Player.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
            }));
            
            Config.set("JoinCommand.Options.New.JoinCommand-Console.Enable", Boolean.valueOf(true));
            Config.set("JoinCommand.Options.New.JoinCommand-Console.Commands",java.util.Arrays.asList(new String[] {
            		"spawn",
            		"an unknow command"
            }));
            Config.set("JoinCommand.Options.New.JoinCommand-Console.World.All_World", Boolean.valueOf(false));
            Config.set("JoinCommand.Options.New.JoinCommand-Console.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
            }));
            
            Config.set("JoinCommand.Options.No-New.JoinCommand-Player.Enable", Boolean.valueOf(true));
            Config.set("JoinCommand.Options.No-New.JoinCommand-Player.Commands",java.util.Arrays.asList(new String[] {
            		"spawn",
            		"an unknow command"
            }));
            Config.set("JoinCommand.Options.No-New.JoinCommand-Player.World.All_World", Boolean.valueOf(false));
            Config.set("JoinCommand.Options.No-New.JoinCommand-Player.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
            }));
            
            Config.set("JoinCommand.Options.No-New.JoinCommand-Console.Enable", Boolean.valueOf(true));
            Config.set("JoinCommand.Options.No-New.JoinCommand-Console.Commands",java.util.Arrays.asList(new String[] {
            		"spawn",
            		"an unknow command"
            }));
            Config.set("JoinCommand.Options.No-New.JoinCommand-Console.World.All_World", Boolean.valueOf(false));
            Config.set("JoinCommand.Options.No-New.JoinCommand-Console.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
            }));

            saveConfigFile();

        }
    }

}
