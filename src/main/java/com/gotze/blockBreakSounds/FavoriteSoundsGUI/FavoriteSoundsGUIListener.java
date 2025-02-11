package com.gotze.blockBreakSounds.FavoriteSoundsGUI;

import com.gotze.blockBreakSounds.BlockBreakSoundsGUI.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.Utility.LineHandlers.FavoritedSoundLineHandler;
import com.gotze.blockBreakSounds.Utility.LineHandlers.PickedSoundLineHandler;
import com.gotze.blockBreakSounds.Utility.SoundData.CurrentSoundData;
import com.gotze.blockBreakSounds.Utility.SoundData.FavoriteSoundsData;
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

import static com.gotze.blockBreakSounds.Utility.CurrentSoundDisplayButton.CurrentSoundDisplayButton;

public class FavoriteSoundsGUIListener implements Listener {

    private final Map<Player, Long> lastClickTime = new HashMap<>();
    private static final long CLICK_DELAY = 50; // 50 milliseconds

    public FavoriteSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();

        if (!event.getView().getTitle().equals("Favorite Sounds")) {
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

        CurrentSoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        FavoriteSoundsGUI favoriteSoundsGUI = new FavoriteSoundsGUI();

        switch (slot) {
            case 4: // Current Sound
                if (clickType == ClickType.DROP) {
                    CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
                    return;
                }
                if (clickType == ClickType.SHIFT_RIGHT) {
                    FavoriteSoundsData.addFavoriteSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);
                    return;
                }
                if (currentSoundData != null && clickedInventory.getItem(slot).getType() != Material.BARRIER) {
                    player.playSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    return;
                }
                return;

            case 36: // Return
            player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
            BlockBreakSoundsGUI blockBreakSoundsGUI = new BlockBreakSoundsGUI(player);
            blockBreakSoundsGUI.openBlockBreakSoundsGUI(player);
            return;

            case 40: // Favorite Sounds
                return;

            default:
                if (slot >= 9 && slot < 36) {
                    if (clickedInventory.getItem(slot) == null || clickedInventory.getItem(slot).getType() == Material.PAPER) {
                        return;
                    }

                    if (clickType == ClickType.DROP) {
                        FavoriteSoundsData.clearFavoriteSound(clickedInventory, player, slot);
                        return;
                    } else {
                        PickedSoundLineHandler.handlePickedLineSound(clickedInventory, slot);
                    }

                    FavoriteSoundsData favoriteSoundsData = FavoriteSoundsData.getFavoriteSoundFromSlot(player, slot);

                    if (favoriteSoundsData == null) {
                        return;
                    }

                    Sound sound = favoriteSoundsData.getSound();
                    float volume = favoriteSoundsData.getVolume();
                    float pitch = favoriteSoundsData.getPitch();

                    if (currentSoundData == null) {
                        currentSoundData = new CurrentSoundData(player, sound, volume, pitch);
                    } else {
                        currentSoundData.setSound(sound);
                        currentSoundData.setVolume(volume);
                        currentSoundData.setPitch(pitch);
                    }

                    CurrentSoundData.currentSound.put(player.getUniqueId(), currentSoundData);
                    player.playSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    clickedInventory.setItem(4, CurrentSoundDisplayButton(player));
                }
                return;

        }
    }
}

