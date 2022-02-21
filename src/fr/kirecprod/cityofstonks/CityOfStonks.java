package fr.kirecprod.cityofstonks;

import com.sun.istack.internal.logging.Logger;
import fr.kirecprod.cityofstonks.listeners.SheepListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CityOfStonks extends JavaPlugin {

    public void onLoad() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[ CityOfStonks ] : Le Plugin démarre");
    }

    public void onEnable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[ CityOfStonks ] : Le plugin a démarré avec succès");

        Bukkit.getServer().getPluginManager().registerEvents(new SheepListener(), this);
    }

    public void onDisable() {
        Bukkit.getConsoleSender().sendMessage(ChatColor.AQUA + "[ CityOfStonks ] : Le plugin s'est arrêté");
    }

}
