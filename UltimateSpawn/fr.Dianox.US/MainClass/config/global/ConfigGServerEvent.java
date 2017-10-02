package fr.Dianox.US.MainClass.config.global;

import java.io.File;
import java.io.IOException;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

public class ConfigGServerEvent {

    private static Plugin pl;
    private static File file;
    private static YamlConfiguration Config;

    public ConfigGServerEvent() {}

    public static void loadConfig(Plugin plugin) {
        pl = plugin;

        file = new File(pl.getDataFolder(), "Config/Global/Server-Event.yml");
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
            
            //Server
            Config.set("Server.Disable.Hunger.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.Hunger.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.Hunger.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.Damage.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.EntityDamageByEntity", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.All", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.BLOCK_EXPLOSION", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.CONTACT", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.CUSTOM", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.DROWNING", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.ENTITY_ATTACK", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.ENTITY_EXPLOSION", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.FALL", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.FALLING_BLOCK", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.FALLING_BLOCK", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.FIRE", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.FIRE_TICK", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.LAVA", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.LIGHTNING", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.MAGIC", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.MELTING", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.POISON", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.PROJECTILE", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.STARVATION", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.SUFFOCATION", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.SUICIDE", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.THORNS", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.VOID", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Entity.Options.WITHER", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.All", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.BLOCK_EXPLOSION", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.CONTACT", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.CUSTOM", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.DROWNING", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.ENTITY_ATTACK", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.ENTITY_EXPLOSION", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.FALL", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.FALLING_BLOCK", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.FALLING_BLOCK", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.FIRE", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.FIRE_TICK", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.LAVA", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.LIGHTNING", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.MAGIC", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.MELTING", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.POISON", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.PROJECTILE", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.STARVATION", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.SUFFOCATION", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.SUICIDE", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.THORNS", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.VOID", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.Options.Player.Options.WITHER", Boolean.valueOf(true));
            Config.set("Server.Disable.Damage.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.Damage.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.Weather.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.Weather.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.Weather.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.ThunderChange.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.ThunderChange.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.ThunderChange.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.Burn-block.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.Burn-block.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.Burn-block.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.BlockIgnite-FireSpread.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.BlockIgnite-FireSpread.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.BlockIgnite-FireSpread.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.Explosion.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.Explosion.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.Explosion.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.Death-Message.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.Death-Message.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.Death-Message.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.Spawning-Monster-Animals.Enable", Boolean.valueOf(true));
            Config.set("Server.Disable.Spawning-Monster-Animals.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.Spawning-Monster-Animals.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.Leave-Decay.Disable", Boolean.valueOf(true));
            Config.set("Server.Disable.Leave-Decay.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.Leave-Decay.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.LightningStrike.Disable", Boolean.valueOf(true));
            Config.set("Server.Disable.LightningStrike.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.LightningStrike.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            Config.set("Server.Disable.Block-Fade.Disable", Boolean.valueOf(true));
            Config.set("Server.Disable.Block-Fade.World.All_World", Boolean.valueOf(false));
            Config.set("Server.Disable.Block-Fade.World.Worlds", java.util.Arrays.asList(new String[] {
                    "world",
                    "world_nether"
                }));
            
            saveConfigFile();

        }
    }
}
