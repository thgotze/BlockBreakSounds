package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.ItemStackCreator;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.Arrays;

public class AllSoundsGUI {

    private final Inventory gui;

    public AllSoundsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "All Sounds");
        setFrames();
        gui.setItem(36, GUIUtils.ReturnButton());
        gui.setItem(40, FavoriteSoundsButton());
        gui.setItem(20, createCategoryItem(Material.ENDER_PEARL, "Entity Sounds"));
        gui.setItem(21, createCategoryItem(Material.STONE, "Block Sounds"));
        gui.setItem(22, createCategoryItem(Material.DIAMOND_PICKAXE, "Item Sounds"));
        gui.setItem(23, createCategoryItem(Material.NOTE_BLOCK, "Noteblock Sounds"));
        gui.setItem(24, createCategoryItem(Material.JUKEBOX, "Other Sounds"));
    }

    public void setupAndOpenGUI(Player player) {
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
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

    // TODO: Add category item stacks

    // Entity Sounds
    private ItemStack EntitySoundsButton() {
        return ItemStackCreator.createItemStack(
                Material.ENDER_PEARL,
                ChatColor.AQUA + "" + ChatColor.BOLD + "Entity Sounds",
                );
    }

    // Block Sounds

    // Item Sounds

    // Noteblock Sounds

    // Other Sounds

    // Example formatting:
//    private ItemStack DecoratedPotBreakButton() {
//        return ItemStackCreator.createItemStack(
//                Material.DECORATED_POT,
//                ChatColor.AQUA + "" + ChatColor.BOLD + "Clonk!",
//                Arrays.asList(
//                        ChatColor.WHITE + "ѕᴏᴜɴᴅ: " + ChatColor.GRAY + "ʙʟᴏᴄᴋ ᴅᴇᴄᴏʀᴀᴛᴇᴅ ᴘᴏᴛ ʙʀᴇᴀᴋ",
//                        ChatColor.WHITE + "ᴠᴏʟᴜᴍᴇ: " + ChatColor.GRAY + "₅₀%",
//                        ChatColor.WHITE + "ᴘɪᴛᴄʜ: " + ChatColor.GRAY + "₁.₀₀",
//                        "",
//                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ")
//        );
//    }

    // Favorite Sounds Button (Nether Star)
    private ItemStack FavoriteSoundsButton() {
        return ItemStackCreator.createItemStack(
                Material.NETHER_STAR,
                ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(ChatColor.WHITE + "ᴘɪᴄᴋ ꜰʀᴏᴍ ʏᴏᴜʀ " + ChatColor.GREEN + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇᴅ " + ChatColor.WHITE + "ѕᴏᴜɴᴅѕ",
                        "",
                        ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ " + ChatColor.GREEN + "ꜰᴀᴠᴏʀɪᴛᴇ")
        );
    }
}