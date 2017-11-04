package fr.Dianox.US.MainClass.config.command;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigCPlayerOption {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigCPlayerOption() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Command/PlayerOption.yml");
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

            Config.set("PlayerOption.Enable", Boolean.valueOf(true));
            Config.set("PlayerOption.Help.Use_Permission", Boolean.valueOf(false));
            Config.set("PlayerOption.DoubleJump.Enable", Boolean.valueOf(true));
            Config.set("PlayerOption.DoubleJump.Use_Permission", Boolean.valueOf(false));
            Config.set("PlayerOption.Fly.Enable", Boolean.valueOf(true));
            Config.set("PlayerOption.Fly.Use_Permission", Boolean.valueOf(false));
            Config.set("PlayerOption.Speed.Enable", Boolean.valueOf(true));
            Config.set("PlayerOption.Speed.Amplifier", Integer.valueOf(1));
            Config.set("PlayerOption.Speed.Use_Permission", Boolean.valueOf(false));
            Config.set("PlayerOption.JumpBoost.Enable", Boolean.valueOf(true));
            Config.set("PlayerOption.JumpBoost.Amplifier", Integer.valueOf(1));
            Config.set("PlayerOption.JumpBoost.Use_Permission", Boolean.valueOf(false));
            Config.set("PlayerOption.Disable-Message", Boolean.valueOf(false));
            
            saveConfigFile();

        }
    }
}
