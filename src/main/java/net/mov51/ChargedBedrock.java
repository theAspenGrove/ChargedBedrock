package net.mov51;

import net.mov51.Handlers.CreatureSpawnHandler;
import net.mov51.Handlers.CreeperIgniteHandler;
import net.mov51.Handlers.ExplosionHandler;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class ChargedBedrock extends JavaPlugin {

    private static ChargedBedrock instance;

    public HashMap<UUID, Double> creepers = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;
        // Plugin startup logic
        getServer().getPluginManager().registerEvents(new ExplosionHandler(), this);
        getServer().getPluginManager().registerEvents(new CreeperIgniteHandler(), this);
        getServer().getPluginManager().registerEvents(new CreatureSpawnHandler(), this);
        System.out.println("Bedrock is no longer safe.... BEWARE!");
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public static ChargedBedrock getInstance() {
        return instance;
    }
}
