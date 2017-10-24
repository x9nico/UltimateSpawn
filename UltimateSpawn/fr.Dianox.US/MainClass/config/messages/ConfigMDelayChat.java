package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMDelayChat {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMDelayChat() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Commands/DelayChat.yml");
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
            
            Config.set("ChatDelay.Delay", java.util.Arrays.asList(new String[] {"&cChat is currently dealyed of %DELAY% seconds"}));
            Config.set("ChatDelay.Admin.Set", java.util.Arrays.asList(new String[] {"&cDelay set to &e%DELAY%.", "&7&oDon't forget to edit this value in the config. Yes this command is only valid if the server does not shut down"}));
            
            saveConfigFile();

        }
    }

}
