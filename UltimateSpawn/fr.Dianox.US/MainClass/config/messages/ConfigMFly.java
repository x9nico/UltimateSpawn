package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMFly {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMFly() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Fly.yml");
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

            Config.set("Fly.Self.Enable", java.util.Arrays.asList(new String[] {"&aYour fly has been enabled"}));
            Config.set("Fly.Self.Disable", java.util.Arrays.asList(new String[] {"&cYour fly has been disabled"}));
            Config.set("Fly.Other.Enable", java.util.Arrays.asList(new String[] {"&a%target%'s fly has been enabled"}));
            Config.set("Fly.Other.Disable", java.util.Arrays.asList(new String[] {"&c%target%'s fly has been disabled"}));
           
            saveConfigFile();

        }
    }

}
