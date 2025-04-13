package com.gotze.blockBreakSounds.utility;

import com.gotze.blockBreakSounds.soundlogic.CurrentSoundData;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundData;
import com.gotze.blockBreakSounds.soundlogic.SoundData;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Sound;
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
        return ItemStackCreator.createItemStack(
                Material.ARROW,
                ChatColor.YELLOW + "" + ChatColor.BOLD + "← ʀᴇᴛᴜʀɴ"
        );
    }

    public static ItemStack CurrentSoundDisplayButton(Player player) {
        SoundData playerCurrentSound = CurrentSoundData.currentSound.get(player.getUniqueId());
        if (playerCurrentSound == null) {
            return ItemStackCreator.createItemStack(
                    Material.GLASS_PANE,
                    ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    List.of(
                            ChatColor.WHITE + "ɴᴏ ѕᴏᴜɴᴅ ѕᴇᴛ"
                    )
            );
        } else {
            return ItemStackCreator.createItemStack(
                    (playerCurrentSound.getMaterial()),
                    ChatColor.GOLD + "" + ChatColor.BOLD + "Current Sound \uD83C\uDFA7",
                    Arrays.asList(
                            ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(TextUtils.getFormattedSoundName(playerCurrentSound.getSound())),
                            ChatColor.WHITE + convertToSmallFont("Volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", playerCurrentSound.getVolume() * 100)),
                            ChatColor.WHITE + convertToSmallFont("Pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", playerCurrentSound.getPitch())),
                            "",
                            ChatColor.WHITE + "ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.YELLOW + "ᴘʟᴀʏᴛᴇѕᴛ",
                            ChatColor.WHITE + "ᴅʀᴏᴘ ɪᴛᴇᴍ ᴛᴏ " + ChatColor.RED + "ᴄʟᴇᴀʀ",
                            ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ᴛᴏ " + ChatColor.GREEN + "ꜰᴀᴠᴏʀɪᴛᴇ"
                    ),
                    true,
                    true,
                    false
            );
        }
    }

    public static void currentSoundButtonHandler(Inventory clickedInventory, ClickType clickType, Player player, int slot) {
        SoundData playerCurrentSound = CurrentSoundData.currentSound.get(player.getUniqueId());

        if (clickType == ClickType.DROP) {
            CurrentSoundData.clearCurrentSound(clickedInventory, player, slot);

        } else if (clickType == ClickType.SHIFT_RIGHT) {
            FavoriteSoundData.addSoundToFavorites(player, playerCurrentSound);
            GUIUtils.handleFavoritedLineSound(player, clickedInventory, slot);

        } else if (playerCurrentSound != null && clickedInventory.getItem(slot).getType() != Material.BARRIER) {
            player.playSound(player, playerCurrentSound.getSound(), playerCurrentSound.getVolume(), playerCurrentSound.getPitch());
        }
    }

    public static void handleFavoritedLineSound(Player player, Inventory clickedInventory, int slot) {
        final String soundUnfavoritedLoreLine = ChatColor.RED + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ᴜɴꜰᴀᴠᴏʀɪᴛᴇᴅ! ✘";
        final String soundFavoritedLoreLine = ChatColor.GREEN + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ꜰᴀᴠᴏʀɪᴛᴇᴅ! ⭐";

        ItemStack item = clickedInventory.getItem(slot);
        if (item == null || item.getType() == Material.GLASS_PANE) return;

        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();
        if (lore == null) return;

        if (lore.contains(soundFavoritedLoreLine)) { // Currently favorited
            lore.remove(soundFavoritedLoreLine);
            lore.add(soundUnfavoritedLoreLine);

        } else if (lore.contains(soundUnfavoritedLoreLine)) { // Currently unfavorited
            lore.remove(soundUnfavoritedLoreLine);
            lore.add(soundFavoritedLoreLine);
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5f, 1.5f);

        } else { // Not favorited yet, add favorited sound line
            lore.addAll(Arrays.asList("", soundFavoritedLoreLine));
            player.playSound(player, Sound.BLOCK_NOTE_BLOCK_CHIME, 0.5f, 1.5f);
        }

        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        clickedInventory.setItem(slot, item);
    }

    public static void handlePickedLineSound(Inventory clickedInventory, int pickedSoundIndex) {
        final String clickToPickLine = ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ";
        final String soundPickedLine = ChatColor.YELLOW + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ᴘɪᴄᴋᴇᴅ! ♪";

        for (int i = 9; i < 36; i++) {
            ItemStack item = clickedInventory.getItem(i);
            if (item == null) return;

            ItemMeta itemMeta = item.getItemMeta();
            if (itemMeta == null) return;

            List<String> lore = itemMeta.getLore();
            if (lore == null) return;

            lore.remove(soundPickedLine);
            lore.add(clickToPickLine);
            itemMeta.setLore(lore);
            item.setItemMeta(itemMeta);
            clickedInventory.setItem(i, item);
        }

        ItemStack item = clickedInventory.getItem(pickedSoundIndex);
        if (item == null) return;

        ItemMeta itemMeta = item.getItemMeta();
        if (itemMeta == null) return;

        List<String> lore = itemMeta.getLore();
        if (lore == null) return;

        lore.remove(clickToPickLine);
        lore.add(soundPickedLine);
        itemMeta.setLore(lore);
        item.setItemMeta(itemMeta);
        clickedInventory.setItem(pickedSoundIndex, item);
    }
}