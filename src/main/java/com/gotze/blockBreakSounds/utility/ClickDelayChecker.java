package com.gotze.blockBreakSounds.utility;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public final class ClickDelayChecker {

    private static final Map<Player, Long> lastClickTime = new HashMap<>();
    private static final long CLICK_DELAY = 50; // 50 milliseconds

    // Checks for click delay to disallow spam clicking
    public static boolean shouldIgnoreClick(Player player) {

        long currentTime = System.currentTimeMillis();

        if (lastClickTime.containsKey(player)) {
            long lastClick = lastClickTime.get(player);
            if ((currentTime - lastClick) < CLICK_DELAY) {
                return true;
            }
        }
        lastClickTime.put(player, currentTime);
        return false;
    }
}