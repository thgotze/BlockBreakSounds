package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.handlers.FavoritedSoundLoreHandler;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.guis.PickSoundGUI;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import java.util.HashMap;
import java.util.Map;

public class AllSoundsGUIListener implements Listener {

    private final Map<Player, Long> lastClickTime = new HashMap<>();
    private static final long CLICK_DELAY = 50; // 50 milliseconds

    public AllSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();

        if (!event.getView().getTitle().equals("All Sounds")) {
            return;
        }

        event.setCancelled(true);

        if (clickedInventory == player.getInventory() || clickedInventory == null) {
            return;
        }

        // Check for click delay to disallow spam clicking
        long currentTime = System.currentTimeMillis();

        if (lastClickTime.containsKey(player)) {
            long lastClick = lastClickTime.get(player);
            if ((currentTime - lastClick) < CLICK_DELAY) {
                return;
            }
        }
        lastClickTime.put(player, currentTime);

        ClickType clickType = event.getClick();
        int slot = event.getSlot();
        CurrentSoundData soundData = CurrentSoundData.currentSound.get(player.getUniqueId());

        switch (slot) {
            case 4: // Current Sound
                if (clickType == ClickType.DROP) {
                    CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
                    return;
                }
                if (clickType == ClickType.SHIFT_RIGHT) {
                    FavoritedSoundLoreHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);
                    return;
                }
                if (soundData != null && clickedInventory.getItem(slot).getType() != Material.BARRIER) {
                    player.playSound(player, soundData.getSound(), soundData.getVolume(), soundData.getPitch());
                    return;
                }
                return;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                PickSoundGUI pickSoundGUI = new PickSoundGUI(player);
                pickSoundGUI.setupAndOpenGUI(player);
                return;
        }
    }
}