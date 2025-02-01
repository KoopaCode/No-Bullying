package com.koopalabs.nobullying;

import org.bukkit.World;
import java.util.List;

public class ConfigManager {
    private final NoBullying plugin;
    private int maxTargetingMobs;
    private List<String> enabledWorlds;

    public ConfigManager(NoBullying plugin) {
        this.plugin = plugin;
        loadConfig();
    }

    public void loadConfig() {
        plugin.reloadConfig();
        maxTargetingMobs = plugin.getConfig().getInt("max-targeting-mobs", 5);
        enabledWorlds = plugin.getConfig().getStringList("enabled-worlds");
    }

    public int getMaxTargetingMobs() {
        return maxTargetingMobs;
    }

    public boolean isWorldEnabled(World world) {
        return enabledWorlds.contains(world.getName());
    }
} 