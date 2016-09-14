package fr.scopegames.DYC.utils;

import fr.scopegames.DYC.Main;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.OfflinePlayer;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;

public class LifeCount
implements Listener {
    Location spawnblue = new Location(Bukkit.getWorld((String)"world"), 0.0, 100.0, 0.0);
    Location spawnred = new Location(Bukkit.getWorld((String)"world"), 0.0, 100.0, 0.0);

    @EventHandler
    public void onDeath(PlayerDeathEvent e) {
        Player p = ((OfflinePlayer)e).getPlayer();
        Player killer = p.getKiller();
        Main.getInstance().Death.add(p);
        if (Main.getInstance().TeamBlue.contains((Object)p)) {
            p.teleport(this.spawnblue);
        }
        if (Main.getInstance().TeamRed.contains((Object)p)) {
            p.teleport(this.spawnred);
        }
        Bukkit.broadcastMessage((String)(String.valueOf(p.getName()) + " \u00a7cest mort a cause de " + (Object)killer));
        LifeCount.countdeath();
    }

    public static void countdeath() {
        if (Main.getInstance().Death.size() == 10) {
            for (Player pl : Bukkit.getOnlinePlayers()) {
                if (!pl.isDead()) continue;
                pl.sendMessage(String.valueOf(pl.getName()) + " \u00a7cVous \u00eates mort ");
                pl.setGameMode(GameMode.SPECTATOR);
                if (Main.getInstance().TeamBlue.contains((Object)pl)) {
                    Main.getInstance().TeamBlue.remove((Object)pl);
                }
                if (!Main.getInstance().TeamRed.contains((Object)pl)) continue;
                Main.getInstance().TeamRed.remove((Object)pl);
            }
        }
    }
}