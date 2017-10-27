package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMPlugin {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMPlugin() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Plugin.yml");
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

            Config.set("Admin.Reload", java.util.Arrays.asList(new String[] {"&8[&bUS&8] &bConfig reloaded &7&oThis command is not fully supported by the plugin"}));
            Config.set("Others.Hours", "hour(s)");
            Config.set("Others.Minutes", "minute(s)");
            Config.set("Others.Seconds", "second(s)");
            Config.set("Error.Player.Only-Player", java.util.Arrays.asList(new String[] {"&cSorry, only players can use this command !"}));
            Config.set("Error.Player.Not-Found", java.util.Arrays.asList(new String[] {"&cSorry, but... The player are online ? If it's the case, check the playername"}));
            Config.set("Error.Player.Enter-Player-Name", java.util.Arrays.asList(new String[] {"&cThanks to enter a player name"}));
            Config.set("Error.No-Permission", java.util.Arrays.asList(new String[] {"&cSorry, but you don't have the permission !"}));
            Config.set("Error.Spawn-not-set", java.util.Arrays.asList(new String[] {"&cSorry, the spawn isn't set"}));
            Config.set("Error.Command-disable", java.util.Arrays.asList(new String[] {"&cSorry, this command is disable"}));
            Config.set("Error.Arguments-Missing", java.util.Arrays.asList(new String[] {"&cI'm sorry, but there must be one or two arguments missing."}));
            
            saveConfigFile();

        }
    }

}
