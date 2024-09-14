package com.capitainfoxy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.Bukkit;

public class ReportCommand implements CommandExecutor {

    private final Main plugin;

    public ReportCommand(Main plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length == 0) {
            sender.sendMessage(ChatColor.RED + "Usage: /report <message>");
            return true;
        }

        String reportMessage = String.join(" ", args);
        String formattedMessage = ChatColor.RED + "[REPORT] " + ChatColor.YELLOW + sender.getName() + ": " + ChatColor.WHITE + reportMessage;

        Bukkit.getConsoleSender().sendMessage(formattedMessage);
        for (Player player : Bukkit.getOnlinePlayers()) {
            if (player.hasPermission("report.system.notify")) {
                player.sendMessage(formattedMessage);
            }
        }

        return true;
    }
}
