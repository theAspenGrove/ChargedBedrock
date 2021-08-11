package net.mov51.Handlers;

import com.destroystokyo.paper.event.entity.CreeperIgniteEvent;

import net.mov51.helpers.fallingHelper;

import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;

import java.util.HashMap;
import java.util.UUID;

public class CreeperIgniteHandler implements Listener {

    @EventHandler(priority = EventPriority.MONITOR)
    public void CreeperIgniteEvent (CreeperIgniteEvent event) {
        fallingHelper.watchFalling(event.getEntity());
    }

}
