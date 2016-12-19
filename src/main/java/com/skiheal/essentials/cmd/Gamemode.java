package com.skiheal.essentials.cmd;

import org.apache.commons.lang.math.NumberUtils;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;
import java.util.List;

public class Gamemode implements CommandExecutor {

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        // Check if sender is a player
        if (!(sender instanceof Player)) {
            sender.sendMessage(ChatColor.RED + "You must be a player to use that command!");
            return false;
        }
        // Cast sender to Player
        Player p = (Player) sender;

        // Create gamemode list
        List<GameMode> gmList = Arrays.asList(GameMode.values());

        // If no arguments
        if (args.length == 0) {
            // Check if in spectator
            if (gmList.indexOf(p.getGameMode()) == 3) {
                // Set to survival
                p.setGameMode(gmList.get(0));
            } else {
                // Change gamemode
                p.setGameMode(gmList.get(gmList.indexOf(p.getGameMode()) + 1));
            }
            // Send message
            p.sendMessage(ChatColor.DARK_AQUA + "You are now in " + p.getGameMode().name().toLowerCase() + " mode!");
            return true;
        }

        // If 1 argument
        if (args.length == 1) {
            // Check argument
            switch (args[0].toLowerCase()) {
                case "0":
                case "1":
                case "2":
                case "3":
                    // Set the gamemode
                    p.setGameMode(gmList.get(Integer.parseInt(args[0])));
                    break;
                case "survival":
                case "s":
                    // Set the gamemode
                    p.setGameMode(GameMode.SURVIVAL);
                    break;
                case "creative":
                case "c":
                    // Set the gamemode
                    p.setGameMode(GameMode.CREATIVE);
                    break;
                case "adventure":
                case "a":
                    // Set the gamemode
                    p.setGameMode(GameMode.SURVIVAL);
                    break;
                case "spectator":
                    // Set the gamemode
                    p.setGameMode(GameMode.SPECTATOR);
                    break;
                default:
                    p.sendMessage(ChatColor.RED + "Invalid arguments! Usage: /<gm> [1|2|3|4]");
                    return true;
            }
            // Send message
            p.sendMessage(ChatColor.DARK_AQUA + "You are now in " + p.getGameMode().name().toLowerCase() + " mode!");
            return true;
        }

        p.sendMessage(ChatColor.RED + "Invalid arguments! Usage: /<gm> [1|2|3|4]");
        return true;
    }
}
