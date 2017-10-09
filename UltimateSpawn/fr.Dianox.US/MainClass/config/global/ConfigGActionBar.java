package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGActionBar {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGActionBar() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/ActionBar-OnJoin.yml");
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

            Config.set("ActionBar.Enable", Boolean.valueOf(true));
            Config.set("ActionBar.Options.New.Enable", Boolean.valueOf(true));
            Config.set("ActionBar.Options.New.Message", "&6Welcome on our &eserver");
            Config.set("ActionBar.Options.New.Duration", "5L");
            Config.set("ActionBar.Options.No-New.Enable", Boolean.valueOf(true));
            Config.set("ActionBar.Options.No-New.Message", "&6Hello on our &eserver");
            Config.set("ActionBar.Options.No-New.Duration", "5L");
            Config.set("ActionBar.World.All_World", Boolean.valueOf(false));
            Config.set("ActionBar.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
            }));

            saveConfigFile();

        }
    }

}
