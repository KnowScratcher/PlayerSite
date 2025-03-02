package com.ks.ps.commands;

import com.ks.ps.Player_site;
import com.ks.ps.api.DynmapControl;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Arrays;

public class Remove implements CommandExecutor {

    private final Player_site plugin;

    public Remove(Player_site plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 1) {
            String[] locations = PointControl.points;
            if (Arrays.asList(locations).contains(args[0]) && args[0]!="佔位符") {
                String[] new_locations = new String[locations.length-1];
                for (int i=0,k=0;i<new_locations.length;i++) {
                    if (locations[i] != args[0]) {
                        new_locations[k] = locations[i];
                        k++;
                    }
                }
                plugin.getConfig().set(args[0],null);
                plugin.getConfig().set("points",new_locations);
                PointControl.config.set(args[0],null);
                PointControl.points = new_locations;
                plugin.saveConfig();
                DynmapControl.remove(args[0]);
                sender.sendMessage(ChatColor.GREEN+"已成功移除"+ChatColor.YELLOW+args[0]);

            }else {
                sender.sendMessage(ChatColor.RED+"找不到tp點"+ChatColor.YELLOW+args[0]);
            }
        }else {
            sender.sendMessage(ChatColor.RED+"請檢查參數");
        }

        return true;
    }
}
