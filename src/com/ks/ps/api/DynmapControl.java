package com.ks.ps.api;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;
import org.dynmap.DynmapCommonAPI;
import org.dynmap.markers.MarkerIcon;
import org.dynmap.markers.MarkerSet;

import java.util.Objects;

public class DynmapControl {
    private JavaPlugin plugin;
    private DynmapCommonAPI dynmapCommonAPI;

    public DynmapControl(JavaPlugin plugin) {
        this.plugin = plugin;
        registerDynmap(this.plugin);
    }
    public static DynmapCommonAPI dapi = null;

    public static MarkerSet markerset = null;
    public static void registerDynmap(JavaPlugin p) {
        dapi = (DynmapCommonAPI) Bukkit.getServer().getPluginManager().getPlugin("dynmap");
        if (dapi == null) {
            Bukkit.getServer().getPluginManager().disablePlugin(p);
        }
        markerset = dapi.getMarkerAPI().createMarkerSet("playersite.points", "PS TP Points", dapi.getMarkerAPI().getMarkerIcons(), false);
    }

    public static void add(Location location, String name) {
        MarkerIcon icon = dapi.getMarkerAPI().getMarkerIcon("walk");
        String htmlLabel = "<div>"+name+"</div>";
        markerset.createMarker(
                /* Marker ID */                  "playersite."+name,
                /* Marker label */               htmlLabel,
                /* Process label as HTML */      true,
                /* World to display marker in */ Objects.requireNonNull(location.getWorld()).getName(),
                /* X coordinate */               location.getX(),
                /* Y coordinate */               location.getY(),
                /* Z coordinate */               location.getZ(),
                /* Related MarkerIcon object */  icon,
                /* Marker is persistent */       false
        );
    }

    public static void remove(String name) {
        String id = "playersite."+name;
        markerset.findMarker(id).deleteMarker();
    }
}
