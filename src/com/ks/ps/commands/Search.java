package com.ks.ps.commands;

import com.ks.ps.Player_site;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class Search implements CommandExecutor {

    private final Player_site plugin;

    public Search(Player_site plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        if (args.length == 1) {
            Location location = plugin.getConfig().getLocation(args[0]);
            if (location != null) {
                sender.sendMessage(ChatColor.GREEN+"==========tp點查詢==========");
                sender.sendMessage(ChatColor.LIGHT_PURPLE+"名稱: "+ChatColor.YELLOW+args[0]);
                sender.sendMessage(ChatColor.LIGHT_PURPLE+"x座標: "+ChatColor.YELLOW+location.getX());
                sender.sendMessage(ChatColor.LIGHT_PURPLE+"y座標: "+ChatColor.YELLOW+location.getY());
                sender.sendMessage(ChatColor.LIGHT_PURPLE+"z座標: "+ChatColor.YELLOW+location.getZ());
            }else {
                sender.sendMessage(ChatColor.YELLOW+args[0]+ChatColor.RED+"不存在");
            }
        }else {
            sender.sendMessage(ChatColor.RED+"請檢查參數");
        }
        return true;
    }
}
