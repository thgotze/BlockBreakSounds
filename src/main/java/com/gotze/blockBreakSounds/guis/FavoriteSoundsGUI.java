package com.gotze.blockBreakSounds.guis;

import com.gotze.blockBreakSounds.soundlogic.SoundData;
import com.gotze.blockBreakSounds.utility.GUIUtils;
import com.gotze.blockBreakSounds.utility.ItemStackCreator;
import com.gotze.blockBreakSounds.soundlogic.FavoriteSoundData;
import com.gotze.blockBreakSounds.utility.TextUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.gotze.blockBreakSounds.utility.TextUtils.convertToSmallFont;

public class FavoriteSoundsGUI {

    private final Inventory gui;

    public FavoriteSoundsGUI() {
        this.gui = Bukkit.createInventory(null, 45, "Favorite Sounds");
        setFrames();
        gui.setItem(36, GUIUtils.ReturnButton());
        gui.setItem(40, FavoriteSoundsInfoButton());
    }

    public void setupAndOpenGUI(Player player) {
        gui.setItem(4, GUIUtils.CurrentSoundDisplayButton(player));
        setFavoriteSoundsToGUI(player);
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

    private ItemStack FavoriteSoundsInfoButton() {
        return ItemStackCreator.createItemStack(
                Material.NETHER_STAR,
                ChatColor.GOLD + "" + ChatColor.BOLD + "Favorite Sounds ⭐",
                Arrays.asList(
                        ChatColor.WHITE + "ᴅʀᴏᴘ ѕᴏᴜɴᴅѕ ᴛᴏ " + ChatColor.RED + "ᴜɴꜰᴀᴠᴏʀɪᴛᴇ",
                        ChatColor.WHITE + "ѕʜɪꜰᴛ ʀɪɢʜᴛ ᴄʟɪᴄᴋ ѕᴏᴜɴᴅs ᴛᴏ " + ChatColor.GREEN + "ꜰᴀᴠᴏʀɪᴛᴇ"
                )
        );
    }

    private void setFavoriteSoundsToGUI(Player player) {
        List<SoundData> playerFavorites = FavoriteSoundData.favoriteSounds.computeIfAbsent(player.getUniqueId(), k -> new ArrayList<>());
        int slot = 9;
        for (int i = 0; i < playerFavorites.size(); i++) {
            SoundData favoriteSoundData = playerFavorites.get(i);
            gui.setItem(slot, createFavoriteSoundButton(favoriteSoundData, i + 1));
            slot++;
        }
        for (int i = playerFavorites.size() + 9; i < 36; i ++) {
            gui.clear(i);
        }
        if (gui.getItem(9) == null) {
            gui.setItem(22, NoSoundsFavoritedYetButton());
        }
    }

    private ItemStack createFavoriteSoundButton(SoundData soundData, int index) {
        return ItemStackCreator.createItemStack(
                soundData.getMaterial(),
                ChatColor.GREEN + "" + ChatColor.BOLD + "Favorite Sound " + index + " ⭐",
                Arrays.asList(
                        ChatColor.WHITE + convertToSmallFont("Sound: ") + ChatColor.GRAY + convertToSmallFont(TextUtils.getFormattedSoundName(soundData.getSound())),
                        ChatColor.WHITE + convertToSmallFont("Volume: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.0f%%", soundData.getVolume() * 100)),
                        ChatColor.WHITE + convertToSmallFont("Pitch: ") + ChatColor.GRAY + convertToSmallFont(String.format("%.2f", soundData.getPitch())),
                        "",
                        ChatColor.YELLOW + "ᴄʟɪᴄᴋ ᴛᴏ ᴘɪᴄᴋ ѕᴏᴜɴᴅ",
                        "",
                        ChatColor.GREEN + "" + ChatColor.BOLD + "ѕᴏᴜɴᴅ ꜰᴀᴠᴏʀɪᴛᴇᴅ! ⭐"),
                true,
                true,
                false
        );
    }

    private ItemStack NoSoundsFavoritedYetButton() {
        return ItemStackCreator.createItemStack(
                Material.PAPER,
                ChatColor.WHITE + "ʏᴏᴜ ʜᴀᴠᴇ ɴᴏᴛ ꜰᴀᴠᴏʀɪᴛᴇᴅ ᴀɴʏ ѕᴏᴜɴᴅѕ ʏᴇᴛ!");
    }
}