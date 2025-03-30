package com.gotze.blockBreakSounds.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.utils.ButtonCreator.createButton;
import static com.gotze.blockBreakSounds.utils.GUIUtils.CurrentSoundDisplayButton;
import static com.gotze.blockBreakSounds.utils.GUIUtils.Frame;

public class AllSoundsGUI {

    private final Inventory gui;

    public AllSoundsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "All Sounds");
        setupGUI();
    }

    public void openAllSoundsGUI(Player player) {
        player.openInventory(gui);
        gui.setItem(4, CurrentSoundDisplayButton(player));
        gui.setItem(36, ReturnButton());
    }

    private void setupGUI() {
        setFrames();
        gui.setItem(22, AllSoundInfoButton());
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, Frame());
        }
    }

    public static ItemStack ReturnButton() {
        return createButton(
                Material.ARROW,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "← ʀᴇᴛᴜʀɴ"
        );
    }

    public static ItemStack AllSoundInfoButton() {
        return createButton(
                Material.JUKEBOX,
                "All Sounds Info",
                Arrays.asList(
                        "Hello",
                        "World!")
        );
    }
}
