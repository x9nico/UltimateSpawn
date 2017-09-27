package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGTitle {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGTitle() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/OnJoin/Title-OnJoin.yml");
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
            
            Config.set("Title.Enable", Boolean.valueOf(true));
            
            Config.set("Title.First-Join.Enable", Boolean.valueOf(true));
            Config.set("Title.First-Join.Title.Enable", Boolean.valueOf(true));
            Config.set("Title.First-Join.Title.FadeIn", Integer.valueOf(20));
            Config.set("Title.First-Join.Title.Stay", Integer.valueOf(150));
            Config.set("Title.First-Join.Title.FadeOut", Integer.valueOf(20));
            Config.set("Title.First-Join.Title.Message", "&6Welcome %player%");
            
            Config.set("Title.First-Join.SubTitle.Enable", Boolean.valueOf(true));
            Config.set("Title.First-Join.SubTitle.FadeIn", Integer.valueOf(20));
            Config.set("Title.First-Join.SubTitle.Stay", Integer.valueOf(150));
            Config.set("Title.First-Join.SubTitle.FadeOut", Integer.valueOf(20));
            Config.set("Title.First-Join.SubTitle.Message", "&eThanks to choose &6US");
            
            Config.set("Title.First-Join.World.All_World", Boolean.valueOf(false));
            Config.set("Title.First-Join.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));

            Config.set("Title.Join.Enable", Boolean.valueOf(true));
            Config.set("Title.Join.Title.Enable", Boolean.valueOf(true));
            Config.set("Title.Join.Title.FadeIn", Integer.valueOf(20));
            Config.set("Title.Join.Title.Stay", Integer.valueOf(150));
            Config.set("Title.Join.Title.FadeOut", Integer.valueOf(20));
            Config.set("Title.Join.Title.Message", "&6Welcome %player%");
            
            Config.set("Title.Join.SubTitle.Enable", Boolean.valueOf(true));
            Config.set("Title.Join.SubTitle.FadeIn", Integer.valueOf(20));
            Config.set("Title.Join.SubTitle.Stay", Integer.valueOf(150));
            Config.set("Title.Join.SubTitle.FadeOut", Integer.valueOf(20));
            Config.set("Title.Join.SubTitle.Message", "&eThanks to choose &6US");
            
            Config.set("Title.Join.World.All_World", Boolean.valueOf(false));
            Config.set("Title.Join.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
