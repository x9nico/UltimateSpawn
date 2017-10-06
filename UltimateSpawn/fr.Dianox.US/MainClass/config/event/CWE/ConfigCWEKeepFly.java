package fr.Dianox.US.MainClass.config.event.CWE;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigCWEKeepFly {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigCWEKeepFly() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/Event/ChangeWorld/KeepFly.yml");
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

            Config.set("KeepFly.Enable.Enable", Boolean.valueOf(true));
            Config.set("KeepFly.Enable.SetFlyOnChangeWorld", Boolean.valueOf(true));
            Config.set("KeepFly.Enable.DisableFlyIfAWorldIsNotListed", Boolean.valueOf(true));
            Config.set("KeepFly.World.All_World", Boolean.valueOf(false));
            Config.set("KeepFly.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
