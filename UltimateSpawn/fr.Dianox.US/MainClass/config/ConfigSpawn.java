package fr.Dianox.US.MainClass.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigSpawn {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigSpawn() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "spawn.yml");
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

            Config.set("spawn.world", null);
            Config.set("spawn.x", null);
            Config.set("spawn.y", null);
            Config.set("spawn.z", null);
            Config.set("spawn.yaw", null);
            Config.set("spawn.pitch", null);
            Config.set("FirstSpawn.Spawn.world", null);
            Config.set("FirstSpawn.Spawn.x", null);
            Config.set("FirstSpawn.Spawn.y", null);
            Config.set("FirstSpawn.Spawn.z", null);
            Config.set("FirstSpawn.Spawn.yaw", null);
            Config.set("FirstSpawn.Spawn.pitch", null);
            Config.set("VoidTP.Spawn.world", null);
            Config.set("VoidTP.Spawn.x", null);
            Config.set("VoidTP.Spawn.y", null);
            Config.set("VoidTP.Spawn.z", null);
            Config.set("VoidTP.Spawn.yaw", null);
            Config.set("VoidTP.Spawn.pitch", null);

            saveConfigFile();

        }
    }

}
