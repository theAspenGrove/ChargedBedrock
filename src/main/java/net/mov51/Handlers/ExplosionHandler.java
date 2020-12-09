package net.mov51.Handlers;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.Creeper;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class ExplosionHandler implements Listener {

    //Register Event Handler
    @EventHandler(priority = EventPriority.MONITOR)
    //Any Exploding entity
    public void EntityExplodeEvent (EntityExplodeEvent event) {
        //Define entity
        Entity e = event.getEntity();
        //Is a creeper?
        if(e instanceof Creeper){
            //is charged?
            if (((Creeper) e).isPowered()){
                //Where is it?
                Location loc = event.getLocation();
                //find the block below
                loc.setY(loc.getBlockY()-1);
                //is the block below bedrock?
                if (loc.getBlock().getType() == Material.BEDROCK){
                    //if yes, remove it
                    loc.getBlock().setType(Material.AIR);
                }else{
                    System.out.println("No Bedrock here");
                }
            }
        }
    }
}
