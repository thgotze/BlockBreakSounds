package com.gotze.blockBreakSounds.Utility.LineHandlers;

import org.bukkit.ChatColor;
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

    public static void handleFavoritedLineSound(Player player, Inventory clickedInventory, int slot) {

        boolean hasFavoriteState = false;

        ItemStack clickedItem = clickedInventory.getItem(slot);
        ItemMeta meta = clickedItem.getItemMeta();
        List<String> lore = meta.getLore();

        for (int i = 0; i < lore.size(); i++) {
            if (lore.get(i).equals(soundFavoritedLoreLine)) {
                lore.set(i, soundUnfavoritedLoreLine);
                hasFavoriteState = true;
                break;
            }
            else if (lore.get(i).equals(soundUnfavoritedLoreLine)) {
                lore.set(i, soundFavoritedLoreLine);
                hasFavoriteState = true;
                player.playSound(player, Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5f, 1.5f);
                break;
            }
        }

        if (!hasFavoriteState) {
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5f, 1.5f);
            lore.addAll(Arrays.asList(
                    "",
                    soundFavoritedLoreLine));
        }

        meta.setLore(lore);
        clickedItem.setItemMeta(meta);
        clickedInventory.setItem(slot, clickedItem);
    }
}
