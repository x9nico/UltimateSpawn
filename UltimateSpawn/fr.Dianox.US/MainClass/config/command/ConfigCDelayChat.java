package fr.Dianox.US.MainClass.config.command;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigCDelayChat {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigCDelayChat() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Command/DelayChat.yml");
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
            
            Config.set("DelayChat.Enable", Boolean.valueOf(true));
            Config.set("DelayChat.Delay.Enable", Boolean.valueOf(true));
            Config.set("DelayChat.Delay.Delay_By_Default", Integer.valueOf(3));
            Config.set("DelayChat.Delay.Bypass", Boolean.valueOf(true));
            Config.set("DelayChat.Disable-Message", Boolean.valueOf(true));
            
            saveConfigFile();

        }
    }
}
