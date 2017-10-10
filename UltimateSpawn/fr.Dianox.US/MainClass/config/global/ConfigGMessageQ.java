package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGMessageQ {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGMessageQ() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnQuit/Message-OnQuit.yml");
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

            Config.set("Broadcast.Quit.Enable", Boolean.valueOf(true));
            Config.set("Broadcast.Quit.Hide", Boolean.valueOf(false));
            Config.set("Broadcast.Quit.Silent_Staff_Quit", Boolean.valueOf(false));
            Config.set("Broadcast.Quit.Message", java.util.Arrays.asList(new String[] {
                "&8[&c-&8] [&c-&8] [&c-&8] ",
                "&cHey, %player% :'("
            }));
            Config.set("Broadcast.Quit.World.All_World", Boolean.valueOf(false));
            Config.set("Broadcast.Quit.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
