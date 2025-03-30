package com.gotze.blockBreakSounds.guis;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.utils.ButtonCreator.createButton;
import static com.gotze.blockBreakSounds.utils.GUIUtils.Frame;

public class SettingsGUI {

    private final Inventory gui;

    public SettingsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "Settings");
        setupGUI();
    }

    public void openSettingsGUI (Player player) {
        player.openInventory(gui);
    }

    private void setupGUI() {
        setFrames();
        gui.setItem(20, PitchVariance());
        gui.setItem(21, ToolSpecificSoundsButton());
        gui.setItem(22, MultiSoundsButton());
        gui.setItem(23, CombinedSoundsButton());
        gui.setItem(24, SoundFilterButton());

        gui.setItem(4, ToDoListButton());

        gui.setItem(36, ReturnButton());
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

    public static ItemStack ToolSpecificSoundsButton() {
        return createButton(
                Material.GOLDEN_SHOVEL,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Tool Specific Sounds",
                Arrays.asList(ChatColor.WHITE + "ᴄʜᴏᴏѕᴇ ѕᴘᴇᴄɪꜰɪᴄ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋ ѕᴏᴜɴᴅѕ",
                        ChatColor.WHITE + "ʙᴀѕᴇᴅ ᴏɴ ᴜѕᴇᴅ ᴛᴏᴏʟ",
                        "",
                        ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
                true,
                false,
                true
        );
    }

    public static ItemStack CombinedSoundsButton() {
        return createButton(
                Material.MUSIC_DISC_PRECIPICE,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Combined Sounds",
                Arrays.asList(ChatColor.WHITE + "ᴄʜᴏᴏѕᴇ ᴍᴜʟᴛɪᴘʟᴇ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋ ѕᴏᴜɴᴅѕ ᴛᴏ ᴘʟᴀʏ ѕɪᴍᴜʟᴛᴀɴᴇᴏᴜѕʟʏ",
                        "",
                        ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
                true
        );
    }

    public static ItemStack SoundFilterButton() {
        return createButton(
                Material.GUSTER_BANNER_PATTERN,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Sound Filter",
                Arrays.asList(ChatColor.WHITE + "" + ChatColor.BOLD + "ᴡʜɪᴛᴇ " + ChatColor.WHITE + " ᴀɴᴅ " +  ChatColor.BOLD + "ʙʟᴀᴄᴋʟɪѕᴛ " + ChatColor.WHITE + "ʙʟᴏᴄᴋѕ ᴛᴏ ᴄᴏɴᴛʀᴏʟ ᴡʜɪᴄʜ ʙʟᴏᴄᴋѕ ᴘʟᴀʏ ѕᴏᴜɴᴅѕ ᴡʜᴇɴ ʙʀᴏᴋᴇɴ",
                        "",
                        ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
                true,
                false,
                true
        );
    }

    public static ItemStack MultiSoundsButton() {
        return createButton(
                Material.TNT,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Multi Sound",
                Arrays.asList(ChatColor.WHITE + "ᴛᴏɢɢʟᴇ ᴡʜᴇᴛʜᴇʀ ᴛᴏ ᴘʟᴀʏ ѕᴏᴜɴᴅ ᴍᴜʟᴛɪᴘʟᴇ ᴛɪᴍᴇѕ",
                        ChatColor.WHITE + "ɪꜰ ᴍᴜʟᴛɪᴘʟᴇ ʙʟᴏᴄᴋѕ ᴀʀᴇ ʙʀᴏᴋᴇɴ ᴀᴛ ᴏɴᴄᴇ",
                        "",
                        ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET")
        );
    }

    public static ItemStack PitchVariance() {
        return createButton(
                Material.REPEATER,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Pitch Variance",
                Arrays.asList(ChatColor.WHITE + "ᴛᴏɢɢʟᴇ ᴘɪᴛᴄʜ ᴠᴀʀɪᴀɴᴄᴇ",
                        "",
                        ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET")
        );
    }

    public static ItemStack ToDoListButton() {
        return createButton(
                Material.BOOK,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "To-Do List",
                Arrays.asList(ChatColor.WHITE + "Add setting to set default block break sound for all players.",
                        ChatColor.WHITE + "Add setting to allow default sound optional for players in or out.",
                        ChatColor.WHITE + "Add option to enable role requirement to use plugin.",
                        ChatColor.WHITE + "Add option for owner to disallow usage of 'all sounds'.",
                        ""),
                true,
                false,
                true
        );
    }
}
