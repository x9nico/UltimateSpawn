package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGInventory {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGInventory() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/Inventory-OnJoin.yml");
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
            
            // Forced selected slot
            Config.set("Inventory.Force-Selected-Slot.Enable", Boolean.valueOf(true));
            Config.set("Inventory.Force-Selected-Slot.Slot", Integer.valueOf(1));
            Config.set("Inventory.Force-Selected-Slot.World.All_World", Boolean.valueOf(false));
            Config.set("Inventory.Force-Selected-Slot.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            Config.set("Inventory.Clear.Enable", Boolean.valueOf(true));
            Config.set("Inventory.Clear.Bypass", Boolean.valueOf(true));
            Config.set("Inventory.Clear.Options.Armor", Boolean.valueOf(true));
            Config.set("Inventory.Clear.Options.Inventory", Boolean.valueOf(true));
            Config.set("Inventory.Clear.World.All_World", Boolean.valueOf(false));
            Config.set("Inventory.Clear.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
