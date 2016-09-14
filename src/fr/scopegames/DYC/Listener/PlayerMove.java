package fr.scopegames.DYC.Listener;

import fr.scopegames.DYC.Game.GameState;
import fr.scopegames.DYC.Main;
import fr.scopegames.DYC.utils.BlockBlackList;
import java.util.ArrayList;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public class PlayerMove
implements Listener {
    ScoreboardManager manager = Bukkit.getScoreboardManager();
    Scoreboard board = this.manager.getNewScoreboard();
    Objective obj = this.board.registerNewObjective("pyc", "dummy");

    @EventHandler
    public void onMove(PlayerMoveEvent e) {
        this.obj.setDisplaySlot(DisplaySlot.SIDEBAR);
        this.obj.setDisplayName("\u00a7cPickYourColor");
        Score space = this.obj.getScore("");
        space.setScore(4);
        Score bb = this.obj.getScore("\u00a7bBlock Bleu: " + Main.getInstance().BlockBlue.size());
        bb.setScore(3);
        Score space2 = this.obj.getScore("");
        space2.setScore(2);
        Score br = this.obj.getScore("\u00a7cBlock Rouge: " + Main.getInstance().BlockRed.size());
        br.setScore(1);
        Player p = e.getPlayer();
        Location loc = new Location(Bukkit.getWorld((String)"world"), (double)p.getLocation().getBlockX(), (double)(p.getLocation().getBlockY() - 1), (double)p.getLocation().getBlockZ());
        if (GameState.isState(GameState.GAME) && p.getGameMode() != GameMode.SPECTATOR) {
            Block b2 = p.getWorld().getBlockAt(loc.getBlockX(), loc.getBlockY(), loc.getBlockZ());
            Material material = b2.getType();
            if (BlockBlackList.getBlackList().contains((Object)material) || b2.isLiquid() || b2.isEmpty()) {
                return;
            }
            if (Main.getInstance().TeamBlue.contains((Object)p)) {
                b2.setType(Material.STAINED_GLASS);
                b2.setData(11);
                Main.getInstance().BlockBlue.add(b2);
            } else if (Main.getInstance().TeamRed.contains((Object)p)) {
                b2.setType(Material.STAINED_GLASS);
                b2.setData(14);
                Main.getInstance().BlockRed.add(b2);
            }
        }
    }
}