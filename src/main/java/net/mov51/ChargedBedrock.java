package net.mov51;

import net.mov51.Handlers.ExplosionHandler;
import org.bukkit.plugin.java.JavaPlugin;

public final class ChargedBedrock extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ExplosionHandler(), this);
        System.out.println("Bedrock is no longer safe.... BEWARE!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
