package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMPing {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMPing() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Commands/Ping.yml");
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

            Config.set("Ping.Self", java.util.Arrays.asList(new String[] {"&c%player% &7>> &e%ping% ms"}));
            Config.set("Ping.Other", java.util.Arrays.asList(new String[] {"&c%target% &7>> &e%ping% ms"}));
            Config.set("Ping.Console-Trool", "Error no seriously ? But... Why ? you can only execute this command in game");
            
            saveConfigFile();

        }
    }

}
