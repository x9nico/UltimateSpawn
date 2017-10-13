package fr.Dianox.US.MainClass.config.command;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigCAnnounce {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigCAnnounce() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Command/Announce.yml");
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
            
            Config.set("Announce.Broadcast.Enable", Boolean.valueOf(true));
            Config.set("Announce.Broadcast.Disable-Message", Boolean.valueOf(true));
            Config.set("Announce.Broadcast.Sounds.Enabled", Boolean.valueOf(true));
            Config.set("Announce.Broadcast.Sounds.Sound", "NOTE_PIANO");
            Config.set("Announce.Broadcast.Sounds.Volume", Integer.valueOf(10));
            Config.set("Announce.Broadcast.Sounds.Pitch", Integer.valueOf(1));
            Config.set("Announce.Broadcast.Sounds-Console.Enabled", Boolean.valueOf(true));
            Config.set("Announce.Broadcast.Sounds-Console.Sound", "NOTE_PIANO");
            Config.set("Announce.Broadcast.Sounds-Console.Volume", Integer.valueOf(10));
            Config.set("Announce.Broadcast.Sounds-Console.Pitch", Integer.valueOf(1));
            
            saveConfigFile();

        }
    }
}
