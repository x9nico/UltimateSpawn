package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGSpawn {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGSpawn() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/Spawn-OnJoin.yml");
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
            
            Config.set("Spawn.Teleport.Enable", Boolean.valueOf(true));
            Config.set("Spawn.Teleport.Use_Permission", Boolean.valueOf(false));
            Config.set("Spawn.Teleport.If_stats_is_enable.Use_stats_Of_UltimateSpawn.To_teleport_players.To_their_last_location", Boolean.valueOf(false));
            Config.set("Spawn.Teleport.If_stats_is_enable.Use_stats_Of_UltimateSpawn.To_teleport_players.Use_Permission", Boolean.valueOf(false));
            Config.set("Spawn.Teleport.On-First-Join.Enable", Boolean.valueOf(true));
            Config.set("Spawn.Teleport.On-First-Join.Custom-Spawn", Boolean.valueOf(true));
            
            saveConfigFile();

        }
    }
}
