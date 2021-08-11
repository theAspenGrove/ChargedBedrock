package net.mov51.Handlers;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;

import static net.mov51.helpers.fallingHelper.watchFalling;

public class CreatureSpawnHandler implements Listener {
    @EventHandler(priority = EventPriority.MONITOR)
    public void CreatureSpawnEvent (CreatureSpawnEvent event) {
        watchFalling(event.getEntity());
    }
}
