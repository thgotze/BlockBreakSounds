package com.gotze.blockbreaksounds.util;

import org.bukkit.entity.Player;

import java.util.HashMap;
import java.util.Map;

public final class ValidClickChecker {

    private static final Map<Player, Long> lastClickTime = new HashMap<>();
    private static final long CLICK_DELAY = 50; // 50 milliseconds

    private ValidClickChecker() {}

    // Checks for click delay to disallow spam clicking
    public static boolean hasClickCooldown(Player player) {
        long currentTime = System.currentTimeMillis();

        if (lastClickTime.containsKey(player)) {
            if ((currentTime - lastClickTime.get(player)) < CLICK_DELAY) {
                return true;
            }
        }
        lastClickTime.put(player, currentTime);
        return false;
    }
}