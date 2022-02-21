package fr.kirecprod.cityofstonks;

import fr.kirecprod.cityofstonks.command.CommandCraft;
import fr.kirecprod.cityofstonks.command.CommandFurnace;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CityOfStonks extends JavaPlugin {

    private static CityOfStonks instance;

    public void onLoad() {
        System.out.println("[ CityOfStonks ] : Le Plugin démarre");
    }



    public void onEnable() {
        saveDefaultConfig();
        System.out.println("[ CityOfStonks ] : Le plugin a démarré avec succès");

        getCommand("craft").setExecutor(new CommandCraft(this));
        getCommand("furnace").setExecutor(new CommandFurnace(this));


    }

    public void onDisable() {
        System.out.println("[ CityOfStonks ] : Le plugin s'est arrêté");
    }


    public static CityOfStonks getInstance(){
        return instance;
    }

}
