package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGQuitCommand {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGQuitCommand() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnQuit/QuitCommand.yml");
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

            Config.set("QuitCommand.Enable", Boolean.valueOf(true));
            Config.set("QuitCommand.QuitCommand-Console.Commands",java.util.Arrays.asList(new String[] {
            		"spawn %player%",
            		"an unknow command"
            }));
            Config.set("QuitCommand.QuitCommand-Console.World.All_World", Boolean.valueOf(false));
            Config.set("QuitCommand.QuitCommand-Console.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
            }));
            

            saveConfigFile();

        }
    }

}
