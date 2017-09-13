package fr.Dianox.US.MainClass.config;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMessage {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMessage() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "messages.yml");
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

            Config.set("Player.Teleport.To-spawn", "&7Teleport...");
            Config.set("Player.Teleport.To-spawn-other", "&7Teleport %target%...");
            Config.set("Player.Ping.Self", "&c%player% &7>> &e%ping%");
            Config.set("Player.Ping.Other", "&c%target% &7>> &e%ping%");
            Config.set("Protection.Construct-Message", "&cSorry, you can't construct here !");
            Config.set("Admin.Plugin-Reload", "&6US &7| &eConfig reloaded &7&oThis command has just reload config.yml, messages.yml and spawn.yml");
            Config.set("Admin.Spawn.Set", "&6US &7| &eSpawn &cset &e!");
            Config.set("Admin.ClearChat.Anonymously", "&cChat clear");
            Config.set("Admin.ClearChat.Own", "&cChat clear");
            Config.set("Admin.ClearChat.Normal", "&cChat clear by %player%");
            Config.set("Admin.ClearChat.Other", "&cYour chat has been clear");
            Config.set("Admin.Broadcast", "&8[&eBroadcast&8]&r ");
            Config.set("Error.Only-Player", "&cSorry, only players can use this command !");
            Config.set("Error.No-permission", "&cSorry, you don't have the permission !");
            Config.set("Error.Spawn-not-set", "&cSorry, the spawn isn't set");
            Config.set("Error.Command-disable", "&cSorry, this command is disable");
            Config.set("Error.Player.Not-found", "&cSorry, but... The player are online ? If it's the case, check the playername");
            Config.set("Error.Player.Enter-Player-Name", "&cThanks to enter a player name");

            saveConfigFile();

        }
    }

}
