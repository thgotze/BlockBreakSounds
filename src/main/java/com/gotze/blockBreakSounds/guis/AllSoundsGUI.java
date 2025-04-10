package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.utility.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class AllSoundsGUI {

    private final Inventory gui;

    public AllSoundsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "All Sounds");
        gui.setItem(36, GUIUtils.ReturnButton());
    }

    public void setupAndOpenGUI(Player player) {
        setFrames();
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        player.openInventory(gui);
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
    }

}
