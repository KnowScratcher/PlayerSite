package com.ks.ps;

import com.ks.ps.api.DynmapControl;
import com.ks.ps.commands.*;
//import com.ks.ps.api.DynmapListener;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
//import org.bukkit.plugin.Plugin;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.dynmap.DynmapCommonAPI;
//import org.dynmap.DynmapCommonAPI;
//import org.dynmap.DynmapCommonAPIListener;
//import org.dynmap.markers.Marker;
import org.dynmap.markers.MarkerIcon;
import org.dynmap.markers.MarkerSet;


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

        DynmapControl.registerDynmap(this);
        Object[] location_config = this.getConfig().getStringList("points").toArray();
        String[] locations = new String[location_config.length];
        for (int i = 0; i < location_config.length; i++) {
            locations[i] = (String) location_config[i];
            Location location = this.getConfig().getLocation(locations[i]);
            assert location != null;
            DynmapControl.add(location,locations[i]);
        }
        PointControl.points = locations;
        PointControl.config = this.getConfig();



        getServer().getConsoleSender().sendMessage(ChatColor.AQUA + "[Player Site] Player Site loaded");
    }

    @Override
    public void onDisable() {
//        if (dynmapListener != null) {
//            dynmapListener.clearMarkers();
//        }
        getServer().getConsoleSender().sendMessage(ChatColor.RED + "[Player Site] Player Site unloaded");
    }

//    public DynmapListener getDynmapListener() {
//        return dynmapListener;
//    }
}
