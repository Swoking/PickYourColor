package fr.scopegames.DYC.Game;

import fr.scopegames.DYC.Game.GameState;
import fr.scopegames.DYC.Main;
import fr.scopegames.DYC.utils.ChatUtils;
import fr.scopegames.DYC.utils.start;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

public class GameManager {
    static int timer = 11;
    static int task;

    public static void pregame() {
        if (GameState.isState(GameState.PREGAME)) {
            task = Bukkit.getScheduler().scheduleSyncRepeatingTask((Plugin)Main.getInstance(), new Runnable(){

                @Override
                public void run() {
                    if (--GameManager.timer == 10 || GameManager.timer == 5 || GameManager.timer == 4 || GameManager.timer == 3 || GameManager.timer == 2 || GameManager.timer == 1) {
                        Bukkit.broadcastMessage((String)(String.valueOf(ChatUtils.prefix) + " \u00a7cPrise des blocs activ\u00e9 dans " + GameManager.timer));
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.sendTitle(" \u00a7cPrise des blocs ", " \u00a72activ\u00e9 dans  " + GameManager.timer);
                        }
                    }
                    if (GameManager.timer == 0) {
                        for (Player pl : Bukkit.getOnlinePlayers()) {
                            pl.sendTitle(" \u00a7cPrise des blocs ", " \u00a72activ\u00e9 dans  " + GameManager.timer);
                            pl.sendMessage(String.valueOf(ChatUtils.prefix) + " \u00a72Bonne chance " + pl.getDisplayName());
                        }
                        Bukkit.getScheduler().cancelTask(GameManager.task);
                        GameState.setState(GameState.GAME);
                        start.Game();
                    }
                }
            }, 20, 20);
        }
    }

}