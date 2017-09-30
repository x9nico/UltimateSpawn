package fr.Dianox.US.MainClass.config.command;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigCGlobal {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigCGlobal() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Commands.yml");
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
            
            // Construct
            Config.set("Command.Ping.Self.Enable", Boolean.valueOf(true));
            Config.set("Command.Ping.Self.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.Ping.Other.Enable", Boolean.valueOf(true));
            Config.set("Command.Ping.Other.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Enable", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Lines-To-Clear", Integer.valueOf(150));
            Config.set("Command.ClearChat.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Anonymous.Enable", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Anonymous.Message-Clear", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Anonymous.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Normal.Enable", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Normal.Message-Clear", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Normal.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Own.Enable", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Own.Message-Clear", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Own.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Other.Enable", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Other.Message-Clear", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Other.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Other.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Console.Anonymous-Message-Clear", Boolean.valueOf(true));
            Config.set("Command.ClearChat.Console.Normal-Message-Clear", Boolean.valueOf(true));
            Config.set("Command.Broadcast.Enable", Boolean.valueOf(true));
            Config.set("Command.Broadcast.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.Broadcast.Sounds.Enabled", Boolean.valueOf(true));
            Config.set("Command.Broadcast.Sounds.Sound", "NOTE_PIANO");
            Config.set("Command.Broadcast.Sounds.Volume", Integer.valueOf(10));
            Config.set("Command.Broadcast.Sounds.Pitch", Integer.valueOf(1));
            Config.set("Command.Broadcast.Sounds-Console.Enabled", Boolean.valueOf(true));
            Config.set("Command.Broadcast.Sounds-Console.Sound", "NOTE_PIANO");
            Config.set("Command.Broadcast.Sounds-Console.Volume", Integer.valueOf(10));
            Config.set("Command.Broadcast.Sounds-Console.Pitch", Integer.valueOf(1));
            Config.set("Command.MuteChat.Enable", Boolean.valueOf(true));
            Config.set("Command.MuteChat.Mute.Enable", Boolean.valueOf(false));
            Config.set("Command.MuteChat.Mute.Bypass", Boolean.valueOf(false));
            Config.set("Command.MuteChat.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.DelayChat.Enable", Boolean.valueOf(true));
            Config.set("Command.DelayChat.Delay.Enable", Boolean.valueOf(true));
            Config.set("Command.DelayChat.Delay.Delay_By_Default", Integer.valueOf(3));
            Config.set("Command.DelayChat.Delay.Bypass", Boolean.valueOf(true));
            Config.set("Command.DelayChat.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.Fly.Self.Enable", Boolean.valueOf(true));
            Config.set("Command.Fly.Self.Disable-Message", Boolean.valueOf(true));
            Config.set("Command.Fly.Other.Enable", Boolean.valueOf(true));
            Config.set("Command.Fly.Other.Disable-Message", Boolean.valueOf(true));
            
            saveConfigFile();

        }
    }
}
