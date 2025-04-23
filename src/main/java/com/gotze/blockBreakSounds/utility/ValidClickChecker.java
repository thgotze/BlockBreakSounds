package com.gotze.blockBreakSounds.utility;

import org.bukkit.entity.Player;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public final class ValidClickChecker {

    private static final Map<Player, Long> lastClickTime = new HashMap<>();
    private static final long CLICK_DELAY = 50; // 50 milliseconds

    public static boolean shouldCancelClick(String expectedTitle, InventoryClickEvent event, Inventory clickedInventory, Player player) {
        event.setCancelled(true);

        if (clickedInventory == null ||
                clickedInventory.equals(player.getInventory()) ||
                !event.getView().getTitle().equals(expectedTitle) ||
                hasClickCooldown(player)) {
            return true;
        }
        return false;
    }

    // Checks for click delay to disallow spam clicking
    private static boolean hasClickCooldown(Player player) {
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