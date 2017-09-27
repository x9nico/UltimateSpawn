package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGCos {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGCos() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/Cosmetics-OnJoin.yml");
        Config = YamlConfiguration.loadConfiguration(file);

        if (!pl.getDataFolder().exists()) {
            pl.getDataFolder().mkdir();
        }

        create();

        int gamemode = Config.getInt("On-Join.Spawn.Gamemode.Gamemode");

        if ((gamemode != 0) && (gamemode != 1) && (gamemode != 2) && (gamemode != 3)) {
            Config.set("Gamemode.Value", Integer.valueOf(0));
        }
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

            Config.set("Cosmetics.Firework.Enable", Boolean.valueOf(true));
            Config.set("Cosmetics.Firework.Options.Amount", Integer.valueOf(2));
            Config.set("Cosmetics.Firework.Options.Height", Integer.valueOf(3));
            Config.set("Cosmetics.Firework.Options.Flicker", Boolean.valueOf(false));
            Config.set("Cosmetics.Firework.Options.Trail", Boolean.valueOf(false));
            Config.set("Cosmetics.Firework.Options.Type", "BALL");
            Config.set("Cosmetics.Firework.Options.Instant-explode", Boolean.valueOf(false));
            Config.set("Cosmetics.Firework.Options.Power", Integer.valueOf(3));
            Config.set("Cosmetics.Firework.Options.Colors", java.util.Arrays.asList(new String[] {
                    "YELLOW",
                    "RED"
                }));
            Config.set("Cosmetics.Firework.Options.Fade", java.util.Arrays.asList(new String[] {
                    "BLUE",
                    "WHITE"
                }));
            Config.set("Cosmetics.Firework.World.All_World", Boolean.valueOf(false));
            Config.set("Cosmetics.Firework.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            Config.set("Cosmetics.Sounds.Enabled", Boolean.valueOf(true));
            Config.set("Cosmetics.Sounds.Sound", "NOTE_PIANO");
            Config.set("Cosmetics.Sounds.Volume", Integer.valueOf(10));
            Config.set("Cosmetics.Sounds.Pitch", Integer.valueOf(1));
            Config.set("Cosmetics.Sounds.World.All_World", Boolean.valueOf(false));
            Config.set("Cosmetics.Sounds.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
