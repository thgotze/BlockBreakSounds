package com.gotze.blockbreaksounds.gui.settings;

import com.gotze.blockbreaksounds.util.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class SettingsGUI { // TODO: Settings GUI is currently not implemented

    private final Inventory gui;

    public SettingsGUI(Player player) {
        this.gui = Bukkit.createInventory(null, 45, "Settings");
        setFrames();
        gui.setItem(20, PitchVariance);
        gui.setItem(21, ToolSpecificSoundsButton);
        gui.setItem(22, MultiSoundsButton);
        gui.setItem(23, CombinedSoundsButton);
        gui.setItem(24, SoundFilterButton);
        gui.setItem(36, GUIUtils.returnButton);
        player.openInventory(gui);
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.frame);
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.frame);
        }
    }

    private final ItemStack ToolSpecificSoundsButton = createItemStack(
            Material.GOLDEN_SHOVEL,
            ChatColor.RED + "" + ChatColor.BOLD + "Tool Specific Sounds",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("choose specific block break sounds"),
                    ChatColor.WHITE + convertToSmallFont("based on what tool was used"),
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
            true,
            true,
            false
    );

    private final ItemStack CombinedSoundsButton = createItemStack(
            Material.MUSIC_DISC_PRECIPICE,
            ChatColor.RED + "" + ChatColor.BOLD + "Combined Sounds",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("choose multiple block break sounds to play simultaneously"),
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
            true,
            true,
            false
    );

    private final ItemStack SoundFilterButton = createItemStack(
            Material.GUSTER_BANNER_PATTERN,
            ChatColor.RED + "" + ChatColor.BOLD + "Sound Filter",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("filter blocks from playing sounds when broken"),
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
            true,
            true,
            false
    );

    private final ItemStack MultiSoundsButton = createItemStack(
            Material.TNT,
            ChatColor.RED + "" + ChatColor.BOLD + "Multi Sound",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("toggle whether to play sound multiple times"),
                    ChatColor.WHITE + convertToSmallFont("if multiple blocks are broken at once"),
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET")
    );

    private final ItemStack PitchVariance = createItemStack(
            Material.REPEATER,
            ChatColor.RED + "" + ChatColor.BOLD + "Pitch Variance",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("toggle pitch variance"),
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET")
    );
}