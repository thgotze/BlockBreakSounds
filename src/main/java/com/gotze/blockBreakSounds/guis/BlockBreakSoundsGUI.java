package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.utility.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;

public class BlockBreakSoundsGUI {

    private final Inventory gui;

    public BlockBreakSoundsGUI(Player player) {
        this.gui = Bukkit.createInventory(null, 45, "Block Break Sounds");
        setFrames();
        gui.setItem(11, IncreaseVolumeButton());
        gui.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(15, IncreasePitchButton());
        gui.setItem(20, VolumeButton());
        gui.setItem(22, PickSoundButton());
        gui.setItem(24, PitchButton());
        gui.setItem(26, SettingsButton());
        gui.setItem(29, DecreaseVolumeButton());
        gui.setItem(31, FavoriteSoundsButton());
        gui.setItem(33, DecreasePitchButton());
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

    // Settings Button (Command Block)
    private ItemStack SettingsButton() {
        return createItemStack(
                Material.COMMAND_BLOCK,
                ChatColor.RED + "" + ChatColor.BOLD + "Settings \uD83D\uDD27",
                Arrays.asList(
                        ChatColor.WHITE + "ᴍᴏᴅɪꜰʏ ᴀᴅᴅɪᴛɪᴏɴᴀʟ ѕᴇᴛᴛɪɴɢѕ"),
                true,
                true,
                false
        );
    }

    // Favorite Sounds Button (Nether Star)
    private ItemStack FavoriteSoundsButton() {
        return createItemStack(
                Material.NETHER_STAR,
                ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.GREEN + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ")
        );
    }

    // Pick Sound Button (Noteblock)
    private ItemStack PickSoundButton() {
        return createItemStack(
                Material.NOTE_BLOCK,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Pick Sound ♪",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ᴀ ѕᴏᴜɴᴅ ᴛᴏ ᴘʟᴀʏ",
                        ChatColor.WHITE + "ᴡʜᴇɴ ʏᴏᴜ ʙʀᴇᴀᴋ ʙʟᴏᴄᴋѕ")
        );
    }

    // Volume Button (Goat Horn)
    private ItemStack VolumeButton() {
        return createItemStack(
                Material.GOAT_HORN,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Tweak Volume \uD83D\uDD0A",
                Arrays.asList(
                        ChatColor.WHITE + "ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.GREEN + ChatColor.BOLD + "ɪɴᴄʀᴇᴀѕᴇ " + ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ",
                        ChatColor.WHITE + "ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.RED + ChatColor.BOLD + "ᴅᴇᴄʀᴇᴀѕᴇ " + ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ",
                        ChatColor.WHITE + "",
                        ChatColor.GRAY + "ᴠᴏʟᴜᴍᴇ ᴄᴀɴ ʙᴇ ѕᴇᴛ ʙᴇᴛᴡᴇᴇɴ ₀ ᴀɴᴅ ₁₀₀"),
                true
        );
    }

    // + Increase Volume (Mangrove Button)
    private ItemStack IncreaseVolumeButton() {
        return createItemStack(
                Material.MANGROVE_BUTTON,
                ChatColor.GREEN + "" + ChatColor.BOLD + "[+] ɪɴᴄʀᴇᴀѕᴇ ᴠᴏʟᴜᴍᴇ"
        );
    }

    // - Decrease Volume (Mangrove Button)
    private ItemStack DecreaseVolumeButton() {
        return createItemStack(
                Material.MANGROVE_BUTTON,
                ChatColor.RED + "" + ChatColor.BOLD + "[-] ᴅᴇᴄʀᴇᴀꜱᴇ ᴠᴏʟᴜᴍᴇ"
        );
    }

    // Pitch Button (Bell)
    private ItemStack PitchButton() {
        return createItemStack(
                Material.BELL,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "Tweak Pitch \uD83D\uDD14",
                Arrays.asList(
                        ChatColor.WHITE + "ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.GREEN + ChatColor.BOLD + "ɪɴᴄʀᴇᴀѕᴇ " + ChatColor.WHITE + "ᴘɪᴛᴄʜ",
                        ChatColor.WHITE + "ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.RED + ChatColor.BOLD + "ᴅᴇᴄʀᴇᴀѕᴇ " + ChatColor.WHITE + "ᴘɪᴛᴄʜ",
                        ChatColor.WHITE + "",
                        ChatColor.GRAY + "ᴘɪᴛᴄʜ ᴄᴀɴ ʙᴇ ѕᴇᴛ ʙᴇᴛᴡᴇᴇɴ ₀.₅₀ ᴀɴᴅ ₂.₀₀")
        );
    }

    // + Increase Pitch (Mangrove Button)
    private ItemStack IncreasePitchButton() {
        return createItemStack(
                Material.MANGROVE_BUTTON,
                ChatColor.GREEN + "" + ChatColor.BOLD + "[+] ɪɴᴄʀᴇᴀѕᴇ ᴘɪᴛᴄʜ"
        );
    }

    // - Decrease Pitch (Mangrove Button)
    private ItemStack DecreasePitchButton() {
        return createItemStack(
                Material.MANGROVE_BUTTON,
                ChatColor.RED + "" + ChatColor.BOLD + "[-] ᴅᴇᴄʀᴇᴀѕᴇ ᴘɪᴛᴄʜ"
        );
    }
}