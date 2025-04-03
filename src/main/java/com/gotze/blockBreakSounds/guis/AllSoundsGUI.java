package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.utils.GUIUtils;
import com.gotze.blockBreakSounds.utils.ItemStackCreator;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class AllSoundsGUI {

    private final Inventory gui;

    public AllSoundsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "All Sounds");
        setupGUI();
    }

    public void openAllSoundsGUI(Player player) {
        player.openInventory(gui);
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(36, GUIUtils.ReturnButton());
    }

    private void setupGUI() {
        setFrames();
        gui.setItem(22, AllSoundInfoButton());
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.Frame());
        }
    }

    private ItemStack AllSoundInfoButton() {
        return ItemStackCreator.createItemStack(
                Material.JUKEBOX,
                "All Sounds Info",
                Arrays.asList(
                        "Hello",
                        "World!")
        );
    }
}
