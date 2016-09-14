package fr.scopegames.DYC.weapon;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class Weapon
implements Listener {
    @EventHandler
    public void onPlace(BlockPlaceEvent e) {
        Location spawn = e.getBlock().getLocation();
        if (e.getBlock().getType() == Material.TNT) {
            Bukkit.getWorld((String)"world").spawnEntity(spawn, EntityType.PRIMED_TNT);
            e.setCancelled(true);
        } else {
            e.setCancelled(true);
        }
    }
}