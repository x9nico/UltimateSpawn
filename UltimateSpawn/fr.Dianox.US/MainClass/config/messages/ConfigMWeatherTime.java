package fr.Dianox.US.MainClass.config.messages;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigMWeatherTime {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigMWeatherTime() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Messages/Commands/Weather-Time.yml");
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

            Config.set("Weather.Set.Sun.Enable", Boolean.valueOf(true));
            Config.set("Weather.Set.Sun.Message", java.util.Arrays.asList(new String[] {"&6The rain and thunderstorm has been removed, long live the sun!"}));
            Config.set("Weather.Set.Rain.Enable", Boolean.valueOf(true));
            Config.set("Weather.Set.Rain.Message", java.util.Arrays.asList(new String[] {"&3You set the rain in this world, be careful not to get wet!"}));
            Config.set("Weather.Set.Thunder.Enable", Boolean.valueOf(true));
            Config.set("Weather.Set.Thunder.Message", java.util.Arrays.asList(new String[] {"&6&k!!!!&r &eThe storm is a sign of disasters... Be careful not to get electrocuted &6&k!!!!"}));
            Config.set("Time.Set.Day.Enable", Boolean.valueOf(true));
            Config.set("Time.Set.Day.Message", java.util.Arrays.asList(new String[] {"&eIt's morning, time to go to school."}));
            Config.set("Time.Set.Night.Enable", Boolean.valueOf(true));
            Config.set("Time.Set.Night.Message", java.util.Arrays.asList(new String[] {"&f&lIt's dark outside. Be careful, the night is dark and full of terror!"}));
            
            saveConfigFile();

        }
    }

}
