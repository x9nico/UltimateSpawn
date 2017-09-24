package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGXP {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGXP() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/Experience-OnJoin.yml");
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

            Config.set("XP.Enable", Boolean.valueOf(true));
            Config.set("XP.Options.Exp.Enable", Boolean.valueOf(true));
            Config.set("XP.Options.Exp.Value", Double.valueOf(0.3));
            Config.set("XP.Options.Exp.World.All_World", Boolean.valueOf(false));
            Config.set("XP.Options.Exp.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            Config.set("XP.Options.Level.Enable", Boolean.valueOf(true));
            Config.set("XP.Options.Level.Value", Integer.valueOf(10));
            Config.set("XP.Options.Level.World.All_World", Boolean.valueOf(false));
            Config.set("XP.Options.Level.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
