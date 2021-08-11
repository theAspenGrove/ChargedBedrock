package net.mov51.helpers;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class chatHelpers {

    private static final String ChatPrefix = "§6§l[§2Naspen§6§l]§r";



    public static void sendChat(Player p, String message){
        p.sendMessage(ChatPrefix + message);
    }

    public static void sendChat(Player p, String prefix, String message){
        p.sendMessage("§6§l[" + prefix + "§6§l]§r " + message);
    }

    public static void sendGlobalChat(String message){
        Bukkit.getServer().getOnlinePlayers().forEach(player -> sendChat(player, message));
    }

    public static void sendGlobalChat(String prefix, String message){
        Bukkit.getServer().getOnlinePlayers().forEach(player -> sendChat(player,prefix, message));
    }
}
