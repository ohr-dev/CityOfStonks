package fr.kirecprod.cityofstonks;

import fr.kirecprod.cityofstonks.command.CommandCraft;
import fr.kirecprod.cityofstonks.command.CommandFurnace;
import fr.kirecprod.cityofstonks.listeners.JoinQuitListener;
import fr.kirecprod.cityofstonks.listeners.killListener;
import fr.kirecprod.cityofstonks.scoreboards.DeathCount;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class CityOfStonks extends JavaPlugin {

    private static CityOfStonks instance;

    public void onLoad() {
        System.out.println("[ CityOfStonks ] : Le Plugin démarre");
    }



    public void onEnable() {
        saveDefaultConfig();
        System.out.println("[ CityOfStonks ] : Le plugin a démarré avec succès");

        // COMMANDS
        getCommand("craft").setExecutor(new CommandCraft(this));
        getCommand("furnace").setExecutor(new CommandFurnace(this));
        // COMMANDS
        // EVENTS
        Bukkit.getServer().getPluginManager().registerEvents(new killListener(), this);
        Bukkit.getServer().getPluginManager().registerEvents(new JoinQuitListener(), this);
        // EVENTS
        // SCOREBOARDS
        Bukkit.getServer().getPluginManager().registerEvents(new DeathCount(), this);
        // SCOREBOARDS

    }

    public void onDisable() {
        System.out.println("[ CityOfStonks ] : Le plugin s'est arrêté");
    }


    public static CityOfStonks getInstance(){
        return instance;
    }

}
