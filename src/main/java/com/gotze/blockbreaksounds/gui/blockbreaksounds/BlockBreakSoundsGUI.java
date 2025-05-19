package com.gotze.blockbreaksounds.gui.blockbreaksounds;

import com.gotze.blockbreaksounds.util.GUIUtils;
import com.gotze.blockbreaksounds.util.StringUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class BlockBreakSoundsGUI {

    private final Inventory gui;

    public BlockBreakSoundsGUI(Player player) {
        this.gui = Bukkit.createInventory(null, 45, "Block Break Sounds");
        setFrames();
        gui.setItem(11, IncreaseVolumeButton);
        gui.setItem(13, GUIUtils.CurrentSoundDisplayButton(player));
        gui.setItem(15, IncreasePitchButton);
        gui.setItem(20, VolumeButton);
        gui.setItem(22, PickSoundButton);
        gui.setItem(24, PitchButton);
        // gui.setItem(26, SettingsButton); TODO: Settings GUI is currently not implemented
        gui.setItem(29, DecreaseVolumeButton);
        gui.setItem(31, FavoriteSoundsButton);
        gui.setItem(33, DecreasePitchButton);
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

    // Settings Button (Command Block) TODO: Settings GUI is currently not implemented
    private final ItemStack SettingsButton = createItemStack(
            Material.COMMAND_BLOCK,
            ChatColor.RED + "" + ChatColor.BOLD + "Settings \uD83D\uDD27",
            List.of(
                    ChatColor.WHITE + "ᴍᴏᴅɪꜰʏ ᴀᴅᴅɪᴛɪᴏɴᴀʟ ѕᴇᴛᴛɪɴɢѕ"),
            true,
            true,
            false
    );

    // Favorite Sounds Button (Nether Star)
    private final ItemStack FavoriteSoundsButton = createItemStack(
            Material.NETHER_STAR,
            ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
            List.of(ChatColor.WHITE + convertToSmallFont("pick from your ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorited ") + ChatColor.WHITE + convertToSmallFont("sounds"))
    );

    // Pick Sound Button (Note Block)
    private final ItemStack PickSoundButton = createItemStack(
            Material.NOTE_BLOCK,
            ChatColor.AQUA + "" + ChatColor.BOLD + "Pick Sound ♪",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("pick a sound to play"),
                    ChatColor.WHITE + convertToSmallFont("when you break blocks")
            )
    );

    // Volume Button (Goat Horn)
    private final ItemStack VolumeButton = createItemStack(
            Material.GOAT_HORN,
            ChatColor.YELLOW + "" + ChatColor.BOLD + "Tweak Volume \uD83D\uDD0A",
            Arrays.asList(
                    ChatColor.WHITE + convertToSmallFont("left click to ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("increase ") + ChatColor.WHITE + convertToSmallFont("volume"),
                    ChatColor.WHITE + convertToSmallFont("right click to ") + ChatColor.RED + ChatColor.BOLD + convertToSmallFont("decrease ") + ChatColor.WHITE + convertToSmallFont("volume"),
                    ChatColor.WHITE + "",
                    ChatColor.GRAY + convertToSmallFont("volume can be set between 0 and 100")),
            true
    );

    // + Increase Volume (Mangrove Button)
    private final ItemStack IncreaseVolumeButton = createItemStack(
            Material.MANGROVE_BUTTON,
            ChatColor.GREEN + "" + ChatColor.BOLD + "[+] " + ChatColor.BOLD + convertToSmallFont("increase volume")
    );

    // - Decrease Volume (Mangrove Button)
    private final ItemStack DecreaseVolumeButton = createItemStack(
            Material.MANGROVE_BUTTON,
            ChatColor.RED + "" + ChatColor.BOLD + "[-] " + ChatColor.BOLD + convertToSmallFont("decrease volume")
    );

    // Pitch Button (Bell)
    private final ItemStack PitchButton = createItemStack(
            Material.BELL,
            ChatColor.YELLOW + "" + ChatColor.BOLD + "Tweak Pitch \uD83D\uDD14",
            Arrays.asList(
                    ChatColor.WHITE + convertToSmallFont("left click to ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("increase ") + ChatColor.WHITE + convertToSmallFont("pitch"),
                    ChatColor.WHITE + convertToSmallFont("right click to ") + ChatColor.RED + ChatColor.BOLD + convertToSmallFont("decrease ") + ChatColor.WHITE + convertToSmallFont("pitch"),
                    ChatColor.WHITE + "",
                    ChatColor.GRAY + convertToSmallFont("pitch can be set between 0.50 and 2.00"))
    );

    // + Increase Pitch (Mangrove Button)
    private final ItemStack IncreasePitchButton = createItemStack(
            Material.MANGROVE_BUTTON,
            ChatColor.GREEN + "" + ChatColor.BOLD + "[+] " + ChatColor.BOLD + convertToSmallFont("increase pitch")
    );

    // - Decrease Pitch (Mangrove Button)
    private final ItemStack DecreasePitchButton = createItemStack(
            Material.MANGROVE_BUTTON,
            ChatColor.RED + "" + ChatColor.BOLD + "[-] " + ChatColor.BOLD + convertToSmallFont("decrease pitch")
    );
}