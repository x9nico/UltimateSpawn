package fr.Dianox.US.MainClass.config.event;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigERespawn {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigERespawn() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/Event/Respawn.yml");
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

            Config.set("Respawn.Enable", Boolean.valueOf(true));
            Config.set("Respawn.Use_Permission", Boolean.valueOf(false));
            Config.set("Respawn.Player.Respawn-After", Integer.valueOf(5));
            Config.set("Respawn.Player.Teleport-Spawn", Boolean.valueOf(true));
            Config.set("Respawn.Player.World.All_World", Boolean.valueOf(false));
            Config.set("Respawn.Player.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
