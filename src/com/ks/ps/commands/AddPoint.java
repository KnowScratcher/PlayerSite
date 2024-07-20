package com.ks.ps.commands;

import com.ks.ps.Player_site;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Arrays;

public class AddPoint implements CommandExecutor {

    private final Player_site plugin;

    public AddPoint(Player_site plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player) {
            if (args.length == 1) {
                String[] locations = PointControl.points;
                System.out.println(Arrays.toString(locations));
                if (!Arrays.asList(locations).contains(args[0]) && args[0] != "points") {
                    Location location = player.getLocation();
                    locations = Arrays.copyOf(locations,locations.length+1);
                    System.out.println(Arrays.toString(locations));
                    locations[locations.length-1] = args[0];
                    System.out.println(Arrays.toString(locations));
                    plugin.getConfig().set(args[0],location);
                    plugin.getConfig().set("points",locations);
                    PointControl.config.set(args[0],location);
                    PointControl.points = locations;
                    plugin.saveConfig();
                    player.sendMessage(ChatColor.GREEN+"已成功新增"+ChatColor.YELLOW+args[0]);
                }else {
                    player.sendMessage(ChatColor.YELLOW+args[0]+ChatColor.RED+"已經存在");
                }
            }else {
                player.sendMessage(ChatColor.RED+"請檢查參數");
            }
        }else {
            System.out.println("請於伺服器內執行");
        }

        return true;
    }
}
