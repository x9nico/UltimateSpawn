package fr.Dianox.US.MainClass.config.command;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigCMuteChat {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigCMuteChat() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Command/Chat/MuteChat.yml");
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
            
            Config.set("MuteChat.Enable", Boolean.valueOf(true));
            Config.set("MuteChat.Mute.Enable", Boolean.valueOf(false));
            Config.set("MuteChat.Mute.Bypass", Boolean.valueOf(false));
            Config.set("MuteChat.Disable-Message", Boolean.valueOf(true));
            
            saveConfigFile();

        }
    }
}
