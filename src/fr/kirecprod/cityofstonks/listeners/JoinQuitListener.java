package fr.kirecprod.cityofstonks.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class JoinQuitListener implements Listener {

    @EventHandler
    public void PlayerJoinEvent(PlayerJoinEvent event){
        String message = event.getJoinMessage();
        Player player = event.getPlayer();
        event.setJoinMessage("&a[+] ".replace("&", "§") + player.getDisplayName().replace("&", "§"));
    }

    @EventHandler
    public void PlayerQuitEvent(PlayerQuitEvent event){
        String message = event.getQuitMessage();
        Player player = event.getPlayer();
        event.setQuitMessage("&4[-] ".replace("&", "§") + player.getName().replace("&", "§"));

    }

}
