package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMServer {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMServer() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Server.yml");
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

            Config.set("TPS.Normal", java.util.Arrays.asList(new String[] {"&8[&bUS&8] &b%tps% tps"}));
            Config.set("TPS.Check.15", java.util.Arrays.asList(new String[] {"&cYour TPS is under 15, done something to improve the stability of your Lobby"}));
            Config.set("TPS.Check.5", java.util.Arrays.asList(new String[] {"&cYour TPS is under 5, your server may shut down, done /stop to avoid any problems.", "&cCRITICAL SERVER CRITICAL STATE ATTENTION"}));
            
            saveConfigFile();

        }
    }

}
