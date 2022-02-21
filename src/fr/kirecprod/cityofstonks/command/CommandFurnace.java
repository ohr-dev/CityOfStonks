package fr.kirecprod.cityofstonks.command;

import fr.kirecprod.cityofstonks.CityOfStonks;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.FurnaceRecipe;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.Recipe;

import java.util.Iterator;

public class CommandFurnace implements CommandExecutor {

    private final CityOfStonks cos;

    public CommandFurnace(CityOfStonks cos) { this.cos = cos; }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if(sender instanceof Player){
            Player player = (Player) sender;
            ItemStack result = null;
            final ItemStack baseItem = player.getItemInHand();
            final Iterator<Recipe> i = Bukkit.recipeIterator();
            while(i.hasNext()){
                Recipe r = i.next();
                if(!(r instanceof FurnaceRecipe)) continue;
                FurnaceRecipe fr = (FurnaceRecipe) r;
                if(fr.getInput().getType() != baseItem.getType()) continue;
                result = fr.getResult();
                break;
            }
            if(result != null){
                sender.sendMessage(ChatColor.BLUE + "tu as fait cuire " + ChatColor.BLUE + baseItem.getAmount() + " " + ChatColor.BLUE + baseItem.getType().name());
                result.setAmount(baseItem.getAmount());
                player.setItemInHand(result);
            }else sender.sendMessage(cos.getConfig().getString("messages.NotFurnaceRecipe").replace("&", "§"));
        }else sender.sendMessage(cos.getConfig().getString("messages.NotPlayer").replace("&", "§"));
        return false;
    }
}
