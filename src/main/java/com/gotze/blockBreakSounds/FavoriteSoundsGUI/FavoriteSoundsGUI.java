package com.gotze.blockBreakSounds.FavoriteSoundsGUI;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

import static com.gotze.blockBreakSounds.Utility.ButtonCreator.createButton;
import static com.gotze.blockBreakSounds.Utility.CurrentSoundDisplayButton.CurrentSoundDisplayButton;
import static com.gotze.blockBreakSounds.Utility.GUIUtils.Frame;

public class FavoriteSoundsGUI {

    private final Inventory gui;

    public FavoriteSoundsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "Favorite Sounds");
        setupGUI();
    }

    public void openFavoriteSoundsGUI(Player player) {
        player.openInventory(gui);
        gui.setItem(4, CurrentSoundDisplayButton(player));
        gui.setItem(36, ReturnButton());
        gui.setItem(40, FavoriteSoundsInfoButton());
    }

    private void setupGUI() {
        setFrames();
        gui.setItem(22, PlaceHolderButton());
    }

    private void setFrames() {
        for (int i = 0; i < 9; i++) {
            gui.setItem(i, Frame());
        }
        for (int i = 36; i < 45; i++) {
            gui.setItem(i, Frame());
        }
    }

    public static ItemStack FavoriteSoundsInfoButton() {
        return createButton(
                Material.NETHER_STAR,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.YELLOW + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ",
                        "",
                        ChatColor.GRAY + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ ꜰᴀᴠᴏʀɪᴛᴇ"
                )
        );
    }

    public static ItemStack ReturnButton() {
        return createButton(
                Material.ARROW,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "← ʀᴇᴛᴜʀɴ"
        );
    }

    public static ItemStack PlaceHolderButton() {
        return createButton(
                Material.PAPER,
                ChatColor.WHITE + "You have not favorited any sounds yet!");
    }

}
