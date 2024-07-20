package com.ks.ps.commands;

import com.ks.ps.Player_site;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Tp implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (sender instanceof Player player) {

            if (args.length == 1) {

                Location location = PointControl.config.getLocation(args[0]);
                if (location != null) {
                    player.teleport(location);
                    player.sendMessage(ChatColor.GREEN+"你已被傳送到"+args[0]);
                }else {
                    player.sendMessage(ChatColor.RED+"找不到地點"+ChatColor.YELLOW+args[0]);
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
