package fr.Dianox.US.MainClass.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigBlockCommands {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigBlockCommands() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/BlockCommands.yml");
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
            
            Config.set("Block-Commands.Enable", Boolean.valueOf(true));
            Config.set("Block-Commands.Bypass", Boolean.valueOf(true));
            Config.set("Block-Commands.Message-Enable", Boolean.valueOf(true));
            Config.set("Block-Commands.Message", "&cSorry... But ! You're noob");
            Config.set("Block-Commands.List", java.util.Arrays.asList(new String[] {
                    "/pl",
                    "/plugins",
                    "/bukkit:pl",
                    "/bukkit:plugins",
                    "/ver",
                    "/version",
                    "/icanhasbukkit",
                    "/info",
                    "/essentials:help",
                    "/?",
                    "/help",
                    "/ehelp",
                    "/minecraft:help",
                    "/bukkit:help",
                    "/bukkit:?",
                    "/bukkit:version",
                    "/seed",
                    "/minecraft:me",
                    "/me",
                    "/about",
                    "/eabout"
                }));
            
            saveConfigFile();

        }
    }

}
