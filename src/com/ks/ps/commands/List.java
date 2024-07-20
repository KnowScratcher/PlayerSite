package com.ks.ps.commands;

import com.ks.ps.Player_site;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.util.Objects;

public class List implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        String[] locations = PointControl.points;
        String list = ChatColor.GREEN+"目前的tp點有 "+ChatColor.YELLOW;
        for (Object location : locations) {
            list +=  location;
            list += " ";
        }
        sender.sendMessage(list);

        return true;
    }
}
