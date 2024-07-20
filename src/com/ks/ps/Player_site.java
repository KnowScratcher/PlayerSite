package com.ks.ps;

import com.ks.ps.commands.*;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public class Player_site extends JavaPlugin {

    @Override
    public void onEnable() {

        getConfig().options().copyDefaults();
        saveDefaultConfig();
        getCommand("playersiteadd").setExecutor(new AddPoint(this));
        getCommand("playersitetp").setExecutor(new Tp());
        getCommand("playersitelist").setExecutor(new List());
        getCommand("playersitesearch").setExecutor(new Search(this));
        getCommand("playersiteremove").setExecutor(new Remove(this));


        Object[] location_config = this.getConfig().getStringList("points").toArray();
        String[] locations = new String[location_config.length];
        for (int i=0;i<location_config.length;i++) {
            locations[i] = (String) location_config[i];
        }
        PointControl.points = locations;
        PointControl.config = this.getConfig();
        getServer().getConsoleSender().sendMessage(ChatColor.AQUA+"[Player Site] Player Site loaded");
    }

    @Override
    public void onDisable() {
        getServer().getConsoleSender().sendMessage(ChatColor.RED+"[Player Site] Player Site unloaded");
    }
}
