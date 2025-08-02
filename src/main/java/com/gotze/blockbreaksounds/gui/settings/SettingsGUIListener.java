package com.gotze.blockbreaksounds.gui.settings;

import com.gotze.blockbreaksounds.gui.blockbreaksounds.BlockBreakSoundsGUI;
import com.gotze.blockbreaksounds.util.SoundUtils;
import com.gotze.blockbreaksounds.util.ClickCooldownChecker;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class SettingsGUIListener implements Listener { // TODO: Settings GUI is currently not implemented

    public SettingsGUIListener() {}

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (!(event.getInventory().getHolder() instanceof SettingsGUI)) return;
        event.setCancelled(true);

        Inventory clickedInventory = event.getClickedInventory();
        Player player = (Player) event.getWhoClicked();

        if (ClickCooldownChecker.hasClickCooldown(player)) return;
        if (clickedInventory == null) return;
        if (clickedInventory.equals(player.getInventory())) return;

        ClickType clickType = event.getClick();
        int slot = event.getSlot();

        switch (slot) {
            case 36: // Return
                SoundUtils.playUIClickSound(player);
                new BlockBreakSoundsGUI(player);
                return;
        }
    }
}