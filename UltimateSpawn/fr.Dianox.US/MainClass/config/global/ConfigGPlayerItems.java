package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGPlayerItems {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGPlayerItems() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/Server-PlayersItems.yml");
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
            
            Config.set("Server.Items.Drop.Disable", Boolean.valueOf(true));
            Config.set("Server.Items.Drop.Bypass", Boolean.valueOf(true));
            Config.set("Server.Items.PickUp.Disable", Boolean.valueOf(true));
            Config.set("Server.Items.PickUp.Bypass", Boolean.valueOf(true));
            Config.set("Server.Items.Damage-Item.Disable", Boolean.valueOf(true));
            Config.set("Server.Items.Damage-Item.Bypass", Boolean.valueOf(true));
            Config.set("Server.Items.Clear-Drops-On-Death.Enable", Boolean.valueOf(true));
            Config.set("Server.Items.Clear-Drops-On-Death.Bypass", Boolean.valueOf(true));
            
            saveConfigFile();

        }
    }
}
