package fr.scopegames.DYC.utils;

import fr.scopegames.DYC.Main;
import fr.scopegames.DYC.utils.ChatUtils;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.block.Block;
import org.bukkit.plugin.Plugin;
import org.spigotmc.RestartCommand;

public class Victory {
    static int timer = 11;
    static int task;

    public static void check() {
        if (Main.getInstance().BlockBlue.size() < Main.getInstance().BlockRed.size()) {
            Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a72L'\u00e9quipe \u00a7cROUGE \u00a72 a gagn\u00e9 avec un total de  " + Main.getInstance().BlockRed.size() + " \u00a72blocks captur\u00e9s "));
            Bukkit.broadcastMessage((String)(" Contre " + Main.getInstance().BlockBlue.size() + " \u00a72blocks captur\u00e9s pour les \u00a7bBleus"));
        } else if (Main.getInstance().BlockBlue.size() > Main.getInstance().BlockRed.size()) {
            Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a72L'\u00e9quipe \u00a7bBleu \u00a72 a gagn\u00e9 avec un total de  " + Main.getInstance().BlockBlue.size() + " \u00a72blocks captur\u00e9s "));
            Bukkit.broadcastMessage((String)(" Contre " + Main.getInstance().BlockRed.size() + " \u00a72blocks captur\u00e9s pour les \u00a7cRouges"));
        } else {
            Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a7cQuel dommage aucune equipe n'a gagne "));
        }
    }

    public static void finish() {
        task = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getInstance(), new Runnable(){

            @Override
            public void run() {
                if (--Victory.timer <= 10 && Victory.timer != 0) {
                    Bukkit.broadcastMessage((String)("\u00a76Le serveur redemarre dans " + Victory.timer + " S"));
                }
                if (Victory.timer == 0) {
                    Bukkit.getScheduler().cancelAllTasks();
                    Bukkit.broadcastMessage((String)"\u00a76Partie termin\u00e9e");
                    RestartCommand.restart();
                }
            }
        }, 20, 20);
    }

}