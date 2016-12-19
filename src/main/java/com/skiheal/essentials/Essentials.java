package com.skiheal.essentials;

import com.skiheal.essentials.cmd.Gamemode;
import org.bukkit.plugin.java.JavaPlugin;

public class Essentials extends JavaPlugin {

    public void onEnable() {
        registerCommands();
    }

    public void registerCommands() {
        getCommand("gm").setExecutor(new Gamemode());
    }
}
