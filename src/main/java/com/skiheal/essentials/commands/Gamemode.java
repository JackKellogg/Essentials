package com.skiheal.essentials.commands;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Gamemode implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if (!(sender instanceof Player )){
            sender.sendMessage(ChatColor.RED + "You must be a player to use that commant!");
            return false;
        }
        Player p = (Player) sender;
        if(label.equalsIgnoreCase("gm")){
            if(p.getGameMode() == GameMode.SURVIVAL && args.length == 0){
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.DARK_AQUA + "You are now in creative mode!");
                return true;
            }
            else if(p.getGameMode() == GameMode.CREATIVE && args.length == 0){
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.DARK_AQUA + "You are now in survival mode!");
                return true;
            }
            if(args[1] == "0"){
                p.setGameMode(GameMode.SURVIVAL);
                p.sendMessage(ChatColor.DARK_AQUA + "You are now in survival mode!");
                return true;
            }
            else if(args[1] == "1") {
                p.setGameMode(GameMode.CREATIVE);
                p.sendMessage(ChatColor.DARK_AQUA + "You are now in creative mode!");
                return true;
            }
            else if(args[1] == "2"){
                p.setGameMode(GameMode.ADVENTURE);
                p.sendMessage(ChatColor.DARK_AQUA + "You are now in adventure mode!");
                return true;
            }
            else if(args[1] == "3"){
                p.setGameMode(GameMode.SPECTATOR);
                p.sendMessage(ChatColor.DARK_AQUA + "You are now in spectator mode!");
                return true;
            }
            else {
                p.sendMessage(ChatColor.RED + "Invalid command. usage: /<gm> [1|2|3|4]");
                return true;
            }

        }
        return false;

    }
}
