package fr.kirecprod.cityofstonks;

import fr.kirecprod.cityofstonks.command.CommandCraft;
import fr.kirecprod.cityofstonks.command.CommandFurnace;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class CityOfStonks extends JavaPlugin {

    private static CityOfStonks instance;

    public void onLoad() {
        System.out.println(ChatColor.AQUA + "[ CityOfStonks ] : Le Plugin démarre");
    }



    public void onEnable() {
        saveDefaultConfig();
        System.out.println(ChatColor.AQUA + "[ CityOfStonks ] : Le plugin a démarré avec succès");

        getCommand("craft").setExecutor(new CommandCraft());
        getCommand("furnace").setExecutor(new CommandFurnace());


    }

    public void onDisable() {
        System.out.println(ChatColor.AQUA + "[ CityOfStonks ] : Le plugin s'est arrêté");
    }


    public static CityOfStonks getInstance(){
        return instance;
    }

}
