package com.capitainfoxy;

import org.bukkit.ChatColor;
import org.bukkit.command.CommandExecutor;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        getLogger().info("ReportSystem enabled!");
        this.getCommand("report").setExecutor(new ReportCommand(this));
    }

    @Override
    public void onDisable() {
        getLogger().info("ReportSystem disabled.");
    }
}
