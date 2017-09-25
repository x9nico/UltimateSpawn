package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGHF {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGHF() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/Health-Food-OnJoin.yml");
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

            Config.set("Restore.Food.Enable", Boolean.valueOf(true));
            Config.set("Restore.Food.Value", Integer.valueOf(20));
            Config.set("Restore.Food..World.All_World", Boolean.valueOf(false));
            Config.set("Restore.Food..World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            Config.set("Restore.Health.Enable", Boolean.valueOf(true));
            Config.set("Restore.Health.Value", Double.valueOf(20.0));
            Config.set("Restore.Health.World.All_World", Boolean.valueOf(false));
            Config.set("Restore.Health.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
