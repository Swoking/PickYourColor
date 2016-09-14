package fr.scopegames.DYC.Listener;

import fr.scopegames.DYC.Listener.EventCancel;
import fr.scopegames.DYC.Listener.Interact;
import fr.scopegames.DYC.Listener.PlayerJoin;
import fr.scopegames.DYC.Listener.PlayerMove;
import fr.scopegames.DYC.Main;
import fr.scopegames.DYC.utils.LifeCount;
import fr.scopegames.DYC.weapon.Weapon;
import org.bukkit.Bukkit;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenerManager {
    public Main pl;

    public ListenerManager(Main PYC) {
        this.pl = PYC;
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents((Listener)new PlayerJoin(), (Plugin)this.pl);
        pm.registerEvents((Listener)new Interact(), (Plugin)this.pl);
        pm.registerEvents((Listener)new PlayerMove(), (Plugin)this.pl);
        pm.registerEvents((Listener)new EventCancel(), (Plugin)this.pl);
        pm.registerEvents((Listener)new LifeCount(), (Plugin)this.pl);
        pm.registerEvents((Listener)new Weapon(), (Plugin)this.pl);
    }
}