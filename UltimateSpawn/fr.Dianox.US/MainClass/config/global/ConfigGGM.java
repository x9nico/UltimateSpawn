package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGGM {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGGM() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/Gamemode-OnJoin.yml");
        Config = YamlConfiguration.loadConfiguration(file);

        if (!pl.getDataFolder().exists()) {
            pl.getDataFolder().mkdir();
        }

        create();

        int gamemode = Config.getInt("On-Join.Spawn.Gamemode.Gamemode");

        if ((gamemode != 0) && (gamemode != 1) && (gamemode != 2) && (gamemode != 3)) {
            Config.set("Gamemode.Value", Integer.valueOf(0));
        }
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

            Config.set("Gamemode.Enable", Boolean.valueOf(true));
            Config.set("Gamemode.Value", Integer.valueOf(2));
            Config.set("Gamemode.World.All_World", Boolean.valueOf(false));
            Config.set("Gamemode.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
