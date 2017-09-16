package fr.Dianox.US.MainClass.event;

import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockBurnEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.ExplosionPrimeEvent;
import org.bukkit.event.entity.FoodLevelChangeEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerItemDamageEvent;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.event.weather.WeatherChangeEvent;

import fr.Dianox.US.MainClass.Utils.PlaceHolderMessageUtils;
import fr.Dianox.US.MainClass.config.ConfigGlobal;
import fr.Dianox.US.MainClass.config.ConfigMessage;

public class BasicFeatures implements Listener {

    //Disable Hunger
    @EventHandler
    public void foodChangeLevel(FoodLevelChangeEvent e) {

        if (e.getEntityType() == EntityType.PLAYER) {
            if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Hunger")) {
                e.setCancelled(true);
            }

            if (ConfigGlobal.getConfig().getBoolean("Server.Disable-Hunger")) {
                Player p = (Player) e.getEntity();

                if (p.getFoodLevel() < 19.0D) {
                    p.setFoodLevel(20);
                }
            }
        }
    }

    //Disable Damage
    @EventHandler
    public void DisableDamage(EntityDamageEvent e) {
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Damage")) {
            if (ConfigGlobal.getConfig().getBoolean("Debug-in-case-of-problem.Disable.Damage-TO-EVERYTHING")) {
                e.setCancelled(true);
            } else {
                if (e.getEntity() instanceof Player) {
                    e.setCancelled(true);
                }
            }
        }
    }

    //Disable Weather
    @EventHandler
    public void WeatherDisable(WeatherChangeEvent e) {
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Weather")) {
            e.setCancelled(true);
        }
    }

    // Disable construct
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Player p = e.getPlayer();

        if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Construct")) {
            if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Construct-Bypass")) {
                if (!p.hasPermission("UltimateSpawn.bypass.Construct")) {
                    e.setCancelled(true);
                    if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Message")) {
                        PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Messaged"), p);
                    }
                }
            } else {
                e.setCancelled(true);
                if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Message")) {
                    PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Messaged"), p);
                }
            }
        }
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player p = e.getPlayer();

        if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Construct")) {
            if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Construct-Bypass")) {
                if (!p.hasPermission("UltimateSpawn.bypass.Construct")) {
                    e.setCancelled(true);
                    if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Message")) {
                        PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Messaged"), p);
                    }
                }
            } else {
                e.setCancelled(true);
                if (ConfigGlobal.getConfig().getBoolean("Protection.Construct.Message")) {
                	PlaceHolderMessageUtils.ReplaceCharMessagePlayer(ConfigMessage.getConfig().getString("Protection.Construct-Messaged"), p);
                }
            }
        }
    }

    // Block Burn
    @EventHandler
    public void BlockBurn(BlockBurnEvent e) {
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Burn-block")) {
            e.setCancelled(true);
        }
    }

    // Protect item for player
    @EventHandler
    public void onDrop(PlayerDropItemEvent e) {
        Player p = e.getPlayer();

        if (ConfigGlobal.getConfig().getBoolean("Server.Items.Drop.Disable")) {
            if (ConfigGlobal.getConfig().getBoolean("Server.Items.Drop.Bypass")) {
                if (!p.hasPermission("UltimateSpawn.bypass.DropItem")) {
                    e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onPickUp(PlayerPickupItemEvent e) {
        Player p = e.getPlayer();

        if (ConfigGlobal.getConfig().getBoolean("Server.Items.PickUp.Disable")) {
            if (ConfigGlobal.getConfig().getBoolean("Server.Items.PickUp.Bypass")) {
                if (!p.hasPermission("UltimateSpawn.bypass.PickUpItem")) {
                    e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onMove(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();

        if (ConfigGlobal.getConfig().getBoolean("Server.Items.Move.Disable")) {
            if (ConfigGlobal.getConfig().getBoolean("Server.Items.Move.Bypass")) {
                if (!p.hasPermission("UltimateSpawn.bypass.MoveItem")) {
                    e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }

    @EventHandler
    public void onDamageItem(PlayerItemDamageEvent e) {
        Player p = e.getPlayer();

        if (ConfigGlobal.getConfig().getBoolean("Server.Items.Damage-Item.Disable")) {
            if (ConfigGlobal.getConfig().getBoolean("Server.Items.Damage-Item.Bypass")) {
                if (!p.hasPermission("UltimateSpawn.bypass.DamageItem")) {
                    e.setCancelled(true);
                }
            } else {
                e.setCancelled(true);
            }
        }
    }

    // Explosion
    @EventHandler
    public void onExplode(ExplosionPrimeEvent e) {
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Explosion")) {
            e.setCancelled(true);
        }
    }

    // Death event
    @EventHandler
    public void onDeathEvent(PlayerDeathEvent e) {
        Player p = e.getEntity();

        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Death-Message")) {
            e.setDeathMessage(null);
        }

        if (ConfigGlobal.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.Enable")) {
            if (ConfigGlobal.getConfig().getBoolean("Server.Items.Clear-Drops-On-Death.Bypass")) {
                if (!p.hasPermission("UltimateSpawn.bypass.ClearDropOnDeath")) {
                    if ((e.getEntity() instanceof Player)) {
                        e.getDrops().clear();
                        forceDelete(e);
                    }
                }
            } else {
                if ((e.getEntity() instanceof Player)) {
                    e.getDrops().clear();
                    forceDelete(e);
                }
            }
        }
    }

    public void forceDelete(EntityDeathEvent e) {
        for (int i = 0; i < e.getDrops().size(); i++)
            e.getDrops().remove(i);
    }

    // Disable Spawning
    @EventHandler
    public void onSpawning(CreatureSpawnEvent e) {
        if (ConfigGlobal.getConfig().getBoolean("Server.Disable.Spawning-Monster-Animals")) {
            e.setCancelled(true);
        }
    }

}
