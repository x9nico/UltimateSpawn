package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGDoubleJumpORFly {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGDoubleJumpORFly() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/DoubleJump-Fly-OnJoin.yml");
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

            Config.set("FD.Enable", Boolean.valueOf(true));
            Config.set("FD.FLY_OR_DOUBLEJUMP", String.valueOf("FLY"));
            Config.set("FD.Fly.Enable", Boolean.valueOf(true));
            Config.set("FD.Fly.Option.SetFlying", Boolean.valueOf(true));
            Config.set("FD.Fly.Option.SetAllowFlight", Boolean.valueOf(true));
            Config.set("FD.Fly.World.All_World", Boolean.valueOf(false));
            Config.set("FD.Fly.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("FD.DoubleJump.Enable", Boolean.valueOf(true));
            Config.set("FD.DoubleJump.World.All_World", Boolean.valueOf(false));
            Config.set("FD.DoubleJump.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("FD.Config_version_NEVER_TOUCH_HERE", Integer.valueOf(1));
            
            saveConfigFile();

        }
    }
}
