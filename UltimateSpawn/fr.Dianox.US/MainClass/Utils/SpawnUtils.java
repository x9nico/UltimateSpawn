package fr.Dianox.US.MainClass.Utils;

import org.bukkit.entity.Player;

import fr.Dianox.US.MainClass.config.ConfigMessage;
import fr.Dianox.US.MainClass.config.ConfigSpawn;

public class SpawnUtils {

    public static void teleportToSpawn(Player player) {
        try {
            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigSpawn.getConfig().getString("spawn.world"));
            double x = ConfigSpawn.getConfig().getDouble("spawn.x");
            double y = ConfigSpawn.getConfig().getDouble("spawn.y");
            double z = ConfigSpawn.getConfig().getDouble("spawn.z");
            float yaw = ConfigSpawn.getConfig().getInt("spawn.yaw");
            float pitch = ConfigSpawn.getConfig().getInt("spawn.pitch");

            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));
        } catch (Exception e) {
            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");

            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Spawn-not-set"), player);
        }
    }

    public static void teleportToSpawn(Player player, boolean message) {
        try {
            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigSpawn.getConfig().getString("spawn.world"));
            double x = ConfigSpawn.getConfig().getDouble("spawn.x");
            double y = ConfigSpawn.getConfig().getDouble("spawn.y");
            double z = ConfigSpawn.getConfig().getDouble("spawn.z");
            float yaw = ConfigSpawn.getConfig().getInt("spawn.yaw");
            float pitch = ConfigSpawn.getConfig().getInt("spawn.pitch");

            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));

            if (message) {
                PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Teleport.To-spawn"), player);
            }
        } catch (Exception e) {
            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");

            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Spawn-not-set"), player);
        }
    }

    public static void teleportToSpawn(Player player, org.bukkit.command.CommandSender sender) {
        try {
            org.bukkit.World w = org.bukkit.Bukkit.getServer().getWorld(ConfigSpawn.getConfig().getString("spawn.world"));
            double x = ConfigSpawn.getConfig().getDouble("spawn.x");
            double y = ConfigSpawn.getConfig().getDouble("spawn.y");
            double z = ConfigSpawn.getConfig().getDouble("spawn.z");
            float yaw = ConfigSpawn.getConfig().getInt("spawn.yaw");
            float pitch = ConfigSpawn.getConfig().getInt("spawn.pitch");

            player.teleport(new org.bukkit.Location(w, x, y, z, yaw, pitch));

            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Teleport.To-spawn"), player);
            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Player.Teleport.To-spawn-other"), (Player) sender);
        } catch (Exception e) {
            org.bukkit.Bukkit.getLogger().warning("UltimateSpawn : Spawn is not set");

            PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Error.Spawn-not-set"), player);
        }
    }

}
