package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMClearChat {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMClearChat() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Commands/ClearChat.yml");
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
            
            Config.set("ClearChat.No-Reason", "It has been held that");
            Config.set("ClearChat.Anonymously", java.util.Arrays.asList(new String[] {"&cChat clear because %reason%"}));
            Config.set("ClearChat.Normal", java.util.Arrays.asList(new String[] {"&cChat clear by %player% because %reason%"}));
            Config.set("ClearChat.Own", java.util.Arrays.asList(new String[] {"&cYour chat has been clear %player%"}));
            Config.set("ClearChat.Other.Target", java.util.Arrays.asList(new String[] {"&cYour chat has been clear %target%"}));
            Config.set("ClearChat.Other.Sender", java.util.Arrays.asList(new String[] {"&cThe %player%'s chat has been clear"}));
            
            saveConfigFile();

        }
    }

}
