package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.utils.GUIUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.utils.ButtonCreator.createButton;
import static com.gotze.blockBreakSounds.utils.GUIUtils.Frame;

public class BlockBreakSoundsGUI {

    private final Inventory gui;

    public BlockBreakSoundsGUI(Player player) {
        this.gui = Bukkit.createInventory(null, 45, "Block Break Sounds");
        setupGUI(player);
    }

    public void openBlockBreakSoundsGUI(Player player) {
        setFramesAndAir();
        player.openInventory(gui);
    }

    private void setupGUI(Player player) {
        setFramesAndAir();
        gui.setItem(26, SettingsButton());
        gui.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(11, IncreaseVolumeButton());
        gui.setItem(15, IncreasePitchButton());
        gui.setItem(20, VolumeButton());
        gui.setItem(22, PickSoundButton());
        gui.setItem(24, PitchButton());
        gui.setItem(29, DecreaseVolumeButton());
        gui.setItem(31, FavoriteSoundsButton());
        gui.setItem(33, DecreasePitchButton());
    }

    private void setFramesAndAir() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, Frame());
        }
        gui.setItem(9, new ItemStack(Material.AIR));
        gui.setItem(17, new ItemStack(Material.AIR));
        gui.setItem(27, new ItemStack(Material.AIR));
        gui.setItem(35, new ItemStack(Material.AIR));
    }

    // Settings Button (Command Block)
    public static ItemStack SettingsButton() {
        return createButton(
                Material.COMMAND_BLOCK,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Settings \uD83D\uDD27",
                Arrays.asList(
                        ChatColor.WHITE + "ᴍᴏᴅɪꜰʏ ᴀᴅᴅɪᴛɪᴏɴᴀʟ ѕᴇᴛᴛɪɴɢѕ"),
                true,
                false,
                true
        );
    }

    // Favorite Sounds Button (Nether Star)
    public static ItemStack FavoriteSoundsButton() {
        return createButton(
                Material.NETHER_STAR,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.YELLOW + "" + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ")
        );
    }

    // Pick Sound Button (Noteblock)
    public static ItemStack PickSoundButton() {
        return createButton(
                Material.NOTE_BLOCK,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Pick Sound ♪",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ᴀ ѕᴏᴜɴᴅ ᴛᴏ ᴘʟᴀʏ",
                        ChatColor.WHITE + "ᴡʜᴇɴ ʏᴏᴜ ʙʀᴇᴀᴋ ʙʟᴏᴄᴋѕ")
        );
    }

    // Volume Button (Goat Horn)
    public static ItemStack VolumeButton() {
        return createButton(
                Material.GOAT_HORN,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Tweak Volume \uD83D\uDD0A",
                Arrays.asList(
                        ChatColor.WHITE + "ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.GREEN + ChatColor.BOLD + "ɪɴᴄʀᴇᴀѕᴇ " + ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ",
                        ChatColor.WHITE + "ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.RED + ChatColor.BOLD + "ᴅᴇᴄʀᴇᴀѕᴇ " + ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ",
                        ChatColor.WHITE + "",
                        ChatColor.GRAY + "ᴠᴏʟᴜᴍᴇ ᴄᴀɴ ʙᴇ ѕᴇᴛ ʙᴇᴛᴡᴇᴇɴ ₀ ᴀɴᴅ ₁₀₀"),
                true
        );
    }

    // + Increase Volume (Mangrove Button)
    public static ItemStack IncreaseVolumeButton() {
        return createButton(
                Material.MANGROVE_BUTTON,
                        ChatColor.GREEN + "" + ChatColor.BOLD + "[+] ɪɴᴄʀᴇᴀѕᴇ ᴠᴏʟᴜᴍᴇ"
        );
    }

    // - Decrease Volume (Mangrove Button)
    public static ItemStack DecreaseVolumeButton() {
        return createButton(
                Material.MANGROVE_BUTTON,
                ChatColor.RED + "" + ChatColor.BOLD + "[-] ᴅᴇᴄʀᴇᴀꜱᴇ ᴠᴏʟᴜᴍᴇ"
        );
    }

    // Pitch Button (Bell)
    public static ItemStack PitchButton() {
        return createButton(
                Material.BELL,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Tweak Pitch \uD83D\uDD14",
                Arrays.asList(
                        ChatColor.WHITE + "ʟᴇꜰᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.GREEN + ChatColor.BOLD + "ɪɴᴄʀᴇᴀѕᴇ " + ChatColor.WHITE + "ᴘɪᴛᴄʜ",
                        ChatColor.WHITE + "ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.RED + ChatColor.BOLD + "ᴅᴇᴄʀᴇᴀѕᴇ " + ChatColor.WHITE + "ᴘɪᴛᴄʜ",
                        ChatColor.WHITE + "",
                        ChatColor.GRAY + "ᴘɪᴛᴄʜ ᴄᴀɴ ʙᴇ ѕᴇᴛ ʙᴇᴛᴡᴇᴇɴ ₀.₅₀ ᴀɴᴅ ₂.₀₀")
        );
    }

    // + Increase Pitch (Mangrove Button)
    public static ItemStack IncreasePitchButton() {
        return createButton(
                Material.MANGROVE_BUTTON,
                ChatColor.GREEN + "" + ChatColor.BOLD + "[+] ɪɴᴄʀᴇᴀѕᴇ ᴘɪᴛᴄʜ"
        );
    }

    // - Decrease Pitch (Mangrove Button)
    public static ItemStack DecreasePitchButton() {
        return createButton(
                Material.MANGROVE_BUTTON,
                ChatColor.RED + "" + ChatColor.BOLD + "[-] ᴅᴇᴄʀᴇᴀѕᴇ ᴘɪᴛᴄʜ"
        );
    }
}