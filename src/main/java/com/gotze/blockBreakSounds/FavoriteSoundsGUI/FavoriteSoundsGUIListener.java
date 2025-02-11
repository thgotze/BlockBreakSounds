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
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.List;
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

        switch (slot) {
            case 4: // Current Sound
                if (clickType == ClickType.DROP) {
                    CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
                    return;
                }
                if (clickType == ClickType.SHIFT_RIGHT) {
                    FavoriteSoundsData.addFavoriteSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);

                    FavoriteSoundsGUI favoriteSoundsGUI = new FavoriteSoundsGUI();
                    favoriteSoundsGUI.openFavoriteSoundsGUI(player);
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
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                FavoriteSoundsGUI favoriteSoundsGUI = new FavoriteSoundsGUI();
                favoriteSoundsGUI.openFavoriteSoundsGUI(player);
                return;

            default:
                if (slot >= 9 && slot < 36) {
                    ItemStack clickedItem = clickedInventory.getItem(slot);
                    if (clickedItem == null) {
                        player.sendMessage("The clicked item is null!");
                        return;
                    }

                    player.sendMessage("DEBUG: Clicked slot " + slot + " with " + clickedItem.getType());

                    if (clickType == ClickType.DROP) {
                        int favoriteSlotIndex = slot - 9;
                        player.sendMessage("DEBUG: Removing favorite at index " + favoriteSlotIndex);

                        FavoriteSoundsData.clearFavoriteSound(clickedInventory, player, slot);
//                        FavoritedSoundLineHandler.handleFavoritedLineSound(player, clickedInventory, slot, true);
                        return;
                    }

                    player.sendMessage("DEBUG: Attempting to get favorite sound for slot " + slot);
                    FavoriteSoundsData favoriteSoundsData = FavoriteSoundsData.getFavoriteSoundFromSlot(player, slot);

                    if (favoriteSoundsData == null) {
                        player.sendMessage("DEBUG: No favorite sound found at slot " + slot);
                        List<FavoriteSoundsData> favorites = FavoriteSoundsData.getFavorites(player);
                        player.sendMessage("DEBUG: Favorites list size: " + (favorites != null ? favorites.size() : 0));
                        return;
                    }

                    player.sendMessage("DEBUG: Retrieved favorite sound: " + favoriteSoundsData.getSound().name());

                    Sound sound = favoriteSoundsData.getSound();
                    float volume = favoriteSoundsData.getVolume();
                    float pitch = favoriteSoundsData.getPitch();

                    PickedSoundLineHandler.handlePickedLineSound(clickedInventory, slot);

                    player.sendMessage("DEBUG: Successfully picked sound");

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

