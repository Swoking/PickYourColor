package fr.scopegames.DYC.commands;

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
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class commandstart
implements CommandExecutor {
    public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] arg3) {
        ItemStack boots2 = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta iboots2 = (LeatherArmorMeta)boots2.getItemMeta();
        iboots2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        iboots2.spigot().setUnbreakable(true);
        iboots2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        iboots2.setColor(Color.RED);
        boots2.setItemMeta((ItemMeta)iboots2);
        ItemStack helmet2 = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta ihelmet2 = (LeatherArmorMeta)helmet2.getItemMeta();
        ihelmet2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ihelmet2.spigot().setUnbreakable(true);
        ihelmet2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ihelmet2.setColor(Color.RED);
        helmet2.setItemMeta((ItemMeta)ihelmet2);
        ItemStack jamb2 = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta ijamb2 = (LeatherArmorMeta)jamb2.getItemMeta();
        ijamb2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ijamb2.spigot().setUnbreakable(true);
        ijamb2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ijamb2.setColor(Color.RED);
        jamb2.setItemMeta((ItemMeta)ijamb2);
        ItemStack chest2 = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta ichest2 = (LeatherArmorMeta)chest2.getItemMeta();
        ichest2.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ichest2.spigot().setUnbreakable(true);
        ichest2.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ichest2.setColor(Color.RED);
        chest2.setItemMeta((ItemMeta)ichest2);
        ItemStack boots = new ItemStack(Material.LEATHER_BOOTS);
        LeatherArmorMeta iboots = (LeatherArmorMeta)boots.getItemMeta();
        iboots.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        iboots.spigot().setUnbreakable(true);
        iboots.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        iboots.setColor(Color.BLUE);
        boots.setItemMeta((ItemMeta)iboots);
        ItemStack helmet = new ItemStack(Material.LEATHER_HELMET);
        LeatherArmorMeta ihelmet = (LeatherArmorMeta)helmet.getItemMeta();
        ihelmet.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ihelmet.spigot().setUnbreakable(true);
        ihelmet.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ihelmet.setColor(Color.BLUE);
        helmet.setItemMeta((ItemMeta)ihelmet);
        ItemStack jamb = new ItemStack(Material.LEATHER_LEGGINGS);
        LeatherArmorMeta ijamb = (LeatherArmorMeta)jamb.getItemMeta();
        ijamb.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ijamb.spigot().setUnbreakable(true);
        ijamb.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ijamb.setColor(Color.BLUE);
        jamb.setItemMeta((ItemMeta)ijamb);
        ItemStack chest = new ItemStack(Material.LEATHER_CHESTPLATE);
        LeatherArmorMeta ichest = (LeatherArmorMeta)chest.getItemMeta();
        ichest.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 1, true);
        ichest.spigot().setUnbreakable(true);
        ichest.addItemFlags(new ItemFlag[]{ItemFlag.HIDE_ATTRIBUTES, ItemFlag.HIDE_ENCHANTS, ItemFlag.HIDE_UNBREAKABLE});
        ichest.setColor(Color.BLUE);
        chest.setItemMeta((ItemMeta)ichest);
        Location SpawnBleu = new Location(Bukkit.getWorld((String)"world"), 0.0, 100.0, 0.0);
        Location SpawnRouge = new Location(Bukkit.getWorld((String)"world"), 30.0, 100.0, 30.0);
        Bukkit.getScheduler().cancelAllTasks();
        GameState.setState(GameState.PREGAME);
        GameManager.pregame();
        Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + sender.getName() + " \u00a76a forc\u00e9 le d\u00e9marrage "));
        for (Player p : Bukkit.getOnlinePlayers()) {
            if (Main.getInstance().TeamBlue.contains((Object)p)) {
                p.getInventory().clear();
                p.getInventory().setBoots(boots2);
                p.getInventory().setChestplate(chest2);
                p.getInventory().setHelmet(helmet2);
                p.getInventory().setLeggings(jamb2);
                p.teleport(SpawnBleu);
                continue;
            }
            if (!Main.getInstance().TeamRed.contains((Object)p)) continue;
            p.teleport(SpawnRouge);
            p.getInventory().clear();
            p.getInventory().setBoots(boots);
            p.getInventory().setChestplate(chest);
            p.getInventory().setHelmet(helmet);
            p.getInventory().setLeggings(jamb);
        }
        return true;
    }
}