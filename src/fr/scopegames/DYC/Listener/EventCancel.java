package fr.scopegames.DYC.Listener;

import fr.scopegames.DYC.Main;
import java.util.ArrayList;
import java.util.List;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.TNTPrimed;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class EventCancel
implements Listener {
    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        e.setCancelled(true);
    }

    @EventHandler
    public void boom(EntityExplodeEvent e) {
        Entity tnt = e.getEntity();
        if (tnt != null && tnt instanceof TNTPrimed) {
            e.blockList().clear();
        }
        List destroy = e.blockList();
        for (Block block : destroy) {
            if (Main.getInstance().tntbleu.size() <= 1) {
                block.setData(11, true);
                Main.getInstance().tntbleu.remove(1);
            }
            if (Main.getInstance().tntrouge.size() > 1 || block.isEmpty() && !block.isLiquid()) continue;
            block.setData(14, true);
        }
    }
}