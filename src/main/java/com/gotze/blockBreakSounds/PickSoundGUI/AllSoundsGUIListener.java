package com.gotze.blockBreakSounds.PickSoundGUI;

import com.gotze.blockBreakSounds.Utility.LineHandlers.FavoritedSoundLineHandler;
import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
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
    private static final long CLICK_DELAY = 100; // 100 milliseconds

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
        CurrentSoundData soundData = CurrentSoundData.playerSounds.get(player.getUniqueId());

        switch (slot) {
            case 4: // Current Sound
                if (clickType == ClickType.DROP) {
                    CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
                    return;
                }
                if (clickType == ClickType.SHIFT_RIGHT) {
                    FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot);
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
                pickSoundGUI.openPickSoundGUI(player);
                return;
        }


    }
}
