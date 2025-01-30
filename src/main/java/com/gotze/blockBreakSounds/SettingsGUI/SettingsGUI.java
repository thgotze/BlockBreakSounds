package com.gotze.blockBreakSounds.SettingsGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.Utility.ButtonCreator.createButton;
import static com.gotze.blockBreakSounds.Utility.GUIUtils.Frame;

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
        gui.setItem(19, MuteDefaultSoundButton());
        gui.setItem(20, PitchVariance());
        gui.setItem(21, ToolSpecificSoundsButton());
        gui.setItem(22, ExplosiveSoundsButton());
        gui.setItem(23, CombinedSoundsButton());
        gui.setItem(24, SelectiveBlockSoundsButton());

        gui.setItem(25, AdminSettingsButton());

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
                Material.DIAMOND_SHOVEL,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Tool Specific Sounds",
                Arrays.asList(ChatColor.WHITE + "ᴄʜᴏᴏѕᴇ ᴅɪꜰꜰᴇʀᴇɴᴛ ѕᴏᴜɴᴅѕ ꜰᴏʀ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋɪɴɢ",
                        ChatColor.WHITE + "ʙᴀѕᴇᴅ ᴏɴ ᴛʜᴇ ᴛᴏᴏʟ ʏᴏᴜ ᴜѕᴇ",
                        "",
                        ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
                true,
                false,
                true
        );
    }

    public static ItemStack MuteDefaultSoundButton() {
        return createButton(
                Material.RED_STAINED_GLASS,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Mute Default Sound",
                Arrays.asList(ChatColor.WHITE + "ᴍᴜᴛᴇѕ ᴛʜᴇ ᴅᴇꜰᴀᴜʟᴛ ѕᴏᴜɴᴅ ᴏꜰ ᴛʜᴇ ʙʟᴏᴄᴋ ʙʀᴏᴋᴇɴ",
                        "",
                        ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
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

    public static ItemStack SelectiveBlockSoundsButton() {
        return createButton(
                Material.GUSTER_BANNER_PATTERN,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Selective Block Sounds",
                Arrays.asList(ChatColor.WHITE + "" + ChatColor.BOLD + "ᴡʜɪᴛᴇʟɪѕᴛ " + ChatColor.WHITE + "ʙʟᴏᴄᴋѕ ᴛᴏ ᴏɴʟʏ ᴀʟʟᴏᴡ ᴛʜᴏѕᴇ ʙʟᴏᴄᴋѕ ᴛᴏ ᴍᴀᴋᴇ ѕᴏᴜɴᴅ ᴡʜᴇɴ ʙʀᴏᴋᴇɴ",
                        ChatColor.DARK_GRAY + "" + ChatColor.BOLD + "ʙʟᴀᴄᴋʟɪѕᴛ " + ChatColor.WHITE + "ʙʟᴏᴄᴋѕ ᴛᴏ ᴅɪѕᴀʟʟᴏᴡ ᴛʜᴏѕᴇ ʙʟᴏᴄᴋѕ ꜰʀᴏᴍ ᴍᴀᴋɪɴɢ ѕᴏᴜɴᴅ ᴡʜᴇɴ ʙʀᴏᴋᴇɴ",
                        "",
                        ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
                true,
                false,
                true
        );
    }

    public static ItemStack ExplosiveSoundsButton() {
        return createButton(
                Material.TNT,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Explosive Sounds",
                Arrays.asList(ChatColor.WHITE + "ᴛᴏɢɢʟᴇ ᴡʜᴇᴛʜᴇʀ ᴛᴏ ᴘʟᴀʏ ѕᴏᴜɴᴅ ᴍᴜʟᴛɪᴘʟᴇ ᴛɪᴍᴇѕ",
                        ChatColor.WHITE + "ɪꜰ ᴍᴜʟᴛɪᴘʟᴇ ʙʟᴏᴄᴋѕ ᴡᴇʀᴇ ʙʀᴏᴋᴇɴ ᴀᴛ ᴏɴᴄᴇ",
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

    public static ItemStack AdminSettingsButton() {
        return createButton(
                Material.COMMAND_BLOCK,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Admin Settings",
                Arrays.asList(ChatColor.WHITE + "₁: ѕᴇᴛ ᴅᴇꜰᴀᴜʟᴛ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋ ѕᴏᴜɴᴅ ꜰᴏʀ ᴀʟʟ ᴘʟᴀʏᴇʀѕ",
                        ChatColor.WHITE + "₂: ᴍᴀᴋᴇ ᴅᴇꜰᴀᴜʟᴛ ѕᴏᴜɴᴅ ᴏᴘᴛ ɪɴ ᴏʀ ᴏᴜᴛ ꜰᴏʀ ᴘʟᴀʏᴇʀѕ",
                        ChatColor.WHITE + "₃: ѕᴇᴛ ʀᴏʟᴇ ɴᴇᴇᴅᴇᴅ ᴛᴏ ᴜѕᴇ ʙʟᴏᴄᴋ ʙʀᴇᴀᴋ ѕᴏᴜɴᴅѕ",
                        ChatColor.WHITE + "₄: ᴅɪѕᴀʟʟᴏᴡ ᴜѕᴀɢᴇ ᴏꜰ ᴀʟʟ ѕᴏᴜɴᴅѕ",
                        "",
                        ChatColor.RED + "" + ChatColor.BOLD + "NOT IMPLEMENTED YET"),
                true,
                false,
                true
        );
    }
}
