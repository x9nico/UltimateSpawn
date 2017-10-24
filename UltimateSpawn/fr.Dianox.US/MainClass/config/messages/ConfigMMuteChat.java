package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMMuteChat {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMMuteChat() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Commands/MuteChat.yml");
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
            
            Config.set("MuteChat.Can-t-Speak", java.util.Arrays.asList(new String[] {"&cThe chat is disable"}));
            Config.set("MuteChat.Admin.On", java.util.Arrays.asList(new String[] {"&aGlobal mute has been enabled by %player%!"}));
            Config.set("MuteChat.Admin.Off", java.util.Arrays.asList(new String[] {"&cGlobal mute has been disabled by %player%!"}));
            
            saveConfigFile();

        }
    }

}
