package fr.kirecprod.cityofstonks.listeners;

import org.apache.logging.log4j.core.net.Priority;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;

public class killListener implements Listener {

    @EventHandler
    public void onPlayerKill(PlayerDeathEvent event){
        String message = event.getDeathMessage();
        Player player = event.getEntity().getPlayer();
        Player killer = event.getEntity().getKiller();
        ItemStack killTool = killer.getItemInHand();

        event.setDeathMessage("&c".replace("&", "§") + player.getDisplayName().replace("&", "§") + " &9à été tué par ".replace("&", "§") + "&c".replace("&", "§") + killer.getDisplayName().replace("&", "§") + " &9avec ".replace("&", "§") + "&c".replace("&", "§") + killTool.getItemMeta().getDisplayName().replace("&", "§"));
    }
}
