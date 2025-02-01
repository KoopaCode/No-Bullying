package com.koopalabs.nobullying;

import org.bukkit.plugin.java.JavaPlugin;

public class NoBullying extends JavaPlugin {
    private static NoBullying instance;
    private ConfigManager configManager;

    @Override
    public void onEnable() {
        instance = this;
        
        // Initialize config
        saveDefaultConfig();
        configManager = new ConfigManager(this);
        
        // Register events
        getServer().getPluginManager().registerEvents(new MobTargetListener(this), this);
        
        // Register commands and tab completer
        getCommand("bully").setExecutor(new BullyCommand(this));
        getCommand("bully").setTabCompleter(new BullyTabCompleter());
        
        getLogger().info("NoBullying plugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("NoBullying plugin has been disabled!");
    }

    public static NoBullying getInstance() {
        return instance;
    }

    public ConfigManager getConfigManager() {
        return configManager;
    }
} 