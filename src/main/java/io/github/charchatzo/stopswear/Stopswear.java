package io.github.charchatzo.stopswear;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Stopswear extends JavaPlugin implements Listener {
    public static String[] bad_words = {"shit", "fuck", "bitch", "malaka", "malaki", "bastard", "gamo", "gamw", "pouta", "poutsa", "kabla", "gamoto", "mpastard", "kariol", "poutso"};
    @Override
    public void onEnable() {
        // Plugin startup logic
        this.getServer().getPluginManager().registerEvents(this, this);
    }
    @EventHandler
    public void onChat(AsyncPlayerChatEvent e) {
        String message = e.getMessage();
        Player player = e.getPlayer();
        for (int i = 0; i < bad_words.length; i++) {
            if (message.contains(bad_words[i])) {

                Bukkit.getScheduler().runTask(this, new Runnable() {
                    @Override
                    public void run() {
                        player.kickPlayer("Kicked for swearing");
                    }
                });

            }
        }
    }
    @Override
    public void onDisable() {

    }


}
