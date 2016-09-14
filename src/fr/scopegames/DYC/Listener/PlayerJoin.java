package fr.scopegames.DYC.Listener;

import fr.scopegames.DYC.Game.GameManager;
import fr.scopegames.DYC.Game.GameState;
import fr.scopegames.DYC.Main;
import fr.scopegames.DYC.utils.ChatUtils;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.Plugin;

public class PlayerJoin
implements Listener {
    Location SpawnBleu = new Location(Bukkit.getWorld((String)"world"), 0.0, 100.0, 0.0);
    Location SpawnRouge = new Location(Bukkit.getWorld((String)"world"), 30.0, 100.0, 30.0);
    int timer = 121;
    int task;
    boolean start = false;
    String ItemBleu = "\u00a71Equipe Bleu";
    String ItemRouge = "\u00a7cEquipe Rouge";

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        final ItemStack boots2 = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta iboots2 = (LeatherArmorMeta)boots2.getItemMeta();
        iboots2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        iboots2.spigot().setUnbreakable(true);
        iboots2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        iboots2.setColor(Color.RED);
        boots2.setItemMeta((ItemMeta)iboots2);
        final ItemStack helmet2 = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta ihelmet2 = (LeatherArmorMeta)helmet2.getItemMeta();
        ihelmet2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ihelmet2.spigot().setUnbreakable(true);
        ihelmet2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ihelmet2.setColor(Color.RED);
        helmet2.setItemMeta((ItemMeta)ihelmet2);
        final ItemStack jamb2 = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta ijamb2 = (LeatherArmorMeta)jamb2.getItemMeta();
        ijamb2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ijamb2.spigot().setUnbreakable(true);
        ijamb2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ijamb2.setColor(Color.RED);
        jamb2.setItemMeta((ItemMeta)ijamb2);
        final ItemStack chest2 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta ichest2 = (LeatherArmorMeta)chest2.getItemMeta();
        ichest2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ichest2.spigot().setUnbreakable(true);
        ichest2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ichest2.setColor(Color.RED);
        chest2.setItemMeta((ItemMeta)ichest2);
        final ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta iboots = (LeatherArmorMeta)boots.getItemMeta();
        iboots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        iboots.spigot().setUnbreakable(true);
        iboots.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        iboots.setColor(Color.BLUE);
        boots.setItemMeta((ItemMeta)iboots);
        final ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta ihelmet = (LeatherArmorMeta)helmet.getItemMeta();
        ihelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ihelmet.spigot().setUnbreakable(true);
        ihelmet.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ihelmet.setColor(Color.BLUE);
        helmet.setItemMeta((ItemMeta)ihelmet);
        final ItemStack jamb = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta ijamb = (LeatherArmorMeta)jamb.getItemMeta();
        ijamb.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ijamb.spigot().setUnbreakable(true);
        ijamb.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ijamb.setColor(Color.BLUE);
        jamb.setItemMeta((ItemMeta)ijamb);
        final ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta ichest = (LeatherArmorMeta)chest.getItemMeta();
        ichest.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ichest.spigot().setUnbreakable(true);
        ichest.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ichest.setColor(Color.BLUE);
        chest.setItemMeta((ItemMeta)ichest);
        final ItemStack BlueWool = new ItemStack(Material.WOOL, 1, 11);
        ItemMeta iBlueMeta = BlueWool.getItemMeta();
        iBlueMeta.setDisplayName(this.ItemBleu);
        BlueWool.setItemMeta(iBlueMeta);
        final ItemStack RedWool = new ItemStack(Material.WOOL, 1, 14);
        ItemMeta iRedMeta = RedWool.getItemMeta();
        iRedMeta.setDisplayName(this.ItemRouge);
        RedWool.setItemMeta(iRedMeta);
        final Player p = e.getPlayer();
        p.getInventory().clear();
        p.getInventory().setArmorContents(null);
        p.setFoodLevel(20);
        p.setHealth(20.0);
        p.getInventory().setItem(0, BlueWool);
        p.getInventory().setItem(1, RedWool);
        Main.getInstance().inGame.add(p);
        e.setJoinMessage(String.valueOf(ChatUtils.prefix) + p.getName() + " \u00a72a rejoin la partie " + Main.getInstance().inGame.size() + "\u00a7a/20");
        p.setPlayerListName(p.getName());
        if (Main.getInstance().inGame.size() >= 1 && !this.start) {
            this.task = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getInstance(), new Runnable(){

                @Override
                public void run() {
                    PlayerJoin.this.start = true;
                    --PlayerJoin.this.timer;
                    if (PlayerJoin.this.timer == 120) {
                        Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a76La partie commence dans 2 minutes "));
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.sendTitle(" \u00a76Commencement dans ", " \u00a762 minutes ");
                        }
                    } else if (PlayerJoin.this.timer == 60) {
                        Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a76La partie va commencer dans 1 minute "));
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.sendTitle(" \u00a76Commencement dans ", " \u00a761 minute ");
                        }
                    }
                    if (PlayerJoin.this.timer == 30 || PlayerJoin.this.timer == 10 || PlayerJoin.this.timer == 5 || PlayerJoin.this.timer == 4 || PlayerJoin.this.timer == 3 || PlayerJoin.this.timer == 2 || PlayerJoin.this.timer == 1) {
                        Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a76La partie commence dans " + PlayerJoin.this.timer + " \u00a76S "));
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.sendTitle(" \u00a76Commencement dans ", "\u00a72" + PlayerJoin.this.timer);
                        }
                    }
                    if (PlayerJoin.this.timer == 0) {
                        p.getInventory().remove(RedWool);
                        p.getInventory().remove(BlueWool);
                        Bukkit.getScheduler().cancelTask(PlayerJoin.this.task);
                        GameState.setState(GameState.PREGAME);
                        GameManager.pregame();
                        if (Main.getInstance().TeamBlue.contains((Object)p)) {
                            p.getInventory().clear();
                            p.getInventory().setBoots(boots2);
                            p.getInventory().setChestplate(chest2);
                            p.getInventory().setHelmet(helmet2);
                            p.getInventory().setLeggings(jamb2);
                            p.teleport(PlayerJoin.this.SpawnBleu);
                        } else if (Main.getInstance().TeamRed.contains((Object)p)) {
                            p.teleport(PlayerJoin.this.SpawnRouge);
                            p.getInventory().clear();
                            p.getInventory().setBoots(boots);
                            p.getInventory().setChestplate(chest);
                            p.getInventory().setHelmet(helmet);
                            p.getInventory().setLeggings(jamb);
                        }
                    }
                }
            }, 20, 20);
        }
    }

    @EventHandler
    public void onQuit(PlayerQuitEvent e) {
        Player p = e.getPlayer();
        if (GameState.isState(GameState.LOBBY) && Main.getInstance().inGame.size() < 2) {
            Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a76Le lancement de la partie a \u00e9t\u00e9 annul\u00e9 par manque de joueur "));
            this.start = false;
            Bukkit.getScheduler().cancelAllTasks();
        }
        Main.getInstance().inGame.remove((Object)p);
        e.setQuitMessage(String.valueOf(ChatUtils.prefix) + p.getName() + " \u00a7ca quitt\u00e9 la partie " + Main.getInstance().inGame.size() + "/\u00a7c20 ");
        if (Main.getInstance().TeamBlue.contains((Object)p)) {
            Main.getInstance().TeamBlue.remove((Object)p);
        } else if (Main.getInstance().TeamRed.contains((Object)p)) {
            Main.getInstance().TeamRed.remove((Object)p);
        }
    }

}