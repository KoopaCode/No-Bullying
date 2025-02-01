package com.koopalabs.nobullying;

import org.bukkit.entity.Entity;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Monster;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityTargetLivingEntityEvent;

import java.util.List;
import java.util.stream.Collectors;

public class MobTargetListener implements Listener {
    private final NoBullying plugin;

    public MobTargetListener(NoBullying plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onEntityTarget(EntityTargetLivingEntityEvent event) {
        if (event.getTarget() instanceof Player && event.getEntity() instanceof Monster) {
            Player player = (Player) event.getTarget();
            
            // Check if the world is enabled
            if (!plugin.getConfigManager().isWorldEnabled(player.getWorld())) {
                return;
            }

            // Get all monsters currently targeting the player
            List<Entity> targetingMobs = player.getWorld().getEntities().stream()
                    .filter(e -> e instanceof Monster)
                    .filter(e -> {
                        LivingEntity target = ((Monster) e).getTarget();
                        return target != null && target.equals(player);
                    })
                    .collect(Collectors.toList());

            // If we already have max mobs targeting, cancel the new targeting
            if (targetingMobs.size() >= plugin.getConfigManager().getMaxTargetingMobs()) {
                event.setCancelled(true);
            }
        }
    }
} 