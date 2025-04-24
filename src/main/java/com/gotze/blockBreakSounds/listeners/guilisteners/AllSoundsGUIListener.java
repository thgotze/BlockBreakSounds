package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.AllSoundsGUI;
import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.guis.PickSoundGUI;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.ValidClickChecker;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class AllSoundsGUIListener implements Listener {

    private static final String GUI_TITLE = "All Sounds";

    public AllSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (ValidClickChecker.shouldCancelClick(GUI_TITLE, event, clickedInventory, player)) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        switch (slot) {
            case 4: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
                return;

            case 20: // Entity Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new AllSoundsGUI("Entity Sounds").setupAndOpenGUI(player);
                return;

            case 21: // Block Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new AllSoundsGUI("Block Sounds").setupAndOpenGUI(player);
                return;

            case 22: // Item Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new AllSoundsGUI("Item Sounds").setupAndOpenGUI(player);
                return;

            case 23: // Noteblock Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new AllSoundsGUI("Noteblock Sounds").setupAndOpenGUI(player);
                return;

            case 24: // Other Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new AllSoundsGUI("Other Sounds").setupAndOpenGUI(player);
                return;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new PickSoundGUI().setupAndOpenGUI(player);
                return;

            case 40: // Favorite Sounds
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
                new FavoriteSoundsGUI().setupAndOpenGUI(player);
                return;
        }
    }
}