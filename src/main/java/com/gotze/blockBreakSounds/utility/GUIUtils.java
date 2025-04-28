package com.gotze.blockBreakSounds.utility;

import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.inventory.ClickType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;
import java.util.List;

import static com.gotze.blockBreakSounds.utility.ItemStackCreator.createItemStack;
import static com.gotze.blockBreakSounds.utility.TextUtils.convertToSmallFont;

public final class GUIUtils {

    public static final String CLICK_TO_PICK = ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ";
    public static final String SOUND_PICKED = ChatColor.YELLOW + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ᴘɪᴄᴋᴇᴅ! ♪";

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
                            ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(TextUtils.getFormattedSoundName(playerCurrentSound.getSound())),
                            ChatColor.WHITE + convertToSmallFont("Volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", playerCurrentSound.getVolume() * 100)),
                            ChatColor.WHITE + convertToSmallFont("Pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", playerCurrentSound.getPitch())),
                            "",
                            ChatColor.WHITE + "ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.YELLOW + "" + ChatColor.BOLD + "ᴘʟᴀʏᴛᴇѕᴛ",
                            ChatColor.WHITE + "ᴅʀᴏᴘ ɪᴛᴇᴍ ᴛᴏ " + ChatColor.RED + "" + ChatColor.BOLD + "ᴄʟᴇᴀʀ",
                            ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.GREEN + "" + ChatColor.BOLD + "ꜰᴀᴠᴏʀɪᴛᴇ"
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
        }

        if (clickType == ClickType.SHIFT_RIGHT) {
            FavoriteSoundData.addSoundToFavorites(player, currentSoundData);
            GUIUtils.handleFavoritedLineSound(clickedInventory, slot);
            return;
        }

        if (clickedInventory.getItem(slot).getType() != Material.BARRIER) {
            player.playSound(player, currentSoundData.getSound(), currentSoundData.getVolume(), currentSoundData.getPitch());
        }
    }

    // TODO: add checker if 27 sounds are already favorite add line that says "max favorites reached"
    public static void handleFavoritedLineSound(Inventory clickedInventory, int slot) {
        final String soundFavoritedLoreLine = ChatColor.GREEN + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ꜰᴀᴠᴏʀɪᴛᴇᴅ! ⭐";

        ItemStack item = clickedInventory.getItem(slot);
        if (item == null || item.getType() == Material.GLASS_PANE) return;

        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();
        if (lore == null) return;

        if (!lore.contains(soundFavoritedLoreLine)) { // Not favorited yet, add favorited sound line
            lore.add(soundFavoritedLoreLine);
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
            clickedInventory.setItem(slot, item);
        }
    }

    public static void handlePickedLineSound(Inventory clickedInventory, int pickedSoundIndex) {
        // Replace sound picked line with click to pick sound line for all sounds in gui
        for (int i = 9; i < 36; i++) {
            ItemStack item = clickedInventory.getItem(i);
            if (item == null) break;
            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta == null) break;
            List<String> lore = itemMeta.getLore();
            if (lore == null) break;
            if (lore.contains(SOUND_PICKED)) {
                lore.set(lore.indexOf(SOUND_PICKED), CLICK_TO_PICK);
                itemMeta.setLore(lore);
                item.setItemMeta(itemMeta);
                clickedInventory.setItem(i, item);
            }
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
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
            clickedInventory.setItem(pickedSoundIndex, item);
        }
    }
}