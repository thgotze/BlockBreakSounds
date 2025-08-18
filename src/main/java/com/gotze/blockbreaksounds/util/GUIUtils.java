package com.gotze.blockbreaksounds.util;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public class GUIUtils {

    public static final ItemStack FRAME = createItemStack(
            Material.BLACK_STAINED_GLASS_PANE,
            null,
            null,
            false,
            false,
            true
    );

    public static final ItemStack RETURN_BUTTON = createItemStack(
            Material.ARROW,
            ChatColor.YELLOW + "" + ChatColor.BOLD + convertToSmallFont("← return")
    );

    public static final ItemStack FAVORITE_SOUNDS_BUTTON = createItemStack(
            Material.NETHER_STAR,
            ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
            Arrays.asList(ChatColor.WHITE + convertToSmallFont("pick from your ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorited ") + ChatColor.WHITE + convertToSmallFont("sounds"),
                    "",
                    ChatColor.WHITE + convertToSmallFont("shift right click sounds to ") + ChatColor.GREEN + ChatColor.BOLD + convertToSmallFont("favorite")
            )
    );

    public static void handlePickedLineSound(Inventory clickedInventory, int pickedSoundIndex) {
        final String CLICK_TO_PICK = ChatColor.YELLOW + convertToSmallFont("click to pick sound");
        final String SOUND_PICKED = ChatColor.YELLOW + "" + ChatColor.BOLD + convertToSmallFont("sound picked! ♪");

        // Replace sound picked line with click to pick sound line for all sounds in gui
        for (int i = 9; i < 36; i++) {
            if (i == pickedSoundIndex) continue;

            ItemStack item = clickedInventory.getItem(i);
            if (item == null) break;
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta == null) break;
            List<String> lore = itemMeta.getLore();
            if (lore == null) break;

            if (lore.contains(SOUND_PICKED)) {
                lore.set(lore.indexOf(SOUND_PICKED), CLICK_TO_PICK);
            }
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
            clickedInventory.setItem(i, item);
        }

        // Replace pick sound line with sound picked line for clicked sound in gui
        ItemStack item = clickedInventory.getItem(pickedSoundIndex);
        if (item == null) return;

        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();
        if (lore == null) return;

        if (lore.contains(CLICK_TO_PICK)) {
            lore.set(lore.indexOf(CLICK_TO_PICK), SOUND_PICKED);
        }
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        clickedInventory.setItem(pickedSoundIndex, item);
    }
}