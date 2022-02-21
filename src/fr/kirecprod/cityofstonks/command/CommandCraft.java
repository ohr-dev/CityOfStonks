package fr.kirecprod.cityofstonks.command;

import fr.kirecprod.cityofstonks.CityOfStonks;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class CommandCraft implements CommandExecutor {

    private CityOfStonks cos = CityOfStonks.getInstance();

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String string, String[] args) {

        if (sender instanceof Player && sender.hasPermission("cos.craft")){
            if (cmd.getName().equalsIgnoreCase("craft")){
                Player player = (Player) sender;
                player.openWorkbench(null, true);
                player.playSound(player.getLocation(), Sound.BLOCK_NOTE_PLING, 1f, 1f);
                sender.sendMessage(cos.getConfig().getString("messageCraft"));
            }
        }

        return false;
    }
}

