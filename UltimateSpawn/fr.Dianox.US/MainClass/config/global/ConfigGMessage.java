package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGMessage {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGMessage() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/Messages-Chat-OnJoin.yml");
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
            
            Config.set("Chat.Clear.Enable", Boolean.valueOf(true));
            Config.set("Chat.Clear.Bypass", Boolean.valueOf(true));
            Config.set("Chat.Clear.Lines-To-Clear", Integer.valueOf(150));
            Config.set("Chat.Clear.World.All_World", Boolean.valueOf(false));
            Config.set("Chat.Clear.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            Config.set("Broadcast.First-Join.Enable", Boolean.valueOf(true));
            Config.set("Broadcast.First-Join.Message", java.util.Arrays.asList(new String[] {
                "&6Welcome %player%!",
                "&eSay welcome ;)"
            }));
            Config.set("Broadcast.First-Join.World.All_World", Boolean.valueOf(false));
            Config.set("Broadcast.First-Join.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            Config.set("Broadcast.Join.Enable", Boolean.valueOf(true));
            Config.set("Broadcast.Join.Hide", Boolean.valueOf(false));
            Config.set("Broadcast.Join.Hide_New_Players", Boolean.valueOf(false));
            Config.set("Broadcast.Join.Silent_Staff_Join", Boolean.valueOf(false));
            Config.set("Broadcast.Join.Message", java.util.Arrays.asList(new String[] {
                "&8[&a+&8] [&a+&8] [&a+&8] ",
                "&eHey, %player%"
            }));
            Config.set("Broadcast.Join.World.All_World", Boolean.valueOf(false));
            Config.set("Broadcast.Join.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            Config.set("Message.First-Join.Enable", Boolean.valueOf(true));
            Config.set("Message.First-Join.Message", java.util.Arrays.asList(new String[] {
                "&6Welcome %player%!",
                "&cDon't forget to see our rules"
            }));
            Config.set("Message.First-Join.World.All_World", Boolean.valueOf(false));
            Config.set("Message.First-Join.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            Config.set("Message.Join.Enable", Boolean.valueOf(true));
            Config.set("Message.Join.Message", java.util.Arrays.asList(new String[] {
                "&8&m<=====-------<&r &6UltimateSpawn &8&m>-------=====>",
                "&cHello %player%",
                "&cDon't forget to see our rules",
                "&8&m<=====-------<&r &6UltimateSpawn &8&m>-------=====>"
            }));
            Config.set("Message.Join.World.All_World", Boolean.valueOf(false));
            Config.set("Message.Join.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
