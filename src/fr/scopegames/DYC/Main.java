package fr.scopegames.DYC;

import fr.dinnerwolph.scopegamesapi.utils.UpdateUtils;
import fr.scopegames.DYC.Game.GameState;
import fr.scopegames.DYC.Listener.ListenerManager;
import fr.scopegames.DYC.commands.commandstart;
import java.io.IOException;
import java.util.ArrayList;
import org.bukkit.block.Block;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.PluginCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public class Main
extends JavaPlugin {
    public ArrayList<Player> inGame = new ArrayList();
    public ArrayList<Player> TeamBlue = new ArrayList();
    public ArrayList<Player> TeamRed = new ArrayList();
    public ArrayList<Block> BlockBlue = new ArrayList();
    public ArrayList<Block> BlockRed = new ArrayList();
    public ArrayList<Player> Death = new ArrayList();
    public ArrayList<Block> tntrouge = new ArrayList();
    public ArrayList<Block> tntbleu = new ArrayList();
    public static Main instance;

    public static Main getInstance() {
        return instance;
    }

    public void onEnable() {
        try {
            new fr.dinnerwolph.scopegamesapi.utils.UpdateUtils((Plugin)this);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        this.getCommand("start").setExecutor((CommandExecutor)new commandstart());
        instance = this;
        GameState.setState(GameState.LOBBY);
        new ListenerManager(this).registerEvents();
    }
}


