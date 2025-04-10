package com.gotze.blockBreakSounds.utility;

import org.bukkit.ChatColor;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.List;

public final class PickedSoundLoreHandler {

    private static final String clickToPickLine = ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ";
    private static final String soundPickedLine = ChatColor.YELLOW + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ᴘɪᴄᴋᴇᴅ! ♪";

    public static void handlePickedLineSound(Inventory clickedInventory, int slot) {

        for (int i = 9; i <= 35; i++) {

            ItemStack item = clickedInventory.getItem(i);
            if (item == null) {
                return;
            }
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta == null) {
                return;
            }
            List<String> lore = itemMeta.getLore();
            if (lore == null) {
                return;
            }

            // For the slot picked replaces the "Click to pick sound" line and replaces it with the "Sound picked!" line
            if (i == slot) {
                int indexClickedItem = lore.indexOf(clickToPickLine);
                if (indexClickedItem != -1) {
                    lore.set(indexClickedItem, soundPickedLine);
                    itemMeta.setLore(lore);
                    item.setItemMeta(itemMeta);
                    clickedInventory.setItem(i, item);
                }
            } else {
                int pickedIndex = lore.indexOf(soundPickedLine);
                if (pickedIndex != -1) {
                    lore.set(pickedIndex, clickToPickLine);
                    itemMeta.setLore(lore);
                    item.setItemMeta(itemMeta);
                    clickedInventory.setItem(i, item);
                }
            }
        }
    }
}