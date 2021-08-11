package net.mov51.helpers;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public abstract class scheduleSyncRepeatingTask implements Runnable {

    public final int taskId;

    public scheduleSyncRepeatingTask(JavaPlugin plugin, Long Delay, Long Period) {
        taskId = Bukkit.getScheduler().scheduleSyncRepeatingTask(plugin, this, Delay, Period);
    }

    public void cancel() {
        Bukkit.getScheduler().cancelTask(taskId);
    }

}
