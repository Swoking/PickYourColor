package fr.scopegames.DYC.utils;

import fr.scopegames.DYC.Game.GameState;
import fr.scopegames.DYC.Main;
import fr.scopegames.DYC.utils.ChatUtils;
import fr.scopegames.DYC.utils.Victory;
import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class start {
    static int timer = 301;
    static int task;

    public static void Game() {
        ItemStack tnt = new ItemStack(Material.TNT, 1);
        ItemMeta tntm = tnt.getItemMeta();
        tntm.setDisplayName("\u00a7bBombe de couleur");
        tnt.setItemMeta(tntm);
        final ItemStack tntlance = new ItemStack(Material.TNT, 1);
        ItemMeta tntlancemeta = tntlance.getItemMeta();
        tntlancemeta.setDisplayName("\u00a7cTnt De Lanc\u00e9");
        tntlance.setItemMeta(tntlancemeta);
        final ItemStack creeper = new ItemStack(Material.MONSTER_EGG, 1, EntityType.CREEPER.getTypeId());
        ItemMeta cm = creeper.getItemMeta();
        cm.setDisplayName("\u00a72KAWABONGA");
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getInstance(), new Runnable(){

            @Override
            public void run() {
                if (--start.timer == 240 || start.timer == 180 || start.timer == 120 || start.timer == 60 || start.timer == 50 || start.timer == 40 || start.timer == 30 || start.timer == 20 || start.timer == 10) {
                    for (Player pl : Bukkit.getOnlinePlayers()) {
                        Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a7cplus d'objet pour ... plus de DESTRUCTION !"));
                        pl.getInventory().addItem(new ItemStack[]{ItemStack.this});
                        pl.getInventory().addItem(new ItemStack[]{creeper});
                        pl.getInventory().addItem(new ItemStack[]{tntlance});
                    }
                }
                if (start.timer == 60) {
                    Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a76Il vous reste une minute "));
                } else if (start.timer == 0) {
                    GameState.setState(GameState.FINISH);
                    Victory.check();
                    Victory.finish();
                }
            }
        }, 20, 20);
    }

}