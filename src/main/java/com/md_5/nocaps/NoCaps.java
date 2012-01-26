package com.md_5.nocaps;

import java.util.logging.Logger;
import org.bukkit.Bukkit;
import org.bukkit.event.Event.Priority;
import org.bukkit.event.Event.Type;
import org.bukkit.event.player.PlayerChatEvent;
import org.bukkit.event.player.PlayerListener;
import org.bukkit.plugin.java.JavaPlugin;

public class NoCaps extends JavaPlugin {

    public static final Logger logger = Bukkit.getServer().getLogger();

    public void onEnable() {
        getServer().getPluginManager().registerEvent(Type.PLAYER_CHAT, new PlayerListener() {

            @Override
            public void onPlayerChat(PlayerChatEvent event) {
                String message = event.getMessage();
                String output = "";
                char[] chars = message.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    if (i == 0) {
                        String t = Character.toString(Character.toUpperCase(chars[0]));
                        output += t;
                        continue;
                    }
                    String t = Character.toString(Character.toLowerCase(chars[i]));
                    if (chars.length >= 3) {
                        if (t.equals("i")) {
                            if (chars[i - 1] == ' ' && chars[i + 1] == ' ') {
                                t = Character.toString(Character.toUpperCase(chars[i]));
                            }
                        }
                    }
                    output += t;
                }
                event.setMessage(output);
            }
        }, Priority.Lowest, this);
        logger.info(String.format("NoCaps v%1$s by md_5 enabled", this.getDescription().getVersion()));
    }

    public void onDisable() {
        logger.info(String.format("NoCaps v%1$s by md_5 disabled", this.getDescription().getVersion()));
    }
}
