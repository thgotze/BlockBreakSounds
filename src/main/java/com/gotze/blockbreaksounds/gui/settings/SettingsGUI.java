package com.gotze.blockbreaksounds.gui.settings;

import com.gotze.blockbreaksounds.util.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.InventoryHolder;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public final class SettingsGUI implements InventoryHolder { // TODO: Settings GUI is currently not implemented

    private final Inventory gui;

    @Override
    public @NotNull Inventory getInventory() {
        return gui;
    }

    public SettingsGUI(Player player) {
        this.gui = Bukkit.createInventory(this, 45, "Settings");
        setFrames();
        gui.setItem(20, PITCH_VARIANCE_BUTTON);
        gui.setItem(21, TOOL_SPECIFIC_SOUNDS_BUTTON);
        gui.setItem(22, MULTI_SOUNDS_BUTTON);
        gui.setItem(23, COMBINED_SOUNDS_BUTTON);
        gui.setItem(24, SOUND_FILTER_BUTTON);
        gui.setItem(36, GUIUtils.FRAME);
        player.openInventory(gui);
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, GUIUtils.FRAME);
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, GUIUtils.FRAME);
        }
    }

    private static final ItemStack TOOL_SPECIFIC_SOUNDS_BUTTON = createItemStack(
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

    private static final ItemStack COMBINED_SOUNDS_BUTTON = createItemStack(
            Material.MUSIC_DISC_PRECIPICE,
            ChatColor.RED + "" + ChatColor.BOLD + "Combined Sounds",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("choose multiple block break sounds to play simultaneously"),
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
            true,
            true,
            false
    );

    private static final ItemStack SOUND_FILTER_BUTTON = createItemStack(
            Material.GUSTER_BANNER_PATTERN,
            ChatColor.RED + "" + ChatColor.BOLD + "Sound Filter",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("filter blocks from playing sounds when broken"),
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
            true,
            true,
            false
    );

    private static final ItemStack MULTI_SOUNDS_BUTTON = createItemStack(
            Material.TNT,
            ChatColor.RED + "" + ChatColor.BOLD + "Multi Sound",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("toggle whether to play sound multiple times"),
                    ChatColor.WHITE + convertToSmallFont("if multiple blocks are broken at once"),
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET")
    );

    private static final ItemStack PITCH_VARIANCE_BUTTON = createItemStack(
            Material.REPEATER,
            ChatColor.RED + "" + ChatColor.BOLD + "Pitch Variance",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("toggle pitch variance"),
                    "",
                    ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET")
    );
}