package net.mov51.helpers;

import net.md_5.bungee.api.ChatColor;
import net.mov51.ChargedBedrock;
import org.bukkit.entity.Entity;

import java.util.HashMap;
import java.util.UUID;

import static net.mov51.helpers.chatHelpers.sendGlobalChat;

public class fallingHelper {

    public static HashMap<UUID, Integer> creepers = new HashMap<>();
    public static int creeperCount = 0;

    public static void watchFalling (Entity e) {
            if (isFalling(e)) {
                scheduleSyncRepeatingTask task = new scheduleSyncRepeatingTask(ChargedBedrock.getInstance(), 5L, 1L) {
                    boolean firstRun = true;
                    double startHeight;
                    double endHeight;
                    double maxSpeed;
                    double fastestYHeight;
                    int creeperNumber;
                    final java.util.UUID UUID = e.getUniqueId();

                    @Override
                    public void run() {
                        if (firstRun) {
                            startHeight = e.getLocation().getY();
                            creepers.put(UUID,creeperNumber);
                            sendGlobalChat(ChatColor.DARK_AQUA + "Creeper#" + creeperNumber + ChatColor.RESET + " started at " + ChatColor.YELLOW + ChatColor.BOLD + String.format("%.5g",(startHeight)) + ChatColor.RESET + "! ");
                            creeperNumber = creeperCount++;
                            firstRun = false;
                        }
                        if (!e.isDead() && creepers.containsKey(UUID) && isFalling(e)) {
                            double v = e.getVelocity().getY();
                            double Yl = e.getLocation().getY();
                            if(maxSpeed > v){
                                maxSpeed = v;
                                fastestYHeight = Yl;
                            }
                            sendGlobalChat(ChatColor.DARK_AQUA + "Creeper#" + creeperNumber,"Speed " + ChatColor.GREEN + String.format("%.5g",v) + ChatColor.RESET + " at "  + ChatColor.DARK_GREEN + String.format("%.5g",Yl));
                        } else {
                            cancel();
                            endHeight = e.getLocation().getY();
                            sendGlobalChat("Cancelled falling watch for " + ChatColor.DARK_AQUA + "Creeper#" + creeperNumber);
                            sendGlobalChat(ChatColor.DARK_AQUA + "Creeper#" + creeperNumber + ChatColor.RESET + " traveled " + ChatColor.YELLOW + ChatColor.BOLD + String.format("%.5g",(startHeight - endHeight)) + ChatColor.RESET + " blocks!");
                            sendGlobalChat(ChatColor.DARK_AQUA + "Creeper#" + creeperNumber + ChatColor.RESET + " stopped at " + ChatColor.YELLOW + ChatColor.BOLD + String.format("%.5g",(endHeight)) + ChatColor.RESET + "!");
                            sendGlobalChat(ChatColor.DARK_AQUA + "Creeper#" + creeperNumber + ChatColor.RESET + " reached a maximum velocity of " + ChatColor.YELLOW + ChatColor.BOLD + String.format("%.5g",(maxSpeed)) + ChatColor.RESET + " at " + String.format("%.5g",(fastestYHeight)) + "!");
                        }
                    }
                };
            }
        }

    public static boolean isFalling(Entity e){
        return e.getVelocity().getY() != -0.0784000015258789;
    }
}
