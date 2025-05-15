package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.AllSoundsGUI;
import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundData;
import com.gotze.blockBreakSounds.soundlogic.PickSoundsRegistry;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.ValidClickChecker;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class PickSoundGUIListener implements Listener {

    public PickSoundGUIListener() {}

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!event.getView().getTitle().equals("Pick Sound")) return;
        event.setCancelled(true);

        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (ValidClickChecker.hasClickCooldown(player)) return;
        if (clickedInventory == null) return;
        if (clickedInventory.equals(player.getInventory())) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        switch (slot) {
            case 4: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
                return;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new BlockBreakSoundsGUI(player);
                return;

            case 40: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new FavoriteSoundsGUI(player);
                return;

            case 44: // Pick From All Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new AllSoundsGUI(player, "All Sounds");
                return;

            default:
                SoundData soundData = PickSoundsRegistry.PICK_SOUND_MAP.get(slot);
                if (soundData == null) return;

                if (clickType == ClickType.SHIFT_RIGHT) { // Favorite Sound
                    FavoriteSoundData.addSoundToFavorites(player, soundData);
                    GUIUtils.handleFavoritedLineSound(clickedInventory, slot, player);
                } else { // Pick Sound
                    CurrentSoundData.setCurrentSound(player, soundData);
                    GUIUtils.handlePickedLineSound(clickedInventory, slot);
                    clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                }
        }
    }
}