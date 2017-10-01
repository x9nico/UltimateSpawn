package fr.Dianox.US.MainClass.config.event;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigEVoidTP {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigEVoidTP() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/Event/VoidTP.yml");
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

            Config.set("VoidTP.Enable", Boolean.valueOf(true));
            Config.set("VoidTP.Options.TP-y", Integer.valueOf(0));
            Config.set("VoidTP.Options.Message.Custom", Boolean.valueOf(true));
            Config.set("VoidTP.Options.Message.Disable", Boolean.valueOf(false));
            Config.set("VoidTP.Options.Custom-Spawn", Boolean.valueOf(false));
            Config.set("VoidTP.Options.Spawn.world", null);
            Config.set("VoidTP.Options.Spawn.x", null);
            Config.set("VoidTP.Options.Spawn.y", null);
            Config.set("VoidTP.Options.Spawn.z", null);
            Config.set("VoidTP.Options.Spawn.yaw", null);
            Config.set("VoidTP.Options.Spawn.pitch", null);
            Config.set("VoidTP.World.All_World", Boolean.valueOf(false));
            Config.set("VoidTP.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
