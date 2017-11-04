package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGPlayerOption {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGPlayerOption() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/PlayerOption-Other-OnJoin.yml");
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
            Config.set("PlayerOption.Option.Speed.Enable", Boolean.valueOf(true));
            Config.set("PlayerOption.Option.Speed.Use_Permission", Boolean.valueOf(true));
            Config.set("PlayerOption.Option.Speed.Option.Amplifier", Integer.valueOf(2));
            Config.set("PlayerOption.Option.JumpBoost.Enable", Boolean.valueOf(true));
            Config.set("PlayerOption.Option.JumpBoost.Use_Permission", Boolean.valueOf(true));
            Config.set("PlayerOption.Option.JumpBoost.Option.Amplifier", Integer.valueOf(0));
            Config.set("PlayerOption.Option.Force-Clear-Effects", Boolean.valueOf(true));
            Config.set("PlayerOption.World.All_World", Boolean.valueOf(false));
            Config.set("PlayerOption.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }

}
