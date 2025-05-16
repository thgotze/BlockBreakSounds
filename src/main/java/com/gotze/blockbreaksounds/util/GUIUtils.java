package com.gotze.blockbreaksounds.util;

import com.gotze.blockbreaksounds.model.CurrentSoundData;
import com.gotze.blockbreaksounds.model.FavoriteSoundData;
import com.gotze.blockbreaksounds.model.SoundData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockbreaksounds.util.ItemStackCreator.createItemStack;
import static com.gotze.blockbreaksounds.util.StringUtils.convertToSmallFont;

public final class GUIUtils {

    public static ItemStack Frame() {
        return createItemStack(
                Material.BLACK_STAINED_GLASS_PANE,
                null,
                null,
                false,
                false,
                true
        );
    }

    public static ItemStack ReturnButton() {
        return createItemStack(
                Material.ARROW,
                ChatColor.YELLOW + "" + ChatColor.BOLD + convertToSmallFont("← return")
        );
    }

    public static ItemStack CurrentSoundDisplayButton(Player player) {
        SoundData playerCurrentSound = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (playerCurrentSound == null) {
            return createItemStack(
                    Material.GLASS_PANE,
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    List.of(
                            ChatColor.WHITE + convertToSmallFont("no sound set")
                    )
            );
        } else {
            return createItemStack(
                    (playerCurrentSound.getDisplayMaterial()),
                    ChatColor.YELLOW + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    Arrays.asList(
                            ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(playerCurrentSound.getFormattedSoundName()),
                            ChatColor.WHITE + convertToSmallFont("Volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", playerCurrentSound.getVolume() * 100)),
                            ChatColor.WHITE + convertToSmallFont("Pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", playerCurrentSound.getPitch())),
                            "",
                            ChatColor.WHITE + "ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.YELLOW + ChatColor.BOLD + "ᴘʟᴀʏᴛᴇѕᴛ",
                            ChatColor.WHITE + "ᴅʀᴏᴘ ɪᴛᴇᴍ ᴛᴏ " + ChatColor.RED + ChatColor.BOLD + "ᴄʟᴇᴀʀ",
                            ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.GREEN + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇ"
                    ),
                    true,
                    true,
                    false
            );
        }
    }

    public static void currentSoundButtonHandler(Inventory clickedInventory, ClickType clickType, Player player, int slot) {
        SoundData currentSoundData = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (currentSoundData == null) return;

        if (clickType == ClickType.DROP) {
            CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);
            return;
        } else if (clickType == ClickType.SHIFT_RIGHT) {
            FavoriteSoundData.addSoundToFavorites(player, currentSoundData);
            GUIUtils.handleFavoritedLineSound(clickedInventory, slot, player);
            return;
        }
        ItemStack clickedItem = clickedInventory.getItem(slot);
        if (clickedItem == null) return;

        if (clickedItem.getType() != Material.BARRIER) {
            player.playSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
        }
    }

    public static void handleFavoritedLineSound(Inventory clickedInventory, int slot, Player player) {
        final String SOUND_FAVORITED = ChatColor.GREEN + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ꜰᴀᴠᴏʀɪᴛᴇᴅ! ⭐";
        final String MAX_FAVORITED = ChatColor.RED + "" + ChatColor.BOLD + "ᴍᴀх ꜰᴀᴠᴏʀɪᴛᴇѕ ʀᴇᴀᴄʜᴇᴅ!";

        ItemStack clickedItem = clickedInventory.getItem(slot);
        if (clickedItem == null || clickedItem.getType() == Material.GLASS_PANE) return;

        ItemMeta itemMeta = clickedItem.getItemMeta();
        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();
        if (lore == null) return;

        if (lore.contains(MAX_FAVORITED)) {
            return;
        } else if (FavoriteSoundData.favoriteSounds.get(player.getUniqueId()).size() >= 27) {
            lore.add(MAX_FAVORITED);
        } else if (!lore.contains(SOUND_FAVORITED)) {
            lore.add(SOUND_FAVORITED);
        } else {
            return;
        }

        itemMeta.setLore(lore);
        clickedItem.setItemMeta(itemMeta);
        clickedInventory.setItem(slot, clickedItem);
    }

    public static void handlePickedLineSound(Inventory clickedInventory, int pickedSoundIndex) {
        final String CLICK_TO_PICK = ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ";
        final String SOUND_PICKED = ChatColor.YELLOW + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ᴘɪᴄᴋᴇᴅ! ♪";


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
