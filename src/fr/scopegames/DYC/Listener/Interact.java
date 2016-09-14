package fr.scopegames.DYC.Listener;

import fr.scopegames.DYC.Main;
import fr.scopegames.DYC.utils.ChatUtils;
import java.util.ArrayList;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.util.Vector;

public class Interact
implements Listener {
    String ItemBleu = "\u00a71Equipe Bleu";
    String ItemRouge = "\u00a7cEquipe Rouge";

    @EventHandler
    public void interact(PlayerInteractEvent e) {
        ItemStack TeamBlue = new ItemStack(Material.WOOL, 1, 9);
        ItemMeta TeamBlueM = TeamBlue.getItemMeta();
        TeamBlueM.setDisplayName(this.ItemBleu);
        TeamBlueM.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES});
        TeamBlue.setItemMeta(TeamBlueM);
        ItemStack TeamRed = new ItemStack(Material.WOOL, 1, 14);
        ItemMeta TeamRedM = TeamRed.getItemMeta();
        TeamRedM.setDisplayName(this.ItemRouge);
        TeamRedM.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_ATTRIBUTES});
        TeamRed.setItemMeta(TeamRedM);
        Player p = e.getPlayer();
        ItemStack mat = p.getInventory().getItemInHand();
        if (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK) {
            if (mat == null) {
                return;
            }
            if (mat.getItemMeta().getDisplayName().equalsIgnoreCase(this.ItemBleu)) {
                if (Main.getInstance().TeamRed.contains((Object)p)) {
                    Main.getInstance().TeamRed.remove((Object)p);
                }
                if (Main.getInstance().TeamBlue.contains((Object)p)) {
                    p.sendMessage("\u00a7cVous \u00eates d\u00e9j\u00e0 dans cette \u00e9quipe");
                } else {
                    Main.getInstance().TeamBlue.add(p);
                    p.setPlayerListName("\u00a7b" + p.getName());
                    p.sendMessage(String.valueOf(ChatUtils.prefix) + " \u00a7fVous avez rejoins l'\u00e9quipe \u00a7bBleu");
                }
            }
            if (mat.getItemMeta().getDisplayName().equalsIgnoreCase(this.ItemRouge)) {
                if (Main.getInstance().TeamBlue.contains((Object)p)) {
                    Main.getInstance().TeamBlue.remove((Object)p);
                }
                if (Main.getInstance().TeamRed.contains((Object)p)) {
                    p.sendMessage("\u00a7cVous \u00eates d\u00e9j\u00e0 dans cette \u00e9quipe");
                } else {
                    Main.getInstance().TeamRed.add(p);
                    p.setPlayerListName("\u00a7c" + p.getName());
                    p.sendMessage(String.valueOf(ChatUtils.prefix) + " \u00a7fVous avez rejoins l'\u00e9quipe \u00a7cRouge");
                }
            }
        }
        if (mat.getItemMeta().getDisplayName().equalsIgnoreCase("\u00a7cTnt De Lanc\u00e9") && (e.getAction() == Action.RIGHT_CLICK_AIR || e.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            TNTPrimed tnt = (TNTPrimed)p.getLocation().getWorld().spawnEntity(p.getLocation(), EntityType.PRIMED_TNT);
            tnt.setVelocity(p.getLocation().getDirection().multiply(2));
        }
    }
}