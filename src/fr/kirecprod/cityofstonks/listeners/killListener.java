package fr.kirecprod.cityofstonks.listeners;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class killListener implements Listener {

    public void onPlayerKill(PlayerDeathEvent event){
        Player player = event.getEntity().getPlayer();
        Player killer = event.getEntity().getKiller();
        ItemStack killTool = killer.getItemInHand();

        if (killer instanceof Player && player instanceof Player){
            Bukkit.broadcastMessage(player + "à été tué par " + killer + "avec " + killTool);
        }
    }
}
