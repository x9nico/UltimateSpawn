package fr.Dianox.US.MainClass.config.fun;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigFDoubleJump {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigFDoubleJump() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/Fun/DoubleJump.yml");
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

            Config.set("DoubleJump.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Double.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Double.Use_Permission", Boolean.valueOf(true));
            Config.set("DoubleJump.Double.Sounds.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Double.Sounds.Sound", "NOTE_PIANO");
            Config.set("DoubleJump.Double.Sounds.Volume", Integer.valueOf(10));
            Config.set("DoubleJump.Double.Sounds.Pitch", Integer.valueOf(1));
            Config.set("DoubleJump.Double.World.All_World", Boolean.valueOf(false));
            Config.set("DoubleJump.Double.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("DoubleJump.Triple.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Triple.Use_Permission", Boolean.valueOf(true));
            Config.set("DoubleJump.Triple.Sounds.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Triple.Sounds.Sound", "NOTE_PIANO");
            Config.set("DoubleJump.Triple.Sounds.Volume", Integer.valueOf(10));
            Config.set("DoubleJump.Triple.Sounds.Pitch", Integer.valueOf(1));
            Config.set("DoubleJump.Triple.World.All_World", Boolean.valueOf(false));
            Config.set("DoubleJump.Triple.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("DoubleJump.Quadruple.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Quadruple.Use_Permission", Boolean.valueOf(true));
            Config.set("DoubleJump.Quadruple.Sounds.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Quadruple.Sounds.Sound", "NOTE_PIANO");
            Config.set("DoubleJump.Quadruple.Sounds.Volume", Integer.valueOf(10));
            Config.set("DoubleJump.Quadruple.Sounds.Pitch", Integer.valueOf(1));
            Config.set("DoubleJump.Quadruple.World.All_World", Boolean.valueOf(false));
            Config.set("DoubleJump.Quadruple.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("DoubleJump.Fivefold.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Fivefold.Use_Permission", Boolean.valueOf(true));
            Config.set("DoubleJump.Fivefold.Sounds.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Fivefold.Sounds.Sound", "NOTE_PIANO");
            Config.set("DoubleJump.Fivefold.Sounds.Volume", Integer.valueOf(10));
            Config.set("DoubleJump.Fivefold.Sounds.Pitch", Integer.valueOf(1));
            Config.set("DoubleJump.Fivefold.World.All_World", Boolean.valueOf(false));
            Config.set("DoubleJump.Fivefold.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("DoubleJump.Infinite.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Infinite.Use_Permission", Boolean.valueOf(true));
            Config.set("DoubleJump.Infinite.Sounds.Enable", Boolean.valueOf(true));
            Config.set("DoubleJump.Infinite.Sounds.Sound", "NOTE_PIANO");
            Config.set("DoubleJump.Infinite.Sounds.Volume", Integer.valueOf(10));
            Config.set("DoubleJump.Infinite.Sounds.Pitch", Integer.valueOf(1));
            Config.set("DoubleJump.Infinite.World.All_World", Boolean.valueOf(false));
            Config.set("DoubleJump.Infinite.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
