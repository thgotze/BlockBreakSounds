package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.utility.ClickDelayChecker;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.FavoritedSoundLoreHandler;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundsData;
import com.gotze.blockBreakSounds.utility.PickedSoundLoreHandler;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import java.util.List;

import static com.gotze.blockBreakSounds.soundlogic.CurrentSoundData.currentSound;

public class FavoriteSoundsGUIListener implements Listener {

    private static final String GUI_TITLE = "Favorite Sounds";

    public FavoriteSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();
        event.setCancelled(true);

        if (clickedInventory == null || clickedInventory == player.getInventory() || !event.getView().getTitle().equals(GUI_TITLE)) {
            return;
        }

        if (ClickDelayChecker.shouldIgnoreClick(player)) {
            return;
        }

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        CurrentSoundData currentSoundData = currentSound.get(player.getUniqueId());

        switch (slot) {
            case 4: // Current Sound
                if (clickType == ClickType.DROP) {
                    CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
                    return;
                }
                if (clickType == ClickType.SHIFT_RIGHT) {
                    FavoriteSoundsData.addFavoriteSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    FavoritedSoundLoreHandler.handleFavoritedLineSound(player, clickedInventory, slot, false);
                    return;
                }
                if (currentSoundData != null && clickedInventory.getItem(slot).getType() != Material.BARRIER) {
                    player.playSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
                    return;
                }
                return;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new BlockBreakSoundsGUI().setupAndOpenGUI(player);
                return;

            default: // Favorited Sounds
                if (slot >= 9 && slot < 36) {
                    List<FavoriteSoundsData> favorites = FavoriteSoundsData.favoriteSounds.get(player.getUniqueId());
                    if (favorites == null || favorites.isEmpty()) {
                        return;
                    }

                    ItemStack item = clickedInventory.getItem(slot);
                    if (item == null || item.getType() == Material.PAPER) {
                        return;
                    }

                    if (clickType == ClickType.DROP) {
                        FavoriteSoundsData.removeFavoriteSound(clickedInventory, player, slot);
                        return;
                    }


                    FavoriteSoundsData favoriteSoundsData = favorites.get(slot - 9); // Adjust for zero-indexing
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

                    currentSound.put(player.getUniqueId(), currentSoundData);
                    player.playSound(player, sound, volume, pitch);
                    PickedSoundLoreHandler.handlePickedLineSound(clickedInventory, slot);
                    clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                }
        }
    }
}