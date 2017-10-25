package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMSpawn {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMSpawn() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Commands/Spawn.yml");
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

            Config.set("Teleport.Spawn", java.util.Arrays.asList(new String[] {"&7Teleport..."}));
            Config.set("Teleport.Spawn-Other", java.util.Arrays.asList(new String[] {"&7Teleport %target%..."}));
            Config.set("Admin.Spawn-set", java.util.Arrays.asList(new String[] {"&6US &7| &eSpawn &cset &e!"}));
            
            saveConfigFile();

        }
    }

}
