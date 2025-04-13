package com.gotze.blockBreakSounds.listeners.guilisteners;

import com.gotze.blockBreakSounds.guis.BlockBreakSoundsGUI;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.ClickDelayChecker;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

import static com.gotze.blockBreakSounds.soundlogic.CurrentSoundData.currentSound;

public class SettingsGUIListener implements Listener {

    private static final String GUI_TITLE = "Settings";

    public SettingsGUIListener() {
    }

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();
        Inventory clickedInventory = event.getClickedInventory();
        event.setCancelled(true);

        if (clickedInventory == null
                || clickedInventory == player.getInventory()
                || !event.getView().getTitle().equals(GUI_TITLE)) {
            return;
        }

        if (ClickDelayChecker.shouldIgnoreClick(player)) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        SoundData playerCurrentSound = currentSound.get(player.getUniqueId());

        switch (slot) {
            case 4: // Current Sound
                GUIUtils.currentSoundButtonHandler(clickedInventory, clickType, player, slot);
                return;

            case 36: // Return
                player.playSound(player, Sound.UI_BUTTON_CLICK, 0.5f, 1.0f);
                new BlockBreakSoundsGUI().setupAndOpenGUI(player);
                return;
        }
    }
}