package com.gotze.blockbreaksounds.gui.picksound;

import com.gotze.blockbreaksounds.gui.allsounds.AllSoundsGUI;
import com.gotze.blockbreaksounds.gui.blockbreaksounds.BlockBreakSoundsGUI;
import com.gotze.blockbreaksounds.gui.favoritesounds.FavoriteSoundsGUI;
import com.gotze.blockbreaksounds.model.FavoriteSoundData;
import com.gotze.blockbreaksounds.model.SoundData;
import com.gotze.blockbreaksounds.util.GUIUtils;
import com.gotze.blockbreaksounds.util.SoundUtils;
import com.gotze.blockbreaksounds.util.ValidClickChecker;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public final class PickSoundGUIListener implements Listener {

    public PickSoundGUIListener() {}

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof PickSoundGUI)) return;
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
                SoundUtils.playUIClickSound(player);
                new BlockBreakSoundsGUI(player);
                return;

            case 40: // Favorite Sounds
                SoundUtils.playUIClickSound(player);
                new FavoriteSoundsGUI(player);
                return;

            case 44: // Pick From All Sounds
                SoundUtils.playUIClickSound(player);
                new AllSoundsGUI(player, "All Sounds");
                return;

            default:
                SoundData soundData = PickSoundsRegistry.PICK_SOUND_MAP.get(slot);
                if (soundData == null) return;

                if (clickType == ClickType.SHIFT_RIGHT) { // Favorite Sound
                    FavoriteSoundData.addSoundToFavorites(player, soundData);
                    GUIUtils.handleFavoritedLineSound(clickedInventory, slot, player);
                } else { // Pick Sound
                    soundData.playSoundData(player);
                    GUIUtils.handlePickedLineSound(clickedInventory, slot);
                    clickedInventory.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
                }
        }
    }
}