package fr.kirecprod.cityofstonks.command;

import fr.kirecprod.cityofstonks.CityOfStonks;
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

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        CityOfStonks cos = CityOfStonks.getInstance();

        if(!cmd.getName().equalsIgnoreCase("furnace")) return false;
        if(!sender.hasPermission("cos.furnace"))

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
                sender.sendMessage("tu as fait cuire " + baseItem.getAmount() + " " + baseItem.getType().name());
                result.setAmount(baseItem.getAmount());
                player.setItemInHand(result);
            }else sender.sendMessage(cos.getConfig().getString("messageNotFurnaceRecipe"));
        }else sender.sendMessage(cos.getConfig().getString("messageNotPlayer"));
        return false;
    }
}
