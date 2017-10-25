package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMPlayerOption {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMPlayerOption() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Commands/PlayerOption.yml");
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

            Config.set("PlayerOption.DoubleJump.Enable", java.util.Arrays.asList(new String[] {"&aYour doublejump has been activated"}));
            Config.set("PlayerOption.DoubleJump.Disable", java.util.Arrays.asList(new String[] {"&cYour doublejump has been disabled"}));
            Config.set("PlayerOption.Error.DoubleJump-Fly", java.util.Arrays.asList(new String[] {"&c&lYou&7 have the fly and doublejump activated, please deactivate one or the other."}));
            Config.set("PlayerOption.Error.DoubleJump", java.util.Arrays.asList(new String[] {"&c&lYou&7 cannot activate your doublejump because the fly is active!"}));
            Config.set("PlayerOption.Error.Fly", java.util.Arrays.asList(new String[] {"&c&lYou&7 cannot activate your fly because the doublejump is active!"}));
            
            saveConfigFile();

        }
    }

}
