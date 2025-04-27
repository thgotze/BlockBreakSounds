package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.FavoriteSoundsGUI;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class AllSoundsGUIListener implements Listener {

    private static final String[] POSSIBLE_ALL_SOUNDS_GUI_TITLES = {"All Sounds", "Entity Sounds", "Block Sounds", "Item Sounds", "Noteblock Sounds", "Other Sounds"};

    public AllSoundsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        String guiTitle = null;
        for (String openedGuiTitle : POSSIBLE_ALL_SOUNDS_GUI_TITLES) {
            if (event.getView().getTitle().equals(openedGuiTitle)) {
                guiTitle = event.getView().getTitle();
                break;
            }
        }
        if (guiTitle == null) return;

        event.setCancelled(true);

        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (clickedInventory == null || clickedInventory.equals(player.getInventory())) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        if (slot == 4) { // Current Sound
            GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
            return;
        }

        if (slot == 40) { // Favorite Sounds
            player.playSound(player, Sound.UI_BUTTON_CLICK, 0.25f, 1.0f);
            new FavoriteSoundsGUI().setupAndOpenGUI(player);
            return;
        }
    }
}