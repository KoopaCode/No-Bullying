package com.koopalabs.nobullying;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class BullyCommand implements CommandExecutor {
    private final NoBullying plugin;

    public BullyCommand(NoBullying plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (!sender.hasPermission("nobullying.reload")) {
            sender.sendMessage(ChatColor.RED + "You don't have permission to use this command!");
            return true;
        }

        if (args.length == 1 && args[0].equalsIgnoreCase("reload")) {
            plugin.getConfigManager().loadConfig();
            sender.sendMessage(ChatColor.GREEN + "NoBullying configuration reloaded!");
            return true;
        }

        sender.sendMessage(ChatColor.RED + "Usage: /bully reload");
        return true;
    }
} 