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

public class AllSoundsGUI {

    private final Inventory gui;
    private final String guiTitle;

    public AllSoundsGUI(String guiTitle) {
        this.gui = Bukkit.createInventory(null, 45, guiTitle);
        this.guiTitle = guiTitle;
        setFrames();
        gui.setItem(36, GUIUtils.ReturnButton());
        gui.setItem(40, FavoriteSoundsButton());
    }

    public void setupAndOpenGUI(Player player) {
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        setCategoryOrSoundButtons();
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

    private void setCategoryOrSoundButtons() {
        switch (guiTitle) {
            case "All Sounds":
                gui.setItem(20, EntitySoundsButton());
                gui.setItem(21, BlockSoundsButton());
                gui.setItem(22, ItemSoundsButton());
                gui.setItem(23, NoteblockSoundsButton());
                gui.setItem(24, OtherSoundsButton());
                return;

            case "Entity Sounds":
                gui.setItem(22, PlaceHolderPaperItem());
                return;

            case "Block Sounds":
                gui.setItem(22, PlaceHolderPaperItem());
                return;

            case "Item Sounds":
                gui.setItem(22, PlaceHolderPaperItem());
                return;

            case "Noteblock Sounds":
                gui.setItem(22, PlaceHolderPaperItem());
                return;

            case "Other Sounds":
                gui.setItem(22, PlaceHolderPaperItem());
                return;
        }
    }

    private ItemStack PlaceHolderPaperItem() {
        return createItemStack(
                Material.PAPER,
                "Placeholder Item for Categories"
        );
    }

    // Entity Sounds Button (Ender Pearl)
    private ItemStack EntitySoundsButton() {
        return createItemStack(
                Material.ENDER_PEARL,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Entity Sounds"
        );
    }

    // Block Sounds Button (Grass Block)
    private ItemStack BlockSoundsButton() {
        return createItemStack(
                Material.GRASS_BLOCK,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Block Sounds"
        );
    }

    // Item Sounds Button (Diamond Pickaxe)
    private ItemStack ItemSoundsButton() {
        return createItemStack(
                Material.DIAMOND_PICKAXE,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Item Sounds",
                null,
                true,
                true
        );
    }

    // Noteblock Sounds Button (Note Block)
    private ItemStack NoteblockSoundsButton() {
        return createItemStack(
                Material.NOTE_BLOCK,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Noteblock Sounds"
        );
    }

    // Other Sounds Button (Jukebox)
    private ItemStack OtherSoundsButton() {
        return createItemStack(
                Material.JUKEBOX,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Other Sounds"
        );
    }

    // Favorite Sounds Button (Nether Star)
    private ItemStack FavoriteSoundsButton() {
        return createItemStack(
                Material.NETHER_STAR,
                ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.GREEN + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ",
                        "",
                        ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ " + ChatColor.GREEN + "ꜰᴀᴠᴏʀɪᴛᴇ")
        );
    }
}