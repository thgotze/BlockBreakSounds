package com.gotze.blockBreakSounds.Utility.LineHandlers;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

public class FavoritedSoundLineHandler {

    private static final String soundFavoritedLoreLine = ChatColor.GREEN + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ꜰᴀᴠᴏʀɪᴛᴇᴅ! ⭐";
    private static final String soundUnfavoritedLoreLine = ChatColor.RED + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ᴜɴꜰᴀᴠᴏʀɪᴛᴇᴅ! ✘";

    public static void handleFavoritedLineSound(Player player, Inventory clickedInventory, int slot, boolean unfavoriteable) {
        ItemStack clickedItem = clickedInventory.getItem(slot);
        if (clickedItem == null || clickedItem.getType() == Material.GLASS_PANE) {
            return;
        }

        ItemMeta meta = clickedItem.getItemMeta();
        if (meta == null) return;

        List<String> lore = meta.getLore();
        if (lore == null) return;

        boolean isFavorited = lore.contains(soundFavoritedLoreLine);
        boolean isUnfavorited = lore.contains(soundUnfavoritedLoreLine);

        if (unfavoriteable && isFavorited) { // Can be unfavorited, currently favorited
            lore.remove(soundFavoritedLoreLine);
            lore.add(soundUnfavoritedLoreLine);

        } else if (unfavoriteable && isUnfavorited) { // Can be unfavorited, currently unfavorited
            lore.remove(soundUnfavoritedLoreLine);
            lore.add(soundFavoritedLoreLine);
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5f, 1.5f);

        } else if (!unfavoriteable && isFavorited) { // Cannot be unfavorited, currently favorited
            return;

        } else { // Not favorited yet, add favorited sound line
            lore.addAll(Arrays.asList("", soundFavoritedLoreLine));
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5f, 1.5f);
        }

        meta.setLore(lore);
        clickedItem.setItemMeta(meta);
        clickedInventory.setItem(slot, clickedItem);
    }
}