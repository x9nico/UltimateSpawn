package fr.Dianox.US.MainClass.config.event.CWE;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigCWEGM {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigCWEGM() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/Event/ChangeWorld/Gamemode.yml");
        Config = YamlConfiguration.loadConfiguration(file);

        if (!pl.getDataFolder().exists()) {
            pl.getDataFolder().mkdir();
        }

        create();
        
        int gamemode = Config.getInt("GM.CustomMode.GameMode");

        if ((gamemode != 0) && (gamemode != 1) && (gamemode != 2) && (gamemode != 3)) {
            Config.set("GM.CustomMode.GameMode", Integer.valueOf(0));
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

            Config.set("GM.Enable", Boolean.valueOf(true));
            Config.set("GM.CustomMode.Enable", Boolean.valueOf(true));
            Config.set("GM.CustomMode.GameMode", Integer.valueOf(1));
            Config.set("GM.CustomMode.If-player-have.Survival", Boolean.valueOf(true));
            Config.set("GM.CustomMode.If-player-have.Creative", Boolean.valueOf(true));
            Config.set("GM.CustomMode.If-player-have.Adventure", Boolean.valueOf(true));
            Config.set("GM.CustomMode.If-player-have.Spectator", Boolean.valueOf(true));
            Config.set("GM.World.All_World", Boolean.valueOf(false));
            Config.set("GM.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
