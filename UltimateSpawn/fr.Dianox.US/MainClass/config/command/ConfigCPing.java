package fr.Dianox.US.MainClass.config.command;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigCPing {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigCPing() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Command/Ping.yml");
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

            Config.set("Ping.Self.Enable", Boolean.valueOf(true));
            Config.set("Ping.Self.Use_Permission", Boolean.valueOf(false));
            Config.set("Ping.Self.Disable-Message", Boolean.valueOf(true));
            Config.set("Ping.Other.Enable", Boolean.valueOf(true));
            Config.set("Ping.Other.Use_Permission", Boolean.valueOf(false));
            Config.set("Ping.Other.Disable-Message", Boolean.valueOf(true));
            
            saveConfigFile();

        }
    }
}
